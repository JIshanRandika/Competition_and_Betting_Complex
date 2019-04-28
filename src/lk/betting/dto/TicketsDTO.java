/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.betting.dto;

/**
 *
 * @author ASUS
 */
public class TicketsDTO {
    private String s_ID;
    private String c_ID;
    private String sheat_No;
    private String ticket_No;

    public TicketsDTO() {
    }

    public TicketsDTO(String s_ID, String c_ID, String sheat_No, String ticket_No) {
        this.s_ID = s_ID;
        this.c_ID = c_ID;
        this.sheat_No = sheat_No;
        this.ticket_No = ticket_No;
    }

    public String getS_ID() {
        return s_ID;
    }

    public void setS_ID(String s_ID) {
        this.s_ID = s_ID;
    }

    public String getC_ID() {
        return c_ID;
    }

    public void setC_ID(String c_ID) {
        this.c_ID = c_ID;
    }

    public String getSheat_No() {
        return sheat_No;
    }

    public void setSheat_No(String sheat_No) {
        this.sheat_No = sheat_No;
    }

    public String getTicket_No() {
        return ticket_No;
    }

    public void setTicket_No(String ticket_No) {
        this.ticket_No = ticket_No;
    }
    
     
}
