package com.retail.application.dataccess;

import com.retail.application.entities.RetailProduct;

public interface ProductDAL {

  RetailProduct getProductById(Integer productId);
}
