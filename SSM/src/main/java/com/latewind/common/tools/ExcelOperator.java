package com.latewind.common.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.latewind.pojo.product.ProductInfo;
import com.latewind.service.product.IProductService;


public class ExcelOperator {
	
	static XSSFRow row;
	
	
	public static List<ProductInfo> readSheet2(String filePath, Integer start,Integer end,Integer sheetIndex,Integer thirdId,
			
			
		IProductService productService) throws IOException {	
	//  修改四个参数 起始行kInteger  终止行   sheet行  商品ThirdID 读取文件 生成商品 
		
		List<ProductInfo> list=new LinkedList<>(); 	
		if(productService!=null){
			
			System.out.println("product Service is not null");
		}
	    XSSFRow row;
	    FileInputStream fis = null;
		fis = new FileInputStream(
		new File("D:/Svod/2014.xlsx"));
	    XSSFWorkbook workbook = null;
		workbook = new XSSFWorkbook(fis);
	    XSSFSheet spreadsheet = workbook.getSheetAt(sheetIndex);
	    Iterator < Row > rowIterator = spreadsheet.iterator();
//	    rowIterator.next();//越过第一行
//	    rowIterator.next();//越过第二行
	    Integer kInteger=start-1;
	    for(int i=0;i<kInteger;i++)
	    	rowIterator.next();
	    while (rowIterator.hasNext()) 
	    {
	  	  ProductInfo pInfo=new ProductInfo();
	       row = (XSSFRow) rowIterator.next();
	       Iterator < Cell > cellIterator = row.cellIterator();            
//	       System.out.println(row.getCell(1).getStringCellValue());
	    pInfo.setPrtName(row.getCell(1).getStringCellValue());
	    String price=row.getCell(2).getStringCellValue();
	   
	    pInfo.setPrice(new BigDecimal(price.trim()));
	    pInfo.setNum(Integer.valueOf(row.getCell(6).getStringCellValue()));
	    pInfo.setDescrib(row.getCell(8).getStringCellValue());
	    pInfo.setThirdId(thirdId);
	    list.add(pInfo);
	    System.out.println(pInfo.toString());
	    
	    if(kInteger>end-2){
	    	break;
	    }
	    kInteger++;
	    }
			fis.close();
			
			return list;
	   }
	
	
	public static void readSheet(String filePath) throws IOException {
		
		

		      FileInputStream fis = null;
		
				fis = new FileInputStream(
				  new File("D:/Svod/2014.xlsx"));
	
		      XSSFWorkbook workbook = null;
		
				workbook = new XSSFWorkbook(fis);
		
		      XSSFSheet spreadsheet = workbook.getSheetAt(10);
		      Iterator < Row > rowIterator = spreadsheet.iterator();
		      rowIterator.next();//越过第一行
		      rowIterator.next();//越过第二行
		      while (rowIterator.hasNext()) 
		      {
		         row = (XSSFRow) rowIterator.next();
		         Iterator < Cell > cellIterator = row.cellIterator();
		         
		         while ( cellIterator.hasNext()) 
		         {
		            Cell cell = cellIterator.next();
		            switch (cell.getCellType()) 
		            {
		               case Cell.CELL_TYPE_NUMERIC:
		               System.out.print( 
		               cell.getNumericCellValue() + " \t\t " );
		               break; 
		               case Cell.CELL_TYPE_STRING:
		               System.out.print(
		               cell.getStringCellValue() + " \t\t " );
		               break;
		            }
		            
		         }
		         System.out.println();
		      }
		   
				fis.close();

		   }
		
		

}
