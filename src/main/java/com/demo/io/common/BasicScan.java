package com.demo.io.common;

import com.demo.io.model.Item;
import com.demo.io.repository.RobotSystemRepo;

/**
 * This Class Define the Scane Strategy to read the barcode (Using Strategy Design Pattern)
 * 
 * @author Neeraj Jain
 *
 */
public class BasicScan implements ScanStrategy {

	/**
	 * This Method Integrate with Scanner or API to read BarCode 
	 * currently returning default barCode 
	 */
	@Override
	public Item performScan() {
		String barCode ="1234567891012345";
		Item item = new Item ();
		item.setBarCode(barCode);
		item.setItemPrice(RobotSystemRepo.getPriceFromBarCode(barCode));
		return item;
	}

}
