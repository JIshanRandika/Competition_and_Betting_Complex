/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.betting.dao.custom;

import javafx.collections.ObservableList;
import lk.betting.dao.CrudDAO;
import lk.betting.entity.JudgersLevals;

/**
 *
 * @author Your Name <Ishan Randika>
 */
public interface JudgersLevalsDAO extends CrudDAO< JudgersLevals, String> {

    public ObservableList<String> fillcomboBox() throws Exception;

    public boolean saveJudgersLevals(JudgersLevals judgers) throws Exception;

}
