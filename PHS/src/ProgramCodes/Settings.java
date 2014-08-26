/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ProgramCodes;

/**
 *
 * @author home
 */
public class Settings {
    private int settingKnowledge;
    private int settingUnderstanding;
    private int settingProcess;
    private int settingProduct;
    private int settingSchoolYear;
    private int settingQuarter;

    public Settings() {
       
    }
    
    //setters
    public void setKnowledge(int knowledge)
    {
        this.settingKnowledge = knowledge;
    }
    
    public void setUnderstanding(int understanding)
    {
        this.settingUnderstanding = understanding;
    }
    
    public void setProcess(int process)
    {
        this.settingProcess = process;
    }
    
    public void setProduct(int product)
    {
        this.settingProduct = product;
    }
    
    public void setSchoolYear(int schoolYear)
    {
        this.settingSchoolYear = schoolYear;
    }
    
    public void setQuarter(int quarter)
    {
        this.settingQuarter = quarter;
    }
    
    //getters
    
    public int getKnowledge()
    {
        return settingKnowledge;
    }
    
    public int getUnderstanding()
    {
        return settingUnderstanding;
    }
    
    public int getProduct()
    {
        return settingProduct;
    }
    
    public int getProcess()
    {
        return settingProcess;
    }
    
    public int getSchoolYear()
    {
        return settingSchoolYear;
    }
    
    public int getQuarter()
    {
        return settingQuarter;
    }
    public Settings(int knowledge,int understanding, int process, int product, int schoolYear, int quarter)
    {
        this.settingKnowledge = knowledge;
        this.settingUnderstanding = understanding;
        this.settingProcess = process;
        this.settingProduct = product;
        this.settingSchoolYear = schoolYear;
        this.settingQuarter = quarter;
    }
}
