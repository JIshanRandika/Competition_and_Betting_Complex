/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.betting.bo;

import lk.betting.bo.custom.impl.BettersLevalsBOImpl;
import lk.betting.bo.custom.impl.CreateBetBOImpl;
import lk.betting.bo.custom.impl.CreateCompetitionBOImpl;
import lk.betting.bo.custom.impl.JudgersLevalsBOImpl;
import lk.betting.bo.custom.impl.LoginBOImpl;
import lk.betting.bo.custom.impl.PlayersLevalsBOImpl;
import lk.betting.bo.custom.impl.RegisterBettersBOImpl;
import lk.betting.bo.custom.impl.RegisterJudgersBOImpl;
import lk.betting.bo.custom.impl.RegisterPlayersBOImpl;
import lk.betting.bo.custom.impl.SpectatorBOImpl;
import lk.betting.bo.custom.impl.TicketsBOImpl;
import lk.betting.bo.custom.impl.UserBOImpl;
import lk.betting.bo.custom.impl.WinnersBOImpl;

/**
 *
 * @author Your Name <Ishan Randika>
 */
public class BOFactory {

    private static BOFactory boFactory;

    private BOFactory() {
    }

    public static BOFactory getInstace() {
        if (boFactory == null) {
            boFactory = new BOFactory();
        }
        return boFactory;
    }

    public enum BOTypes {
        TICKETS, CREATEBET, CREATECOMPETITION, USERS, WINNERS, BETTERSLEVALS, LOGIN, PURCHASE, REGISTERJUDGERS, REGISTERPLAYERS, SPECTATOR, REGISTERBETTERS, PLAYERSLEVALS, JUDGERSLEVALS;
    }

    public SuperBO getBO(BOTypes types) {
        switch (types) {
            case USERS:
                return new UserBOImpl();
            case LOGIN:
                return new LoginBOImpl();
            case REGISTERJUDGERS:
                return new RegisterJudgersBOImpl();
            case REGISTERPLAYERS:
                return new RegisterPlayersBOImpl();
            case REGISTERBETTERS:
                return new RegisterBettersBOImpl();
            case SPECTATOR:
                return new SpectatorBOImpl();
            case JUDGERSLEVALS:
                return new JudgersLevalsBOImpl();
            case PLAYERSLEVALS:
                return new PlayersLevalsBOImpl();
            case BETTERSLEVALS:
                return new BettersLevalsBOImpl();
            case WINNERS:
                return new WinnersBOImpl();
            case CREATECOMPETITION:
                return new CreateCompetitionBOImpl();
            case CREATEBET:
                return new CreateBetBOImpl();
            case TICKETS:
                return new TicketsBOImpl();
            default:
                return null;
        }
    }

}
