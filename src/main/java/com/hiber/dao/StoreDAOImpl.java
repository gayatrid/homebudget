package com.hiber.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hiber.entity.Spending;
import com.hiber.entity.Store;

@Repository
public class StoreDAOImpl implements StoreDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Store> getAllStore() {
		return this.sessionFactory.getCurrentSession().createQuery("from Store").list();
	}

	@Override
	public Store getStore(Integer storeId) {
		return (Store) this.sessionFactory.getCurrentSession().get(Store.class, storeId);
	}

	@Override
	public Store getStoreByName(String storeName) {
		Query query = this.sessionFactory.getCurrentSession().createQuery("from Store where storeName = :code ");
		query.setParameter("code",storeName);
		List<Store> list = query.list();
		Store store=null;
		if(list!=null&& list.size()>0){
			store =(Store)list.get(0);
		}
		return store ;
	}

	@Override
	public void addStore(Store store) {
		this.sessionFactory.getCurrentSession().saveOrUpdate(store);
		
	}
}