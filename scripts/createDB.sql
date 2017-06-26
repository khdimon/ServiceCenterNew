DROP SCHEMA IF EXISTS `service_center_new`;

CREATE SCHEMA `service_center_new`
  DEFAULT CHARACTER SET utf8
  COLLATE utf8_general_ci;

USE `service_center_new`;


CREATE TABLE `service_center_new`.`teams` (
  `id`   INT         NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC)
)
  ENGINE = InnoDB;

CREATE TABLE `service_center_new`.`states` (
  `id`   INT         NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC)
)
  ENGINE = InnoDB;

CREATE TABLE `service_center_new`.`services` (
  `id`    INT          NOT NULL AUTO_INCREMENT,
  `name`  VARCHAR(100) NOT NULL,
  `price` INT          NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC)
)
  ENGINE = InnoDB;

CREATE TABLE `service_center_new`.`roles` (
  `id`   INT         NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC)
)
  ENGINE = InnoDB;

CREATE TABLE `service_center_new`.`users` (
  `id`       INT          NOT NULL AUTO_INCREMENT,
  `name`     VARCHAR(100) NOT NULL,
  `address`  VARCHAR(150) NOT NULL,
  `phone`    VARCHAR(45)  NOT NULL,
  `e-mail`   VARCHAR(100) NOT NULL,
  `password` VARCHAR(45)  NOT NULL,
  `roles_id` INT          NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_users_roles_idx` (`roles_id` ASC),
  CONSTRAINT `fk_users_roles`
  FOREIGN KEY (`roles_id`)
  REFERENCES `service_center_new`.`roles` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
  ENGINE = InnoDB;

CREATE TABLE `service_center_new`.`orders` (
  `id`             INT          NOT NULL AUTO_INCREMENT,
  `address`        VARCHAR(150) NOT NULL,
  `phone`          VARCHAR(45)  NOT NULL,
  `creation_date`  TIMESTAMP    NOT NULL,
  `execution_date` DATE         NULL,
  `users_id`       INT          NOT NULL,
  `teams_id`       INT          NULL,
  `services_id`    INT          NOT NULL,
  `states_id`      INT          NOT NULL,
  `comment`        VARCHAR(300) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_orders_users1_idx` (`users_id` ASC),
  INDEX `fk_orders_teams1_idx` (`teams_id` ASC),
  INDEX `fk_orders_services1_idx` (`services_id` ASC),
  INDEX `fk_orders_states1_idx` (`states_id` ASC),
  CONSTRAINT `fk_orders_users1`
  FOREIGN KEY (`users_id`)
  REFERENCES `service_center_new`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_orders_teams1`
  FOREIGN KEY (`teams_id`)
  REFERENCES `service_center_new`.`teams` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_orders_services1`
  FOREIGN KEY (`services_id`)
  REFERENCES `service_center_new`.`services` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_orders_states1`
  FOREIGN KEY (`states_id`)
  REFERENCES `service_center_new`.`states` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
  ENGINE = InnoDB;