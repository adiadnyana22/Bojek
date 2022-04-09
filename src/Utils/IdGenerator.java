package Utils;

public class IdGenerator {
	public String generateIdDriver() {
		return "" + (int) Math.floor(Math.random() * 10) + (int)  Math.floor(Math.random() * 10) + (int)  Math.floor(Math.random() * 10) + (int) Math.floor(Math.random() * 10) + (int) Math.floor(Math.random() * 10);
	}
	
	public String generateIdOrder() {
		return "" + (int) Math.floor(Math.random() * 10) + (int) Math.floor(Math.random() * 10) + (int) Math.floor(Math.random() * 10);
	}
}
