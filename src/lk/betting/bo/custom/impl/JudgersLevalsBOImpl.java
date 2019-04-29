/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.betting.bo.custom.impl;

import java.sql.SQLException;
import javafx.collections.ObservableList;
import lk.betting.bo.custom.JudgersLevalsBO;
import lk.betting.dao.DAOFactory;
import lk.betting.dao.custom.JudgersLevalsDAO;
import lk.betting.dto.JudgersLevalsDTO;
import lk.betting.entity.JudgersLevals;

/**
 *
 * @author Your Name <Ishan Randika>
 */
public class JudgersLevalsBOImpl implements JudgersLevalsBO {

    JudgersLevalsDAO dao = (JudgersLevalsDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.JUDGERSLEVALS);

    @Override
    public ObservableList<String> fillcomboBox() throws Exception {
        return dao.fillcomboBox();
    }

    @Override
    public boolean saveJudgersLevals(JudgersLevalsDTO ju) throws SQLException, ClassNotFoundException, Exception {
        return dao.saveJudgersLevals(new JudgersLevals(ju.getJuNIC(), ju.getC_ID(), ju.isLeval_01(), ju.isLeval_02(), ju.isLeval_03()));
    }

}
