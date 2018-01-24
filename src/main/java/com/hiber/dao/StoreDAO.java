package com.hiber.dao;
 
import java.util.List;

import com.hiber.entity.Spending;
import com.hiber.entity.Store;
 
public interface StoreDAO
{
	public void addStore(Store store);
    public List<Store> getAllStore();
    public Store getStore(Integer storeId);
    public Store getStoreByName(String storeName);
}