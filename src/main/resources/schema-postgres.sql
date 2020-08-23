DROP TABLE IF EXISTS schools;
CREATE TABLE schools(id VARCHAR(255) NOT NULL, name VARCHAR(255), PRIMARY KEY (id, name));
--DROP TABLE IF EXISTS reports;
--CREATE TABLE reports(resource_id VARCHAR(255) NOT NULL, reason VARCHAR(50), description VARCHAR(50), submit_date timestamptz);
--DROP TABLE IF EXISTS courses;
--CREATE TABLE courses(id VARCHAR(255) NOT NULL, name VARCHAR(255), PRIMARY KEY (id));
--DROP TABLE IF EXISTS course_ratings;
--CREATE TABLE course_ratings(id VARCHAR(255) NOT NULL, course_id VARCHAR(255) NOT NULL, name VARCHAR(255), difficulty INT, grade INT, worth INT, PRIMARY KEY (id));
--DROP TABLE IF EXISTS course_comments;
--CREATE TABLE course_comments(id VARCHAR(255) NOT NULL, course_id VARCHAR(255) NOT NULL, name VARCHAR(255), difficulty INT, grade INT, worth INT, PRIMARY KEY (id));

--SELECT * FROM schools WHERE id = '123123';