CREATE TABLE `User` (
  `UserID` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `Username` VARCHAR(16) UNIQUE NOT NULL,
  `Password` VARCHAR(31) NOT NULL,
  `Email` VARCHAR(31) UNIQUE NOT NULL,
  `Phone` VARCHAR(11)
);

CREATE TABLE `Account` (
  `AccountNumber` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `UserID` INT NOT NULL,
  `AccountType` TINYINT NOT NULL,
  `Balance` DOUBLE NOT NULL
);

CREATE TABLE `Transaction` (
  `TransactionID` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `AccountNumber` INT NOT NULL,
  `ProcessingDate` DATETIME NOT NULL,
  `TransactionType` TINYINT NOT NULL,
  `Amount` DOUBLE NOT NULL,
  `Description` VARCHAR(31) NOT NULL,
  `Category` TINYINT NOT NULL,
  `State` CHAR(2) NOT NULL
);

CREATE TABLE `Trigger` (
  `TriggerID` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `UserID` INT NOT NULL,
  `TriggerName` VARCHAR(31) UNIQUE NOT NULL,
  `TriggerType` TINYINT NOT NULL,
  `TriggerDescription` VARCHAR(31) NOT NULL
);

CREATE TABLE `Notifications` (
  `NotificationID` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `TriggerID` INT NOT NULL,
  `TransactionID` INT NOT NULL,
  `Message` VARCHAR(255) NOT NULL,
  `ReadStatus` BOOLEAN NOT NULL DEFAULT false
);

ALTER TABLE `Account` ADD FOREIGN KEY (`UserID`) REFERENCES `User` (`UserID`);

ALTER TABLE `Transaction` ADD FOREIGN KEY (`AccountNumber`) REFERENCES `Account` (`AccountNumber`);

ALTER TABLE `Trigger` ADD FOREIGN KEY (`UserID`) REFERENCES `User` (`UserID`);

ALTER TABLE `Notifications` ADD FOREIGN KEY (`TriggerID`) REFERENCES `Trigger` (`TriggerID`);

ALTER TABLE `Notifications` ADD FOREIGN KEY (`TransactionID`) REFERENCES `Transaction` (`TransactionID`);
