package com.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sample.dto.EquityDto;
import com.sample.service.EquityService;


@RestController
@RequestMapping("equity")
public class EquityController {
  @Autowired
  private EquityService equityService;
  
  
  @RequestMapping("/details/{equityId}")
  public EquityDto getEquityById(@PathVariable("equityId") Long equityId){
    return equityService.getEquityById(equityId);
  }
  
  @RequestMapping("/list")
  public List<EquityDto> getEquities(){
    return equityService.findAll();
  }
  
  @RequestMapping(value="/save", method = RequestMethod.POST)
  public EquityDto saveEquity(@RequestBody EquityDto equityDto){
    return equityService.save(equityDto);
  }
  
  @RequestMapping(value = "/update", method = RequestMethod.PUT)
  public EquityDto updateEquity(@RequestBody EquityDto equityDto){
    return equityService.save(equityDto);
  }
  
  @RequestMapping(value = "/delete/{equityId}", method = RequestMethod.DELETE)
  public void deleteEquity(@PathVariable("equityId") Long equityId){
    equityService.delete(equityId);
  }
}