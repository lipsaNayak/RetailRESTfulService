package com.retail.application.entities;


import java.util.HashMap;
import java.util.Map;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class RetailProduct {

  @Id
  @NotNull(message = "Id is mandatory")
  private Integer id;

  @NotNull(message = "Name is mandatory")
  private String name;

  @NotNull(message = "Price is mandatory")
  private Map<String, String> current_price = new HashMap<>();

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Map<String, String> getCurrent_price() {
    return current_price;
  }

  public void setCurrent_price(Map<String, String> current_price) {
    this.current_price = current_price;
  }

  @Override
  public String toString() {
    return "RetailProduct{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", current_price=" + current_price +
        '}';
  }
}

