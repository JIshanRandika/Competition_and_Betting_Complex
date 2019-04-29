/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.betting.dao.custom.impl;

import lk.betting.dao.CrudUtil;
import lk.betting.dao.custom.CreateCompetitionDAO;
import lk.betting.entity.CreateCompetition;

/**
 *
 * @author Your Name <Ishan Randika>
 */
public class CreateCompetitionDAOImpl implements CreateCompetitionDAO {

    @Override
    public boolean createCompetition(CreateCompetition createCompetition) throws Exception {
        return CrudUtil.executeUpdate("insert into competition values(?,?,?,?,?)", createCompetition.getCompetitionDate(), createCompetition.getCompetitionTime(), createCompetition.getCompetitionID(), createCompetition.getPoolNo(), createCompetition.getTracks());
    }

}
