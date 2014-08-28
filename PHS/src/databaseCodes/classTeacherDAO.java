package databaseCodes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Chris
 */
public class classTeacherDAO {
     Connection connection = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
        }
        
     public ArrayList<String> getSubjectListID(String section){
         ArrayList<String> list = new ArrayList();
         try
            {
                    String queryString = "select * from classteacher where ct_classID = ?";
                    connection = getConnection();
                    stmt = connection.prepareStatement(queryString);
                    stmt.setString(1, section);
                    rs =stmt.executeQuery();
                    
            while (rs.next()) {
                 classTeacherBean ab = new classTeacherBean(rs.getInt("ct_SubjectID"),rs.getString("ct_SubjectID"),rs.getInt("ct_classID"));
                 list.add(Integer.toString(ab.getCt_classID()));
                }
            if(list.isEmpty() == false)
              return list;
            else
              {
              list.add("Empty");
              return list;
              }
            
            }
            catch (SQLException e) {
			 System.out.println("ERROR CODE: "+ e.getErrorCode());
                         list.add("Unavailable");
                         return list;
            }
     }
}
