/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.betting.dao.custom.impl;

import lk.betting.dao.CrudUtil;
import lk.betting.dao.custom.RegisterJudgersDAO;
import lk.betting.entity.Judgers;

/**
 *
 * @author Your Name <Ishan Randika>
 */
public class RegisterJudgersDAOImpl implements RegisterJudgersDAO{

    @Override
    public boolean registerJudgers(Judgers judgers) throws Exception {
        return CrudUtil.executeUpdate("insert into judges values(?,?,?,?)", judgers.getJuNIC(), judgers.getJuName(), judgers.getJuMobile(), judgers.getJuEmail());


    }
    
}
