package com.sample.dao;

import java.util.List;

import com.sample.domain.Equity;

public interface EquityDao {

  Equity save(Equity equity);

  List<Equity> findAll();

  int countAll();

  void delete(Long equityId);

  Equity getEquityById(Long equityId);
}