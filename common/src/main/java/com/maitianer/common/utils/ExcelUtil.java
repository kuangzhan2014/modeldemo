package com.maitianer.common.utils;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author chen
 */
public class ExcelUtil {

    private String title = "data";

    public ExcelUtil() {
    }

    public ExcelUtil(String title) {
        this.title = title;
    }

    public String createExcel(HttpServletResponse response, List<List<String>> header, List<List<Object>> data) throws IOException {

        //创建HSSFWorkbook对象(excel的文档对象)
        HSSFWorkbook wb = new HSSFWorkbook();
        //建立新的sheet对象（excel的表单）
        HSSFSheet sheet = wb.createSheet();
        //单元格风格
        HSSFCellStyle cellStyle = wb.createCellStyle();
        CreationHelper creationHelper = wb.getCreationHelper();
        cellStyle.setDataFormat(creationHelper.createDataFormat().getFormat("yyyy/MM/dd hh:mm:ss"));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        //在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个
        HSSFRow row1 = sheet.createRow(0);
        //创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个
        HSSFCell cell = row1.createCell(0);
        //单元格开始行
        int startRow = 0;
        //是否有标题
        if (header != null && header.size() >= 2) {
            //设置单元格内容
            cell.setCellValue(header.get(0).get(0));
            //合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列
            sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, header.size()));
            startRow++;
        }
        //在sheet里创建第X行
        HSSFRow row2 = sheet.createRow(startRow);
        //创建单元格并设置单元格内容
        for (int i = 0; i < header.get(startRow).size(); i++) {
            row2.createCell(i).setCellValue(header.get(startRow).get(i));
        }
        //行++
        startRow++;
        for (List<Object> list : data) {
            HSSFRow dataRow = sheet.createRow(startRow);
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) == null || "".equals(list.get(i))) {
                    continue;
                }
                if (list.get(i) instanceof Integer) {
                    dataRow.createCell(i).setCellValue((Integer) list.get(i));
                } else if (list.get(i) instanceof Long) {
                    dataRow.createCell(i).setCellValue((Long) list.get(i));
                } else if (list.get(i) instanceof Date) {
                    dataRow.createCell(i).setCellValue(dateFormat.format((Date) list.get(i)));
                } else {
                    dataRow.createCell(i).setCellValue(list.get(i).toString());
                }
            }
            startRow++;
        }
        //输出Excel文件
        OutputStream output = null;
        output = response.getOutputStream();
        response.reset();
        response.setHeader("Content-disposition", "attachment; filename=" + new String(title.getBytes("GBK"), "ISO8859-1") + ".xls");
        response.setContentType("application/msexcel");
        wb.write(output);
        output.close();
        return null;
    }

    public String createExcelMergeSameRow(HttpServletResponse response, List<List<String>> header, List<List<Object>> data) throws IOException {

        //创建HSSFWorkbook对象(excel的文档对象)
        HSSFWorkbook wb = new HSSFWorkbook();
        //建立新的sheet对象（excel的表单）
        HSSFSheet sheet = wb.createSheet();
        //单元格风格
        HSSFCellStyle cellStyle = wb.createCellStyle();
        CreationHelper creationHelper = wb.getCreationHelper();
        cellStyle.setDataFormat(creationHelper.createDataFormat().getFormat("yyyy/MM/dd hh:mm:ss"));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        //合并的单元格样式
        HSSFCellStyle boderStyle = wb.createCellStyle();
        //垂直居中
        boderStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        boderStyle.setAlignment(HorizontalAlignment.CENTER); // 创建一个居中格式
        //设置一个边框
        sheet.setDefaultColumnStyle(0, boderStyle);
        sheet.setDefaultColumnStyle(3, boderStyle);
        sheet.setColumnWidth(0, 256 * 16);

        //在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个
        HSSFRow row1 = sheet.createRow(0);
        //创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个
        HSSFCell cell = row1.createCell(0);
        //单元格开始行
        int startRow = 0;
        //是否有标题
        if (header != null && header.size() >= 2) {
            //设置单元格内容
            cell.setCellValue(header.get(0).get(0));
            //合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列
            sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, header.size()));
            startRow++;
        }
        //在sheet里创建第X行
        HSSFRow row2 = sheet.createRow(startRow);
        //创建单元格并设置单元格内容
        for (int i = 0; i < header.get(startRow).size(); i++) {
            row2.createCell(i).setCellValue(header.get(startRow).get(i));
        }
        //行++
        startRow++;
        for (List<Object> list : data) {
            HSSFRow dataRow = sheet.createRow(startRow);
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) == null || "".equals(list.get(i))) {
                    continue;
                }
                if (list.get(i) instanceof Integer) {
                    dataRow.createCell(i).setCellValue((Integer) list.get(i));
                } else if (list.get(i) instanceof Long) {
                    dataRow.createCell(i).setCellValue((Long) list.get(i));
                } else if (list.get(i) instanceof Date) {
                    dataRow.createCell(i).setCellValue(dateFormat.format((Date) list.get(i)));
                } else {
                    dataRow.createCell(i).setCellValue(list.get(i).toString());
                }
            }
            if (startRow > 0 && startRow % 2 == 0) {
                CellRangeAddress cra = new CellRangeAddress(startRow - 1, startRow, 0, 0);
                sheet.addMergedRegion(cra);
                CellRangeAddress cra2 = new CellRangeAddress(startRow - 1, startRow, 3, 3);
                sheet.addMergedRegion(cra2);
            }
            startRow++;
        }
        //输出Excel文件
        OutputStream output = null;
        output = response.getOutputStream();
        response.reset();
        response.setHeader("Content-disposition", "attachment; filename=" + new String(title.getBytes("GBK"), "ISO8859-1") + ".xls");
        response.setContentType("application/msexcel");
        wb.write(output);
        output.close();
        return null;
    }

    public void titleAddDate() {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        this.title = this.title + format.format(new Date());
    }
}
