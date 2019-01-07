-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Erstellungszeit: 07. Jan 2019 um 11:02
-- Server-Version: 10.1.31-MariaDB
-- PHP-Version: 7.2.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Datenbank: `db_clients`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `t_clients`
--

CREATE TABLE `t_clients` (
  `id` bigint(20) NOT NULL,
  `name` varchar(100) NOT NULL,
  `fav_color` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Daten für Tabelle `t_clients`
--

INSERT INTO `t_clients` (`id`, `name`, `fav_color`) VALUES
(3, 'Lizzy Hale', 'Color of Love'),
(4, 'Eisbrecher', 'Rot wie die Liebe'),
(5, 'Ruby Rap', 'SuperGrün!'),
(6, 'Alissa White-gluss', 'Time is black'),
(7, 'Falco -> \"sie\"', 'Goldne Nase heißt sie auf der Szene'),
(8, 'Parkway Drive', 'Blue and the Grey'),
(9, 'Blues Brothers', 'Black\n');

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `t_clients`
--
ALTER TABLE `t_clients`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT für exportierte Tabellen
--

--
-- AUTO_INCREMENT für Tabelle `t_clients`
--
ALTER TABLE `t_clients`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
