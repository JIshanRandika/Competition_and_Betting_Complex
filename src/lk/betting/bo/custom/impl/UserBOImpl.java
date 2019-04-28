/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.betting.bo.custom.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import lk.betting.bo.custom.UserBO;
import lk.betting.dao.DAOFactory;
import lk.betting.dao.custom.UserDAO;
import lk.betting.dto.UserDTO;
import lk.betting.entity.User;
import lk.betting.tablemodal.UserTM;

/**
 *
 * @author Your Name <Ishan Randika>
 */
public class UserBOImpl implements UserBO {

    UserDAO dao = (UserDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.USERS);

    @Override
    public boolean registerUser(UserDTO user) throws SQLException, ClassNotFoundException, Exception {
        System.out.println("BOImpl");
        System.out.println(user.getPassword());
        return dao.registerUser(new User(user.getUserID(), user.getU_Name(), user.getU_NIC(), user.getMobile_No(), user.getU_Email(), user.getU_Address(), user.getbOD(), user.getPassword(), user.getImage()));

    }

    @Override
    public boolean UpdateUser(UserDTO user) throws SQLException, ClassNotFoundException, Exception {
        return dao.UpdateUser(new User(user.getU_Name(), user.getU_NIC(), user.getMobile_No(), user.getU_Email(), user.getU_Address(), user.getImage(), user.getUserID()));

    }

    @Override
    public boolean removeUser(String userID) throws SQLException, ClassNotFoundException, Exception {
        return dao.removeUser(userID);
    }

    @Override
    public ArrayList<UserTM> getAllUsers() throws ClassNotFoundException, SQLException, Exception {
        ArrayList<UserTM> allUsers = new ArrayList<>();
        ArrayList<User> all = dao.getAll();
        for (User a : all) {
            allUsers.add(new UserTM(a.getUserID(), a.getU_Name(), a.getU_NIC(), a.getU_Address(), a.getbOD() + "", a.getMobile_No(), a.getU_Email()));
        }
        return allUsers;
    }

    @Override
    public ResultSet getimage(String nic) throws ClassNotFoundException, SQLException, Exception {
        return dao.getimage(nic);
    }

}
