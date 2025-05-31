-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 31, 2025 at 03:37 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.1.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `incident_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `userName` varchar(20) NOT NULL,
  `userpassword` varchar(45) DEFAULT NULL,
  `Hint` varchar(45) DEFAULT NULL,
  `loginAs` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`userName`, `userpassword`, `Hint`, `loginAs`) VALUES
('admin', '123456', '123', 'Barangay.Secretary'),
('brgy.tanod', '1234567', '123', 'Chief brgy.police officer');

-- --------------------------------------------------------

--
-- Table structure for table `resulttable`
--

CREATE TABLE `resulttable` (
  `id` varchar(10) NOT NULL,
  `stdName` varchar(20) DEFAULT NULL,
  `Course` varchar(20) DEFAULT NULL,
  `DSALAB` varchar(4) DEFAULT NULL,
  `MPLAB` varchar(4) DEFAULT NULL,
  `MATH` varchar(4) DEFAULT NULL,
  `FLAC` varchar(4) DEFAULT NULL,
  `SystemP` varchar(4) DEFAULT NULL,
  `DSA` varchar(4) DEFAULT NULL,
  `MP` varchar(4) DEFAULT NULL,
  `DBMS` varchar(4) DEFAULT NULL,
  `Total` varchar(4) DEFAULT NULL,
  `Average` varchar(4) DEFAULT NULL,
  `Ranking` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Table structure for table `student_registration`
--

CREATE TABLE `student_registration` (
  `id` int(255) NOT NULL,
  `incident` varchar(255) NOT NULL,
  `firstName` varchar(45) DEFAULT NULL,
  `lastName` varchar(45) DEFAULT NULL,
  `Gender` varchar(10) DEFAULT NULL,
  `Time` varchar(45) DEFAULT NULL,
  `Date` date DEFAULT NULL,
  `Involved` varchar(255) DEFAULT NULL,
  `Location` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `student_registration`
--

INSERT INTO `student_registration` (`id`, `incident`, `firstName`, `lastName`, `Gender`, `Time`, `Date`, `Involved`, `Location`) VALUES
(9, 'nakipag suntukan', 'ooscar', 'ewew', 'Male', '09:00AM', '2025-05-19', 'ewee', 'wewe'),
(11, 'crash', 'ddoe', 'john', 'Female', '1:50 am', '2025-05-30', 'mga kaklase', 'school zone'),
(12, 'gulo', 'michelle', 'conor', 'Male', '12:19 am', '2025-01-25', 'oscar', 'sanluis'),
(13, 'school incident', 'testf', 'testl', 'Female', '12:00 am', '1991-01-21', 'adada', 'asfasfsa');

-- --------------------------------------------------------

--
-- Table structure for table `teacher`
--

CREATE TABLE `teacher` (
  `teacher_id` varchar(5) NOT NULL,
  `FirstName` varchar(20) DEFAULT NULL,
  `LastName` varchar(20) DEFAULT NULL,
  `Gender` varchar(10) DEFAULT NULL,
  `Birth` date DEFAULT NULL,
  `Subject` varchar(20) DEFAULT NULL,
  `Salary` varchar(20) DEFAULT NULL,
  `Phone` varchar(20) DEFAULT NULL,
  `Address` varchar(64) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `teacher`
--

INSERT INTO `teacher` (`teacher_id`, `FirstName`, `LastName`, `Gender`, `Birth`, `Subject`, `Salary`, `Phone`, `Address`) VALUES
('12', 'saas', 'asdas', 'Male', '1991-01-19', 'dsa', '21321', '12345678909', 'adasdgdsgsd');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`userName`);

--
-- Indexes for table `resulttable`
--
ALTER TABLE `resulttable`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id_UNIQUE` (`id`);

--
-- Indexes for table `student_registration`
--
ALTER TABLE `student_registration`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `student_id_UNIQUE` (`id`);

--
-- Indexes for table `teacher`
--
ALTER TABLE `teacher`
  ADD PRIMARY KEY (`teacher_id`),
  ADD UNIQUE KEY `teacher_id_UNIQUE` (`teacher_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `student_registration`
--
ALTER TABLE `student_registration`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
