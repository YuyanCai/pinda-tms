package com.itheima.pinda.service.truck.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.pinda.common.CustomIdGenerator;
import com.itheima.pinda.entity.truck.PdTruckTypeGoodsType;
import com.itheima.pinda.mapper.truck.PdTruckTypeGoodsTypeMapper;
import com.itheima.pinda.service.truck.IPdTruckTypeGoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author: xiaocai
 * @since: 2023/05/05/08:51
 */
@Service
public class PdTruckTypeGoodsTypeServiceImpl extends
        ServiceImpl<PdTruckTypeGoodsTypeMapper, PdTruckTypeGoodsType>
        implements IPdTruckTypeGoodsTypeService {
    @Autowired
    private CustomIdGenerator idGenerator;

    @Override
    public void batchSave(List<PdTruckTypeGoodsType> truckTypeGoodsTypeList) {
        truckTypeGoodsTypeList.forEach(pdTruckTypeGoodsType -> pdTruckTypeGoodsType.setId(idGenerator.nextId(pdTruckTypeGoodsType) + ""));
        saveBatch(truckTypeGoodsTypeList);
    }

    @Override
    public List<PdTruckTypeGoodsType> findAll(String truckTypeId, String goodsTypeId) {
        LambdaQueryWrapper<PdTruckTypeGoodsType> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (!StringUtils.isEmpty(truckTypeId)) {
            lambdaQueryWrapper.eq(PdTruckTypeGoodsType::getTruckTypeId, truckTypeId);
        }
        if (!StringUtils.isEmpty(goodsTypeId)) {
            lambdaQueryWrapper.eq(PdTruckTypeGoodsType::getGoodsTypeId, goodsTypeId);
        }
        return baseMapper.selectList(lambdaQueryWrapper);
    }

    @Override
    public void delete(String truckTypeId, String goodsTypeId) {
        LambdaQueryWrapper<PdTruckTypeGoodsType> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        boolean canExecute = false;
        if (!StringUtils.isEmpty(truckTypeId)) {
            lambdaQueryWrapper.eq(PdTruckTypeGoodsType::getTruckTypeId, truckTypeId);
            canExecute = true;
        }
        if (!StringUtils.isEmpty(goodsTypeId)) {
            lambdaQueryWrapper.eq(PdTruckTypeGoodsType::getGoodsTypeId, goodsTypeId);
            canExecute = true;
        }
        if (canExecute) {
            baseMapper.delete(lambdaQueryWrapper);
        }
    }


}
