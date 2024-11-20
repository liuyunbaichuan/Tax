package org.example.utils;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class  PageUtils <T>{

    private Integer total;
    private Integer page;
    private List<T> data;

    public static <T> PageUtils <T> page(IPage<T> data) {
        PageUtils<T> pageUtils = new PageUtils<>();
        pageUtils.setTotal((int) data.getTotal());
        pageUtils.setPage((int) data.getPages());
        pageUtils.setData(data.getRecords());
        return pageUtils;
    }

}
