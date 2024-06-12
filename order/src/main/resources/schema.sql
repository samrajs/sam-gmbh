CREATE TABLE IF NOT EXISTS `order` (
  `id` varchar(100)  PRIMARY KEY,
  `email` varchar(100) NOT NULL,
  `order_date` date NOT NULL,
  `created_at` date NOT NULL,
  `created_by` varchar(20) NOT NULL,
  `updated_at` date DEFAULT NULL,
  `updated_by` varchar(20) DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS `lineitem` (
  `id` varchar2(100) PRIMARY KEY,
  `order_id` varchar(100),
  `product_id` varchar(100) NOT NULL,
  `price` number(17,2) NOT NULL,
  `quantity` int NOT NULL,
  `created_at` date NOT NULL,
  `created_by` varchar(20) NOT NULL,
  `updated_at` date DEFAULT NULL,
  `updated_by` varchar(20) DEFAULT NULL
);