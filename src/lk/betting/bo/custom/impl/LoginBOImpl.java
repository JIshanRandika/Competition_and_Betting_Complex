/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.betting.bo.custom.impl;

import java.sql.SQLException;
import lk.betting.bo.custom.LoginBO;
import lk.betting.dao.DAOFactory;
import lk.betting.dao.custom.LoginDAO;
import lk.betting.dto.LoginDTO;
import lk.betting.entity.Login;

/**
 *
 * @author Your Name <Ishan Randika>
 */
public class LoginBOImpl implements LoginBO {

    LoginDAO dao = (LoginDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.LOGIN);

    @Override
    public boolean login(LoginDTO login) throws SQLException, ClassNotFoundException, Exception {
        return dao.loginUser(new Login(login.getU_Email(),login.getPassword()));
    }

}
