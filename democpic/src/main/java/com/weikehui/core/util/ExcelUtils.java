package com.weikehui.core.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

public class ExcelUtils {
	
	/**
	 * 通过全路径，解析excel
	 * @param fileAbsolutePath
	 * @return
	 * @throws IOException
	 */
	public static List<List<String>> readFromExcel(String fileAbsolutePath)
			throws IOException {
		// 读取Excel表中的所有数据		 
		Workbook workbook = getWeebWork(fileAbsolutePath);
		List<List<String>> workbookList = readExcel(workbook);
		return workbookList;
	}
	
	/**
	 * 通过MultipartFile，解析excel
	 * @param file MultipartFile file
	 * @return List<List<String>>
	 * @throws IOException
	 */
	public static List<List<String>> readFromExcel(MultipartFile file) {
		//读取Excel表中的所有数据		
		try {
			Workbook workbook = getWeebWork(file);
			List<List<String>> workbookList = readExcel(workbook);
			return workbookList;
		}catch(IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 通过MultipartFile，获取工作簿
	 * @param file MultipartFile
	 * @return Workbook Workbook
	 * @throws IOException
	 */
	private static Workbook getWeebWork(MultipartFile file) throws IOException {		
		InputStream inputStream = file.getInputStream();
		String filename = file.getOriginalFilename();		
		return getWorkbook(inputStream, filename);
	}

	private static Workbook getWorkbook(InputStream inputStream, String filename) throws IOException {
		Workbook workbook = null;
		if (null != filename) {
			String fileType = filename.substring(filename.lastIndexOf("."),
					filename.length());
			if (".xls".equals(fileType.trim().toLowerCase())) {
				// 创建 Excel 2003 工作簿对象
				workbook = new HSSFWorkbook(inputStream);
			} else if (".xlsx".equals(fileType.trim().toLowerCase())) {
				// 创建 Excel 2007 工作簿对象
				workbook = new XSSFWorkbook(inputStream);
			}
		}
		return workbook;
	}
	
	/**
	 * @Title: getWeebWork
	 * @Description: (根据传入的文件名获取工作簿对象(Workbook))
	 * @param filename
	 * @return
	 * @throws IOException
	 */
	private static Workbook getWeebWork(String filename) throws IOException {
		Workbook workbook = null;
		if (null != filename) {
			String fileType = filename.substring(filename.lastIndexOf("."),
					filename.length());
			FileInputStream fileStream = new FileInputStream(new File(filename));
			if (".xls".equals(fileType.trim().toLowerCase())) {
				// 创建 Excel 2003 工作簿对象
				workbook = new HSSFWorkbook(fileStream);
			} else if (".xlsx".equals(fileType.trim().toLowerCase())) {
				// 创建 Excel 2007 工作簿对象
				workbook = new XSSFWorkbook(fileStream);
			}
		}
		return workbook;
	}
	
	private static List<List<String>> readExcel(Workbook workbook) {
		// 获取表页数
		//PepLogger.info(ExcelUtils.class,"总表页数为：" + workbook.getNumberOfSheets());
		List<List<String>> workbookList = new ArrayList<List<String>>();
		for (int sheetIndex = 0; sheetIndex < workbook.getNumberOfSheets(); sheetIndex++) {
			Sheet sheet = workbook.getSheetAt(sheetIndex);
			// 获取总行数
			int rownum = sheet.getLastRowNum();
			//PepLogger.info(ExcelUtils.class,"总行数：" + rownum);
			if (rownum == 0) {
				continue;
			}

			for (int i = 0; i <= rownum; i++) {
				Row row = sheet.getRow(i);
				if (null == row) {
					continue;
				}
				List<String> rowList = new ArrayList<String>();
				for (int j = row.getFirstCellNum(); j < row.getLastCellNum(); j++) {
					Cell celldata = row.getCell(j);					
					String celldataStr = celldata.toString();
//					// 1、判断是否是数值格式
//					if (celldata.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
//						short format = celldata.getCellStyle().getDataFormat();
//						SimpleDateFormat sdf = null;
//						if (format == 14 || format == 31 || format == 57
//								|| format == 58) {
//							// 日期
//							sdf = new SimpleDateFormat("yyyy-MM-dd");
//						} else if (format == 20 || format == 32) {
//							// 时间
//							sdf = new SimpleDateFormat("HH:mm");
//						}
//						if (sdf != null) {
//							double value = celldata.getNumericCellValue();
//							Date date = org.apache.poi.ss.usermodel.DateUtil
//									.getJavaDate(value);
//							celldataStr = sdf.format(date);
//						} else {
//							// celldataStr = sdf.format(date);
//							// 防止手机号变成E出现，数字出现.0
//							DecimalFormat df = new DecimalFormat("#");  
//							celldataStr = df.format(celldata.getNumericCellValue()); 
//						}
//					}
					rowList.add(celldataStr);
				}
				workbookList.add(rowList);
			}
		}
		return workbookList;
	}

//	public static void main(String[] args) throws IOException {
//
////		System.out.println(generateShortUuid());
//
//		 String fileName = "D:/pep/cpic/2016.xlsx";
//		
//		 File file = new File(fileName);
//		 // 判断文件夹是否存在,如果不存在则创建文件夹
//		 if (!file.exists()) {
//		 System.out.println("文件不存在");
//		 return;
//		 }
//		 List<List<String>> list = readFromExcel(fileName);
//		
//		 System.out.println("===================================");
//		 for (List<String> list2 : list) {
//			 for (String string : list2) {
//				 System.out.print(string + "\t");
//			 }
//			 System.out.print("\n");
//		 }
//
//	}
}
