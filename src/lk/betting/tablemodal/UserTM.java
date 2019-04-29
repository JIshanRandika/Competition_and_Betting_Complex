/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.betting.tablemodal;

/**
 *
 * @author Your Name <Ishan Randika>
 */
public class UserTM {

    String id;
    String name;
    String nic;
    String address;
    String dob;
    String mobile;
    String email;

    public UserTM() {
    }

    public UserTM(String id, String name, String nic, String address, String dob, String mobile, String email) {
        this.id = id;
        this.name = name;
        this.nic = nic;
        this.address = address;
        this.dob = dob;
        this.mobile = mobile;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
