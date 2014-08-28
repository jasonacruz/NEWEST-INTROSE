package databaseCodes;

/**
 *
 * @author Chris
 */
public class StudentBean {
    private String idStudent;
    private String firstNameSt;
    private String middleNameSt;
    private String lastNamest;
    private String genderSt;
    private String birthDateSt;
    private int yearLevelSt;

    public StudentBean(String idStudent, String firstNameSt, String middleNameSt, String lastNamest, String genderSt, String birthDateSt, int yearLevelSt) {
        this.idStudent = idStudent;
        this.firstNameSt = firstNameSt;
        this.middleNameSt = middleNameSt;
        this.lastNamest = lastNamest;
        this.genderSt = genderSt;
        this.birthDateSt = birthDateSt;
        this.yearLevelSt = yearLevelSt;
    }

    public String getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(String idStudent) {
        this.idStudent = idStudent;
    }

    public String getFirstNameSt() {
        return firstNameSt;
    }

    public void setFirstNameSt(String firstNameSt) {
        this.firstNameSt = firstNameSt;
    }

    public String getMiddleNameSt() {
        return middleNameSt;
    }

    public void setMiddleNameSt(String middleNameSt) {
        this.middleNameSt = middleNameSt;
    }

    public String getLastNamest() {
        return lastNamest;
    }

    public void setLastNamest(String lastNamest) {
        this.lastNamest = lastNamest;
    }

    public String getGenderSt() {
        return genderSt;
    }

    public void setGenderSt(String genderSt) {
        this.genderSt = genderSt;
    }

    public String getBirthDateSt() {
        return birthDateSt;
    }

    public void setBirthDateSt(String birthDateSt) {
        this.birthDateSt = birthDateSt;
    }

    public int getYearLevelSt() {
        return yearLevelSt;
    }

    public void setYearLevelSt(int yearLevelSt) {
        this.yearLevelSt = yearLevelSt;
    }
    
    public String getName(){
        return this.getLastNamest()+ ", "+this.getFirstNameSt()+" "+this.getMiddleNameSt();
    }
}
