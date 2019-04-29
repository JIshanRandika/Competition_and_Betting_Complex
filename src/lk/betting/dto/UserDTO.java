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
public class UserDTO {

    private String userID;
    private String u_Name;
    private String u_NIC;
    private String mobile_No;
    private String u_Email;
    private String u_Address;
    private Date bOD;
    private String password;
    private String image;

    public UserDTO() {
    }

    public UserDTO(String userID, String u_Name, String u_NIC, String mobile_No, String u_Email, String u_Address, Date bOD, String password, String image) {
        this.userID = userID;
        this.u_Name = u_Name;
        this.u_NIC = u_NIC;
        this.mobile_No = mobile_No;
        this.u_Email = u_Email;
        this.u_Address = u_Address;
        this.bOD = bOD;
        this.password = password;
        this.image = image;
    }

    public UserDTO(String userID, String u_Name, String u_NIC, String mobile_No, String u_Email, String u_Address, Date bOD, String image) {
        this.userID = userID;
        this.u_Name = u_Name;
        this.u_NIC = u_NIC;
        this.mobile_No = mobile_No;
        this.u_Email = u_Email;
        this.u_Address = u_Address;
        this.bOD = bOD;
//        this.password = password;
        this.image = image;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getU_Name() {
        return u_Name;
    }

    public void setU_Name(String u_Name) {
        this.u_Name = u_Name;
    }

    public String getU_NIC() {
        return u_NIC;
    }

    public void setU_NIC(String u_NIC) {
        this.u_NIC = u_NIC;
    }

    public String getMobile_No() {
        return mobile_No;
    }

    public void setMobile_No(String mobile_No) {
        this.mobile_No = mobile_No;
    }

    public String getU_Email() {
        return u_Email;
    }

    public void setU_Email(String u_Email) {
        this.u_Email = u_Email;
    }

    public String getU_Address() {
        return u_Address;
    }

    public void setU_Address(String u_Address) {
        this.u_Address = u_Address;
    }

    public Date getbOD() {
        return bOD;
    }

    public void setbOD(Date bOD) {
        this.bOD = bOD;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

//    public void setbOD(String bod) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}
