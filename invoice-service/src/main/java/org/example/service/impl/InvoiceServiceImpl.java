package org.example.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.domain.dto.InvoiceDto;
import org.example.domain.po.Invoice;
import org.example.domain.vo.InvoiceVo;
import org.example.mapper.InvoiceMapper;
import org.example.service.InvoiceService;
import org.example.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class InvoiceServiceImpl extends ServiceImpl<InvoiceMapper, Invoice> implements InvoiceService {

    @Autowired
    InvoiceMapper invoiceMapper;

    @Override
    public List<Invoice> invoiceList() {
        return invoiceMapper.selectList(null);
    }

    @Override
    public PageUtils<InvoiceVo> search(int pageNum, int pageSize, InvoiceDto search) {

        QueryWrapper<Invoice> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .eq(ObjectUtil.isNotEmpty(search.getCreateTime()),"create_time",search.getCreateTime())
                .eq(StringUtils.hasText(search.getInvoiceNum()),"invoice_num",search.getInvoiceNum())
                .eq(StringUtils.hasText(search.getProduct()),"product",search.getProduct())
                .eq(StringUtils.hasText(search.getInvoice()),"invoice",search.getInvoice())
                .eq(StringUtils.hasText(search.getTaxpayer()),"taxpayer",search.getTaxpayer())
                .eq(StringUtils.hasText(search.getSfsh()),"sfsh",search.getSfsh());

        Page<Invoice> page = new Page<>(pageNum, pageSize);
        IPage<Invoice> invoiceIPage = invoiceMapper.selectPage(page, queryWrapper);
        return PageUtils.page(invoiceIPage,InvoiceVo.class);
    }

    @Override
    public List<InvoiceVo> search1(int pageNum, int pageSize, InvoiceDto search) {
        Invoice invoice = BeanUtil.copyProperties(search, Invoice.class);
        List<Invoice> invoices = invoiceMapper.query1((pageNum-1)*pageSize, pageSize, invoice);
        return BeanUtil.copyToList(invoices,InvoiceVo.class);
    }

    @Override
    public void add(InvoiceDto invoiceDto) {
        invoiceDto.setCreateTime(DateTime.now());
        invoiceMapper.insert(BeanUtil.copyProperties(invoiceDto, Invoice.class));
    }
}
