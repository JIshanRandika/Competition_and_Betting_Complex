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
public class BettersLevals {
    private String b_NIC;
    private String b_ID;
    private String le01_P_NIC;
    private String le02_P_NIC;
    private String le03_P_NIC;

    public BettersLevals() {
    }

    public BettersLevals(String b_NIC, String b_ID, String le01_P_NIC, String le02_P_NIC, String le03_P_NIC) {
        this.b_NIC = b_NIC;
        this.b_ID = b_ID;
        this.le01_P_NIC = le01_P_NIC;
        this.le02_P_NIC = le02_P_NIC;
        this.le03_P_NIC = le03_P_NIC;
    }

    public String getB_NIC() {
        return b_NIC;
    }

    public void setB_NIC(String b_NIC) {
        this.b_NIC = b_NIC;
    }

    public String getB_ID() {
        return b_ID;
    }

    public void setB_ID(String b_ID) {
        this.b_ID = b_ID;
    }

    public String getLe01_P_NIC() {
        return le01_P_NIC;
    }

    public void setLe01_P_NIC(String le01_P_NIC) {
        this.le01_P_NIC = le01_P_NIC;
    }

    public String getLe02_P_NIC() {
        return le02_P_NIC;
    }

    public void setLe02_P_NIC(String le02_P_NIC) {
        this.le02_P_NIC = le02_P_NIC;
    }

    public String getLe03_P_NIC() {
        return le03_P_NIC;
    }

    public void setLe03_P_NIC(String le03_P_NIC) {
        this.le03_P_NIC = le03_P_NIC;
    }
    
    
}
