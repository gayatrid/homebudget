package com.hiber.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
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
	
	
	@Override
	public List<Spending> getIncomeAndexpenses(String monthlyRecord){
		
		String hql = "select SUM(s.price),SUM(CASE WHEN s.price < 0 THEN s.price ELSE 0 END),SUM(CASE WHEN s.price > 0 THEN s.price ELSE 0 END) "
				+ "from Spending s WHERE s.transactionDate LIKE '"+monthlyRecord+"%'";
		 
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		List<Object[]> listResult = query.list();
		List<Spending> spendings = new ArrayList<>();
		  Double totalSaving =null,expenses=null,income=null;;
		  
		  if(listResult!=null && listResult.size()>0){
			  for (Object[] aRow : listResult) {
				     totalSaving = (Double) aRow[0];
				    expenses = (Double) aRow[1];
				    income = (Double) aRow[2];
				}
				
				Spending spending = new Spending();
				spending.setTotalSaving(totalSaving);
				spending.setPrice(Math.abs(expenses));
				spending.setDescription("Expenses");
			    spendings.add(spending);
			    
			    Spending spending2 = new Spending();
				spending2.setTotalSaving(totalSaving);
				spending2.setPrice(income);
				spending2.setDescription("Income");
			    spendings.add(spending2);
			    
			    System.out.println("displaySpending"+spending2);
		  }
		
		return spendings;
		
	}
	
	
	@Override
	public List<Spending> spendingInStore(String monthlyRecord){
		String hql = "select SUM(CASE WHEN s.price < 0 THEN s.price ELSE 0 END),s.store from Spending s  group by s.store";
		 
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		List<Object[]> listResult = query.list();
		List<Spending> spendings = new ArrayList<>();
		 
		for (Object[] aRow : listResult) {
			Double price = (Double) aRow[0];
		    Store store = (Store) aRow[1];
		    Spending spending = new Spending();
		    spending.setPrice(Math.abs(price));
		    spending.setStore(store);
		    spendings.add(spending);
		    System.out.println("displaySpending to display totoal spendingInStore"+spending);
		}
		
		return spendings;
		
	/*	for (Object[] aRow : listResult) {
		    Double spending = (Double) aRow[0];
		    Store store = (Store)aRow[1];
		    System.out.println("store"+store+"-->"+spending +"Totoal spending in store");
		}	*/
	}
	
/*	SELECT SUM(price),SUM(CASE WHEN price < 0 THEN price ELSE 0 END) AS negative_values,
    SUM(CASE WHEN price > 0 THEN price ELSE 0 END) AS non_negative_values
 FROM spending; where pay_date LIKE  '2017-01%';

select SUM(price),store from spending group by store;*/

}