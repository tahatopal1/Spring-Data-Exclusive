USE `hb_student_tracker`;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `course_student`;

CREATE TABLE `course_student`
(
    `course_id`  int(11) NOT NULL,
    `student_id` int(11) NOT NULL,

    PRIMARY KEY (`course_id`, `student_id`),

    KEY          `FK_STUDENT_idx` (`student_id`),

    CONSTRAINT `FK_COURSE_05` FOREIGN KEY (`course_id`)
        REFERENCES `course` (`id`)
        ON DELETE NO ACTION ON UPDATE NO ACTION,

    CONSTRAINT `FK_STUDENT` FOREIGN KEY (`student_id`)
        REFERENCES `student` (`id`)
        ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;
