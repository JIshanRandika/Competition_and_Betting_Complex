/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.betting.dao.custom.impl;

import lk.betting.dao.CrudUtil;
import lk.betting.dao.custom.CreateBetDAO;
import lk.betting.entity.CreateBet;

/**
 *
 * @author Your Name <Ishan Randika>
 */
public class CreateBetDAOImpl implements CreateBetDAO{

    @Override
    public boolean createBet(CreateBet createBet) throws Exception {
        return CrudUtil.executeUpdate("insert into bet values(?,?)", createBet.getBetID(),createBet.getCompetitionID());
    }
    
}
