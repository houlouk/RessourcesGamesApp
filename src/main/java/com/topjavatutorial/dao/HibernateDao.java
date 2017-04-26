package com.topjavatutorial.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;


public abstract class HibernateDao<T> implements Dao<T> {

  protected Class<T> classT;
  private EntityManager em;

  public HibernateDao() {
    this.em = EntityManagerUtil.getInstance().getEntityManagerFactory().createEntityManager();
    // TODO Auto-generated constructor stub
  }

  @Override
  public void add(T t) {

    em.getTransaction().begin();
    em.persist(t);
    em.getTransaction().commit();

  }

  @Override
  public int delete(int id) {
    T t = get(id);
    if (t == null) {
      return 0;
    }
    em.getTransaction().begin();
    em.remove(t);
    em.getTransaction().commit();
    return 1;
  }

  @Override
  public T get(int id) {
    return em.find(classT, id);

  }

  @Override
  public int update(int id, T t) {
    em.getTransaction().begin();
    T res = em.merge(t);
    em.getTransaction().commit();

    return res == null ? 0 : 1;

  }

  @Override
  public List<T> getAll() {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<T> cq = cb.createQuery(classT);
    return em.createQuery(cq.select(cq.from(classT))).getResultList();

  }

}
