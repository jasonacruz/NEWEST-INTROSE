package ProgramCodes;

import databaseCodes.EmployeeDAO;

public class Admin extends Employee {

        EmployeeDAO ed;
    public Admin(String idNum, String lastName, String firstName, String midName, String contactNum, String homeAddress, String empPw, String empPosition, Boolean passField) {
        super(idNum, lastName, firstName, midName, contactNum, homeAddress, empPw, empPosition, passField);
        ed = new EmployeeDAO();
    }

    public Admin() {

    }

	public boolean addFaculty(Employee emp) {
   
            return ed.addEmployee(emp);
	}

	public boolean addFacultyList() {
		// TODO - implement Admin.addFacultyList
		throw new UnsupportedOperationException();
	}

	public boolean addSection() {
		// TODO - implement Admin.addSection
		throw new UnsupportedOperationException();
	}

	public boolean addStudents() {
		// TODO - implement Admin.addStudents
		throw new UnsupportedOperationException();
	}
}