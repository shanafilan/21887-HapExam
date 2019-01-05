package com.hand.ar.mapper;

import com.hand.hap.mybatis.common.Mapper;
import com.hand.ar.dto.Customers;

import java.util.List;

public interface CustomersMapper extends Mapper<Customers>{
    List<Customers> selctByCompany(Customers customers);
}