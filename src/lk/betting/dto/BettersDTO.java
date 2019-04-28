/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.betting.dto;

import java.util.Date;

/**
 *
 * @author Your Name <Ishan Randika>
 */
public class BettersDTO {

    private String btNIC;
    private String btName;
    private String btMobile;
    private String btAddress;
    private Date btBOD;
    private String btAge;

    public BettersDTO() {
    }

    public BettersDTO(String btNIC, String btName, String btMobile, String btAddress, Date btBOD, String btAge) {
        this.btNIC = btNIC;
        this.btName = btName;
        this.btMobile = btMobile;
        this.btAddress = btAddress;
        this.btBOD = btBOD;
        this.btAge = btAge;
    }

    public String getBtNIC() {
        return btNIC;
    }

    public void setBtNIC(String btNIC) {
        this.btNIC = btNIC;
    }

    public String getBtName() {
        return btName;
    }

    public void setBtName(String btName) {
        this.btName = btName;
    }

    public String getBtMobile() {
        return btMobile;
    }

    public void setBtMobile(String btMobile) {
        this.btMobile = btMobile;
    }

    public String getBtAddress() {
        return btAddress;
    }

    public void setBtAddress(String btAddress) {
        this.btAddress = btAddress;
    }

    public Date getBtBOD() {
        return btBOD;
    }

    public void setBtBOD(Date btBOD) {
        this.btBOD = btBOD;
    }

    public String getBtAge() {
        return btAge;
    }

    public void setBtAge(String btAge) {
        this.btAge = btAge;
    }

   
    
}
