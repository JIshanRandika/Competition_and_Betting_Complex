/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.betting.bo.custom;

import java.sql.SQLException;
import lk.betting.bo.SuperBO;
import lk.betting.dto.BettersDTO;

/**
 *
 * @author Your Name <Ishan Randika>
 */
public interface RegisterBettersBO extends SuperBO{
                    public boolean registerBetters (BettersDTO better) throws SQLException, ClassNotFoundException, Exception;

}
