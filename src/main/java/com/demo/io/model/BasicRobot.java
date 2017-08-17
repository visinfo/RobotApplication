package com.demo.io.model;


import java.util.List;

import com.demo.io.RobotType;
import com.demo.io.ScanStrategy;
import com.demo.io.repository.RobotSystemRepo;

/**
 * This is Robot Model Class . Defines Basic Feature And Method To Build Robot Instance 
 * @author Neeraj Jain
 *
 */
public class BasicRobot implements Robot{

	private  Battery  battery ;
	
	private String roboCode ;
	private RobotType type ;
	private List<Item> items;

	private final double BATTERY_CONSUMPTION_PER_KMS=20;
	private final double BATTERY_CONSUMPTION_PER_KGS=2;
	private final double MAX_LOAD_IN_KGS=10;


	
	private  BasicRobot(BasicRoboBuilder builder){
		this.roboCode=builder.roboCode;
		this.type =builder.type;
		this.battery=builder.battery;
		this.items=builder.items;
		
	}
	
	
	public String getRoboCode() {
		return roboCode;
	}


	public RobotType getType() {
		return type;
	}


	public List<Item> getItems() {
		return items;
	}

	public void addItem(Item item){
		this.items.add(item);
	}



	public Battery getBattery() {
		return battery;
	}


	public static class BasicRoboBuilder {
		private String roboCode ;
		private RobotType type ;
		private  Battery  battery ;
		private List<Item> items; 
	
		public BasicRoboBuilder (String roboCode,RobotType type,List<Item> items){
			this.items=items;
			this.roboCode=roboCode;
			this.type=type;
		}
		public BasicRoboBuilder setBattery(Battery battery){
			this.battery=battery;
			return this;
		}
		public BasicRobot build(){
			return new BasicRobot(this);
			
		}
		
		
	}

	/**
	 * This method Move the robot for given distance
	 * @param distance in kms
	 * @throws Exception 
	 */
	public void move(Distance distance) throws Exception {
		if(distance==null){
			throw new Exception("Error !!Define Proper Move!!");
		}
		double consumption =distance.getForward()*BATTERY_CONSUMPTION_PER_KMS;
		if(this.items!=null){
			double 	totalWeight=checkIfOverWeight();
			if(totalWeight>0){
				consumption+=totalWeight*BATTERY_CONSUMPTION_PER_KGS;
			}

		}
		this.getBattery().cosumeBattery(consumption);

		
	}

/**
 * Check If Robot Is overweight or not 
 * @throws Exception
 */
	private double checkIfOverWeight() throws Exception {
		double totalWeight =this.getItems().stream().filter(item ->item.getWeight()>0).mapToDouble(Item::getWeight).sum();
		if(totalWeight>=MAX_LOAD_IN_KGS){
			Message msg = new Message();
			msg.setCotent(ErrorCode.Overweight.getError());
			msg.setItems(items);
			msg.setCode(ErrorCode.Overweight);
			display(msg);
		
			throw new Exception("Overweight!! Cannot Move Further");
		}else {
			return totalWeight;
		}
	}


@Override
public Item scan(ScanStrategy scan) throws Exception {
	Item item=scan.performScan();
	if(item.getBarCode().isEmpty()||item.getBarCode().length()!=16){
		Message displayMessage = new Message ();
		displayMessage.setCode(ErrorCode.ScanFail);
		displayMessage.setCotent(ErrorCode.ScanFail.getError());
		display(displayMessage);
		throw new Exception("Scan Failure");
	}
	Message displayMessage = new Message ();
	displayMessage.setCode(ErrorCode.Price);
	displayMessage.setCotent(ErrorCode.Price.getError()+":"+item.getItemPrice());
	display(displayMessage);
	return item;
}






@Override
public void display(Message displayMessage) throws Exception {
	if(displayMessage.getCode().equals(ErrorCode.Overweight)||displayMessage.getCode().equals(ErrorCode.ScanFail)||displayMessage.getCode().equals(ErrorCode.Price)){
		System.out.println("LED display on chest:"+displayMessage.getCotent());
	}else 	if(displayMessage.getCode().equals(ErrorCode.LowBattery)){
		System.out.println("Robot head  display"+displayMessage.getCotent());
	}else {
		System.out.println("Error In Display Define Display");

	}
	
}




}
