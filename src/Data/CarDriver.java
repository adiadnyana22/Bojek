package Data;

public class CarDriver extends Driver {

	public CarDriver(String identityCardNumber, String name, String gender, String phoneNumber, String email,
			String dateOfBirth, String address, Vehicle vehilce) {
		super(identityCardNumber, name, gender, phoneNumber, email, dateOfBirth, address, vehilce);
		// TODO Auto-generated constructor stub
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
