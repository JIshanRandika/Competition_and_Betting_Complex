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
import lk.betting.dto.BettersLevalsDTO;

/**
 *
 * @author Your Name <Ishan Randika>
 */
public interface BettersLevalsBO extends SuperBO {

    public ObservableList<String> fillcomboBox() throws Exception;

    public boolean saveBettersLevals(BettersLevalsDTO ju) throws SQLException, ClassNotFoundException, Exception;

    public ResultSet getleval02Pnic(String nic, String betID) throws ClassNotFoundException, SQLException, Exception;

    public ResultSet getleval01Pnic(String nic, String betID) throws ClassNotFoundException, SQLException, Exception;

    public ResultSet getleval03Pnic(String nic, String betID) throws ClassNotFoundException, SQLException, Exception;

//    public boolean leval02Pnic(String nic, String betID) throws SQLException, ClassNotFoundException, Exception;
//
//    public boolean leval01Pnic(String nic, String betID) throws SQLException, ClassNotFoundException, Exception;
//
//    public boolean leval03Pnic(String nic, String betID) throws SQLException, ClassNotFoundException, Exception;
}
