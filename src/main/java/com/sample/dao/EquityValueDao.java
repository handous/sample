package com.sample.dao;

import java.util.List;

import com.sample.domain.EquityValue;

public interface EquityValueDao {

  EquityValue save(EquityValue equity);

  List<EquityValue> findAll();

  int countAll();

  void delete(Long equityValueId);

  EquityValue getEquityValueById(Long equityValueId);

  List<EquityValue> findByEquityId(Long equityId);
}