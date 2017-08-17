package com.demo.io;


import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.demo.io.common.BasicScan;
import com.demo.io.common.RobotType;
import com.demo.io.model.Distance;
import com.demo.io.model.Item;
import com.demo.io.model.Robot;
import com.demo.io.model.implementation.BasicBattery;
import com.demo.io.model.implementation.BasicRobot;

import junit.framework.Assert;

public class BasicRobotTest {
	
	private static BasicRobot robot ;
	@BeforeClass
	public static  void setup() {
			
 		robot= new BasicRobot.BasicRoboBuilder("DEFAULT",RobotType.BASIC,null).setBattery(new BasicBattery()).build();
	}

	@Test
	public void checkIfRobotExists(){
		
		Assert.assertNotNull(robot);
	}
	
	@Test
	public void checkIfRobotHasBattery(){
		
		Assert.assertNotNull(robot.getBattery());
	}
	
	@Test
	public void checkBatteryCapacityAfterCosumption() throws Exception{
		double capacity =robot.getBattery().getCapacity();
		Assert.assertEquals(robot.getBattery().cosumeBattery(1*20),(capacity-(20*(1))));
	}
	
	@Test
	public void checkIfRobotCanMoveOneKms() throws Exception{
		Distance dist = new Distance();
		dist.setForward(1);
		robot.move(dist);
		
	}
	@Test(expected=Exception.class)
	public void checkIfRobotCanMoveSixKms() throws Exception {
		Distance dist = new Distance();
		dist.setForward(6);
		Robot robot= new BasicRobot.BasicRoboBuilder("DEFAULT", RobotType.BASIC,null).setBattery(new BasicBattery()).build();

		robot.move(dist);
	}
	
	
	@Test
	public void checkIfBatteryCapcityLow() throws Exception{
		Distance dist = new Distance();
		dist.setForward(4);
		BasicRobot robot= new BasicRobot.BasicRoboBuilder("DEFAULT",RobotType.BASIC,null).setBattery(new BasicBattery()).build();
		robot.move(dist);
		dist.setForward(0.5);
		robot.move(dist);
		Assert.assertEquals(true, ((BasicBattery)robot.getBattery()).isLowCapacity());
	}
	
	@Test(expected=Exception.class)
	public void checkIfRobotTrowsExceptionWhenOverWeight() throws Exception{
		Distance dist = new Distance();
		dist.setForward(1);
		List<Item> items = new ArrayList<Item>();	
		Item item = new Item();
		item.setWeight(10);
		items.add(item);
		Robot robot= new BasicRobot.BasicRoboBuilder("DEFAULT", RobotType.BASIC,items).setBattery(new BasicBattery()).build();
		robot.move(dist);
	}
	@Test
	public void checkBetteryConsumptionWithFourKgsWeight() throws Exception{
		Distance dist = new Distance();
		dist.setForward(1);
		List<Item> items = new ArrayList<Item>();	
		Item item = new Item();
		item.setWeight(4);
		items.add(item);
		BasicRobot robot= new BasicRobot.BasicRoboBuilder("DEFAULT", RobotType.BASIC,items).setBattery(new BasicBattery()).build();
		double capacity =robot.getBattery().getCapacity();
		robot.move(dist);
		Assert.assertEquals(capacity-1*20-8, robot.getBattery().getCapacity());
	
	}
	/**
	 * Defined User Test Cases 
	 * 
	 * @throws Exception
	 */
	@Test
	public void checkBetteryConsumptionAfterThreeAndHalfKms() throws Exception{
		Distance dist = new Distance();
		dist.setForward(3.5);
		BasicRobot robot= new BasicRobot.BasicRoboBuilder("DEFAULT", RobotType.BASIC,null).setBattery(new BasicBattery()).build();
		double capacity =robot.getBattery().getCapacity();
		robot.move(dist);
		Assert.assertEquals(capacity-3.5*20, robot.getBattery().getCapacity());
	
	}
	@Test
	public void checkBetteryConsumptionAfterTwoKmsWithThreeKgsWeight() throws Exception{
		Distance dist = new Distance();
		dist.setForward(2);
		List<Item> items = new ArrayList<Item>();	
		Item item = new Item();
		item.setWeight(3);
		items.add(item);
		BasicRobot robot= new BasicRobot.BasicRoboBuilder("DEFAULT", RobotType.BASIC,items).setBattery(new BasicBattery()).build();
		double capacity =robot.getBattery().getCapacity();
		robot.move(dist);
		Assert.assertEquals(capacity-2*20-6, robot.getBattery().getCapacity());
	
	}
	
	@Test(expected=Exception.class)
	public void checkRobotWithTwleveKgsWeight() throws Exception{
		Distance dist = new Distance();
		dist.setForward(1);
		List<Item> items = new ArrayList<Item>();	
		Item item = new Item();
		item.setWeight(12);
		items.add(item);
		BasicRobot robot= new BasicRobot.BasicRoboBuilder("DEFAULT", RobotType.BASIC,items).setBattery(new BasicBattery()).build();
		robot.move(dist);
	
	}
	
	@Test
	public void checkRobotCanPerformScan() throws Exception{
	
		List<Item> items = new ArrayList<Item>();	
		Item item = new Item();
		item.setWeight(12);
		items.add(item);
		BasicRobot robot= new BasicRobot.BasicRoboBuilder("DEFAULT", RobotType.BASIC,items).setBattery(new BasicBattery()).build();
		Assert.assertEquals(16, robot.scan(new BasicScan()).getBarCode().length());
	
	}
	
	
	
	
}
