/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.betting.bo.custom;

import java.sql.SQLException;
import lk.betting.bo.SuperBO;
import lk.betting.dto.LoginDTO;
import lk.betting.entity.Login;

/**
 *
 * @author Your Name <Ishan Randika>
 */
public interface LoginBO extends SuperBO{
            public boolean login(LoginDTO login) throws SQLException, ClassNotFoundException, Exception;

}
