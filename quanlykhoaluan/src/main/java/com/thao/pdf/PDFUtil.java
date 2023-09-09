/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.pdf;

import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.view.document.AbstractPdfView;

/**
 *
 * @author Chung Vu
 */
public class PDFUtil extends AbstractPdfView{
    
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setHeader("Content-Disposition", "attachment; filename=\"stats.pdf\"");
        
        @SuppressWarnings("unchecked")
        List<Object[]> list = (List<Object[]>) model.get("statDTB");
        
        document.add(new Paragraph(String.format("Diem trung binh cua khoa luan %s", (String)list.get(0)[4])));
        Table table = new Table(5);
        table.addCell("Ho giang vien");
        table.addCell("Ten giang vien");
        table.addCell("Ngay cham");
        table.addCell("Ten khoa luan");
        table.addCell("Dem");
        
        for(Object[] o : list){
            table.addCell((String) o[2]);
            table.addCell((String) o[3]);
            table.addCell(dateFormat.format(o[1]));
            table.addCell((String) o[4]);
            table.addCell(Float.toString((float) o[0]));
        }
        document.add(table);
        document.add(new Paragraph("Lanh dao ky ten"));
    }
    
}
