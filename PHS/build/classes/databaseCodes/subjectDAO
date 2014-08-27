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
        
        
}
