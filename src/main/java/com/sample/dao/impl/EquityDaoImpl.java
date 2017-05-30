package com.sample.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.sample.dao.EquityDao;
import com.sample.domain.Equity;

@Repository
public class EquityDaoImpl implements EquityDao{
  private HibernateTemplate template;

  @Autowired
  public void setSessionFactory(SessionFactory sessionFactory) {
    template = new HibernateTemplate(sessionFactory);
  }

  @Override
  public Equity save(Equity equity) {
    template.saveOrUpdate(equity);
    return equity;
  }

  @Override
  public List<Equity> findAll() {
    DetachedCriteria equityCriteria = DetachedCriteria.forClass(Equity.class);
    List equities = template.findByCriteria(equityCriteria);
    return equities;
  }

  @Override
  public int countAll() {
    DetachedCriteria equityCriteria = DetachedCriteria.forClass(Equity.class);
    equityCriteria.setProjection(Projections.projectionList().add(Projections.count("id")));
    return ((Long) DataAccessUtils.uniqueResult(template.findByCriteria(equityCriteria))).intValue();
  }

  @Override
  public void delete(Long equityId) {
    Session session = template.getSessionFactory().getCurrentSession();
    String hql = "delete from equity where id=?";
    template.bulkUpdate(hql, equityId);    
  }

  @Override
  public Equity getEquityById(Long equityId) {
    DetachedCriteria equityCriteria = DetachedCriteria.forClass(Equity.class);
    equityCriteria.add(Restrictions.eq("id", equityId));
    return (Equity) DataAccessUtils.uniqueResult(template.findByCriteria(equityCriteria));
  }
}