package com.lys.mapper;

import com.lys.model.AdminVO;

public interface AdminMapper {
	
	//Admin �������� login
	public AdminVO adminchk(AdminVO admin)throws Exception;
	
}
