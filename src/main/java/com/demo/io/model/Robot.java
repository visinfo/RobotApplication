package com.demo.io.model;

import com.demo.io.ScanStrategy;

public interface Robot {

	
	public void move(Distance distance) throws Exception;
	public Item  scan(ScanStrategy scan) throws Exception;
	public void display(Message displayMessage) throws Exception; 
	
}
