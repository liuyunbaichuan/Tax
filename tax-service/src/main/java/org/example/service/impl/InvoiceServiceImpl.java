package org.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.domain.po.Invoice;
import org.example.mapper.InvoiceMapper;
import org.example.service.InvoiceService;
import org.springframework.stereotype.Service;

@Service
public class InvoiceServiceImpl extends ServiceImpl<InvoiceMapper, Invoice> implements InvoiceService {
}
