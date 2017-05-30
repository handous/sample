package com.sample.dto;

import java.util.Date;

import com.sample.domain.EquityValue;

public class EquityValueDto {

  private Long id;
  private Date date;
  private EquityDto equity;
  private Double bid;
  private Double mid;
  private Double ask;

  public EquityValueDto() {

  }

  public EquityValueDto(EquityValue equityValue) {
    this.id = equityValue.getId();
    this.date = equityValue.getDate();
    this.equity = new EquityDto(equityValue.getEquity());
    this.bid = equityValue.getBid();
    this.mid = equityValue.getMid();
    this.ask = equityValue.getAsk();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }
  
  public EquityDto getEquity() {
    return equity;
  }
  
  public void setEquity(EquityDto equity) {
    this.equity = equity;
  }

  public Double getBid() {
    return bid;
  }

  public void setBid(Double bid) {
    this.bid = bid;
  }

  public Double getMid() {
    return mid;
  }

  public void setMid(Double mid) {
    this.mid = mid;
  }

  public Double getAsk() {
    return ask;
  }

  public void setAsk(Double ask) {
    this.ask = ask;
  }

  public EquityValue convert() {
    EquityValue equityValue = new EquityValue();
    equityValue.setId(this.id);
    equityValue.setDate(this.date);
    equityValue.setEquity(this.equity.convert());
    equityValue.setBid(this.bid);
    equityValue.setMid(this.mid);
    equityValue.setAsk(this.ask);
    return equityValue;
  }
}