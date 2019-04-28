/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.betting.entity;

/**
 *
 * @author Your Name <Ishan Randika>
 */
public class Judgers {
    private String juNIC;
    private String juName;
    private String juMobile;
    private String juEmail;

    public Judgers() {
    }

    public Judgers(String juNIC, String juName, String juMobile, String juEmail) {
        this.juNIC = juNIC;
        this.juName = juName;
        this.juMobile = juMobile;
        this.juEmail = juEmail;
    }

    public String getJuNIC() {
        return juNIC;
    }

    public void setJuNIC(String juNIC) {
        this.juNIC = juNIC;
    }

    public String getJuName() {
        return juName;
    }

    public void setJuName(String juName) {
        this.juName = juName;
    }

    public String getJuMobile() {
        return juMobile;
    }

    public void setJuMobile(String juMobile) {
        this.juMobile = juMobile;
    }

    public String getJuEmail() {
        return juEmail;
    }

    public void setJuEmail(String juEmail) {
        this.juEmail = juEmail;
    }
    
    
}
