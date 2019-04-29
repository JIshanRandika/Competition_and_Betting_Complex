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
public class CreateCompetition {

    private String competitionID;
    private Date competitionDate;
    private String competitionTime;
    private String poolNo;
    private String tracks;

    public CreateCompetition() {
    }

    public CreateCompetition(String competitionID, Date competitionDate, String competitionTime, String poolNo, String tracks) {
        this.competitionID = competitionID;
        this.competitionDate = competitionDate;
        this.competitionTime = competitionTime;
        this.poolNo = poolNo;
        this.tracks = tracks;
    }

    public String getCompetitionID() {
        return competitionID;
    }

    public void setCompetitionID(String competitionID) {
        this.competitionID = competitionID;
    }

    public Date getCompetitionDate() {
        return competitionDate;
    }

    public void setCompetitionDate(Date competitionDate) {
        this.competitionDate = competitionDate;
    }

    public String getCompetitionTime() {
        return competitionTime;
    }

    public void setCompetitionTime(String competitionTime) {
        this.competitionTime = competitionTime;
    }

    public String getPoolNo() {
        return poolNo;
    }

    public void setPoolNo(String poolNo) {
        this.poolNo = poolNo;
    }

    public String getTracks() {
        return tracks;
    }

    public void setTracks(String tracks) {
        this.tracks = tracks;
    }

}
