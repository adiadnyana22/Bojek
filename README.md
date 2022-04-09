# Bojek (Kasus Aplikasi Pemesanan Driver)

## Tugas Pra UTS Object Oriented Programming

Anggota:
- Christoper Lim (2440026591)
- Martin (2440032663)
- Made Ade Adnyana (2440042550)

### Deskripsi Kasus :
BOJEK merupakan sebuah aplikasi pemesanan driver online. Aplikasi ini dapat digunakan untuk memesan driver secara online dimanapun dan kapanpun. Terdapat 2 jenis driver yang disediakan aplikasi yaitu, Motor Driver dan Car Driver. Motor driver adalah driver yang menggunakan motor dimana hanya dapat menerima 1 penumpang setiap Order. Car Driver adalah driver yang menggunakan kendaraan mobil beroda empat dimana dapat membawa penumpang lebih dari satu hingga 5 orang setiap Order. Aplikasi digunakan untuk Driver dan pelanggan. Untuk driver ialah dapat mendaftar sebagai driver dengan mengisi informasi-informasi yang dibutuhkan. Untuk pelanggan ialah dapat memesan driver dengan pilihan yang tersedia yaitu MotorDriver dan CarDriver. Pemilihan Driver akan dilakukan secara acak oleh system. Tujuan dari aplikasi BOJEK adalah menyediakan platform bagi pengguna yang dapat digunakan kapanpun dan dimanapun dalam menyediakan transportasi baik perorangan maupun kelompok. Aplikasi ini juga menjadi perantara terpercaya antara Driver dan Pengguna yang ingin dapat memesan driver/ojek.

### Class Analysis :
#### Relationship :
- Driver dan DriverList memiliki relationship Aggregation dikarenakan DriverList akan menyimpan List dari Driver dan kita tidak dapat membalikkan relasi dari kedua kelas tersebut. DriverList berupa kumpulan-kumpulan Driver.
- CarDriver dan MotorDriver merupakan Inheritance dari Driver. Hal ini dibuktikan dari menggunakan extends Driver yang terdapat pada Class Car Driver dan Motor Driver dan juga CarDriver dan MotorDriver. MotorDriver dan CarDriver keduanya adalah pengemudi/Driver namun memiliki tipe yang berbeda dengan MotorDriver menggunakan motor sedangkan CarDriver menggunakan mobil namun sama-sama Driver sehingga merupakan inherintance dari Driver karena sama-sama driver namun akan memiliki tambahan atribut sebagai keunikan satu sama lain.
- Vehicle dan driver memiliki relationship Composition dikarenakan saat driver mendaftar pada Bojek, kendaraan juga didaftarkan sebagai milik pribadi dari driver tersebut dimana bila driver tersebut sudah tidak bekerja di Bojek lagi maka kendaraannya juga sudah tidak ada lagi di Bojek karena milik Driver tersebut.
- Order dan OrderList memiliki relationship Aggregation dikarenakan OrderList akan menyimpan List dari Order dan kita tidak dapat membalikkan relasi dari kedua kelas tersebut. OrderList berupa kumpulan-kumpulan Order.
- Order dan Driver memiliki relationship Aggregation dikarenakan tanpa adanya Order, Driver masih memiliki data driver tersebut. Sedangkan Order hanya menyimpan data mengenai driver tersebut.

#### Class Field & Method :
**Driver**<br />
Fields:
- id : String
- identityCardNumber : String
- name : String
- gender : String
- phoneNumber : String
- email : String
- address : String
- joinDate : String
- orderComplete : int
- vehicle : Vehicle

Methods:
+ getId() : String
+ getName() : String
+ setName(name : String)
+ getGender() : String
+ setGender(gender : String)
+ getPhoneNumber() : String
+ setPhoneNumber(phoneNumber : String)
+ getEmail() : String
+ setEmail(email : String)
+ getDateOfBirth() : String
+ setDateOfBrith(dateOfBirth : String)
+ getAddress() : String
+ setAddress(address : String) 
+ getJoinDate() : String
+ setJoinDate(joinDate : String) 
+ getOrderCompleted() : int
+ setOrderCompleted(orderCompleted : int)
+ getVehicle() : Vehicle
+ getIdentityCardNumber() : String

**Vehicle**<br />
Fields:
- plateNumber : String
- merk : String
- type : String

Methods:
+ getPlateNumber() : String
+ getMerk() : String
+ getType() : String
+ setPlateNumber(plateNumber : String)
+ setMerk(merk : String)
+ setType(type : String)


**MotorDriver**<br />
Methods:
+ calculateFee(distance : int) : int

**CarDriver**<br />
Methods:
+ calculateFee(distance : int) : int

**DriverList**<br />
Fields: 
- driverList : ArrayList<Driver>

Methods:
+ addDriver(newDriver : Driver)
+ showAllDriver()
+ showMotorDriver()
+ showCarDriver()
+ updateDriver(driverId : String, name : String, email : String, address : String)
+ updateVehicle(index : int, plateNumber : String, merk : String, type : String)
+ deleteDriver(driverId : String)
+ searchDriver(driverId : String)
+ getRandomMotorDriver() : Driver
+ getRandomCarDriver() : Driver

**Order**<br />
Fields:
- orderId : String
- orderDate : String
- fee : int
- distance : int
- driver : Driver

Methods:
+ getOrderId() : String
+ getOrderDate() : String
+ getFee() : int
+ getDistance() : int
+ getDriver() : Driver

**OrderList**<br />
Fields:
- orderList : ArrayList<Order>

Methods:
+ acceptOrder(Driver : driver, customerName : String, distance : int) : void
+ showOrder() : void


### Class Diagram :
![alt text](https://github.com/adiadnyana22/Bojek/blob/master/ClassDiagram.png?raw=true)

### Pembagian Tugas :
| No   | Nama Anggota                    | Tugas yang dikerjakan                                    |
| ---- | ------------------------------- | -------------------------------------------------------- |
| 1.   | Christoper Lim - 2440026591     | Kodingan, Deskripsi Kasus, Class Diagram, Analisa Kelas  |
| 2.   | Martin - 2440032663             | Kodingan, Deskripsi Kasus, Class Diagram, Analisa Kelas  |
| 3.   | Made Adi Adnyana - 2440042550   | Kodingan, Deskripsi Kasus, Class Diagram, Analisa Kelas  |
