package com.venkatesh.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.venkatesh.entity.CitizenPlan;
@Component
public class Pdfexport {
	public void pdfgenerator(HttpServletResponse response,List<CitizenPlan> plans,File f) throws DocumentException, IOException {
		Document doc=new Document(PageSize.A4);
		PdfWriter.getInstance(doc, response.getOutputStream());
		
		PdfWriter.getInstance(doc, new FileOutputStream(f));
		
		
		doc.open();
		Paragraph p=new Paragraph("plans-data");
		
	PdfPTable table=new PdfPTable(7);
		table.addCell("citizenid");
		table.addCell("citizenname");
		table.addCell("gender");
		table.addCell("planname");
		
		table.addCell("planstatus");
		table.addCell("planstartdate");
		table.addCell("planenddate");
		
		
		for(CitizenPlan plan:plans) {
			table.addCell(String.valueOf(plan.getCITIZEN_ID()));
			table.addCell(plan.getCITIZEN_NAME());
			
			table.addCell(plan.getGENDER());
			table.addCell(plan.getPLAN_NAME());
			table.addCell(plan.getPLAN_STATUS());
			table.addCell(String.valueOf(plan.getPLAN_START_DATE()));
			table.addCell(String.valueOf(plan.getPLAN_END_DATE()));
			
			
		}
		doc.add(table);
		
		doc.close();
		
		
	}

}
