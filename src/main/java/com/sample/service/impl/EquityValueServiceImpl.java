package com.sample.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.dao.EquityValueDao;
import com.sample.domain.EquityValue;
import com.sample.dto.EquityValueDto;
import com.sample.service.EquityValueService;

@Service
public class EquityValueServiceImpl implements EquityValueService {

  @Autowired
  private EquityValueDao equityValueDao;

  @Override
  public EquityValueDto save(EquityValueDto equityValueDto) {
    EquityValue equityValue = equityValueDao.save(equityValueDto.convert());
    return new EquityValueDto(equityValue);
  }

  @Override
  public List<EquityValueDto> findByEquityId(Long equityId) {
    List<EquityValueDto> equities = new ArrayList<EquityValueDto>();
    List<EquityValue> list = equityValueDao.findByEquityId(equityId);
    for(EquityValue equityValue : list){
      equities.add(new EquityValueDto(equityValue));
    }
    return equities;
  }
  
  @Override
  public List<EquityValueDto> findAll() {
    List<EquityValueDto> equities = new ArrayList<EquityValueDto>();
    List<EquityValue> list = equityValueDao.findAll();
    for(EquityValue equityValue : list){
      equities.add(new EquityValueDto(equityValue));
    }
    return equities;
  }

  @Override
  public int countAll() {
    return equityValueDao.countAll();
  }

  @Override
  public void delete(Long equityValueId) {
    equityValueDao.delete(equityValueId);
  }

  @Override
  public EquityValueDto getEquityValueById(Long equityValueId) {
    EquityValue equityValue = equityValueDao.getEquityValueById(equityValueId);
    return new EquityValueDto(equityValue);
  }
}