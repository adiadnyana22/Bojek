package DB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Data.CarDriver;
import Data.Driver;
import Data.DriverFactory;
import Data.MotorDriver;
import Data.Vehicle;

public class DriverRepository {
	
	private Connect con = Connect.getInstance();
	
	public ArrayList<Driver> getAllDriver(){
		ArrayList<Driver> driverList = new ArrayList<>();
		
		String query = "SELECT * FROM driver";
		
		ResultSet rs = con.executeQuery(query);
		
		try {
			while(rs.next()) {
				Vehicle newVehicle = new Vehicle(rs.getString("plateNumber"), rs.getString("merk"), rs.getString("vehicleType"));
				
				DriverFactory df = new DriverFactory(rs.getInt("driverId"), rs.getString("identityNumber"), rs.getString("name"), rs.getString("gender"), rs.getString("phoneNumber"), rs.getString("email"), rs.getString("dob"), rs.getString("address"), rs.getString("joinDate"), rs.getInt("orderComplete"), newVehicle);
				if(rs.getString("driverType").equals("Motor Driver")) {
					driverList.add(df.getMotorDriverForDatabase());
				} else if(rs.getString("driverType").equals("Car Driver")) {
					driverList.add(df.getCarDriverForDatabase());
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return driverList;
	}
	
	public ArrayList<Driver> getMotorDriver(){
		ArrayList<Driver> driverList = new ArrayList<>();
		
		String query = "SELECT * FROM driver WHERE driverType = 'Motor Driver'";
		
		ResultSet rs = con.executeQuery(query);
		
		try {
			while(rs.next()) {
				Vehicle newVehicle = new Vehicle(rs.getString("plateNumber"), rs.getString("merk"), rs.getString("vehicleType"));
				
				DriverFactory df = new DriverFactory(rs.getInt("driverId"), rs.getString("identityNumber"), rs.getString("name"), rs.getString("gender"), rs.getString("phoneNumber"), rs.getString("email"), rs.getString("dob"), rs.getString("address"), rs.getString("joinDate"), rs.getInt("orderComplete"), newVehicle);
				if(rs.getString("driverType").equals("Motor Driver")) {
					driverList.add(df.getMotorDriverForDatabase());
				} else if(rs.getString("driverType").equals("Car Driver")) {
					driverList.add(df.getCarDriverForDatabase());
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return driverList;
	}
	
	public ArrayList<Driver> getCarDriver(){
		ArrayList<Driver> driverList = new ArrayList<>();
		
		String query = "SELECT * FROM driver WHERE driverType = 'Car Driver'";
		
		ResultSet rs = con.executeQuery(query);
		
		try {
			while(rs.next()) {
				Vehicle newVehicle = new Vehicle(rs.getString("plateNumber"), rs.getString("merk"), rs.getString("vehicleType"));
				
				DriverFactory df = new DriverFactory(rs.getInt("driverId"), rs.getString("identityNumber"), rs.getString("name"), rs.getString("gender"), rs.getString("phoneNumber"), rs.getString("email"), rs.getString("dob"), rs.getString("address"), rs.getString("joinDate"), rs.getInt("orderComplete"), newVehicle);
				if(rs.getString("driverType").equals("Motor Driver")) {
					driverList.add(df.getMotorDriverForDatabase());
				} else if(rs.getString("driverType").equals("Car Driver")) {
					driverList.add(df.getCarDriverForDatabase());
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return driverList;
	}
	
	public Driver getDriverById(int id) {
		Driver newDriver = null;
		
		String query = String.format("SELECT * FROM driver WHERE " + "driverId = %d", id);
		
		ResultSet rs = con.executeQuery(query);
		
		try {
			while(rs.next()) {
				Vehicle newVehicle = new Vehicle(rs.getString("plateNumber"), rs.getString("merk"), rs.getString("vehicleType"));
				
				DriverFactory df = new DriverFactory(rs.getInt("driverId"), rs.getString("identityNumber"), rs.getString("name"), rs.getString("gender"), rs.getString("phoneNumber"), rs.getString("email"), rs.getString("dob"), rs.getString("address"), rs.getString("joinDate"), rs.getInt("orderComplete"), newVehicle);
				if(rs.getString("driverType").equals("Motor Driver")) {
					newDriver = df.getMotorDriverForDatabase();
				} else if(rs.getString("driverType").equals("Car Driver")) {
					newDriver = df.getCarDriverForDatabase();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return newDriver;
	}
	
	public void updateDriverById(Driver driver, int id) {
		String driverType = null;
		
		if(driver instanceof MotorDriver) {
			driverType = "Motor Driver";
		} else if(driver instanceof CarDriver) {
			driverType = "Car Driver";
		}
		
		String query = String.format("UPDATE driver SET " 
				+"identityNumber = '%s', "
				+"name = '%s', "
				+"gender = '%s', "
				+"phoneNumber = '%s', "
				+"email ='%s', "
				+"dob = '%s', "
				+"address = '%s', "
				+"joinDate = '%s', "
				+"orderComplete = %d,"
				+" driverType = '%s',"
				+" plateNumber = '%s',"
				+" merk = '%s',"
				+" vehicleType='%s'"
				+"WHERE driverId = %d", 
				driver.getIdentityCardNumber(), driver.getName(), driver.getGender(), driver.getPhoneNumber(), driver.getEmail(),
				driver.getDateOfBirth(), driver.getAddress(), driver.getJoinDate(), driver.getOrderCompleted(),
				driverType, driver.getVehicle().getPlateNumber(), driver.getVehicle().getMerk(),
				driver.getVehicle().getType(), id);
		
		con.executeUpdate(query);
				
	}
	
	public void deleteDriverById(int id) {
		String query = String.format("DELETE FROM driver " +
		"WHERE driverId = %d", id);
		
		con.executeUpdate(query);
	}
	
	public void insertDriver(Driver d) {
		String driverType = null;
		
		if(d instanceof MotorDriver) {
			driverType = "Motor Driver";
		} else if(d instanceof CarDriver) {
			driverType = "Car Driver";
		}
		
		String query = String.format("INSERT INTO driver VALUES"
				+ "(NULL,'%s','%s','%s','%s',"
				+ "'%s','%s','%s','%s',"
				+ "%d,'%s','%s',"
				+ "'%s','%s')",
				d.getIdentityCardNumber(), d.getName(), d.getGender(), d.getPhoneNumber(),
				d.getEmail(), d.getDateOfBirth(), d.getAddress(), d.getJoinDate(),
				d.getOrderCompleted(), driverType, d.getVehicle().getPlateNumber(),
				d.getVehicle().getMerk(), d.getVehicle().getType());
		
		con.executeUpdate(query);
	}
	
	public void orderCompleteIncrement(int id) {		
		String query = String.format("UPDATE driver SET " 
				+ "orderComplete = orderComplete + 1 "
				+ "WHERE driverId = %d", id);
		
		con.executeUpdate(query);
	}

}
