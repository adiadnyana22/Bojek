package Data;

public class CarDriver extends Driver {

	public CarDriver(String identityCardNumber, String name, String gender, String phoneNumber, String email, String dateOfBirth, String address, Vehicle vehicle) {
		super(identityCardNumber, name, gender, phoneNumber, email, dateOfBirth, address, vehicle);
	}
	
	public CarDriver(int id, String identityCardNumber, String name, String gender, String phoneNumber, String email, String dateOfBirth, String address, String joinDate, int orderCompleted, Vehicle vehicle) {
		super(id, identityCardNumber, name, gender, phoneNumber, email, dateOfBirth, address, joinDate, orderCompleted, vehicle);
	}

	@Override
	public int calculateFee(int distance) {
		// TODO Auto-generated method stub
		if(distance <= 5) {
			return 20000;
		}
		
		return 20000 + ((distance-5) * 6000);
	}

	
}
