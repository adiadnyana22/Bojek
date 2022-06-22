package Data;

import java.util.ArrayList;

import DB.DriverRepository;

public class DriverService {
	private DriverRepository repo = new DriverRepository();
	
	public void addDriver(Driver newDriver) {
		repo.insertDriver(newDriver);
	}
	
	public void showAllDriver() {
		ArrayList<Driver> allDriver = repo.getAllDriver();
		
		for (Driver driver : allDriver) {
			System.out.println("Driver Id : " + driver.getId());
			System.out.println("Name : " + driver.getName());
			System.out.println("Gender : " + driver.getGender());
			System.out.println("Address : " + driver.getAddress());
			System.out.println("Phone Number : " + driver.getPhoneNumber());
			System.out.println("Email : " + driver.getEmail());
			System.out.println("Vehicle Type : " + driver.getVehicle().getType());
			System.out.println("Order Completed : " + driver.getOrderCompleted());
			System.out.println("-------------------------------------\n");
		}
	}
	
	public void showMotorDriver() {
		ArrayList<Driver> motorDriver = repo.getMotorDriver();
		
		for (Driver driver : motorDriver) {
			System.out.println("Driver Id : " + driver.getId());
			System.out.println("Name : " + driver.getName());
			System.out.println("Gender : " + driver.getGender());
			System.out.println("Address : " + driver.getAddress());
			System.out.println("Phone Number : " + driver.getPhoneNumber());
			System.out.println("Email : " + driver.getEmail());
			System.out.println("Vehicle Type : " + driver.getVehicle().getType());
			System.out.println("Order Completed : " + driver.getOrderCompleted());
			System.out.println("-------------------------------------\n");
		}
	}
	
	public void showCarDriver() {
		ArrayList<Driver> carDriver = repo.getCarDriver();
		
		for (Driver driver : carDriver) {
			System.out.println("Driver Id : " + driver.getId());
			System.out.println("Name : " + driver.getName());
			System.out.println("Gender : " + driver.getGender());
			System.out.println("Address : " + driver.getAddress());
			System.out.println("Phone Number : " + driver.getPhoneNumber());
			System.out.println("Email : " + driver.getEmail());
			System.out.println("Vehicle Type : " + driver.getVehicle().getType());
			System.out.println("Order Completed : " + driver.getOrderCompleted());
			System.out.println("-------------------------------------\n");
		}
	}
	
	public void updateDriver(Driver driver, int id) {
		repo.updateDriverById(driver, id);
	}
	
	public void deleteDriver(int driverId) {
		Driver tempDriver = repo.getDriverById(driverId);
		if(tempDriver == null) {
			System.out.println("Id nya ga ada bos");
		} else {
			repo.deleteDriverById(driverId);
		}
	}
	
	public Driver searchDriver(int driverId) {
		Driver tempDriver = repo.getDriverById(driverId);
		
		return tempDriver;
	}
	
	public Driver getRandomMotorDriver() {
		ArrayList<Driver> allDriver = repo.getAllDriver();
		
		int random = (int) Math.floor(Math.random() * allDriver.size());
		
		while(!allDriver.get(random).getClass().equals(MotorDriver.class)) {
			random = (int) Math.floor(Math.random() * allDriver.size());
		}
		
		return allDriver.get(random);
	}
	
	public Driver getRandomCarDriver() {
		ArrayList<Driver> allDriver = repo.getAllDriver();
		
		int random = (int) Math.floor(Math.random() * allDriver.size());
		
		while(!allDriver.get(random).getClass().equals(CarDriver.class)) {
			random = (int) Math.floor(Math.random() * allDriver.size());
		}
		
		return allDriver.get(random);
	}
}
