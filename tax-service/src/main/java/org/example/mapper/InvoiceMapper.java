package org.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.domain.po.Invoice;


@Mapper
public interface InvoiceMapper extends BaseMapper<Invoice> {
}
