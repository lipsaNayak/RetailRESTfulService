package com.retail.application.utils;

import com.retail.application.entities.RetailProduct;
import com.retail.application.exception.ValidationException;
import org.springframework.stereotype.Component;

@Component
public class ProductValidation {

  public void validateProductId(Integer ProductId, RetailProduct retailProduct)
      throws ValidationException {

    if(ProductId != retailProduct.getId().intValue()){
      throw new ValidationException("ProductId in path does not match with the ProductId in the request body");
    }

  }



}
