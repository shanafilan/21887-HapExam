package com.hand.om.service.impl;

import com.github.pagehelper.PageHelper;
import com.hand.hap.account.service.IRole;
import com.hand.hap.account.service.IRoleService;
import com.hand.hap.core.IRequest;
import com.hand.hap.mybatis.common.Criteria;
import com.hand.hap.system.dto.ResponseData;
import com.hand.hap.system.service.impl.BaseServiceImpl;
import com.hand.om.mapper.OrderHeadersMapper;
import com.hand.om.mapper.OrderLinesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import com.hand.om.dto.OrderHeaders;
import com.hand.om.service.IOrderHeadersService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class OrderHeadersServiceImpl extends BaseServiceImpl<OrderHeaders> implements IOrderHeadersService{
    @Autowired
    private MessageSource messageSource;
    @Autowired
    private OrderHeadersMapper orderHeadersMapper;
    @Autowired
    private OrderLinesMapper orderLinesMapper;
    @Autowired
    private IRoleService iRoleService;

    public List<OrderHeaders> selectByCondition(IRequest requestContext, OrderHeaders dto, int page, int pageSize){
        PageHelper.startPage(page,pageSize);
        return orderHeadersMapper.selectByCondition(dto);
    }

    @Override
    public ResponseData changeStatusTo(IRequest requestCtx, HttpServletRequest request, OrderHeaders header, String orderStatus) {
        //如果是审批或者拒绝 需要有销售管理员角色才行
        if(OrderHeaders.ORDER_STATUS_APPROVED.equals(orderStatus) || OrderHeaders.ORDER_STATUS_REJECTED.equals(orderStatus)){
            List<IRole> roles = iRoleService.selectUserRolesByUserId(requestCtx.getUserId());
            boolean flag = false;
            for(IRole role : roles){
                if(role.getRoleCode().equals(OrderHeaders.SALEMANAGER)){
                    flag = true;
                }
            }
            if (!flag){
                ResponseData responseData = new ResponseData(false);
                //多语言
                responseData.setMessage(messageSource.getMessage("exam.noAuth", null, RequestContextUtils.getLocale(request)));
                return responseData;
            }
        }
        header.setOrderStatus(orderStatus);

        Criteria criteria = new Criteria();
        criteria.update(OrderHeaders.FIELD_ORDER_STATUS);
        updateByPrimaryKeyOptions(requestCtx, header, criteria);
        return new ResponseData(Arrays.asList(header));
    }

    @Override
    public void remove(OrderHeaders header) {
        //删除行
        orderLinesMapper.deleteByPrimaryKey(header.getHeaderId());
        //删除头
        deleteByPrimaryKey(header);
    }

    @Override
    public List<OrderHeaders> select(OrderHeaders orderHeader)
    {
        return orderHeadersMapper.select(orderHeader);
    }
}