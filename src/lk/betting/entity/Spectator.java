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
public class Spectator {
    private String spectatorID;
    private String spectatorName;
    private String spectatorAddress;
    private String spectatorMobile;

    public Spectator() {
    }

    public Spectator(String spectatorID, String spectatorName, String spectatorAddress, String spectatorMobile) {
        this.spectatorID = spectatorID;
        this.spectatorName = spectatorName;
        this.spectatorAddress = spectatorAddress;
        this.spectatorMobile = spectatorMobile;
    }

    public String getSpectatorID() {
        return spectatorID;
    }

    public void setSpectatorID(String spectatorID) {
        this.spectatorID = spectatorID;
    }

    public String getSpectatorName() {
        return spectatorName;
    }

    public void setSpectatorName(String spectatorName) {
        this.spectatorName = spectatorName;
    }

    public String getSpectatorAddress() {
        return spectatorAddress;
    }

    public void setSpectatorAddress(String spectatorAddress) {
        this.spectatorAddress = spectatorAddress;
    }

    public String getSpectatorMobile() {
        return spectatorMobile;
    }

    public void setSpectatorMobile(String spectatorMobile) {
        this.spectatorMobile = spectatorMobile;
    }
    
    
}
