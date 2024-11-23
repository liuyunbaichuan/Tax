package org.example.domain.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceDto {

    private int id;
    private Date createTime;   //
    private String invoiceNum;       //发票编号
    private String product;    //产品
    private String invoice;       //发票类型
    private String taxpayer;   //纳税人
    private String sfsh;            //审核
}
