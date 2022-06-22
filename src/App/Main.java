package App;

import java.util.Scanner;

public class Main {
	
//	Kasus :
//	Bojek merupakan aplikasi management dan pemesanan ojek
//	Aplikasi Bojek memiliki 2 pilihan menu utama yaitu Manage Driver dan Manage Order
//	
//	Menu Manage Driver berisi pilihan menu terkait tata kelola data driver,
//	baik itu penambahan, menampilkan, mengubah, dan menghapus data driver
//	
//	Menu Manage Order berisi pilihan menu terkait pembuatan pesanan (menambah data order) dan menampilkan data order
//	Pemesanan dilakukan dengan memilih secara acak driver yang sesuai (Motor / Car)
	
	
//	Implementasi OOP & Design Patern :
//	Inheritance :
//		- Superclass : Driver
//		- Subclass : CarDriver & MotorDriver
//	Dikarenakan adanya 2 pilihan tipe driver yang bisa dipesan dimana keduanya memiliki mayoritas karakteristik yang sama,
//	maka dibuatkanlah inheritance class Driver yang memiliki anak CarDriver dan MotorDriver sebagai pilihan tipe driver yang tersedia
//	
//	Abstract & Polymorphism :
//		- Abtract Method calculateFee pada class Driver
//	Dikarenakan adanya perbedaan cara penghitungan biaya yang tergantung dari tipe driver maka dibuatkanlah abstract method pada class Driver
//	yang kemudian di override dengan cara perhitungan tersendiri oleh subclassnya yaitu CarDriver dan MotorDriver
//	
//	Encapsulation :
//	Semua atribut class data (Driver, CarDriver, MotorDriver, Vehicle, Order) menggunakan access modifier private
//	yang menggunakan method getter setter untuk mengakses dan mengubah nilai dari atribut yang ada sehingga meminimalisir kesalahan perubahan nilai
	
//	Singleton :
//		- Singleton Class : Connect (access method getInstance())
//	Penggunaan singleton pada class Connect dibuat agar hanya ada 1 objek yang digunakan untuk mengakses ke database dengan begitu traffic ke database akan minim
//	Class Connect hanya dapat digunakan dengan mengakses method getInstance saja karena constructor yang ada dibuat private
//	sehingga pembuatan objek Connect harus melalui method getInstance
//	
//	Factory :
//		- Factory Class : DriverFactory (get CarDriver or MotorDriver object) & OrderFactory (get Order object)
//	Pembuatan object driver sepenuhnya diatur oleh DriverFactory sehingga mekanisme pembuatan object akan lebih teratur
	
	
//	Database :
//	DBMS yang digunakan adalah MySQL dengan nama database "bojek"
//	Semua class terkait database berada di package "DB" dimana class koneksinya adalah class Connect
//	Terkait operasi query pada database dan pengelolaan data yang diterima dari database terdapat pada DriverRepository & OrderRepository
//	dimana DriverRepository mengelola data dan query terkait Driver dan OrderRepository mengelola data dan query terkait Order
	

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
