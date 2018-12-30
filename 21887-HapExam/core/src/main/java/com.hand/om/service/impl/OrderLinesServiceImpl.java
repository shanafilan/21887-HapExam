package com.hand.om.service.impl;

import com.hand.hap.system.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import com.hand.om.dto.OrderLines;
import com.hand.om.service.IOrderLinesService;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class OrderLinesServiceImpl extends BaseServiceImpl<OrderLines> implements IOrderLinesService{

}