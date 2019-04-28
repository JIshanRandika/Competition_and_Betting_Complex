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
public class Bet {
    private String com_ID;
    private String bet_ID;

    public Bet() {
    }

    public Bet(String com_ID, String bet_ID) {
        this.com_ID = com_ID;
        this.bet_ID = bet_ID;
    }

    public String getCom_ID() {
        return com_ID;
    }

    public void setCom_ID(String com_ID) {
        this.com_ID = com_ID;
    }

    public String getBet_ID() {
        return bet_ID;
    }

    public void setBet_ID(String bet_ID) {
        this.bet_ID = bet_ID;
    }
    
    
}
