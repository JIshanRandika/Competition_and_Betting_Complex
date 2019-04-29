/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.betting.dto;

/**
 *
 * @author Your Name <Ishan Randika>
 */
public class WinnersDTO {

    private String competition_ID;
    private String le01_P_NIC;
    private String le02_P_NIC;
    private String le03_P_NIC;

    public WinnersDTO() {
    }

    public WinnersDTO(String competition_ID, String le01_P_NIC, String le02_P_NIC, String le03_P_NIC) {
        this.competition_ID = competition_ID;
        this.le01_P_NIC = le01_P_NIC;
        this.le02_P_NIC = le02_P_NIC;
        this.le03_P_NIC = le03_P_NIC;
    }

    public String getCompetition_ID() {
        return competition_ID;
    }

    public void setCompetition_ID(String competition_ID) {
        this.competition_ID = competition_ID;
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
