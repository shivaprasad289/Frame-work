package com.StrongerMe.generics;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Reporter;
/**
 * @author Shivaprasad
 */
public class ExcelUtiltiy {
	public CellStyle style; 
	public static FileOutputStream fileOut;
	public FileInputStream fileIn;
	public Cell cell;
	public String excelPath;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet; 
	public Workbook wb,wb1; 
	
	public ExcelUtiltiy(String excelPath) {
		this.excelPath = excelPath;
	}
	public ExcelUtiltiy() {
		
	}
/**
 * This method is used to read data from excel by specifying sheet name, row number and cell number.
 * @param sheetName
 * @param rowNum
 * @param cellNum
 * @return
 * @throws EncryptedDocumentException
 * @throws IOException
 */
	public String getExcelData(String sheetName,int rowNum,int cellNum) throws EncryptedDocumentException, IOException
	{	 
		 fileIn = new FileInputStream(excelPath);
		 fileOut = new FileOutputStream(IAutoConstant.RESULTEXCELPATH);
		 wb = WorkbookFactory.create(fileIn);
		 String data = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		 fileIn.close();
		 wb.close();
		return data;
	}
	/**
	 * This method return all the data in the sheet.
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 * @author Lenovo
	 */
	public Object[][] getExcelData(String sheetName) throws EncryptedDocumentException, IOException
	{				
		 fileIn = new FileInputStream(excelPath);
		 wb = WorkbookFactory.create(fileIn);
		int lastRow = wb.getSheet(sheetName).getLastRowNum();
		short lastCellNum = wb.getSheet(sheetName).getRow(0).getLastCellNum();
		Object data[][] = new Object[lastRow][lastCellNum];
		
		for(int i=0;i<lastRow;i++)
		{
			for(int j=0;j<lastCellNum;j++)
			{
				data[i][j] = wb.getSheet(sheetName).getRow(i+1).getCell(j).toString();
				String celldata = data.toString();
				//setCellData(IAutoConstant.EXCELOGINRESULTSHEETNAME, i+1, j,celldata);
			}
		}
		fileIn.close();
		wb.close();
		return data;
	}
	/**
	 * This method used to write data inside the excel sheet.
	 * @param sheetName
	 * @param rowNum
	 * @param colNum
	 * @param value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void writeExcelData(String sheetName,int rowNum,int colNum,String value) throws EncryptedDocumentException, IOException{ 
	    fileIn = new FileInputStream(excelPath);
		wb = WorkbookFactory.create(fileIn);
		wb.createSheet(sheetName).createRow(rowNum).createCell(colNum).setCellValue(value);
		fileIn.close();
		wb.close();
	}
	/**
	 * This method helps to set green foreground color.
	 * @param sheetName
	 * @param rowNum
	 * @param colNum
	 * @throws IOException
	 */
	public void fillGreenForegroundColor(String sheetName,int rowNum,int colNum) throws IOException{
	    fileIn = new FileInputStream(excelPath);
		wb = WorkbookFactory.create(fileIn);
		cell   = wb.getSheet(sheetName).getRow(rowNum).getCell(colNum);
		style = wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		fileOut = new FileOutputStream(excelPath);
		try {
			wb.write(fileOut);
			wb.close();
			fileIn.close();
		} catch (IOException e) {
			Reporter.log("Excel file not found",true);
		}
	}
	/**
	 * his method helps to set red foreground color.. 
	 * @param sheetName
	 * @param rowNum
	 * @param colNum
	 * @throws IOException
	 */
	public void fillRedForegroundColor(String sheetName,int rowNum,int colNum) throws IOException{
	    fileIn = new FileInputStream(IAutoConstant.EXCELPATH);
	     wb = WorkbookFactory.create(fileIn);
		cell   = wb.getSheet(sheetName).getRow(rowNum).getCell(colNum);
		style = wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		fileOut = new FileOutputStream(excelPath);
		try {
			wb.write(fileOut);
			wb.close();
			fileIn.close();
		} catch (IOException e) {
			Reporter.log("Excel file not found",false);
		}	
	}
	
	public void setRedBackgroundColor(String sheetName,int rowNum,int colNum) throws IOException{
	    fileIn = new FileInputStream(IAutoConstant.EXCELPATH);
	     wb = WorkbookFactory.create(fileIn);
		cell   = wb.getSheet(sheetName).getRow(rowNum).getCell(colNum);
		style = wb.createCellStyle();
		style.setFillBackgroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		fileOut = new FileOutputStream(excelPath);
		try {
			wb.write(fileOut);
			wb.close();
			fileIn.close();
		} catch (IOException e) {
			Reporter.log("Excel file not found",false);
		}	
	}
	
