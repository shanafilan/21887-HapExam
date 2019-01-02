package com.hand.inv.mapper;

import com.hand.hap.mybatis.common.Mapper;
import com.hand.inv.dto.InventoryItems;

import java.util.List;

public interface InventoryItemsMapper extends Mapper<InventoryItems>{
    List<InventoryItems> selectByItem(InventoryItems items);
}