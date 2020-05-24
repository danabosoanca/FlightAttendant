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
-- Structură tabel pentru tabel `zboruri`
--

CREATE TABLE `zboruri` (
  `id_zbor` int(11) NOT NULL,
  `oras_de_plecare` varchar(30) NOT NULL,
  `destinatie` varchar(30) NOT NULL,
  `ora_imbarcare` time NOT NULL,
  `data_imbarcare` date NOT NULL,
  `durata` int(11) NOT NULL,
  `locuri_disp` int(11) NOT NULL,
  `pret_bilet` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Eliminarea datelor din tabel `zboruri`
--

INSERT INTO `zboruri` (`id_zbor`, `oras_de_plecare`, `destinatie`, `ora_imbarcare`, `data_imbarcare`, `durata`, `locuri_disp`, `pret_bilet`) VALUES
(1, 'Bucharest (OTP)', 'London Luton (LTN)', '06:40:00', '2020-06-14', 180, 115, 88),
(2, 'Brussels Charleroi (CRL)', 'Vienna (VIE)', '15:50:00', '2020-07-01', 110, 142, 50),
(3, 'Baku (GYD)', 'Budapest (BUD)', '05:50:00', '2020-06-19', 245, 180, 120),
(4, 'Vienna (VIE)', 'Malta (MLA)', '06:25:00', '2020-07-04', 135, 120, 70),
(5, 'Dubai (DWC)', 'Bucharest (OTP)', '21:25:00', '2020-07-12', 320, 100, 412),
(6, 'Geneva (GVA)', 'Sofia (SOF)', '15:40:00', '2020-06-26', 145, 135, 78),
(7, 'Ibiza (IBZ)', 'Budapest (BUD)', '23:45:00', '2020-06-28', 155, 97, 70),
(8, 'Odesa (ODS)', 'Bratislava (BTS)', '20:05:00', '2020-07-27', 115, 90, 1480),
(9, 'Porto (OPO)', 'London Luton (LTN)', '15:20:00', '2020-08-01', 135, 110, 50),
(10, 'Cluj-Napoca (CLJ)', 'Bari (BRI)', '06:15:00', '2020-08-09', 100, 80, 85),
(11, 'Corfu (CFU)', 'Vienna (VIE)', '16:00:00', '2020-08-22', 110, 90, 70),
(12, 'Dortmund (DTM)', 'Riga (RIX)', '20:40:00', '2020-08-29', 115, 100, 60),
(13, 'Paris Orly (ORY)', 'Budapest (BUD)', '09:40:00', '2020-08-31', 120, 99, 70),
(14, 'Hanover (HAJ)', 'Skopje (SKP)', '21:45:00', '2020-09-01', 130, 125, 80),
(15, 'Tel-Aviv (TLV)', 'Varna (Black Sea)  (VAR)', '15:55:00', '2020-09-07', 145, 98, 429),
(16, 'Podgorica (TGD)', 'Milan Malpensa (MXP)', '19:35:00', '2020-09-16', 110, 80, 15),
(17, 'Eindhoven (EIN)', 'Tuzla (TZL)', '14:40:00', '2020-10-01', 130, 100, 40),
(18, 'Oslo (OSL)', 'Kraków (KRK)', '21:40:00', '2020-10-22', 130, 90, 699);

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
  MODIFY `id_zbor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
