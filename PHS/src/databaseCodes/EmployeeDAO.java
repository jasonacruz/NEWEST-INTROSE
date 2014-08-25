package databaseCodes;

import ProgramCodes.Admin;
import ProgramCodes.Coordinator;
import ProgramCodes.Employee;
import ProgramCodes.Faculty;
import ProgramCodes.Principal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDAO{
	Connection connection = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	public boolean addEmployee(Employee emp)
	{
            try{
                String queryString = "INSERT INTO EMPLOYEE(idEmployee, firstNameEmp, middleNameEmp, lastNameEmp, positionEmp, contactNumberEmp,  passwordEmp, passFlagEmp , departmentEmp, genderEmp) VALUES (?,?,?,?,? , ?,idEmployee, false,?,?)";
                connection = getConnection();
                stmt = connection.prepareStatement(queryString);
                stmt.setString(1, emp.getIdNum());
                stmt.setString(2, emp.getFirstName());
                stmt.setString(3, emp.getMidName());
                stmt.setString(4, emp.getLastName());
                stmt.setString(5, emp.getPosition());
                stmt.setString(6, emp.getContactNum());
                stmt.setString(7, emp.getDepartment());
                stmt.setString(8, emp.getGender());
                stmt.executeUpdate();
            }catch (SQLException e) {
                System.out.println(e.getMessage() + e.getErrorCode());
                return false;
            }
            return true;
	}
        
	public boolean editEmployeeInfo(Employee emp)
	{
            int x =0;
            try{
		String queryString = "UPDATE EMPLOYEE SET idEmployee =?, firstNameEmp = ?, middleNameEmp = ?, lastNameEmp = ?, position = ? WHERE idEmployee = "+emp.getIdNum()+"";
		connection = getConnection();
		stmt = connection.prepareStatement(queryString);
                stmt.setString(1, emp.getIdNum());
                stmt.setString(2, emp.getFirstName());
                stmt.setString(3, emp.getMidName());
            	stmt.setString(4, emp.getLastName());
		stmt.setString(5, emp.getPosition());
		x = stmt.executeUpdate();
                System.out.println(x);
            }catch (SQLException e) {
                System.out.println(e.getMessage());
                return false;
            }
            return true;
	}
        
        public boolean regEmployee(Employee emp)
	{
            int x =0;
	try
		{
			String queryString = "UPDATE EMPLOYEE SET passwordEmp = ?, passFlagEmp = ? WHERE idEmployee = ? AND firstNameEmp = ? AND middleNameEmp = ? AND lastNameEmp = ? AND positionEmp = ? AND passFlagEmp = false";
			connection = getConnection();
			stmt = connection.prepareStatement(queryString);
                        
                        stmt.setString(1, emp.getEmpPW());
                        stmt.setBoolean(3, true);
                        stmt.setString(4, emp.getIdNum());
			stmt.setString(5, emp.getFirstName());
			stmt.setString(6, emp.getMidName());
			stmt.setString(7, emp.getLastName());
                        stmt.setString(8, emp.getPosition());
			x = stmt.executeUpdate();
                        System.out.println(x);
			}catch (SQLException e) {
			 System.out.println(e.getMessage());
                         x = 0;
                        }
            return x != 0;
	}
        /*
        public boolean getEmpInfo(Employee emp)
        { 
            try
            {
                    String queryString = "SELECT * FROM EMPLOYEE WHERE lastNameEmp = ? AND firstNameEmp = ?";
                    connection = getConnection();
                    stmt = connection.prepareStatement(queryString);
                    stmt.setString(1, emp.getLastname());
                    stmt.setString(2, emp.getFirstname());
                    
                    ResultSet resultString = stmt.executeQuery();
                    resultString.next();
                    emp.setFirstname(resultString.getString("firstNameEmp"));
                    emp.setMidname(resultString.getString("middleNameEmp"));
                    emp.setLastname(resultString.getString("lastNameEmp"));
                    emp.setID(resultString.getInt("idEmployee"));
                    emp.setChangedpass(resultString.getBoolean("passFlagEmp"));
            }
            catch (SQLException e) {
			 System.out.println(e.getMessage());
                         return false;
            }
                         return true;
        }
              
        */
        
         public void updatePassword(Employee emp, String newPass)
        {
            String x = "null";
            try
            {
                    String queryString = "UPDATE EMPLOYEE SET passwordEmp = ?, passFlagEmp = ? WHERE idEmployee= ? AND passFlagEmp= false";
                    connection = getConnection();
                    stmt = connection.prepareStatement(queryString);
                    stmt.setString(1, newPass);
                    stmt.setBoolean(2, true);
                    stmt.setString(3, emp.getIdNum());
                    stmt.executeUpdate();
            }
            catch(SQLException e)
            {
                System.out.println(e.getMessage());
            }
        
        }
        public Employee getLoginReq(String idNum, String empPW) 
        {
            String x = "null";
            Employee emp;
            try
            {
                    String queryString = "SELECT * FROM EMPLOYEE WHERE idEmployee = ? AND BINARY passwordEmp = ?";
                    connection = getConnection();
                    stmt = connection.prepareStatement(queryString);
                    stmt.setString(1,idNum);
                    stmt.setString(2,empPW);
                    
                    ResultSet resultString = stmt.executeQuery();
                    resultString.next();                    
                    x = resultString.getString("positionEmp");
                    if(!x.equals("")){
                    if(x.equals("Principal"))
                       emp = new Principal();
                    else if(x.equals("Coordinator"))
                       emp = new Coordinator();
                    else if(x.equals("Administrator"))
                       emp = new Admin();
                    else
                        emp = new Faculty();
                    emp.setFirstName(resultString.getString("firstNameEmp"));
                    emp.setMidName(resultString.getString("middleNameEmp"));
                    emp.setLastName(resultString.getString("lastNameEmp"));
                    emp.setIdNum(resultString.getString("idEmployee"));
                    emp.setEmpPW(resultString.getString("passwordEmp"));
                    emp.setPosition(x);
                    emp.setContactNum(resultString.getString("contactNumberEmp"));
                    emp.setpassField(resultString.getBoolean("passFlagEmp"));
                    emp.setHomeAddress(resultString.getString("addressEmp"));
                    System.out.println("Yohoo");
                    System.out.println(x);
                    return emp;
                    }
                    return null;
            }
            catch (SQLException e) {
			 System.out.println(e.getErrorCode());
                         return null;
            }
        }
			
}
