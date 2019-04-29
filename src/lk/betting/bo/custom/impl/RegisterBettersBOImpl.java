/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.betting.bo.custom.impl;

import lk.betting.bo.custom.RegisterBettersBO;
import lk.betting.dao.DAOFactory;
import lk.betting.dao.custom.RegisterBettersDAO;
import lk.betting.dto.BettersDTO;
import lk.betting.entity.Betters;

/**
 *
 * @author Your Name <Ishan Randika>
 */
public class RegisterBettersBOImpl implements RegisterBettersBO {

    RegisterBettersDAO dao = (RegisterBettersDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.REGISTERBETTERS);

    @Override
    public boolean registerBetters(BettersDTO better) throws Exception {
        return dao.registerBetters(new Betters(better.getBtNIC(), better.getBtName(), better.getBtMobile(), better.getBtAddress(), better.getBtBOD(), better.getBtAge()));
    }

}
