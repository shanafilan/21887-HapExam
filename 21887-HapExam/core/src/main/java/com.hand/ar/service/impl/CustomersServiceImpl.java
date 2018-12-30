package com.hand.ar.service.impl;

import com.hand.hap.system.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import com.hand.ar.dto.Customers;
import com.hand.ar.service.ICustomersService;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class CustomersServiceImpl extends BaseServiceImpl<Customers> implements ICustomersService{

}