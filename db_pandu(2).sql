-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema db_pandu
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema db_pandu
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `db_pandu` DEFAULT CHARACTER SET utf8mb4 ;
USE `db_pandu` ;

-- -----------------------------------------------------
-- Table `db_pandu`.`_jenisbangun`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_pandu`.`_jenisbangun` (
  `id_jenisbangun` INT(11) NOT NULL AUTO_INCREMENT,
  `jenisbangun_nama` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id_jenisbangun`))
ENGINE = InnoDB
AUTO_INCREMENT = 10
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `db_pandu`.`_pelanggan`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_pandu`.`_pelanggan` (
  `id_pelanggan` INT(11) NOT NULL AUTO_INCREMENT,
  `pelanggan_nama` VARCHAR(50) NOT NULL,
  `pelanggan_alamat` VARCHAR(50) NOT NULL,
  `pelanggan_nohp` VARCHAR(50) NOT NULL,
  `pelanggan_email` VARCHAR(50) NOT NULL,
  `pelanggan_pekerjaan` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id_pelanggan`))
ENGINE = InnoDB
AUTO_INCREMENT = 23
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `db_pandu`.`_lokasi`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_pandu`.`_lokasi` (
  `id_lokasi` INT(11) NOT NULL AUTO_INCREMENT,
  `lokasi_namalokasi` VARCHAR(150) NOT NULL,
  PRIMARY KEY (`id_lokasi`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `db_pandu`.`_tender`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_pandu`.`_tender` (
  `id_tender` INT(11) NOT NULL AUTO_INCREMENT,
  `id_pelanggan` INT(11) NOT NULL,
  `id_jenisbangun` INT(11) NOT NULL,
  `_lokasi_id_lokasi` INT(11) NOT NULL,
  `tender_tanggaltender` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP() ON UPDATE CURRENT_TIMESTAMP(),
  `tender_namatender` VARCHAR(50) NOT NULL,
  `tender_nilaikontrak` VARCHAR(50) NOT NULL,
  `tender_nilaidp` VARCHAR(50) NOT NULL,
  `tender_alamat` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id_tender`, `id_pelanggan`, `id_jenisbangun`, `_lokasi_id_lokasi`),
  INDEX `fk__tender__pelanggan_idx` (`id_pelanggan` ASC),
  INDEX `fk__tender__jenisbangun1_idx` (`id_jenisbangun` ASC),
  INDEX `fk__tender__lokasi1_idx` (`_lokasi_id_lokasi` ASC),
  CONSTRAINT `fk__tender__jenisbangun`
    FOREIGN KEY (`id_jenisbangun`)
    REFERENCES `db_pandu`.`_jenisbangun` (`id_jenisbangun`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk__tender__pelanggan`
    FOREIGN KEY (`id_pelanggan`)
    REFERENCES `db_pandu`.`_pelanggan` (`id_pelanggan`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk__tender__lokasi1`
    FOREIGN KEY (`_lokasi_id_lokasi`)
    REFERENCES `db_pandu`.`_lokasi` (`id_lokasi`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `db_pandu`.`_cicilan`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_pandu`.`_cicilan` (
  `id_cicilan` INT(11) NOT NULL AUTO_INCREMENT,
  `cicilan_tgl` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP() ON UPDATE CURRENT_TIMESTAMP(),
  `cicilan_nominal` VARCHAR(50) NOT NULL,
  `_tender_id_tender` INT(11) NOT NULL,
  `_tender_id_pelanggan` INT(11) NOT NULL,
  `_tender_id_jenisbangun` INT(11) NOT NULL,
  `_tender__lokasi_id_lokasi` INT(11) NOT NULL,
  PRIMARY KEY (`id_cicilan`, `_tender_id_tender`, `_tender_id_pelanggan`, `_tender_id_jenisbangun`, `_tender__lokasi_id_lokasi`),
  INDEX `fk__cicilan__tender1_idx` (`_tender_id_tender` ASC, `_tender_id_pelanggan` ASC, `_tender_id_jenisbangun` ASC, `_tender__lokasi_id_lokasi` ASC),
  CONSTRAINT `fk__cicilan__tender1`
    FOREIGN KEY (`_tender_id_tender` , `_tender_id_pelanggan` , `_tender_id_jenisbangun` , `_tender__lokasi_id_lokasi`)
    REFERENCES `db_pandu`.`_tender` (`id_tender` , `id_pelanggan` , `id_jenisbangun` , `_lokasi_id_lokasi`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `db_pandu`.`_user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_pandu`.`_user` (
  `id_user` INT(11) NOT NULL AUTO_INCREMENT,
  `user_username` VARCHAR(50) NOT NULL,
  `user_password` VARCHAR(50) NOT NULL,
  `user_status` VARCHAR(50) NOT NULL,
  `user_tglbuat` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP() ON UPDATE CURRENT_TIMESTAMP(),
  PRIMARY KEY (`id_user`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
