package Data;

public class DriverFactory {
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
	
	public DriverFactory(String identityCardNumber, String name, String gender, String phoneNumber, String email, String dateOfBirth, String address, Vehicle vehicle) {
		this.identityCardNumber = identityCardNumber;
		this.name = name;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.address = address; 
		this.vehicle = vehicle;
	}
	
	public DriverFactory(int id, String identityCardNumber, String name, String gender, String phoneNumber, String email, String dateOfBirth, String address, String joinDate, int orderCompleted, Vehicle vehicle) {
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
	
	public Driver getMotorDriver() {
		return new MotorDriver(identityCardNumber, name, gender, phoneNumber, email, dateOfBirth, address, vehicle);
	}
	
	public Driver getCarDriver() {
		return new CarDriver(identityCardNumber, name, gender, phoneNumber, email, dateOfBirth, address, vehicle);
	}
	
	public Driver getMotorDriverForDatabase() {
		return new MotorDriver(id, identityCardNumber, name, gender, phoneNumber, email, dateOfBirth, address, joinDate, orderCompleted, vehicle);
	}
	
	public Driver getCarDriverForDatabase() {
		return new CarDriver(id, identityCardNumber, name, gender, phoneNumber, email, dateOfBirth, address, joinDate, orderCompleted, vehicle);
	}
}
