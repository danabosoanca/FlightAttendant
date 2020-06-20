-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 20, 2020 at 03:32 PM
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
-- Table structure for table `zboruritest`
--

CREATE TABLE `zboruritest` (
  `id_zbor` int(11) NOT NULL,
  `oras_de_plecare` varchar(30) NOT NULL,
  `destinatie` varchar(30) NOT NULL,
  `ora_imbarcare` time NOT NULL,
  `data_imbarcare` date NOT NULL,
  `durata` int(11) NOT NULL,
  `locuri_disp` int(11) NOT NULL,
  `pret_bilet` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `zboruritest`
--

INSERT INTO `zboruritest` (`id_zbor`, `oras_de_plecare`, `destinatie`, `ora_imbarcare`, `data_imbarcare`, `durata`, `locuri_disp`, `pret_bilet`) VALUES
(1, 'test', 'test', '00:00:00', '2020-06-20', 100, 100000, 10),
(8, 'bla', 'bla', '06:06:00', '2020-12-24', 80, 80, 80);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `zboruritest`
--
ALTER TABLE `zboruritest`
  ADD UNIQUE KEY `id_zbor` (`id_zbor`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `zboruritest`
--
ALTER TABLE `zboruritest`
  MODIFY `id_zbor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
