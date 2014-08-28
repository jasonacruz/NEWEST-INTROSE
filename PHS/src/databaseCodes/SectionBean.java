package databaseCodes;

/**
 *
 * @author Chris
 */
public class SectionBean {
    private int sectionID;
    private String name;
    private int year;
    private int schoolYear;

    public SectionBean(int sectionID, String name, int year, int schoolYear) {
        this.sectionID = sectionID;
        this.name = name;
        this.year = year;
        this.schoolYear = schoolYear;
    }

    public int getSectionID() {
        return sectionID;
    }

    public void setSectionID(int sectionID) {
        this.sectionID = sectionID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(int schoolYear) {
        this.schoolYear = schoolYear;
    }

    
}
