package com.topjavatutorial.model;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class ExtractorLevel1Test {

  @Test
  public void getIncrease() {
    Extractor extractorLevel1 = new ExtractorLevel1();
    assertEquals(extractorLevel1.getIncrease(), 0.5);
  }
}
