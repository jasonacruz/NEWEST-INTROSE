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
        
            public ArrayList<String> getYearList(){
        ArrayList<String> list = new ArrayList();
       try
            {
                    String queryString = "select * from section group by sectionyear order by 2";
                    connection = getConnection();
                    stmt = connection.prepareStatement(queryString);
                    rs =stmt.executeQuery();
                    
            while (rs.next()) {
                 SectionBean ab = new SectionBean(rs.getString("sectionName"), rs.getInt("sectionYear"));
                 list.add(Integer.toString(ab.getYear()));
                }
            if(list != null)
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
    
    public ArrayList<String> getSectionList(String level){
        ArrayList<String> list = new ArrayList();
       try
            {
                    String queryString = "select * from section where sectionYear = ?";
                    connection = getConnection();
                    stmt = connection.prepareStatement(queryString);
                    stmt.setString(1, level);
                    rs =stmt.executeQuery();
                    
            while (rs.next()) {
                 SectionBean ab = new SectionBean(rs.getString("sectionName"), rs.getInt("sectionYear"));
                 list.add(ab.getName());
                }
            if(list != null)
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
