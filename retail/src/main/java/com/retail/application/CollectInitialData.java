package com.retail.application;

import com.retail.application.dataccess.ProductDALImpl;
import com.retail.application.dataccess.ProductRepository;
import com.retail.application.entities.RetailProduct;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CollectInitialData {

  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

  private final ProductRepository productRepository;

  private final static Logger log = LoggerFactory.getLogger(CollectInitialData.class);

  @Autowired
  public CollectInitialData(ProductRepository productRepository){
    this.productRepository = productRepository;
  }

  //This bean is for storing a default pricing information.
  //We have a default entry with the below values
  // {
  //    "id": 0,
  //    "name": "DEFAULT",
  //    "current_price": {
  //        "value": "13.49",
  //        "currency_code": "USD"
  //    }
  // }
  @Bean
  public String storeInitialData(){

    RetailProduct retailProduct = new RetailProduct();
    retailProduct.setId(0);
    retailProduct.setName("DEFAULT");
    Map<String, String> current_price = new HashMap<>();
    current_price.put("value", "13.49");
    current_price.put("currency_code", "USD");
    retailProduct.setCurrent_price(current_price);
    productRepository.save(retailProduct);
    log.info("Default product {} added to the nosql database.", retailProduct.toString());
    return retailProduct.toString();
  }

}
