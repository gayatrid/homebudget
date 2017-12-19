package com.rd.service;

import java.util.List;

import com.rd.controller.ReleaseDetailsForm;
import com.rd.entity.Partition;
import com.rd.entity.ReleaseDetail;

public interface ReleaseDetailsService {
	public void saveReleaseDetails(ReleaseDetail releaseDetail);
	
	public List<ReleaseDetail> getReleaseDetails();
	
	public void deleteReleaseDetail(Integer releaseDetailId);
	
	public ReleaseDetail getReleaseDetail(Integer releaseDetailId);
	
	public List<ReleaseDetail> searchReleaseDetail(ReleaseDetailsForm releaseDetailsForm);
	
	public List<Partition> getAllParition();
}
