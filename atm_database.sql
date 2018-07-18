-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Aug 03, 2016 at 08:26 PM
-- Server version: 10.1.13-MariaDB
-- PHP Version: 5.5.35

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `atm`
--
CREATE DATABASE IF NOT EXISTS `atm` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE `atm`;

-- --------------------------------------------------------

--
-- Table structure for table `deposit`
--

CREATE TABLE `deposit` (
  `id_deposit` int(11) NOT NULL,
  `amount` double NOT NULL,
  `date_deposit` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `id_user` int(11) NOT NULL,
  `action` varchar(25) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


--
-- Table structure for table `transfer`
--

CREATE TABLE `transfer` (
  `id_transfer` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `transfer_code` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `transfer_date` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `amount` double NOT NULL,
  `received` enum('YES','NO') COLLATE utf8_unicode_ci NOT NULL,
  `action` varchar(25) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


--
-- Table structure for table `transfer_phone`
--

CREATE TABLE `transfer_phone` (
  `id_transfer_phone` int(11) NOT NULL,
  `code_transfer` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `date_transfer` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `amount` double NOT NULL,
  `phone_number` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `received` varchar(3) COLLATE utf8_unicode_ci NOT NULL,
  `id_user` int(11) NOT NULL,
  `action` varchar(25) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


--
-- Table structure for table `user_account`
--

CREATE TABLE `user_account` (
  `id_user` int(11) NOT NULL,
  `name` varchar(25) COLLATE utf8_unicode_ci NOT NULL,
  `card_number` varchar(5) COLLATE utf8_unicode_ci NOT NULL,
  `pin_code` varchar(4) COLLATE utf8_unicode_ci NOT NULL,
  `balance` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `user_account`
--

INSERT INTO `user_account` (`id_user`, `name`, `card_number`, `pin_code`, `balance`) VALUES
(1, 'MUTOMBO', 'cn007', '1234', 4000),
(2, 'SAMSON', 'cn001', '0000', 4000),
(3, 'NATHALIE', 'cn002', '1010', 4000),
(4, 'SAMUEL', 'cn445', '1290', 4000);

-- --------------------------------------------------------

--
-- Table structure for table `withdraw`
--

CREATE TABLE `withdraw` (
  `id_withdraw` int(11) NOT NULL,
  `amount` double NOT NULL,
  `date_withdraw` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `id_user` int(11) NOT NULL,
  `action` varchar(25) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


--
-- Indexes for table `deposit`
--

ALTER TABLE `deposit`
  ADD PRIMARY KEY (`id_deposit`),
  ADD KEY `id_user` (`id_user`);

--
-- Indexes for table `transfer`
--
ALTER TABLE `transfer`
  ADD PRIMARY KEY (`id_transfer`),
  ADD KEY `id_user` (`id_user`);

--
-- Indexes for table `transfer_phone`
--
ALTER TABLE `transfer_phone`
  ADD PRIMARY KEY (`id_transfer_phone`),
  ADD KEY `id_user` (`id_user`);

--
-- Indexes for table `user_account`
--
ALTER TABLE `user_account`
  ADD PRIMARY KEY (`id_user`);

--
-- Indexes for table `withdraw`
--
ALTER TABLE `withdraw`
  ADD PRIMARY KEY (`id_withdraw`),
  ADD KEY `id_user` (`id_user`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `deposit`
--
ALTER TABLE `deposit`
  MODIFY `id_deposit` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `transfer`
--
ALTER TABLE `transfer`
  MODIFY `id_transfer` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `transfer_phone`
--
ALTER TABLE `transfer_phone`
  MODIFY `id_transfer_phone` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `user_account`
--
ALTER TABLE `user_account`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `withdraw`
--
ALTER TABLE `withdraw`
  MODIFY `id_withdraw` int(11) NOT NULL AUTO_INCREMENT;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `deposit`
--
ALTER TABLE `deposit`
  ADD CONSTRAINT `deposit_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user_account` (`id_user`);

--
-- Constraints for table `transfer`
--
ALTER TABLE `transfer`
  ADD CONSTRAINT `id_user` FOREIGN KEY (`id_user`) REFERENCES `user_account` (`id_user`);

--
-- Constraints for table `transfer_phone`
--
ALTER TABLE `transfer_phone`
  ADD CONSTRAINT `transfer_phone_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user_account` (`id_user`);

--
-- Constraints for table `withdraw`
--
ALTER TABLE `withdraw`
  ADD CONSTRAINT `withdraw_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user_account` (`id_user`);
