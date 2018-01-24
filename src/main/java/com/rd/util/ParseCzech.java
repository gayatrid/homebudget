package com.rd.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

/**
 *
 * @author Bruno Lowagie (iText Software)
 */
public class ParseCzech {

	public static final String SRC = "c:\\pdf\\eStmt_2017-10-26.pdf";
	public static final String DEST = "c:\\results\\parse\\czech.txt";

	public static void main(String[] args) throws Exception {
		File file = new File(DEST);
		file.getParentFile().mkdirs();
		new ParseCzech().convertPDFtoText(SRC);
	}

	public void searchString(){
		
	}
	
	public void SearchRecord(File textFile){
		try {
			boolean flag=false;
			Scanner scnr = new Scanner(new FileInputStream(textFile));
			while (scnr.hasNextLine()) {
				String lineData =scnr.nextLine();
				String searchedDate =BudgetUtils.searchDate(lineData);
					//System.out.println("Check........."+lineData);
					if(searchedDate!=null){
						String[] splited = lineData.split("\\s+");
						System.out.println("Date.........."+searchedDate); 
						System.out.println("store ........"+splited[1]);
						System.out.println("price........."+splited[splited.length-1]);
						String description="";
					for (int i = 1; i < splited.length-1; i++) {
						description+=splited[i]+" ";
						}
					System.out.println("description......."+description);
						
					}
					
				//}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	}
	
	public static void compareInFile(Scanner scanner) {
	    try {
	        while (scanner.hasNext()) {
	           String word = scanner.next();
	           System.out.println("word----"+word);
	        }
	 
	    } catch (Exception error) {
	    }
	}

	
	public File convertPDFtoText(String filename) throws IOException {
		PdfReader reader = new PdfReader(filename);
		FileOutputStream fos = new FileOutputStream(DEST);
		File file = new File(DEST);
		for (int page = 1; page <= reader.getNumberOfPages(); page++) {
			String data = PdfTextExtractor.getTextFromPage(reader, page);
			fos.write(data.getBytes("UTF-8"));
		}
		
		fos.flush();
		fos.close();
		SearchRecord(file);
		return file;
	}
		
		
		



	
}