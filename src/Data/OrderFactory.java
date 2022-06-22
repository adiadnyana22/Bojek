package Data;

public class OrderFactory {
	private int orderId;
	private Driver driver;
	private String orderDate;
	private int fee;
	private int distance;
	
	public OrderFactory(int orderId, Driver driver, int fee, int distance, String orderDate) {
		this.orderId = orderId;
		this.driver = driver;
		this.orderDate = orderDate;
		this.fee = fee;
		this.distance = distance;
	}
	
	public OrderFactory(Driver driver, int fee, int distance) {
		this.driver = driver;
		this.fee = fee;
		this.distance = distance;
	}
	
	public Order getOrder() {
		return new Order(driver, fee, distance);
	}
	
	public Order getOrderForDatabase() {
		return new Order(orderId, driver, fee, distance, orderDate);
	}
}
