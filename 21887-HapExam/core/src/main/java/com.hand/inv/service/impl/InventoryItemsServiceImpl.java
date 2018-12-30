package com.hand.inv.service.impl;

import com.hand.hap.system.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import com.hand.inv.dto.InventoryItems;
import com.hand.inv.service.IInventoryItemsService;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class InventoryItemsServiceImpl extends BaseServiceImpl<InventoryItems> implements IInventoryItemsService{

}