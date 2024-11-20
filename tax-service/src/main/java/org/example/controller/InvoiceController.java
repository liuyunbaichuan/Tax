package org.example.controller;


import org.example.common.Result;
import org.example.domain.po.Invoice;
import org.example.service.InvoiceService;
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
    public Result<Invoice> list(){
        List<Invoice> list = invoiceService.list();
        return  Result.success(list);
    }
}
