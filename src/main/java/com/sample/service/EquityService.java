package com.sample.service;

import java.util.List;

import com.sample.dto.EquityDto;


public interface EquityService {

  EquityDto save(EquityDto equityDto);

  List<EquityDto> findAll();

  int countAll();

  void delete(Long equityId);

  EquityDto getEquityById(Long equityId);
}