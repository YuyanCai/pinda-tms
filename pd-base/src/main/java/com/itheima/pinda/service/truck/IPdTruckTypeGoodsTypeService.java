package com.itheima.pinda.service.truck;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.pinda.entity.truck.PdTruckTypeGoodsType;

import java.util.List;

/**
 * @author: xiaocai
 * @since: 2023/05/05/08:51
 */
public interface IPdTruckTypeGoodsTypeService extends IService<PdTruckTypeGoodsType> {
    void batchSave(List<PdTruckTypeGoodsType> collect);

    /**
     * 获取车辆与货物类型关联
     * @param truckTypeId
     * @param goodsTypeId
     * @return
     */
    List<PdTruckTypeGoodsType> findAll(String truckTypeId, String goodsTypeId);

    /**
     * 删除关联关系
     *
     * @param truckTypeId 车辆类型id
     * @param goodsTypeId 货物类型id
     */
    void delete(String truckTypeId, String goodsTypeId);
}
