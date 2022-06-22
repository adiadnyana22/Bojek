package Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Order {
	private int orderId;
	private Driver driver;
	private String orderDate;
	private int fee;
	private int distance;
	
	public Order(int orderId, Driver driver, int fee, int distance, String orderDate) {
		this.orderId = orderId;
		this.driver = driver;
		this.orderDate = orderDate;
		this.fee = fee;
		this.distance = distance;
	}
	
	public Order(Driver driver, int fee, int distance) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
		LocalDateTime now = LocalDateTime.now(); 
		
		this.driver = driver;
		this.orderDate = dtf.format(now);
		this.fee = fee;
		this.distance = distance;
	}

	public int getOrderId() {
		return orderId;
	}

	public Driver getDriver() {
		return driver;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}
}
