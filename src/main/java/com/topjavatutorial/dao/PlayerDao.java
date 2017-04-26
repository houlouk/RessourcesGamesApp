package com.topjavatutorial.dao;

import com.topjavatutorial.model.Mine;
import com.topjavatutorial.model.Player;

public class PlayerDao extends HibernateDao<Player> implements IPlayerDao {

  public PlayerDao() {
    this.classT = Player.class;
    // TODO Auto-generated constructor stub
  }

  @Override
  public void addMine(int idPlayer, Mine m) {

    //this.get(idPlayer).getMines().add(m);
    
    throw new UnsupportedOperationException("not implemented");
  }

}
