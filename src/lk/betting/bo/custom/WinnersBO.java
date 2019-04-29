/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.betting.bo.custom;

import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.ObservableList;
import lk.betting.bo.SuperBO;
import lk.betting.dto.WinnersDTO;

/**
 *
 * @author Your Name <Ishan Randika>
 */
public interface WinnersBO extends SuperBO {

    public ObservableList<String> fillcomboBox() throws Exception;

    public boolean saveWinners(WinnersDTO win) throws SQLException, ClassNotFoundException, Exception;

    public ResultSet getleval02Pnic(String nic, String comID) throws ClassNotFoundException, SQLException, Exception;

    public ResultSet getleval01Pnic(String nic, String comID) throws ClassNotFoundException, SQLException, Exception;

    public ResultSet getleval03Pnic(String nic, String comID) throws ClassNotFoundException, SQLException, Exception;
}
