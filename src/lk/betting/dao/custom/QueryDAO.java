/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.betting.dao.custom;

import java.sql.ResultSet;
import lk.betting.dao.SuperDAO;

/**
 *
 * @author ASUS
 */
public interface QueryDAO extends SuperDAO {

    public ResultSet getleval02Pnic(String nic, String comID) throws Exception;

    public ResultSet getleval01Pnic(String nic, String comID) throws Exception;

    public ResultSet getleval03Pnic(String nic, String comID) throws Exception;

    public ResultSet betLgetleval02Pnic(String nic, String betID) throws Exception;

    public ResultSet betLgetleval01Pnic(String nic, String betID) throws Exception;

    public ResultSet betLgetleval03Pnic(String nic, String betID) throws Exception;
    
}
