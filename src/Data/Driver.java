package Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Driver {
	private int id;
	private String identityCardNumber;
	private String name;
	private String gender;
	private String phoneNumber;
	private String email;
	private String dateOfBirth;
	private String address;
	private String joinDate;
	private int orderCompleted;
	private Vehicle vehicle;

	public Driver(int id, String identityCardNumber, String name, String gender, String phoneNumber, String email, String dateOfBirth, String address, String joinDate, int orderCompleted, Vehicle vehicle) {
		this.id = id;
		this.identityCardNumber = identityCardNumber;
		this.name = name;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.address = address; 
		this.joinDate = joinDate;
		this.orderCompleted = orderCompleted;
		this.vehicle = vehicle;
	}
	
	public Driver(String identityCardNumber, String name, String gender, String phoneNumber, String email, String dateOfBirth, String address, Vehicle vehicle) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
		LocalDateTime now = LocalDateTime.now(); 
		
		this.identityCardNumber = identityCardNumber;
		this.name = name;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.address = address; 
		this.joinDate = dtf.format(now);
		this.orderCompleted = 0;
		this.vehicle = vehicle;
	}

	public int getId() {
		return id;
	}

	public String getIdentityCardNumber() {
		return identityCardNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getJoinDate() {
		return joinDate;
	}

	public int getOrderCompleted() {
		return orderCompleted;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public abstract int calculateFee(int distance);
}
