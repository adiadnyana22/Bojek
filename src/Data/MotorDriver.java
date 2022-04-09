package Data;

public class MotorDriver extends Driver {

	public MotorDriver(String identityCardNumber, String name, String gender, String phoneNumber, String email,
			String dateOfBirth, String address, Vehicle vehicle) {
		super(identityCardNumber, name, gender, phoneNumber, email, dateOfBirth, address, vehicle);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int calculateFee(int distance) {
		// TODO Auto-generated method stub
		if(distance <= 5) {
			return 10000;
		}
		
		return 10000 + ((distance-5) * 2000);
	}


}
