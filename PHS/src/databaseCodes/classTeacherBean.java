package databaseCodes;

/**
 *
 * @author Chris
 */
public class classTeacherBean {
    private int ct_subjectID;
    private String ct_idEmployee;
    private int ct_classID;

    public classTeacherBean(int ct_subjectID, String ct_idEmployee, int ct_classID) {
        this.ct_subjectID = ct_subjectID;
        this.ct_idEmployee = ct_idEmployee;
        this.ct_classID = ct_classID;
    }

    public int getCt_subjectID() {
        return ct_subjectID;
    }

    public void setCt_subjectID(int ct_subjectID) {
        this.ct_subjectID = ct_subjectID;
    }

    public String getCt_idEmployee() {
        return ct_idEmployee;
    }

    public void setCt_idEmployee(String ct_idEmployee) {
        this.ct_idEmployee = ct_idEmployee;
    }

    public int getCt_classID() {
        return ct_classID;
    }

    public void setCt_classID(int ct_classID) {
        this.ct_classID = ct_classID;
    }
    
    
    
}
