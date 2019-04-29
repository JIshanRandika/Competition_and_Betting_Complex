/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.betting.bo.custom.impl;

import java.sql.SQLException;
import lk.betting.bo.custom.RegisterPlayersBO;
import lk.betting.dao.DAOFactory;
import lk.betting.dao.custom.RegisterPlayersDAO;
import lk.betting.dto.PlayersDTO;
import lk.betting.entity.Players;

/**
 *
 * @author Your Name <Ishan Randika>
 */
public class RegisterPlayersBOImpl implements RegisterPlayersBO {

    RegisterPlayersDAO dao = (RegisterPlayersDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.REGISTERPLAYERS);

    @Override
    public boolean registerPlayers(PlayersDTO players) throws SQLException, ClassNotFoundException, Exception {
        return dao.registerPlayers(new Players(players.getPlNIC(), players.getPlName(), players.getPlMobile(), players.getPlAddress(), players.getPlBOD(), players.getPlAge()));
    }

}
