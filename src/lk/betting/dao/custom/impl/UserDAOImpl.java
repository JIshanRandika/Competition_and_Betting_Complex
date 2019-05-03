
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.betting.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.betting.dao.CrudUtil;
import lk.betting.dao.custom.UserDAO;
import lk.betting.entity.User;

/**
 *
 * @author Your Name <Ishan Randika>
 */
public class UserDAOImpl implements UserDAO {

    @Override
    public boolean registerUser(User user) throws Exception {
        return CrudUtil.executeUpdate("insert into users values(?,?,?,?,?,?,?,MD5(?),?)", user.getUserID(), user.getU_Name(), user.getU_NIC(), user.getMobile_No(), user.getU_Email(), user.getU_Address(), user.getbOD(), user.getPassword(), user.getImage());
    }

    @Override
    public boolean UpdateUser(User user) throws Exception {
        return CrudUtil.executeUpdate("update users set U_Name=?, U_NIC=? ,Mobile_No=? ,U_Email=?, U_Address=?,image=?  where userID=?", user.getU_Name(), user.getU_NIC(), user.getMobile_No(), user.getU_Email(), user.getU_Address(), user.getImage(), user.getUserID());

    }

    @Override
    public boolean removeUser(String userID) throws Exception {
        return CrudUtil.executeUpdate("delete from users where userID=?", userID);
    }

    @Override
    public ArrayList<User> getAll() throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT*FROM users");
        ArrayList<User> allUsers = new ArrayList<>();
        while (rst.next()) {
            User user = new User(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6), rst.getDate(7), "", "", "");
            allUsers.add(user);
        }
        return allUsers;
    }

    @Override
    public ResultSet getimage(String nic) throws Exception {
        return CrudUtil.executeQuery("select image from users where U_NIC=?", nic);
    }
}
