-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 25, 2022 at 06:07 PM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 8.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sdn_sales_management`
--

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `id` int(11) NOT NULL,
  `cat_name` varchar(50) NOT NULL,
  `length` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `customer_info`
--

CREATE TABLE `customer_info` (
  `id` int(10) NOT NULL,
  `comp_name` varchar(200) NOT NULL,
  `own_name` varchar(150) NOT NULL,
  `comp_address` varchar(250) NOT NULL,
  `phone` varchar(15) NOT NULL,
  `password` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `items`
--

CREATE TABLE `items` (
  `id` int(11) NOT NULL,
  `item_cat` int(11) NOT NULL,
  `Name` varchar(100) NOT NULL,
  `img` varchar(150) NOT NULL,
  `price` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `item_stock`
--

CREATE TABLE `item_stock` (
  `item_cat_id` int(11) NOT NULL,
  `item_id` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `unit` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `purchase_details`
--

CREATE TABLE `purchase_details` (
  `pur_id` int(11) NOT NULL,
  `item_cat_id` int(11) NOT NULL,
  `item_id` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `price_per_unit` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `purchase_invoice`
--

CREATE TABLE `purchase_invoice` (
  `pur_id` int(11) NOT NULL,
  `sup_id` int(11) NOT NULL,
  `total_amount` int(11) NOT NULL,
  `remark` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `sale_details`
--

CREATE TABLE `sale_details` (
  `sale_id` int(11) NOT NULL,
  `item_cat` int(11) NOT NULL,
  `item_id` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `pri_per_unit` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `sale_invoice`
--

CREATE TABLE `sale_invoice` (
  `sale_id` int(11) NOT NULL,
  `customer_id` int(11) NOT NULL,
  `total_price` int(11) NOT NULL,
  `remark` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `supplier_info`
--

CREATE TABLE `supplier_info` (
  `sup_id` int(11) NOT NULL,
  `name` int(11) NOT NULL,
  `address` int(11) NOT NULL,
  `phone` int(11) NOT NULL,
  `img` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `customer_info`
--
ALTER TABLE `customer_info`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `items`
--
ALTER TABLE `items`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_it_cat_id` (`item_cat`);

--
-- Indexes for table `item_stock`
--
ALTER TABLE `item_stock`
  ADD KEY `fk_itstk_cat_id` (`item_cat_id`),
  ADD KEY `fk_itstk_it_id` (`item_id`);

--
-- Indexes for table `purchase_details`
--
ALTER TABLE `purchase_details`
  ADD KEY `pur_id` (`pur_id`),
  ADD KEY `item_cat_id` (`item_cat_id`),
  ADD KEY `item_id` (`item_id`);

--
-- Indexes for table `purchase_invoice`
--
ALTER TABLE `purchase_invoice`
  ADD PRIMARY KEY (`pur_id`),
  ADD KEY `fk_pi_supid` (`sup_id`);

--
-- Indexes for table `sale_invoice`
--
ALTER TABLE `sale_invoice`
  ADD PRIMARY KEY (`sale_id`),
  ADD KEY `customer_id` (`customer_id`);

--
-- Indexes for table `supplier_info`
--
ALTER TABLE `supplier_info`
  ADD PRIMARY KEY (`sup_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `items`
--
ALTER TABLE `items`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `purchase_invoice`
--
ALTER TABLE `purchase_invoice`
  MODIFY `pur_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `sale_invoice`
--
ALTER TABLE `sale_invoice`
  MODIFY `sale_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `supplier_info`
--
ALTER TABLE `supplier_info`
  MODIFY `sup_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `items`
--
ALTER TABLE `items`
  ADD CONSTRAINT `fk_it_cat_id` FOREIGN KEY (`item_cat`) REFERENCES `category` (`id`) ON UPDATE CASCADE;

--
-- Constraints for table `item_stock`
--
ALTER TABLE `item_stock`
  ADD CONSTRAINT `fk_itstk_cat_id` FOREIGN KEY (`item_cat_id`) REFERENCES `category` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_itstk_it_id` FOREIGN KEY (`item_id`) REFERENCES `items` (`id`) ON UPDATE CASCADE;

--
-- Constraints for table `purchase_details`
--
ALTER TABLE `purchase_details`
  ADD CONSTRAINT `purchase_details_ibfk_1` FOREIGN KEY (`pur_id`) REFERENCES `purchase_invoice` (`pur_id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `purchase_details_ibfk_2` FOREIGN KEY (`item_cat_id`) REFERENCES `category` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `purchase_details_ibfk_3` FOREIGN KEY (`item_id`) REFERENCES `items` (`id`) ON UPDATE CASCADE;

--
-- Constraints for table `purchase_invoice`
--
ALTER TABLE `purchase_invoice`
  ADD CONSTRAINT `fk_pi_supid` FOREIGN KEY (`sup_id`) REFERENCES `supplier_info` (`sup_id`) ON UPDATE CASCADE;

--
-- Constraints for table `sale_invoice`
--
ALTER TABLE `sale_invoice`
  ADD CONSTRAINT `sale_invoice_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `cutomer_info` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `sale_invoice_ibfk_2` FOREIGN KEY (`customer_id`) REFERENCES `customer_info` (`id`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
