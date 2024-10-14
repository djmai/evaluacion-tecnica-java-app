-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: castores_db
-- ------------------------------------------------------
-- Server version	5.7.33

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping data for table `movimientos`
--

LOCK TABLES `movimientos` WRITE;
/*!40000 ALTER TABLE `movimientos` DISABLE KEYS */;
INSERT INTO `movimientos` VALUES (1,1,1,'entrada',50,'2024-10-01 16:00:00'),(2,2,2,'entrada',30,'2024-10-01 17:00:00'),(3,3,1,'entrada',20,'2024-10-02 18:00:00'),(4,5,2,'entrada',15,'2024-10-03 20:00:00'),(5,1,1,'salida',5,'2024-10-04 15:00:00'),(6,2,2,'salida',2,'2024-10-04 21:00:00'),(78,29,3,'salida',13,'2024-09-15 07:43:29'),(79,11,2,'entrada',3,'2024-09-30 07:43:29'),(80,25,2,'salida',8,'2024-10-08 07:43:29'),(81,18,2,'entrada',2,'2024-10-06 07:43:29'),(82,20,3,'salida',17,'2024-10-02 07:43:29'),(83,15,1,'salida',6,'2024-09-21 07:43:29'),(84,7,1,'salida',17,'2024-09-29 07:43:29'),(85,5,1,'entrada',7,'2024-10-10 07:43:29'),(86,25,1,'salida',4,'2024-09-21 07:43:29'),(87,20,2,'salida',8,'2024-09-14 07:43:29'),(88,14,1,'entrada',10,'2024-09-23 07:43:29'),(89,19,2,'entrada',7,'2024-10-13 07:43:29'),(90,13,3,'salida',16,'2024-10-05 07:43:29'),(91,19,2,'salida',13,'2024-09-22 07:43:29'),(92,24,1,'entrada',10,'2024-10-12 07:43:29'),(93,11,3,'salida',9,'2024-09-24 07:43:29'),(94,25,2,'salida',13,'2024-10-12 07:43:29'),(95,22,2,'entrada',1,'2024-10-05 07:43:29'),(96,28,3,'salida',17,'2024-10-01 07:43:29'),(97,7,1,'salida',5,'2024-09-29 07:43:29'),(98,1,1,'entrada',1,'2024-10-14 04:56:54'),(99,1,1,'entrada',1,'2024-10-14 06:01:21'),(100,1,1,'salida',1,'2024-10-14 06:02:37'),(101,1,1,'salida',10,'2024-10-14 06:03:21'),(102,1,1,'entrada',10,'2024-10-14 07:47:18'),(103,1,2,'salida',100,'2024-10-14 07:49:50'),(104,6,1,'entrada',10,'2024-10-14 19:04:49'),(105,33,1,'entrada',100,'2024-10-14 19:05:07');
/*!40000 ALTER TABLE `movimientos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `permisos`
--

LOCK TABLES `permisos` WRITE;
/*!40000 ALTER TABLE `permisos` DISABLE KEYS */;
INSERT INTO `permisos` VALUES (1,'Ver módulo inventario'),(2,'Agregar nuevos productos'),(3,'Aumentar inventario'),(4,'Dar de baja/reactivar un producto'),(5,'Ver módulo para Salida de productos'),(6,'Sacar inventario del almacén'),(7,'Ver módulo del histórico');
/*!40000 ALTER TABLE `permisos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES (1,'Zapato Deportivo','Zapato para deportes',31,'inactivo'),(2,'Bolso de Mano','Bolso casual para uso diario',30,'activo'),(3,'Cinturón de Cuero','Cinturón de cuero genuino',20,'activo'),(4,'Gorra','Gorra casual para el día a día',10,'inactivo'),(5,'Camisa Formal','Camisa de vestir',15,'activo'),(6,'Zapato De Lujo','Descripción del zapato de lujo para uso especial.',16,'inactivo'),(7,'Camisa Vintage','Descripción del camisa vintage para uso ocasional.',74,'activo'),(8,'Cinturón De Cuero','Descripción del cinturón de cuero para uso diario.',12,'inactivo'),(9,'Reloj Elegante','Descripción del reloj elegante para uso ocasional.',95,'activo'),(10,'Camisa De Cuero','Descripción del camisa de cuero para uso ocasional.',40,'activo'),(11,'Camisa Elegante','Descripción del camisa elegante para uso especial.',32,'inactivo'),(12,'Cinturón Vintage','Descripción del cinturón vintage para uso ocasional.',53,'inactivo'),(13,'Bolso Moderno','Descripción del bolso moderno para uso ocasional.',35,'activo'),(14,'Sombrero Vintage','Descripción del sombrero vintage para uso diario.',24,'activo'),(15,'Sombrero Casual','Descripción del sombrero casual para uso diario.',85,'inactivo'),(16,'Gorra Vintage','Descripción del gorra vintage para uso diario.',7,'activo'),(17,'Zapato De Lujo','Descripción del zapato de lujo para uso ocasional.',92,'activo'),(18,'Pantalón Elegante','Descripción del pantalón elegante para uso diario.',74,'inactivo'),(19,'Bolso Clásico','Descripción del bolso clásico para uso ocasional.',10,'activo'),(20,'Anillo Casual','Descripción del anillo casual para uso ocasional.',76,'inactivo'),(21,'Bolso De Cuero','Descripción del bolso de cuero para uso ocasional.',41,'activo'),(22,'Reloj De Cuero','Descripción del reloj de cuero para uso diario.',18,'inactivo'),(23,'Anillo De Lujo','Descripción del anillo de lujo para uso especial.',48,'inactivo'),(24,'Pantalón De Seda','Descripción del pantalón de seda para uso diario.',1,'activo'),(25,'Cinturón Vintage','Descripción del cinturón vintage para uso especial.',17,'activo'),(26,'Zapato Moderno','Descripción del zapato moderno para uso diario.',36,'activo'),(27,'Pantalón De Lujo','Descripción del pantalón de lujo para uso diario.',6,'activo'),(28,'Gorra Clásico','Descripción del gorra clásico para uso especial.',40,'activo'),(29,'Bufanda De Lujo','Descripción del bufanda de lujo para uso especial.',38,'activo'),(30,'Sombrero De Cuero','Descripción del sombrero de cuero para uso diario.',3,'activo'),(31,'Pantalón Formal','Descripción del pantalón formal para uso especial.',65,'activo'),(32,'Blusa De Lujo','Descripcion de la blusa de lujo',0,'activo'),(33,'Camisa manga larga de lujo','Descripcion de camisa manga larga de lujo',100,'activo'),(34,'Nuevo producto nuevo','AquÃ­ va la descripciÃ³n del producto',0,'activo');
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `rol_permisos`
--

LOCK TABLES `rol_permisos` WRITE;
/*!40000 ALTER TABLE `rol_permisos` DISABLE KEYS */;
INSERT INTO `rol_permisos` VALUES (1,1),(2,1),(1,2),(1,3),(1,4),(2,5),(2,6),(1,7);
/*!40000 ALTER TABLE `rol_permisos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'admin'),(2,'almacenista');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'Juan Pérez','juan.perez@empresa.com','password123',1,'activo'),(2,'Ana Gómez','ana.gomez@empresa.com','password456',2,'activo'),(3,'Carlos Ruiz','carlos.ruiz@empresa.com','password789',2,'inactivo'),(4,'Prueba 1','prueba1@gmail.com','123456',2,'activo');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-10-14 12:43:12
