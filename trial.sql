INSERT INTO EMPLOYEE(idEmployee,firstNameEmp,middleNameEmp,lastNameEmp,contactNumberEmp,positionEmp,departmentEmp,passwordEmp,addressEmp,passFlagEmp, genderEmp) VALUES ('admin', '','','','','Administrator', '','admin1234', '', 1,'');

INSERT INTO EMPLOYEE(idEmployee,firstNameEmp,middleNameEmp,lastNameEmp,contactNumberEmp,positionEmp,departmentEmp,passwordEmp,addressEmp,passFlagEmp,genderEmp) VALUES (11233877, 'Jason','Anthony','Cruz','1234567','Subject Teacher', 'Elementary','Isawboy', 'blabla', 1, 'Male');

INSERT INTO EMPLOYEE(idEmployee,firstNameEmp,middleNameEmp,lastNameEmp,contactNumberEmp,positionEmp,departmentEmp,passwordEmp,addressEmp,passFlagEmp,genderEmp) VALUES (12345678, 'Jason','Anthon','Cruz','1234567','Principal', 'NonE','Isawboy', 'blabla', 1, 'Female');

INSERT INTO SECTION(`sectionName`, `sectionYear`) VALUES ('Peace', 2);
INSERT INTO SECTION(`sectionName`, `sectionYear`) VALUES ('Love', 5);

INSERT INTO SUBJECT(subjectName,subjectDepartment) VALUES ('Mathematics', 'Elementary');
INSERT INTO SUBJECT(subjectName,subjectDepartment) VALUES ('Mathematics', 'High School');
INSERT INTO SUBJECT(subjectName,subjectDepartment) VALUES ('Filipino', 'High School');
INSERT INTO SUBJECT(subjectName,subjectDepartment) VALUES ('Filipino', 'Elementary');

INSERT INTO STUDENT(idStudent,firstNameSt,middleNameSt,lastNameSt,genderSt,birthDateSt,yearLevelSt) VALUES (123456, 'jason', 'antyhon', 'cruz', 'm', 'October-12-1995', '1');
INSERT INTO STUDENT(idStudent,firstNameSt,middleNameSt,lastNameSt,genderSt,birthDateSt,yearLevelSt) VALUES (1234567, 'jasone', 'antyhon', 'cruz', 'm', 'October-12-1995', '1'); 
INSERT INTO STUDENT(idStudent,firstNameSt,middleNameSt,lastNameSt,genderSt,birthDateSt,yearLevelSt) VALUES (12345678, 'jasonee', 'antyhon', 'cruz', 'm', 'October-12-1995', '1'); 

INSERT INTO CLASSADVISER(classYear,classSection,adviserID) VALUES(2013, 'Peace',99999999);
INSERT INTO CLASSADVISER(classYear,classSection,adviserID) VALUES(2013, 'Love', 11233877);
INSERT INTO CLASSADVISER(classYear,classSection,adviserID) VALUES(2014, 'Love',12345678);
INSERT INTO CLASSADVISER(classYear,classSection,adviserID) VALUES(2015, 'Peace',99999999);
INSERT INTO CLASSADVISER(classYear,classSection,adviserID) VALUES(2014, 'Peace',11233877);

INSERT INTO classsubject(cs_classYear,cs_classID,cs_subjectID) VALUES(2013,2, 1);
INSERT INTO classsubject(cs_classYear,cs_classID,cs_subjectID) VALUES(2015, 4, 1);
INSERT INTO classsubject(cs_classYear,cs_classID,cs_subjectID) VALUES(2013, 2, 3);
INSERT INTO classsubject(cs_classYear,cs_classID,cs_subjectID) VALUES(2013,2, 2);
INSERT INTO classsubject(cs_classYear,cs_classID,cs_subjectID) VALUES(2013, 1, 7);
INSERT INTO classsubject(cs_classYear,cs_classID,cs_subjectID) VALUES(2013, 2, 7);

INSERT INTO CLASSTEACHER(ct_classID,ct_subjectID,ct_idEmployee,ct_classYear) VALUES (2, 1, 11233877, 2013);
INSERT INTO CLASSTEACHER(ct_classID,ct_subjectID,ct_idEmployee,ct_classYear) VALUES (1, 3, 11233877,2013);
INSERT INTO CLASSTEACHER(ct_classID,ct_subjectID,ct_idEmployee,ct_classYear) VALUES (1, 7, 11233877,2013);
INSERT INTO CLASSTEACHER(ct_classID,ct_subjectID,ct_idEmployee,ct_classYear) VALUES (2, 7, 11233877,2013);


INSERT INTO GRADECOMPOSITION(gc_classYear,gc_classID,gc_subjectID,gc_gradeQuarter,gc_gradeComp,gc_gradeCompNumber,KnowledgeValue,UnderstandingValue,SkillValue,ProductValue) VALUES(2013, 2,1,1,'Quiz',(SELECT (COUNT(*)+1) FROM (SELECT * FROM GRADECOMPOSITION) as gc WHERE gc_classID = 2 AND gc_subjectID = 1 AND gc_gradeQuarter = 1 AND gc_gradeComp = 'Quiz'), 30,40,20,50);

INSERT INTO GRADECOMPOSITION(gc_classYear,gc_classID,gc_subjectID,gc_gradeQuarter,gc_gradeComp,gc_gradeCompNumber,KnowledgeValue,UnderstandingValue,SkillValue,ProductValue) VALUES(2013, 2,1,1,'Periodical Exam', 0, 30,40,20,50);

INSERT INTO GRADECOMPOSITION(gc_classYear,gc_classID,gc_subjectID,gc_gradeQuarter,gc_gradeComp,gc_gradeCompNumber,KnowledgeValue,UnderstandingValue,SkillValue,ProductValue) VALUES(2013, 2,1,1,'Seatwork', 1,30,40,20,50);

INSERT INTO STUDENTROSTER(sr_ClassID,sr_StudentID, sr_classYear) VALUES(2, 123456, 2013);
INSERT INTO STUDENTROSTER(sr_ClassID,sr_StudentID, sr_classYear) VALUES(3, 123456,2015);
INSERT INTO STUDENTROSTER(sr_ClassID,sr_StudentID, sr_classYear) VALUES(4, 123456,2015);
