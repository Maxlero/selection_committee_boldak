-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Apr 24, 2018 at 01:25 PM
-- Server version: 5.6.34-log
-- PHP Version: 7.1.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `selection_committee`
--

-- --------------------------------------------------------

--
-- Table structure for table `faculty`
--

CREATE TABLE `faculty` (
  `id` int(11) NOT NULL,
  `faculty` varchar(255) DEFAULT NULL,
  `requirement` int(11) NOT NULL,
  `subject1` varchar(255) DEFAULT NULL,
  `subject2` varchar(255) DEFAULT NULL,
  `subject3` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `faculty`
--

INSERT INTO `faculty` (`id`, `faculty`, `requirement`, `subject1`, `subject2`, `subject3`) VALUES
(4, 'Mathematical', 300, 'Mathematics', 'Physics', 'Russian language'),
(5, 'Not mathematical', 30, 'Steps count in 30 seconds', 'Number of heart beats in 10 seconds', 'Number of knee lifts per step');

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(9),
(9),
(9);

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`id`, `name`) VALUES
(2, 'ROLE_ADMIN'),
(4, 'ROLE_USER'),
(6, 'ROLE_USER'),
(8, 'ROLE_USER');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `certificate` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `faculty` int(11) NOT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `mark1` int(11) NOT NULL,
  `mark2` int(11) NOT NULL,
  `mark3` int(11) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `confirmed` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `certificate`, `email`, `faculty`, `first_name`, `last_name`, `mark1`, `mark2`, `mark3`, `password`, `confirmed`) VALUES
(1, 100, 'dbsfbp@gmail.com', 4, 'Boldak', 'Dzmitry', 100, 100, 100, '$2a$10$2BUarS0wB5SWzdpEJ3RMpOCVRolQobbqowBZORkyEF4Vjkr65y5pW', 1),
(3, 91, 'drochu@kogdahochu.net', 4, 'Alexey', 'Romanovskij', 46, 48, 97, '$2a$10$GP4D0BiUbt1gddHRIGm2.e5OLVVsJFp6qrQexrcZCGEx4jk9fPMbG', 1),
(5, 99, 'sobaka@sobaka.sobaka', 5, 'Maxim', 'Orel', 0, 12, 13, '$2a$10$8QYalYaW74Yt30cTvmFtLe5hGnHnStzg5e6wBqg.I74RfUYSSkiOy', 1),
(7, 1, '123@mail.ru', 4, 'Test', 'Test', 1, 1, 1, '$2a$10$wJaBxink.oRAiS5B/PY.2.Tz97CNRW08MjhLGCyoaH9dePc8aHtfm', 0);

-- --------------------------------------------------------

--
-- Table structure for table `users_roles`
--

CREATE TABLE `users_roles` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users_roles`
--

INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES
(1, 2),
(3, 4),
(5, 6),
(7, 8);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `faculty`
--
ALTER TABLE `faculty`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users_roles`
--
ALTER TABLE `users_roles`
  ADD KEY `FKt4v0rrweyk393bdgt107vdx0x` (`role_id`),
  ADD KEY `FKgd3iendaoyh04b95ykqise6qh` (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `faculty`
--
ALTER TABLE `faculty`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
