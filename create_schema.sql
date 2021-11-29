-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema lab1_AMT
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema lab1_AMT
-- -----------------------------------------------------
USE `lab1_AMT` ;

-- -----------------------------------------------------
-- Table `lab1_AMT`.`Station`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab1_AMT`.`Station` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `adresse` VARCHAR(150) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lab1_AMT`.`Emplacement`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab1_AMT`.`Emplacement` (
  `id` INT NOT NULL,
  `station_id` INT NOT NULL,
  PRIMARY KEY (`id`, `station_id`),
  INDEX `fk_Emplacement_Station1_idx` (`station_id` ASC),
  CONSTRAINT `fk_Emplacement_Station1`
    FOREIGN KEY (`station_id`)
    REFERENCES `lab1_AMT`.`Station` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `lab1_AMT`.`Prix`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab1_AMT`.`Prix` (
  `categorie` ENUM('BERLINE', 'MOTO', 'FOURGON') NOT NULL,
  `prix1` DECIMAL(4,2) NOT NULL,
  `prix2` DECIMAL(4,2) NOT NULL,
  `prix3` DECIMAL(4,2) NOT NULL,
  PRIMARY KEY (`categorie`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lab1_AMT`.`Vehicule`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab1_AMT`.`Vehicule` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `matricule` VARCHAR(20) NOT NULL,
  `emplacement_id` INT,
  `station_id` INT,
  `categorie` ENUM('BERLINE', 'MOTO', 'FOURGON') NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `matricule_UNIQUE` (`matricule` ASC),
  INDEX `fk_Vehicule_Emplacement1_idx` (`emplacement_id` ASC, `station_id` ASC),
  INDEX `fk_Vehicule_Categorie1_idx` (`categorie` ASC),
  CONSTRAINT `fk_Vehicule_Emplacement1`
    FOREIGN KEY (`emplacement_id` , `station_id`)
    REFERENCES `lab1_AMT`.`Emplacement` (`id` , `station_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Vehicule_Prix`
    FOREIGN KEY (`categorie`)
    REFERENCES `lab1_AMT`.`Prix` (`categorie`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lab1_AMT`.`Utilisateur`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab1_AMT`.`Utilisateur` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(60) NOT NULL,
  `password` VARCHAR(150) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `login_UNIQUE` (`login` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lab1_AMT`.`Trajet`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab1_AMT`.`Trajet` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `vehicule_id` INT NOT NULL,
  `destination_emplacement_id` INT NOT NULL,
  `destination_Station_id` INT NOT NULL,
  `duree` INT NULL,
  `prix` DECIMAL(5,2) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Trajet_Vehicule1_idx` (`vehicule_id` ASC),
  INDEX `fk_Trajet_Emplacement1_idx` (`destination_emplacement_id` ASC, `destination_Station_id` ASC),
  CONSTRAINT `fk_Trajet_Vehicule1`
    FOREIGN KEY (`vehicule_id`)
    REFERENCES `lab1_AMT`.`Vehicule` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Trajet_Emplacement1`
    FOREIGN KEY (`destination_emplacement_id` , `destination_Station_id`)
    REFERENCES `lab1_AMT`.`Emplacement` (`id` , `station_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lab1_AMT`.`Client`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab1_AMT`.`Client` (
  `utilisateur_id` INT NOT NULL,
  `trajet_id` INT NULL,
  `solde` DECIMAL(5,2) NOT NULL DEFAULT 0.0,
  INDEX `fk_Client_Utilisateur1_idx` (`utilisateur_id` ASC),
  INDEX `fk_Client_Trajet1_idx` (`trajet_id` ASC),
  CONSTRAINT `fk_Client_Utilisateur1`
    FOREIGN KEY (`utilisateur_id`)
    REFERENCES `lab1_AMT`.`Utilisateur` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Client_Trajet1`
    FOREIGN KEY (`trajet_id`)
    REFERENCES `lab1_AMT`.`Trajet` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lab1_AMT`.`Administrateur`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab1_AMT`.`Administrateur` (
  `utilisateur_id` INT NOT NULL,
  INDEX `fk_Administrateur_Utilisateur1_idx` (`utilisateur_id` ASC),
  CONSTRAINT `fk_Administrateur_Utilisateur1`
    FOREIGN KEY (`utilisateur_id`)
    REFERENCES `lab1_AMT`.`Utilisateur` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
