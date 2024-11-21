package org.example.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceDto {

    private int id;
    private LocalDateTime Time;   //
    private String invoiceNum;       //发票编号
    private String product;    //产品
    private String invoice;       //发票类型
    private String taxpayer;   //纳税人
    private String sfsh;            //审核
}
