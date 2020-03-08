package com.lys.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lys.mapper.ReviewMapper;
import com.lys.model.Criteria;
import com.lys.model.ReviewVO;

@Service
public class ReviewServiceImpl implements ReviewService{
	
	@Autowired
	ReviewMapper rm;
	
	//¥Ò±€ µÓ∑œ
	@Override
	public int reviewinsert(ReviewVO review) throws Exception {
		return rm.reviewinsert(review);
	}
	
	//¥Ò±€ ∏ÆΩ∫∆Æ
	@Override
	public List<ReviewVO> reviewlist(int bookno) throws Exception {
		System.out.println("reviewlistservice.............");
		return rm.reviewlist(bookno);
	}
	
	//¥Ò±€ ºˆ¡§
	@Override
	public int reviewmodify(ReviewVO review) throws Exception {
		return rm.reviewmodify(review);
	}
	
	//¥Ò±€ ªË¡¶
	@Override
	public int reviewdel(ReviewVO review) throws Exception {
		return rm.reviewdel(review);
	}
	
	//¥Ò±€ ∏ÆΩ∫∆Æ ∆‰¿Ã¬° √≥∏Æ
	@Override
	public List<ReviewVO> reviewlistpage(Criteria cri) throws Exception {
		return rm.reviewlistpage(cri);
	}

}
