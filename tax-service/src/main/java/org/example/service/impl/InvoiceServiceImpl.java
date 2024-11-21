package org.example.service.impl;

import cn.hutool.core.bean.BeanUtil;
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
                .eq("invoice_num",search.getInvoiceNum())
                .eq("product",search.getProduct());

        Page<Invoice> page = new Page<>(pageNum, pageSize);
        IPage<Invoice> invoiceIPage = invoiceMapper.selectPage(page, queryWrapper);

        return PageUtils.page(invoiceIPage,InvoiceVo.class);
    }
}
