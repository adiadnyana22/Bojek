package Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import DB.DriverRepository;
import DB.OrderRepository;

public class OrderService {
	private OrderRepository orderRepo = new OrderRepository();
	private DriverRepository driverRepo = new DriverRepository();

	public void acceptOrder(Driver driver, String customerName, int distance) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
		LocalDateTime now = LocalDateTime.now();
		
		orderRepo.insertOrder(driver.getId(), dtf.format(now), driver.calculateFee(distance), distance);
		driverRepo.orderCompleteIncrement(driver.getId());
	}
	
	public void showOrder() {
		ArrayList<Order> allOrder = orderRepo.getAllOrder();
		
		for (Order order : allOrder) {
			System.out.println("Order Id : " + order.getOrderId());
			System.out.println("Order Date : " + order.getOrderDate());
			System.out.println("Driver Name : " + order.getDriver().getName());
			System.out.println("Distance : " + order.getDistance());
			System.out.println("Fee : " + order.getFee());
			System.out.println("-------------------------------------\n");
		}
	}
}
