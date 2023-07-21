INSERT INTO holidays (day,reason,type,created_at, created_by)
 VALUES (' Jan 1 ','New Year''s Day','FESTIVAL',CURRENT_DATE,'DBA');

INSERT INTO holidays (day,reason,type,created_at, created_by)
 VALUES (' Oct 31 ','Halloween','FESTIVAL',CURRENT_DATE,'DBA');

INSERT INTO holidays (day,reason,type,created_at, created_by)
 VALUES ( 'Nov 24 ','Thanksgiving Day','FESTIVAL',CURRENT_DATE,'DBA');

INSERT INTO holidays (day,reason,type,created_at, created_by)
 VALUES (' Dec 25 ','Christmas','FESTIVAL',CURRENT_DATE,'DBA');

INSERT INTO holidays (day,reason,type,created_at, created_by)
 VALUES (' Jan 17 ','Martin Luther King Jr. Day','FEDERAL',CURRENT_DATE,'DBA');

INSERT INTO holidays (day,reason,type,created_at, created_by)
 VALUES (' July 4 ','Independence Day','FEDERAL',CURRENT_DATE,'DBA');

INSERT INTO holidays (day,reason,type,created_at, created_by)
 VALUES (' Sep 5 ','Labor Day','FEDERAL',CURRENT_DATE,'DBA');

INSERT INTO holidays (day,reason,type,created_at, created_by)
  VALUES (' Nov 11 ','Veterans Day','FEDERAL',CURRENT_DATE,'DBA');

-- ROLES
INSERT INTO roles (role_name,created_at, created_by)
  VALUES ('ADMIN',CURDATE(),'DBA');

INSERT INTO roles (role_name,created_at, created_by)
  VALUES ('STUDENT',CURDATE(),'DBA');

INSERT INTO users (name,email,mobile_number,password,role_id,created_at, created_by)
  VALUES ('Admin','admin@codeschool.com','9988776655','$2a$12$TFw44sgxvSiqSm9OxtuP9OqE/Bwok0XUULVQwh4JnkTaafzcicZI2', 1 ,CURRENT_DATE,'DBA');
  