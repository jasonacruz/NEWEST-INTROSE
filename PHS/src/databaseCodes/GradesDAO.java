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
        //
    //INSERT INTO STUDENTGRADE(sg_classID, sg_subjectID, sg_idStudent, sg_gradeQuarter, sg_gradeComp, sg_gradeCompNumber, KnowledgeValue, UnderstandingValue,SkillValue, ProductValue, gradeFinal, gradeApproved) VALUES(?,?,?,?,?,?,?,?,?,?,0,0);
        
        public boolean checkStudentGradetoComp(int subjectID, int sectionID, String examType, int numComp, int knowledge, int understanding, int process, int product)
        {
            String queryString;
                    try{
                           queryString = "SELECT KnowledgeValue, UnderstandingValue, SkillValue, ProductValue FROM GRADECOMPOSITION WHERE gc_classID = ? AND gc_subjectID = ? AND gc_gradeQuarter = ? AND gc_gradeComp = ? AND gc_gradeCompNumber = ?";
                           connection = getConnection();
                           stmt = connection.prepareStatement(queryString);
                           stmt.setInt(1, sectionID);
                           stmt.setInt(2, subjectID);
                           stmt.setInt(3, s.getQuarter());
                           stmt.setString(4, examType);
                           stmt.setInt(5, numComp);
                           ResultSet resultString = stmt.executeQuery();
                           resultString.next();
                           System.out.println(resultString.getInt(1));
                           System.out.println(resultString.getInt(2));
                           System.out.println(resultString.getInt(3));
                           System.out.println(resultString.getInt(4));
                           if(resultString.getInt(1) >= knowledge && resultString.getInt(2) >= understanding && resultString.getInt(3) >= process && resultString.getInt(4) >= product)
                               return true;
                           else
                               return false;
                    }
                    catch(SQLException e)
                    {
                        System.out.println(e.getMessage());
                        System.out.println("THIS");
                        return false;
                    }
        }
        public boolean addStudentProject(Classroom c,  int grade, String idStudent)
                {
                int subjectID = getSubjectID(c.getSubjectName(), c.getSectYearlvl());
                int sectionID = new ClassroomDAO().getSectionID(c.getSectName(), c.getSectYearlvl(), c.getSchoolYear());
                int numComp = getNumComponents(c, "Project") - 1;
                Boolean check = checkStudentGradetoComp(subjectID, sectionID, "Project", numComp,0, 0,0, grade);
                if(check)
              {
                
                String queryString;
                        try {
                                queryString = "INSERT INTO STUDENTGRADE(sg_classID, sg_subjectID, sg_idStudent, sg_gradeQuarter, sg_gradeComp, sg_gradeCompNumber, KnowledgeValue, UnderstandingValue,SkillValue, ProductValue, gradeFinal, gradeApproved) VALUES(?,?,?,?,?,?,?,?,?,?,0,0)";
                                connection = getConnection();
                                stmt = connection.prepareStatement(queryString);
                                stmt.setInt(1, sectionID);
                                stmt.setInt(2, subjectID);
                                stmt.setString(3, idStudent);
                                stmt.setInt(4, s.getQuarter());
                                stmt.setString(5, "Project");
                                stmt.setInt(6, numComp);
                                stmt.setInt(7, 0);
                                stmt.setInt(8, 0);
                                stmt.setInt(9, 0);
                                stmt.setInt(10, grade);
                                stmt.executeUpdate();
                                return true;
                                }
    
                                                        catch(SQLException e)
                                        {}}
                return false;
                                
                        }
        public boolean addStudentGrade(Classroom c, String examType, int knowledge, int understanding, int process, int product, String idStudent)
        {
                int subjectID = getSubjectID(c.getSubjectName(), c.getSectYearlvl());
                int sectionID = new ClassroomDAO().getSectionID(c.getSectName(), c.getSectYearlvl(), c.getSchoolYear());
                int numComp = getNumComponents(c, examType) - 1;
                String queryString;
                Boolean check = checkStudentGradetoComp(subjectID, sectionID, examType, numComp, knowledge, understanding, process, product);
                                if(check)
                                {
                        try {
                                queryString = "INSERT INTO STUDENTGRADE(sg_classID, sg_subjectID, sg_idStudent, sg_gradeQuarter, sg_gradeComp, sg_gradeCompNumber, KnowledgeValue, UnderstandingValue,SkillValue, ProductValue, gradeFinal, gradeApproved) VALUES(?,?,?,?,?,?,?,?,?,?,0,0)";
                                connection = getConnection();
                                stmt = connection.prepareStatement(queryString);
                                stmt.setInt(1, sectionID);
                                stmt.setInt(2, subjectID);
                                stmt.setString(3, idStudent);
                                stmt.setInt(4, s.getQuarter());
                                stmt.setString(5, examType);
                                stmt.setInt(6, numComp);
                                stmt.setInt(7, knowledge);
                                stmt.setInt(8, understanding);
                                stmt.setInt(9, process);
                                stmt.setInt(10, product);
                                stmt.executeUpdate();
                                return true;
                                
                        }
                                catch(SQLException e)
                                        {System.out.println(e.getMessage());
                                        return false;}
                     }
                                return false;
                        }
                
        
        public boolean addGradeComp(Classroom c, String examType, int knowledge, int understanding, int process, int product)
	{
                int subjectID = getSubjectID(c.getSubjectName(), c.getSectYearlvl());
                int sectionID = new ClassroomDAO().getSectionID(c.getSectName(), c.getSectYearlvl(), c.getSchoolYear());
                int numComp = getNumComponents(c, examType);
                System.out.println(numComp);
                String queryString;
                        try {
                                if(examType.equals("Quiz") || examType.equals("Seatwork") || examType.equals("Homework"))
                                {queryString = "INSERT INTO GRADECOMPOSITION(gc_classID,gc_subjectID,gc_gradeQuarter,gc_gradeComp,gc_gradeCompNumber,KnowledgeValue,UnderstandingValue,SkillValue,ProductValue) VALUES(?,?,?,?, ?, ?,?,?,?)";
                                    connection = getConnection();
                                    stmt = connection.prepareStatement(queryString);
                                    stmt.setInt(1, sectionID);
                                    stmt.setInt(2, subjectID);
                                    stmt.setInt(3, s.getQuarter());
                                    stmt.setString(4, examType);
                                    stmt.setInt(5, numComp);
                                    stmt.setInt(6, knowledge);
                                    stmt.setInt(7, understanding);
                                    stmt.setInt(8, process);
                                    stmt.setInt(9, product);
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
    //SELECT AVG(sg.KnowledgeValue/gc.KnowledgeValue) FROM STUDENTGRADE sg, gradecomposition gc WHERE sg_classID = gc_classID AND gc_subjectID = sg_subjectID AND gc_gradeQuarter = sg_gradeQuarter AND gc_gradeComp = sg_gradeComp AND sg_gradeCompNumber = gc_gradeCompNumber AND gc_gradeComp = 'Quiz' AND sg_idStudent = 123456;
//getGradeComp(c, 'Quiz', c.getStudentList.get(i).getidNumber(), 1);
    public int getGradeComp(Classroom c, String examType, String idNumber, int gradeType)
    {    
        int subjectID = getSubjectID(c.getSubjectName(), c.getSectYearlvl());
        int sectionID = new ClassroomDAO().getSectionID(c.getSectName(), c.getSectYearlvl(), c.getSchoolYear());
         String queryString;
        try
            {
                    if(gradeType == 1)
                         queryString = "SELECT AVG(sg.KnowledgeValue/gc.KnowledgeValue) FROM STUDENTGRADE sg, gradecomposition gc WHERE sg_classID = gc_classID AND gc_subjectID = sg_subjectID AND gc_gradeQuarter = sg_gradeQuarter AND gc_gradeComp = sg_gradeComp AND sg_gradeCompNumber = gc_gradeCompNumber AND gc_classID = ? AND gc_subjectID = ? AND gc_gradequarter = ?  AND gc_gradeComp = ? AND sg_idStudent = ?  ";
                    else if(gradeType == 2)
                         queryString = "SELECT AVG(sg.UnderstandingValue/gc.UnderstandingValue) FROM STUDENTGRADE sg, gradecomposition gc WHERE sg_classID = gc_classID AND gc_subjectID = sg_subjectID AND gc_gradeQuarter = sg_gradeQuarter AND gc_gradeComp = sg_gradeComp AND sg_gradeCompNumber = gc_gradeCompNumber AND gc_classID = ? AND gc_subjectID = ? AND gc_gradequarter = ?  AND gc_gradeComp = ? AND sg_idStudent = ?  ";
                     else if(gradeType == 3)
                         queryString = "SELECT AVG(sg.SkillValue/gc.SkillValue) FROM STUDENTGRADE sg, gradecomposition gc WHERE sg_classID = gc_classID AND gc_subjectID = sg_subjectID AND gc_gradeQuarter = sg_gradeQuarter AND gc_gradeComp = sg_gradeComp AND sg_gradeCompNumber = gc_gradeCompNumber AND gc_classID = ? AND gc_subjectID = ? AND gc_gradequarter = ?  AND gc_gradeComp = ? AND sg_idStudent = ?  ";
                     else
                         queryString = "SELECT AVG(sg.ProductValue/gc.ProductValue) FROM STUDENTGRADE sg, gradecomposition gc WHERE sg_classID = gc_classID AND gc_subjectID = sg_subjectID AND gc_gradeQuarter = sg_gradeQuarter AND gc_gradeComp = sg_gradeComp AND sg_gradeCompNumber = gc_gradeCompNumber AND gc_classID = ? AND gc_subjectID = ? AND gc_gradequarter = ?  AND gc_gradeComp = ? AND sg_idStudent = ?  ";
                    
                    connection = getConnection();
                    stmt = connection.prepareStatement(queryString);
                     stmt.setInt(1, sectionID);
                     stmt.setInt(2, subjectID);
                     stmt.setInt(3, s.getQuarter());
                     stmt.setString(4, examType);
                     stmt.setString(5, idNumber);
                     ResultSet resultString = stmt.executeQuery();
                     resultString.next();
                    return resultString.getInt(1);
            }
            catch (SQLException e) {
			 System.out.println(e.getMessage());
                         return -1;
            }
    }
    public int getNumComponents(Classroom c, String examType)
    {
                int subjectID = getSubjectID(c.getSubjectName(), c.getSectYearlvl());
                int sectionID = new ClassroomDAO().getSectionID(c.getSectName(), c.getSectYearlvl(), c.getSchoolYear());
        
                 try
            {
                    String queryString = "SELECT (COUNT(*)+1) FROM (SELECT * FROM GRADECOMPOSITION) as gc WHERE gc_classID = ? AND gc_subjectID = ? AND gc_gradeQuarter = ? AND gc_gradeComp = ?";
                    connection = getConnection();
                    stmt = connection.prepareStatement(queryString);
                     stmt.setInt(1, sectionID);
                     stmt.setInt(2, subjectID);
                     stmt.setInt(3, s.getQuarter());
                     stmt.setString(4, examType);
                     ResultSet resultString = stmt.executeQuery();
                     resultString.next();
                    return resultString.getInt(1);
            }
            catch (SQLException e) {
			 System.out.println(e.getMessage());
                         return -1;
            }
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
