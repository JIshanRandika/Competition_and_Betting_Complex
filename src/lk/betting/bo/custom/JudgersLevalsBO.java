/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.betting.bo.custom;

import java.sql.SQLException;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import static javafx.scene.input.KeyCode.T;
import lk.betting.bo.SuperBO;
import lk.betting.dto.JudgersLevalsDTO;

/**
 *
 * @author Your Name <Ishan Randika>
 */
public interface JudgersLevalsBO extends SuperBO {

    public ObservableList<String> fillcomboBox() throws Exception;

    public boolean saveJudgersLevals(JudgersLevalsDTO ju) throws SQLException, ClassNotFoundException, Exception;

}
