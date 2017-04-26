package com.topjavatutorial.model;

import javax.persistence.Entity;

@Entity
public class CopperMine extends Mine {

  @Override
  public String getType() {
    return "COPPER";
  }

  @Override
  public int getNaturalExtraction() {
    // TODO Auto-generated method stub
    return 30;
  }

}
