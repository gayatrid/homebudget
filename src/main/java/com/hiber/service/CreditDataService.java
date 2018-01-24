package com.hiber.service;
 
import java.util.List;

import com.hiber.controller.SpendingForm;
import com.hiber.entity.CreditData;
import com.hiber.entity.Spending;
 
public interface CreditDataService {
	
	 public void addCreditData(SpendingForm spendingForm);
	    public List<CreditData> getAllCredits();
	    public void deleteCreditData(Integer id);
	    public CreditData getCreditData(Integer id);
	    
}