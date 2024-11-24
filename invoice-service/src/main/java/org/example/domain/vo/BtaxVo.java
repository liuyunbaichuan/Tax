package org.example.domain.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BtaxVo {      ///经营税收


    @ExcelProperty("id")
    @ColumnWidth(20)
    private Integer id;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ExcelProperty("创建时间")
    @ColumnWidth(20)
    private LocalDateTime createTime;   //
    @ExcelProperty("企业账号")
    @ColumnWidth(20)
    private String enterpriseNum;                    //企业账号
    @ExcelProperty("企业名")
    @ColumnWidth(20)
    private String enterpriseName;
    @ExcelProperty("税种")
    @ColumnWidth(20)
    private String taxType;       //税种
    @ExcelProperty("税收金额")
    @ColumnWidth(20)
    private double taxAmount;    //税收金额
    @ExcelProperty("非税收金额")
    @ColumnWidth(20)private double nottaxAmount;       //非税收金额
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime regTime;    //支付说明
    @ExcelProperty("审核")
    @ColumnWidth(20)
    private Integer sfsh;            //审核
    @ExcelProperty("审核回复")
    @ColumnWidth(20)
    private String shhf;        //审核回复
    @ExcelProperty("用户id")
    @ColumnWidth(20)
    private Integer userid;
    @ExcelProperty("审核用户名")
    @ColumnWidth(20)
    private String username;
}
