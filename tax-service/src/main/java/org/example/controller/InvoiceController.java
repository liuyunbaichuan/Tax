package org.example.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.example.common.Result;
import org.example.domain.po.Invoice;
import org.example.service.InvoiceService;
import org.example.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;

    @GetMapping
    public PageUtils<Invoice> list(int pageNum, int pageSize) {
        Page<Invoice> page = new Page<>(pageNum, pageSize);
        IPage<Invoice> invoiceIPage = invoiceService.page(page);

        return  PageUtils.page(invoiceIPage);
    }
}
