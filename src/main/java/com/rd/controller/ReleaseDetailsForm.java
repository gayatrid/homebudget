package com.rd.controller;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class ReleaseDetailsForm {
	private Integer ticketNumber;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fromDate;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date toDate;

	public Integer getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(Integer ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

}
