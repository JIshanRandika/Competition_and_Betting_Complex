/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.betting.dao.custom;

import java.sql.ResultSet;
import javafx.collections.ObservableList;
import lk.betting.dao.CrudDAO;
import lk.betting.entity.BettersLevals;

/**
 *
 * @author Your Name <Ishan Randika>
 */
public interface BettersLevalsDAO extends CrudDAO< BettersLevals, String> {

    public ObservableList<String> fillcomboBox() throws Exception;

    public boolean saveBettersLevals(BettersLevals bettersLevals) throws Exception;

    public ResultSet getleval02Pnic(String nic, String betID) throws Exception;

//    public boolean leval02Pnic(String nic, String betID) throws Exception;
//
//    public boolean leval01Pnic(String nic, String betID) throws Exception;
//
//    public boolean leval03Pnic(String nic, String betID) throws Exception;
    public ResultSet getleval01Pnic(String nic, String betID) throws Exception;

    public ResultSet getleval03Pnic(String nic, String betID) throws Exception;

}
