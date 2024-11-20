package org.example.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.domain.po.Btax;
import org.example.mapper.BtaxMapper;
import org.example.service.BtaxService;
import org.springframework.stereotype.Service;


@Service
public class BtaxServiceImpl extends ServiceImpl<BtaxMapper, Btax> implements BtaxService {
}
