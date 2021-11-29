CREATE
DATABASE  IF NOT EXISTS `hb_student_tracker`;
USE
`hb_student_tracker`;

DROP TABLE IF EXISTS `course`;

CREATE TABLE `course`
(
    `id`            int(11) NOT NULL AUTO_INCREMENT,
    `title`         varchar(128) DEFAULT NULL,
    `instructor_id` int(11) DEFAULT NULL,

    PRIMARY KEY (`id`), course

    UNIQUE KEY `TITLE_UNIQUE` (`title`),

    KEY `FK_INSTRUCTOR_idx` (`instructor_id`),

    CONSTRAINT `FK_INSTRUCTOR`
    FOREIGN KEY (`instructor_id`)
    REFERENCES `instructor` (`id`)

    ON DELETE NO ACTION ON UPDATE NO ACTION)
    ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;


SET FOREIGN_KEY_CHECKS = 1;
