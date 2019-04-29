/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.betting.dao.custom.impl;

import java.sql.ResultSet;
import lk.betting.dao.CrudUtil;
import lk.betting.dao.custom.LoginDAO;
import lk.betting.entity.Login;

/**
 *
 * @author Your Name <Ishan Randika>
 */
public class LoginDAOImpl implements LoginDAO {

    boolean d;

    @Override
    public boolean loginUser(Login login) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM users WHERE U_Email = ? and password =MD5(?)", login.getU_Email(), login.getPassword());

        if (!rst.next()) {
            d = false;
        } else {
            d = true;
        }
        return d;
    }

}
