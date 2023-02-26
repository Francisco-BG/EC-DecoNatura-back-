-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema deconatura
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema deconatura
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `deconatura` DEFAULT CHARACTER SET utf8 ;
USE `deconatura` ;

-- -----------------------------------------------------
-- Table `deconatura`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `deconatura`.`cliente` (
  `idcliente` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(50) NULL,
  `apellido` VARCHAR(50) NULL,
  `telefono` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `carrito_idcarrito` INT NOT NULL,
  PRIMARY KEY (`idcliente`),
  UNIQUE INDEX `idcliente_UNIQUE` (`idcliente` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `deconatura`.`producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `deconatura`.`producto` (
  `idproducto` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(50) NOT NULL,
  `precio` DECIMAL(6,2) NOT NULL,
  `categoria` VARCHAR(50) NOT NULL,
  `subcategoria` VARCHAR(50) NOT NULL,
  `descripcion` VARCHAR(150) NULL,
  `stock` INT NOT NULL,
  `imagen` VARCHAR(300) NOT NULL,
  PRIMARY KEY (`idproducto`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `deconatura`.`carrito`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `deconatura`.`carrito` (
  `idcarrito` INT NOT NULL,
  PRIMARY KEY (`idcarrito`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `deconatura`.`paqueteria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `deconatura`.`paqueteria` (
  `idpaqueteria` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(50) NULL,
  PRIMARY KEY (`idpaqueteria`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `deconatura`.`envio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `deconatura`.`envio` (
  `idenvio` INT NOT NULL AUTO_INCREMENT,
  `numero de pedido` INT NOT NULL,
  `direccion` VARCHAR(100) NULL,
  `codigo postal` INT NULL,
  `estado` VARCHAR(50) NULL,
  `municipio` VARCHAR(50) NULL,
  `precio de envio` DECIMAL(6,2) NULL,
  `paqueteria_idpaqueteria` INT NOT NULL,
  PRIMARY KEY (`idenvio`, `numero de pedido`, `paqueteria_idpaqueteria`),
  INDEX `fk_envio_paqueteria1_idx` (`paqueteria_idpaqueteria` ASC) VISIBLE,
  CONSTRAINT `fk_envio_paqueteria1`
    FOREIGN KEY (`paqueteria_idpaqueteria`)
    REFERENCES `deconatura`.`paqueteria` (`idpaqueteria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `deconatura`.`orden status`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `deconatura`.`orden status` (
  `idorden status` INT NOT NULL AUTO_INCREMENT,
  `orden status` VARCHAR(50) NULL,
  PRIMARY KEY (`idorden status`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `deconatura`.`orden`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `deconatura`.`orden` (
  `idorden` INT NOT NULL,
  `fecha` DATE NULL,
  `total` DECIMAL(6,2) NULL,
  `cliente_idcliente` INT NOT NULL,
  `cliente_carrito_idcarrito` INT NOT NULL,
  `carrito_idcarrito` INT NOT NULL,
  `orden status_idorden status` INT NOT NULL,
  PRIMARY KEY (`idorden`, `cliente_idcliente`, `cliente_carrito_idcarrito`, `carrito_idcarrito`, `orden status_idorden status`),
  INDEX `fk_orden_carrito1_idx` (`carrito_idcarrito` ASC) VISIBLE,
  INDEX `fk_orden_orden status1_idx` (`orden status_idorden status` ASC) VISIBLE,
  CONSTRAINT `fk_orden_has_envio`
    FOREIGN KEY (`idorden`)
    REFERENCES `deconatura`.`envio` (`idenvio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_orden_carrito1`
    FOREIGN KEY (`carrito_idcarrito`)
    REFERENCES `deconatura`.`carrito` (`idcarrito`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_orden_orden status1`
    FOREIGN KEY (`orden status_idorden status`)
    REFERENCES `deconatura`.`orden status` (`idorden status`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `deconatura`.`carrito_has_producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `deconatura`.`carrito_has_producto` (
  `carrito_idcarrito` INT NOT NULL,
  `producto_idproducto` INT NOT NULL,
  `cantidad` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`carrito_idcarrito`, `producto_idproducto`),
  INDEX `fk_carrito_has_producto_producto1_idx` (`producto_idproducto` ASC) VISIBLE,
  INDEX `fk_carrito_has_producto_carrito1_idx` (`carrito_idcarrito` ASC) VISIBLE,
  CONSTRAINT `fk_carrito_has_producto_carrito1`
    FOREIGN KEY (`carrito_idcarrito`)
    REFERENCES `deconatura`.`carrito` (`idcarrito`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_carrito_has_producto_producto1`
    FOREIGN KEY (`producto_idproducto`)
    REFERENCES `deconatura`.`producto` (`idproducto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
