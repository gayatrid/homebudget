package com.hiber.service;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hiber.controller.SpendingForm;
import com.hiber.dao.SpendingDAO;
import com.hiber.dao.StoreDAO;
import com.hiber.entity.Spending;
import com.hiber.entity.Store;
 
 
@Service
public class StoreServiceImpl implements StoreService 
{
    @Autowired
    private StoreDAO storeDAO;

	@Override
	@Transactional
	public List<Store> getAllStore() {
		return storeDAO.getAllStore();
	}

	@Override
	@Transactional
	public Store getStore(Integer storeId) {
		return storeDAO.getStore(storeId);
	}
    
	@Override
	@Transactional
	public Store getStoreByName(String StoreName) {
		return storeDAO.getStoreByName(StoreName);
	}

	@Override
	@Transactional
	public void addStore(Store store) {
		storeDAO.addStore(store);
		
	}
    
   
}