package com.lys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lys.mapper.AdminMapper;
import com.lys.mapper.MemberMapper;
import com.lys.model.AdminVO;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminMapper am;
	
	//admin login
	@Override
	public AdminVO adminchk(AdminVO admin) throws Exception {
		return am.adminchk(admin);
	}

}
