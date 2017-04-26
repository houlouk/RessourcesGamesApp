package com.topjavatutorial.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Formula;

@Entity
public abstract class Mine {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  private Long id;

  @OneToOne(fetch = FetchType.LAZY, mappedBy = "mine", cascade = CascadeType.ALL)
  private Extractor extractor;

  public Extractor getExtractor() {
    return extractor;
  }

  public void setExtractor(Extractor extractor) {
    this.extractor = extractor;
  }

  public List<Extraction> getHistoryProductions() {
    return historyProductions;
  }

  @Formula("select sum(p) from historyProduction")
  private int extracted;

  @OneToMany
  private List<Extraction> historyProductions = new ArrayList<>();

  public abstract String getType();

  public abstract int getNaturalExtraction();

  public int getExtracted() {
    return extracted;
  }

  public void setExtracted(int extracted) {
    this.extracted = extracted;
  }

  public void extract(Extraction e) {
    e.setQuantity((int) (getNaturalExtraction() * getExtractor().getIncrease()));

    this.extracted += e.getQuantity();
    // TODO Auto-generated method stub

  }

}
