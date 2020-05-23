-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Gazdă: 127.0.0.1
-- Timp de generare: mai 05, 2020 la 04:18 PM
-- Versiune server: 10.4.11-MariaDB
-- Versiune PHP: 7.2.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Bază de date: `facultate`
--

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `zboruri`
--

CREATE TABLE `zboruri` (
  `id_zbor` int(11) NOT NULL,
  `oras_de_plecare` varchar(20) NOT NULL,
  `destinatie` varchar(20) NOT NULL,
  `ora_imbarcare` time NOT NULL,
  `data_imbarcare` date NOT NULL,
  `durata` int(11) NOT NULL,
  `locuri_disp` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Eliminarea datelor din tabel `zboruri`
--

INSERT INTO `zboruri` (`id_zbor`, `oras_de_plecare`, `destinatie`, `ora_imbarcare`, `data_imbarcare`, `durata`, `locuri_disp`) VALUES
(1, 'test', 'test', '22:43:00', '2020-05-06', 100, 100);

--
-- Indexuri pentru tabele eliminate
--

--
-- Indexuri pentru tabele `zboruri`
--
ALTER TABLE `zboruri`
  ADD PRIMARY KEY (`id_zbor`),
  ADD UNIQUE KEY `id_zbor` (`id_zbor`);

--
-- AUTO_INCREMENT pentru tabele eliminate
--

--
-- AUTO_INCREMENT pentru tabele `zboruri`
--
ALTER TABLE `zboruri`
  MODIFY `id_zbor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
