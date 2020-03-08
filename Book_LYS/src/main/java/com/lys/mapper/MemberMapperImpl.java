package com.lys.mapper;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;


import com.lys.model.MemberVO;

@Repository
public class MemberMapperImpl implements MemberMapper{

	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace="com.lys.mapper.MemberMapper";
	
	//회원 가입 등록
	@Override
	public void Mregister(MemberVO member) throws Exception {
		sqlSession.insert(namespace+".register",member);
		
	}
	
	// 아이디 중복 체크
	@Override
	public int idchk(MemberVO member) throws Exception {
		int result = sqlSession.selectOne(namespace+".idcheck",member);
		return result;
	}
	
	//로그인 체크
	@Override
	public MemberVO loginCheck(MemberVO member) throws Exception {
		
		return sqlSession.selectOne(namespace+".loginchk",member);
		
	}
	//회원 상세 정보
	@Override
	public MemberVO accdetail(String userid) throws Exception {
		MemberVO memberdao = sqlSession.selectOne(namespace+".accdetail",userid);
		return  memberdao;
	}
	//회원 정보 수정
	@Override
	public void accmodify(MemberVO member) throws Exception {
		sqlSession.update(namespace+".accmodify",member);
		
	}
	
	//id 찾기 - email 값 가져오기
	@Override
	public MemberVO findid(MemberVO member) throws Exception {
		System.out.println("이메일 mapper");
		System.out.println("mapper : "+member.toString());
		return sqlSession.selectOne(namespace+".findid",member);	
	}
	
	//인증 번호 적용 후 비밀 번호 변경 - 회원 확인
	@Override
	public int findmem(MemberVO member) throws Exception {
		int result = sqlSession.selectOne(namespace+".modifypw",member);
		return result;
	}
	
	//password 인증 후 변경
	@Override
	public void pass_change(MemberVO member, Map<String, Object> map) throws Exception {
		
		map.get("password");
		map.get("email");
		sqlSession.update(namespace+".pass_change",map);
	}

	//회원 탈퇴
	@Override
	public void memberdel(MemberVO member) throws Exception {
		sqlSession.delete(namespace+".memberdel",member);
	}

}
