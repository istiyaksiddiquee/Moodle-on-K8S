CREATE DATABASE exam;

USE exam;

CREATE TABLE IF NOT EXISTS t_exam (
	exam_id INT NOT NULL AUTO_INCREMENT,	
	name VARCHAR(30), 
	description VARCHAR(30),
	PRIMARY KEY (exam_id)
);

INSERT INTO t_exam(exam_id, name, description) VALUES(1, 'Istiyak', 'demo exam 1');
INSERT INTO t_exam(exam_id, name, description) VALUES(2, 'Siddiquee', 'demo exam 2');
INSERT INTO t_exam(exam_id, name, description) VALUES(3, 'Aabir', 'demo exam 3');

GRANT ALL PRIVILEGES ON exam.* TO 'magnumopus'@'%';