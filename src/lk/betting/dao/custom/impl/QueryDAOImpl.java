/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.betting.dao.custom.impl;

import java.sql.ResultSet;
import lk.betting.dao.CrudUtil;
import lk.betting.dao.custom.QueryDAO;

/**
 *
 * @author ASUS
 */
public class QueryDAOImpl implements QueryDAO{

    @Override
    public ResultSet getleval02Pnic(String nic, String comID) throws Exception {
        return CrudUtil.executeQuery("select L2 from bet left join playerslevals using(C_ID) where P_NIC=? && C_ID=?", nic, comID);
    }

    @Override
    public ResultSet getleval01Pnic(String nic, String comID) throws Exception {
        return CrudUtil.executeQuery("select L1 from bet left join playerslevals using(C_ID) where P_NIC=? && C_ID=?", nic, comID);
    }

    @Override
    public ResultSet getleval03Pnic(String nic, String comID) throws Exception {
        return CrudUtil.executeQuery("select L3 from bet left join playerslevals using(C_ID) where P_NIC=? && C_ID=?", nic, comID);
    }

    @Override
    public ResultSet betLgetleval02Pnic(String nic, String betID) throws Exception {
        return CrudUtil.executeQuery("select L2 from bet left join playerslevals using(C_ID) where P_NIC=? && B_ID=?", nic, betID);
    }

    @Override
    public ResultSet betLgetleval01Pnic(String nic, String betID) throws Exception {
        return CrudUtil.executeQuery("select L1 from bet left join playerslevals using(C_ID) where P_NIC=? && B_ID=?", nic, betID);
    }

    @Override
    public ResultSet betLgetleval03Pnic(String nic, String betID) throws Exception {
        return CrudUtil.executeQuery("select L3 from bet left join playerslevals using(C_ID) where P_NIC=? && B_ID=?", nic, betID);
    }
    
}
