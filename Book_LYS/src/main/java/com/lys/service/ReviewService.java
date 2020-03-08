package com.lys.service;

import java.util.List;
import java.util.Map;

import com.lys.model.Criteria;
import com.lys.model.ReviewVO;

public interface ReviewService {

	//¥Ò±€ µÓ∑œ
	public int reviewinsert(ReviewVO review)throws Exception;
	
	//¥Ò±€ ∏ÆΩ∫∆Æ
	public List<ReviewVO> reviewlist(int bookno)throws Exception;
	
	//¥Ò±€ ∏ÆΩ∫∆Æ ∆‰¿Ã¬° √≥∏Æ
	public List<ReviewVO> reviewlistpage(Criteria cri)throws Exception;
	
	//¥Ò±€ ºˆ¡§
	public int reviewmodify (ReviewVO review)throws Exception;
	
	//¥Ò±€ ªË¡¶
	public int reviewdel (ReviewVO review)throws Exception;
}
