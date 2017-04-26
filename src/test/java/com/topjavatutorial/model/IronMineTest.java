package com.topjavatutorial.model;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class IronMineTest {

  @Test
  public void getNaturalExtraction() {
    Mine mine= new IronMine();
    assertEquals(mine.getNaturalExtraction(), 100);
  }

  @Test
  public void getType() {
    Mine mine= new IronMine();
    assertEquals(mine.getType(), "IRON");  }
}
