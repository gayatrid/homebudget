package com.rd.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rd.controller.ReleaseDetailsForm;
import com.rd.entity.Partition;
import com.rd.entity.ReleaseDetail;

@Repository
public class ReleaseDetailsDAOImpl implements ReleaseDetailsDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public void saveReleaseDetails(ReleaseDetail releaseDetail) {
		Session session = sessionFactory.getCurrentSession();
		// Transaction tx = session.beginTransaction();
		// tx.begin();
		session.saveOrUpdate(releaseDetail);
		// tx.commit();
		System.out.println(releaseDetail.getId() + "--------------------------");
	}
	
	@Override
	public List<ReleaseDetail> getReleaseDetails() {
		return this.sessionFactory.getCurrentSession().createQuery("from ReleaseDetail").list();
	}
	
	@Override
	public void deleteReleaseDetail(Integer releaseDetailId) {
		ReleaseDetail releaseDetail = (ReleaseDetail) sessionFactory.getCurrentSession().load(ReleaseDetail.class,
				releaseDetailId);
		if (null != releaseDetail) {
			this.sessionFactory.getCurrentSession().delete(releaseDetail);
		}
	}
	
	@Override
	public ReleaseDetail getReleaseDetail(Integer releaseDetailId) {
		return (ReleaseDetail) this.sessionFactory.getCurrentSession().get(ReleaseDetail.class, releaseDetailId);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<ReleaseDetail> searchReleaseDetail(ReleaseDetailsForm releaseDetailsForm) {
		Criteria cr = this.sessionFactory.getCurrentSession().createCriteria(ReleaseDetail.class);
		// long startTimeCriteria = System.nanoTime();
		System.out.println("releaseDetailsForm.getTicketNumber()" + releaseDetailsForm.getTicketNumber());
		System.out.println("releaseDetailsForm.getFromDate()" + releaseDetailsForm.getFromDate());
		System.out.println("releaseDetailsForm.getToDate()" + releaseDetailsForm.getToDate());
		Criterion ticketNumber = Restrictions.eq("ticketNumber", releaseDetailsForm.getTicketNumber());
		Criterion releaseDate = Restrictions.between("releaseDate", releaseDetailsForm.getFromDate(),
				releaseDetailsForm.getToDate());
		LogicalExpression orExp = Restrictions.or(ticketNumber, releaseDate);
		cr.add(orExp);
		System.out.println("Done..........");
		return cr.list();
	}
	
	@Override
	public List<Partition> getAllParition() {
		return this.sessionFactory.getCurrentSession().createQuery("from Partition").list();
	}
}