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
	
	//��� ���
	@Override
	public int reviewinsert(ReviewVO review) throws Exception {
		return rm.reviewinsert(review);
	}
	
	//��� ����Ʈ
	@Override
	public List<ReviewVO> reviewlist(int bookno) throws Exception {
		System.out.println("reviewlistservice.............");
		return rm.reviewlist(bookno);
	}
	
	//��� ����
	@Override
	public int reviewmodify(ReviewVO review) throws Exception {
		return rm.reviewmodify(review);
	}
	
	//��� ����
	@Override
	public int reviewdel(ReviewVO review) throws Exception {
		return rm.reviewdel(review);
	}
	
	//��� ����Ʈ ����¡ ó��
	@Override
	public List<ReviewVO> reviewlistpage(Criteria cri) throws Exception {
		return rm.reviewlistpage(cri);
	}

}
