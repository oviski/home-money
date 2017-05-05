SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `java2_money` DEFAULT CHARACTER SET utf8 ;
USE `java2_money` ;

DROP TABLE IF EXISTS `Checks`;
CREATE TABLE `Checks` (
	`CheckID` bigint NOT NULL,
	`DatePourches` DATE NOT NULL,
	`SumOfCheck` bigint NOT NULL DEFAULT 0,
	`ShopName` varchar(15),
	`UserID` int NOT NULL,
	`UserMoneyAccountID` int NOT NULL,
	`DetailsAllow` bit NOT NULL DEFAULT 0,
	`Comments` varchar(50),
	PRIMARY KEY (`CheckID`)
)
ENGINE = InnoDB
AUTO_INCREMENT = 101;

DROP TABLE IF EXISTS `ChecksDetails`;
CREATE TABLE `ChecksDetails` (
    `ChecksDetailsID` bigint NOT NULL,
	`CheckID` bigint NOT NULL,
	`CheckPositionID` int NOT NULL,
	`CategoryID` int NOT NULL,
	`SubcategoryID` int NOT NULL,
	`ProductID` bigint NOT NULL,
	`SumOfProduct` bigint DEFAULT 0,
	`PositionDatails` varchar(25),
	PRIMARY KEY (`ChecksDetailsID`)
)
ENGINE = InnoDB
AUTO_INCREMENT = 101;

DROP TABLE IF EXISTS `Users`;
CREATE TABLE `Users` (
	`UserID` int NOT NULL UNIQUE,
	`UserName` varchar(25) NOT NULL UNIQUE,
	PRIMARY KEY (`UserID`)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1002;

DROP TABLE IF EXISTS `UserMoneyAccounts`;
CREATE TABLE `UserMoneyAccounts` (
	`UserMoneyAccountID` int NOT NULL,
	`UserID` int NOT NULL,
	`MoneyAccountName` varchar(25) NOT NULL UNIQUE,
	PRIMARY KEY (`UserMoneyAccountID`)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1002;

DROP TABLE IF EXISTS `Category`;
CREATE TABLE `Category` (
	`CategoryID` int NOT NULL,
	`CategoryName` varchar(15) NOT NULL UNIQUE,
	`SubcategoryAllow` bit NOT NULL DEFAULT 0,
	PRIMARY KEY (`CategoryID`)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1002;

DROP TABLE IF EXISTS `Subcategory`;
CREATE TABLE `Subcategory` (
	`SubcategoryID` int NOT NULL,
	`CategoryID` int NOT NULL,
	`SubcategoryName` varchar(25) NOT NULL,
	PRIMARY KEY (`SubcategoryID`)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1002;

DROP TABLE IF EXISTS `Products`;
CREATE TABLE `Products` (
	`ProductID` bigint NOT NULL,
	`CategoryID` int NOT NULL,
	`SubcategoryID` int,
	`ProductName` varchar(25) NOT NULL,
	PRIMARY KEY (`ProductID`)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1002;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;