/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.betting.dao;

import lk.betting.dao.custom.impl.BettersLevalsDAOImpl;
import lk.betting.dao.custom.impl.CreateBetDAOImpl;
import lk.betting.dao.custom.impl.CreateCompetitionDAOImpl;
import lk.betting.dao.custom.impl.JudgersLevalsDAOImpl;
import lk.betting.dao.custom.impl.LoginDAOImpl;
import lk.betting.dao.custom.impl.PlayersLevalsDAOImpl;
import lk.betting.dao.custom.impl.QueryDAOImpl;
import lk.betting.dao.custom.impl.RegisterBettersDAOImpl;
import lk.betting.dao.custom.impl.RegisterJudgersDAOImpl;
import lk.betting.dao.custom.impl.RegisterPlayersDAOImpl;
import lk.betting.dao.custom.impl.SpectatorDAOImpl;
import lk.betting.dao.custom.impl.TicketsDAOImpl;
import lk.betting.dao.custom.impl.UserDAOImpl;
import lk.betting.dao.custom.impl.WinnersDAOImpl;

/**
 *
 * @author Your Name <Ishan Randika>
 */
public class DAOFactory {

    private static DAOFactory dAOFactory;

    public DAOFactory() {
    }

    public static DAOFactory getInstance() {
        if (dAOFactory == null) {
            dAOFactory = new DAOFactory();
        }
        return dAOFactory;
    }

    public enum DAOTypes {
        TICKETS, QUERY, CREATEBET, CREATECOMPETITION, JUDGERSLEVALS, BETTERSLEVALS, PLAYERSLEVALS, BET, LOGIN, REGISTERBETTERS, COMPETITION, REGISTERJUDGERS, REGISTERPLAYERS, PLAYERS, SPECTATOR, USERS, WINNERS
    }

    public SuperDAO getDAO(DAOTypes types) {
        switch (types) {
            case LOGIN:
                return new LoginDAOImpl();
            case REGISTERJUDGERS:
                return new RegisterJudgersDAOImpl();
            case REGISTERPLAYERS:
                return new RegisterPlayersDAOImpl();
            case REGISTERBETTERS:
                return new RegisterBettersDAOImpl();
            case SPECTATOR:
                return new SpectatorDAOImpl();
            case WINNERS:
                return new WinnersDAOImpl();
            case BETTERSLEVALS:
                return new BettersLevalsDAOImpl();
            case PLAYERSLEVALS:
                return new PlayersLevalsDAOImpl();
            case JUDGERSLEVALS:
                return new JudgersLevalsDAOImpl();
            case USERS:
                return new UserDAOImpl();
            case CREATECOMPETITION:
                return new CreateCompetitionDAOImpl();
            case CREATEBET:
                return new CreateBetDAOImpl();
            case TICKETS:
                return new TicketsDAOImpl();
            case QUERY:
                return new QueryDAOImpl();
            default:
                return null;
        }
    }
}
