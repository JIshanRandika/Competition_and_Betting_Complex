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
public class Competition {

    private String c_Date;
    private String c_Time;
    private String c_ID;
    private String pool_No;
    private String tracks;

    public Competition() {
    }

    public Competition(String c_Date, String c_Time, String c_ID, String pool_No, String tracks) {
        this.c_Date = c_Date;
        this.c_Time = c_Time;
        this.c_ID = c_ID;
        this.pool_No = pool_No;
        this.tracks = tracks;
    }

    public String getC_Date() {
        return c_Date;
    }

    public void setC_Date(String c_Date) {
        this.c_Date = c_Date;
    }

    public String getC_Time() {
        return c_Time;
    }

    public void setC_Time(String c_Time) {
        this.c_Time = c_Time;
    }

    public String getC_ID() {
        return c_ID;
    }

    public void setC_ID(String c_ID) {
        this.c_ID = c_ID;
    }

    public String getPool_No() {
        return pool_No;
    }

    public void setPool_No(String pool_No) {
        this.pool_No = pool_No;
    }

    public String getTracks() {
        return tracks;
    }

    public void setTracks(String tracks) {
        this.tracks = tracks;
    }

}
