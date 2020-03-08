package com.lys.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.lys.model.MemberVO;

public interface MemberService {
	
	//회원 가입 등록
	public void Mregister(MemberVO member) throws Exception;
	
	//아이디 중복 체크
	public int idchk(MemberVO member) throws Exception;
	
	//로그인 체크
	public MemberVO loginCheck(MemberVO member) throws Exception;
	
	//회원 정보 detail
	public MemberVO accdetail(String userid) throws Exception;
	
	//회원 정보 수정
	public void accmodify(MemberVO member) throws Exception;
	
	//id 찾기 - email 정보 가져오기
	public MemberVO findid(MemberVO member) throws Exception;
	
	//인증 번호 적용 후 비밀 번호 변경 - 회원 확인
	public int findmem(MemberVO member)throws Exception;
	
	//password 인증 후 변경
	public void pass_change(MemberVO member,Map<String,Object>map)throws Exception;

	//회원 탈퇴
	public void memberdel(MemberVO member)throws Exception;
}
