/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.betting.bo.custom.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.ObservableList;
import lk.betting.bo.custom.TicketsBO;
import lk.betting.dao.DAOFactory;
import lk.betting.dao.custom.TicketsDAO;
import lk.betting.dto.TicketsDTO;
import lk.betting.entity.Spectator;
import lk.betting.entity.Tickets;

/**
 *
 * @author ASUS
 */
public class TicketsBOImpl implements TicketsBO {

    TicketsDAO dao = (TicketsDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.TICKETS);

    @Override
    public ObservableList<String> fillcomboBox() throws Exception {
        return dao.fillcomboBox();
    }

    @Override
    public boolean comfirmSeat(TicketsDTO ti) throws SQLException, ClassNotFoundException, Exception {
        return dao.comfirmSeat(new Tickets(ti.getS_ID(), ti.getC_ID(), ti.getSheat_No(), ti.getTicket_No()));
    }

    @Override
    public ResultSet getseat(String cid) throws ClassNotFoundException, SQLException, Exception {
        return dao.getseat(cid);
    }

}
