package com.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sample.dto.EquityValueDto;
import com.sample.service.EquityValueService;


@RestController
@RequestMapping("/equityValues")
public class EquityValueController {
  
  @Autowired
  private EquityValueService equityValueService;
  
  @RequestMapping("/{equityId}")
  @ResponseBody
  public List<EquityValueDto> getEquityValues(@PathVariable("equityId") Long equityId){
    return equityValueService.findByEquityId(equityId);
  }
  
  @RequestMapping("/list")
  public List<EquityValueDto> getEquityValues(){
    return equityValueService.findAll();
  }
  
  @RequestMapping(value = "/save", method = RequestMethod.POST)
  public EquityValueDto saveEquityValue(@RequestBody EquityValueDto equityValueDto){
    return equityValueService.save(equityValueDto);
  }
  
  @RequestMapping(value = "/update", method = RequestMethod.PUT)
  public EquityValueDto updateEquityValue(EquityValueDto equityValueDto){
    return equityValueService.save(equityValueDto);
  }
  
  @RequestMapping(value = "/delete/{equityValueId}", method = RequestMethod.DELETE)
  public void deleteEquityValue(@PathVariable("equityValueId") Long equityValueId){
    equityValueService.delete(equityValueId);
  }
}