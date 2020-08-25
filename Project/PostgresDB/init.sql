CREATE USER magnumopus WITH PASSWORD '123456';
CREATE DATABASE magnum_rdbms;
GRANT ALL PRIVILEGES ON DATABASE magnum_rdbms TO magnumopus;

\c magnum_rdbms;

CREATE TABLE IF NOT EXISTS t_faculty (
	faculty_id SERIAL PRIMARY KEY, 
	name VARCHAR, 
	address VARCHAR
);
ALTER TABLE t_faculty OWNER TO magnumopus;

CREATE TABLE IF NOT EXISTS t_department (
	department_id SERIAL PRIMARY KEY, 
	name VARCHAR, 
	address VARCHAR, 
	faculty_id INT NOT NULL, 
	CONSTRAINT fk_dept_faculty FOREIGN KEY(faculty_id) REFERENCES t_faculty(faculty_id) 
	ON UPDATE CASCADE ON DELETE CASCADE
);
ALTER TABLE t_department OWNER TO magnumopus;

CREATE TABLE IF NOT EXISTS t_course (
	course_id SERIAL PRIMARY KEY, 
	title VARCHAR, 
	credit_points FLOAT(8),
	address VARCHAR, 
	department_id INT NOT NULL, 
	CONSTRAINT fk_course_dept FOREIGN KEY(department_id) REFERENCES t_department(department_id)
	ON UPDATE CASCADE ON DELETE CASCADE
);
ALTER TABLE t_course OWNER TO magnumopus;

CREATE TABLE IF NOT EXISTS t_user (
	user_id SERIAL PRIMARY KEY, 
	first_name VARCHAR, 
	last_name VARCHAR, 
	user_name VARCHAR NOT NULL UNIQUE, 
	email_id VARCHAR NOT NULL UNIQUE,
	password VARCHAR NOT NULL UNIQUE,
	address VARCHAR	
);
ALTER TABLE t_user OWNER TO magnumopus;

CREATE TABLE IF NOT EXISTS t_role_permissions (
	role_permission_id SERIAL PRIMARY KEY, 
	role_name VARCHAR NOT NULL, 
	privilege json NOT NULL	
);
ALTER TABLE t_role_permissions OWNER TO magnumopus;

CREATE TABLE IF NOT EXISTS t_acl_rules (
	acl_rule_id SERIAL PRIMARY KEY, 
	user_id INT NOT NULL,
	role_permission_id INT NOT NULL, 
	included json, 
	excluded json,
	
	CONSTRAINT fk_acl_user FOREIGN KEY(user_id) REFERENCES t_user(user_id)
	ON UPDATE CASCADE ON DELETE CASCADE,	
	CONSTRAINT fk_acl_role FOREIGN KEY(role_permission_id) REFERENCES t_role_permissions(role_permission_id)
	ON UPDATE CASCADE ON DELETE CASCADE	
);
ALTER TABLE t_acl_rules OWNER TO magnumopus;

CREATE TABLE IF NOT EXISTS t_group (
	group_id SERIAL PRIMARY KEY, 
	group_name VARCHAR		
);
ALTER TABLE t_group OWNER TO magnumopus;

CREATE TABLE IF NOT EXISTS t_group_user_mapping (
	group_user_mapping_id SERIAL PRIMARY KEY, 
	user_id INT NOT NULL, 
	group_id INT NOT NULL, 
	
	CONSTRAINT fk_mapping_user FOREIGN KEY(user_id) REFERENCES t_user(user_id)
	ON UPDATE CASCADE ON DELETE CASCADE,	
	CONSTRAINT fk_mapping_group FOREIGN KEY(group_id) REFERENCES t_group(group_id)
	ON UPDATE CASCADE ON DELETE CASCADE		
);
ALTER TABLE t_group_user_mapping OWNER TO magnumopus;