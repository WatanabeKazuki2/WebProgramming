CREATE DATABASE user DEFAULT CHARACTER SET utf8;
USE user;

CREATE TABLE user (
id SERIAL,
login_id varchar(255) UNIQUE NOT NULL,
name varchar(255) NOT NULL,
birth_date DATE NOT NULL,
password varchar(255) NOT NULL,
create_date DATETIME NOT NULL,
update_date DATETIME NOT NULL
);
INSERT INTO user
(login_id,name,birth_date,password,create_date,update_date)
VALUES
('addmin','管理者','1990-01-01','password','2018-11-01','2018-11-06');

INSERT INTO user
(login_id,name,birth_date,password,create_date,update_date)
VALUES
('player','ポムポム','2017-01-01','password','2018-11-03','2018-11-06');

UPDATE user SET password = '5F4DCC3B5AA765D61D8327DEB882CF99';