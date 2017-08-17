package com.demo.io.model;

import com.demo.io.common.ScanStrategy;

/**
 * Robot Interface to define abstract Features
 * 
 * @author Neeraj Jain
 *
 */

public interface Robot {

	/**
	 * Method define Move E.g Forward,Left,Right,Backward For Robot
	 * 
	 * @param distance
	 * @throws Exception
	 */
	public void move(Distance distance) throws Exception;

	/**
	 * Method define Scan with Desired ScanStrategy *
	 * 
	 * @param scan
	 * @return
	 * @throws Exception
	 */
	public Item scan(ScanStrategy scan) throws Exception;

	/**
	 * Method Define the display of message on Display Screen
	 * 
	 * @param displayMessage
	 * @throws Exception
	 */
	public void display(Message displayMessage) throws Exception;

}
