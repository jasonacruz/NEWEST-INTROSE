package databaseCodes;

import ProgramCodes.Classroom;
import ProgramCodes.Employee;
import ProgramCodes.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.lang.Exception;

public class ClassroomDAO{
        private ArrayList<Student> studentList;
        private Student s;
	Connection connection = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	/*
	public boolean addSection(Section s)
	{
		try {
				String queryString = "INSERT INTO SECTION( sect_name, sect_yrlvl) VALUES (?, ?)";
				connection = getConnection();
				stmt = connection.prepareStatement(queryString);
				stmt.setString(1, s.getSectname());
				stmt.setInt(2, s.getYearlvl());
				stmt.executeUpdate();
			}catch (SQLException e) {
                            System.out.println(e.getMessage());
			return false;
	}
	return true;
	}
        */
        public ArrayList<Student> setStudentList(Classroom c)
        {
            try
            {
                    studentList = new ArrayList<Student>();
                    String queryString = "SELECT idStudent, lastNameSt, firstNameSt, middleNameSt from studentRoster, Student, section where sectionName = ? AND sectionYearLevel = ? AND sectionSchoolYear = ? AND idStudent = sr_studentID AND sectionID = sr_classID ORDER BY lastNameSt, firstNameSt ";
                    connection = getConnection();
                    stmt = connection.prepareStatement(queryString); 
                    stmt.setString(1, c.getSectName());
                    stmt.setInt(2, c.getSectYearlvl());
                    stmt.setInt(3, c.getSchoolYear());
                ResultSet resultString = stmt.executeQuery();
                    while(resultString.next())
                    {
                        s = new Student();
                        s.setIdNum(resultString.getString("idStudent"));
                        s.setFirstName(resultString.getString("firstNameSt"));
                        s.setMidName(resultString.getString("middleNameSt"));
                        s.setLastName(resultString.getString("lastNameST"));
                        studentList.add(s);
                        c.setStudentList(studentList);
                    }         
                    
            }
            catch (SQLException e) {
			 System.out.println(e.getMessage());
            }
                 return studentList;
        }/*
        public boolean addAdviser(Classroom c)
        {
             try {
				String queryString = "INSERT INTO CLASSADVISER(class_name, class_schlyear, class_prof) VALUES (?, YEAR(CURRENT_TIME), ?)";
				connection = getConnection();
				stmt = connection.prepareStatement(queryString);
				stmt.setString(1, c.getSection().getSectname());
				stmt.setInt(2, c.getEmp().getID());
				stmt.executeUpdate();
			}catch (SQLException e) {
                            System.out.println(e.getMessage());
			return false;
	}
	return true;
        }
        public boolean addtoClass(Classroom c)
        {
                try {
				String queryString = "INSERT INTO CLASSSTUDENT(class_name, class_schlyear, class_student) VALUES (?, YEAR(CURRENT_TIME),?)";
				connection = getConnection();
				stmt = connection.prepareStatement(queryString);
				stmt.setString(1, c.getSection().getSectname());
                                stmt.setInt(2, c.getStudent().getId());
				stmt.executeUpdate();
			}catch (SQLException e) {
                            System.out.println(e.getMessage());
			return false;
	}
	return true;
        }
        
        public boolean addSubjTeach(Classroom c)
        {
            try {
				String queryString = "INSERT INTO ClassTeacher(course_name, class_name, class_schlyear, class_prof) VALUES (?, ?, year(current_time),?)";
				connection = getConnection();
				stmt = connection.prepareStatement(queryString);
                                stmt.setString(1, c.getCourse().getCoursename());
				stmt.setString(2, c.getSection().getSectname());
				stmt.setInt(3, c.getEmp().getID());
				stmt.executeUpdate();
			}catch (SQLException e) {
                            System.out.println(e.getMessage());
			return false;
	}
	return true;
        }
        */
        public boolean getSubjectInfo(Employee emp, String[] SubjectList, int schoolYear)
        {
            int x = 0;
            try
            {
                    String queryString = "SELECT sectionYearLevel, subjectName, sectionName FROM SECTION , SUBJECT , CLASSTEACHER  where sectionSchoolYear = ? AND ct_idEmployee = ? AND ct_subjectID = subjectID AND ct_classID = sectionID ORDER BY sectionYearLevel;";
                    connection = getConnection();
                    stmt = connection.prepareStatement(queryString);
                    stmt.setInt(1, schoolYear);
                    stmt.setString(2, emp.getIdNum());
                ResultSet resultString = stmt.executeQuery();
                    while(resultString.next())
                    {
                        
                        SubjectList[x] = (""+resultString.getString("sectionYearLevel")+" - "+(resultString.getString("sectionName"))+" - "+ (resultString.getString("subjectName")));
                        System.out.println(SubjectList[x]);
                        x++;}                
                    return true;
            }
            catch (SQLException e) {
			 System.out.println(e.getMessage());
                         return false;
            }
        }
        
        public boolean getAdviserSect(Employee emp, String[] SubjectList, int schoolYear)
        { 
            int x = 0;
            try
            {
                    String queryString = "SELECT sectionYearLevel, sectionName FROM CLASSADVISER CA, SECTION S where adviserID= ? AND sectionSchoolYear = ? AND sectionID = ca_classID ORDER BY sectionYearLevel;";
                    connection = getConnection();
                    stmt = connection.prepareStatement(queryString);
                    stmt.setString(1, emp.getIdNum());
                    stmt.setInt(2, schoolYear);
                ResultSet resultString = stmt.executeQuery();
                    while(resultString.next())
                    {
                        SubjectList[x] = (""+resultString.getString("sectionYearLevel")+" - "+(resultString.getString("sectionName")) + " - Adviser");
                        System.out.println(SubjectList[x]);
                        x++;}                
                    return true;
            }
            catch (SQLException e) {
			 System.out.println(e.getMessage());
                         return false;
            }
        }
        public boolean getSection(int s, String[] SectList)
        {
            int x = 0;
            try
            {
                    String queryString = "SELECT sect_name FROM SECTION WHERE sect_yrlvl= ?";
                    connection = getConnection();
                    stmt = connection.prepareStatement(queryString);
                    stmt.setInt(1, s);
                ResultSet resultString = stmt.executeQuery();
                    while(resultString.next())
                    {
                        SectList[x] = resultString.getString("sect_name");
                        System.out.println(SectList[x]);
                        x++;}                
                    return true;
            }
            catch (SQLException e) {
			 System.out.println(e.getMessage());
                         return false;
            }
		
        }
        
        public int getSectionID(String sectionName, int yearLevel, int schoolYear)
        {  int x = 0;
            try
            {
                    String queryString = "SELECT sectionID FROM Section WHERE sectionName = ? AND sectionYearLevel = ? AND sectionSchoolYear = ?";
                    connection = getConnection();
                    stmt = connection.prepareStatement(queryString);
                    stmt.setString(1, sectionName);
                    stmt.setInt(2, yearLevel);
                    stmt.setInt(3, schoolYear);
                     ResultSet resultString = stmt.executeQuery();
                     resultString.next();
                    return resultString.getInt(1);
            }
            catch (SQLException e) {
			 System.out.println(e.getMessage());
                         return 0;
            }
		
        }
}