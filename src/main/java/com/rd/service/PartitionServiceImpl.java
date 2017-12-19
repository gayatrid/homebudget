package com.rd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rd.dao.PartitionDAO;
import com.rd.entity.Partition;

@Service
public class PartitionServiceImpl implements PartitionService {
	@Autowired
	private PartitionDAO partitionDAO;
	
	@Override
	@Transactional
	public List<Partition> getAllParition() {
		return partitionDAO.getAllParition();
	}
}