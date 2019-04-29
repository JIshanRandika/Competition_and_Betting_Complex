/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.betting.dao.custom.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.betting.dao.CrudUtil;
import lk.betting.dao.custom.PlayersLevalsDAO;
import lk.betting.entity.PlayersLevals;

/**
 *
 * @author Your Name <Ishan Randika>
 */
public class PlayersLevalsDAOImpl implements PlayersLevalsDAO {

    @Override
    public ObservableList<String> fillcomboBox() throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM competition ORDER BY C_ID DESC LIMIT 4");
        ObservableList<String> list = FXCollections.observableArrayList();
        while (rst.next()) {
            String name = rst.getString("C_ID");
            list.add(name);
        }
        return list;
    }

    @Override
    public boolean savePlayersLevals(PlayersLevals players) throws ClassNotFoundException, SQLException {
        return CrudUtil.executeUpdate("insert into playerslevals values(?,?,?,?,?)", players.getPlNIC(), players.getC_ID(), players.isLeval_01(), players.isLeval_02(), players.isLeval_03());
    }

}
