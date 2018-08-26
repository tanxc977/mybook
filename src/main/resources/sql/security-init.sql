insert into PERMISSION (PERMISSION_ID, PERMISSION_DESC, PERMISSION_URL,method, CREATED_USER, CREATED_DATE, LAST_UPDATE_BY, LAST_UPDATE_DATE)
values ('p1', '访问首页', '/index', 'get','sys', null, null, null);

insert into ROLE_INFO (ROLE_ID, ROLE_CODE, ROLE_NAME, CREATED_USER, CREATED_DATE, LAST_UPDATE_BY, LAST_UPDATE_DATE)
values ('r1', 'ROLE_GRANT_AUTHORIZATION', '角色管理员', 'cy', null, null, null);

insert into ROLE_INFO (ROLE_ID, ROLE_CODE, ROLE_NAME, CREATED_USER, CREATED_DATE, LAST_UPDATE_BY, LAST_UPDATE_DATE)
values ('r1', 'ROLE_ADMIN', '超级管理员', 'cy', null, null, null);

insert into ROLE_REL_PERMISSION (ROLE_ID, PERMISSION_ID, CREATED_USER, CREATED_DATE, LAST_UPDATE_BY, LAST_UPDATE_DATE)
values ('r1', 'p1', 'cy', null, null, null);

insert into USER_INFO (USER_ID, USER_NAME, PASS_WORD, SEX, DEPARTMENT_ID, STATUS, CREATED_USER, CREATED_DATE, LAST_UPDATE_BY, LAST_UPDATE_DATE)
values ('037', 'cy', '037', '1', 'xxb', 'y', null, null, null, null);

insert into USER_REL_ROLE (USER_ID, ROLE_ID, CREATED_USER, CREATED_DATE, LAST_UPDATE_BY, LAST_UPDATE_DATE)
values ('037', 'r1', 'cy', null, null, null);
