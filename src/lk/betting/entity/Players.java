/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.betting.entity;

import java.util.Date;

/**
 *
 * @author Your Name <Ishan Randika>
 */
public class Players {

    private String plNIC;
    private String plName;
    private String plMobile;
    private String plAddress;
    private Date plBOD;
    private String plAge;

    public Players() {
    }

    public Players(String plNIC, String plName, String plMobile, String plAddress, Date plBOD, String plAge) {
        this.plNIC = plNIC;
        this.plName = plName;
        this.plMobile = plMobile;
        this.plAddress = plAddress;
        this.plBOD = plBOD;
        this.plAge = plAge;
    }

    public String getPlNIC() {
        return plNIC;
    }

    public void setPlNIC(String plNIC) {
        this.plNIC = plNIC;
    }

    public String getPlName() {
        return plName;
    }

    public void setPlName(String plName) {
        this.plName = plName;
    }

    public String getPlMobile() {
        return plMobile;
    }

    public void setPlMobile(String plMobile) {
        this.plMobile = plMobile;
    }

    public String getPlAddress() {
        return plAddress;
    }

    public void setPlAddress(String plAddress) {
        this.plAddress = plAddress;
    }

    public Date getPlBOD() {
        return plBOD;
    }

    public void setPlBOD(Date plBOD) {
        this.plBOD = plBOD;
    }

    public String getPlAge() {
        return plAge;
    }

    public void setPlAge(String plAge) {
        this.plAge = plAge;
    }

}
