DROP SCHEMA IF EXISTS `quiz` ;
CREATE SCHEMA IF NOT EXISTS `quiz` DEFAULT CHARACTER SET utf8 ;
USE `quiz` ;

DROP TABLE IF EXISTS `quiz`.`admin` ;
CREATE TABLE IF NOT EXISTS `quiz`.`admin` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `pass` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;
INSERT INTO quiz.admin (name, pass) VALUES ('admin', 'pass');

DROP TABLE IF EXISTS `quiz`.`user` ;
CREATE TABLE IF NOT EXISTS `quiz`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `pass` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;
INSERT INTO quiz.user (name, pass) VALUES ('Admin', 'pass');

DROP TABLE IF EXISTS `quiz`.`question` ;
CREATE TABLE IF NOT EXISTS `quiz`.`question` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `editor` INT NOT NULL,
  `content` VARCHAR(250) NOT NULL,
  `solution` VARCHAR(45) NOT NULL,
  `points` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_question_admin1_idx` (`editor` ASC),
  CONSTRAINT `fk_question_created_by`
    FOREIGN KEY (`editor`)
    REFERENCES `quiz`.`admin` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
INSERT INTO quiz.question (editor, content, solution, points) VALUES (1, 'There were 6 apples\nand you took 4\how many you have?', 'four', 5);
INSERT INTO quiz.question (editor, content, solution, points) VALUES (1, 'What is apple?', 'fruit', 2);
INSERT INTO quiz.question (editor, content, solution, points) VALUES (1, 'Do you care?', 'sure', 10);
INSERT INTO quiz.question (editor, content, solution, points) VALUES (1, 'How many cheeks you have?', 'four', 10);
INSERT INTO quiz.question (editor, content, solution, points) VALUES (1, 'Truth or dare?', 'dare', 10);

DROP TABLE IF EXISTS `quiz`.`score` ;
CREATE TABLE IF NOT EXISTS `quiz`.`score` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `result` INT NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  INDEX `fk_score_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_answer_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `quiz`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
INSERT INTO quiz.score (user_id, result) VALUES (1, 0);