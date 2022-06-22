-- -------------------------------------------------------------
-- TablePlus 4.6.8(424)
--
-- https://tableplus.com/
--
-- Database: bojek
-- Generation Time: 2022-06-13 22:50:56.5400
-- -------------------------------------------------------------


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


CREATE TABLE `driver` (
  `driverId` int NOT NULL AUTO_INCREMENT,
  `identityNumber` varchar(16) NOT NULL,
  `name` varchar(50) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `phoneNumber` varchar(13) NOT NULL,
  `email` varchar(100) NOT NULL,
  `dob` varchar(20) NOT NULL,
  `address` varchar(255) NOT NULL,
  `joinDate` varchar(20) NOT NULL,
  `orderComplete` int NOT NULL,
  `driverType` varchar(50) NOT NULL,
  `plateNumber` varchar(20) NOT NULL,
  `merk` varchar(100) NOT NULL,
  `vehicleType` varchar(100) NOT NULL,
  PRIMARY KEY (`driverId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `orders` (
  `orderId` int NOT NULL AUTO_INCREMENT,
  `driverId` int NOT NULL,
  `orderDate` varchar(20) NOT NULL,
  `fee` int NOT NULL,
  `distance` int NOT NULL,
  PRIMARY KEY (`orderId`),
  KEY `driveridFK` (`driverId`),
  CONSTRAINT `driveridFK` FOREIGN KEY (`driverId`) REFERENCES `driver` (`driverId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `driver` (`driverId`, `identityNumber`, `name`, `gender`, `phoneNumber`, `email`, `dob`, `address`, `joinDate`, `orderComplete`, `driverType`, `plateNumber`, `merk`, `vehicleType`) VALUES
(1, '5171012411010001', 'Adi Adnyana', 'Male', '081246868369', 'adiadnyana22@gmail.com', '24/11/2001', 'Jl. Anggrek Cakra', '13/06/2022', 1, 'Motor Driver', 'DK 123 UY', 'Honda', 'Beat'),
(2, '9472047107492684', 'Martin', 'Male', '081234567890', 'martin@gmail.com', '01/01/2001', 'Jl. Bebas', '12/06/2022', 3, 'Car Driver', 'KB 456 AJ', 'Toyota', 'Avanza'),
(3, '4193683508529478', 'Chris', 'Male', '086392376492', 'chris@gmail.com', '02/02/2002', 'Jl. ga tau', '11/06/2022', 0, 'Motor Driver', 'AA 911 BB', 'Honda', 'Supra');

INSERT INTO `orders` (`orderId`, `driverId`, `orderDate`, `fee`, `distance`) VALUES
(2, 2, '13/06/2022', 20000, 3),
(3, 2, '13/06/2022', 50000, 10),
(4, 2, '13/06/2022', 50000, 10),
(5, 2, '13/06/2022', 50000, 10);



/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;