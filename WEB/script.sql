SET FOREIGN_KEY_CHECKS = 0;

CREATE SCHEMA IF NOT EXISTS `races` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `races` ;

CREATE TABLE IF NOT EXISTS `races`.`hourse_racing` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  `date` DATETIME NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `races`.`rate_type` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` TEXT(1000) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `races`.`rate_line` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  `description` TEXT(1000) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  UNIQUE INDEX `name_UNIQUE` (`title` ASC))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `races`.`hourse` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `races`.`jockey` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `races`.`participant` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `hourse_id` INT NOT NULL,
  `jockey_id` INT NOT NULL,
  INDEX `fk_hourses_has_jockeys_jockeys1_idx` (`jockey_id` ASC),
  INDEX `fk_hourses_has_jockeys_hourses1_idx` (`hourse_id` ASC),
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  CONSTRAINT `fk_hourses_has_jockeys_hourses1`
    FOREIGN KEY (`hourse_id`)
    REFERENCES `races`.`hourse` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_hourses_has_jockeys_jockeys1`
    FOREIGN KEY (`jockey_id`)
    REFERENCES `races`.`jockey` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `races`.`racing_line` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `hourse_racing_id` INT NOT NULL,
  `participant_id` INT NOT NULL,
  `result` INT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_racing_line_hourse_racing1_idx` (`hourse_racing_id` ASC),
  INDEX `fk_racing_line_hourse_2_jockey1_idx` (`participant_id` ASC),
  CONSTRAINT `fk_racing_line_hourse_racing1`
    FOREIGN KEY (`hourse_racing_id`)
    REFERENCES `races`.`hourse_racing` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_racing_line_hourse_2_jockey1`
    FOREIGN KEY (`participant_id`)
    REFERENCES `races`.`participant` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `races`.`coefficient` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `value` DOUBLE NOT NULL,
  `rate_line_id` INT NOT NULL,
  `racing_line_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_first_variant_rate1_idx` (`rate_line_id` ASC),
  INDEX `fk_coefficients_racing_line1_idx` (`racing_line_id` ASC),
  CONSTRAINT `fk_first_variant_rate1`
    FOREIGN KEY (`rate_line_id`)
    REFERENCES `races`.`rate_line` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_coefficients_racing_line1`
    FOREIGN KEY (`racing_line_id`)
    REFERENCES `races`.`racing_line` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `races`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(20) NOT NULL,
  `password` VARCHAR(40) NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `role` VARCHAR(20) NOT NULL,
  `balance` DOUBLE NOT NULL DEFAULT 0.0,
  `create_date` DATETIME NOT NULL,
  `end_date` DATETIME NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `login_UNIQUE` (`login` ASC),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `races`.`rate` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `value` DOUBLE NOT NULL,
  `rate_type_id` INT NOT NULL,
  `coefficient_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_rate_type_rate1_idx` (`rate_type_id` ASC),
  INDEX `fk_rate_coefficient1_idx` (`coefficient_id` ASC),
  INDEX `fk_rate_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_rate_type_rate1`
    FOREIGN KEY (`rate_type_id`)
    REFERENCES `races`.`rate_type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_rate_coefficient1`
    FOREIGN KEY (`coefficient_id`)
    REFERENCES `races`.`coefficient` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_rate_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `races`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET FOREIGN_KEY_CHECKS = 1;

insert into races.user(login,password,first_name,last_name,email,role,balance,create_date) values('admin','21232f297a57a5a743894a0e4a801fc3','admin','admin','admin@admin.com','admin',0,'2016.01.01');

