-- ALL DATA ARE IMPORTED HERE


INSERT INTO LOGIN_USER (EMP_ID, EMP_Name, EMP_Date_Of_Hire, EMP_Supervisor, email, password, role) VALUES ('82D58D49-72A2-42B0-A250-471E5C10D7D9', 'Greg', '2018-6-5' , null , 'greg@test.com', '$2a$10$dwF44b7vyxH0qKY2Q5Bi1ulVUwjxv9L5UmEgBKfcCU9WtpqXwjsy.','USER');
INSERT INTO LOGIN_USER (EMP_ID, EMP_Name, EMP_Date_Of_Hire, EMP_Supervisor, email, password, role) VALUES ('8CEE7A83-A9EB-4170-B7E8-5D4F0440C074', 'Oleg','2018-6-5' , '82D58D49-72A2-42B0-A250-471E5C10D7D9','oleg@test.com', '$2a$10$dwF44b7vyxH0qKY2Q5Bi1ulVUwjxv9L5UmEgBKfcCU9WtpqXwjsy.','USER');
INSERT INTO LOGIN_USER (EMP_ID, EMP_Name, EMP_Date_Of_Hire, EMP_Supervisor, email, password, role) VALUES ('561E2D88-A747-460F-99E1-CFB1D3D8CA5C', 'Pete','2018-6-5', '8CEE7A83-A9EB-4170-B7E8-5D4F0440C074', 'pete@test.com', '$2a$10$dwF44b7vyxH0qKY2Q5Bi1ulVUwjxv9L5UmEgBKfcCU9WtpqXwjsy.','USER');
INSERT INTO LOGIN_USER (EMP_ID, EMP_Name, EMP_Date_Of_Hire, EMP_Supervisor, email, password, role) VALUES ('28106345-435B-4215-AECF-7C226C071E11', 'Paul','2018-6-5', '82D58D49-72A2-42B0-A250-471E5C10D7D9', 'paul@test.com', '$2a$10$dwF44b7vyxH0qKY2Q5Bi1ulVUwjxv9L5UmEgBKfcCU9WtpqXwjsy.','USER');
INSERT INTO LOGIN_USER (EMP_ID, EMP_Name, EMP_Date_Of_Hire, EMP_Supervisor, email, password, role) VALUES ('7012F5C7-33AD-4839-A092-4FA6E1448A5D', 'Aura','2018-6-5', '82D58D49-72A2-42B0-A250-471E5C10D7D9', 'auraz@test.com','$2a$10$dwF44b7vyxH0qKY2Q5Bi1ulVUwjxv9L5UmEgBKfcCU9WtpqXwjsy.','USER');
INSERT INTO LOGIN_USER (EMP_ID, EMP_Name, EMP_Date_Of_Hire, EMP_Supervisor, email, password, role) VALUES ('2E3074E7-8FFB-4C5F-83AE-962812F93D08', 'Phil','2018-6-5', '82D58D49-72A2-42B0-A250-471E5C10D7D9', 'phil@test.com', '$2a$10$dwF44b7vyxH0qKY2Q5Bi1ulVUwjxv9L5UmEgBKfcCU9WtpqXwjsy.','USER');

-- insert into "Employee" values ('{82D58D49-72A2-42B0-A250-471E5C10D7D9}', '{Greg}', NOW(), null);
-- insert into "Employee" values('{8CEE7A83-A9EB-4170-B7E8-5D4F0440C074}', '{Oleg}', NOW(), '{82D58D49-72A2-42B0-A250-471E5C10D7D9}');
-- insert into "Employee" values('{561E2D88-A747-460F-99E1-CFB1D3D8CA5C}', '{Pete}', NOW(), '{8CEE7A83-A9EB-4170-B7E8-5D4F0440C074}');
-- insert into "Employee" values('{28106345-435B-4215-AECF-7C226C071E11}', '{Paul}', NOW(), '{82D58D49-72A2-42B0-A250-471E5C10D7D9}');
-- insert into "Employee" values('{7012F5C7-33AD-4839-A092-4FA6E1448A5D}', '{Aura}', NOW(), '{82D58D49-72A2-42B0-A250-471E5C10D7D9}');
-- insert into "Employee" values('{2E3074E7-8FFB-4C5F-83AE-962812F93D08}', '{Phil}', NOW(), '{82D58D49-72A2-42B0-A250-471E5C10D7D9}');

-- insert into "Attribute" values ('{3C86A592-823B-4B83-952F-F437D08F2EA8}', '{Height}', '{Tall}');
-- insert into "Attribute" values ('{70C311F5-B2B0-4118-A069-3AB9C3AC65E1}', '{Height}', '{Short}');
-- insert into "Attribute" values ('{82FF24BB-0180-40F9-B68E-15799556A5C2}', '{Height}', '{Medium}');
-- insert into "Attribute" values ('{EB812BF6-3415-4686-A0B6-38089C87D09D}', '{Height}', '{Short}');
--
-- insert into "Attribute" values ('{83382664-DA55-4C6D-8D18-ED79C26332A8}', '{Weight}', '{Medium}');
-- insert into "Attribute" values ('{F27B9C58-FD9E-4EB1-9B09-E01FF7032CC8}', '{Weight}', '{Thin}');
-- insert into "Attribute" values ('{4F8EAC6B-8B29-4716-A597-C8CDE3A3996D}', '{Weight}', '{Heavy}');
--
-- insert into "EmployeeAttribute" values ('{82D58D49-72A2-42B0-A250-471E5C10D7D9}', '{3C86A592-823B-4B83-952F-F437D08F2EA8}');
-- insert into "EmployeeAttribute" values ('{8CEE7A83-A9EB-4170-B7E8-5D4F0440C074}', '{70C311F5-B2B0-4118-A069-3AB9C3AC65E1}');
-- insert into "EmployeeAttribute" values ('{561E2D88-A747-460F-99E1-CFB1D3D8CA5C}', '{82FF24BB-0180-40F9-B68E-15799556A5C2}');
-- insert into "EmployeeAttribute" values ('{28106345-435B-4215-AECF-7C226C071E11}', '{EB812BF6-3415-4686-A0B6-38089C87D09D}');
--
-- insert into "EmployeeAttribute" values ('{2E3074E7-8FFB-4C5F-83AE-962812F93D08}', '{4F8EAC6B-8B29-4716-A597-C8CDE3A3996D}');
-- insert into "EmployeeAttribute" values ('{8CEE7A83-A9EB-4170-B7E8-5D4F0440C074}', '{F27B9C58-FD9E-4EB1-9B09-E01FF7032CC8}');
-- insert into "EmployeeAttribute" values ('{82D58D49-72A2-42B0-A250-471E5C10D7D9}', '{83382664-DA55-4C6D-8D18-ED79C26332A8}');

