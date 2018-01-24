package com.hiber.service;
 
import java.util.List;

import com.hiber.controller.SpendingForm;
import com.hiber.entity.Spending;
import com.hiber.entity.Store;
 
public interface StoreService {
	 public void addStore(Store store);
    public List<Store> getAllStore();
    public Store getStore(Integer storeId);
    public Store getStoreByName(String StoreName);
}