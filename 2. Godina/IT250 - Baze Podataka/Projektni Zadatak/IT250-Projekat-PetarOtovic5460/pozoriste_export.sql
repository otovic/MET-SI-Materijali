-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jan 13, 2024 at 06:23 PM
-- Server version: 5.7.36
-- PHP Version: 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pozoriste`
--

-- --------------------------------------------------------

--
-- Table structure for table `kreditna_kartica`
--

DROP TABLE IF EXISTS `kreditna_kartica`;
CREATE TABLE IF NOT EXISTS `kreditna_kartica` (
  `broj_kreditne_kartice` varchar(100) NOT NULL,
  `jedinstveni_broj_pretplatnika` int(11) NOT NULL,
  `tip` varchar(50) NOT NULL,
  `datum_isteka` date NOT NULL,
  PRIMARY KEY (`broj_kreditne_kartice`),
  KEY `fk_pripada2` (`jedinstveni_broj_pretplatnika`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kreditna_kartica`
--

INSERT INTO `kreditna_kartica` (`broj_kreditne_kartice`, `jedinstveni_broj_pretplatnika`, `tip`, `datum_isteka`) VALUES
('1111-2222-3333-4444', 1, 'MasterCard', '2024-12-31'),
('2222-3333-4444-5555', 2, 'Visa', '2023-11-30'),
('3333-4444-5555-6666', 3, 'Visa', '2025-08-31'),
('4444-5555-6666-7777', 4, 'MasterCard', '2022-10-31'),
('5555-6666-7777-8888', 5, 'DinaCard', '2026-05-31');

-- --------------------------------------------------------

--
-- Table structure for table `narodno_pozoriste`
--

