package com.lys.service;

import java.util.List;
import java.util.Map;

import com.lys.model.Criteria;
import com.lys.model.ReviewVO;

public interface ReviewService {

	//��� ���
	public int reviewinsert(ReviewVO review)throws Exception;
	
	//��� ����Ʈ
	public List<ReviewVO> reviewlist(int bookno)throws Exception;
	
	//��� ����Ʈ ����¡ ó��
	public List<ReviewVO> reviewlistpage(Criteria cri)throws Exception;
	
	//��� ����
	public int reviewmodify (ReviewVO review)throws Exception;
	
	//��� ����
	public int reviewdel (ReviewVO review)throws Exception;
}
