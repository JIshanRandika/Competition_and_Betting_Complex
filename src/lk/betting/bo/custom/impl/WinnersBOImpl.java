/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.betting.bo.custom.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.ObservableList;
import lk.betting.bo.custom.WinnersBO;
import lk.betting.dao.DAOFactory;
import lk.betting.dao.custom.WinnersDAO;
import lk.betting.dto.WinnersDTO;
import lk.betting.entity.Winners;

/**
 *
 * @author Your Name <Ishan Randika>
 */
public class WinnersBOImpl implements WinnersBO {

    WinnersDAO dao = (WinnersDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.WINNERS);

    @Override
    public ObservableList<String> fillcomboBox() throws Exception {
        return dao.fillcomboBox();
    }

    @Override
    public boolean saveWinners(WinnersDTO win) throws SQLException, ClassNotFoundException, Exception {
        return dao.saveWinners(new Winners(win.getCompetition_ID(), win.getLe01_P_NIC(), win.getLe02_P_NIC(), win.getLe03_P_NIC()));
    }

    @Override
    public ResultSet getleval02Pnic(String nic, String comID) throws ClassNotFoundException, SQLException, Exception {
        return dao.getleval02Pnic(nic, comID);
    }

    @Override
    public ResultSet getleval01Pnic(String nic, String comID) throws ClassNotFoundException, SQLException, Exception {
        return dao.getleval01Pnic(nic, comID);
    }

    @Override
    public ResultSet getleval03Pnic(String nic, String comID) throws ClassNotFoundException, SQLException, Exception {
        return dao.getleval03Pnic(nic, comID);
    }

}
