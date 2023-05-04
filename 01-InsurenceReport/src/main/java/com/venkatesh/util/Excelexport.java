package com.venkatesh.util;

import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import org.springframework.stereotype.Component;

import com.venkatesh.entity.CitizenPlan;



@Component
public class Excelexport{
	
	public void excelgenerator(HttpServletResponse response,List<CitizenPlan> plans) throws Exception{
		Workbook workbook=new HSSFWorkbook();
		Sheet sheet=workbook.createSheet("plans-data");
		Row headerrow=sheet.createRow(0);
		headerrow.createCell(0).setCellValue("id");
		headerrow.createCell(1).setCellValue("CITIZEN_NAME");
		headerrow.createCell(2).setCellValue("PLAN_NAME");
		headerrow.createCell(3).setCellValue("PLAN_STATUS");
		headerrow.createCell(4).setCellValue("PLAN_START_DATE");
		headerrow.createCell(5).setCellValue("PLAN_END_DATE");
		
		headerrow.createCell(6).setCellValue("BENEFIT_AMOUNT");
		
		
		int datarowindex=1;
		for(CitizenPlan p:plans) {
			Row datarow=sheet.createRow(datarowindex);
			datarow.createCell(0).setCellValue(p.getCITIZEN_ID());
			datarow.createCell(1).setCellValue(p.getCITIZEN_NAME());
			datarow.createCell(2).setCellValue(p.getPLAN_NAME());
			datarow.createCell(3).setCellValue(p.getPLAN_STATUS());
			if(null !=p.getPLAN_START_DATE()) {
			
			
			datarow.createCell(4).setCellValue(p.getPLAN_START_DATE());
			
			}else {
				datarow.createCell(4).setCellValue("n/a");
				
			}
			if(null!=p.getPLAN_END_DATE()) {
			datarow.createCell(5).setCellValue(p.getPLAN_END_DATE());
			}else {
				datarow.createCell(5).setCellValue("n/a");
			}
			if(null!=p.getBENEFIT_AMOUNT()) {
			datarow.createCell(6).setCellValue(p.getBENEFIT_AMOUNT());
			}else {
				datarow.createCell(6).setCellValue("n/a");
			}
			
			datarowindex++;
		}
		
		FileOutputStream fos=new FileOutputStream("plans.xls");
		workbook.write(fos);
		workbook.close();
		
		
		ServletOutputStream outputstream=response.getOutputStream();
		workbook.write(outputstream);
		workbook.close();
	}
	
	

}
