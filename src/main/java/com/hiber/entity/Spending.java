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




/*
 * spending
(
    ID          INT PRIMARY KEY AUTO_INCREMENT,
    pay_date   date not null,
    description    VARCHAR(100) not null,
    price   double not null,
    bank_name     varchar (60)
 * */
@Entity
@Table(name="spending")
public class Spending {
	
	
	@Id
	@Column(name="ID")
	@GeneratedValue
	private int id;
	
	@Column(name="pay_date")
	private Date transactionDate;
	
	@Column(name="description")
	private String description ;
	
	@Column(name="price")
	private Double price;
	
	@Column(name="bank_name")
	private String bankName;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "store")
	private Store store;
	
	
	
	

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	@Override
	public String toString() {
		return "Spending [id=" + id + ", description=" + description + ", price=" + price + ", bankName=" + bankName
				+ ", pay_Date=" + transactionDate + "]";
	}
	
}
	