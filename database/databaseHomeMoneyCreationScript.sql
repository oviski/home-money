SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `java2` DEFAULT CHARACTER SET utf8 ;
USE `java2` ;

-- -----------------------------------------------------
-- Table `Java2_test`.`users`
-- -----------------------------------------------------
--DROP TABLE IF EXISTS `users` ;

CREATE TABLE `Checks` (
	`CheckID` bigint NOT NULL,
	`DatePourches` DATE NOT NULL,
	`SumOfCheck` bigint NOT NULL DEFAULT '0',
	`ShopName` varchar(15),
	`WhoPayID` int NOT NULL,
	`PaymentTypeID` int NOT NULL,
	`WhoPayID` int(15) NOT NULL,
	`DetailsAllow` bit NOT NULL DEFAULT '0',
	PRIMARY KEY (`CheckID`)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1002;

CREATE TABLE `Details` (
	`CheckID` bigint NOT NULL,
	`ChekPositionID` bigint NOT NULL,
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
	`SubcategoryID` bigint NOT NULL,
	`CategoryID` varchar NOT NULL,
	`SubcategoryName` varchar NOT NULL,
	PRIMARY KEY (`SubcategoryID`)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1002;

CREATE TABLE `Users` (
	`UserID` int NOT NULL UNIQUE,
	`UserName` varchar NOT NULL UNIQUE,
	PRIMARY KEY (`UserID`)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1002;

CREATE TABLE `MoneyAccounNumber` (
	`MoneyAccountID` int NOT NULL UNIQUE,
	`UserID` int NOT NULL,
	`PaymentTypeName` varchar NOT NULL
)
ENGINE = InnoDB
AUTO_INCREMENT = 1002;

CREATE TABLE `MoneyBalanse` (
	`MoneyBalanceID` bigint NOT NULL UNIQUE,
	`PaymentTypeID` int NOT NULL DEFAULT '0',
	`StandingOfMoney` bigint NOT NULL,
	`DateOfLastChange` DATETIME NOT NULL,
	`CheckID` bigint,
	`ReceiptsID` bigint,
	PRIMARY KEY (`MoneyBalanceID`)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1002;

CREATE TABLE `Receipts` (
	`ReceiptsID` bigint NOT NULL,
	`UserID` bigint NOT NULL,
	`MoneyAccountID` int NOT NULL,
	`SumOfReceipts` bigint NOT NULL DEFAULT '0',
	`DetailsReceipts` varchar NOT NULL,
	PRIMARY KEY (`ReceiptsID`)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1002;

CREATE TABLE `Products` (
	`ProductID` bigint NOT NULL,
	`ProductName` varchar NOT NULL,
	`CategoryID` int NOT NULL,
	`SubcategoryID` int NOT NULL,
	PRIMARY KEY (`ProductID`)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1002;


ALTER TABLE `Checks` ADD CONSTRAINT `Checks_fk0` FOREIGN KEY (`CheckID`) REFERENCES `Details`(`CheckID`);

ALTER TABLE `Category` ADD CONSTRAINT `Category_fk0` FOREIGN KEY (`CategoryID`) REFERENCES `Products`(`CategoryID`);

ALTER TABLE `Subcategory` ADD CONSTRAINT `Subcategory_fk0` FOREIGN KEY (`SubcategoryID`) REFERENCES `Products`(`SubcategoryID`);

ALTER TABLE `Users` ADD CONSTRAINT `Users_fk0` FOREIGN KEY (`UserID`) REFERENCES `Checks`(`WhoPayID`);

ALTER TABLE `MoneyAccounNumber` ADD CONSTRAINT `MoneyAccounNumber_fk0` FOREIGN KEY (`MoneyAccountID`) REFERENCES `Checks`(`PaymentTypeID`);

ALTER TABLE `Products` ADD CONSTRAINT `Products_fk0` FOREIGN KEY (`ProductID`) REFERENCES `Details`(`ProductID`);





SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;