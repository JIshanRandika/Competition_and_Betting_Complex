/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.betting.bo.custom.impl;

import java.sql.SQLException;
import lk.betting.bo.custom.CreateCompetitionBO;
import lk.betting.dao.DAOFactory;
import lk.betting.dao.custom.CreateCompetitionDAO;
import lk.betting.dto.CreateCompetitionDTO;
import lk.betting.entity.CreateCompetition;

/**
 *
 * @author Your Name <Ishan Randika>
 */
public class CreateCompetitionBOImpl implements CreateCompetitionBO {

    CreateCompetitionDAO dao = (CreateCompetitionDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CREATECOMPETITION);

    @Override
    public boolean createCompetition(CreateCompetitionDTO crcom) throws SQLException, ClassNotFoundException, Exception {
        return dao.createCompetition(new CreateCompetition(crcom.getCompetitionID(),crcom.getCompetitionDate(),crcom.getCompetitionTime(),crcom.getPoolNo(),crcom.getTracks()));
    }

}
