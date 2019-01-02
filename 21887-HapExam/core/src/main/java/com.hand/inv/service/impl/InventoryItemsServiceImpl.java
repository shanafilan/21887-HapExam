package com.hand.inv.service.impl;

import com.github.pagehelper.PageHelper;
import com.hand.hap.core.IRequest;
import com.hand.hap.system.service.impl.BaseServiceImpl;
import com.hand.inv.mapper.InventoryItemsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hand.inv.dto.InventoryItems;
import com.hand.inv.service.IInventoryItemsService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class InventoryItemsServiceImpl extends BaseServiceImpl<InventoryItems> implements IInventoryItemsService{
    @Autowired
    private  InventoryItemsMapper itemsMapper;

    @Override
    public List<InventoryItems> selectByItem(IRequest requestContext, InventoryItems items, int page, int pageSize) {
        PageHelper.startPage(page,pageSize);
        return itemsMapper.selectByItem(items);
    }
}