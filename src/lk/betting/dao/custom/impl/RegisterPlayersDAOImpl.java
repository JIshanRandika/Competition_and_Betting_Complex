/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.betting.dao.custom.impl;

import java.sql.SQLException;
import lk.betting.dao.CrudUtil;
import lk.betting.dao.custom.RegisterPlayersDAO;
import lk.betting.entity.Players;

/**
 *
 * @author Your Name <Ishan Randika>
 */
public class RegisterPlayersDAOImpl implements RegisterPlayersDAO {

    @Override
    public boolean registerPlayers(Players players) throws ClassNotFoundException, SQLException {
        return CrudUtil.executeUpdate("insert into players values(?,?,?,?,?,?)", players.getPlNIC(), players.getPlName(), players.getPlAddress(), players.getPlMobile(), players.getPlBOD(), players.getPlAge());
    }

}
