package com.hiber.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.hiber.entity.Spending;
import com.hiber.entity.Store;
import com.hiber.service.CreditDataService;
import com.hiber.service.SpendingService;
import com.hiber.service.StoreService;
import com.hiber.service.UploadDataFromFileBL;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import com.rd.util.BudgetUtils;

@Controller
public class SpendingController {
	@Autowired
	private SpendingService spendingService;
	
	 @Autowired
	 ServletContext context;
	
	@Autowired
	UploadDataFromFileBL uploadDataFromFileBL;
	
	@Autowired
	private StoreService storeService;
	
	@Autowired
	private CreditDataService creditDataService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String spending(ModelMap map) {
		map.addAttribute("spendingForm", new SpendingForm());
		return "index";
	}
	
	@RequestMapping(value = "/uploadFileData", method = RequestMethod.GET)
	public String uploadFileData(ModelMap map) {
		map.addAttribute("spendingForm", new SpendingForm());
		return "uploadFile";
	}
	
	

	@RequestMapping(value = "/getStarted", method = RequestMethod.GET)
	public String listSpending(ModelMap map) {
		map.addAttribute("spendingForm", new SpendingForm());
		map.addAttribute("stores", storeService.getAllStore());
		return "spending";
	}

	public void setAttributeObject(SpendingForm spendingForm,ModelMap map){
		List<Spending> list=spendingService.getAllSpending(spendingForm.getMonth());
		map.addAttribute("stores", storeService.getAllStore());
		map.addAttribute("spendingList",list );
	}

	@RequestMapping(value = "/addRecord", params="addSpending",method = RequestMethod.POST)
	public String addSpending(SpendingForm spendingForm, BindingResult result,ModelMap map) {
		spendingService.addSpending(spendingForm);
		setAttributeObject(spendingForm, map);
		return "spending";
	}
	@RequestMapping(value = "/addRecord", params="search",method = RequestMethod.POST)
	public String searchByMonth(SpendingForm spendingForm, BindingResult result,ModelMap map) {
		setAttributeObject(spendingForm, map);
		return "spending";
	}
	
	/*@RequestMapping(value = "/addRecord",params="addCredit",method = RequestMethod.POST)
	public String addCredit(SpendingForm spendingForm, BindingResult result) {
		creditDataService.addCreditData(spendingForm);
		return "redirect:/getStarted";
	}
*/
	@RequestMapping("/delete/{spendingId}")
	public String deleteSpending(@PathVariable("spendingId") Integer spendingId) {
		spendingService.deleteSpending(spendingId);
		return "redirect:/getStarted";
	}
	
	@RequestMapping(value = "/addRecord", params="uploadFile",method = RequestMethod.POST)
	public String uploadFile(SpendingForm spendingForm,BindingResult result,ModelMap map) throws IOException, ParseException {
		String UPLOADED_FOLDER=context.getRealPath("/WEB-INF/");
	    byte[] bytes = spendingForm.getFile().getBytes();
	    String completeFilePath=UPLOADED_FOLDER + spendingForm.getFile().getOriginalFilename();
        Path path = Paths.get(completeFilePath);
        Files.write(path, bytes);
	    uploadDataFromFileBL.convertPDFtoText(completeFilePath);
	   // return "redirect:/getStarted";
	    map.addAttribute("message", "Load file Data Successfully");
	    return "uploadFile";
	}
	
	@RequestMapping("/edit/{spendingId}")
	public String editSpending(ModelMap map, @PathVariable("spendingId") Integer spendingId) throws ParseException {
		Spending  spending =spendingService.getSpending(spendingId);
		if (spendingId != null) {
			//
			//SimpleDateFormat dt = new SimpleDateFormat("MM-dd-yyyy");
	       // Date date = dt.parse(String.valueOf(spending.getPayDate()));
			//spending.setPayDate(date);
		}
			map.addAttribute("spending",spending);
	//	map.addAttribute("spendingList", spendingService.getAllSpending());
		return "spending";
	}
	

	public void setSpendingService(SpendingService spendingService) {
		this.spendingService = spendingService;
	}

	public void setCreditDataService(CreditDataService creditDataService) {
		this.creditDataService = creditDataService;
	}

	public void setUploadDataFromFileBL(UploadDataFromFileBL uploadDataFromFileBL) {
		this.uploadDataFromFileBL = uploadDataFromFileBL;
	}
	
	
	
	
}