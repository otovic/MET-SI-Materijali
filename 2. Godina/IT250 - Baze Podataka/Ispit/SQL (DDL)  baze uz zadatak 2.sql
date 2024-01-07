--
-- Table structure for table `aircraft`
--

DROP TABLE IF EXISTS `aircraft`;
CREATE TABLE `aircraft` (
  `AircraftID` smallint(4) unsigned NOT NULL AUTO_INCREMENT,
  `AircraftTypeID` smallint(4) unsigned NOT NULL,
  `RegNum` char(6) NOT NULL,
  `LastMaintEnd` date NOT NULL,
  `NextMaintBegin` date NOT NULL,
  `NextMaintEnd` date NOT NULL,
  PRIMARY KEY (`AircraftID`),
  UNIQUE KEY `RegNum` (`RegNum`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

--
-- Dumping data for table `aircraft`
--

INSERT INTO `aircraft` (`AircraftID`, `AircraftTypeID`, `RegNum`, `LastMaintEnd`, `NextMaintBegin`, `NextMaintEnd`) VALUES(3451, 503, 'ZX6488', '2018-01-01', '2018-06-23', '2018-06-30');
INSERT INTO `aircraft` (`AircraftID`, `AircraftTypeID`, `RegNum`, `LastMaintEnd`, `NextMaintBegin`, `NextMaintEnd`) VALUES(3465, 503, 'ZX5373', '2018-01-15', '2018-04-14', '2018-05-21');
INSERT INTO `aircraft` (`AircraftID`, `AircraftTypeID`, `RegNum`, `LastMaintEnd`, `NextMaintBegin`, `NextMaintEnd`) VALUES(3467, 616, 'ZX7283', '2018-02-05', '2018-12-02', '2018-10-09');
INSERT INTO `aircraft` (`AircraftID`, `AircraftTypeID`, `RegNum`, `LastMaintEnd`, `NextMaintBegin`, `NextMaintEnd`) VALUES(3452, 617, 'ZX5464', '2018-01-04', '2018-04-03', '2018-02-21');
INSERT INTO `aircraft` (`AircraftID`, `AircraftTypeID`, `RegNum`, `LastMaintEnd`, `NextMaintBegin`, `NextMaintEnd`) VALUES(3469, 616, 'ZX5382', '2018-01-16', '2018-04-08', '2018-04-18');
INSERT INTO `aircraft` (`AircraftID`, `AircraftTypeID`, `RegNum`, `LastMaintEnd`, `NextMaintBegin`, `NextMaintEnd`) VALUES(3145, 503, 'ZX5731', '2018-02-17', '2018-12-20', '2018-12-30');
INSERT INTO `aircraft` (`AircraftID`, `AircraftTypeID`, `RegNum`, `LastMaintEnd`, `NextMaintBegin`, `NextMaintEnd`) VALUES(3425, 504, 'ZX6821', '2018-02-22', '2018-05-25', '2018-06-04');
INSERT INTO `aircraft` (`AircraftID`, `AircraftTypeID`, `RegNum`, `LastMaintEnd`, `NextMaintBegin`, `NextMaintEnd`) VALUES(3427, 616, 'ZX5921', '2018-02-01', '2018-03-02', '2018-04-02');
INSERT INTO `aircraft` (`AircraftID`, `AircraftTypeID`, `RegNum`, `LastMaintEnd`, `NextMaintBegin`, `NextMaintEnd`) VALUES(3189, 616, 'ZX5823', '2018-03-07', '2018-11-05', '2018-11-12');
INSERT INTO `aircraft` (`AircraftID`, `AircraftTypeID`, `RegNum`, `LastMaintEnd`, `NextMaintBegin`, `NextMaintEnd`) VALUES(3470, 616, 'ZX5173', '2018-04-20', '2018-10-05', '2018-10-15');
INSERT INTO `aircraft` (`AircraftID`, `AircraftTypeID`, `RegNum`, `LastMaintEnd`, `NextMaintBegin`, `NextMaintEnd`) VALUES(3125, 617, 'ZX1386', '2018-02-12', '2018-02-01', '2018-02-22');
INSERT INTO `aircraft` (`AircraftID`, `AircraftTypeID`, `RegNum`, `LastMaintEnd`, `NextMaintBegin`, `NextMaintEnd`) VALUES(3128, 617, 'ZX7634', '2018-01-07', '2018-05-07', '2018-05-18');
INSERT INTO `aircraft` (`AircraftID`, `AircraftTypeID`, `RegNum`, `LastMaintEnd`, `NextMaintBegin`, `NextMaintEnd`) VALUES(3565, 503, 'ZX5830', '2018-01-19', '2018-11-15', '2018-12-15');
INSERT INTO `aircraft` (`AircraftID`, `AircraftTypeID`, `RegNum`, `LastMaintEnd`, `NextMaintBegin`, `NextMaintEnd`) VALUES(3201, 617, 'ZX7472', '2018-02-15', '2018-10-15', '2018-10-27');
INSERT INTO `aircraft` (`AircraftID`, `AircraftTypeID`, `RegNum`, `LastMaintEnd`, `NextMaintBegin`, `NextMaintEnd`) VALUES(3223, 618, 'ZX1037', '2018-03-06', '2018-09-16', '2018-09-30');
INSERT INTO `aircraft` (`AircraftID`, `AircraftTypeID`, `RegNum`, `LastMaintEnd`, `NextMaintBegin`, `NextMaintEnd`) VALUES(3130, 616, 'ZX7391', '2018-02-15', '2018-04-15', '2018-05-15');

-- --------------------------------------------------------

--
-- Table structure for table `aircrafttype`
--

DROP TABLE IF EXISTS `aircrafttype`;
CREATE TABLE `aircrafttype` (
  `AircraftTypeID` smallint(4) unsigned NOT NULL AUTO_INCREMENT,
  `AircraftName` varchar(255) NOT NULL,
  PRIMARY KEY (`AircraftTypeID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

--
-- Dumping data for table `aircrafttype`
--

INSERT INTO `aircrafttype` (`AircraftTypeID`, `AircraftName`) VALUES(503, 'Boeing 747');
INSERT INTO `aircrafttype` (`AircraftTypeID`, `AircraftName`) VALUES(504, 'Boeing 767');
INSERT INTO `aircrafttype` (`AircraftTypeID`, `AircraftName`) VALUES(615, 'Airbus A300SW/310SM');
INSERT INTO `aircrafttype` (`AircraftTypeID`, `AircraftName`) VALUES(616, 'Airbus A330');
INSERT INTO `aircrafttype` (`AircraftTypeID`, `AircraftName`) VALUES(617, 'Airbus A340SW');
INSERT INTO `aircrafttype` (`AircraftTypeID`, `AircraftName`) VALUES(618, 'Airbus A380SM');

-- --------------------------------------------------------

--
-- Table structure for table `airport`
--

DROP TABLE IF EXISTS `airport`;
CREATE TABLE `airport` (
  `AirportID` smallint(5) unsigned NOT NULL,
  `AirportCode` char(3) NOT NULL,
  `AirportName` varchar(255) NOT NULL,
  `CityName` varchar(255) NOT NULL,
  `CountryCode` char(2) NOT NULL,
  `NumRunways` tinyint(1) unsigned NOT NULL,
  `NumTerminals` tinyint(1) unsigned NOT NULL,
  PRIMARY KEY (`AirportID`),
  UNIQUE KEY `AirportCode_2` (`AirportCode`),
  KEY `AirportCode` (`AirportCode`),
  KEY `CountryCode` (`CountryCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `airport`
--

INSERT INTO `airport` (`AirportID`, `AirportCode`, `AirportName`, `CityName`, `CountryCode`, `NumRunways`, `NumTerminals`) VALUES(34, 'ORY', 'Orly Airport', 'Paris', 'FR', 3, 2);
INSERT INTO `airport` (`AirportID`, `AirportCode`, `AirportName`, `CityName`, `CountryCode`, `NumRunways`, `NumTerminals`) VALUES(48, 'LGW', 'Gatwick Airport', 'London', 'UK', 2, 2);
INSERT INTO `airport` (`AirportID`, `AirportCode`, `AirportName`, `CityName`, `CountryCode`, `NumRunways`, `NumTerminals`) VALUES(56, 'LHR', 'Heathrow Airport', 'London', 'UK', 2, 5);
INSERT INTO `airport` (`AirportID`, `AirportCode`, `AirportName`, `CityName`, `CountryCode`, `NumRunways`, `NumTerminals`) VALUES(59, 'CIA', 'Rome Ciampino Airport', 'Rome', 'IT', 1, 1);
INSERT INTO `airport` (`AirportID`, `AirportCode`, `AirportName`, `CityName`, `CountryCode`, `NumRunways`, `NumTerminals`) VALUES(62, 'AMS', 'Schiphol Airport', 'Amsterdam', 'NL', 6, 1);
INSERT INTO `airport` (`AirportID`, `AirportCode`, `AirportName`, `CityName`, `CountryCode`, `NumRunways`, `NumTerminals`) VALUES(72, 'BCN', 'Barcelona International Airport', 'Barcelona', 'ES', 3, 3);
INSERT INTO `airport` (`AirportID`, `AirportCode`, `AirportName`, `CityName`, `CountryCode`, `NumRunways`, `NumTerminals`) VALUES(74, 'MUC', 'Franz Josef Strauss Airport', 'Munich', 'DE', 3, 2);
INSERT INTO `airport` (`AirportID`, `AirportCode`, `AirportName`, `CityName`, `CountryCode`, `NumRunways`, `NumTerminals`) VALUES(83, 'LIS', 'Lisbon Airport', 'Lisbon', 'PT', 2, 2);
INSERT INTO `airport` (`AirportID`, `AirportCode`, `AirportName`, `CityName`, `CountryCode`, `NumRunways`, `NumTerminals`) VALUES(87, 'BUD', 'Budapest Ferihegy International Airport', 'Budapest', 'HU', 2, 2);
INSERT INTO `airport` (`AirportID`, `AirportCode`, `AirportName`, `CityName`, `CountryCode`, `NumRunways`, `NumTerminals`) VALUES(92, 'ZRH', 'Zurich Airport ', 'Zurich', 'CH', 3, 1);
INSERT INTO `airport` (`AirportID`, `AirportCode`, `AirportName`, `CityName`, `CountryCode`, `NumRunways`, `NumTerminals`) VALUES(126, 'BOM', 'Chhatrapati Shivaji International Airport ', 'Bombay', 'IN', 2, 2);
INSERT INTO `airport` (`AirportID`, `AirportCode`, `AirportName`, `CityName`, `CountryCode`, `NumRunways`, `NumTerminals`) VALUES(129, 'BRS', 'Bristol International Airport', 'Bristol', 'UK', 1, 1);
INSERT INTO `airport` (`AirportID`, `AirportCode`, `AirportName`, `CityName`, `CountryCode`, `NumRunways`, `NumTerminals`) VALUES(132, 'MAD', 'Barajas Airport', 'Madrid', 'ES', 4, 4);
INSERT INTO `airport` (`AirportID`, `AirportCode`, `AirportName`, `CityName`, `CountryCode`, `NumRunways`, `NumTerminals`) VALUES(165, 'NCE', 'Nice Côte d''Azur Airport ', 'Nice', 'FR', 2, 2);
INSERT INTO `airport` (`AirportID`, `AirportCode`, `AirportName`, `CityName`, `CountryCode`, `NumRunways`, `NumTerminals`) VALUES(201, 'SIN', 'Changi Airport', 'Singapore', 'SG', 3, 3);

-- --------------------------------------------------------

--
-- Table structure for table `class`
--

DROP TABLE IF EXISTS `class`;
CREATE TABLE `class` (
  `ClassID` int(11) NOT NULL AUTO_INCREMENT,
  `ClassName` varchar(25) NOT NULL,
  PRIMARY KEY (`ClassID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

--
-- Dumping data for table `class`
--

INSERT INTO `class` (`ClassID`, `ClassName`) VALUES(1, 'Platinum');
INSERT INTO `class` (`ClassID`, `ClassName`) VALUES(2, 'Gold');
INSERT INTO `class` (`ClassID`, `ClassName`) VALUES(3, 'Silver');

-- --------------------------------------------------------

--
-- Table structure for table `flight`
--

DROP TABLE IF EXISTS `flight`;
CREATE TABLE `flight` (
  `FlightID` smallint(4) unsigned NOT NULL AUTO_INCREMENT,
  `RouteID` smallint(4) unsigned NOT NULL,
  `AircraftID` smallint(4) unsigned NOT NULL,
  PRIMARY KEY (`FlightID`),
  KEY `AircraftID` (`AircraftID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

--
-- Dumping data for table `flight`
--

INSERT INTO `flight` (`FlightID`, `RouteID`, `AircraftID`) VALUES(345, 1003, 3452);
INSERT INTO `flight` (`FlightID`, `RouteID`, `AircraftID`) VALUES(535, 1005, 3451);
INSERT INTO `flight` (`FlightID`, `RouteID`, `AircraftID`) VALUES(589, 1097, 3467);
INSERT INTO `flight` (`FlightID`, `RouteID`, `AircraftID`) VALUES(652, 1018, 3465);
INSERT INTO `flight` (`FlightID`, `RouteID`, `AircraftID`) VALUES(662, 1018, 3465);
INSERT INTO `flight` (`FlightID`, `RouteID`, `AircraftID`) VALUES(663, 1009, 3427);
INSERT INTO `flight` (`FlightID`, `RouteID`, `AircraftID`) VALUES(671, 1169, 3201);
INSERT INTO `flight` (`FlightID`, `RouteID`, `AircraftID`) VALUES(672, 1169, 3223);
INSERT INTO `flight` (`FlightID`, `RouteID`, `AircraftID`) VALUES(674, 1165, 3427);
INSERT INTO `flight` (`FlightID`, `RouteID`, `AircraftID`) VALUES(675, 1023, 3451);
INSERT INTO `flight` (`FlightID`, `RouteID`, `AircraftID`) VALUES(681, 1123, 3189);
INSERT INTO `flight` (`FlightID`, `RouteID`, `AircraftID`) VALUES(685, 1180, 3470);
INSERT INTO `flight` (`FlightID`, `RouteID`, `AircraftID`) VALUES(687, 1191, 3128);
INSERT INTO `flight` (`FlightID`, `RouteID`, `AircraftID`) VALUES(688, 1139, 3130);
INSERT INTO `flight` (`FlightID`, `RouteID`, `AircraftID`) VALUES(689, 1140, 3130);
INSERT INTO `flight` (`FlightID`, `RouteID`, `AircraftID`) VALUES(702, 1008, 3469);
INSERT INTO `flight` (`FlightID`, `RouteID`, `AircraftID`) VALUES(708, 1006, 3469);
INSERT INTO `flight` (`FlightID`, `RouteID`, `AircraftID`) VALUES(724, 1193, 3125);
INSERT INTO `flight` (`FlightID`, `RouteID`, `AircraftID`) VALUES(725, 1192, 3125);
INSERT INTO `flight` (`FlightID`, `RouteID`, `AircraftID`) VALUES(765, 1133, 3425);
INSERT INTO `flight` (`FlightID`, `RouteID`, `AircraftID`) VALUES(812, 1190, 3565);
INSERT INTO `flight` (`FlightID`, `RouteID`, `AircraftID`) VALUES(826, 1209, 3469);
INSERT INTO `flight` (`FlightID`, `RouteID`, `AircraftID`) VALUES(833, 1061, 3469);
INSERT INTO `flight` (`FlightID`, `RouteID`, `AircraftID`) VALUES(857, 1059, 3565);
INSERT INTO `flight` (`FlightID`, `RouteID`, `AircraftID`) VALUES(871, 1173, 3201);
INSERT INTO `flight` (`FlightID`, `RouteID`, `AircraftID`) VALUES(872, 1173, 3223);
INSERT INTO `flight` (`FlightID`, `RouteID`, `AircraftID`) VALUES(876, 1175, 3467);
INSERT INTO `flight` (`FlightID`, `RouteID`, `AircraftID`) VALUES(877, 1176, 3467);
INSERT INTO `flight` (`FlightID`, `RouteID`, `AircraftID`) VALUES(896, 1141, 3145);
INSERT INTO `flight` (`FlightID`, `RouteID`, `AircraftID`) VALUES(897, 1142, 3145);
INSERT INTO `flight` (`FlightID`, `RouteID`, `AircraftID`) VALUES(898, 1141, 3145);
INSERT INTO `flight` (`FlightID`, `RouteID`, `AircraftID`) VALUES(899, 1142, 3145);

-- --------------------------------------------------------

--
-- Table structure for table `flightclass`
--

DROP TABLE IF EXISTS `flightclass`;
CREATE TABLE `flightclass` (
  `FlightID` smallint(6) NOT NULL,
  `ClassID` char(1) NOT NULL,
  `MaxSeats` smallint(6) NOT NULL,
  `BasePrice` int(11) NOT NULL,
  KEY `ClassID` (`ClassID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `flightclass`
--

INSERT INTO `flightclass` (`FlightID`, `ClassID`, `MaxSeats`, `BasePrice`) VALUES(535, '2', 50, 200);
INSERT INTO `flightclass` (`FlightID`, `ClassID`, `MaxSeats`, `BasePrice`) VALUES(535, '3', 150, 50);
INSERT INTO `flightclass` (`FlightID`, `ClassID`, `MaxSeats`, `BasePrice`) VALUES(876, '2', 85, 250);
INSERT INTO `flightclass` (`FlightID`, `ClassID`, `MaxSeats`, `BasePrice`) VALUES(876, '3', 100, 35);
INSERT INTO `flightclass` (`FlightID`, `ClassID`, `MaxSeats`, `BasePrice`) VALUES(876, '1', 10, 300);
INSERT INTO `flightclass` (`FlightID`, `ClassID`, `MaxSeats`, `BasePrice`) VALUES(652, '2', 10, 200);
INSERT INTO `flightclass` (`FlightID`, `ClassID`, `MaxSeats`, `BasePrice`) VALUES(652, '3', 20, 50);

-- --------------------------------------------------------

--
-- Table structure for table `flightdep`
--

DROP TABLE IF EXISTS `flightdep`;
CREATE TABLE `flightdep` (
  `FlightID` smallint(6) NOT NULL,
  `DepDay` tinyint(4) NOT NULL,
  `DepTime` time NOT NULL,
  PRIMARY KEY (`FlightID`,`DepDay`,`DepTime`),
  KEY `DepDay` (`DepDay`,`DepTime`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `flightdep`
--

INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(345, 1, '21:30:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(345, 2, '21:30:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(345, 3, '21:30:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(345, 4, '21:30:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(345, 5, '21:30:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(345, 6, '21:30:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(345, 7, '21:30:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(535, 2, '15:30:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(535, 4, '15:30:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(589, 6, '20:05:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(589, 7, '20:05:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(652, 1, '14:10:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(652, 2, '14:10:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(652, 3, '14:10:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(652, 4, '14:10:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(652, 5, '14:10:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(662, 6, '17:45:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(662, 7, '17:45:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(663, 1, '09:10:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(663, 2, '09:10:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(663, 3, '09:10:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(663, 4, '09:10:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(663, 5, '09:10:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(671, 1, '16:55:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(671, 3, '16:55:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(671, 5, '16:55:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(672, 2, '16:55:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(672, 4, '16:55:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(672, 6, '16:55:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(672, 7, '16:55:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(674, 1, '14:25:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(674, 2, '14:25:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(674, 3, '14:25:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(674, 4, '14:25:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(675, 1, '07:30:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(675, 3, '07:30:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(675, 5, '07:30:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(681, 1, '08:15:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(685, 1, '21:45:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(685, 2, '21:45:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(685, 3, '21:45:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(687, 2, '19:35:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(687, 3, '19:35:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(687, 4, '19:35:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(688, 3, '13:45:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(688, 4, '13:45:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(688, 5, '13:45:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(688, 6, '13:45:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(689, 3, '19:00:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(689, 4, '19:00:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(689, 5, '19:00:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(689, 6, '19:00:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(702, 5, '09:30:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(702, 6, '09:30:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(702, 7, '09:30:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(708, 5, '12:45:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(708, 6, '12:45:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(708, 7, '12:45:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(724, 3, '23:30:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(724, 7, '23:30:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(725, 1, '17:30:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(725, 4, '17:30:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(765, 2, '01:45:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(765, 4, '01:45:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(765, 6, '01:45:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(812, 1, '14:30:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(812, 2, '14:30:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(812, 3, '14:30:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(812, 4, '14:30:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(812, 5, '14:30:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(826, 2, '13:45:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(833, 3, '07:00:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(857, 1, '19:30:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(857, 2, '19:30:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(857, 3, '19:30:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(857, 4, '19:30:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(857, 5, '19:30:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(871, 1, '12:50:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(871, 3, '12:50:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(871, 5, '12:50:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(872, 2, '12:50:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(872, 4, '12:50:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(872, 6, '12:50:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(872, 7, '12:50:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(876, 1, '07:10:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(876, 2, '07:10:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(876, 3, '07:10:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(876, 4, '07:10:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(876, 5, '07:10:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(877, 1, '20:30:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(877, 2, '20:30:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(877, 3, '20:30:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(877, 4, '20:30:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(877, 5, '20:30:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(896, 1, '00:30:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(896, 2, '00:30:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(896, 3, '00:30:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(896, 6, '00:30:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(896, 7, '00:30:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(897, 1, '20:15:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(897, 2, '20:15:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(897, 3, '20:15:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(897, 6, '20:15:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(897, 7, '20:15:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(898, 4, '00:10:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(898, 5, '00:10:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(899, 4, '21:15:00');
INSERT INTO `flightdep` (`FlightID`, `DepDay`, `DepTime`) VALUES(899, 5, '21:15:00');

-- --------------------------------------------------------

--
-- Table structure for table `pax`
--

DROP TABLE IF EXISTS `pax`;
CREATE TABLE `pax` (
  `RecordID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `FlightID` int(11) NOT NULL,
  `FlightDate` date NOT NULL,
  `ClassID` int(11) NOT NULL,
  `PaxName` varchar(255) NOT NULL,
  `PaxRef` varchar(255) DEFAULT NULL,
  `Note` text,
  PRIMARY KEY (`RecordID`),
  KEY `ClassID` (`ClassID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

--
-- Dumping data for table `pax`
--

INSERT INTO `pax` (`RecordID`, `FlightID`, `FlightDate`, `ClassID`, `PaxName`, `PaxRef`, `Note`) VALUES(197, 652, '2018-06-22', 2, 'Henry Rabbit', 'TG75850303', '');
INSERT INTO `pax` (`RecordID`, `FlightID`, `FlightDate`, `ClassID`, `PaxName`, `PaxRef`, `Note`) VALUES(198, 652, '2018-06-22', 3, 'Harry Hippo', 'TG75847493', '');
INSERT INTO `pax` (`RecordID`, `FlightID`, `FlightDate`, `ClassID`, `PaxName`, `PaxRef`, `Note`) VALUES(199, 652, '2018-06-22', 3, 'Henrietta Hippo', 'TG75847493', '');

-- --------------------------------------------------------

--
-- Table structure for table `route`
--

DROP TABLE IF EXISTS `route`;
CREATE TABLE `route` (
  `RouteID` smallint(4) unsigned NOT NULL AUTO_INCREMENT,
  `FromAirport` smallint(4) unsigned NOT NULL,
  `ToAirport` smallint(4) unsigned NOT NULL,
  `Distance` smallint(4) unsigned NOT NULL,
  `Duration` smallint(4) unsigned NOT NULL,
  `Status` tinyint(1) NOT NULL,
  PRIMARY KEY (`RouteID`),
  KEY `Duration` (`Duration`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

--
-- Dumping data for table `route`
--

INSERT INTO `route` (`RouteID`, `FromAirport`, `ToAirport`, `Distance`, `Duration`, `Status`) VALUES(1003, 126, 56, 7200, 550, 1);
INSERT INTO `route` (`RouteID`, `FromAirport`, `ToAirport`, `Distance`, `Duration`, `Status`) VALUES(1005, 34, 48, 343, 85, 1);
INSERT INTO `route` (`RouteID`, `FromAirport`, `ToAirport`, `Distance`, `Duration`, `Status`) VALUES(1176, 56, 132, 1267, 150, 1);
INSERT INTO `route` (`RouteID`, `FromAirport`, `ToAirport`, `Distance`, `Duration`, `Status`) VALUES(1175, 132, 56, 1267, 150, 1);
INSERT INTO `route` (`RouteID`, `FromAirport`, `ToAirport`, `Distance`, `Duration`, `Status`) VALUES(1018, 34, 87, 1248, 135, 1);
INSERT INTO `route` (`RouteID`, `FromAirport`, `ToAirport`, `Distance`, `Duration`, `Status`) VALUES(1023, 48, 59, 1434, 150, 1);
INSERT INTO `route` (`RouteID`, `FromAirport`, `ToAirport`, `Distance`, `Duration`, `Status`) VALUES(1008, 34, 165, 686, 60, 1);
INSERT INTO `route` (`RouteID`, `FromAirport`, `ToAirport`, `Distance`, `Duration`, `Status`) VALUES(1009, 34, 92, 489, 70, 1);
INSERT INTO `route` (`RouteID`, `FromAirport`, `ToAirport`, `Distance`, `Duration`, `Status`) VALUES(1165, 92, 59, 683, 50, 1);
INSERT INTO `route` (`RouteID`, `FromAirport`, `ToAirport`, `Distance`, `Duration`, `Status`) VALUES(1167, 92, 56, 777, 70, 0);
INSERT INTO `route` (`RouteID`, `FromAirport`, `ToAirport`, `Distance`, `Duration`, `Status`) VALUES(1123, 92, 48, 777, 60, 1);
INSERT INTO `route` (`RouteID`, `FromAirport`, `ToAirport`, `Distance`, `Duration`, `Status`) VALUES(1133, 74, 126, 6336, 470, 1);
INSERT INTO `route` (`RouteID`, `FromAirport`, `ToAirport`, `Distance`, `Duration`, `Status`) VALUES(1141, 126, 201, 3913, 320, 1);
INSERT INTO `route` (`RouteID`, `FromAirport`, `ToAirport`, `Distance`, `Duration`, `Status`) VALUES(1142, 201, 126, 3915, 320, 1);
INSERT INTO `route` (`RouteID`, `FromAirport`, `ToAirport`, `Distance`, `Duration`, `Status`) VALUES(1180, 201, 56, 10863, 815, 1);
INSERT INTO `route` (`RouteID`, `FromAirport`, `ToAirport`, `Distance`, `Duration`, `Status`) VALUES(1193, 201, 92, 10310, 760, 1);
INSERT INTO `route` (`RouteID`, `FromAirport`, `ToAirport`, `Distance`, `Duration`, `Status`) VALUES(1191, 74, 83, 1966, 190, 1);
INSERT INTO `route` (`RouteID`, `FromAirport`, `ToAirport`, `Distance`, `Duration`, `Status`) VALUES(1071, 132, 72, 505, 65, 0);
INSERT INTO `route` (`RouteID`, `FromAirport`, `ToAirport`, `Distance`, `Duration`, `Status`) VALUES(1190, 72, 165, 488, 80, 1);
INSERT INTO `route` (`RouteID`, `FromAirport`, `ToAirport`, `Distance`, `Duration`, `Status`) VALUES(1173, 72, 62, 1237, 130, 1);
INSERT INTO `route` (`RouteID`, `FromAirport`, `ToAirport`, `Distance`, `Duration`, `Status`) VALUES(1169, 62, 92, 612, 120, 1);
INSERT INTO `route` (`RouteID`, `FromAirport`, `ToAirport`, `Distance`, `Duration`, `Status`) VALUES(1139, 83, 87, 2474, 150, 1);
INSERT INTO `route` (`RouteID`, `FromAirport`, `ToAirport`, `Distance`, `Duration`, `Status`) VALUES(1140, 87, 83, 2474, 150, 1);
INSERT INTO `route` (`RouteID`, `FromAirport`, `ToAirport`, `Distance`, `Duration`, `Status`) VALUES(1097, 129, 165, 1134, 120, 1);
INSERT INTO `route` (`RouteID`, `FromAirport`, `ToAirport`, `Distance`, `Duration`, `Status`) VALUES(1209, 56, 59, 1434, 150, 1);
INSERT INTO `route` (`RouteID`, `FromAirport`, `ToAirport`, `Distance`, `Duration`, `Status`) VALUES(1006, 165, 132, 974, 125, 1);
INSERT INTO `route` (`RouteID`, `FromAirport`, `ToAirport`, `Distance`, `Duration`, `Status`) VALUES(1059, 165, 62, 978, 130, 1);
INSERT INTO `route` (`RouteID`, `FromAirport`, `ToAirport`, `Distance`, `Duration`, `Status`) VALUES(1061, 48, 87, 1452, 155, 1);
INSERT INTO `route` (`RouteID`, `FromAirport`, `ToAirport`, `Distance`, `Duration`, `Status`) VALUES(1192, 92, 201, 10310, 760, 0);

-- --------------------------------------------------------

--
-- Table structure for table `stats`
--

DROP TABLE IF EXISTS `stats`;
CREATE TABLE `stats` (
  `FlightID` int(11) NOT NULL,
  `FlightDate` date NOT NULL,
  `ClassID` int(11) NOT NULL,
  `CurrSeats` int(11) NOT NULL,
  `CurrPrice` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `stats`
--

INSERT INTO `stats` (`FlightID`, `FlightDate`, `ClassID`, `CurrSeats`, `CurrPrice`) VALUES(652, '2018-06-20', 2, 9, 200);
INSERT INTO `stats` (`FlightID`, `FlightDate`, `ClassID`, `CurrSeats`, `CurrPrice`) VALUES(652, '2018-06-20', 3, 17, 50);
INSERT INTO `stats` (`FlightID`, `FlightDate`, `ClassID`, `CurrSeats`, `CurrPrice`) VALUES(876, '2018-07-23', 1, 10, 300);
INSERT INTO `stats` (`FlightID`, `FlightDate`, `ClassID`, `CurrSeats`, `CurrPrice`) VALUES(876, '2018-06-30', 2, 85, 250);
INSERT INTO `stats` (`FlightID`, `FlightDate`, `ClassID`, `CurrSeats`, `CurrPrice`) VALUES(876, '2018-06-24', 3, 100, 35);
INSERT INTO `stats` (`FlightID`, `FlightDate`, `ClassID`, `CurrSeats`, `CurrPrice`) VALUES(876, '2018-07-18', 1, 3, 300);
INSERT INTO `stats` (`FlightID`, `FlightDate`, `ClassID`, `CurrSeats`, `CurrPrice`) VALUES(876, '2018-07-08', 2, 3, 250);
INSERT INTO `stats` (`FlightID`, `FlightDate`, `ClassID`, `CurrSeats`, `CurrPrice`) VALUES(876, '2018-03-08', 3, 3, 35);