DROP TABLE IF EXISTS `narodno_pozoriste`;
CREATE TABLE IF NOT EXISTS `narodno_pozoriste` (
  `ime_narodnog_pozorista` varchar(200) NOT NULL,
  PRIMARY KEY (`ime_narodnog_pozorista`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `narodno_pozoriste`
--

INSERT INTO `narodno_pozoriste` (`ime_narodnog_pozorista`) VALUES
('Pozoriste Bojan Stupica'),
('Pozoriste Bora Stankovic'),
('Pozoriste na Terazijama');

-- --------------------------------------------------------

--
-- Table structure for table `pozorisni_komad`
--

DROP TABLE IF EXISTS `pozorisni_komad`;
CREATE TABLE IF NOT EXISTS `pozorisni_komad` (
  `ime_pozorisnog_komada` varchar(100) NOT NULL,
  PRIMARY KEY (`ime_pozorisnog_komada`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pozorisni_komad`
--

INSERT INTO `pozorisni_komad` (`ime_pozorisnog_komada`) VALUES
('Cele Kula'),
('Picasso'),
('Stefan Nemanja');

-- --------------------------------------------------------

--
-- Table structure for table `predstava`
--

DROP TABLE IF EXISTS `predstava`;
CREATE TABLE IF NOT EXISTS `predstava` (
  `predstava_id` int(11) NOT NULL,
  `ime_predstave` varchar(200) NOT NULL,
  `producent_id` int(11) NOT NULL,
  `ime_trupe` varchar(150) NOT NULL,
  `ime_pozorisnog_komada` varchar(100) NOT NULL,
  `datum_odrzavanja` date DEFAULT NULL,
  `cena_ulaznice` int(11) DEFAULT NULL,
  `max_mesta` int(11) NOT NULL,
  PRIMARY KEY (`predstava_id`),
  KEY `fk_izvodi` (`ime_trupe`),
  KEY `fk_organizuje` (`ime_pozorisnog_komada`),
  KEY `fk_producira` (`producent_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `predstava`
--

INSERT INTO `predstava` (`predstava_id`, `ime_predstave`, `producent_id`, `ime_trupe`, `ime_pozorisnog_komada`, `datum_odrzavanja`, `cena_ulaznice`, `max_mesta`) VALUES
(21, 'Ne Gledam Rijaliti', 1, 'Kraljevski Teatar', 'Picasso', '2034-09-25', 2200, 233),
(20, 'Seherzada', 2, 'Star Wars', 'Stefan Nemanja', '2014-08-24', 2100, 400),
(18, 'Ana Karenjina', 2, 'Star Wars', 'Picasso', '2015-06-22', 1900, 200),
(19, 'Nindza Kornjace', 1, 'Kraljevski Teatar', 'Cele Kula', '2033-07-23', 2000, 150),
(16, 'Nindza Kornjace', 2, 'Star Wars', 'Cele Kula', '2016-04-20', 1700, 100),
(17, 'Nindza Kornjace', 1, 'Kraljevski Teatar', 'Stefan Nemanja', '2032-05-21', 1800, 200),
(15, 'Ne Gledam Rijaliti', 1, 'Kraljevski Teatar', 'Picasso', '2031-03-19', 1600, 500),
(14, 'Seherzada', 2, 'Star Wars', 'Stefan Nemanja', '2017-02-18', 1500, 400),
(13, 'Zlocin i kazna', 1, 'Kraljevski Teatar', 'Cele Kula', '2030-01-17', 1400, 300),
(12, 'Ana Karenjina', 2, 'Star Wars', 'Picasso', '2018-12-16', 1300, 70),
(11, 'Nindza Kornjace', 1, 'Kraljevski Teatar', 'Stefan Nemanja', '2029-11-15', 1200, 145),
(10, 'Nindza Kornjace', 2, 'Star Wars', 'Cele Kula', '2019-10-14', 1100, 233),
(9, 'Zlocin i kazna', 1, 'Kraljevski Teatar', 'Picasso', '2028-09-13', 1000, 200),
(8, 'Ne Gledam Rijaliti', 2, 'Star Wars', 'Stefan Nemanja', '2020-08-12', 900, 200),
(7, 'Seherzada', 1, 'Kraljevski Teatar', 'Cele Kula', '2027-07-11', 800, 15),
(6, 'Nindza Kornjace', 2, 'Star Wars', 'Picasso', '2021-06-10', 700, 60),
(5, 'Nindza Kornjace', 1, 'Kraljevski Teatar', 'Stefan Nemanja', '2026-05-09', 600, 323),
(4, 'Zlocin i kazna', 2, 'Star Wars', 'Cele Kula', '2022-04-08', 500, 1111),
(3, 'Seherzada', 1, 'Kraljevski Teatar', 'Picasso', '2025-03-07', 400, 123),
(2, 'Zlocin i kazna', 2, 'Star Wars', 'Stefan Nemanja', '2023-02-06', 300, 200),
(1, 'Ana Karenjina', 1, 'Kraljevski Teatar', 'Cele Kula', '2024-01-05', 200, 100),
(22, 'Ne Gledam Rijaliti', 2, 'Star Wars', 'Cele Kula', '2013-10-26', 2300, 200),
(23, 'Ne Gledam Rijaliti', 1, 'Kraljevski Teatar', 'Stefan Nemanja', '2035-11-27', 2400, 100);

--
-- Triggers `predstava`
--
DROP TRIGGER IF EXISTS `before_insert_predstava`;
DELIMITER $$
CREATE TRIGGER `before_insert_predstava` BEFORE INSERT ON `predstava` FOR EACH ROW BEGIN
    DECLARE datum DATE;
    DECLARE komad VARCHAR(100);
    DECLARE broj_predstava INT;

    SET datum = NEW.datum_odrzavanja;
    SET komad = NEW.ime_pozorisnog_komada;
    
    SELECT COUNT(pr.predstava_id)
    INTO broj_predstava
    FROM predstava AS pr
    WHERE pr.datum_odrzavanja = datum AND pr.ime_pozorisnog_komada = komad;

    IF broj_predstava > 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Vec je rezervisana predstava sa ovim pozorisnim komadom za dati datum!';
    END IF;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `pretplatnik`
--

DROP TABLE IF EXISTS `pretplatnik`;
CREATE TABLE IF NOT EXISTS `pretplatnik` (
  `jedinstveni_broj_pretplatnika` int(11) NOT NULL,
  `ime` varchar(200) NOT NULL,
  `prezime` varchar(200) NOT NULL,
  `broj_kreditne_kartice` varchar(100) DEFAULT NULL,
  `adresa` varchar(100) DEFAULT NULL,
  `telefon` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`jedinstveni_broj_pretplatnika`),
  KEY `fk_pripada` (`broj_kreditne_kartice`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pretplatnik`
--

INSERT INTO `pretplatnik` (`jedinstveni_broj_pretplatnika`, `ime`, `prezime`, `broj_kreditne_kartice`, `adresa`, `telefon`) VALUES
(3, 'Stevan', 'Planic', '3333-4444-5555-6666', 'Cara Lazara 10', '0634567890'),
(2, 'Miomir', 'Dragovic', '2222-3333-4444-5555', 'Knez Mihailova 25', '0623456789'),
(1, 'Zelimir', 'Prodanovic', '1111-2222-3333-4444', 'Bulevar Despota Stefana 15', '0612345678'),
(4, 'Petar', 'Petrovic', '4444-5555-6666-7777', 'Trg Republike 7', '0645678901'),
(5, 'Zeljko', 'Zeljkovic', '5555-6666-7777-8888', 'Cara Nemanje 22', '0656789012');

-- --------------------------------------------------------

--
-- Table structure for table `producent`
--

DROP TABLE IF EXISTS `producent`;
CREATE TABLE IF NOT EXISTS `producent` (
  `producent_id` int(11) NOT NULL,
  `ime_producenta` varchar(100) NOT NULL,
  PRIMARY KEY (`producent_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `producent`
--

INSERT INTO `producent` (`producent_id`, `ime_producenta`) VALUES
(1, 'Maksim Svetlanovic'),
(2, 'Gradimir Eror');

-- --------------------------------------------------------

--
-- Stand-in structure for view `producenti_predstave`
-- (See below for the actual view)
--
DROP VIEW IF EXISTS `producenti_predstave`;
CREATE TABLE IF NOT EXISTS `producenti_predstave` (
);

-- --------------------------------------------------------

--
-- Table structure for table `rezervacija`
--

DROP TABLE IF EXISTS `rezervacija`;
CREATE TABLE IF NOT EXISTS `rezervacija` (
  `jedinstveni_broj_rezervacije` int(11) NOT NULL AUTO_INCREMENT,
  `jedinstveni_broj_pretplatnika` int(11) NOT NULL,
  `predstava_id` int(11) NOT NULL,
  `datum_rezervacije` date NOT NULL,
  `iznos_za_placanje` int(11) NOT NULL,
  `mesta_rezervisano` int(11) NOT NULL,
  PRIMARY KEY (`jedinstveni_broj_rezervacije`),
  KEY `fk_rezervisano` (`predstava_id`),
  KEY `fk_rezervise` (`jedinstveni_broj_pretplatnika`)
) ENGINE=MyISAM AUTO_INCREMENT=1002 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rezervacija`
--

INSERT INTO `rezervacija` (`jedinstveni_broj_rezervacije`, `jedinstveni_broj_pretplatnika`, `predstava_id`, `datum_rezervacije`, `iznos_za_placanje`, `mesta_rezervisano`) VALUES
(3, 3, 3, '2025-03-07', 22000, 55),
(2, 2, 2, '2023-02-06', 60000, 200),
(1, 1, 1, '2024-01-05', 20000, 100),
(100, 2, 3, '2025-03-07', 22000, 55),
(4, 4, 4, '2022-04-08', 44500, 89),
(5, 3, 4, '2022-04-08', 100000, 200),
(6, 5, 5, '2026-05-09', 73800, 123),
(7, 1, 5, '2026-05-09', 73800, 123),
(8, 2, 5, '2026-05-09', 30000, 50),
(9, 1, 6, '2021-06-10', 14000, 20),
(10, 4, 6, '2021-06-09', 21000, 30),
(11, 2, 7, '2027-07-11', 8000, 10),
(12, 4, 7, '2027-07-09', 3200, 4),
(13, 3, 8, '2020-08-12', 29700, 33),
(14, 1, 8, '2020-08-11', 49500, 55),
(15, 5, 8, '2020-08-10', 39600, 44),
(16, 4, 9, '2028-09-13', 10000, 10),
(17, 1, 9, '2028-09-13', 20000, 20),
(18, 2, 9, '2028-09-13', 50000, 50),
(19, 3, 9, '2028-09-13', 100000, 100),
(20, 5, 10, '2019-10-14', 11000, 20),
(21, 1, 10, '2019-10-11', 2200, 2),
(22, 2, 10, '2019-10-11', 33000, 33),
(23, 3, 10, '2019-10-12', 44000, 44),
(24, 4, 10, '2019-10-11', 55000, 55),
(25, 5, 11, '2029-11-15', 14400, 12),
(26, 1, 11, '2029-11-13', 28800, 24),
(27, 2, 11, '2029-11-13', 43200, 36),
(28, 3, 11, '2029-11-11', 57600, 48),
(29, 4, 11, '2029-11-09', 12000, 10),
(30, 5, 12, '2018-12-16', 16900, 13),
(31, 1, 12, '2018-12-14', 26000, 20),
(32, 2, 12, '2018-12-12', 50700, 39),
(35, 5, 13, '2030-01-17', 14000, 10),
(36, 1, 13, '2030-01-15', 28000, 20),
(38, 3, 13, '2030-01-11', 56000, 40),
(39, 4, 13, '2030-01-09', 70000, 50),
(40, 5, 14, '2017-02-18', 15000, 10),
(41, 1, 14, '2017-02-16', 30000, 20),
(42, 2, 14, '2017-02-14', 45000, 30),
(43, 3, 14, '2017-02-12', 60000, 40),
(45, 5, 15, '2031-03-19', 16000, 10),
(46, 1, 15, '2031-03-17', 32000, 20),
(48, 3, 15, '2031-03-13', 64000, 40),
(49, 4, 15, '2031-03-11', 80000, 50),
(50, 5, 16, '2016-04-20', 17000, 10),
(51, 1, 16, '2016-04-18', 34000, 20),
(52, 1, 16, '2016-04-16', 51000, 30),
(54, 4, 16, '2016-04-12', 17000, 10),
(55, 5, 17, '2032-05-21', 18000, 10),
(56, 1, 17, '2032-05-19', 36000, 20),
(57, 2, 17, '2032-05-17', 54000, 30),
(58, 3, 17, '2032-05-15', 72000, 40),
(1000, 1, 3, '2020-03-03', 4000, 1),
(1001, 1, 3, '2020-03-03', 4000, 10);

--
-- Triggers `rezervacija`
--
DROP TRIGGER IF EXISTS `before_insert_rezervacija`;
DELIMITER $$
CREATE TRIGGER `before_insert_rezervacija` BEFORE INSERT ON `rezervacija` FOR EACH ROW BEGIN
    DECLARE remaining_seats INT;

    SELECT (pr.max_mesta - COALESCE(SUM(mesta_rezervisano), 0))
    INTO remaining_seats
    FROM rezervacija
    INNER JOIN predstava AS pr ON rezervacija.prestava_id = pr.prestava_id
    WHERE pr.prestava_id = NEW.prestava_id;

    IF NEW.mesta_rezervisano > remaining_seats THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Cannot reserve more seats than available';
    END IF;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `se_izvodi_u`
--

DROP TABLE IF EXISTS `se_izvodi_u`;
CREATE TABLE IF NOT EXISTS `se_izvodi_u` (
  `ime_narodnog_pozorista` varchar(200) NOT NULL,
  `predstava_id` int(11) NOT NULL,
  PRIMARY KEY (`ime_narodnog_pozorista`,`predstava_id`),
  KEY `fk_se_izvodi_u2` (`predstava_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `se_izvodi_u`
--

INSERT INTO `se_izvodi_u` (`ime_narodnog_pozorista`, `predstava_id`) VALUES
('Pozoriste Bojan Stupica', 2),
('Pozoriste Bojan Stupica', 5),
('Pozoriste Bojan Stupica', 8),
('Pozoriste Bojan Stupica', 11),
('Pozoriste Bojan Stupica', 14),
('Pozoriste Bojan Stupica', 17),
('Pozoriste Bojan Stupica', 20),
('Pozoriste Bojan Stupica', 23),
('Pozoriste Bora Stankovic', 1),
('Pozoriste Bora Stankovic', 4),
('Pozoriste Bora Stankovic', 7),
('Pozoriste Bora Stankovic', 10),
('Pozoriste Bora Stankovic', 13),
('Pozoriste Bora Stankovic', 16),
('Pozoriste Bora Stankovic', 19),
('Pozoriste Bora Stankovic', 22),
('Pozoriste na Terazijama', 3),
('Pozoriste na Terazijama', 6),
('Pozoriste na Terazijama', 9),
('Pozoriste na Terazijama', 12),
('Pozoriste na Terazijama', 15),
('Pozoriste na Terazijama', 18),
('Pozoriste na Terazijama', 21);

-- --------------------------------------------------------

--
-- Table structure for table `trupa`
--

DROP TABLE IF EXISTS `trupa`;
CREATE TABLE IF NOT EXISTS `trupa` (
  `ime_trupe` varchar(150) NOT NULL,
  PRIMARY KEY (`ime_trupe`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `trupa`
--

INSERT INTO `trupa` (`ime_trupe`) VALUES
('Inzenjeri Spekulativnih Finansija'),
('Kraljevski Teatar'),
('Star Wars');

-- --------------------------------------------------------

--
-- Structure for view `producenti_predstave`
--
DROP TABLE IF EXISTS `producenti_predstave`;

DROP VIEW IF EXISTS `producenti_predstave`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `producenti_predstave`  AS SELECT `pr`.`prestava_id` AS `prestava_id`, `pr`.`ime_trupe` AS `ime_trupe`, `pr`.`ime_pozorisnog_komada` AS `ime_pozorisnog_komada`, `prod`.`ime_producenta` AS `ime_producenta` FROM (`predstava` `pr` left join `producent` `prod` on((`pr`.`producent_id` = `prod`.`producent_id`))) ;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
