package com.yz.manager.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import com.yz.manager.storehouse.bean.storeHouse;

public class ExcelHandler {

	public List<Map<String,String>> getDataFromExcel(InputStream in) throws BiffException, IOException{
		List<Map<String,String>> data = new ArrayList<Map<String,String>>();
		Workbook book  = Workbook.getWorkbook(in);
		Sheet sheet = book.getSheet(0);
		Integer rowNum = sheet.getRows();
		for(int row=0;row<rowNum;row++){
			Map<String,String> rowData = new HashMap<String,String>();
			if(sheet.getCell(1, row).getContents().equals("")){
				continue;
			}
			rowData.put("name", sheet.getCell(1, row).getContents());
			rowData.put("class", sheet.getCell(2, row).getContents());
			rowData.put("specification", sheet.getCell(3, row).getContents());
			rowData.put("unit", sheet.getCell(4, row).getContents());
			rowData.put("unitPrice", sheet.getCell(5, row).getContents());
			rowData.put("storeNum", sheet.getCell(6, row).getContents());
			data.add(rowData);
		}
		return data;
	}
	
	public List<storeHouse> getStoreHousesFromExcel(InputStream in) throws BiffException, IOException{
		List<storeHouse> data = new ArrayList<storeHouse>();
		Workbook book  = Workbook.getWorkbook(in);
		Sheet sheet = book.getSheet(0);
		Integer rowNum = sheet.getRows();
		for(int row=1;row<rowNum;row++){
			storeHouse rowData = new storeHouse();
			if(sheet.getCell(1, row).getContents().equals("")){
				continue;
			}
			rowData.setSecondCName(sheet.getCell(1, row).getContents());
			rowData.setFirstCName(sheet.getCell(2, row).getContents());
			rowData.setInContent(sheet.getCell(3, row).getContents());
			rowData.setUnit(sheet.getCell(4, row).getContents());
			try{
				rowData.setUnitPrice(Double.parseDouble(sheet.getCell(5, row).getContents()));
			}catch (Exception e) {
				rowData.setUnitPrice(0.0);
			}
			try{
				rowData.setInCount(Integer.parseInt(sheet.getCell(6, row).getContents()));
			}catch (Exception e) {
				rowData.setInCount(0);
			}
			data.add(rowData);
		}
		book.close();
		return data;
	}
}
