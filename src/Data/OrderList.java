package Data;

import java.util.ArrayList;

public class OrderList {
	private ArrayList<Order> orderList = new ArrayList<Order>();

	public void acceptOrder(Driver driver, String customerName, int distance) {
		Order newOrder = new Order(driver, driver.calculateFee(distance), distance);
		orderList.add(newOrder);
	}
	
	public void showOrder() {
		for (Order order : orderList) {
			System.out.println("Order Id : " + order.getOrderId());
			System.out.println("Order Date : " + order.getOrderDate());
			System.out.println("Driver Name : " + order.getDriver().getName());
			System.out.println("Distance : " + order.getDistance());
			System.out.println("Fee : " + order.getFee());
			System.out.println("-------------------------------------\n");
		}
	}
}
