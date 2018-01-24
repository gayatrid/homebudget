package com.hiber.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hiber.controller.SpendingForm;
import com.hiber.dao.SpendingDAO;
import com.hiber.entity.Spending;
import com.hiber.entity.Store;

@Service
public class SpendingServiceImpl implements SpendingService {
	@Autowired
	private SpendingDAO spendingDAO;
	@Autowired
	private StoreService storeService;

	@Override
	@Transactional
	public void addSpending(SpendingForm spendingForm) {
		Spending spending = new Spending();
		Store store = storeService.getStore(spendingForm.getStoreId());
		spending.setStore(store);
		BeanUtils.copyProperties(spendingForm, spending);
		spendingDAO.addSpending(spending);
	}

	@Override
	@Transactional
	public void addSpendingFromFile(Spending spending) {
		spendingDAO.addSpending(spending);
	}

	@Override
	@Transactional
	public List<Spending> getAllSpending(String monthlyRecord) {
		return spendingDAO.getAllSpendings(monthlyRecord);
	}

	@Override
	@Transactional
	public void deleteSpending(Integer spendingId) {
		spendingDAO.deleteSpending(spendingId);
	}

	public void setSpendingDAO(SpendingDAO spendingDAO) {
		this.spendingDAO = spendingDAO;
	}

	@Override
	@Transactional
	public Spending getSpending(Integer spendingId) {
		return spendingDAO.getSpending(spendingId);
	}
}