package databaseCodes;

/**
 *
 * @author Chris
 */
public class subjectBean {
    private int subjectID;
    private String subjectName;
    private int subjectGradeLevel;

    public subjectBean(int subjectID, String subjectName, int subjectGradeLevel) {
        this.subjectID = subjectID;
        this.subjectName = subjectName;
        this.subjectGradeLevel = subjectGradeLevel;
    }

    public int getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(int subjectID) {
        this.subjectID = subjectID;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getSubjectGradeLevel() {
        return subjectGradeLevel;
    }

    public void setSubjectGradeLevel(int subjectGradeLevel) {
        this.subjectGradeLevel = subjectGradeLevel;
    }
    
    
}
