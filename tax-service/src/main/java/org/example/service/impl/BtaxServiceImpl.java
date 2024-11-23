package org.example.service.impl;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.domain.dto.UserDto;
import org.example.domain.po.Btax;
import org.example.domain.vo.BtaxVo;
import org.example.mapper.BtaxMapper;
import org.example.service.BtaxService;
import org.example.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BtaxServiceImpl extends ServiceImpl<BtaxMapper, Btax> implements BtaxService {

    @Autowired
    BtaxMapper btaxMapper;

    @Override
    public PageUtils<BtaxVo> btaxList(int pageNum, int pageSize) {
        Page<Btax> page = new Page<>(pageNum, pageSize);
        IPage<Btax> iPage = btaxMapper.selectPage(page, null);

        return PageUtils.page(iPage,BtaxVo.class);
    }

    @Override
    public void approval(UserDto user, int id) {

        Btax btax = new Btax();
        btax.setId(id);
        btax.setSfsh(1);
        btax.setUserid(Integer.valueOf(user.getUserNum()));
        btax.setUsername(user.getUsername());
        baseMapper.updateById(btax);
    }
}
