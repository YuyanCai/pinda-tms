package com.itheima.pinda.entity.truck;

/**
 * @author: xiaocai
 * @since: 2023/05/05/08:45
 */

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 车辆类型与货物类型关联
 */
@Data
@TableName("pd_truck_type_goods_type")
public class PdTruckTypeGoodsType implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * id
     */
    @TableId(value = "id", type = IdType.INPUT)
    private String id;
    /**
     * 车辆类型id
     */
    private String truckTypeId;
    /**
     * 货物类型id
     */
    private String goodsTypeId;
}
