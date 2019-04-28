/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.betting.bo.custom;

import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.ObservableList;
import lk.betting.bo.SuperBO;
import lk.betting.dto.TicketsDTO;

/**
 *
 * @author ASUS
 */
public interface TicketsBO extends SuperBO{

    public ObservableList<String> fillcomboBox() throws Exception;


    public boolean comfirmSeat(TicketsDTO ti) throws SQLException, ClassNotFoundException, Exception;

    public ResultSet getseat(String cid) throws ClassNotFoundException, SQLException, Exception;
    
}
