package org.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.domain.po.Gtax;
import org.example.mapper.GtaxMapper;
import org.example.service.GtaxService;
import org.springframework.stereotype.Service;


@Service
public class GtaxServiceImpl extends ServiceImpl<GtaxMapper, Gtax> implements GtaxService {
}
