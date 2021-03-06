-- MySQL Script generated by MySQL Workbench
-- Wed Mar 28 22:54:20 2018
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema LegoHouse
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema LegoHouse
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `LegoHouse` DEFAULT CHARACTER SET latin1 ;
USE `LegoHouse` ;

-- -----------------------------------------------------
-- Table `LegoHouse`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `LegoHouse`.`user` (
  `iduser` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `role` ENUM('employee', 'customer') NOT NULL DEFAULT 'customer',
  PRIMARY KEY (`iduser`),
  UNIQUE INDEX `iduser_UNIQUE` (`iduser` ASC),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `LegoHouse`.`order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `LegoHouse`.`order` (
  `idorder` INT NOT NULL AUTO_INCREMENT,
  `length` INT NOT NULL,
  `width` INT NOT NULL,
  `height` INT NOT NULL,
  `status` ENUM('pending', 'sent') NOT NULL DEFAULT 'pending',
  `user_iduser` INT NOT NULL,
  PRIMARY KEY (`idorder`, `user_iduser`),
  UNIQUE INDEX `idorder_UNIQUE` (`idorder` ASC),
  INDEX `fk_order_user_idx` (`user_iduser` ASC),
  CONSTRAINT `fk_order_user`
    FOREIGN KEY (`user_iduser`)
    REFERENCES `LegoHouse`.`user` (`iduser`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `LegoHouse`.`user`
-- -----------------------------------------------------
START TRANSACTION;
USE `LegoHouse`;
INSERT INTO `LegoHouse`.`user` (`iduser`, `email`, `password`, `role`) VALUES (1, 'employee1@legobuilder.com', 'ilovelego', 'employee');
COMMIT;

