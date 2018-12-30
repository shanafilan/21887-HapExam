package com.hand.org.service.impl;

import com.hand.hap.system.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import com.hand.org.dto.Companys;
import com.hand.org.service.ICompanysService;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class CompanysServiceImpl extends BaseServiceImpl<Companys> implements ICompanysService{

}