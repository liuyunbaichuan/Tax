package org.example.domain.po;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor

@TableName("invoice")
public class Invoice {          //发票

    @TableId(type= IdType.AUTO)
    private Integer id;
    @TableField(value = "create_time")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;  //
    @TableField(value = "usernum")
    private String usernum;
    @TableField(value = "username")//用户账号
    private String username;
    @TableField(value = "invoice_num")
    private String invoiceNum;       //发票编号
    @TableField(value = "product")
    private String product;    //产品
    @TableField(value = "invoice")
    private String invoice;       //发票
    @TableField(value = "nums")
    private Integer nums;    //数量
    @TableField(value = "unitprice")
    private Integer unitPrice;   //单价
    @TableField(value = "amount")
    private Integer amount;    //金额
    @TableField(value = "rate")
    private double  rate;   //税率
    @TableField(value = "taxnum")
    private double taxNum;  //税额
    @TableField(value = "taxpayer")
    private String taxpayer;   //纳税人
    @TableField(value = "sfsh")
    private String sfsh;            //审核
    @TableField(value = "shhf")
    private String shhf;        //审核回复
    @TableField(value = "userid")
    private Integer userid;
}
