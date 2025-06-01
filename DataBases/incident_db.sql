-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 01, 2025 at 06:25 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

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
-- Table structure for table `incident_table`
--

CREATE TABLE `incident_table` (
  `id` int(255) NOT NULL,
  `incident` varchar(255) NOT NULL,
  `time` varchar(45) DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  `people_involved` varchar(255) DEFAULT NULL,
  `location` varchar(45) DEFAULT NULL,
  `description` varchar(255) NOT NULL,
  `officer` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL,
  `date_passed` varchar(255) NOT NULL,
  `resolve_description` varchar(255) NOT NULL,
  `resolved_by` varchar(255) NOT NULL,
  `date_finished` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `incident_table`
--

INSERT INTO `incident_table` (`id`, `incident`, `time`, `date`, `people_involved`, `location`, `description`, `officer`, `status`, `date_passed`, `resolve_description`, `resolved_by`, `date_finished`) VALUES
(15, 'steal', '10:00 AM', '2025-06-01', 'ewewe', 'Beijing China', 'wew', 'wewe', 'Under Investigation', '2025-06-01', 'resolvedtype', 'resolvedby', '2025-06-01'),
(16, 'Crnapping', '10:00 AM', '2025-06-01', 'ewewe', 'Nanjing, China', 'wwewew', 'wewe', 'Resolved', '2025-06-01', 'ddd', 'dd', '2025-06-01'),
(17, 'Kidnapping', '10:00 AM', '2025-06-10', 'doe', 'Manila, Philippines', 'ewewe', 'anna', 'Pending', '2025-06-01', 'n/a', 'n/a', 'n/a');

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
-- Indexes for table `incident_table`
--
ALTER TABLE `incident_table`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `student_id_UNIQUE` (`id`);

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
-- Indexes for table `teacher`
--
ALTER TABLE `teacher`
  ADD PRIMARY KEY (`teacher_id`),
  ADD UNIQUE KEY `teacher_id_UNIQUE` (`teacher_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `incident_table`
--
ALTER TABLE `incident_table`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
