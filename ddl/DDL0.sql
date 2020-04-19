CREATE DATABASE IF NOT EXISTS CommerceDB;
USE CommerceDB;
CREATE TABLE IF NOT EXISTS `User` (
  `UserID` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `Username` VARCHAR(16) UNIQUE NOT NULL,
  `Password` VARCHAR(31) NOT NULL,
  `Email` VARCHAR(31) UNIQUE NOT NULL,
  `Phone` VARCHAR(11)
);

CREATE TABLE IF NOT EXISTS `Account` (
  `AccountNumber` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `UserID` INT NOT NULL,
  `AccountType` TINYINT NOT NULL,
  `Balance` DOUBLE NOT NULL
);

CREATE TABLE IF NOT EXISTS `Transaction` (
  `TransactionID` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `AccountNumber` INT NOT NULL,
  `ProcessingDate` DATETIME NOT NULL,
  `TransactionType` TINYINT NOT NULL,
  `Balance` DECIMAL(12,2) NOT NULL,
  `Amount` DECIMAL(12,2) NOT NULL,
  `Description` VARCHAR(63) NOT NULL,
  `Category` VARCHAR(23) NOT NULL,
  `State` CHAR(2) NOT NULL
);

CREATE TABLE IF NOT EXISTS `Trigger` (
  `TriggerID` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `UserID` INT NOT NULL,
  `TriggerName` VARCHAR(31) UNIQUE NOT NULL,
  `TriggerCount` INT NOT NULL DEFAULT 0
);

CREATE TABLE IF NOT EXISTS `Notifications` (
  `NotificationID` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `TriggerID` INT NOT NULL,
  `TransactionID` INT NOT NULL,
  `Message` VARCHAR(255) NOT NULL,
  `ReadStatus` BOOLEAN NOT NULL DEFAULT FALSE
);

ALTER TABLE `Account` ADD FOREIGN KEY (`UserID`) REFERENCES `User` (`UserID`);

ALTER TABLE `Transaction` ADD FOREIGN KEY (`AccountNumber`) REFERENCES `Account` (`AccountNumber`);

ALTER TABLE `Trigger` ADD FOREIGN KEY (`UserID`) REFERENCES `User` (`UserID`);

ALTER TABLE `Notifications` ADD FOREIGN KEY (`TriggerID`) REFERENCES `Trigger` (`TriggerID`);

ALTER TABLE `Notifications` ADD FOREIGN KEY (`TransactionID`) REFERENCES `Transaction` (`TransactionID`);

DROP TRIGGER IF EXISTS `CommerceDB`.`GET_TRANSACTION_BALANCE`;
DELIMITER $$
CREATE DEFINER = `commerce-notifications`@`%` TRIGGER `CommerceDB`.`GET_TRANSACTION_BALANCE` BEFORE INSERT ON `Transaction` FOR EACH ROW
BEGIN
	IF NEW.TransactionType = 1 THEN SET NEW.Balance = ( SELECT Balance FROM Account WHERE AccountNumber = NEW.AccountNumber ) - NEW.Amount;
	ELSE SET NEW.Balance = ( SELECT Balance FROM Account WHERE AccountNumber = NEW.AccountNumber ) + NEW.Amount;
    END IF;
    
    UPDATE Account
	SET Balance = NEW.Balance
	WHERE AccountNumber = NEW.AccountNumber;
END$$
DELIMITER ;

-- TODO trigger for duplicate transactions
-- DROP TRIGGER IF EXISTS `CommerceDB`.`DUPLICATE_TRANSACTIONS`;
-- DELIMITER $$
-- CREATE DEFINER = `commerce-notifications`@`%` TRIGGER `CommerceDB`.`DUPLICATE_TRANSACTIONS` AFTER INSERT ON `Transaction` FOR EACH ROW
-- BEGIN
-- 	IF NEW.TransactionType = 1
--     THEN IF;
-- 		
--     END IF;
--     
--     UPDATE Account
-- 	SET Balance = NEW.Balance
-- 	WHERE AccountNumber = NEW.AccountNumber;
-- END$$
-- DELIMITER ;
