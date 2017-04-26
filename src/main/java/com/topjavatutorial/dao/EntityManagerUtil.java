package com.topjavatutorial.dao;

import java.util.Date;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {
  private static final String DB_PU = "RessourcesPU";

  public static final boolean DEBUG = true;

  private static final EntityManagerUtil singleton = new EntityManagerUtil();

  private EntityManagerFactory emf;

  private EntityManagerUtil() {
    // TODO Auto-generated constructor stub
  }

  public static EntityManagerUtil getInstance() {
    return singleton;
  }

  public EntityManagerFactory getEntityManagerFactory() {
    if (emf == null) {
      emf = Persistence.createEntityManagerFactory(DB_PU);
    }
    if (DEBUG) {
      System.out.println("factory created on: " + new Date());
    }
    return emf;
  }

  public void closeEmf() {
    if (emf.isOpen() || emf != null) {
      emf.close();
    }
    emf = null;
    if (DEBUG) {
      System.out.println("EMF closed at: " + new Date());
    }
  }

}
