/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.betting.dao.custom.impl;

import lk.betting.dao.CrudUtil;
import lk.betting.dao.custom.SpectatorDAO;
import lk.betting.entity.Spectator;

/**
 *
 * @author Your Name <Ishan Randika>
 */
public class SpectatorDAOImpl implements SpectatorDAO{

    @Override
    public boolean registerSpectator(Spectator spectator) throws Exception {
        return CrudUtil.executeUpdate("insert into spectator values(?,?,?,?)", spectator.getSpectatorID(), spectator.getSpectatorName(), spectator.getSpectatorAddress(), spectator.getSpectatorMobile());
    }
    
}
