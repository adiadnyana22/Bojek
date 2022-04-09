package Data;

import java.util.ArrayList;

public class DriverList {
	private static DriverList singleton = null;
	
	public static DriverList getInstance() {
		if(singleton == null) {
			singleton = new DriverList();
		}
		
		return singleton;
	}

	private ArrayList<Driver> driverList = new ArrayList<Driver>();
	
	public void addDriver(Driver newDriver) {
		driverList.add(newDriver);
	}
	
	public void showAllDriver() {
		for (Driver driver : driverList) {
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
		for (Driver driver : driverList) {
			if(driver.getClass().equals(MotorDriver.class)) {
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
	}
	
	public void showCarDriver() {
		for (Driver driver : driverList) {
			if(driver.getClass().equals(CarDriver.class)) {
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
	}
	
	public void updateDriver(int index, String name, String email, String phoneNumber, String address) {
		if(!name.isBlank()) driverList.get(index).setName(name);
		if(!email.isBlank()) driverList.get(index).setEmail(email);
		if(!phoneNumber.isBlank()) driverList.get(index).setPhoneNumber(phoneNumber);
		if(!address.isBlank()) driverList.get(index).setAddress(address);
	}
	
	public void updateVehicle(int index, String plateNumber, String merk, String type) {
		Vehicle vehicle = driverList.get(index).getVehicle();
		if(!plateNumber.isBlank()) vehicle.setPlateNumber(plateNumber);
		if(!merk.isBlank()) vehicle.setMerk(merk);
		if(!type.isBlank()) vehicle.setType(type);
	}
	
	public void deleteDriver(String driverId) {
		int index = searchDriver(driverId);
		if(index == -1) {
			System.out.println("Id nya ga ada bos");
		} else {
			driverList.remove(index);
		}
	}
	
	public int searchDriver(String driverId) {
		for (int i = 0; i < driverList.size(); i++) {
			if(driverList.get(i).getId().equals(driverId)) return i;
		}
		
		return -1;
	}
	
	public Driver getRandomMotorDriver() {
		int random = (int) Math.floor(Math.random() * driverList.size());
		
		while(!driverList.get(random).getClass().equals(MotorDriver.class)) {
			random = (int) Math.floor(Math.random() * driverList.size());
		}
		
		return driverList.get(random);
	}
	
	public Driver getRandomCarDriver() {
		int random = (int) Math.floor(Math.random() * driverList.size());
		
		while(!driverList.get(random).getClass().equals(CarDriver.class)) {
			random = (int) Math.floor(Math.random() * driverList.size());
		}
		
		return driverList.get(random);
	}
}
