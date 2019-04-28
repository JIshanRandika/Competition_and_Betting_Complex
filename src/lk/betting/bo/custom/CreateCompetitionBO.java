/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.betting.bo.custom;

import java.sql.SQLException;
import lk.betting.bo.SuperBO;
import lk.betting.dto.CreateBetDTO;
import lk.betting.dto.CreateCompetitionDTO;

/**
 *
 * @author Your Name <Ishan Randika>
 */
public interface CreateCompetitionBO extends SuperBO{

    public boolean createCompetition(CreateCompetitionDTO crcom) throws SQLException, ClassNotFoundException, Exception;

    
}
