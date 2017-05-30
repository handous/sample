package com.sample.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.dao.EquityDao;
import com.sample.domain.Equity;
import com.sample.dto.EquityDto;
import com.sample.service.EquityService;


@Service
public class EquityServiceImpl implements EquityService{

  @Autowired
  private EquityDao equityDao;

  @Override
  public EquityDto save(EquityDto equityDto) {
    Equity equity = equityDao.save(equityDto.convert());
    return new EquityDto(equity);
  }

  @Override
  public List<EquityDto> findAll() {
    List<EquityDto> equities = new ArrayList<EquityDto>();
    List<Equity> list = equityDao.findAll();
    for(Equity equity : list){
      equities.add(new EquityDto(equity));
    }
    return equities;
  }

  @Override
  public int countAll() {
    return equityDao.countAll();
  }

  @Override
  public void delete(Long equityId) {
    equityDao.delete(equityId);
  }

  @Override
  public EquityDto getEquityById(Long equityId) {
    Equity equity = equityDao.getEquityById(equityId);
    return new EquityDto(equity);
  }
}
