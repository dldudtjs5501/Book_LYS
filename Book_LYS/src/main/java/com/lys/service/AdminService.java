package com.lys.service;

import com.lys.model.AdminVO;

public interface AdminService {
	
	//Admin 계정으로 login
	public AdminVO adminchk(AdminVO admin)throws Exception;
}
