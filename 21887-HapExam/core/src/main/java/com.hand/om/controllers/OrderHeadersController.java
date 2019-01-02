package com.hand.om.controllers;

import org.springframework.stereotype.Controller;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.core.IRequest;
import com.hand.hap.system.dto.ResponseData;
import com.hand.om.dto.OrderHeaders;
import com.hand.om.service.IOrderHeadersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import org.springframework.validation.BindingResult;
import java.util.List;

    @Controller
    @RequestMapping("/hap/om/order/headers")
    public class OrderHeadersController extends BaseController{

    @Autowired
    private IOrderHeadersService service;


    @RequestMapping(value = "/query")
    @ResponseBody
    public ResponseData query(OrderHeaders dto, @RequestParam(defaultValue = DEFAULT_PAGE) int page,
        @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize, HttpServletRequest request) {
        System.out.println("----------------------");
        System.out.println(dto);
        IRequest requestContext = createRequestContext(request);
        return new ResponseData(service.selectByCondition(requestContext,dto,page,pageSize));
    }

    @RequestMapping(value = "/submit")
    @ResponseBody
    public ResponseData update(@RequestBody List<OrderHeaders> dto, BindingResult result, HttpServletRequest request){
        getValidator().validate(dto, result);
        if (result.hasErrors()) {
        ResponseData responseData = new ResponseData(false);
        responseData.setMessage(getErrorMessage(result, request));
        return responseData;
        }
        IRequest requestCtx = createRequestContext(request);
        return new ResponseData(service.batchUpdate(requestCtx, dto));
    }

    @RequestMapping(value = "/remove")
    @ResponseBody
    public ResponseData delete(HttpServletRequest request,@RequestBody List<OrderHeaders> dto){
        service.batchDelete(dto);
        return new ResponseData();
    }
    /**
     * 提交订单
     */
    @RequestMapping(value = "/status/submit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData submitOrder(@RequestBody OrderHeaders header, HttpServletRequest request) {
        IRequest requestCtx = createRequestContext(request);

        return service.changeStatusTo(requestCtx, request, header, OrderHeaders.ORDER_STATUS_REJECTED);
    }

    /**
     * 审核
     */
    @RequestMapping(value = "/status/approval", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData approvalOrder(@RequestBody OrderHeaders header, HttpServletRequest request) {
        IRequest requestCtx = createRequestContext(request);
        return service.changeStatusTo(requestCtx, request, header, OrderHeaders.ORDER_STATUS_APPROVED);
    }

    /**
     * 拒绝
     */
    @RequestMapping(value = "/status/reject", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData rejectOrder(@RequestBody OrderHeaders header, HttpServletRequest request) {
        IRequest requestCtx = createRequestContext(request);
        return service.changeStatusTo(requestCtx, request, header, OrderHeaders.ORDER_STATUS_REJECTED);
    }

}