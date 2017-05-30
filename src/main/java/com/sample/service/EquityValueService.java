package com.sample.service;

import java.util.List;

import com.sample.dto.EquityValueDto;

public interface EquityValueService {

  EquityValueDto save(EquityValueDto equityDto);

  List<EquityValueDto> findAll();

  int countAll();

  void delete(Long equityValueId);

  EquityValueDto getEquityValueById(Long equityValueId);

  List<EquityValueDto> findByEquityId(Long equityId);
}