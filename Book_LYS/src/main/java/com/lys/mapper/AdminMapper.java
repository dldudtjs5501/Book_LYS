package com.lys.mapper;

import com.lys.model.AdminVO;

public interface AdminMapper {
	
	//Admin 계정으로 login
	public AdminVO adminchk(AdminVO admin)throws Exception;
	
}
