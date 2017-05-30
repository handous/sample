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

import com.sample.dao.EquityValueDao;
import com.sample.domain.EquityValue;

@Repository
public class EquityValueDaoImpl implements EquityValueDao{
  private HibernateTemplate template;

  @Autowired
  public void setSessionFactory(SessionFactory sessionFactory) {
    template = new HibernateTemplate(sessionFactory);
  }

  @Override
  public EquityValue save(EquityValue equity) {
    template.saveOrUpdate(equity);
    return equity;
  }

  @Override
  public List<EquityValue> findByEquityId(Long equityId) {
    DetachedCriteria equityCriteria = DetachedCriteria.forClass(EquityValue.class);
    equityCriteria.add(Restrictions.eq("equity.id", equityId));
    List equityValues = template.findByCriteria(equityCriteria);
    return equityValues;
  }
  
  @Override
  public List<EquityValue> findAll() {
    DetachedCriteria equityCriteria = DetachedCriteria.forClass(EquityValue.class);
    List equityValues = template.findByCriteria(equityCriteria);
    return equityValues;
  }

  @Override
  public int countAll() {
    DetachedCriteria equityValuesCriteria = DetachedCriteria.forClass(EquityValue.class);
    equityValuesCriteria.setProjection(Projections.projectionList().add(Projections.count("id")));
    return ((Long) DataAccessUtils.uniqueResult(template.findByCriteria(equityValuesCriteria))).intValue();
  }

  @Override
  public void delete(Long equityValuesId) {
    Session session = template.getSessionFactory().getCurrentSession();
    String hql = "delete from equityValues where id=?";
    template.bulkUpdate(hql, equityValuesId);    
  }

  @Override
  public EquityValue getEquityValueById(Long equityValueId) {
    DetachedCriteria equityValuesCriteria = DetachedCriteria.forClass(EquityValue.class);
    equityValuesCriteria.add(Restrictions.eq("id", equityValueId));
    return (EquityValue) DataAccessUtils.uniqueResult(template.findByCriteria(equityValuesCriteria));
  }
}