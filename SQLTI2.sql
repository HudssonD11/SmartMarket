CREATE SCHEMA IF NOT EXISTS `SM` DEFAULT CHARACTER SET utf8 ;
USE `SM` ;


CREATE TABLE IF NOT EXISTS `SM`.`Usuario` (
  `CPF` CHAR(11) NOT NULL,
  `Nome` VARCHAR(45) NOT NULL,
  `Login` VARCHAR(45) NOT NULL,
  `Senha` CHAR(15) NOT NULL,
  `Créditos` SMALLINT UNSIGNED,
  `Tipo` CHAR(1) NOT NULL)


CREATE TABLE IF NOT EXISTS `SM`.`Estabelecimento` (
  `id` CHAR(15) NOT NULL,
  `Nome` VARCHAR(45) NOT NULL,
  `Estado` CHAR(2) NOT NULL,
  `Cidade` VARCHAR(45) NOT NULL,
  `Bairro` VARCHAR(45) NOT NULL,
  `Rua` VARCHAR(45) NOT NULL,
  `Numero` SMALLINT NOT NULL)


CREATE TABLE IF NOT EXISTS `SM`.`Produto` (
  `id` CHAR(15) NOT NULL,
  `Nome` VARCHAR(45) NOT NULL,
  `Categoria` VARCHAR(45) NOT NULL,
  `Marca` VARCHAR(45) NOT NULL,
  `Unidade` VARCHAR(10))


CREATE TABLE IF NOT EXISTS `SM`.`Comercializa` (
  `Estabelecimento` CHAR(15) NOT NULL,
  `Produto` CHAR(15) NOT NULL,
  `Preço` VARCHAR(15))


CREATE TABLE IF NOT EXISTS `SM`.`Atualiza` (
  `Usuario` CHAR(11) NOT NULL,
  `Produto` CHAR(15) NOT NULL,
  `Estabelecimento` CHAR(15) NOT NULL,
  `Data` DATE NOT NULL,
  PRIMARY KEY (`Usuario`, `Produto`, `Estabelecimento`))


CREATE TABLE IF NOT EXISTS `SM`.`Acessa` (
  `Usuario` CHAR(11) NOT NULL,
  `Produto` CHAR(15) NOT NULL,
  `Quantidade` INT)

ALTER TABLE `Usuario` ADD CONSTRAINT `pk_usuario`
    PRIMARY KEY(`CPF`)

ALTER TABLE `Estabelecimento` ADD CONSTRAINT `pk_estabelecimento`
    PRIMARY KEY(`id`)

ALTER TABLE `Produto` ADD CONSTRAINT `pk_Produto`
    PRIMARY KEY(`id`)

ALTER TABLE `Comercializa` ADD CONSTRAINT `pk_comercializa`
    PRIMARY KEY(`Estabelecimento`, `Produto`)
    
ALTER TABLE `Comercializa` ADD CONSTRAINT `fk_produto_comercializa`
    FOREIGN KEY (`Produto`)
    REFERENCES `SM`.`Produto` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE

ALTER TABLE `Comercializa` ADD CONSTRAINT `fk_estabelecimento_comercializa`
    FOREIGN KEY (`Estabelecimento`)
    REFERENCES `SM`.`Estabelecimento` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE

ALTER TABLE `Atualiza` ADD CONSTRAINT `pk_atualiza`
    PRIMARY KEY(`Estabelecimento`, `Produto`, `Usuario`)

ALTER TABLE `Atualiza` ADD CONSTRAINT `fk_estabelecimento_atualiza`
    FOREIGN KEY (`Estabelecimento`)
    REFERENCES `SM`.`Comercializa` (`Estabelecimento`)
    ON DELETE CASCADE
    ON UPDATE CASCADE

ALTER TABLE `Atualiza` ADD CONSTRAINT `fk_produto_atualiza`
    FOREIGN KEY (`Produto`)
    REFERENCES `SM`.`Comercializa` (`Produto`)
    ON DELETE CASCADE
    ON UPDATE CASCADE

ALTER TABLE `Atualiza` ADD CONSTRAINT `fk_usuario_atualiza`
    FOREIGN KEY (`Usuario`)
    REFERENCES `SM`.`Usuario` (`CPF`)
    ON DELETE CASCADE
    ON UPDATE CASCADE

ALTER TABLE `Atualiza` ADD CONSTRAINT `pk_atualiza`
    PRIMARY KEY (`Usuario`, `Produto`)

ALTER TABLE `Acessa` ADD CONSTRAINT `fk_produto_acessa`
    FOREIGN KEY (`Produto`)
    REFERENCES `SM`.`Produto` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE

ALTER TABLE `Acessa` ADD CONSTRAINT `fk_usuario_acessa`
    FOREIGN KEY (`Usuario`)
    REFERENCES `SM`.`Usuario` (`CPF`)
    ON DELETE CASCADE
    ON UPDATE CASCADE