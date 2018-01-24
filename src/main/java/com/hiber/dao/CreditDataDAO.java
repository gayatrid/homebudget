package com.hiber.dao;
 
import java.util.List;

import com.hiber.entity.CreditData;
 
public interface CreditDataDAO
{
    public void addCreditData(CreditData creditData);
    public List<CreditData> getAllCredits();
    public void deleteCreditData(Integer id);
    public CreditData getCreditData(Integer id);
   
}