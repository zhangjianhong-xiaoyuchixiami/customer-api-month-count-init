package org.qydata.tools;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.util.CellRangeAddress;
import org.qydata.po.*;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/1/10.
 */
public class ExcelUtil {

    public static List<CustomerConsumeExcel> createExcel(List<ConsumeTime> consumeTimeList) {

        List<CustomerConsumeExcel> customerConsumeExcelList = new ArrayList<>();
        if (consumeTimeList != null){
            for (int g = 0; g<consumeTimeList.size(); g++){
                ConsumeTime consumeTime = consumeTimeList.get(g);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat sdfDetail = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");

                //第一步创建workbook
                HSSFWorkbook wb = new HSSFWorkbook();
                //第二步创建按天消费统计sheet
                HSSFSheet sheet = wb.createSheet(consumeTime.getYearMonth()+"按天消费统计");

                sheet.setColumnWidth(0, 31 * 256);//设置第0列的宽度是31个字符宽度
                sheet.setColumnWidth(1, 31 * 256);//设置第1列的宽度是31个字符宽度
                sheet.setColumnWidth(2, 31 * 256);//设置第2列的宽度是31个字符宽度
                sheet.setColumnWidth(3, 31 * 256);//设置第3列的宽度是31个字符宽度

                //第三步创建行row:添加表头行

                HSSFRow row = sheet.createRow(0);
                HSSFCell cell = row.createCell(0);
                cell.setCellValue("说明：如对账单有所疑问，烦请贵公司与我们联系");
                row.setHeightInPoints(20);//设置行的高度是20个点
                CellRangeAddress region = new CellRangeAddress(0, 0, 0, 3);
                sheet.addMergedRegion(region);
                HSSFCellStyle style = wb.createCellStyle();
                HSSFFont font = wb.createFont();   // 设置字体加粗
                font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
                style.setFont(font);
                style.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);//设置图案颜色
                style.setFillBackgroundColor(HSSFColor.GREY_25_PERCENT.index);//设置图案背景色
                style.setFillPattern(HSSFCellStyle.THIN_FORWARD_DIAG);//设置图案样式
                style.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
                style.setBorderBottom(HSSFCellStyle.BORDER_THIN);//下边框
                style.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
                style.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框
                cell.setCellStyle(style);

                row = sheet.createRow(1);
                cell = row.createCell(0);
                cell.setCellValue("时间范围："+consumeTime.getYearMonth());
                row.setHeightInPoints(20);//设置行的高度是20个点
                region = new CellRangeAddress(1, 1, 0, 3);
                sheet.addMergedRegion(region);
                cell.setCellStyle(style);


                style = wb.createCellStyle();
                style.setAlignment(HSSFCellStyle.ALIGN_CENTER);  //设置字体居中
                font = wb.createFont();   // 设置字体加粗
                font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
                style.setFont(font);
                style.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);//设置图案颜色
                style.setFillBackgroundColor(HSSFColor.GREY_25_PERCENT.index);//设置图案背景色
                style.setFillPattern(HSSFCellStyle.THIN_FORWARD_DIAG);//设置图案样式
                style.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
                style.setBorderBottom(HSSFCellStyle.BORDER_THIN);//下边框
                style.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
                style.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框
                row = sheet.createRow(2);
                row.setHeightInPoints(20);//设置行的高度是20个点
                //第四步创建单元格
                cell = row.createCell(0);         //第一个单元格
                cell.setCellValue("日期");                  //设定值

                cell.setCellStyle(style);                   //内容居中

                cell = row.createCell(1);                   //第二个单元格
                cell.setCellValue("产品类型");
                cell.setCellStyle(style);

                cell = row.createCell(2);                   //第三个单元格
                cell.setCellValue("消费金额（单位：元）");
                cell.setCellStyle(style);

                cell = row.createCell(3);                   //第四个单元格
                cell.setCellValue("扣费次数");
                cell.setCellStyle(style);

                //创建消费明细sheetDetail
                HSSFSheet sheetDetail = wb.createSheet(consumeTime.getYearMonth()+"消费明细");

                sheetDetail.setColumnWidth(0, 31 * 256);//设置第0列的宽度是31个字符宽度
                sheetDetail.setColumnWidth(1, 31 * 256);//设置第1列的宽度是31个字符宽度
                sheetDetail.setColumnWidth(2, 31 * 256);//设置第2列的宽度是31个字符宽度
                sheetDetail.setColumnWidth(3, 31 * 256);//设置第3列的宽度是31个字符宽度
                sheetDetail.setColumnWidth(4, 31 * 256);//设置第3列的宽度是31个字符宽度


                //创建行row:添加表头0行
                row = sheetDetail.createRow(0);
                style = wb.createCellStyle();
                font = wb.createFont();
                style.setAlignment(HSSFCellStyle.ALIGN_CENTER);  //设置字体居中
                font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
                style.setFont(font);
                style.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);//设置图案颜色
                style.setFillBackgroundColor(HSSFColor.GREY_25_PERCENT.index);//设置图案背景色
                style.setFillPattern(HSSFCellStyle.THIN_FORWARD_DIAG);//设置图案样式
                style.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
                style.setBorderBottom(HSSFCellStyle.BORDER_THIN);//下边框
                style.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
                style.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框
                row.setHeightInPoints(20);//设置行的高度是20个点

