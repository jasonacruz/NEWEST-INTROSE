package ProgramCodes;

public class Coordinator extends Employee implements HeadEmployee, GradesViewing {

    public Coordinator(String idNum, String lastName, String firstName, String midName, String contactNum, String homeAddress, String empPw, String empPosition, Boolean passField) {
        super(idNum, lastName, firstName, midName, contactNum, homeAddress, empPw, empPosition, passField);
    }

    public Coordinator() {
    }

	public boolean approveGrade() {
		// TODO - implement Coordinator.approveGrade
		throw new UnsupportedOperationException();
	}

	public boolean viewGrades() {
		// TODO - implement Coordinator.viewGrades
		throw new UnsupportedOperationException();
	}

	private String department;
}