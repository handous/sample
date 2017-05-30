package com.sample.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity(name="equityValues")
@Table(name="equityValues")
public class EquityValue {

  private Long id;
  private Date date;
  private Equity equity;
  private Double bid;
  private Double mid;
  private Double ask;

  @Id
  @GenericGenerator(name = "increment", strategy = "increment")
  @GeneratedValue(generator = "increment")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Column
  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  @ManyToOne(targetEntity=Equity.class)
  @JoinColumn(name="equityId")
  public Equity getEquity() {
    return equity;
  }

  public void setEquity(Equity equity) {
    this.equity = equity;
  }

  @Column
  public Double getBid() {
    return bid;
  }

  public void setBid(Double bid) {
    this.bid = bid;
  }

  @Column
  public Double getMid() {
    return mid;
  }

  public void setMid(Double mid) {
    this.mid = mid;
  }

  @Column
  public Double getAsk() {
    return ask;
  }

  public void setAsk(Double ask) {
    this.ask = ask;
  }

}