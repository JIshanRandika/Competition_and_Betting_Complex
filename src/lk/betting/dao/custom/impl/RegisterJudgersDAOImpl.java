/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.betting.dao.custom.impl;

import java.sql.ResultSet;
import lk.betting.dao.CrudUtil;
import lk.betting.dao.custom.RegisterJudgersDAO;
import lk.betting.entity.Judgers;

/**
 *
 * @author Your Name <Ishan Randika>
 */
public class RegisterJudgersDAOImpl implements RegisterJudgersDAO {

    @Override
    public boolean registerJudgers(Judgers judgers) throws Exception {
        return CrudUtil.executeUpdate("insert into judges values(?,?,?,?)", judgers.getJuNIC(), judgers.getJuName(), judgers.getJuMobile(), judgers.getJuEmail());

    }

    @Override
    public Judgers search(String juNIC) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select * from judges where J_NIC=?", juNIC);
        Judgers cust = null;
        while (rst.next()) {
            cust = new Judgers(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4));
        }
        return cust;
    }

    @Override
    public boolean UpdateJudgers(Judgers judgers) throws Exception {
            return CrudUtil.executeUpdate("update judges set J_Mobile=? where J_Email=?",judgers.getJuMobile(), judgers.getJuEmail());

    }

}
