package com.demo.io.repository;

import java.util.HashMap;
import java.util.Map;

/**
 * This Class Define some Basic Data For Items with Barcode
 * Just to ease out the prototype by not using Database 
 * @author Neeraj Jain
 *
 */
public class RobotSystemRepo {
	private static Map<String,Double> itemMap ;
	static{
		
		itemMap = new HashMap<String,Double>();
		itemMap.put("1234567891012345", 10.00);
		
	}
	
	public static double getPriceFromBarCode(String barCode){
		
		return itemMap.get(barCode);
	}

}