                //创建明细单元格
                cell = row.createCell(0);         //第一个单元格
                cell.setCellValue("日期");                  //设定值
                cell.setCellStyle(style);                   //内容居中

                cell = row.createCell(1);                   //第二个单元格
                cell.setCellValue("类型");
                cell.setCellStyle(style);

                cell = row.createCell(2);                   //第三个单元格
                cell.setCellValue("消费金额（单位：元）");
                cell.setCellStyle(style);

                cell = row.createCell(3);                   //第四个单元格
                cell.setCellValue("查询对象");
                cell.setCellStyle(style);

                cell = row.createCell(4);                   //第五个单元格
                cell.setCellValue("reqId");
                cell.setCellStyle(style);

                style = wb.createCellStyle();
                style.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);//设置图案颜色
                style.setFillBackgroundColor(HSSFColor.GREY_25_PERCENT.index);//设置图案背景色
                style.setFillPattern(HSSFCellStyle.THIN_FORWARD_DIAG);//设置图案样式
                style.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
                style.setBorderBottom(HSSFCellStyle.BORDER_THIN);//下边框
                style.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
                style.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框

                List<Customer> customerList = consumeTime.getCustomerList();
                if (customerList != null){
                    for (int i = 0; i < customerList.size(); i++) {
                        Customer customer = customerList.get(i);
                        //循环遍历生成按天统计的Excel
                        List<CustomerApiTypeConsume> customerApiTypeConsumeList = customer.getCustomerApiTypeConsumeList();
                        if (customerApiTypeConsumeList != null){
                            for (int j = 0; j < customerApiTypeConsumeList.size(); j++) {
                                CustomerApiTypeConsume customerApiTypeConsume = customerApiTypeConsumeList.get(j);
                                row = sheet.createRow(j + 3);
                                //创建单元格并且添加数据
                                cell = row.createCell(0);
                                cell.setCellStyle(style);
                                if(customerApiTypeConsume.getConsuTime() != null){
                                    cell.setCellValue(sdf.format(customerApiTypeConsume.getConsuTime()));
                                }
                                cell = row.createCell(1);
                                cell.setCellStyle(style);
                                if (customerApiTypeConsume.getApiTypeName() != null) {
                                    if (customerApiTypeConsume.getStidName() != null) {
                                        cell.setCellValue(customerApiTypeConsume.getApiTypeName() + "-" + customerApiTypeConsume.getStidName());
                                    } else {
                                        cell.setCellValue(customerApiTypeConsume.getApiTypeName());
                                    }
                                }
                                cell = row.createCell(2);
                                cell.setCellStyle(style);
                                if (customerApiTypeConsume.getSumAmount() != null) {
                                    cell.setCellValue(-customerApiTypeConsume.getSumAmount() / 100.0);
                                }
                                cell = row.createCell(3);
                                cell.setCellStyle(style);
                                if (customerApiTypeConsume.getCountSuccess() != null) {
                                    cell.setCellValue(customerApiTypeConsume.getCountSuccess());
                                }
                            }

                        }

                        //循环遍历生成明细的Excel
                        List<CustomerApiTypeConsumeDetail> customerApiTypeConsumeDetailList = customer.getCustomerApiTypeConsumeDetailList();
                        if (customerApiTypeConsumeDetailList != null){
                            for (int r=0; r<customerApiTypeConsumeDetailList.size(); r++){
                                CustomerApiTypeConsumeDetail customerApiTypeConsumeDetail = customerApiTypeConsumeDetailList.get(r);
                                row = sheetDetail.createRow(r + 1);
                                //创建单元格并且添加数据
                                cell = row.createCell(0);
                                cell.setCellStyle(style);
                                if(customerApiTypeConsumeDetail.getCreateTime() != null){
                                    cell.setCellValue(sdfDetail.format(customerApiTypeConsumeDetail.getCreateTime()));
                                }
                                cell = row.createCell(1);
                                cell.setCellStyle(style);
                                if (customerApiTypeConsumeDetail.getApiTypeName() != null) {
                                    if (customerApiTypeConsumeDetail.getStidName() == null) {
                                        cell.setCellValue(customerApiTypeConsumeDetail.getApiTypeName());
                                    } else {
                                        cell.setCellValue(customerApiTypeConsumeDetail.getApiTypeName() + "-" + customerApiTypeConsumeDetail.getStidName());
                                    }
                                }
                                cell = row.createCell(2);
                                cell.setCellStyle(style);
                                if (customerApiTypeConsumeDetail.getAmount() != null) {
                                    cell.setCellValue(-customerApiTypeConsumeDetail.getAmount() / 100.0);
                                }
                                cell = row.createCell(3);
                                cell.setCellStyle(style);
                                if (customerApiTypeConsumeDetail.getK() != null) {
                                    cell.setCellValue(customerApiTypeConsumeDetail.getK());
                                }
                                cell = row.createCell(4);
                                cell.setCellStyle(style);
                                if (customerApiTypeConsumeDetail.getReqId() != null) {
                                    cell.setCellValue(customerApiTypeConsumeDetail.getReqId());
                                }
                            }
                        }

                        //第六步将生成excel文件保存到指定路径下
                        FileOutputStream fos = null;
                        FileInputStream fis = null;
                        ByteArrayOutputStream out = null;
                        try {
                            File file = new File("D:\\finance\\" + consumeTime.getYearMonth() + "\\"+customer.getCustomerId()+"@"+consumeTime.getYearMonth()+".xls");
                            if (!file.exists()) {
                                file.getParentFile().mkdirs();
                                file.createNewFile();
                            }
                            fos = new FileOutputStream(file);
                            wb.write(fos);

                            //读文件
                            fis=new FileInputStream(file);
                            out= new ByteArrayOutputStream();
                            int start = fis.read();
                            while (start != -1) {
                                out.write(start);
                                start= fis.read();
                            }
                            CustomerConsumeExcel customerConsumeExcel = new CustomerConsumeExcel();
                            customerConsumeExcel.setCustomerId(customer.getCustomerId());
                            customerConsumeExcel.setExcelCode(out.toByteArray());
                            customerConsumeExcel.setConsuTime(consumeTime.getYearMonth());
                            customerConsumeExcel.setYear(consumeTime.getYear());
                            customerConsumeExcel.setMonth(consumeTime.getMonth());
                            customerConsumeExcelList.add(customerConsumeExcel);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }finally {
                            try {
                                fos.close();
                                fis.close();
                                out.close();
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        }

                    }
                }
            }
        }
        return customerConsumeExcelList;
    }
}
