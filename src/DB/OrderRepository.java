package DB;

import java.sql.ResultSet;
import java.util.ArrayList;

import Data.Driver;
import Data.DriverFactory;
import Data.Order;
import Data.OrderFactory;
import Data.Vehicle;

public class OrderRepository {
	private Connect con = Connect.getInstance();
	
	public ArrayList<Order> getAllOrder() {
		ArrayList<Order> orderList = new ArrayList<>();
		
		String query = "SELECT od.orderId, od.orderDate, od.fee, od.distance, dr.driverId, dr.identityNumber, dr.name, dr.gender, dr.phoneNumber, dr.email, dr.dob, dr.address, dr.joinDate, dr.orderComplete, dr.driverType, dr.plateNumber, dr.merk, dr.vehicleType  FROM orders od"
				+ " JOIN driver dr ON od.driverId = dr.driverId";
		
		ResultSet rs = con.executeQuery(query);
		
		try {
			while(rs.next()) {
				Driver newDriver = null;
				Vehicle newVehicle = new Vehicle(rs.getString("dr.plateNumber"),rs.getString("dr.merk"),rs.getString("dr.vehicleType"));
				DriverFactory df = new DriverFactory(rs.getString("dr.identityNumber"),rs.getString("dr.name"), rs.getString("dr.gender"),rs.getString("dr.phoneNumber"),rs.getString("dr.email"),rs.getString("dr.dob"),rs.getString("dr.address"),newVehicle);
				
				if(rs.getString("dr.driverType").equals("Motor Driver")) {
					newDriver = df.getMotorDriverForDatabase();
				} else if(rs.getString("dr.driverType").equals("Car Driver")) {
					newDriver = df.getCarDriverForDatabase();
				}
				
				OrderFactory of = new OrderFactory(rs.getInt("od.orderId"), newDriver, rs.getInt("od.fee"), rs.getInt("od.distance"), rs.getString("od.orderDate"));
				orderList.add(of.getOrderForDatabase());
			}
		} catch (Exception e) {
			System.out.println("Something went wrong");
		}
		
		return orderList;
	}
	
	public Order getOrderById(int id) {
		Order orderData = null;
		
		String query = String.format("SELECT od.orderId, od.orderDate, od.fee, od.distance, dr.driverId, dr.identityNumber, dr.name, dr.gender, dr.phoneNumber, dr.email, dr.dob, dr.address, dr.joinDate, dr.orderComplete, dr.driverType, dr.plateNumber, dr.merk, dr.vehicleType  FROM orders od JOIN driver dr ON od.driverId = dr.driverId "
				+ "WHERE od.orderId = %d",id);
		
		ResultSet rs = con.executeQuery(query);
		
		try {
			while(rs.next()) {
				Driver newDriver = null;
				Vehicle newVehicle = new Vehicle(rs.getString("dr.plateNumber"),rs.getString("dr.merk"),rs.getString("dr.vehicleType"));
				DriverFactory df = new DriverFactory(rs.getString("dr.identityNumber"),rs.getString("dr.name"), rs.getString("dr.gender"),rs.getString("dr.phoneNumber"),rs.getString("dr.email"),rs.getString("dr.dob"),rs.getString("dr.address"),newVehicle);
				
				if(rs.getString("dr.vehicleType").equals("Motor Driver")) {
					newDriver = df.getMotorDriverForDatabase();
				} else if(rs.getString("dr.vehicleType").equals("Car Driver")) {
					newDriver = df.getCarDriverForDatabase();
				}
				
				OrderFactory of = new OrderFactory(rs.getInt("od.orderId"), newDriver, rs.getInt("od.fee"), rs.getInt("od.distance"), rs.getString("od.orderDate"));
				orderData = of.getOrderForDatabase();
			}
		} catch (Exception e) {
			System.out.println("Something went wrong");
		}
		
		return orderData;
	}
	
	public void insertOrder(int driverId, String orderDate, int fee, int distance) {
		String query = String.format("INSERT INTO orders (orderId, driverId, orderDate, fee, distance) "
				+ "VALUES (NULL, %d, '%s', %d, %d)", driverId, orderDate, fee, distance);
		
		try {
			con.executeUpdate(query);
		} catch (Exception e) {
			System.out.println("Something went wrong");
		}
	}

}
