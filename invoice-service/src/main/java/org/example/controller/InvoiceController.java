package org.example.controller;


import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.example.common.Result;

import org.example.domain.dto.InvoiceDto;
import org.example.domain.po.Invoice;
import org.example.domain.vo.InvoiceVo;
import org.example.service.InvoiceService;
import org.example.utils.ExportExcel;
import org.example.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;

    @GetMapping
    public PageUtils<InvoiceVo> list(int pageNum, int pageSize) {
        Page<Invoice> page = new Page<>(pageNum, pageSize);
        IPage<Invoice> invoiceIPage = invoiceService.page(page);

        PageUtils<InvoiceVo> page1 = PageUtils.page(invoiceIPage, InvoiceVo.class);
        return page1;
    }

    @PostMapping("/export")
    public void export(HttpServletResponse response) {
        List<Invoice> list = invoiceService.invoiceList();
        List<InvoiceVo> invoiceVos = BeanUtil.copyToList(list, InvoiceVo.class);
        ExportExcel.exportData(InvoiceVo.class,invoiceVos,response);
    }


    @PostMapping("/query")
    public PageUtils<InvoiceVo> invoiceVoPage(int pageNum, int pageSize, @RequestBody InvoiceDto search) {

        return invoiceService.search(pageNum,pageSize,search);
    }
    @PostMapping("/query1")
    public List<InvoiceVo> invoiceVoPage1(int pageNum, int pageSize, @RequestBody InvoiceDto search) {

        return invoiceService.search1(pageNum,pageSize,search);
    }

    @PostMapping("/update")
    public Result update(@RequestBody InvoiceDto invoiceDto) {

        invoiceService.updateById(BeanUtil.copyProperties(invoiceDto,Invoice.class));
        return Result.success();
    }

    @PostMapping("/add")
    public Result add(@RequestBody InvoiceDto invoiceDto) {
        invoiceService.add(invoiceDto);
        return Result.success("添加成功");
    }

}
