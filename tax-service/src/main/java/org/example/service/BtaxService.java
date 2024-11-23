package org.example.service;


import com.baomidou.mybatisplus.extension.service.IService;
import org.example.domain.dto.UserDto;
import org.example.domain.po.Btax;
import org.example.domain.vo.BtaxVo;
import org.example.domain.vo.UserVo;
import org.example.utils.PageUtils;

public interface BtaxService extends IService<Btax> {
    PageUtils<BtaxVo> btaxList(int pageNum, int pageSize);

    void approval(UserDto usernum, int id);
}
