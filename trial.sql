INSERT INTO EMPLOYEE(idEmployee,firstNameEmp,middleNameEmp,lastNameEmp,contactNumberEmp,positionEmp,departmentEmp,passwordEmp,addressEmp,passFlagEmp) VALUES (99999999, '','','','','Administrator', '','admin1234', '', 1);

INSERT INTO EMPLOYEE(idEmployee,firstNameEmp,middleNameEmp,lastNameEmp,contactNumberEmp,positionEmp,departmentEmp,passwordEmp,addressEmp,passFlagEmp) VALUES (11233877, 'Jason','Anthony','Cruz','1234567','Subject Teacher', 'Elementary','Isawboy', 'blabla', 1);

INSERT INTO EMPLOYEE(idEmployee,firstNameEmp,middleNameEmp,lastNameEmp,contactNumberEmp,positionEmp,departmentEmp,passwordEmp,addressEmp,passFlagEmp) VALUES (12345678, 'Jason','Anthon','Cruz','1234567','Principal', 'NonE','Isawboy', 'blabla', 1);

INSERT INTO SECTION(`sectionName`, `sectionYear`) VALUES ('Peace', 2);
INSERT INTO SECTION(`sectionName`, `sectionYear`) VALUES ('Love', 5);

INSERT INTO STUDENT(idStudent,firstNameSt,middleNameSt,lastNameSt,genderSt,birthDateSt,yearLevelSt) VALUES (123456, 'jason', 'antyhon', 'cruz', 'm', 'October-12-1995', '1');
INSERT INTO STUDENT(idStudent,firstNameSt,middleNameSt,lastNameSt,genderSt,birthDateSt,yearLevelSt) VALUES (1234567, 'jasone', 'antyhon', 'cruz', 'm', 'October-12-1995', '1'); 
INSERT INTO STUDENT(idStudent,firstNameSt,middleNameSt,lastNameSt,genderSt,birthDateSt,yearLevelSt) VALUES (12345678, 'jasonee', 'antyhon', 'cruz', 'm', 'October-12-1995', '1'); 
INSERT INTO CLASSADVISER(classYear,classSection,adviserID) VALUES(2013, 'Peace',99999999);
INSERT INTO CLASSADVISER(classYear,classSection,adviserID) VALUES(2014, 'Love',12345678);
INSERT INTO CLASSADVISER(classYear,classSection,adviserID) VALUES(2015, 'Peace',99999999);
INSERT INTO CLASSADVISER(classYear,classSection,adviserID) VALUES(2014, 'Peace',11233877);
INSERT INTO STUDENTROSTER(sr_ClassID,sr_StudentID) VALUES(1, 123456);