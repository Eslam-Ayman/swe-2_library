

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

CREATE DATABASE IF NOT EXISTS library_management_system;

use library_management_system;

CREATE TABLE `book` (
  `ID` int(11) NOT NULL,
  `serialNo` int(11) NOT NULL,
  `state` tinyint(1) NOT NULL,
  `dateOfReturn` date NOT NULL,
  `copyID` int(11) NOT NULL,
  
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `copy` (
  `id` int(11) NOT NULL,
  `name` varchar(250) NOT NULL,
  `description` text NOT NULL,
  `author` varchar(250) NOT NULL,
  `numberOfPaper` int(20) NOT NULL,
  `price` double NOT NULL,
  `type` int(11) NOT NULL,
  `publishPlace` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `invoice` (
  `ID` int(11) NOT NULL,
  `date` date NOT NULL,
  `totalAmount` int(20) NOT NULL,
  `memberName` varchar(250) NOT NULL,
  `numberBook` int(11) NOT NULL,
  `nameBook` varchar(250) NOT NULL,
  `priceBook` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `librarian` (
  `ID` int(11) NOT NULL,
  `username` varchar(250) NOT NULL,
  `password` varchar(200) NOT NULL,
  `salary` double NOT NULL,
  `admin` tinyint(1) NOT NULL DEFAULT '0',
  `userID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `librarian` (`ID`, `username`, `password`, `salary`, `admin`, `userID`) VALUES
(1, 'enghassan', 'hassan', 2500, 1, 1);


CREATE TABLE `section` (
  `ID` int(11) NOT NULL,
  `name` varchar(250) NOT NULL,
  `description` text NOT NULL,
  `serialNo` int(11) NOT NULL,
  `numberBook` int(11) NOT NULL,
  `subSection` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `subSection` (
  `ID` int(11) NOT NULL,
  `name` varchar(250) NOT NULL,
  `parent` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



CREATE TABLE `typeUser` (
  `ID` int(11) NOT NULL,
  `typeUser` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `typeUser` (`ID`, `typeUser`) VALUES
(1, 'librarian'),
(2, 'member');



CREATE TABLE `users` (
  `ID` int(11) NOT NULL,
  `name` varchar(250) NOT NULL,
  `address` varchar(250) NOT NULL,
  `email` varchar(250) NOT NULL,
  `ssn` int(20) NOT NULL,
  `gender` tinyint(1) NOT NULL,
  `phone` int(20) NOT NULL,
  `dateBirth` date NOT NULL,
  `typeUser` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `users` (`ID`, `name`, `address`, `email`, `ssn`, `gender`, `phone`, `dateBirth`, `typeUser`) VALUES
(1, 'hassan', 'el sherouk', 'eng.hassan2015@yahoo.com', 1122, 1, 111235, '2017-04-11', 1);


ALTER TABLE `book`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `serialNo` (`serialNo`);


ALTER TABLE `copy`
  ADD PRIMARY KEY (`id`);


ALTER TABLE `invoice`
  ADD PRIMARY KEY (`ID`);


ALTER TABLE `librarian`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `fk_foreign_librarian` (`userID`);


ALTER TABLE `section`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `serialNo` (`serialNo`),
  ADD KEY `fk_forign_sec` (`subSection`);


ALTER TABLE `subSection`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `fk_forign_subsection` (`parent`);


ALTER TABLE `typeUser`
  ADD PRIMARY KEY (`ID`);


ALTER TABLE `users`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `ssn` (`ssn`),
  ADD KEY `fk_forign_user_typeUser` (`typeUser`);


ALTER TABLE `book`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `copy`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `invoice`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `librarian`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

ALTER TABLE `section`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `subSection`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `typeUser`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

ALTER TABLE `users`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;


ALTER TABLE `copy`
  ADD CONSTRAINT `fk_forign_book_sec` FOREIGN KEY (`type`) REFERENCES `section` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;


ALTER TABLE `book`
  ADD CONSTRAINT `fk_forign_book_copy` FOREIGN KEY (`copyID`) REFERENCES `copy` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;



ALTER TABLE `librarian`
  ADD CONSTRAINT `fk_foreign_librarian` FOREIGN KEY (`userID`) REFERENCES `users` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;


ALTER TABLE `section`
  ADD CONSTRAINT `fk_forign_sec` FOREIGN KEY (`subSection`) REFERENCES `subSection` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;


ALTER TABLE `subSection`
  ADD CONSTRAINT `fk_forign_subsection` FOREIGN KEY (`parent`) REFERENCES `subSection` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;


ALTER TABLE `users`
  ADD CONSTRAINT `fk_forign_user_typeUser` FOREIGN KEY (`typeUser`) REFERENCES `typeUser` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;


