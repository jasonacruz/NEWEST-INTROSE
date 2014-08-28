/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseCodes;

import ProgramCodes.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
/**
 *
 * @author Jan
 */
public class subjectDAO {
     Connection connection = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	private Connection getConnection() throws SQLException {
            Connection conn;
            conn = ConnectionFactory.getInstance().getConnection();
            return conn;
	}
        
        public ArrayList<String> getSubject(int x){
            ArrayList<String> a = new ArrayList();
            Statement s = null;
            try{
                connection = getConnection();
                s = connection.createStatement();
                rs = s.executeQuery("SELECT * FROM SUBJECT WHERE subjectGradeLevel = "+x+"");
                while(rs.next()){
                    a.add(rs.getString("subjectName"));
                }
            }catch(SQLException e){
                System.out.println(e.getMessage() + e.getErrorCode());   
            }
            return a;
        }
        
        public int getSubjID(String x, int z){
            Statement s = null;
            int y = 0;
            try{
                connection = getConnection();
                s = connection.createStatement();
                rs = s.executeQuery("SELECT * FROM SUBJECT WHERE subjectName = '"+x+"' AND subjectGradeLevel = "+z+"");
                while(rs.next()){
                    y = rs.getInt("subjectID");
                }
            }catch(SQLException e){
                System.out.println(e.getMessage() + e.getErrorCode());   
            }
            return y;
        }
        
 public ArrayList<String> getSubjectNames(String section,String grade){
            ArrayList<String> list = new ArrayList();
       try
            {
                    String queryString = "select * from subject where \n" +
                                        "subjectID = some (select ct_subjectID from classteacher where ct_classID = \n" +
                                        "(select sectionID from section where sectionName like ? )\n" +
                                        ")\n" +
                                        "and subjectGradeLevel = ?";
 
                    connection = getConnection();
                    stmt = connection.prepareStatement(queryString);
                    stmt.setString(1, section);
                    stmt.setString(2, grade);
                    rs =stmt.executeQuery();
                    
            while (rs.next()) {
                 
                 subjectBean ab = new subjectBean(rs.getInt("subjectID"),rs.getString("subjectName"), rs.getInt("subjectGradeLevel"));
                 list.add(ab.getSubjectName());
                }
            if(list.isEmpty() == false)
              return list;
            else
              {
              list.add("Unavailable");
              return list;
              }
            
            }
            catch (SQLException e) {
			 System.out.println("ERROR CODE: "+ e.getErrorCode());
                         list.add("Empty");
                         return list;
            }
    }
}
