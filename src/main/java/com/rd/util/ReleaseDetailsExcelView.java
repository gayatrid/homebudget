package com.rd.util;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.rd.entity.ReleaseDetail;

public class ReleaseDetailsExcelView extends AbstractExcelView {
	@Override
	protected void buildExcelDocument(Map model, HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HSSFSheet excelSheet = workbook.createSheet("Animal List");
		setExcelHeader(excelSheet);
		List animalList = (List) model.get("animalList");
		setExcelRows(excelSheet, animalList);
	}
	
	public void setExcelHeader(HSSFSheet excelSheet) {
		HSSFRow excelHeader = excelSheet.createRow(0);
		excelHeader.createCell(0).setCellValue("Composite Name");
		excelHeader.createCell(1).setCellValue("Partition");
		excelHeader.createCell(2).setCellValue("Ticket Number");
		excelHeader.createCell(3).setCellValue("Release Date");
		excelHeader.createCell(4).setCellValue("Release Description");
	}
	
	public void setExcelRows(HSSFSheet excelSheet, List<ReleaseDetail> releaseDetails) {
		int record = 1;
		for (ReleaseDetail animal : releaseDetails) {
			HSSFRow excelRow = excelSheet.createRow(record++);
			excelRow.createCell(0).setCellValue(animal.getId());
			excelRow.createCell(1).setCellValue(animal.getReleaseDate());
			excelRow.createCell(2).setCellValue(animal.getReleaseDate());
			excelRow.createCell(3).setCellValue(animal.getReleaseDate());
			excelRow.createCell(4).setCellValue(animal.getReleaseDate());
		}
	}
}