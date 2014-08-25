SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema phs
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `phs` DEFAULT CHARACTER SET utf8 ;
USE `phs` ;

-- -----------------------------------------------------
-- Table `phs`.`section`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `phs`.`section` ;

CREATE TABLE IF NOT EXISTS `phs`.`section` (
  `idSection` INT(11) NOT NULL AUTO_INCREMENT,
  `sectionName` VARCHAR(45) NOT NULL,
  `sectionYear` INT(11) NOT NULL,
  PRIMARY KEY (`idSection`),
  UNIQUE INDEX `sectionName_UNIQUE` (`sectionName` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `phs`.`employee`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `phs`.`employee` ;

CREATE TABLE IF NOT EXISTS `phs`.`employee` (
  `idEmployee` VARCHAR(12) NOT NULL,
  `firstNameEmp` VARCHAR(30) NOT NULL,
  `middleNameEmp` VARCHAR(20) NOT NULL,
  `lastNameEmp` VARCHAR(20) NOT NULL,
  `contactNumberEmp` VARCHAR(15) NULL DEFAULT NULL,
  `positionEmp` VARCHAR(20) NOT NULL,
  `departmentEmp` VARCHAR(20) NULL DEFAULT NULL,
  `passwordEmp` VARCHAR(20) NULL DEFAULT NULL,
  `addressEmp` VARCHAR(100) NULL DEFAULT NULL,
  `passFlagEmp` TINYINT(1) NOT NULL,
  PRIMARY KEY (`idEmployee`),
  UNIQUE INDEX `Name` (`firstNameEmp` ASC, `middleNameEmp` ASC, `lastNameEmp` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `phs`.`classaAdvisers`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `phs`.`classaAdvisers` ;

CREATE TABLE IF NOT EXISTS `phs`.`classaAdvisers` (
  `classID` INT NOT NULL AUTO_INCREMENT,
  `sectionID` INT(11) NOT NULL,
  `adviserID` VARCHAR(12) NOT NULL,
  `classYear` YEAR NOT NULL,
  UNIQUE INDEX `adviserClassYear` (`adviserID` ASC, `classYear` ASC),
  INDEX `fk_Class_Employee1_idx` (`adviserID` ASC),
  PRIMARY KEY (`classID`),
  UNIQUE INDEX `classIDyear` (`classYear` ASC, `sectionID` ASC),
  CONSTRAINT `fk_ClassRoster_Section1`
    FOREIGN KEY (`sectionID`)
    REFERENCES `phs`.`section` (`idSection`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Class_Employee1`
    FOREIGN KEY (`adviserID`)
    REFERENCES `phs`.`employee` (`idEmployee`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `phs`.`student`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `phs`.`student` ;

CREATE TABLE IF NOT EXISTS `phs`.`student` (
  `idStudent` VARCHAR(12) NOT NULL,
  `firstNameSt` VARCHAR(30) NOT NULL,
  `middleNameSt` VARCHAR(20) NOT NULL,
  `lastNameSt` VARCHAR(20) NOT NULL,
  `genderSt` CHAR(2) NOT NULL,
  `birthDateSt` DATE NOT NULL,
  `yearLevelSt` INT(11) NOT NULL,
  PRIMARY KEY (`idStudent`),
  UNIQUE INDEX `Name` (`firstNameSt` ASC, `middleNameSt` ASC, `lastNameSt` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `phs`.`subject`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `phs`.`subject` ;

CREATE TABLE IF NOT EXISTS `phs`.`subject` (
  `subjectName` VARCHAR(20) NOT NULL,
  `subjectYearLevel` INT(11) NOT NULL,
  PRIMARY KEY (`subjectName`),
  UNIQUE INDEX `SubjectYear` (`subjectName` ASC, `subjectYearLevel` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `phs`.`StudentRoster`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `phs`.`StudentRoster` ;

CREATE TABLE IF NOT EXISTS `phs`.`StudentRoster` (
  `classID` INT NOT NULL,
  `idStudent` VARCHAR(12) NOT NULL,
  INDEX `fk_table1_student1_idx` (`idStudent` ASC),
  PRIMARY KEY (`classID`),
  CONSTRAINT `fk_table1_student1`
    FOREIGN KEY (`idStudent`)
    REFERENCES `phs`.`student` (`idStudent`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_StudentRoster_classaAdvisers1`
    FOREIGN KEY (`classID`)
    REFERENCES `phs`.`classaAdvisers` (`classID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `phs`.`classSubjects`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `phs`.`classSubjects` ;

CREATE TABLE IF NOT EXISTS `phs`.`classSubjects` (
  `classID` INT NOT NULL,
  `subjectName` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`classID`, `subjectName`),
  INDEX `fk_classSubjects_subject1_idx` (`subjectName` ASC),
  INDEX `fk_classSubjects_classaAdvisers1_idx` (`classID` ASC),
  CONSTRAINT `fk_classSubjects_subject1`
    FOREIGN KEY (`subjectName`)
    REFERENCES `phs`.`subject` (`subjectName`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_classSubjects_classaAdvisers1`
    FOREIGN KEY (`classID`)
    REFERENCES `phs`.`classaAdvisers` (`classID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `phs`.`classTeachers`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `phs`.`classTeachers` ;

CREATE TABLE IF NOT EXISTS `phs`.`classTeachers` (
  `classSubjects_classID` INT NOT NULL,
  `classSubjects_subjectName` VARCHAR(20) NOT NULL,
  `employee_idEmployee` VARCHAR(12) NOT NULL,
  PRIMARY KEY (`classSubjects_classID`, `classSubjects_subjectName`),
  INDEX `fk_classTeachers_employee1_idx` (`employee_idEmployee` ASC),
  INDEX `fk_classTeachers_classSubjects1_idx` (`classSubjects_classID` ASC, `classSubjects_subjectName` ASC),
  UNIQUE INDEX `index4` (`classSubjects_classID` ASC, `employee_idEmployee` ASC, `classSubjects_subjectName` ASC),
  CONSTRAINT `fk_classTeachers_employee1`
    FOREIGN KEY (`employee_idEmployee`)
    REFERENCES `phs`.`employee` (`idEmployee`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_classTeachers_classSubjects1`
    FOREIGN KEY (`classSubjects_classID` , `classSubjects_subjectName`)
    REFERENCES `phs`.`classSubjects` (`classID` , `subjectName`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `phs`.`Settings`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `phs`.`Settings` ;

CREATE TABLE IF NOT EXISTS `phs`.`Settings` (
  `SettingName` VARCHAR(20) NOT NULL,
  `SettingVal` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`SettingName`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `phs`.`SchoolDays`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `phs`.`SchoolDays` ;

CREATE TABLE IF NOT EXISTS `phs`.`SchoolDays` (
  `SchoolYear` INT NOT NULL,
  `Month` VARCHAR(15) NOT NULL,
  `Days` INT NOT NULL,
  PRIMARY KEY (`SchoolYear`, `Month`),
  UNIQUE INDEX `yearMonth` (`SchoolYear` ASC, `Month` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `phs`.`GradeComposition`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `phs`.`GradeComposition` ;

CREATE TABLE IF NOT EXISTS `phs`.`GradeComposition` (
  `classID` INT NOT NULL,
  `subjectName` VARCHAR(20) NOT NULL,
  `GradeComp` VARCHAR(45) NOT NULL,
  `GradeCompNumber` INT NOT NULL AUTO_INCREMENT,
  `KnowledgeValue` INT NOT NULL,
  `UnderstandingValue` INT NOT NULL,
  `SkillValue` INT NOT NULL,
  `ProductValue` INT NOT NULL,
  PRIMARY KEY (`GradeCompNumber`, `classID`, `subjectName`, `GradeComp`),
  UNIQUE INDEX `gradeNumbers` (`subjectName` ASC, `classID` ASC, `GradeComp` ASC, `GradeCompNumber` ASC),
  UNIQUE INDEX `index3` (`classID` ASC, `subjectName` ASC, `GradeComp` ASC, `GradeCompNumber` ASC),
  CONSTRAINT `fk_GradeComposition_classTeachers1`
    FOREIGN KEY (`classID` , `subjectName`)
    REFERENCES `phs`.`classTeachers` (`classSubjects_classID` , `classSubjects_subjectName`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `phs`.`studentGrade`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `phs`.`studentGrade` ;

CREATE TABLE IF NOT EXISTS `phs`.`studentGrade` (
  `classID` INT NOT NULL,
  `student_idStudent` VARCHAR(12) NOT NULL,
  `subjectName` VARCHAR(20) NOT NULL,
  `GradeComp` VARCHAR(45) NOT NULL,
  `GradeCompNumber` INT NOT NULL,
  `KnowledgeValue` INT NOT NULL,
  `UnderstandingValue` INT NOT NULL,
  `SkillValue` INT NOT NULL,
  `ProductValue` INT NOT NULL,
  `gradeFinal` TINYINT(1) NOT NULL DEFAULT 0,
  `gradeApproved` TINYINT(1) NOT NULL DEFAULT 0,
  INDEX `fk_studentGrade_student1_idx` (`student_idStudent` ASC),
  PRIMARY KEY (`classID`, `subjectName`, `GradeComp`, `GradeCompNumber`),
  UNIQUE INDEX `classSubjectSt` (`student_idStudent` ASC, `classID` ASC, `subjectName` ASC, `GradeComp` ASC, `GradeCompNumber` ASC),
  CONSTRAINT `fk_studentGrade_student1`
    FOREIGN KEY (`student_idStudent`)
    REFERENCES `phs`.`student` (`idStudent`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_studentGrade_GradeComposition1`
    FOREIGN KEY (`GradeCompNumber` , `classID` , `subjectName` , `GradeComp`)
    REFERENCES `phs`.`GradeComposition` (`GradeCompNumber` , `classID` , `subjectName` , `GradeComp`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
