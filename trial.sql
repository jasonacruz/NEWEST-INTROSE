INSERT INTO EMPLOYEE(`idEmployee`, `firstNameEmp`, `middleNameEmp`, `lastNameEmp`,  `contactNumberEmp`, `positionEmp`, `departmentEmp`, `passwordEmp`, `addressEmp`, `passFlagEmp`) VALUES (99999999, '','','','','Administrator', '','admin1234', '', 1);

INSERT INTO EMPLOYEE(`idEmployee`, `firstNameEmp`, `middleNameEmp`, `lastNameEmp`,  `contactNumberEmp`, `positionEmp`, `departmentEmp`, `passwordEmp`, `addressEmp`, `passFlagEmp`) VALUES (11233877, 'Jason','Anthony','Cruz','1234567','Subject Teacher', 'Elementary','Isawboy', 'blabla', 1);

INSERT INTO EMPLOYEE(`idEmployee`, `firstNameEmp`, `middleNameEmp`, `lastNameEmp`,  `contactNumberEmp`, `positionEmp`, `departmentEmp`, `passwordEmp`, `addressEmp`, `passFlagEmp`) VALUES (12345678, 'Jason','Anthon','Cruz','1234567','Principal', 'NonE','Isawboy', 'blabla', 1);

INSERT INTO SECTION(`sectionName`, `sectionYear`) VALUES ('Peace', 2);
INSERT INTO STUDENT(idStudent,firstNameSt,middleNameSt,lastNameSt,genderSt,birthDateSt,yearLevelSt) VALUES (123456, 'jason', 'antyhon', 'cruz', 'm', 'October-12-1995', '1'); 
INSERT INTO CLASS(`Section_idSection`, `classYear`, `studentID`, `adviserID`) VALUES(1, 2014, 0,0);

SELECT  CURRENT_DATE() as YEARNOW, date_format(CURRENT_DATE(), '%M %d, %Y');