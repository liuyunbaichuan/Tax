package org.example.domain.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor

@TableName("finance")
public class Finance {          //财务信息
    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField(value = "create_time")
    private LocalDateTime createTime;   //
    private String username;
    private String password;
    @TableField(value = "voucher_num")
    private String voucherNum;       //凭证单号
    @TableField(value = "invoice_pic")
    private String invoicePic;    //发票图片
    @TableField(value = "pay_type")
    private String payType;      //支付类型
    private double amount;       //金额
    @TableField(value = "pay_explain")
    private String payExplain;    //支付说明
    private String remark;      //备注
    private String sfsh;            //审核
    private String shhf;        //审核回复

}
