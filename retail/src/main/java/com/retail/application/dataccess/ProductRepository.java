package com.retail.application.dataccess;

import com.retail.application.entities.RetailProduct;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<RetailProduct, Integer> {

}
