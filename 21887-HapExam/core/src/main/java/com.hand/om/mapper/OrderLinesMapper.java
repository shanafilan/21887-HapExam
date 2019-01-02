package com.hand.om.mapper;

import com.hand.hap.mybatis.common.Mapper;
import com.hand.om.dto.OrderLines;

public interface OrderLinesMapper extends Mapper<OrderLines>{
    Long selectMaxLineNumber(Long headerId);
    void deleteByHeaderId(Long headerId);
}