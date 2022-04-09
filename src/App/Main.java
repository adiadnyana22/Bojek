package App;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DriverMenu driverMenu = new DriverMenu();
		OrderMenu orderMenu = new OrderMenu();
		
		int pilihanMenu = 0;
		do {
			System.out.println("Bojek Management App");
			System.out.println("--------------------\n");
			System.out.println("1. Manage Driver");
			System.out.println("2. Manage Order");
			System.out.println("3. Exit");
			System.out.print(">> ");
			pilihanMenu = sc.nextInt();
			sc.nextLine();
			
			if(pilihanMenu == 1) driverMenu.run();
			else if(pilihanMenu == 2) orderMenu.run();
			else if(pilihanMenu == 3) System.out.println("Thank You !");
		} while(pilihanMenu != 3);
		
		sc.close();
	}

}
