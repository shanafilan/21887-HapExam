package com.hand.om.service;

import com.hand.hap.core.IRequest;
import com.hand.hap.core.ProxySelf;
import com.hand.hap.core.annotation.StdWho;
import com.hand.hap.system.dto.ResponseData;
import com.hand.hap.system.service.IBaseService;
import com.hand.om.dto.OrderHeaders;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface IOrderHeadersService extends IBaseService<OrderHeaders>, ProxySelf<IOrderHeadersService>{
    List<OrderHeaders> selectByCondition(IRequest requestContext,OrderHeaders dto,int page,int pageSize);

    ResponseData changeStatusTo(IRequest requestCtx, HttpServletRequest request, OrderHeaders header, String orderStatus);

    void remove(OrderHeaders header);

    List<OrderHeaders> select(OrderHeaders orderHeader);

    /*List<OrderHeaders> batchUpdate(IRequest requestContext,@StdWho List<OrderHeaders> orderHeaders);*/
    /*int insertHeaders(OrderHeaders headers);
    int updateHeaders(OrderHeaders headers);*/
}