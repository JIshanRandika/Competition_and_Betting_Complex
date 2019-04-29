/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.betting.dao.custom;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.betting.dao.CrudDAO;
import lk.betting.entity.User;

/**
 *
 * @author Your Name <Ishan Randika>
 */
public interface UserDAO extends CrudDAO<User, String> {

    public boolean registerUser(User user) throws Exception;

    public boolean UpdateUser(User user) throws Exception;

    public boolean removeUser(String userID) throws Exception;

    public ArrayList<User> getAll() throws Exception;

    public ResultSet getimage(String nic) throws Exception;
}
