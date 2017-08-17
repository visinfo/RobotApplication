package com.demo.io.model;

public interface Battery {
	double INITAL_CAPCITY =100;
	double LOW_CAPCITY =15;
    public double cosumeBattery(double consumption) throws Exception;
    public double getCapacity();
    public void setCapacity(double capacity);
    
}
