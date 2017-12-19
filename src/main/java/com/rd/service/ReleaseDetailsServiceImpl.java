package com.rd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rd.controller.ReleaseDetailsForm;
import com.rd.dao.ReleaseDetailsDAO;
import com.rd.entity.Partition;
import com.rd.entity.ReleaseDetail;

@Service
public class ReleaseDetailsServiceImpl implements ReleaseDetailsService {
	@Autowired
	private ReleaseDetailsDAO releaseDetailsDAO;
	
	@Override
	@Transactional
	public void saveReleaseDetails(ReleaseDetail releaseDetail) {
		releaseDetailsDAO.saveReleaseDetails(releaseDetail);
	}
	
	@Override
	@Transactional
	public List<ReleaseDetail> getReleaseDetails() {
		return releaseDetailsDAO.getReleaseDetails();
	}
	
	@Override
	@Transactional
	public void deleteReleaseDetail(Integer releaseDetailId) {
		releaseDetailsDAO.deleteReleaseDetail(releaseDetailId);
	}
	
	@Override
	@Transactional
	public ReleaseDetail getReleaseDetail(Integer releaseDetailId) {
		return releaseDetailsDAO.getReleaseDetail(releaseDetailId);
	}
	
	@Override
	@Transactional
	public List<ReleaseDetail> searchReleaseDetail(ReleaseDetailsForm releaseDetailsForm) {
		return releaseDetailsDAO.searchReleaseDetail(releaseDetailsForm);
	}
	
	@Override
	@Transactional
	public List<Partition> getAllParition() {
		return releaseDetailsDAO.getAllParition();
	}
}