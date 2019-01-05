package com.hand.om.mapper;

import com.hand.hap.mybatis.common.Mapper;
import com.hand.om.dto.OrderLines;

import java.util.List;

public interface OrderLinesMapper extends Mapper<OrderLines>{
    List<OrderLines> selectByLines(OrderLines orderLines);
    Long selectMaxLineNumber(Long headerId);
    Long selectNextLineId();
    void deleteByHeaderId(Long headerId);
}