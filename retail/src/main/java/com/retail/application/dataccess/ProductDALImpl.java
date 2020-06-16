package com.retail.application.dataccess;

import com.retail.application.entities.Item;
import com.retail.application.entities.Result;
import com.retail.application.entities.RetailProduct;
import com.retail.application.exception.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class ProductDALImpl implements ProductDAL{

  private MongoTemplate mongoTemplate;

  private  ProductRepository productRepository;

  private RestTemplate restTemplate;

  private final static Logger log = LoggerFactory.getLogger(ProductDALImpl.class);

  private static String redskyTargetURL= "https://redsky.target.com/v2/pdp/tcin/{productId}?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics";

  @Autowired
  public ProductDALImpl(MongoTemplate mongoTemplate, ProductRepository productRepository, RestTemplate restTemplate){

    this.mongoTemplate = mongoTemplate;
    this.productRepository = productRepository;
    this.restTemplate = restTemplate;
  }

  /* This method is invoked when no product with the given productId exists.
  * */
  @Override
  public RetailProduct getProductById(Integer productId) throws ValidationException {

    //Fetch the deafult product i:e, product with id 0
    RetailProduct retailProduct = productRepository.findOne(0);
    log.info("Default product fetched from the database is : {}", retailProduct.toString());
    retailProduct.setId(productId);
    //Fetch the product name from the external source.
    retailProduct = createNewProductWithDefaultPrice(retailProduct);
    //Return this new formed customized product.
    return retailProduct;

  }

  //The product details is fetched from an external API i:e redsky.target.com.
  //The details of the product is collected and a new RetailProduct is created.
  private RetailProduct createNewProductWithDefaultPrice(RetailProduct defaultRetailProduct)
      throws ValidationException {

    ResponseEntity<Result> response
        = restTemplate.getForEntity(redskyTargetURL , Result.class, defaultRetailProduct.getId());
    Result result = response.getBody();
    Item item = result.getProduct().getItem();
    if(result == null || item == null){
      throw new ValidationException("Product with productId " + defaultRetailProduct.getId() + "does not exist" );
    }
    log.info("Product fetched from the external source has id as : {} and name as : {}", item.getTcin(), item.getProductDescription().getTitle());
    defaultRetailProduct.setName(item.getProductDescription().getTitle());
    return defaultRetailProduct;

  }

}