	public void setReGreenBackgroundColor(String sheetName,int rowNum,int colNum) throws IOException{
	    fileIn = new FileInputStream(IAutoConstant.EXCELPATH);
	     wb = WorkbookFactory.create(fileIn);
		cell   = wb.getSheet(sheetName).getRow(rowNum).getCell(colNum);
		style = wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		fileOut = new FileOutputStream(excelPath);
		try {
			wb.write(fileOut);
			wb.close();
			fileIn.close();
		} catch (IOException e) {
			Reporter.log("Excel file not found",false);
		}	
	}
	
	public void fillRedColor(String sheetName,int rowNum,int colNum) throws IOException{
	    fileIn = new FileInputStream(IAutoConstant.EXCELPATH);
	     wb = WorkbookFactory.create(fileIn);
		cell   = wb.getSheet(sheetName).getRow(rowNum).getCell(colNum);
		style = wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		fileOut = new FileOutputStream(excelPath);
		try {
			wb.write(fileOut);
			wb.close();
			fileIn.close();
		} catch (IOException e) {
			Reporter.log("Excel file not found",false);
		}	
	}
	/**
	 * This method return row count in a sheet.
	 * @param sheetName
	 * @return
	 * @throws IOException 
	 * @throws EncryptedDocumentException 
	 */
	public int getRowCount(String sheetName) throws EncryptedDocumentException, IOException {
		fileIn = new FileInputStream(excelPath);
		wb = WorkbookFactory.create(fileIn);
		int rowNum = wb.getSheet(sheetName).getLastRowNum();
		try {
			wb.close();
			fileIn.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return rowNum;
	}
	/**
	 * This method returns cell count in a row.
	 * @param sheeetName
	 * @param rowNum
	 * @return
	 * @throws IOException 
	 * @throws EncryptedDocumentException 
	 */
	public int getCellCount(String sheeetName,int rowNum) throws EncryptedDocumentException, IOException {
		fileIn = new FileInputStream(excelPath);
	    wb = WorkbookFactory.create(fileIn);
		int cellCount = wb.getSheet(sheeetName).getRow(rowNum).getLastCellNum();
		try {
			wb.close();
			fileIn.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return cellCount;
	}
/**
 *  * This method used to write data inside the excel sheet.
 * @param sheetName
 * @param rowNum
 * @param colNum
 * @param data
 * @throws IOException
 */
	public void setCellData(String sheetName,int rowNum,int colNum,String data) throws IOException {
		File xfile = new File(IAutoConstant.RESULTEXCELPATH);
		if(!xfile.exists()) {		                           
		 workbook = new XSSFWorkbook();//If file not exist create new file
		 fileOut = new FileOutputStream(IAutoConstant.RESULTEXCELPATH);
		 workbook.write(fileOut);
		}
		fileIn = new FileInputStream(IAutoConstant.RESULTEXCELPATH);
		workbook = new XSSFWorkbook(fileIn); 
		if(workbook.getSheetIndex(sheetName)==-1)//If sheet not exists then create new sheet.
			workbook.createSheet(sheetName);
		
	    sheet = workbook.getSheet(sheetName);
		if(sheet.getRow(rowNum)==null)
			sheet.createRow(rowNum);
		sheet.getRow(rowNum).createCell(colNum).setCellValue(data);
		workbook.close();
		fileIn.close();
		if(fileOut!=null)
          fileOut.close();
	}
	/**
	 * This method returns the header data.
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public Object[][] readheadersOfSheet(String sheetName) throws EncryptedDocumentException, IOException {
		fileIn  = new FileInputStream(excelPath);
		wb = WorkbookFactory.create(fileIn);
		 short headerRowNum = wb.getSheet(sheetName).getTopRow();
		short headerLastCellNum = wb.getSheet(sheetName).getRow(0).getLastCellNum(); 
		Object data[][] = new Object[headerRowNum][headerLastCellNum];
		for(int j=0;j<headerLastCellNum;j++) {
			wb.getSheet(sheetName).getRow(headerRowNum).getCell(j).toString();
		}
		fileIn.close();
		wb.close();
		return data;
	}
}
