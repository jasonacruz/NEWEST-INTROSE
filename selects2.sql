SELECT * FROM SECTION;

SELECT * FROM studentroster;

SELECT * FROM CLASSADVISER;
SELECT * FROM subject;


SELECT sectionYear, subjectName, sectionName FROM CLASSADVISER CA, SECTION S, SUBJECT SU, CLASSTEACHER CT where ct_classYear = 2013 AND ct_idEmployee = 11233877 AND ct.ct_subjectID = subjectID AND ct_classID = classID ORDER BY sectionYear;

SELECT * FROM GRADECOMPOSITION
