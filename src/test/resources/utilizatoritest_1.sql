-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Gazdă: 127.0.0.1
-- Timp de generare: iun. 21, 2020 la 09:52 AM
-- Versiune server: 10.4.11-MariaDB
-- Versiune PHP: 7.4.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
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
-- Structură tabel pentru tabel `utilizatoritest`
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
-- Eliminarea datelor din tabel `utilizatoritest`
--

INSERT INTO `utilizatoritest` (`nume`, `adresa`, `telefon`, `membru`, `username`, `password`, `id_utilizator`) VALUES
('test', 'test', '000000000', 1, 'test', '098f6bcd4621d373cade4e832627b4f6', 1),
('test', 'test', '000000000', 1, 'test', '098f6bcd4621d373cade4e832627b4f6', 2),
('admin', 'admin', '000000000', 1, 'admin', '21232f297a57a5a743894a0e4a801fc3', 3),
('client', 'client', '000000000', 0, 'client', '62608e08adc29a8d6dbc9754e659f125', 4),
('client', 'client', '000000000', 0, 'client', '62608e08adc29a8d6dbc9754e659f125', 5),
('client', 'client', '000000000', 0, 'client', '62608e08adc29a8d6dbc9754e659f125', 6),
('client', 'client', '000000000', 0, 'client', '62608e08adc29a8d6dbc9754e659f125', 7),
('client', 'client', '000000000', 0, 'client', '62608e08adc29a8d6dbc9754e659f125', 8),
('client', 'client', '000000000', 0, 'client', '62608e08adc29a8d6dbc9754e659f125', 9),
('client', 'client', '000000000', 0, 'client', '62608e08adc29a8d6dbc9754e659f125', 10),
('client', 'client', '000000000', 0, 'client', '62608e08adc29a8d6dbc9754e659f125', 11),
('client', 'client', '000000000', 0, 'client', '62608e08adc29a8d6dbc9754e659f125', 12),
('client', 'client', '000000000', 0, 'client', '62608e08adc29a8d6dbc9754e659f125', 13),
('client', 'client', '000000000', 0, 'client', '62608e08adc29a8d6dbc9754e659f125', 14),
('client', 'client', '000000000', 0, 'client', '62608e08adc29a8d6dbc9754e659f125', 15),
('client', 'client', '000000000', 0, 'client', '62608e08adc29a8d6dbc9754e659f125', 16),
('client', 'client', '000000000', 0, 'client', '62608e08adc29a8d6dbc9754e659f125', 17),
('client', 'client', '000000000', 0, 'client', '62608e08adc29a8d6dbc9754e659f125', 18),
('client', 'client', '000000000', 0, 'client', '62608e08adc29a8d6dbc9754e659f125', 19),
('client', 'client', '000000000', 0, 'client', '62608e08adc29a8d6dbc9754e659f125', 20),
('client', 'client', '000000000', 0, 'client', '62608e08adc29a8d6dbc9754e659f125', 21),
('client', 'client', '000000000', 0, 'client', '62608e08adc29a8d6dbc9754e659f125', 22),
('client', 'client', '000000000', 0, 'client', '62608e08adc29a8d6dbc9754e659f125', 23),
('client', 'client', '000000000', 0, 'client', '62608e08adc29a8d6dbc9754e659f125', 24),
('client', 'client', '000000000', 0, 'client', '62608e08adc29a8d6dbc9754e659f125', 25),
('client', 'client', '000000000', 0, 'client', '62608e08adc29a8d6dbc9754e659f125', 26),
('client', 'client', '000000000', 0, 'client', '62608e08adc29a8d6dbc9754e659f125', 27),
('client', 'client', '000000000', 0, 'client', '62608e08adc29a8d6dbc9754e659f125', 28),
('client', 'client', '000000000', 0, 'client', '62608e08adc29a8d6dbc9754e659f125', 29),
('client', 'client', '000000000', 0, 'client', '62608e08adc29a8d6dbc9754e659f125', 30),
('client', 'client', '000000000', 0, 'client', '62608e08adc29a8d6dbc9754e659f125', 31),
('client', 'client', '000000000', 0, 'client', '62608e08adc29a8d6dbc9754e659f125', 32),
('client', 'client', '000000000', 0, 'client', '62608e08adc29a8d6dbc9754e659f125', 33),
('client', 'client', '000000000', 0, 'client', '62608e08adc29a8d6dbc9754e659f125', 34),
('client', 'client', '000000000', 0, 'client', '62608e08adc29a8d6dbc9754e659f125', 35),
('client', 'client', '000000000', 0, 'client', '62608e08adc29a8d6dbc9754e659f125', 36),
('client', 'client', '000000000', 0, 'client', '62608e08adc29a8d6dbc9754e659f125', 37),
('client', 'client', '000000000', 0, 'client', '62608e08adc29a8d6dbc9754e659f125', 38),
('client', 'client', '000000000', 0, 'client', '62608e08adc29a8d6dbc9754e659f125', 39),
('client', 'client', '000000000', 0, 'client', '62608e08adc29a8d6dbc9754e659f125', 40),
('client', 'client', '000000000', 0, 'client', '62608e08adc29a8d6dbc9754e659f125', 41),
('client', 'client', '000000000', 0, 'client', '62608e08adc29a8d6dbc9754e659f125', 42),
('client', 'client', '000000000', 0, 'client', '62608e08adc29a8d6dbc9754e659f125', 43),
('client', 'client', '000000000', 0, 'client', '62608e08adc29a8d6dbc9754e659f125', 44);

--
-- Indexuri pentru tabele eliminate
--

--
-- Indexuri pentru tabele `utilizatoritest`
--
ALTER TABLE `utilizatoritest`
  ADD PRIMARY KEY (`id_utilizator`),
  ADD UNIQUE KEY `id_utilizator` (`id_utilizator`);

--
-- AUTO_INCREMENT pentru tabele eliminate
--

--
-- AUTO_INCREMENT pentru tabele `utilizatoritest`
--
ALTER TABLE `utilizatoritest`
  MODIFY `id_utilizator` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
