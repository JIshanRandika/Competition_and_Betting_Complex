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
public class LoginDTO {

    private String u_Email;
    private String password;

    public LoginDTO(String u_Email, String password) {
        this.u_Email = u_Email;
        this.password = password;
    }

    public LoginDTO() {
    }

    public String getU_Email() {
        return u_Email;
    }

    public void setU_Email(String u_Email) {
        this.u_Email = u_Email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
