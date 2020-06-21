-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Gazdă: 127.0.0.1
-- Timp de generare: iun. 20, 2020 la 02:43 PM
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
('Valentin Popescu', 'Timisoara, Romania', '0767472019', 0, 'valentin_popescu', 'dee484ff7366319331b0d36e9d0958c1', 1),
('Maria Georgescu', 'Craiova, Romania', '0732190621', 0, 'maria_georgescu', '263bce650e68ab4e23f28263760b9fa5', 2),
('Andrei Dumitru', 'Bucharesc, Romania', '0756907612', 0, 'andrei_dumitru', 'b2d09b73eb5ad0228f9cb2e51485a45f', 3),
('Adrian Lazar', 'Sibiu, Romania', '0722962478', 0, 'adrian_lazar', '8c4205ec33d8f6caeaaaa0c10a14138c', 4),
('David Smith', 'London, UK', '08001111', 0, 'david_smith', '172522ec1028ab781d9dfd17eaca4427', 5),
('Emily Moore', 'Tel Aviv, Israel', '050986543', 0, 'emily_moore', 'b02ae5aaefe3f7090668df034b0f2324', 6),
('Adela Alvarez', 'Madrid, Spain', '007649876', 0, 'adela_alvarez', 'bbad14bc2a2ddb9244a72058cddf15cb', 7),
('Berta Alonzo', 'Ibiza, Spain', '564532907', 0, 'berta_alonzo', '43d75035f949d7bad66383b46374d2e2', 8),
('Sophie Parker', 'Geneva, Switzerland', '085644920', 0, 'sophie_parker', '6988ec3aba1eaddf2435141bf10487ca', 9),
('Thomas Koch', 'Dortmund, Germany', '0700437658', 0, 'thomas_koch', 'ef6e65efc188e7dffd7335b646a85a21', 10),
('Norris Martin', 'Paris, France', '0140250808', 0, 'norris_martin', '44041e67a48e7629148000666397ff53', 11),
('Client', 'Orsova, Romania', '0789543021', 0, 'client', '62608e08adc29a8d6dbc9754e659f125', 12),
('Francisc Bernard', 'Nice, Paris', '3387201245', 1, 'francisc_bernard', 'f87e388d33364d9b1cba549175106da8', 13),
('Lee Muller', 'Berlin, Germany', '0748327502', 1, 'lee_muller', 'b0f8b49f22c718e9924f5b1165111a67', 14),
('Harris Griffin', 'Baku, Azerbaijan', '03457825', 1, 'harris_griffin', '65ec1e9ca4d5c2ca4ebc071b2047d1c1', 15),
('Daniel De Alba', 'Barcelona, Spain', '54863078', 1, 'daniel_dealba', '07a88e756847244f3496f63f473d6085', 16),
('Melanie Williams', 'Liverpool, UK', '0873654', 1, 'melanie_williams', '73aaec6dc33b96597d8019f7553e96a2', 17),
('Mirela Moldovan', 'Bucharest, Romania', '0746853245', 1, 'mirela_moldovan', '2604fa2f1a58c5ca204b123a937424db', 18),
('Marius Tudor', 'Constanta, Romania', '0725468932', 1, 'marius_tudor', '242aa1a97769109065e3b4df359bcfc9', 19),
('Alina Iordache', 'Brasov, Romania', '0743269874', 1, 'alina_iordache', '914a23f72f590809d3fe431573ecb71f', 20),
('Ryan Berg', 'Oslo, Norway', '00149632', 1, 'ryan_berg', '10c7ccc7a4f0aff03c915c485565b9da', 21),
('Admin', 'Severin', '0765491029', 1, 'admin', '21232f297a57a5a743894a0e4a801fc3', 22);

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
  MODIFY `id_utilizator` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
