/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseCodes;
import ProgramCodes.Admin;
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
public class StudentDAO {
    Connection connection = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	private Connection getConnection() throws SQLException {
            Connection conn;
            conn = ConnectionFactory.getInstance().getConnection();
            return conn;
	}
        
        public boolean addStudent(Student s){
            try{
                String queryString = "INSERT INTO STUDENT(idStudent, firstNameSt, middleNameSt, lastNameSt, genderST, birthDateSt, yearLevelSt) VALUES (?,?,?,?,?,?, ?)";
                connection = getConnection();
                stmt = connection.prepareStatement(queryString);
		stmt.setString(1, s.getIdNum());
		stmt.setString(2, s.getFirstName());
		stmt.setString(3, s.getMidName());
		stmt.setString(4, s.getLastName());
		stmt.setString(5, s.getGender());
		stmt.setString(6, s.getDOB());
                stmt.setInt(7, 1);
		stmt.executeUpdate();
            }catch(SQLException e){
                System.out.println(e.getMessage() + e.getErrorCode());
                return false;
            }
            return true;
        }
        
        public boolean editStudentInfo(String st){
            int x = 0;
            try{
                Statement s = null;
                //ResultSet rs = s.executeQuery("SELECT * FROM STUDENT WHERE idStudent = "+ st + "");
                
                String queryString = "UPDATE STUDENT SET idStudent =?, firstNameSt = ?, middleNameSt = ?, lastNameSt = ?, genderSt = ?, birthDateSt =? WHERE idEmployee = "+st+"";
		connection = getConnection();
		stmt = connection.prepareStatement(queryString);
                /*stmt.setString(1, s.getIdNum());
                stmt.setString(2, s.getFirstName());
                stmt.setString(3, s.getMidName());
            	stmt.setString(4, s.getLastName());
		stmt.setString(5, s.getGender());
		stmt.setString(5, s.getDOB());*/
		x = stmt.executeUpdate();
                System.out.println(x);
            }catch(SQLException e){
                System.out.println("lol");
                return false;
            }
            return true;
        }
        
        public Student getStudent(String i){
            Statement x = null;
            ResultSet b = null;    
            Student a = new Student();
            try{
                connection = getConnection();
                System.out.println("1");
                x = connection.createStatement();
                System.out.println("11");
                b = x.executeQuery("SELECT * FROM STUDENT WHERE idStudent = '"+ i +"' ");
                if(b.wasNull()){
                    System.out.println("x");
                }
                else{
                System.out.println("111");
                System.out.println(b.getString(1));
                a.setIdNum( b.getString(1) );
                System.out.println("1111");
                a.setLastName(  b.getString(4));
                System.out.println("11111");
                a.setFirstName(  b.getString(2));
                System.out.println("111111");
                a.setMidName(  b.getString(3));
                System.out.println("1111111");
                a.setGender(  b.getString(5));
                System.out.println("11111111");
                a.setDOB(  b.getString(6));
                System.out.println("11111111");
                a.setGradeLvl(  b.getInt(7));
                System.out.println("111111111");
                }
            }catch(SQLException g){
                System.out.println("lol");
            }
            return a;
        }
        
        
}
