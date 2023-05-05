package com.itheima.pinda.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.pinda.entity.base.PdGoodsType;

import java.util.List;

/**
 * @author: xiaocai
 * @since: 2023/05/05/08:51
 */
public interface IPdGoodsTypeService extends IService<PdGoodsType> {
    PdGoodsType saveGoodsType(PdGoodsType pdGoodsType);

    /**
     * 获取货物类型列表
     * @param ids 货物类型id
     * @return 货物类型列表
     */
    List<PdGoodsType> findAll(List<String> ids);


    List<PdGoodsType> findAll();

    IPage<PdGoodsType> findByPage(Integer page, Integer pageSize, String name, String truckTypeId, String truckTypeName);
}
