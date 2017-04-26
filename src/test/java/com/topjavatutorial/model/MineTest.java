package com.topjavatutorial.model;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class MineTest {

  @Test
  public void extract() {
   Mine mine= new Mine() {
    
    @Override
    public String getType() {
      // TODO Auto-generated method stub
      return "TEST";
    }
    
    @Override
    public int getNaturalExtraction() {
      // TODO Auto-generated method stub
      return 50;
    }
  };
  
  mine.setExtractor(new Extractor() {
    
    @Override
    public double getIncrease() {
      // TODO Auto-generated method stub
      return 0.2;
    }
  });
  
  Extraction extraction = new Extraction();
  mine.extract(extraction);
  
  assertEquals(mine.getExtracted(),10);
  assertEquals(extraction.getQuantity(), 10);
  
  }

  
}
