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
import lk.betting.dao.custom.BettersLevalsDAO;
import lk.betting.entity.BettersLevals;

/**
 *
 * @author Your Name <Ishan Randika>
 */
public class BettersLevalsDAOImpl implements BettersLevalsDAO {

    @Override
    public ObservableList<String> fillcomboBox() throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM bet ORDER BY B_ID DESC LIMIT 3");
        ObservableList<String> list = FXCollections.observableArrayList();
        while (rst.next()) {
            String name = rst.getString("B_ID");
            list.add(name);
        }
        return list;
    }

    @Override
    public boolean saveBettersLevals(BettersLevals bettersLevals) throws Exception {
        return CrudUtil.executeUpdate("insert into betterslevals values(?,?,?,?,?)", bettersLevals.getB_NIC(), bettersLevals.getB_ID(), bettersLevals.getLe01_P_NIC(), bettersLevals.getLe02_P_NIC(), bettersLevals.getLe03_P_NIC());
    }

}
