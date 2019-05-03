/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.betting.bo.custom.impl;

import java.sql.SQLException;
import lk.betting.bo.custom.RegisterJudgersBO;
import lk.betting.dao.DAOFactory;
import lk.betting.dao.custom.RegisterJudgersDAO;
import lk.betting.dto.JudgersDTO;
import lk.betting.entity.Judgers;

/**
 *
 * @author Your Name <Ishan Randika>
 */
public class RegisterJudgersBOImpl implements RegisterJudgersBO {

    RegisterJudgersDAO dao = (RegisterJudgersDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.REGISTERJUDGERS);

    @Override
    public boolean registerJudgers(JudgersDTO ju) throws SQLException, ClassNotFoundException, Exception {

        return dao.registerJudgers(new Judgers(ju.getJuNIC(), ju.getJuName(), ju.getJuMobile(), ju.getJuEmail()));

    }

    @Override
    public JudgersDTO searchJu(String juNIC) throws SQLException, ClassNotFoundException, Exception {
        Judgers search = dao.search(juNIC);
        return new JudgersDTO(search.getJuNIC(), search.getJuName(), search.getJuMobile(), search.getJuEmail());    }

    @Override
    public boolean UpdateJudgers(JudgersDTO judgers) throws SQLException, ClassNotFoundException, Exception {
        return dao.UpdateJudgers(new Judgers(judgers.getJuNIC(), judgers.getJuName(), judgers.getJuMobile(), judgers.getJuEmail()));
    }

}
