package com.hiber.dao;

import java.sql.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hiber.entity.Spending;
import com.hiber.entity.Store;

@Repository
public class SpendingDAOImpl implements SpendingDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addSpending(Spending spending) {
		this.sessionFactory.getCurrentSession().saveOrUpdate(spending);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Spending> getAllSpendings(String monthlyRecord) {
		return this.sessionFactory.getCurrentSession().createQuery("from Spending  spending WHERE spending.transactionDate LIKE '"+monthlyRecord+"%'").list();
	}

	@Override
	public void deleteSpending(Integer spendingId) {
		Spending spending = (Spending) sessionFactory.getCurrentSession().load(Spending.class, spendingId);
		if (null != spending) {
			this.sessionFactory.getCurrentSession().delete(spending);
		}
	}

	@Override
	public Spending getSpending(Integer spendingId) {
		return (Spending) this.sessionFactory.getCurrentSession().get(Spending.class, spendingId);
	}

}