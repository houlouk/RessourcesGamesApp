package com.topjavatutorial.dao;

import com.topjavatutorial.model.Extraction;
import com.topjavatutorial.model.Mine;

public interface IMineDao extends Dao<Mine> {

  void addExtraction(int id, Extraction e);

}
