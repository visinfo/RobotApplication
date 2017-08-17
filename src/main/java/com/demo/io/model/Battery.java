package com.demo.io.model;

/**
 * 
 * Define the Supported Battery Prototype for Robot 
 * @author Neeraj Jain
 *
 */
public interface Battery {
	double INITAL_CAPCITY =100;
	double LOW_CAPCITY =15;
    public double cosumeBattery(double consumption) throws Exception;
    public double getCapacity();
    public void setCapacity(double capacity);
    
}
