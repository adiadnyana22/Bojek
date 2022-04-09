package Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import Utils.IdGenerator;

public class Order {
	private String orderId;
	private Driver driver;
	private String orderDate;
	private int fee;
	private int distance;
	
	public Order(Driver driver, int fee, int distance) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
		LocalDateTime now = LocalDateTime.now(); 
		IdGenerator idGenerator = new IdGenerator();
		
		this.orderId = idGenerator.generateIdOrder();
		this.driver = driver;
		this.orderDate = dtf.format(now);
		this.fee = fee;
		this.distance = distance;
	}

	public String getOrderId() {
		return orderId;
	}

	public Driver getDriver() {
		return driver;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public int getFee() {
		return fee;
	}

	public int getDistance() {
		return distance;
	}

}
