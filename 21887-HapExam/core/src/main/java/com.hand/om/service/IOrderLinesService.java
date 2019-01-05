package com.hand.om.service;

import com.hand.hap.core.IRequest;
import com.hand.hap.core.ProxySelf;
import com.hand.hap.system.service.IBaseService;
import com.hand.om.dto.OrderLines;

import java.util.List;

public interface IOrderLinesService extends IBaseService<OrderLines>, ProxySelf<IOrderLinesService>{
    List<OrderLines> selectByLines(IRequest requestContext, OrderLines dto, int page, int pageSize);
    Long selectMaxLineNumber(Long headerId);
    Long selectNextLineId();
}