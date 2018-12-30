package com.hand.base.mapper;

import com.hand.base.dto.OrderSummary;
import com.hand.hap.mybatis.common.Mapper;

import java.util.List;

public interface OrderSummaryMapper extends Mapper<OrderSummary>{
    List<OrderSummary> findAll();
    List<OrderSummary> selectByOrderSummary(OrderSummary orderSummary);
}
