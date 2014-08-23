package ProgramCodes;

public class Principal extends Employee implements HeadEmployee, GradesViewing {

    public Principal(String idNum, String lastName, String firstName, String midName, String contactNum, String homeAddress, String empPw, String empPosition, Boolean passField) {
        super(idNum, lastName, firstName, midName, contactNum, homeAddress, empPw, empPosition, passField);
    }

    public Principal() {
    }

	public boolean viewGrades() {
		// TODO - implement Principal.viewGrades
		throw new UnsupportedOperationException();
	}

	public boolean approveGrade() {
		// TODO - implement Principal.approveGrade
		throw new UnsupportedOperationException();
	}
}