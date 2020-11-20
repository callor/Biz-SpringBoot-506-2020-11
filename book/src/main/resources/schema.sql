CREATE TABLE IF NOT EXISTS `tbl_book` (
   `id` bigint NOT NULL AUTO_INCREMENT,
   `author` varchar(30) DEFAULT NULL,
   `comp` varchar(125) DEFAULT NULL,
   `price` int DEFAULT NULL,
   `str_name` varchar(255) DEFAULT NULL,
   `title` varchar(125) DEFAULT NULL,
   PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ;