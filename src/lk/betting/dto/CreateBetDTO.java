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
public class CreateBetDTO {

    private String competitionID;
    private String betID;

    public CreateBetDTO() {
    }

    public CreateBetDTO(String competitionID, String betID) {
        this.competitionID = competitionID;
        this.betID = betID;
    }

    public String getCompetitionID() {
        return competitionID;
    }

    public void setCompetitionID(String competitionID) {
        this.competitionID = competitionID;
    }

    public String getBetID() {
        return betID;
    }

    public void setBetID(String betID) {
        this.betID = betID;
    }

}
