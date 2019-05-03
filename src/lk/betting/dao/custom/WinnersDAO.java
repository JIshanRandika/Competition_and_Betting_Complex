/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.betting.dao.custom;

import java.sql.ResultSet;
import javafx.collections.ObservableList;
import lk.betting.dao.CrudDAO;
import lk.betting.entity.Winners;

/**
 *
 * @author Your Name <Ishan Randika>
 */
public interface WinnersDAO extends CrudDAO< Winners, String> {

    public ObservableList<String> fillcomboBox() throws Exception;

    public boolean saveWinners(Winners winners) throws Exception;

}
