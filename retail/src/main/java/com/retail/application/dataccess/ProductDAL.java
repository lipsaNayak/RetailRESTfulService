package com.retail.application.dataccess;

import com.retail.application.entities.RetailProduct;
import com.retail.application.exception.ValidationException;

public interface ProductDAL {

  RetailProduct getProductById(Integer productId) throws ValidationException;
}
