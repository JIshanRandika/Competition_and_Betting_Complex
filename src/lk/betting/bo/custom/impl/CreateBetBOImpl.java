/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.betting.bo.custom.impl;

import java.sql.SQLException;
import lk.betting.bo.custom.CreateBetBO;
import lk.betting.dao.DAOFactory;
import lk.betting.dao.custom.CreateBetDAO;
import lk.betting.dto.CreateBetDTO;
import lk.betting.entity.CreateBet;

/**
 *
 * @author Your Name <Ishan Randika>
 */
public class CreateBetBOImpl implements CreateBetBO{

            CreateBetDAO dao = (CreateBetDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CREATEBET);

    
    @Override
    public boolean createBet(CreateBetDTO crbet) throws SQLException, ClassNotFoundException, Exception {
        return dao.createBet(new CreateBet(crbet.getCompetitionID(),crbet.getBetID()));
    }
    
}
