package com.grocery.exception;


public class StockNotAvailableException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	private String errorMessage;
	private String errorCode;
	
	
	
	public StockNotAvailableException(String errorCode, String errorMessage) {
		super();
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
	

}
