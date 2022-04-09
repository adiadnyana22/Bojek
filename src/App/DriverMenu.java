package App;

import java.util.Scanner;

import Data.CarDriver;
import Data.Driver;
import Data.DriverList;
import Data.MotorDriver;
import Data.Vehicle;

public class DriverMenu {
	private Scanner sc = new Scanner(System.in);
	private DriverList driverList = DriverList.getInstance();
	
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
		if(jenisDriver == 1) {
			newDriver = new MotorDriver(identityCardNumber, name, gender, phoneNumber, email, dateOfBirth, address, vehicle);
		} else if(jenisDriver == 2) {
			newDriver = new CarDriver(identityCardNumber, name, gender, phoneNumber, email, dateOfBirth, address, vehicle);
		}
		
		driverList.addDriver(newDriver);
	}
	
	private void showAllDriverMenu() {
		driverList.showAllDriver();
	}
	
	private void showMotorDriverMenu() {
		driverList.showMotorDriver();
	}
	
	private void showCarDriverMenu() {
		driverList.showCarDriver();
	}
	
	private void updateDriverMenu() {
		String driverId, name, email, phoneNumber, address, boolVehicle;
		int index;
		
		System.out.print("Driver Id : ");
		driverId = sc.nextLine();
		
		index = driverList.searchDriver(driverId);
		if(index != -1) {
			System.out.println("Personal Data");
			System.out.println("-------------");
			System.out.print("New Name [Kosongkan Jika tidak ingin diganti] : ");
			name = sc.nextLine();
			System.out.print("New Email [Kosongkan Jika tidak ingin diganti] : ");
			email = sc.nextLine();
			System.out.print("New Phone Number [Kosongkan Jika tidak ingin diganti] : ");
			phoneNumber = sc.nextLine();
			System.out.print("New Address [Kosongkan Jika tidak ingin diganti] : ");
			address = sc.nextLine();
			
			System.out.print("Do you want to update Vehicle (yes/no) ? ");
			boolVehicle = sc.nextLine();
			if(boolVehicle.equalsIgnoreCase("yes")) {
				String plateNumber, merk, type;
				
				System.out.println("Vehicle Data");
				System.out.println("-------------");
				System.out.print("New Plate Number [Kosongkan Jika tidak ingin diganti] : ");
				plateNumber = sc.nextLine();
				System.out.print("New Vehicle Merk [Kosongkan Jika tidak ingin diganti] : ");
				merk = sc.nextLine();
				System.out.print("New Vehicle Type [Kosongkan Jika tidak ingin diganti] : ");
				type = sc.nextLine();
				
				driverList.updateVehicle(index, plateNumber, merk, type);
			}
			
			driverList.updateDriver(index, name, email, phoneNumber, address);
		} else {
			System.out.println("Driver tidak ditemukan");
		}
	}
	
	private void deleteDriverMenu() {
		String driverId;
		
		System.out.print("Driver Id : ");
		driverId = sc.nextLine();
		
		driverList.deleteDriver(driverId);
	}
}
