package com.demo.io.model;

import java.util.List;

public class Message {

	
	private List<Item> items ;
	
	private ErrorCode code;
	
	private String cotent ;

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	

	public ErrorCode getCode() {
		return code;
	}

	public void setCode(ErrorCode code) {
		this.code = code;
	}

	public String getCotent() {
		return cotent;
	}

	public void setCotent(String cotent) {
		this.cotent = cotent;
	}
			
	
	
}
