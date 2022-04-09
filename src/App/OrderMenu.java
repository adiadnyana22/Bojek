package App;

import java.util.Scanner;

import Data.Driver;
import Data.DriverList;
import Data.OrderList;

public class OrderMenu {
	private Scanner sc = new Scanner(System.in);
	private OrderList orderList = new OrderList();
	private DriverList driverList = DriverList.getInstance();
	
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
			orderDriver = driverList.getRandomMotorDriver();
		} else if(driverType == 2) {
			orderDriver = driverList.getRandomCarDriver();
		}
		
		System.out.println("Fee : " + orderDriver.calculateFee(distance));
		System.out.println("Searching For Driver ...");
		
		orderDriver.incrementOrderCompleted();
		
		System.out.println("You Got Driver");
		System.out.println("Driver Name : " + orderDriver.getName());
		System.out.println("Plate Number : " + orderDriver.getVehicle().getPlateNumber());
		System.out.println("Vehicle : " + orderDriver.getVehicle().getMerk() + " " + orderDriver.getVehicle().getType());
		
		orderList.acceptOrder(orderDriver, customerName, distance);
	}
	
	private void showOrderMenu() {
		orderList.showOrder();
	}
}
