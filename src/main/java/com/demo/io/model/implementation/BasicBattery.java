package com.demo.io.model.implementation;

import com.demo.io.model.Battery;

/**
 * this model defines battery features 
 * @author Neeraj Jain
 *
 */

public class BasicBattery implements Battery{



	private   double capacity ;
	
	private boolean isLowCapacity =false;
	
	 public BasicBattery  (){
		 this.capacity=INITAL_CAPCITY;
	 }
	
	 public double cosumeBattery(double consumption) throws Exception{
		 if((this.capacity-consumption)<=0){
			 throw new Exception("NOT ENOUGH BETTERY TO COSUME!!RECHARGE BETTERY");
		 }
		 if(this.capacity<=LOW_CAPCITY||(this.capacity-consumption<=LOW_CAPCITY)){
			 this.isLowCapacity=true;
			 System.out.println("---LOW BETTERY---");

		 }

		 this.capacity-=consumption;
		 return capacity;
	 }

	public double getCapacity() {
		return capacity;
	}

	public boolean isLowCapacity() {
		return isLowCapacity;
	}

	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}
	 
	 
	 
	 
	
	
}
