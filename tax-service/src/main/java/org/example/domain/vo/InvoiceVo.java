package org.example.domain.vo;



import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

@TableName("invoice")
public class InvoiceVo {          //发票

    @ExcelProperty("创建时间")
    @ColumnWidth(20)
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date createTime;   //
    @ExcelProperty("用户账号")
    @ColumnWidth(20)
    private String usernum;
    @ExcelProperty("用户名")
    @ColumnWidth(20)
    private String username;
    @ExcelProperty("发票编号")
    @ColumnWidth(20)
    private String invoiceNum;       //发票编号
    @ExcelProperty("产品")
    @ColumnWidth(20)
    private String product;    //产品
    @ExcelProperty("发票")
    @ColumnWidth(20)
    private String invoice;       //发票
    @ExcelProperty("数量")
    @ColumnWidth(20)
    private Integer nums;    //数量
    @ExcelProperty("单价")
    @ColumnWidth(20)
    private Integer unitPrice;   //单价
    @ExcelProperty("金额")
    @ColumnWidth(20)
    private Integer amount;    //金额
    @ExcelProperty("税率")
    @ColumnWidth(20)
    private double  rate;   //税率
    @ExcelProperty("税额")
    @ColumnWidth(20)
    private double taxNum;  //税额
    @ExcelProperty("纳税人")
    @ColumnWidth(20)
    private String taxpayer;   //纳税人
    @ExcelProperty("审核")
    @ColumnWidth(20)
    private String sfsh;            //审核
    @ExcelProperty("审核回复")
    @ColumnWidth(20)
    private String shhf;        //审核回复
    @ExcelProperty("用户id")
    @ColumnWidth(20)
    private Integer userid;
}
