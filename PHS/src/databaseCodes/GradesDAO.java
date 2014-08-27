/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package databaseCodes;

import ProgramCodes.Classroom;
import ProgramCodes.Settings;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author home
 */
public class GradesDAO {
        Connection connection = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
        Settings s;
	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	public GradesDAO(Settings s)
        {
            this.s = s;
        }
    public boolean addGradeComp(Classroom c, String examType, int knowledge, int understanding, int process, int product)
	{
                int subjectID = getSubjectID(c.getSubjectName(), c.getSectYearlvl());
                int sectionID = new ClassroomDAO().getSectionID(c.getSectName(), c.getSectYearlvl(), c.getSchoolYear());
                System.out.println(subjectID + " " + sectionID);
                String queryString;
                        try {
                                if(examType.equals("Quiz") || examType.equals("Seatwork"))
                                {queryString = "INSERT INTO GRADECOMPOSITION(gc_classID,gc_subjectID,gc_gradeQuarter,gc_gradeComp,gc_gradeCompNumber,KnowledgeValue,UnderstandingValue,SkillValue,ProductValue) VALUES(?,?,?,?,(SELECT (COUNT(*)+1) FROM (SELECT * FROM GRADECOMPOSITION) as gc WHERE gc_classID = ? AND gc_subjectID = ? AND gc_gradeQuarter = ? AND gc_gradeComp = ?), ?,?,?,?);";
                                    connection = getConnection();
                                    stmt = connection.prepareStatement(queryString);
                                    stmt.setInt(1, sectionID);
                                    stmt.setInt(2, subjectID);
                                    stmt.setInt(3, s.getQuarter());
                                    stmt.setString(4, examType);
                                    stmt.setInt(5, sectionID);
                                    stmt.setInt(6, subjectID);
                                    stmt.setInt(7, s.getQuarter());
                                    stmt.setString(8, examType);
                                    stmt.setInt(9, knowledge);
                                    stmt.setInt(10, understanding);
                                    stmt.setInt(11, process);
                                    stmt.setInt(12, product);
                                    stmt.executeUpdate();  
                                }
                                else
                                {   queryString = "INSERT INTO GRADECOMPOSITION(gc_classID,gc_subjectID,gc_gradeQuarter,gc_gradeComp,gc_gradeCompNumber,KnowledgeValue,UnderstandingValue,SkillValue,ProductValue) VALUES(?,?,?, ?, ?,?,?,?,?)";
                                    connection = getConnection();
                                    stmt = connection.prepareStatement(queryString);
                                    stmt.setInt(1, sectionID);
                                    stmt.setInt(2, subjectID);
                                    stmt.setInt(3, s.getQuarter());
                                    stmt.setString(4, examType);
                                    stmt.setInt(5, 0);
                                    stmt.setInt(6, knowledge);
                                    stmt.setInt(7, understanding);
                                    stmt.setInt(8, process);
                                    stmt.setInt(9, product);
                                    stmt.executeUpdate();  
                                }
			}catch (SQLException e) {
                            System.out.println(e.getMessage());
			return false;
	}
	return true;
	}
    
    public int getSubjectID(String subjectName, int yearLevel)
    {
        try{
                     String queryString = "SELECT subjectID FROM SUBJECT WHERE subjectName = ? AND subjectGradeLevel = ?";
                    connection = getConnection();
                    stmt = connection.prepareStatement(queryString); 
                    stmt.setString(1, subjectName);
                    stmt.setInt(2, yearLevel);
                   ResultSet resultString = stmt.executeQuery();
                    resultString.next();
                    return resultString.getInt(1);
    }  
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            return 0;
        }
}
}
