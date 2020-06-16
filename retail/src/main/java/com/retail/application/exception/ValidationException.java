package com.retail.application.exception;

import java.io.Serializable;

public class ValidationException extends Exception implements Serializable {

  private String exceptionMessage;

  public String getExceptionMessage() {
    return exceptionMessage;
  }

  public void setExceptionMessage(String exceptionMessage) {
    this.exceptionMessage = exceptionMessage;
  }

  public ValidationException(String msg){
    this.exceptionMessage = msg;
  }

}
