package ProgramCodes;

import databaseCodes.EmployeeDAO;

public abstract class Employee extends Person {

	private String empPW;
        private String empPosition;
        private String empDepartment;
        private Boolean passFlag;
        EmployeeDAO ed = new EmployeeDAO();
        public String getPosition()
        {
            return empPosition;
        }
        public String getDepartment(){
            return empDepartment;
            
        }
        
        public void setDepartment(String department)
        {
            empDepartment = department;
        }
        public Employee Login(String empID, String empPW)
        {
            System.out.println("SUCCESSSS!");
            return ed.getLoginReq(empID, empPW);
        }
        public Boolean getpassFlag()
        {
            return passFlag;
        }
        
	public String getEmpPW() {
		return this.empPW;
	}
       
	/**
	 * 
	 * @param empPW
	 */
	public void setEmpPW(String empPW) {
		this.empPW = empPW;
	}
        
        public void setpassField(Boolean passFlag) {
		this.passFlag = passFlag;
	}
        
         public void setPosition(String empPosition)
        {
            this.empPosition = empPosition;
        }
        
         public Employee()
        {}
	/**
	 * 
	 * @param idNum
	 * @param lastName
	 * @param firstName
	 * @param midName
	 * @param contactNum
	 * @param homeAddress
	 * @param empPw
         * @param empPosition
         * @param passFlag */
       
	public Employee(String idNum, String lastName, String firstName, String midName, String contactNum, String homeAddress, String empPw, String empPosition, Boolean passFlag) {
		// TODO - implement Employee.Employee
                super(idNum, lastName, firstName, midName, contactNum, homeAddress);
                this.empPW = empPw;
                this.empPosition = empPosition;
                this.passFlag = passFlag;
		throw new UnsupportedOperationException();
                
	}

}