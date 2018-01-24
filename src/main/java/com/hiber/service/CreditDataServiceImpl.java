package com.hiber.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hiber.controller.SpendingForm;
import com.hiber.dao.CreditDataDAO;
import com.hiber.entity.CreditData;

@Service
public class CreditDataServiceImpl implements CreditDataService {
	@Autowired
	private CreditDataDAO creditDataDAO;

	@Override
	@Transactional
	public void addCreditData(SpendingForm spendingForm) {
		CreditData creditData = new CreditData();
		BeanUtils.copyProperties(spendingForm,creditData);
		creditDataDAO.addCreditData(creditData);
	}

	@Override
	@Transactional
	public List<CreditData> getAllCredits() {
		return creditDataDAO.getAllCredits();
	}

	@Override
	@Transactional
	public void deleteCreditData(Integer id) {
		creditDataDAO.deleteCreditData(id);
	}

	@Override
	@Transactional
	public CreditData getCreditData(Integer id) {
		return creditDataDAO.getCreditData(id);
	}

	public void setCreditDataDAO(CreditDataDAO creditDataDAO) {
		this.creditDataDAO = creditDataDAO;
	}
	
	
}