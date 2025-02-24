CREATE TABLE IF NOT EXISTS `books` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `author` varchar(255) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `genre` varchar(255) DEFAULT NULL,
  `isbn` varchar(255) DEFAULT NULL,
  `language` varchar(255) DEFAULT NULL,
  `pages` int DEFAULT NULL,
  `publication_year` int DEFAULT NULL,
  `publisher` varchar(255) DEFAULT NULL,
  `summary` varchar(1000) DEFAULT NULL,
  `title` varchar(255) NOT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKkibbepcitr0a3cpk3rfr7nihn` (`isbn`)
)