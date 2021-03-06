/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.betting.bo.custom.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.ObservableList;
import lk.betting.bo.custom.BettersLevalsBO;
import lk.betting.dao.DAOFactory;
import lk.betting.dao.custom.BettersLevalsDAO;
import lk.betting.dao.custom.QueryDAO;
import lk.betting.dto.BettersLevalsDTO;
import lk.betting.entity.BettersLevals;

/**
 *
 * @author Your Name <Ishan Randika>
 */
public class BettersLevalsBOImpl implements BettersLevalsBO {

    BettersLevalsDAO dao = (BettersLevalsDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.BETTERSLEVALS);
    
    QueryDAO qudao = (QueryDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.QUERY);

    @Override
    public ObservableList<String> fillcomboBox() throws Exception {
        return dao.fillcomboBox();
    }

    @Override
    public boolean saveBettersLevals(BettersLevalsDTO bt) throws SQLException, ClassNotFoundException, Exception {
        return dao.saveBettersLevals(new BettersLevals(bt.getB_NIC(), bt.getB_ID(), bt.getLe01_P_NIC(), bt.getLe02_P_NIC(), bt.getLe03_P_NIC()));
    }

    @Override
    public ResultSet getleval02Pnic(String nic, String betID) throws ClassNotFoundException, SQLException, Exception {
        return qudao.betLgetleval02Pnic(nic, betID);
    }

    @Override
    public ResultSet getleval01Pnic(String nic, String betID) throws ClassNotFoundException, SQLException, Exception {
        return qudao.betLgetleval01Pnic(nic, betID);
    }

    @Override
    public ResultSet getleval03Pnic(String nic, String betID) throws ClassNotFoundException, SQLException, Exception {
        return qudao.betLgetleval03Pnic(nic, betID);
    }

}
