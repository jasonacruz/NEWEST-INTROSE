package ProgramCodes;


import java.util.ArrayList;

public class Classroom {

	private String sectName;
        private String subjectName;
	private ArrayList<Student> studentList;
	private int sectYearlvl;
	private int schoolYear;

        public void setStudentList(ArrayList<Student> Students)
        {
            this.studentList = Students;
        }
        
        public ArrayList<Student> getStudentList()
        {
            return studentList;
        }
        
	public String getSectName() {
		return this.sectName;
	}
        public String getSubjectName() {
		return this.subjectName;
	}
	/**
	 * 
	 * @param sectName
	 */
	public void setSectName(String sectName) {
		this.sectName = sectName;
	}
        
        public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
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