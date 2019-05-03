/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.betting.dao.custom.impl;

import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.betting.dao.CrudUtil;
import lk.betting.dao.custom.WinnersDAO;
import lk.betting.entity.Winners;

/**
 *
 * @author Your Name <Ishan Randika>
 */
public class WinnersDAOImpl implements WinnersDAO {

    @Override
    public ObservableList<String> fillcomboBox() throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM competition ORDER BY C_ID DESC LIMIT 3");
        ObservableList<String> list = FXCollections.observableArrayList();
        while (rst.next()) {
            String name = rst.getString("C_ID");
            list.add(name);
        }
        return list;
    }

    @Override
    public boolean saveWinners(Winners winners) throws Exception {
        return CrudUtil.executeUpdate("insert into winners values(?,?,?,?)", winners.getCompetition_ID(), winners.getLe01_P_NIC(), winners.getLe02_P_NIC(), winners.getLe03_P_NIC());
    }
}
