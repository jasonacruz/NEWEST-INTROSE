package databaseCodes;

/**
 *
 * @author Chris
 */
public class classAdviserBean {
    private int classID;
    private int classYear;
    private int adviserID;
    private String classSection;

    public classAdviserBean(int classID, int classYear, int adviserID, String classSection) {
        this.classID = classID;
        this.classYear = classYear;
        this.adviserID = adviserID;
        this.classSection = classSection;
    }

    public int getClassID() {
        return classID;
    }

    public void setClassID(int classID) {
        this.classID = classID;
    }

    public int getClassYear() {
        return classYear;
    }

    public void setClassYear(int classYear) {
        this.classYear = classYear;
    }

    public int getAdviserID() {
        return adviserID;
    }

    public void setAdviserID(int adviserID) {
        this.adviserID = adviserID;
    }

    public String getClassSection() {
        return classSection;
    }

    public void setClassSection(String classSection) {
        this.classSection = classSection;
    }
    
    
}
