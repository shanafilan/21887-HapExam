package com.hand.org.mapper;

import com.hand.hap.mybatis.common.Mapper;
import com.hand.org.dto.Companys;

import java.util.List;

public interface CompanysMapper extends Mapper<Companys>{
    List<Companys> selectByCompany(Companys dto);
}