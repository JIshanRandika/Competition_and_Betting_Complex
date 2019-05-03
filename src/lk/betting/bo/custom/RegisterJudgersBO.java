/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.betting.bo.custom;

import java.sql.SQLException;
import lk.betting.bo.SuperBO;
import lk.betting.dto.JudgersDTO;

/**
 *
 * @author Your Name <Ishan Randika>
 */
public interface RegisterJudgersBO extends SuperBO {

    public boolean registerJudgers(JudgersDTO login) throws SQLException, ClassNotFoundException, Exception;

    public JudgersDTO searchJu(String juNIC) throws SQLException, ClassNotFoundException, Exception;

    public boolean UpdateJudgers(JudgersDTO judgers) throws SQLException, ClassNotFoundException, Exception;

}
