package org.example.feign;


import org.example.domain.vo.BtaxVo;
import org.example.domain.vo.User;
import org.example.utils.PageUtils;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("tax-service")
public interface BtaxFeign {

    @GetMapping("/btax/list")
    PageUtils<BtaxVo> btaxList(@RequestParam("pageNum") int pageNum,@RequestParam("pageSize") int pageSize);


    @GetMapping("/user/userList")
    public List<User> Userlist();
}
