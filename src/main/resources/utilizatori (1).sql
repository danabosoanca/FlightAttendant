-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Gazdă: 127.0.0.1
-- Timp de generare: mai 24, 2020 la 03:27 PM
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
-- Structură tabel pentru tabel `utilizatori`
--

CREATE TABLE `utilizatori` (
  `nume` varchar(35) NOT NULL,
  `adresa` varchar(40) NOT NULL,
  `telefon` varchar(10) NOT NULL,
  `membru` tinyint(1) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(120) NOT NULL,
  `id_utilizator` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Eliminarea datelor din tabel `utilizatori`
--

INSERT INTO `utilizatori` (`nume`, `adresa`, `telefon`, `membru`, `username`, `password`, `id_utilizator`) VALUES
(' Valentin Popescu', 'Timisoara, Romania', '0767472019', 0, 'valentin_popescu', '1e2443f36131013ed9801', 1),
(' Maria Georgescu', 'Craiova, Romania', '0732190621', 0, 'maria_georgescu', '6b0e5e8be332236bf5', 2),
(' Andrei Dumitru', 'Bucharest, Romania', '0756907612', 0, 'andrei_dumitru', '210b32ba102fc225454f', 3),
(' Adrian Lazar', 'Sibiu, Romania', '0722962478', 0, 'adrian_lazar', 'c252c318360a2aa001a43c', 4),
('David Smith', 'London, UK', '08001111', 0, 'david_smith', '7522c08b8dd3d72a0a47', 5),
('Emily Moore', 'Tel Aviv, Israel', '050986543', 0, 'emily_moore', '0a25a2f23379681f3bf34', 6),
('Adela Alvarez', 'Madrid, Spain', '007649876', 0, 'adela_alvarez', 'bd4cad1b247080d1f50b', 7),
('Berta Alonzo', 'Ibiza, Spain', '564532907', 0, 'berta_alonzo', '3170539917a16334341222', 8),
(' Sophie Parker', 'Geneva, Switzerland', '085644920', 0, 'sophie_parker', '06c2eb21e932f3e20ac042', 9),
('Thomas Koch', 'Dortmund, Germany', '0700437658', 0, 'thomas_koch', '2fe52f018271f3d35668a1', 10),
('Norris Martin', 'Paris, France', '0140250808', 0, 'norris_martin', '44e74e694006373f3', 11),
('Francisc Bernard', 'Nice, Paris', '3387201245', 1, 'francisc_bernard', '38e8d36dbca4150d8', 12),
('Lee Müller', 'Berlin, Germany', '0748327502', 1, 'lee_muller', '0384f2078292fb151a7', 13),
('Harris Griffin', 'Baku,  Azerbaijan', '03457825', 1, 'harris_griffin', '52cec415020aec7b071101', 14),
('Daniel De Alba', 'Barcelona, Spain', '54863078', 1, 'daniel_dealba', 'a7381cf001c1ba69346e', 15),
('Melanie Williams', 'Liverpool, UK', '0873654', 1, 'melanie_williams', '3a2cd03b69d09375e62', 16),
('Mirela Moldovan', 'Bucharest, Romania', '0746853245', 1, 'mirela_moldovan', '643afa8050a0b2a3441b', 17),
('Marius Tudor', 'Constanta, Romania', '0725468932', 1, 'marius_tudor', '4a19790052341f5b0f09', 18),
('Alina Iordache', 'Brasov, Romania', '0743269874', 1, 'alina_iordache', '1a337f989133e3532c7f', 19),
('Ryan Berg', 'Oslo, Norway', '00149632', 1, 'ryan_berg', '0070c07430f30c1c85591a', 20);

--
-- Indexuri pentru tabele eliminate
--

--
-- Indexuri pentru tabele `utilizatori`
--
ALTER TABLE `utilizatori`
  ADD PRIMARY KEY (`id_utilizator`),
  ADD UNIQUE KEY `id_utilizator` (`id_utilizator`);

--
-- AUTO_INCREMENT pentru tabele eliminate
--

--
-- AUTO_INCREMENT pentru tabele `utilizatori`
--
ALTER TABLE `utilizatori`
  MODIFY `id_utilizator` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
