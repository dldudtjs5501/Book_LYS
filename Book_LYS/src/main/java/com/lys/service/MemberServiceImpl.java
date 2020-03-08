package com.lys.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lys.mapper.MemberMapper;
import com.lys.model.MemberVO;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	MemberMapper mm;
	
	//회원 가입 등록
	@Override
	public void Mregister(MemberVO member) throws Exception {
		// TODO Auto-generated method stub
		mm.Mregister(member);
	}
	
	//아이디 중복 체크
	@Override
	public int idchk(MemberVO member) throws Exception {
		
		int result = mm.idchk(member);
		return result;
	}
	//로그인 체크
	@Override
	public MemberVO loginCheck(MemberVO member) throws Exception {
		
		return mm.loginCheck(member);
		
	}
	//회원 상세 정보 
	@Override
	public MemberVO accdetail(String userid) throws Exception {
		return mm.accdetail(userid);
	}
	//회원 정보 수정
	@Override
	public void accmodify(MemberVO member) throws Exception {
		
		mm.accmodify(member);	
	}
	
	//이름과 폰번호가 같은 회원 정보 
	@Override
	public MemberVO findid(MemberVO member) throws Exception {
		
		System.out.println("이메일 service 진입.....");
		
		return mm.findid(member);	
	}
	
	//인증 번호 적용 후 비밀 번호 변경 - 회원 확인
	@Override
	public int findmem(MemberVO member) throws Exception {
		int result = mm.findmem(member);
		return result;
	}

	//password 인증 후 변경
	@Override
	public void pass_change(MemberVO member, Map<String, Object> map) throws Exception {
		mm.pass_change(member, map);
		
	}

	//회원 탈퇴
	@Override
	public void memberdel(MemberVO member) throws Exception {
		mm.memberdel(member);
		
	}
}
