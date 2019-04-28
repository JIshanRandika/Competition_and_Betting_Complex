/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.betting.bo.custom.impl;

import java.sql.SQLException;
import javafx.collections.ObservableList;
import lk.betting.bo.custom.PlayersLevalsBO;
import lk.betting.dao.DAOFactory;
import lk.betting.dao.custom.PlayersLevalsDAO;
import lk.betting.dto.PlayersLevalsDTO;
import lk.betting.entity.PlayersLevals;

/**
 *
 * @author Your Name <Ishan Randika>
 */
public class PlayersLevalsBOImpl implements PlayersLevalsBO{
    PlayersLevalsDAO dao = (PlayersLevalsDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.PLAYERSLEVALS);

    @Override
    public ObservableList<String> fillcomboBox() throws Exception {
        return dao.fillcomboBox();
    }

//    @Override
//    public boolean savePlayersLevals(PlayersLevalsDTO ju) throws SQLException, ClassNotFoundException, Exception {
//        return dao.savePlayersLevals(new PlayersLevals(ju.getJuNIC(),ju.getC_ID(),ju.isLeval_01(),ju.isLeval_02(),ju.isLeval_03()));
//    }

    @Override
    public boolean savePlayersLevals(PlayersLevalsDTO ju) throws SQLException, ClassNotFoundException, Exception {
        return dao.savePlayersLevals(new PlayersLevals(ju.getPlNIC(),ju.getC_ID(),ju.isLeval_01(),ju.isLeval_02(),ju.isLeval_03()));
    }
    }
    

