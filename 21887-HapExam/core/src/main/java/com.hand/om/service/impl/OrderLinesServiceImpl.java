package com.hand.om.service.impl;

import com.github.pagehelper.PageHelper;
import com.hand.hap.core.IRequest;
import com.hand.hap.system.service.impl.BaseServiceImpl;
import com.hand.om.mapper.OrderLinesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hand.om.dto.OrderLines;
import com.hand.om.service.IOrderLinesService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(rollbackFor = Exception.class)
public class OrderLinesServiceImpl extends BaseServiceImpl<OrderLines> implements IOrderLinesService{
    @Autowired
    private OrderLinesMapper orderLinesMapper;


    @Override
    public List<OrderLines> selectByLines(IRequest requestContext, OrderLines dto, int page, int pageSize) {
        PageHelper.startPage(page,pageSize);
        return orderLinesMapper.selectByLines(dto);
    }

    @Override
    public Long selectMaxLineNumber(Long headerId) {
        Long lineNumber = null;
        if (headerId!=null){
            lineNumber = orderLinesMapper.selectMaxLineNumber(headerId);
        }
        return lineNumber == null ? 0L:lineNumber;
    }

    @Override
    public Long selectNextLineId() {
        return orderLinesMapper.selectNextLineId();
    }
}