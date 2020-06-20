-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 19, 2020 at 05:05 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.2.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `facultate`
--

-- --------------------------------------------------------

--
-- Table structure for table `utilizatoritest`
--

CREATE TABLE `utilizatoritest` (
  `nume` varchar(35) NOT NULL,
  `adresa` varchar(40) NOT NULL,
  `telefon` varchar(10) NOT NULL,
  `membru` tinyint(4) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(120) NOT NULL,
  `id_utilizator` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `utilizatoritest`
--

INSERT INTO `utilizatoritest` (`nume`, `adresa`, `telefon`, `membru`, `username`, `password`, `id_utilizator`) VALUES
('test', 'test', '000000000', 1, 'test', '098f6bcd4621d373cade4e832627b4f6', 1),
('test', 'test', '000000000', 1, 'test', '098f6bcd4621d373cade4e832627b4f6', 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `utilizatoritest`
--
ALTER TABLE `utilizatoritest`
  ADD PRIMARY KEY (`id_utilizator`),
  ADD UNIQUE KEY `id_utilizator` (`id_utilizator`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `utilizatoritest`
--
ALTER TABLE `utilizatoritest`
  MODIFY `id_utilizator` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
