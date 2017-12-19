package com.rd.controller;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rd.entity.CronJob;
import com.rd.entity.DataSourceObject;
import com.rd.entity.Deployment;
import com.rd.entity.FTPAdapterObject;
import com.rd.entity.JMSObject;
import com.rd.entity.MDSObject;
import com.rd.entity.ReleaseDetail;
import com.rd.service.PartitionService;
import com.rd.service.ReleaseDetailsService;

@Controller
public class ReleaseDetailsController {
	@Autowired
	ReleaseDetailsService releaseDetailsService;
	@Autowired
	PartitionService partitionService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String releaseDetails(ModelMap map) {
		return "releaseDetails";
	}
	
	@RequestMapping(value = "/viewReleaseDetails", method = RequestMethod.GET)
	public String viewReleaseDetails(ModelMap map) {
		map.addAttribute("releaseDetailsForm", new ReleaseDetailsForm());
		return "searchReleaseDetails";
	}
	
	@RequestMapping(value = "/addRD", method = RequestMethod.GET)
	public String addRD(ModelMap map) {
		map.addAttribute("paritionList", partitionService.getAllParition());
		System.out.println("releaseDetailsService.getAllParition()" + releaseDetailsService.getAllParition());
		return "addReleaseDetails";
	}
	
	@RequestMapping(value = "/searchReleaseDetails", method = RequestMethod.POST)
	public String searchRD(ReleaseDetailsForm releaseDetailsForm, ModelMap map) {
		map.addAttribute("releaseDetails", releaseDetailsService.searchReleaseDetail(releaseDetailsForm));
		return "searchReleaseDetails";
	}
	
	@RequestMapping(value = "/editReleaseDetails", method = RequestMethod.GET)
	public String editReleaseDetails(@RequestParam Integer releaseDetailsId, Model model) throws IOException {
		System.out.println("I am here now releaseDetailsId" + releaseDetailsId);
		ReleaseDetail releaseDetail = releaseDetailsService.getReleaseDetail(releaseDetailsId);
		model.addAttribute("releaseDetail", releaseDetail);
		return "viewReleaseDetails";
	}
	
	@Consumes(MediaType.APPLICATION_JSON)
	@RequestMapping(value = "/saveReleaseData", method = RequestMethod.POST)
	public @ResponseBody String saveReleaseData(@RequestBody ReleaseDetail releaseDetail) {
		System.out.println("getTicketType---->Date " + releaseDetail.getTicketType());
		System.out.println("getTicketNumber---->" + releaseDetail.getTicketNumber());
		System.out.println("getReleaseDate---->" + releaseDetail.getReleaseDate());
		System.out.println("getReleaseDescription---->" + releaseDetail.getReleaseDescription());
		System.out.println("getDeployments---->" + releaseDetail.getDeployments());
		System.out.println("getJmsObjects---->" + releaseDetail.getJmsObjects());
		System.out.println("getDataSourceObjects---->" + releaseDetail.getDataSourceObjects());
		System.out.println("getFtpAdapterObjectPs---->" + releaseDetail.getFtpAdapterObject());
		System.out.println("getMdsObjects---->" + releaseDetail.getMdsObjects());
		System.out.println("getCronJobs---->" + releaseDetail.getCronJobs());
		// Has to change. if (releaseDetail != null) { if
		if (releaseDetail.getDeployments() != null) {
			for (Deployment deployment : releaseDetail.getDeployments()) {
				System.out.println(deployment.getCompositeName());
				System.out.println(deployment.getPartition());
				deployment.setReleaseDetail(releaseDetail);
				System.out.println(deployment.getReleaseDetail());
			}
		}
		System.out.println("-----------------------dataSourceObject------------------------");
		if (releaseDetail != null) {
			if (releaseDetail.getDataSourceObjects() != null) {
				for (DataSourceObject dataSourceObject : releaseDetail.getDataSourceObjects()) {
					System.out.println(dataSourceObject.getDataBaseHost());
					System.out.println(dataSourceObject.getDataSourceJNDI());
					dataSourceObject.setReleaseDetail(releaseDetail);
				}
			}
		}
		System.out.println("----------------jmsObject-------------------------------");
		if (releaseDetail != null) {
			if (releaseDetail.getJmsObjects() != null) {
				for (JMSObject jmsObject : releaseDetail.getJmsObjects()) {
					System.out.println(jmsObject.getJmsName());
					System.out.println(jmsObject.getJmsType());
					System.out.println(jmsObject.getJndiName());
					System.out.println(jmsObject.getSubDeployment());
					System.out.println("cccccccccc" + jmsObject.getConnectionFactory());
					jmsObject.setReleaseDetail(releaseDetail);
				}
			}
		}
		System.out.println("--------------------ftpAdapter---------------------------");
		if (releaseDetail != null) {
			if (releaseDetail.getFtpAdapterObject() != null) {
				for (FTPAdapterObject ftpAdapter : releaseDetail.getFtpAdapterObject()) {
					System.out.println(ftpAdapter.getFtpCFI());
					System.out.println(ftpAdapter.getHost());
					ftpAdapter.setReleaseDetail(releaseDetail);
				}
			}
		}
		System.out.println("----------------------mdsObject-------------------------");
		if (releaseDetail != null) {
			if (releaseDetail.getMdsObjects() != null) {
				for (MDSObject mdsObject : releaseDetail.getMdsObjects()) {
					System.out.println(mdsObject.getServerLocation());
					System.out.println(mdsObject.getTarget());
					mdsObject.setReleaseDetail(releaseDetail);
				}
			}
		}
		System.out.println("-------------------cronJob----------------------------");
		if (releaseDetail != null) {
			if (releaseDetail.getCronJobs() != null) {
				for (CronJob cronJob : releaseDetail.getCronJobs()) {
					System.out.println(cronJob.getCronJob());
					cronJob.setReleaseDetail(releaseDetail);
				}
			}
		}
		releaseDetailsService.saveReleaseDetails(releaseDetail);
		return "sucess";
	}
}