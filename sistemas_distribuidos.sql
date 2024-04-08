/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

CREATE TABLE `cliente` (
  `id` int NOT NULL AUTO_INCREMENT,
  `apellido` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_cmxo70m08n43599l3h0h07cc6` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `producto` (
  `id` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  `imagen` varchar(255) DEFAULT NULL,
  `precio` float NOT NULL,
  `stock` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `usuario` (
  `id` int NOT NULL AUTO_INCREMENT,
  `apellido` varchar(255) DEFAULT NULL,
  `contraseña` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `is_admin` bit(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_5171l57faosmj8myawaucatdw` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `cliente` (`id`, `apellido`, `email`, `nombre`, `telefono`) VALUES
(1, 'rodriguez', 'roberto@correo.com', 'roberto', '987654321');
INSERT INTO `cliente` (`id`, `apellido`, `email`, `nombre`, `telefono`) VALUES
(5, 'martinez', 'maria@correo.com', 'maria', '987654321');
INSERT INTO `cliente` (`id`, `apellido`, `email`, `nombre`, `telefono`) VALUES
(7, 'martinez', 'pedro@correo.com', 'pedro', '987654321');
INSERT INTO `cliente` (`id`, `apellido`, `email`, `nombre`, `telefono`) VALUES
(10, 'martinez', 'marta@correo.com', 'marta', '987654321'),
(11, 'correa', 'natalia@correo.com', 'natalia', '987654321'),
(13, 'francesca', 'noemi@correo.com', 'noemi', '987654321'),
(15, 'francesca', 'noemi1@correo.com', 'noemi', '987654321');

INSERT INTO `producto` (`id`, `descripcion`, `imagen`, `precio`, `stock`) VALUES
(1, 'paneton', 'imagen1.jpg', 15.5, 30);
INSERT INTO `producto` (`id`, `descripcion`, `imagen`, `precio`, `stock`) VALUES
(2, 'chocolate', 'imagen2.jpg', 8.5, 40);
INSERT INTO `producto` (`id`, `descripcion`, `imagen`, `precio`, `stock`) VALUES
(3, 'mayonesa', 'imagen3.jpg', 9.5, 25);
INSERT INTO `producto` (`id`, `descripcion`, `imagen`, `precio`, `stock`) VALUES
(4, 'carne', 'imagen4.jpg', 7.6, 36),
(6, 'sal', 'imagen6.jpg', 2.4, 25),
(7, 'sal', 'imagen6.jpg', 0, 25);

INSERT INTO `usuario` (`id`, `apellido`, `contraseña`, `email`, `nombre`, `is_admin`) VALUES
(11, 'Mendoza', '$2a$10$yDtbr0p5d0txkmgs.1vu7O2IyIT/5kPJVg0aBJfsQl1zqVbeh5IJS', 'daniel@correo.com', 'Daniel', 1);
INSERT INTO `usuario` (`id`, `apellido`, `contraseña`, `email`, `nombre`, `is_admin`) VALUES
(12, 'Perez', '$2a$10$F2rUaLYf3VGR6YCIp17BL.uZji1pveovouWb4quM2fjBEESfjMDDy', 'juan@correo.com', 'Juan', 0);
INSERT INTO `usuario` (`id`, `apellido`, `contraseña`, `email`, `nombre`, `is_admin`) VALUES
(13, 'Perez', '$2a$10$XAOYcIH05sqI.4R0Y8G3Q..1.SdcBJyfxr7RZq6QmQwTj3LtHOQCC', 'juanito@correo.com', 'Juan', 0);
INSERT INTO `usuario` (`id`, `apellido`, `contraseña`, `email`, `nombre`, `is_admin`) VALUES
(14, 'Perez', '$2a$10$fz/c4c5YtJwxtNyr2imF1.WJ2wUXtETEO8RmzUlUJNj7rzv0JCdTW', 'ana@correo.com', 'Ana', 0);


/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
