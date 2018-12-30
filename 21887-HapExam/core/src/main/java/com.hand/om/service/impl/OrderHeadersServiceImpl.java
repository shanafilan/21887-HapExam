package com.hand.om.service.impl;

import com.hand.hap.system.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import com.hand.om.dto.OrderHeaders;
import com.hand.om.service.IOrderHeadersService;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class OrderHeadersServiceImpl extends BaseServiceImpl<OrderHeaders> implements IOrderHeadersService{

}