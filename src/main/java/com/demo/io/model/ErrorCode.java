package com.demo.io.model;

public enum ErrorCode{
	Overweight("Overweight"),
	ScanFail("Scan Failure"),
	Price("Item Price"),
	LowBattery("Low Battery ");

	String errorMsg ;
	 private ErrorCode(String err) {
		 errorMsg = err;
		  }

		  public String getError() {
		    return errorMsg;
		  }
}
