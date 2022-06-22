package App;

import java.util.Scanner;

import Data.Driver;
import Data.DriverFactory;
import Data.DriverService;
import Data.Vehicle;

public class DriverMenu {
	private Scanner sc = new Scanner(System.in);
	private DriverService driverService = new DriverService();
	
	public void run() {
		int pilihanMenu = 0;
		
		do {
			printMenu();
			pilihanMenu = sc.nextInt();
			sc.nextLine();
			if(pilihanMenu == 1) addDriverMenu();
			else if(pilihanMenu == 2) showAllDriverMenu();
			else if(pilihanMenu == 3) showMotorDriverMenu();
			else if(pilihanMenu == 4) showCarDriverMenu();
			else if(pilihanMenu == 5) updateDriverMenu();
			else if(pilihanMenu == 6) deleteDriverMenu();
		} while(pilihanMenu != 7);
	}
	
	private void printMenu() {
		System.out.println("Manage Driver");
		System.out.println("-------------\n");
		System.out.println("1. Add New Driver");
		System.out.println("2. Show All Driver");
		System.out.println("3. Show Motor Driver");
		System.out.println("4. Show Car Driver");
		System.out.println("5. Update Driver");
		System.out.println("6. Delete Driver");
		System.out.println("7. Back");
		System.out.print(">> ");
	}
	
	private void addDriverMenu() {
		String identityCardNumber, name, gender, phoneNumber, email, dateOfBirth, address;
		String plateNumber, merk, type;
		int jenisDriver;
		
		System.out.println("Personal Data");
		System.out.println("-------------");
		System.out.print("Identity Number : ");
		identityCardNumber = sc.nextLine();
		System.out.print("Name : ");
		name = sc.nextLine();
		System.out.print("Gender (Male/Female) : ");
		gender = sc.nextLine();
		System.out.print("Phone Number : ");
		phoneNumber = sc.nextLine();
		System.out.print("Email : ");
		email = sc.nextLine();
		System.out.print("Date Of Birth (dd/mm/yyyy) : ");
		dateOfBirth = sc.nextLine();
		System.out.print("Address : ");
		address = sc.nextLine();
		
		System.out.println("Driver Type");
		System.out.println("-------------");
		System.out.println("1. Motor Driver");
		System.out.println("2. Car Driver");
		System.out.print(">> ");
		jenisDriver = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Vehicle Data");
		System.out.println("-------------");
		System.out.print("Plate Number : ");
		plateNumber = sc.nextLine();
		System.out.print("Vehicle Merk : ");
		merk = sc.nextLine();
		System.out.print("Vehicle Type : ");
		type = sc.nextLine();
		
		Driver newDriver = null;
		Vehicle vehicle = new Vehicle(plateNumber, merk, type);
		DriverFactory df = new DriverFactory(identityCardNumber, name, gender, phoneNumber, email, dateOfBirth, address, vehicle);
		
		if(jenisDriver == 1) {
			newDriver = df.getMotorDriver();
		} else if(jenisDriver == 2) {
			newDriver = df.getCarDriver();
		}
		
		driverService.addDriver(newDriver);
	}
	
	private void showAllDriverMenu() {
		driverService.showAllDriver();
	}
	
	private void showMotorDriverMenu() {
		driverService.showMotorDriver();
	}
	
	private void showCarDriverMenu() {
		driverService.showCarDriver();
	}
	
	private void updateDriverMenu() {
		String  name, email, phoneNumber, address, boolVehicle;
		int driverId;
		
		System.out.print("Driver Id : ");
		driverId = sc.nextInt();
		sc.nextLine();
		
		Driver searchDriver = driverService.searchDriver(driverId);
		if(searchDriver != null) {
			System.out.println("Personal Data");
			System.out.println("-------------");
			System.out.print("New Name [Kosongkan jika tidak ingin diubah] : ");
			name = sc.nextLine();
			System.out.print("New Email [Kosongkan jika tidak ingin diubah] : ");
			email = sc.nextLine();
			System.out.print("New Phone Number [Kosongkan jika tidak ingin diubah] : ");
			phoneNumber = sc.nextLine();
			System.out.print("New Address [Kosongkan jika tidak ingin diubah] : ");
			address = sc.nextLine();
			
			if(!name.isBlank()) searchDriver.setName(name);
			if(!email.isBlank()) searchDriver.setEmail(email);
			if(!phoneNumber.isBlank()) searchDriver.setPhoneNumber(phoneNumber);
			if(!address.isBlank()) searchDriver.setAddress(address);
			
			System.out.print("Do you want to update Vehicle (yes/no) ? ");
			boolVehicle = sc.nextLine();
			if(boolVehicle.equalsIgnoreCase("yes")) {
				String plateNumber, merk, type;
				
				System.out.println("Vehicle Data");
				System.out.println("-------------");
				System.out.print("New Plate Number [Kosongkan jika tidak ingin diubah] : ");
				plateNumber = sc.nextLine();
				System.out.print("New Vehicle Merk [Kosongkan jika tidak ingin diubah] : ");
				merk = sc.nextLine();
				System.out.print("New Vehicle Type [Kosongkan jika tidak ingin diubah] : ");
				type = sc.nextLine();
				
				if(!plateNumber.isBlank()) searchDriver.getVehicle().setPlateNumber(plateNumber);
				if(!merk.isBlank()) searchDriver.getVehicle().setMerk(merk);
				if(!type.isBlank()) searchDriver.getVehicle().setType(type);
			}
			
			driverService.updateDriver(searchDriver, driverId);
		} else {
			System.out.println("Driver tidak ditemukan");
		}
	}
	
	private void deleteDriverMenu() {
		int driverId;
		
		System.out.print("Driver Id : ");
		driverId = sc.nextInt();
		
		driverService.deleteDriver(driverId);
	}
}
