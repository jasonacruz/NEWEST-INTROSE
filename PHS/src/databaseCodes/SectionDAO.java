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
                String queryString = "INSERT INTO SECTION(sectionName, sectionYear) VALUES (?,?)";
                connection = getConnection();
                stmt = connection.prepareStatement(queryString);
		stmt.setString(1, s2);
		stmt.setString(2, s1);
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
                
                rs = st.executeQuery("SELECT * FROM SECTION WHERE sectionYear ="+ x +"");
                while(rs.next()){
                    sNames.add(rs.getString("sectionName"));
                }
            }catch(SQLException e){
                System.out.println(e.getMessage() + e.getErrorCode());
            }
            return sNames;
        }
}
