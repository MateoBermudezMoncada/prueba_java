CREATE SCHEMA `riwiAcademyDB` ;

CREATE TABLE `riwiAcademyDB`.`students` (
  `idstudents` INT NOT NULL AUTO_INCREMENT,
  `emailstudents` VARCHAR(55) NOT NULL,
  `status` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idstudents`),
  UNIQUE INDEX `emailstudents_UNIQUE` (`emailstudents` ASC) VISIBLE,
  UNIQUE INDEX `idstudents_UNIQUE` (`idstudents` ASC) VISIBLE);

alter TABLE `riwiAcademyDB`.`students` 
ADD COLUMN `name` VARCHAR(45) NOT NULL AFTER `status`,
ADD COLUMN `lastname` VARCHAR(45) NOT NULL AFTER `name`,
CHANGE COLUMN `idstudents` `idstudent` INT NOT NULL AUTO_INCREMENT ,
CHANGE COLUMN `emailstudents` `emailstudent` VARCHAR(55) NOT NULL ,
CHANGE COLUMN `status` `status` TINYINT NOT NULL ;

ALTER TABLE `riwiAcademyDB`.`students` 
ADD COLUMN `courseenrolled` VARCHAR(100) NOT NULL AFTER `lastname`;

ALTER TABLE `riwiAcademyDB`.`students` 
ADD INDEX `fk_courseenrroled_idx` (`courseenrolled` ASC) VISIBLE;
;
ALTER TABLE `riwiAcademyDB`.`students` 
ADD CONSTRAINT `fk_courseenrroled`
  FOREIGN KEY (`courseenrolled`)
  REFERENCES `riwiAcademyDB`.`courses` (`namecourse`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;


select * from students;

CREATE TABLE `riwiAcademyDB`.`courses` (
  `idcourse` INT NOT NULL AUTO_INCREMENT,
  `namecourse` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idcourse`),
  UNIQUE INDEX `idcourses_UNIQUE` (`idcourse` ASC) VISIBLE,
  UNIQUE INDEX `namecourse_UNIQUE` (`namecourse` ASC) VISIBLE);

select * from courses;

ALTER TABLE `riwiAcademyDB`.`enrollments` 
ADD INDEX `fk_studentenrolled_idx` (`studentenrolled` ASC) VISIBLE,
ADD INDEX `fk_courseenrolled_idx` (`courseenrolled` ASC) VISIBLE;
;
ALTER TABLE `riwiAcademyDB`.`enrollments` 
ADD CONSTRAINT `fk_studentenrolled`
  FOREIGN KEY (`studentenrolled`)
  REFERENCES `riwiAcademyDB`.`students` (`emailstudent`)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
ADD CONSTRAINT `fk_courseenrolled`
  FOREIGN KEY (`courseenrolled`)
  REFERENCES `riwiAcademyDB`.`courses` (`namecourse`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;

select * from enrollments;

CREATE TABLE `riwiAcademyDB`.`grades` (
  `idgrades` INT NOT NULL AUTO_INCREMENT,
  `description` TEXT(500) NULL,
  `gradestudent` INT(3) NOT NULL,
  PRIMARY KEY (`idgrades`));

select * from grades;
ALTER TABLE `riwiAcademyDB`.`grades` 
ADD INDEX `fk_student_grade_idx` (`gradeStudent` ASC) VISIBLE,
ADD INDEX `fk_course_grade_idx` (`gradeCourse` ASC) VISIBLE;
;
ALTER TABLE `riwiAcademyDB`.`grades` 
ADD CONSTRAINT `fk_student_grade`
  FOREIGN KEY (`gradeStudent`)
  REFERENCES `riwiAcademyDB`.`students` (`idstudent`)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
ADD CONSTRAINT `fk_course_grade`
  FOREIGN KEY (`gradeCourse`)
  REFERENCES `riwiAcademyDB`.`courses` (`namecourse`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;
  
  select * from grades;
