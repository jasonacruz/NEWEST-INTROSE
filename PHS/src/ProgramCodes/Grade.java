package ProgramCodes;

public abstract class Grade {

	private double gradeScore;
	private int gradeQuarter;
	private Subject subject;
	private Student student;

	public double getGradeScore() {
		return this.gradeScore;
	}

	/**
	 * 
	 * @param gradeScore
	 */
	public void setGradeScore(double gradeScore) {
		this.gradeScore = gradeScore;
	}

	public int getGradeQuarter() {
		return this.gradeQuarter;
	}

	/**
	 * 
	 * @param gradeQuarter
	 */
	public void setGradeQuarter(int gradeQuarter) {
		this.gradeQuarter = gradeQuarter;
	}

	public Subject getSubjName() {
		// TODO - implement Grade.getSubjName
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param subjName
	 */
	public void setSubjName(Subject subjName) {
		// TODO - implement Grade.setSubjName
		throw new UnsupportedOperationException();
	}

	public Student getStudentID() {
		// TODO - implement Grade.getStudentID
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param studentID
	 */
	public void setStudentID(Student studentID) {
		// TODO - implement Grade.setStudentID
		throw new UnsupportedOperationException();
	}

}