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
public class PlayersLevalsDTO {

    private String plNIC;
    private String c_ID;
    private boolean leval_01;
    private boolean leval_02;
    private boolean leval_03;

    public PlayersLevalsDTO() {
    }

    public PlayersLevalsDTO(String plNIC, String c_ID, boolean leval_01, boolean leval_02, boolean leval_03) {
        this.plNIC = plNIC;
        this.c_ID = c_ID;
        this.leval_01 = leval_01;
        this.leval_02 = leval_02;
        this.leval_03 = leval_03;
    }

    public String getPlNIC() {
        return plNIC;
    }

    public void setPlNIC(String plNIC) {
        this.plNIC = plNIC;
    }

    public String getC_ID() {
        return c_ID;
    }

    public void setC_ID(String c_ID) {
        this.c_ID = c_ID;
    }

    public boolean isLeval_01() {
        return leval_01;
    }

    public void setLeval_01(boolean leval_01) {
        this.leval_01 = leval_01;
    }

    public boolean isLeval_02() {
        return leval_02;
    }

    public void setLeval_02(boolean leval_02) {
        this.leval_02 = leval_02;
    }

    public boolean isLeval_03() {
        return leval_03;
    }

    public void setLeval_03(boolean leval_03) {
        this.leval_03 = leval_03;
    }

}
