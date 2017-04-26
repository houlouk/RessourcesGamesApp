package com.topjavatutorial.dao;

import com.topjavatutorial.model.Extraction;
import com.topjavatutorial.model.Mine;

public class MineDao extends HibernateDao<Mine> implements IMineDao {

  @Override
  public void addExtraction(int idMine, Extraction e) {
    this.get(idMine).getHistoryProductions().add(e);

  }

}
