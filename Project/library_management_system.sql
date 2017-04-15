
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

CREATE DATABASE IF NOT EXISTS library_management_system;

use library_management_system;

CREATE TABLE IF NOT EXISTS `book` (
  `ID` int(11) NOT NULL,
  `name` varchar(250) NOT NULL,
  `serialNo` int(11) NOT NULL,
  `description` text NOT NULL,
  `publishingHouse` varchar(250) NOT NULL,
  `author` varchar(250) NOT NULL,
  `numberPaper` int(20) NOT NULL,
  `type` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE IF NOT EXISTS `invoice` (
  `ID` int(11) NOT NULL,
  `date` date NOT NULL,
  `totalAmount` int(20) NOT NULL,
  `memberName` varchar(250) NOT NULL,
  `numberBook` int(11) NOT NULL,
  `nameBook` varchar(250) NOT NULL,
  `priceBook` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



CREATE TABLE IF NOT EXISTS `librarian` (
  `ID` int(11) NOT NULL,
  `username` varchar(250) NOT NULL,
  `password` varchar(200) NOT NULL,
  `salary` double NOT NULL,
  `admin` bit(1) NOT NULL DEFAULT b'0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE IF NOT EXISTS `section` (
  `ID` int(11) NOT NULL,
  `name` varchar(250) NOT NULL,
  `description` text NOT NULL,
  `serialNo` int(11) NOT NULL,
  `numberBook` int(11) NOT NULL,
  `subSection` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE IF NOT EXISTS `subSection` (
  `ID` int(11) NOT NULL,
  `name` varchar(250) NOT NULL,
  `parent` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE IF NOT EXISTS `typeUser` (
  `ID` int(11) NOT NULL,
  `typeUser` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `typeUser` (`ID`, `typeUser`) VALUES
(1, 'librarian'),
(2, 'member');


CREATE TABLE IF NOT EXISTS `users` (
  `ID` int(11) NOT NULL,
  `name` varchar(250) NOT NULL,
  `address` varchar(250) NOT NULL,
  `email` varchar(250) NOT NULL,
  `ssn` int(20) NOT NULL,
  `gender` bit(1) NOT NULL,
  `phone` int(20) NOT NULL,
  `dateBirth` date NOT NULL,
  `typeUser` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


ALTER TABLE `book`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `serialNo` (`serialNo`),
  ADD KEY `fk_forign_book_sec` (`type`);


ALTER TABLE `invoice`
  ADD PRIMARY KEY (`ID`);


ALTER TABLE `librarian`
  ADD PRIMARY KEY (`ID`);


ALTER TABLE `section`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `serialNo` (`serialNo`),
  ADD KEY `fk_forign_sec` (`subSection`);


ALTER TABLE `subSection`
  ADD PRIMARY KEY (`ID`);


ALTER TABLE `typeUser`
  ADD PRIMARY KEY (`ID`);


ALTER TABLE `users`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `fk_forign_user_typeUser` (`typeUser`);


ALTER TABLE `book`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;


ALTER TABLE `invoice`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `librarian`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `section`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `subSection`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `typeUser`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

ALTER TABLE `users`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;


ALTER TABLE `book`
  ADD CONSTRAINT `fk_forign_book_sec` FOREIGN KEY (`type`) REFERENCES `section` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `section`
  ADD CONSTRAINT `fk_forign_sec` FOREIGN KEY (`subSection`) REFERENCES `subSection` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;


ALTER TABLE `users`
  ADD CONSTRAINT `fk_forign_user_typeUser` FOREIGN KEY (`typeUser`) REFERENCES `typeUser` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;


