package org.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.domain.po.Invoice;

import java.util.List;


@Mapper
public interface InvoiceMapper extends BaseMapper<Invoice> {
    List<Invoice> query1(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize, @Param("invoice") Invoice invoice);
}
