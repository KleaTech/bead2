-- MySQL Script generated by MySQL Workbench
-- Sun Dec 10 22:27:31 2017
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema bead2
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bead2` DEFAULT CHARACTER SET utf8 ;
USE `bead2` ;

-- -----------------------------------------------------
-- Table `bead2`.`usertable`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bead2`.`usertable` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `passwd` VARCHAR(255) NULL DEFAULT NULL,
  `uniquealias` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bead2`.`pencilcase`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bead2`.`pencilcase` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `owner` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK705xjcoqq5wq7icino216l4ks` (`owner` ASC),
  CONSTRAINT `FK705xjcoqq5wq7icino216l4ks`
    FOREIGN KEY (`owner`)
    REFERENCES `bead2`.`usertable` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 22
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bead2`.`penciltable`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bead2`.`penciltable` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `brand` VARCHAR(255) NULL DEFAULT NULL,
  `color` VARCHAR(255) NULL DEFAULT NULL,
  `lengthcolumn` INT(11) NULL DEFAULT NULL,
  `sharpness` INT(11) NULL DEFAULT NULL,
  `pencilcase` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKmwaig6vjvxdj8348y5wxk5moc` (`pencilcase` ASC),
  CONSTRAINT `FKmwaig6vjvxdj8348y5wxk5moc`
    FOREIGN KEY (`pencilcase`)
    REFERENCES `bead2`.`pencilcase` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 28
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

INSERT INTO `bead2`.`usertable` (`id`, `name`, `passwd`, `uniquealias`)
VALUES (1, "Bela", "jelszo", "bela123");