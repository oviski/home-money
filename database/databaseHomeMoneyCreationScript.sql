SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `java2` DEFAULT CHARACTER SET utf8 ;
USE `java2` ;

-- -----------------------------------------------------
-- Table `Java2_test`.`users`
-- -----------------------------------------------------
-- DROP TABLE IF EXISTS `users` ;
--ALTER TABLE `Checks` DROP FOREIGN KEY `Checks_fk0`;
--
--ALTER TABLE `Category` DROP FOREIGN KEY `Category_fk0`;
--
--ALTER TABLE `Subcategory` DROP FOREIGN KEY `Subcategory_fk0`;
--
--ALTER TABLE `UsersID` DROP FOREIGN KEY `UsersID_fk0`;
--
--ALTER TABLE `UsersMoneyAccount` DROP FOREIGN KEY `UsersMoneyAccount_fk0`;
--
--ALTER TABLE `Products` DROP FOREIGN KEY `Products_fk0`;
--
--DROP TABLE IF EXISTS `Checks`;
--
--DROP TABLE IF EXISTS `Details`;
--
--DROP TABLE IF EXISTS `Category`;
--
--DROP TABLE IF EXISTS `Subcategory`;
--
--DROP TABLE IF EXISTS `UsersID`;
--
--DROP TABLE IF EXISTS `UsersMoneyAccount`;
--
--DROP TABLE IF EXISTS `Products`;


CREATE TABLE `Checks` (
	`CheckID` bigint NOT NULL,
	`DatePourches` DATE NOT NULL,
	`SumOfCheck` bigint NOT NULL DEFAULT '0',
	`ShopName` varchar(15),
	`WhoPayID` int NOT NULL,
	`UserMoneyAccountID` int NOT NULL,
	`DetailsAllow` bit NOT NULL DEFAULT '0',
	`Comments` varchar,
	PRIMARY KEY (`CheckID`)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1002;

CREATE TABLE `CheckDetails` (
	`CheckID` bigint NOT NULL,
	`ChekPositionID` bigint NOT NULL,
	`CategoryID` int NOT NULL,
	`SubcategoryID` int NOT NULL,
	`ProductID` bigint NOT NULL,
	`SumOfProduct` bigint DEFAULT '0',
	`PositionDatails` varchar,
	`DetailsID` varchar NOT NULL,
	PRIMARY KEY (`DetailsID`)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1002;

CREATE TABLE `Category` (
	`CategoryID` int NOT NULL,
	`CategoryName` varchar NOT NULL UNIQUE,
	`SubcategoryAllow` bit NOT NULL DEFAULT '0',
	PRIMARY KEY (`CategoryID`)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1002;

CREATE TABLE `Subcategory` (
	`CategoryID` varchar NOT NULL,
	`SubcategoryID` bigint NOT NULL,
	`SubcategoryName` varchar NOT NULL,
	PRIMARY KEY (`SubcategoryID`)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1002;

CREATE TABLE `UsersID` (
	`UserID` int NOT NULL UNIQUE,
	`UserName` varchar NOT NULL UNIQUE,
	PRIMARY KEY (`UserID`)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1002;

CREATE TABLE `UsersMoneyAccount` (
	`UserMoneyAccountID` int NOT NULL,
	`UserID` int NOT NULL,
	`MoneyAccountName` varchar NOT NULL UNIQUE,
	PRIMARY KEY (`UserMoneyAccountID`)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1002;

CREATE TABLE `Products` (
	`ProductID` bigint NOT NULL,
	`CategoryID` int NOT NULL,
	`SubcategoryID` bigint,
	`ProductName` bigint NOT NULL,
	PRIMARY KEY (`ProductID`)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1002;

ALTER TABLE `Checks` ADD CONSTRAINT `Checks_fk0` FOREIGN KEY (`CheckID`) REFERENCES `Details`(`CheckID`);

ALTER TABLE `Category` ADD CONSTRAINT `Category_fk0` FOREIGN KEY (`CategoryID`) REFERENCES `Details`(`CategoryID`);

ALTER TABLE `Subcategory` ADD CONSTRAINT `Subcategory_fk0` FOREIGN KEY (`SubcategoryID`) REFERENCES `Details`(`SubcategoryID`);

ALTER TABLE `UsersID` ADD CONSTRAINT `UsersID_fk0` FOREIGN KEY (`UserID`) REFERENCES `Checks`(`WhoPayID`);

ALTER TABLE `UsersMoneyAccount` ADD CONSTRAINT `UsersMoneyAccount_fk0` FOREIGN KEY (`UserMoneyAccountID`) REFERENCES `Checks`(`UserMoneyAccountID`);

ALTER TABLE `Products` ADD CONSTRAINT `Products_fk0` FOREIGN KEY (`ProductID`) REFERENCES `Details`(`ProductID`);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;