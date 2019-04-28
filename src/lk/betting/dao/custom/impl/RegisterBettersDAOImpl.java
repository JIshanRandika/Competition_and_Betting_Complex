/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.betting.dao.custom.impl;

import lk.betting.dao.CrudUtil;
import lk.betting.dao.custom.RegisterBettersDAO;
import lk.betting.entity.Betters;

/**
 *
 * @author Your Name <Ishan Randika>
 */
public class RegisterBettersDAOImpl implements RegisterBettersDAO{

    @Override
    public boolean registerBetters(Betters betters) throws Exception {
        return CrudUtil.executeUpdate("insert into betters values(?,?,?,?,?,?)", betters.getBtNIC(), betters.getBtName(), betters.getBtAddress(), betters.getBtMobile(),betters.getBtBOD(),betters.getBtAge());

    }
    
}
