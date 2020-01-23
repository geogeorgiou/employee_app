-- ALL DATA ARE IMPORTED HERE


INSERT INTO Employee (EMP_ID, EMP_Name, EMP_Date_Of_Hire, EMP_Supervisor, email, password, role) VALUES ('82D58D49-72A2-42B0-A250-471E5C10D7D9', 'Greg', CURDATE(), null , 'greg@test.com', '$2a$10$dwF44b7vyxH0qKY2Q5Bi1ulVUwjxv9L5UmEgBKfcCU9WtpqXwjsy.','USER');
INSERT INTO Employee (EMP_ID, EMP_Name, EMP_Date_Of_Hire, EMP_Supervisor, email, password, role) VALUES ('8CEE7A83-A9EB-4170-B7E8-5D4F0440C074', 'Oleg', CURDATE(), '82D58D49-72A2-42B0-A250-471E5C10D7D9','oleg@test.com', '$2a$10$dwF44b7vyxH0qKY2Q5Bi1ulVUwjxv9L5UmEgBKfcCU9WtpqXwjsy.','USER');
INSERT INTO Employee (EMP_ID, EMP_Name, EMP_Date_Of_Hire, EMP_Supervisor, email, password, role) VALUES ('561E2D88-A747-460F-99E1-CFB1D3D8CA5C', 'Pete', CURDATE(), '8CEE7A83-A9EB-4170-B7E8-5D4F0440C074', 'pete@test.com', '$2a$10$dwF44b7vyxH0qKY2Q5Bi1ulVUwjxv9L5UmEgBKfcCU9WtpqXwjsy.','USER');
INSERT INTO Employee (EMP_ID, EMP_Name, EMP_Date_Of_Hire, EMP_Supervisor, email, password, role) VALUES ('28106345-435B-4215-AECF-7C226C071E11', 'Paul', CURDATE(), '82D58D49-72A2-42B0-A250-471E5C10D7D9', 'paul@test.com', '$2a$10$dwF44b7vyxH0qKY2Q5Bi1ulVUwjxv9L5UmEgBKfcCU9WtpqXwjsy.','USER');
INSERT INTO Employee (EMP_ID, EMP_Name, EMP_Date_Of_Hire, EMP_Supervisor, email, password, role) VALUES ('7012F5C7-33AD-4839-A092-4FA6E1448A5D', 'Aura', CURDATE(), '82D58D49-72A2-42B0-A250-471E5C10D7D9', 'auraz@test.com','$2a$10$dwF44b7vyxH0qKY2Q5Bi1ulVUwjxv9L5UmEgBKfcCU9WtpqXwjsy.','USER');
INSERT INTO Employee (EMP_ID, EMP_Name, EMP_Date_Of_Hire, EMP_Supervisor, email, password, role) VALUES ('2E3074E7-8FFB-4C5F-83AE-962812F93D08', 'Phil', CURDATE(), '82D58D49-72A2-42B0-A250-471E5C10D7D9', 'phil@test.com', '$2a$10$dwF44b7vyxH0qKY2Q5Bi1ulVUwjxv9L5UmEgBKfcCU9WtpqXwjsy.','USER');


insert into Attribute (ATTR_ID,ATTR_Name,ATTR_Value) values ('3C86A592-823B-4B83-952F-F437D08F2EA8', 'Height', 'Tall');
insert into Attribute (ATTR_ID,ATTR_Name,ATTR_Value) values ('70C311F5-B2B0-4118-A069-3AB9C3AC65E1', 'Height', 'Short');
insert into Attribute (ATTR_ID,ATTR_Name,ATTR_Value) values ('82FF24BB-0180-40F9-B68E-15799556A5C2', 'Height', 'Medium');
insert into Attribute (ATTR_ID,ATTR_Name,ATTR_Value) values ('EB812BF6-3415-4686-A0B6-38089C87D09D', 'Height', 'Short');

insert into Attribute (ATTR_ID,ATTR_Name,ATTR_Value) values ('83382664-DA55-4C6D-8D18-ED79C26332A8', 'Weight', 'Medium');
insert into Attribute (ATTR_ID,ATTR_Name,ATTR_Value) values ('F27B9C58-FD9E-4EB1-9B09-E01FF7032CC8', 'Weight', 'Thin');
insert into Attribute (ATTR_ID,ATTR_Name,ATTR_Value) values ('4F8EAC6B-8B29-4716-A597-C8CDE3A3996D', 'Weight', 'Heavy');
--
insert into EmployeeAttribute (EMP_ID,ATTR_ID) values ('82D58D49-72A2-42B0-A250-471E5C10D7D9', '3C86A592-823B-4B83-952F-F437D08F2EA8');
insert into EmployeeAttribute (EMP_ID,ATTR_ID) values ('8CEE7A83-A9EB-4170-B7E8-5D4F0440C074', '70C311F5-B2B0-4118-A069-3AB9C3AC65E1');
insert into EmployeeAttribute (EMP_ID,ATTR_ID) values ('561E2D88-A747-460F-99E1-CFB1D3D8CA5C', '82FF24BB-0180-40F9-B68E-15799556A5C2');
insert into EmployeeAttribute (EMP_ID,ATTR_ID) values ('28106345-435B-4215-AECF-7C226C071E11', 'EB812BF6-3415-4686-A0B6-38089C87D09D');

insert into EmployeeAttribute (EMP_ID,ATTR_ID) values ('2E3074E7-8FFB-4C5F-83AE-962812F93D08', '4F8EAC6B-8B29-4716-A597-C8CDE3A3996D');
insert into EmployeeAttribute (EMP_ID,ATTR_ID) values ('8CEE7A83-A9EB-4170-B7E8-5D4F0440C074', 'F27B9C58-FD9E-4EB1-9B09-E01FF7032CC8');
insert into EmployeeAttribute (EMP_ID,ATTR_ID) values ('82D58D49-72A2-42B0-A250-471E5C10D7D9', '83382664-DA55-4C6D-8D18-ED79C26332A8');

