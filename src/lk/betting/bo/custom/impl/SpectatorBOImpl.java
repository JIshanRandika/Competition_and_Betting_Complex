/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.betting.bo.custom.impl;

import java.sql.SQLException;
import lk.betting.bo.custom.SpectatorBO;
import lk.betting.dao.DAOFactory;
import lk.betting.dao.custom.SpectatorDAO;
import lk.betting.dto.SpectatorDTO;
import lk.betting.entity.Spectator;

/**
 *
 * @author Your Name <Ishan Randika>
 */
public class SpectatorBOImpl implements SpectatorBO{
        SpectatorDAO dao = (SpectatorDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.SPECTATOR);

    @Override
    public boolean registerSpectator(SpectatorDTO spectator) throws SQLException, ClassNotFoundException, Exception {
        return dao.registerSpectator(new Spectator(spectator.getSpectatorID(), spectator.getSpectatorName(), spectator.getSpectatorAddress(), spectator.getSpectatorMobile()));
    }
    
}
