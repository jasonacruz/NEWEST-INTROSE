/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package databaseCodes;

import ProgramCodes.Settings;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author home
 */
public class SettingsDAO {
    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

     Connection connection = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	private Connection getConnection() throws SQLException {
            Connection conn;
            conn = ConnectionFactory.getInstance().getConnection();
            return conn;
	}
        
     public boolean Update(int settingValue, String settingName)
     {
          int x =0;
	try
		{
			String queryString = "UPDATE SETTINGS SET SettingVal = ? WHERE SettingName = ?;";
			connection = getConnection();
			stmt = connection.prepareStatement(queryString);
                        
                        stmt.setInt(1, settingValue);
                        stmt.setString(2,settingName);
			x = stmt.executeUpdate();
                        System.out.println(x);
			}catch (SQLException e) {
			 System.out.println(e.getMessage());
                         x = 0;
                        }
            return x != 0;
}
        
     public void getSettings(Settings s)
     {
         try{
                    String queryString = "SELECT * FROM Settings";
                    connection = getConnection();
                    stmt = connection.prepareStatement(queryString);
                    
                    ResultSet resultString = stmt.executeQuery();
                    while(resultString.next())
                    {
                        if(resultString.getString("SettingName").equals("Knowledge"))
                            s.setKnowledge(resultString.getInt("SettingVal"));
                        else if(resultString.getString("SettingName").equals("Understanding"))
                            s.setUnderstanding(resultString.getInt("SettingVal"));
                        else if(resultString.getString("SettingName").equals("Process"))
                            s.setProcess(resultString.getInt("SettingVal"));
                        else if(resultString.getString("SettingName").equals("Product"))
                            s.setProduct(resultString.getInt("SettingVal"));
                        else if(resultString.getString("SettingName").equals("Schoolyear"))
                            s.setSchoolYear(resultString.getInt("SettingVal"));
                        else if(resultString.getString("SettingName").equals("Quarter"))
                            s.setQuarter(resultString.getInt("SettingVal"));
                    }
         }
         catch(SQLException e)
         {
             System.out.println(e.getMessage());
         }
     }
}
