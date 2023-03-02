USE `tutoringhub-db`;

create table if not exists students(
                                        id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
                                        student_id VARCHAR(36),
    student_name VARCHAR (50),
    student_age VARCHAR(50),
    student_email VARCHAR(50),
    student_school VARCHAR (50)
);


create table if not exists tutors(
                                       id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
                                       tutor_id VARCHAR(36),
    tutor_name VARCHAR (50),
    tutor_age VARCHAR(50),
    tutor_email VARCHAR(50),
    specialty VARCHAR(50),
    experience VARCHAR(50)
    );


