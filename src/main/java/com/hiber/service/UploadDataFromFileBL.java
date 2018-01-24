package com.hiber.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

import com.hiber.dao.SpendingDAO;
import com.hiber.entity.Spending;
import com.hiber.entity.Store;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import com.rd.util.BudgetUtils;

public class UploadDataFromFileBL {
	
	
	@Autowired
	private StoreService storeService;
	@Autowired
	private SpendingService spendingService;
	
	public static final String DEST = "c:\\results\\parse\\czech.txt";
	
	public void convertPDFtoText(String filename) throws IOException, ParseException {
		File file = new File(DEST);
		file.getParentFile().mkdirs();
		PdfReader reader = new PdfReader(filename);
		FileOutputStream fos = new FileOutputStream(DEST);
		for (int page = 1; page <= reader.getNumberOfPages(); page++) {
			String data = PdfTextExtractor.getTextFromPage(reader, page);
			fos.write(data.getBytes("UTF-8"));
		}
		
		fos.flush();
		fos.close();
		SearchRecord(file);
		  File pdfFile = new File(filename);
	      boolean pdffileDelete = pdfFile.delete();
	      boolean testfileDelete =file.delete();
	      System.out.println("file Deleted"+pdffileDelete);
	      System.out.println("file Deleted"+testfileDelete);
	}
	
	public void SearchRecord(File textFile) throws ParseException{
		try {
			Scanner scnr = new Scanner(new FileInputStream(textFile));
			while (scnr.hasNextLine()) {
				String lineData =scnr.nextLine();
				String searchedDate =BudgetUtils.searchDate(lineData);
					if(searchedDate!=null){
						String[] splited = lineData.split("\\s+");
						String description="";
					for (int i = 1; i < splited.length-1; i++) {
						description+=splited[i]+" ";
						}
					Date transactionDate = BudgetUtils.convertStringToDate(searchedDate);
					Double price=BudgetUtils.convertStringToDouble(splited[splited.length-1]);	
					String storeDetails=splited[1];
					System.out.println("Date"+" "+"store"+"price"+" "+"description"+" "+"Bank Name"+" ");
					System.out.println(searchedDate+" "+splited[1]+" "+splited[splited.length-1]+" "+description+" "+"Bank Of America"+"");
					Spending spending = new Spending();
					spending.setPrice(price);
					spending.setDescription(description);
					spending.setTransactionDate(new java.sql.Date(transactionDate.getTime()));
					spending.setStore(stroreDetails(storeDetails));
					spending.setBankName("Bank of America");
					System.out.println(spending);
					spendingService.addSpendingFromFile(spending);
					
					}
					
				//}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
		private Store stroreDetails(String storeName){
			Store store = storeService.getStoreByName(storeName);
			if(store==null){
				store= new Store();
				store.setStoreName(storeName);
				storeService.addStore(store);
				
			}
			return store;
		}
		
		

		public void setSpendingService(SpendingService spendingService) {
			this.spendingService = spendingService;
		}

		public void setStoreService(StoreService storeService) {
			this.storeService = storeService;
		}
		
		
		

}
