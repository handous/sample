package com.sample.dto;

import com.sample.domain.Equity;

public class EquityDto {

  private Long id;
  private String ticker;

  public EquityDto(){
    
  }

  public EquityDto(Equity equity){
    this.id = equity.getId();
    this.ticker = equity.getTicker();
  }
  
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTicker() {
    return ticker;
  }

  public void setTicker(String ticker) {
    this.ticker = ticker;
  }
  
  public Equity convert(){
    Equity equity = new Equity();
    equity.setId(id);
    equity.setTicker(ticker);
    return equity;
  }

}