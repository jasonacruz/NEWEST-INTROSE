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
public class SectionDAO {
     Connection connection = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	private Connection getConnection() throws SQLException {
            Connection conn;
            conn = ConnectionFactory.getInstance().getConnection();
            return conn;
	}
        
        public boolean addSection(String s1, String s2){
            try{
                String queryString = "INSERT INTO SECTION(sectionName, sectionYearLevel, sectionSchoolYear) VALUES (?,?,?)";
                connection = getConnection();
                stmt = connection.prepareStatement(queryString);
		stmt.setString(1, s2);
		stmt.setString(2, s1);
                stmt.setString(3, s1);
		stmt.executeUpdate();
            }catch(SQLException e){
                System.out.println(e.getMessage() + e.getErrorCode());
                return false;
            }
            return true;
        }
        
        public ArrayList<String> getSections(String x){
            Statement st = null;
            ArrayList<String> sNames = new ArrayList();
            try{
                connection = getConnection();
                st = connection.createStatement();
                
                rs = st.executeQuery("SELECT * FROM SECTION WHERE sectionYearLevel ="+ x +"");
                while(rs.next()){
                    sNames.add(rs.getString("sectionName"));
                }
            }catch(SQLException e){
                System.out.println(e.getMessage() + e.getErrorCode());
            }
            return sNames;
        }
         public int getSectionID(String x, String y){
            Statement st = null;
            int id = 0;
            try{
                connection = getConnection();
                st = connection.createStatement();
                rs = st.executeQuery("SELECT sectionID FROM SECTION WHERE sectionName = '"+x+"' AND sectionYearLevel = '"+y+"'");
                System.out.println(x);
                while(rs.next())
                    id = rs.getInt("sectionID");
                System.out.println("ad");
            }catch(SQLException e){
                System.out.println(e.getMessage() + e.getErrorCode());
            }
            return id;
        }
         public ArrayList<String> getStudentInSection(String x){
            ArrayList<String> st = new ArrayList();
            Statement s = null;
            try{
                connection = getConnection();
                s = connection.createStatement();
                rs = s.executeQuery("SELECT * FROM SECTION WHERE sectionName = '"+x+"'");
                int a = rs.getInt("sectionID");
                rs = s.executeQuery("SELECT * FROM STUDENTROSTER s, STUDENT a where sr_classID = "+a+" and sr_studentID = idStudent");
                st.add(rs.getString("lastNameSt").concat(", ").concat("firstNameSt"));
            }catch(SQLException e){
                System.out.println(e.getMessage() + e.getErrorCode());
            }
            return st;
        }
}
