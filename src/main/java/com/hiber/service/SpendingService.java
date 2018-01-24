package com.hiber.service;

import java.util.List;

import com.hiber.controller.SpendingForm;
import com.hiber.entity.Spending;

public interface SpendingService {
	public void addSpending(SpendingForm spendingForm);

	public List<Spending> getAllSpending(String monthlyRecord);

	public void deleteSpending(Integer spendingId);

	public Spending getSpending(Integer spendingId);

	public void addSpendingFromFile(Spending spending);
}