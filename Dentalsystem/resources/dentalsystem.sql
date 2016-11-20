-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Nov 18, 2016 at 01:49 PM
-- Server version: 10.1.19-MariaDB
-- PHP Version: 5.6.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dentalsystem`
-- 

-- --------------------------------------------------------

-- 
-- Table structure for table 'treatment_healthcare_plan'
-- 

CREATE TABLE 'treatment_healthcare_plan' (
  'planName' varchar(50) NOT NULL,
  'treatName' varchar(50) NOT NULL,
  'amount' int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1

--
-- Dumping data for table 'treatments'
-- 

INSERT INTO 'treatment_healthcare_plan' ('planName', 'treatName', 'amount') VALUES
('Free NHS Plan', 'Check-up', 2);

-- --------------------------------------------------------

-- 
-- Table structure for table 'patient_healthcare_plan'
-- 

CREATE TABLE 'patient_healthcare_plan' ( 
  'patientID' int NOT NULL, 
  'planName' varchar(50) NOT NULL,
) ENGINE=InnoDB DEFAULT CHARSET=latin1

--
-- Dumping data for table 'treatments'
-- 

INSERT INTO 'patient_healthcare_plan' ('patientID', 'planName') VALUES
(1, 'Maintenance Plan');


-- --------------------------------------------------------

-- 
-- Table structure for table 'treatments'
-- 

CREATE TABLE 'treatments' (
  'treatName' varchar(50) NOT NULL,
  'treatPrice' double NOT NULL, 
  'duration' time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1

--
-- Dumping data for table 'treatments'
-- 

INSERT INTO 'treatments' ('treatName', 'treatPrice', 'duration') VALUES
('Check-up', 45.00, 00:20:00),
('Hygiene', 45.00, 00:20:00),
('Fitting a gold Crown', 500.00, 01:00:00),
('Silver amalgam filling', 90.00, 01:00:00),
('White composite resin filling', 150.00, 01:00:00);

-- -------------------------------------------------------

-- 
-- Table structure for table 'healthcare plan'
-- 

CREATE TABLE 'healthcarePlan' (
  'planName' varchar(50) NOT NULL,
  'monthlyPayment' double NOT NULL
) ENGINE=innoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table 'healthcare plan'
-- 

INSERT INTO 'healthcarePlan' ('planName', 'monthlyPayment') VALUES 
('NHS free Plan',  0.00),
('Maintenance Plan', 15.00),
('Oral Heath Plan',  21.00),
('Dental Repair Plan', 36.00);



-- --------------------------------------------------------

--
-- Table structure for table `appointment`
--

CREATE TABLE `appointment` (
  `patientID` int(11) NOT NULL,
  `practitionerID` int(11) NOT NULL,
  `startTime` datetime NOT NULL,
  `endTime` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `appointment`
--

INSERT INTO `appointment` (`patientID`, `practitionerID`, `startTime`, `endTime`) VALUES
(1, 1, '2016-11-24 10:30:00', '2016-11-24 11:00:00'),
(1, 1, '2016-11-25 12:30:00', '2016-11-25 13:00:00'),
(1, 1, '2016-11-30 00:00:00', '2016-11-30 00:00:00'),
(1, 1, '2016-12-15 00:00:00', '2016-12-15 00:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `patient`
--

CREATE TABLE `patient` (
  `id` int(11) NOT NULL,
  `title` varchar(10) NOT NULL,
  `forename` varchar(20) NOT NULL,
  `surname` varchar(20) NOT NULL,
  `dateOfBirth` datetime NOT NULL,
  `contactNumer` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `patient`
--

INSERT INTO `patient` (`id`, `title`, `forename`, `surname`, `dateOfBirth`, `contactNumer`) VALUES
(1, 'Mr', 'Matheus', 'Gomes', '2016-07-29 00:00:00', '0732384783');

-- --------------------------------------------------------

--
-- Table structure for table `practitioner`
--

CREATE TABLE `practitioner` (
  `id` int(11) NOT NULL,
  `surname` varchar(20) NOT NULL,
  `forename` varchar(20) NOT NULL,
  `role` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `practitioner`
--

INSERT INTO `practitioner` (`id`, `surname`, `forename`, `role`) VALUES
(1, 'Barker', 'John', 'Dentist');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `type` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`username`, `password`, `type`) VALUES
('matheus', 'password', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `appointment`
--
ALTER TABLE `appointment`
  ADD PRIMARY KEY (`practitionerID`,`startTime`),
  ADD KEY `patientID` (`patientID`);

--
-- Indexes for table `patient`
--
ALTER TABLE `patient`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `practitioner`
--
ALTER TABLE `practitioner`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `appointment`
--
ALTER TABLE `appointment`
  MODIFY `patientID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `patient`
--
ALTER TABLE `patient`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `practitioner`
--
ALTER TABLE `practitioner`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `appointment`
--
ALTER TABLE `appointment`
  ADD CONSTRAINT `appointment_ibfk_1` FOREIGN KEY (`patientID`) REFERENCES `patient` (`id`),
  ADD CONSTRAINT `appointment_ibfk_2` FOREIGN KEY (`practitionerID`) REFERENCES `practitioner` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
