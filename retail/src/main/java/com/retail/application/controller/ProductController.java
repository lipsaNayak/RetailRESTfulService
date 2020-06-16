package com.retail.application.controller;

import com.retail.application.dataccess.ProductDAL;
import com.retail.application.dataccess.ProductRepository;
import com.retail.application.entities.RetailProduct;
import com.retail.application.exception.RetailException;
import com.retail.application.exception.ValidationException;
import com.retail.application.utils.ProductValidation;
import javax.ws.rs.BadRequestException;
import javax.xml.ws.http.HTTPException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

  private final static Logger log = LoggerFactory.getLogger(ProductController.class);

  private final ProductRepository productRepository;

  private final ProductDAL productDAL;

  private ProductValidation productValidation;

  @Autowired
  public ProductController(ProductRepository productRepository, ProductDAL productDAL, ProductValidation productValidation){
    this.productRepository = productRepository;
    this.productDAL = productDAL;
    this.productValidation = productValidation;
  }

  @RequestMapping(value = "/{productId}", consumes = "application/json", produces = "application/json", method = RequestMethod.POST)
  public RetailProduct save(@PathVariable(value = "productId") Integer productId,
      @RequestBody RetailProduct retailProduct) throws Exception {

    try {
      productValidation.validateProductId(productId, retailProduct);
    } catch (ValidationException e) {
      log.error("Validation exception: {}", e.getExceptionMessage());
      throw new Exception(e.getExceptionMessage());
    }

    log.info("Saving a new product : {} ", retailProduct.toString());
    return productRepository.save(retailProduct);
  }

  @RequestMapping(value = "/{productId}", produces = "application/json", method = RequestMethod.GET)
  public RetailProduct findById(@PathVariable(value = "productId") Integer productId){
    RetailProduct retailProduct = productRepository.findOne(productId);
    if(retailProduct == null) {
      log.info("No such product found in the database!");
      retailProduct = productDAL.getProductById(productId);
    } else {
      log.info("Found product in the database!");
    }
    log.info("The Product: {} with ProductId : {} ", retailProduct.toString(), productId);
    return retailProduct;
  }

}
