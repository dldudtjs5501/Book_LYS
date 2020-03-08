package com.lys.mapper;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lys.model.Criteria;
import com.lys.model.ReviewVO;

@Repository
public class ReviewMapperImpl implements ReviewMapper{
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace="com.lys.mapper.ReviewMapper";
	
	
	//¥Ò±€ ∏ÆΩ∫∆Æ
	@Override
	public List<ReviewVO> reviewlist(int bookno) throws Exception {
		System.out.println("reviewlistmapper........");
		return sqlSession.selectList(namespace+".reviewlist",bookno);
	}

	//¥Ò±€ µÓ∑œ
	@Override
	public int reviewinsert(ReviewVO review) throws Exception {
		return sqlSession.insert(namespace+".reviewinsert",review);
	}
	
	//¥Ò±€ ºˆ¡§
	@Override
	public int reviewmodify(ReviewVO review) throws Exception {
		return sqlSession.update(namespace+".reviewmodify",review);
	}

	//¥Ò±€ ªË¡¶
	@Override
	public int reviewdel(ReviewVO review) throws Exception {
		return sqlSession.delete(namespace+".reviewdel",review);
	}

	//¥Ò±€ ∏ÆΩ∫∆Æ ∆‰¿Ã¬° √≥∏Æ
	@Override
	public List<ReviewVO> reviewlistpage(Criteria cri) throws Exception {
		List list = sqlSession.selectList(namespace+".reviewlistpage",cri);
		return list;
	}
	
}
