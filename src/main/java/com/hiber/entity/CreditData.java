package com.hiber.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;




/*
CREATE TABLE  `homebudget`.`credit_data` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `credit_date` date NOT NULL,
  `credit` double NOT NULL,
  `description` varchar(100) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 * */
@Entity
@Table(name="credit_data")
public class CreditData {
	
	
	@Id
	@Column(name="ID")
	@GeneratedValue
	private int id;
	
	@Column(name="credit_date")
	private Date incomeDate;
	
	@Column(name="description")
	private String incomeDescription ;
	
	@Column(name="credit")
	private Double credit;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public Double getCredit() {
		return credit;
	}

	public void setCredit(Double credit) {
		this.credit = credit;
	}

	public Date getIncomeDate() {
		return incomeDate;
	}

	public void setIncomeDate(Date incomeDate) {
		this.incomeDate = incomeDate;
	}

	public String getIncomeDescription() {
		return incomeDescription;
	}

	public void setIncomeDescription(String incomeDescription) {
		this.incomeDescription = incomeDescription;
	}

	@Override
	public String toString() {
		return "CreditData [id=" + id + ", incomeDate=" + incomeDate + ", incomeDescription=" + incomeDescription
				+ ", credit=" + credit + "]";
	}

	
	
	
	
	
}
	