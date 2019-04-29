/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.betting.dao.custom;

import lk.betting.dao.CrudDAO;
import lk.betting.entity.Login;

/**
 *
 * @author Your Name <Ishan Randika>
 */
public interface LoginDAO extends CrudDAO<Login, String> {

    public boolean loginUser(Login login) throws Exception;

}
