-- MySQL Workbench Synchronization
-- Generated: 2015-10-14 14:23
-- Model: New Model
-- Version: 1.0
-- Project: Name of the project
-- Author: Андрей

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `office` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;

CREATE TABLE IF NOT EXISTS `office`.`employee` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `name` VARCHAR(45) NOT NULL COMMENT '',
  `surname` VARCHAR(45) NOT NULL COMMENT '',
  `position` VARCHAR(45) NULL DEFAULT 'trainee' COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '')
ENGINE = InnoDB;
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE TABLE IF NOT EXISTS `office`.`stationery` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `name` VARCHAR(45) NOT NULL COMMENT '',
  `cost` DOUBLE NOT NULL COMMENT '',
  `description` VARCHAR(45) NULL DEFAULT 'No description' COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '')
ENGINE = InnoDB;
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE TABLE IF NOT EXISTS `office`.`employee_has_stationery` (
  `employee_id` INT NOT NULL COMMENT '',
  `stationery_id` INT NOT NULL COMMENT '',
  PRIMARY KEY (`employee_id`, `stationery_id`)  COMMENT '',
  INDEX `fk_employee_has_stationery_stationery1_idx` (`stationery_id` ASC)  COMMENT '',
  INDEX `fk_employee_has_stationery_employee_idx` (`employee_id` ASC)  COMMENT '',
  CONSTRAINT `fk_employee_has_stationery_employee`
    FOREIGN KEY (`employee_id`)
    REFERENCES `office`.`employee` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_employee_has_stationery_stationery1`
    FOREIGN KEY (`stationery_id`)
    REFERENCES `office`.`stationery` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
