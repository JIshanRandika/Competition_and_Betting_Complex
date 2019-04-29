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
import lk.betting.dao.custom.JudgersLevalsDAO;
import lk.betting.entity.JudgersLevals;

/**
 *
 * @author Your Name <Ishan Randika>
 */
public class JudgersLevalsDAOImpl implements JudgersLevalsDAO {

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
    public boolean saveJudgersLevals(JudgersLevals judgers) throws Exception {
        return CrudUtil.executeUpdate("insert into judgeslevals values(?,?,?,?,?)", judgers.getJuNIC(), judgers.getC_ID(), judgers.isLeval_01(), judgers.isLeval_02(), judgers.isLeval_03());
    }
}
