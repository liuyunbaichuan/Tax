package org.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.domain.dto.InvoiceDto;
import org.example.domain.po.Invoice;
import org.example.domain.vo.InvoiceVo;
import org.example.utils.PageUtils;

import java.util.List;

public interface InvoiceService extends IService<Invoice> {
    List<Invoice> invoiceList();

    PageUtils<InvoiceVo> search(int pageNum, int pageSize, InvoiceDto search);

    List<InvoiceVo> search1(int pageNum, int pageSize, InvoiceDto search);


    void add(InvoiceDto invoiceDto);
}
