/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.betting.bo.custom;

import java.sql.SQLException;
import javafx.collections.ObservableList;
import lk.betting.bo.SuperBO;
import lk.betting.dto.PlayersLevalsDTO;

/**
 *
 * @author Your Name <Ishan Randika>
 */
public interface PlayersLevalsBO extends SuperBO {
       public ObservableList<String> fillcomboBox() throws Exception;

    public boolean savePlayersLevals(PlayersLevalsDTO ju) throws SQLException, ClassNotFoundException, Exception;

}
