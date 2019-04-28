/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.betting.dao.custom;

import java.sql.ResultSet;
import javafx.collections.ObservableList;
import lk.betting.dao.CrudDAO;
import lk.betting.entity.Tickets;

/**
 *
 * @author ASUS
 */
public interface TicketsDAO extends CrudDAO<Tickets, String> {
          public ObservableList<String> fillcomboBox() throws Exception;

    public boolean comfirmSeat(Tickets tickets) throws Exception;

    public ResultSet getseat(String cid) throws Exception;

}
