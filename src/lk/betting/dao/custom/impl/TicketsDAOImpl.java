/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.betting.dao.custom.impl;

import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.betting.dao.CrudUtil;
import lk.betting.dao.custom.TicketsDAO;
import lk.betting.entity.Tickets;

/**
 *
 * @author ASUS
 */
public class TicketsDAOImpl implements TicketsDAO {

    @Override
    public ObservableList<String> fillcomboBox() throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM competition ORDER BY C_ID DESC LIMIT 4");
        ObservableList<String> list = FXCollections.observableArrayList();
        while (rst.next()) {
            String name = rst.getString("C_ID");
            list.add(name);
        }
        return list;
    }

    @Override
    public boolean comfirmSeat(Tickets tickets) throws Exception {
        return CrudUtil.executeUpdate("insert into tickets values(?,?,?,?)", tickets.getS_ID(), tickets.getC_ID(), tickets.getSheat_No(), tickets.getTicket_No());
    }

    @Override
    public ResultSet getseat(String cid) throws Exception {
        return CrudUtil.executeQuery("select Sheat_No from tickets where C_ID=?", cid);
    }

}
