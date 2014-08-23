package ProgramCodes;

public class Faculty extends Employee implements GradesViewing {

    public Faculty(String idNum, String lastName, String firstName, String midName, String contactNum, String homeAddress, String empPw, String empPosition, Boolean passField) {
        super(idNum, lastName, firstName, midName, contactNum, homeAddress, empPw, empPosition, passField);
    }

    public Faculty() {
    }

	public boolean addGrade() {
		// TODO - implement Faculty.addGrade
		throw new UnsupportedOperationException();
	}

	public boolean viewGrades() {
		// TODO - implement Faculty.viewGrades
		throw new UnsupportedOperationException();
	}

	private String department;
}