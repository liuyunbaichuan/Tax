package org.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.domain.po.Finance;
import org.example.mapper.FinanceMapper;
import org.example.service.FinanceService;
import org.springframework.stereotype.Service;


@Service
public class FinanceServiceImpl extends ServiceImpl<FinanceMapper,Finance> implements FinanceService{
}
