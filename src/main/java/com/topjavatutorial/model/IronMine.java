package com.topjavatutorial.model;

import javax.persistence.Entity;

@Entity
public class IronMine extends Mine {

  @Override
  public String getType() {
    // TODO Auto-generated method stub
    return "IRON";
  }

  @Override
  public int getNaturalExtraction() {
    // TODO Auto-generated method stub
    return 100;
  }

}
