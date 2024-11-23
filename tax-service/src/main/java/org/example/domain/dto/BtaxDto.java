package org.example.domain.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("btax")
public class BtaxDto {      ///经营税收


    private Integer id;
    private LocalDateTime createTime;   //
    private String enterpriseNum;                    //企业账号
    private String enterpriseName;
    private String taxType;       //税种
    private double taxAmount;    //税收金额
    private double nottaxAmount;       //非税收金额
    private LocalDateTime regTime;    //支付说明
    private Integer sfsh;            //审核
    private String shhf;        //审核回复
    private Integer userid;
    private String username;

}
