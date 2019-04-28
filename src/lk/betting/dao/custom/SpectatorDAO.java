/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.betting.dao.custom;

import lk.betting.dao.CrudDAO;
import lk.betting.entity.Spectator;

/**
 *
 * @author Your Name <Ishan Randika>
 */
public interface SpectatorDAO extends CrudDAO<Spectator, String>{
    
        public boolean registerSpectator(Spectator spectator) throws Exception;

}
