package com.topjavatutorial.dao;

import com.topjavatutorial.model.Mine;
import com.topjavatutorial.model.Player;

public interface IPlayerDao extends Dao<Player> {

  public void addMine(int idPlayer, Mine m);

}
