package App;

import java.util.Scanner;

import Data.Driver;
import Data.DriverService;
import Data.OrderService;

public class OrderMenu {
	private Scanner sc = new Scanner(System.in);
	private OrderService orderService = new OrderService();
	private DriverService driverService = new DriverService();
	
	public void run() {
		int pilihanMenu = 0;
		
		do {
			printMenu();
			pilihanMenu = sc.nextInt();
			sc.nextLine();
			if(pilihanMenu == 1) createOrderMenu();
			else if(pilihanMenu == 2) showOrderMenu();
		} while(pilihanMenu != 3);
	}
	
	private void printMenu() {
		System.out.println("Manage Order");
		System.out.println("-------------\n");
		System.out.println("1. Create Order");
		System.out.println("2. Show Order");
		System.out.println("3. Back");
		System.out.print(">> ");
	}
	
	private void createOrderMenu() {
		int distance, driverType;
		String customerName;
		Driver orderDriver = null;
		
		System.out.print("Your Name : ");
		customerName = sc.nextLine();
		System.out.print("Distance (in km) : ");
		distance = sc.nextInt();
		System.out.println("Driver Type");
		System.out.println("-------------");
		System.out.println("1. Motor Driver");
		System.out.println("2. Car Driver");
		System.out.print(">> ");
		driverType = sc.nextInt();
		sc.nextLine();
		
		if(driverType == 1) {
			orderDriver = driverService.getRandomMotorDriver();
		} else if(driverType == 2) {
			orderDriver = driverService.getRandomCarDriver();
		}
		
		System.out.println("Fee : " + orderDriver.calculateFee(distance));
		System.out.println("Searching For Driver ...");
		
		System.out.println("You Got Driver");
		System.out.println("Driver Name : " + orderDriver.getName());
		System.out.println("Plate Number : " + orderDriver.getVehicle().getPlateNumber());
		System.out.println("Vehicle : " + orderDriver.getVehicle().getMerk() + " " + orderDriver.getVehicle().getType());
		
		orderService.acceptOrder(orderDriver, customerName, distance);
	}
	
	private void showOrderMenu() {
		orderService.showOrder();
	}
}
