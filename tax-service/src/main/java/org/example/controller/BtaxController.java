package org.example.controller;


import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.example.common.Result;
import org.example.domain.dto.BtaxDto;
import org.example.domain.dto.UserDto;
import org.example.domain.po.Btax;
import org.example.domain.po.User;
import org.example.domain.vo.BtaxVo;
import org.example.service.BtaxService;
import org.example.service.UserService;
import org.example.utils.ExportExcel;
import org.example.utils.PageUtils;
import org.example.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/btax")
public class BtaxController {

    @Autowired
    BtaxService btaxService;

    @Autowired
    UserService userService;

    @GetMapping("/list")
    public PageUtils<BtaxVo> list(int pageNum, int pageSize){
        return btaxService.btaxList(pageNum,pageSize);
    }

    @GetMapping("/delete")
    public Result delete(int id){
        btaxService.removeById(id);
        return Result.success();
    }


    @PostMapping("/add")
    public Result save(@RequestBody BtaxDto btaxDto){
        btaxDto.setCreateTime(LocalDateTime.now());
        btaxDto.setRegTime(LocalDateTime.now());
        btaxService.save(BeanUtil.toBean(btaxDto,Btax.class));
        return Result.success();
    }

    @PostMapping("/update")
    public Result update(@RequestBody BtaxDto btaxDto){

        btaxService.updateById(BeanUtil.toBean(btaxDto,Btax.class));
        return Result.success();
    }


    @GetMapping("/detail")
    public BtaxVo detail(int id){
        Btax btax = btaxService.getById(id);
        return BeanUtil.copyProperties(btax,BtaxVo.class);
    }

    @GetMapping("/approval")
    public Result approval(int id){
        String usernum = ThreadLocalUtil.get();
        UserDto user = userService.querybynum(usernum);
        btaxService.approval(user,id);
        return Result.success("审批成功");
    }

    @PostMapping("/excel")
    public void export(HttpServletResponse response,int pageNum,int pageSize){
        PageUtils<BtaxVo> btaxVos = btaxService.btaxList(pageNum, pageSize);
        List<BtaxVo> data = btaxVos.getData();
        ExportExcel.exportData(BtaxVo.class,data,response);
    }
}
