package Data;

public class Vehicle {
	private String plateNumber;
	private String merk;
	private String type;
	
	public Vehicle(String plateNumber, String merk, String type) {
		this.plateNumber = plateNumber;
		this.merk = merk;
		this.type = type;
	}

	public String getPlateNumber() {
		return plateNumber;
	}
	
	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}
	
	public String getMerk() {
		return merk;
	}
	
	public void setMerk(String merk) {
		this.merk = merk;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
}
