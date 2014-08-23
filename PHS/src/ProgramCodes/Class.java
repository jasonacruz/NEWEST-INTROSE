package ProgramCodes;


import java.util.ArrayList;

public class Class {

	private String sectName;
	private ArrayList<Student> Students;
	private int sectYearlvl;
	private int schoolYear;

	public String getSectName() {
		return this.sectName;
	}

	/**
	 * 
	 * @param sectName
	 */
	public void setSectName(String sectName) {
		this.sectName = sectName;
	}

	public int getSectYearlvl() {
		return this.sectYearlvl;
	}

	/**
	 * 
	 * @param sectYearlvl
	 */
	public void setSectYearlvl(int sectYearlvl) {
		this.sectYearlvl = sectYearlvl;
	}

	public int getSchoolYear() {
		return this.schoolYear;
	}

	/**
	 * 
	 * @param schoolYear
	 */
	public void setSchoolYear(int schoolYear) {
		this.schoolYear = schoolYear;
	}
}