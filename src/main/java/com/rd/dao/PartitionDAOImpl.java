package com.rd.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rd.entity.Partition;

@Repository
public class PartitionDAOImpl implements PartitionDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Partition> getAllParition() {
		return this.sessionFactory.getCurrentSession().createQuery("from Partition").list();
	}
}