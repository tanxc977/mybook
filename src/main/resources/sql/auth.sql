drop table if EXISTS Sys_User;
CREATE TABLE Sys_User (
id bigint NOT NULL AUTO_INCREMENT ,
username  varchar(30),
password VARCHAR(30),
PRIMARY KEY (id)
)ENGINE=InnoDB CHARSET='utf8';

drop table  if EXISTS Sys_Role;
CREATE TABLE Sys_Role (
  id bigint NOT NULL AUTO_INCREMENT ,
  roleName  varchar(30),
  PRIMARY KEY (id)
)ENGINE=InnoDB CHARSET='utf8';

DROP TABLE IF EXISTS Sys_Role_User;
CREATE TABLE Sys_Role_User(
  id BIGINT NOT NULL AUTO_INCREMENT,
  sysUserId BIGINT,
  roleId BIGINT,
  PRIMARY KEY (id)
)ENGINE=InnoDB CHARSET = 'utf8';

DROP TABLE IF EXISTS sys_permission;
CREATE TABLE sys_permission(
  id BIGINT NOT NULL AUTO_INCREMENT,
  name VARCHAR(30),
  description VARCHAR(60),
  url VARCHAR(100),
  pid VARCHAR(30),
  PRIMARY KEY (id)
)ENGINE=InnoDB CHARSET = 'utf8';

DROP TABLE IF EXISTS sys_permission_role;
CREATE TABLE sys_permission_role(
  id BIGINT NOT NULL AUTO_INCREMENT,
  roleId BIGINT,
  permissionId BIGINT,
  PRIMARY KEY (id)
)ENGINE=InnoDB CHARSET = 'utf8';

