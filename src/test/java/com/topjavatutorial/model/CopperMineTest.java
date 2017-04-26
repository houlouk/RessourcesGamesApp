package com.topjavatutorial.model;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class CopperMineTest {

  @Test
  public void getNaturalExtraction() {
     Mine mine=new CopperMine();
     assertEquals(mine.getNaturalExtraction(), 30);
  }

  @Test
  public void getType() {
    Mine mine=new CopperMine();
    assertEquals(mine.getNaturalExtraction(), "COPPER");  }
}
