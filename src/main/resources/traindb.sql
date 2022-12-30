-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 29, 2022 at 10:33 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT = @@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS = @@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION = @@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `traindb`
--

-- --------------------------------------------------------

--
-- Table structure for table `address`
--

CREATE TABLE `address`
(
    `address_id` int(11)     NOT NULL,
    `user_id`    int(11)     NOT NULL,
    `divison`    varchar(25) NOT NULL,
    `district`   varchar(25) NOT NULL,
    `thana`      varchar(25) NOT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin`
(
    `admin_id`   int(11)      NOT NULL,
    `first_name` varchar(10)  NOT NULL,
    `last_name`  varchar(10)  NOT NULL,
    `email`      varchar(25)  NOT NULL,
    `phone_no`   varchar(11)  NOT NULL,
    `nid`        varchar(15)  NOT NULL,
    `password`   varchar(100) NOT NULL,
    `division`   varchar(15)  NOT NULL,
    `district`   varchar(15)  NOT NULL,
    `thana`      varchar(15)  NOT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `deposite`
--

CREATE TABLE `deposite`
(
    `user_id` int(11) NOT NULL,
    `balance` float   NOT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `route`
--

CREATE TABLE `route`
(
    `route_id`       int(11)     NOT NULL,
    `route_name`     varchar(25) NOT NULL,
    `total_distance` float       NOT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `stations`
--

CREATE TABLE `stations`
(
    `station_id`          int(11)     NOT NULL,
    `route_id`            int(11)     NOT NULL,
    `station_name`        varchar(25) NOT NULL,
    `distance_from_start` float       NOT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

CREATE TABLE `transaction`
(
    `transaction_id`  int(11) NOT NULL,
    `from_station_id` int(11) NOT NULL,
    `to_station_id`   int(11) NOT NULL,
    `user_id`         int(11) NOT NULL,
    `price`           float   NOT NULL,
    `ticket_count`    int(11) NOT NULL,
    `route_id`        int(11) NOT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user`
(
    `user_id`    int(11)      NOT NULL,
    `first_name` varchar(10)  NOT NULL,
    `last_name`  varchar(10)  NOT NULL,
    `email`      varchar(25)  NOT NULL,
    `phone_no`   varchar(10)  NOT NULL,
    `nid`        varchar(15)  NOT NULL,
    `password`   varchar(100) NOT NULL,
    `is_active`  tinyint(1)   NOT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `address`
--
ALTER TABLE `address`
    ADD PRIMARY KEY (`address_id`),
    ADD KEY `FK_user` (`user_id`);

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
    ADD PRIMARY KEY (`admin_id`);

--
-- Indexes for table `deposite`
--
ALTER TABLE `deposite`
    ADD PRIMARY KEY (`user_id`);

--
-- Indexes for table `route`
--
ALTER TABLE `route`
    ADD PRIMARY KEY (`route_id`);

--
-- Indexes for table `stations`
--
ALTER TABLE `stations`
    ADD PRIMARY KEY (`station_id`),
    ADD KEY `FK_route` (`route_id`);

--
-- Indexes for table `transaction`
--
ALTER TABLE `transaction`
    ADD PRIMARY KEY (`transaction_id`),
    ADD KEY `FK_station_from` (`from_station_id`),
    ADD KEY `FK_station_to` (`to_station_id`),
    ADD KEY `FK_user_transaction` (`user_id`),
    ADD KEY `FK_route_transaction` (`route_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
    ADD PRIMARY KEY (`user_id`),
    ADD UNIQUE KEY `email` (`email`),
    ADD UNIQUE KEY `PHONENO` (`phone_no`),
    ADD UNIQUE KEY `nid` (`nid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `address`
--
ALTER TABLE `address`
    MODIFY `address_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
    MODIFY `admin_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `route`
--
ALTER TABLE `route`
    MODIFY `route_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `stations`
--
ALTER TABLE `stations`
    MODIFY `station_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `transaction`
--
ALTER TABLE `transaction`
    MODIFY `transaction_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
    MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `address`
--
ALTER TABLE `address`
    ADD CONSTRAINT `FK_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`);

--
-- Constraints for table `deposite`
--
ALTER TABLE `deposite`
    ADD CONSTRAINT `FK_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`);

--
-- Constraints for table `stations`
--
ALTER TABLE `stations`
    ADD CONSTRAINT `FK_route` FOREIGN KEY (`route_id`) REFERENCES `route` (`route_id`);

--
-- Constraints for table `transaction`
--
ALTER TABLE `transaction`
    ADD CONSTRAINT `FK_route_transaction` FOREIGN KEY (`route_id`) REFERENCES `route` (`route_id`),
    ADD CONSTRAINT `FK_station_from` FOREIGN KEY (`from_station_id`) REFERENCES `stations` (`station_id`),
    ADD CONSTRAINT `FK_station_to` FOREIGN KEY (`to_station_id`) REFERENCES `stations` (`station_id`),
    ADD CONSTRAINT `FK_user_transaction` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT = @OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS = @OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION = @OLD_COLLATION_CONNECTION */;
