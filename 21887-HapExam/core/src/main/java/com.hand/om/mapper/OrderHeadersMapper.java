package com.hand.om.mapper;

import com.hand.hap.mybatis.common.Mapper;
import com.hand.om.dto.OrderHeaders;

import java.util.List;

public interface OrderHeadersMapper extends Mapper<OrderHeaders>{
    List<OrderHeaders> selectByCondition(OrderHeaders orderHeaders);

}