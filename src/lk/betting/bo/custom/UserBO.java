/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.betting.bo.custom;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import lk.betting.bo.SuperBO;
import lk.betting.dto.UserDTO;
import lk.betting.tablemodal.UserTM;

/**
 *
 * @author Your Name <Ishan Randika>
 */
public interface UserBO extends SuperBO {

    public boolean registerUser(UserDTO user) throws SQLException, ClassNotFoundException, Exception;

    public boolean UpdateUser(UserDTO user) throws SQLException, ClassNotFoundException, Exception;

    public boolean removeUser(String userID) throws SQLException, ClassNotFoundException, Exception;

    public ArrayList<UserTM> getAllUsers() throws ClassNotFoundException, SQLException, Exception;

    public ResultSet getimage(String nic) throws ClassNotFoundException, SQLException, Exception;

}
