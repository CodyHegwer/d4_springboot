DROP TABLE IF EXISTS reports;
DROP TABLE IF EXISTS course_ratings;
DROP TABLE IF EXISTS courses;
DROP TABLE IF EXISTS schools;

CREATE TABLE schools(id VARCHAR(50) UNIQUE NOT NULL, name VARCHAR(255) NOT NULL, ip VARCHAR(30) NOT NULL, PRIMARY KEY (id, name, ip));
CREATE TABLE courses(id VARCHAR(50) UNIQUE NOT NULL, school_id VARCHAR(50) NOT NULL, name VARCHAR(255) NOT NULL, school_course_id VARCHAR(30), ip VARCHAR(30) NOT NULL, PRIMARY KEY (id, school_id, name, ip), CONSTRAINT fk_school FOREIGN KEY(school_id) REFERENCES schools(id));
CREATE TABLE course_ratings(id VARCHAR(50) UNIQUE NOT NULL, course_id VARCHAR(50) NOT NULL, difficulty INT, grade INT, worth INT, ip VARCHAR(30) NOT NULL, PRIMARY KEY (id, course_id, difficulty, ip), CONSTRAINT fk_course FOREIGN KEY(course_id) REFERENCES courses(id));
CREATE TABLE reports(id VARCHAR(50) UNIQUE NOT NULL, resource_id VARCHAR(50) NOT NULL, resource_type VARCHAR(15) NOT NULL, reason VARCHAR(50), description VARCHAR(50), ip VARCHAR(30) NOT NULL, submit_date timestamptz, PRIMARY KEY (id, resource_id, resource_type, reason, ip));

--DROP TABLE IF EXISTS courseComments;
--CREATE TABLE courseComments(id VARCHAR(255) UNIQUE NOT NULL, PRIMARY KEY (id));
--DROP TABLE IF EXISTS black_list;


--SELECT * FROM schools WHERE id = '123123';