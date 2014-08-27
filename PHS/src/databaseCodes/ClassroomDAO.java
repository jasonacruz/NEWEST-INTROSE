package databaseCodes;

import ProgramCodes.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.lang.Exception;

public class ClassroomDAO{
	Connection connection = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
        
        public boolean addAdviser(String x, int y)
        {
             try {
		String queryString = "INSERT INTO CLASSADVISER(adviserID, ca_classID) VALUES (?, ?)";
		connection = getConnection();
		stmt = connection.prepareStatement(queryString);
		stmt.setString(1, x);
                stmt.setInt(2, y);
		stmt.executeUpdate();
             }catch (SQLException e) {
                System.out.println(e.getMessage()+ e.getErrorCode());
                return false;
            }
            return true;
        }
        
        public boolean addSubjTeacher(String x, int y, int z){
            try {
		String queryString = "INSERT INTO CLASSTEACHER(ct_subjectId, ct_idEmployee ,ct_classID) VALUES (?,?,?)";
		connection = getConnection();
		stmt = connection.prepareStatement(queryString);
		stmt.setInt(1, z);
		stmt.setInt(3, y);
                stmt.setString(2, x);
		stmt.executeUpdate();
             }catch (SQLException e) {
                System.out.println(e.getMessage()+ e.getErrorCode());
                return false;
            }
            return true;
        }
        
        public boolean addToClass(String x, int y)
        {
             try {
		String queryString = "INSERT INTO STUDENTROSTER(sr_classID, sr_studentID) VALUES (?, ?)";
		connection = getConnection();
		stmt = connection.prepareStatement(queryString);
		stmt.setString(2, x);
                stmt.setInt(1, y);
		stmt.executeUpdate();
             }catch (SQLException e) {
                System.out.println(e.getMessage()+ e.getErrorCode());
                return false;
            }
            return true;
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
        public ArrayList<Student> getStudent(Classroom c)
        {
            try
            {
                    studentList = new ArrayList<Student>();
                    String queryString = "SELECT st.st_id, st.st_firstname, st.st_lastname FROM  CLASSSTUDENT c, STUDENT st WHERE st_id = class_student AND c.class_name = ? AND c.class_schlyear = YEAR(CURRENT_TIME)";
                    connection = getConnection();
                    stmt = connection.prepareStatement(queryString); 
                    stmt.setString(1, c.getSection().getSectname());
                ResultSet resultString = stmt.executeQuery();
                    while(resultString.next())
                    {
                        s = new Student();
                        s.setID(resultString.getInt("st_id"));
                        s.setFirstname((resultString.getString("st_firstname")));
                        s.setLastname((resultString.getString("st_lastname")));
                        studentList.add(s);
                    }         
                    
            }
            catch (SQLException e) {
			 System.out.println(e.getMessage());
            }
                 return studentList;
        }
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
        public boolean getSubjectInfo(Employee emp, String[] SubjectList)
        {
            int x = 0;
            try
            {
                    String queryString = "SELECT sectionYear, subjectName, sectionName FROM CLASSADVISER CA, SECTION S, SUBJECT SU, CLASSTEACHER CT where ct_classYear = ? AND ct_idEmployee = ?AND ct.ct_subjectID = subjectID AND ct_classID = classID ORDER BY sectionYear;";
                    connection = getConnection();
                    stmt = connection.prepareStatement(queryString);
                    stmt.setInt(1, 2013);
                    stmt.setString(2, emp.getIdNum());
                ResultSet resultString = stmt.executeQuery();
                    while(resultString.next())
                    {
                        
                        SubjectList[x] = (""+resultString.getString("sectionYear")+" - "+(resultString.getString("sectionName"))+" - "+ (resultString.getString("subjectName")));
                        System.out.println(SubjectList[x]);
                        x++;}                
                    return true;
            }
            catch (SQLException e) {
			 System.out.println(e.getMessage());
                         return false;
            }
        }
        /*
        public boolean getAdviserSect(Employee emp, Section s)
        { 
            int x = 0;
            try
            {
                    String queryString = "select sect_yrlvl, class_name FROM SECTION, CLASSADVISER WHERE class_prof = ? AND class_name = sect_name AND class_schlyear = YEAR(CURRENT_TIME)";
                    connection = getConnection();
                    stmt = connection.prepareStatement(queryString);
                    stmt.setInt(1, emp.getID());
                    stmt.executeQuery();
                    ResultSet resultString = stmt.executeQuery();
                    resultString.next();
                    s.setSectyear(resultString.getInt("sect_yrlvl"));
                    s.setSectname(resultString.getString("class_name"));
                return !s.getSectname().isEmpty();
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
        */
}
