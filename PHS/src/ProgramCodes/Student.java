package ProgramCodes;


import java.util.ArrayList;

public class Student extends Person {

	private int stAge;
	private int gradeLvl;
	private ArrayList<Grade> Grades;

	public int getStAge() {
		return this.stAge;
	}

	/**
	 * 
	 * @param stAge
	 */
	public void setStAge(int stAge) {
		this.stAge = stAge;
	}

	public int getGradeLvl() {
		return this.gradeLvl;
	}

	/**
	 * 
	 * @param gradeLvl
	 */
	public void setGradeLvl(int gradeLvl) {
		this.gradeLvl = gradeLvl;
	}

	/**
	 * 
	 * @param idNum
	 * @param lastName
	 * @param firstName
	 * @param midName
	 * @param contactNum
	 * @param homeAddress
	 * @param stAge
	 * @param gradeLvl
	 */
	public Student(String idNum, String lastName, String firstName, String midName, String contactNum, String homeAddress, int stAge, int gradeLvl) {
		// TODO - implement Student.Student
                super(idNum, lastName, firstName, midName, contactNum, homeAddress);
		throw new UnsupportedOperationException();
	}

	public ArrayList<Grade> getGrades() {
		// TODO - implement Student.getGrades
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param Grades
	 */
	public void setGrades(ArrayList<Grade> Grades) {
		// TODO - implement Student.setGrades
		throw new UnsupportedOperationException();
	}

}