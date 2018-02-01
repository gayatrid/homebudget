package com.hiber.dao;

import java.util.List;

import com.hiber.entity.Spending;

public interface SpendingDAO {
	public void addSpending(Spending Spending);

	public List<Spending> getAllSpendings(String monthlyRecord);

	public void deleteSpending(Integer SpendingId);

	public Spending getSpending(Integer SpendingId);

	public List<Spending> getIncomeAndexpenses(String monthlyRecord);
	
	public List<Spending> spendingInStore(String monthlyRecord);

}