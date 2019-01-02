package com.hand.inv.service;

import com.hand.hap.core.IRequest;
import com.hand.hap.core.ProxySelf;
import com.hand.hap.system.service.IBaseService;
import com.hand.inv.dto.InventoryItems;

import java.util.List;

public interface IInventoryItemsService extends IBaseService<InventoryItems>, ProxySelf<IInventoryItemsService>{
    List<InventoryItems> selectByItem(IRequest requestContext, InventoryItems items,int page,int pageSize);
}