package com.hiber.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hiber.entity.CreditData;

@Repository
public class CreditDataDAOImpl implements CreditDataDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addCreditData(CreditData creditData) {
		this.sessionFactory.getCurrentSession().saveOrUpdate(creditData);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CreditData> getAllCredits() {
		return this.sessionFactory.getCurrentSession().createQuery("from CreditData").list();
	}

	@Override
	public void deleteCreditData(Integer id) {
		CreditData creditData = (CreditData) sessionFactory.getCurrentSession().load(CreditData.class, id);
		if (null != creditData) {
			this.sessionFactory.getCurrentSession().delete(creditData);
		}
	}

	@Override
	public CreditData getCreditData(Integer id) {
		return (CreditData) this.sessionFactory.getCurrentSession().get(CreditData.class, id);
	}

}