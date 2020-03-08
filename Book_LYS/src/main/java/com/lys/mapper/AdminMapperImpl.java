package com.lys.mapper;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.lys.model.AdminVO;

@Repository
public class AdminMapperImpl implements AdminMapper{
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace="com.lys.mapper.AdminMapper";

	//Admin login üũ
	@Override
	public AdminVO adminchk(AdminVO admin) throws Exception {
		
		return sqlSession.selectOne(namespace+".adminchk",admin);
	}

}
