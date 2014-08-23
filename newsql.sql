SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Student`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Student` (
  `idStudent` VARCHAR(12) NOT NULL,
  `firstNameSt` VARCHAR(30) NOT NULL,
  `middleNameSt` VARCHAR(20) NOT NULL,
  `lastNameSt` VARCHAR(20) NOT NULL,
  `genderSt` CHAR(2) NOT NULL,
  `birthDateSt` DATE NOT NULL,
  `yearLevelSt` INT NOT NULL,
  PRIMARY KEY (`idStudent`),
  UNIQUE INDEX `firstNameStudent_UNIQUE` (`firstNameSt` ASC),
  UNIQUE INDEX `middleNameStudent_UNIQUE` (`middleNameSt` ASC),
  UNIQUE INDEX `lastNameStudent_UNIQUE` (`lastNameSt` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Employee`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Employee` (
  `idEmployee` VARCHAR(12) NOT NULL,
  `firstNameEmp` VARCHAR(30) NOT NULL,
  `middleNameEmp` VARCHAR(20) NOT NULL,
  `lastNameEmp` VARCHAR(20) NOT NULL,
  `contactNumberEmp` VARCHAR(15) NULL,
  `positionEmp` VARCHAR(20) NOT NULL,
  `departmentEmp` VARCHAR(20) NULL,
  `passwordEmp` VARCHAR(20) NULL,
  `addressEmp` VARCHAR(100) NULL,
  `passFlagEmp` TINYINT(1) NOT NULL,
  PRIMARY KEY (`idEmployee`),
  UNIQUE INDEX `firstNameEmployee_UNIQUE` (`firstNameEmp` ASC),
  UNIQUE INDEX `middleNameEmployee_UNIQUE` (`middleNameEmp` ASC),
  UNIQUE INDEX `lastNameEmployee_UNIQUE` (`lastNameEmp` ASC))
ENGINE = InnoDB;

INSERT INTO EMPLOYEE(`idEmployee`, `firstNameEmp`, `middleNameEmp`, `lastNameEmp`,  `contactNumberEmp`, `positionEmp`, `departmentEmp`, `passwordEmp`, `addressEmp`, `passFlagEmp`) VALUES (12345678, '','','','','Administrator', '','admin1234', '', 1); 
SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
