package org.example.utils;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;


public class ExportExcel<T>{   //通用导出模板
    private static final String FILENAME = "export";

    public static<T> void exportData(Class<T> clazz, List<T> list, HttpServletResponse response) {
        try {

            setExcelResponseProp(response, FILENAME);
            EasyExcel.write(response.getOutputStream())
                    .head(clazz)
                    .excelType(ExcelTypeEnum.XLSX)
                    .sheet(FILENAME)
                    .doWrite(list);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * 设置响应结果
     *
     * @param response    响应结果对象
     * @param rawFileName 文件名
     * @throws UnsupportedEncodingException 不支持编码异常
     */
    public static void setExcelResponseProp(HttpServletResponse response, String rawFileName) throws UnsupportedEncodingException {
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode(rawFileName, "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
    }




}
