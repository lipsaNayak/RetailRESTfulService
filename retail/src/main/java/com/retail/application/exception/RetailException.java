package com.retail.application.exception;

public class RetailException extends RuntimeException {

  private String exceptionMessage;

  public String getExceptionMessage() {
    return exceptionMessage;
  }

  public void setExceptionMessage(String exceptionMessage) {
    this.exceptionMessage = exceptionMessage;
  }

  public RetailException(String msg){
    this.exceptionMessage = msg;
  }

}
