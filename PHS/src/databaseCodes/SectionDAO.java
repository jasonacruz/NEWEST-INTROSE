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
        
        public ResultSet getSections(String x){
            Statement st = null;
            try{
                connection = getConnection();
                st = connection.createStatement();
                rs = st.executeQuery("SELECT * FROM SECTION WHERE sectionYearLevel ="+ x +"");
            }catch(SQLException e){
                System.out.println("x");
            }
            return rs;
        }
}
