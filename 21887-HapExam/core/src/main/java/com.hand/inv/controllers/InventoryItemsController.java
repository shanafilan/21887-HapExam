package com.hand.inv.controllers;

import org.springframework.stereotype.Controller;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.core.IRequest;
import com.hand.hap.system.dto.ResponseData;
import com.hand.inv.dto.InventoryItems;
import com.hand.inv.service.IInventoryItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import org.springframework.validation.BindingResult;
import java.util.List;

    @Controller
    public class InventoryItemsController extends BaseController{

    @Autowired
    private IInventoryItemsService service;


    @RequestMapping(value = "/hap/inv/inventory/items/query")
    @ResponseBody
    public ResponseData query(InventoryItems dto, @RequestParam(defaultValue = DEFAULT_PAGE) int page,
        @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize, HttpServletRequest request) {
        IRequest requestContext = createRequestContext(request);
        return new ResponseData(service.selectByItem(requestContext,dto,page,pageSize));
    }

    @RequestMapping(value = "/hap/inv/inventory/items/submit")
    @ResponseBody
    public ResponseData update(@RequestBody List<InventoryItems> dto, BindingResult result, HttpServletRequest request){
        getValidator().validate(dto, result);
        if (result.hasErrors()) {
        ResponseData responseData = new ResponseData(false);
        responseData.setMessage(getErrorMessage(result, request));
        return responseData;
        }
        IRequest requestCtx = createRequestContext(request);
        return new ResponseData(service.batchUpdate(requestCtx, dto));
    }

    @RequestMapping(value = "/hap/inv/inventory/items/remove")
    @ResponseBody
    public ResponseData delete(HttpServletRequest request,@RequestBody List<InventoryItems> dto){
        service.batchDelete(dto);
        return new ResponseData();
    }
    }