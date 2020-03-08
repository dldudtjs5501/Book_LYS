package com.lys.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lys.mapper.MemberMapper;
import com.lys.model.MailVO;
import com.lys.model.MemberVO;
import com.lys.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService mservice;
	@Autowired
	private JavaMailSender mailsender;
	
	//회원 가입 페이지 단순 이동
	@RequestMapping(value="register" , method=RequestMethod.GET)
	public String memberGet() throws Exception{
		//System.out.println("register get.................");
		return "member/Member";
	}
	
	//회원 가입 시 입력 한 정보 database에 저장 -> login페이지로 이동
	@RequestMapping(value="register" , method=RequestMethod.POST)
	public String memberPost(MemberVO member , Model model) throws Exception{
		
		//System.out.println("register......................");
		
		int result = mservice.idchk(member);
		
		System.out.println("id : "+member.getUserid());
		//System.out.println(member.getAddress_post() + member.getAddress_jibun() + "/" + member.getAddress_road());
		try {
			if(result == 1) {
				//입력 한 아이디가 존재 -> 회원가입 페이지
				return "member/register";
			}else if(result == 0) {
				//입력 한 아이디가 무존재 -> 등록
				mservice.Mregister(member);
				//System.out.println("저장이 되니?");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "redirect:login"; 
	}
	
	//id 중복 체크
	@RequestMapping(value="IDCHK")
	@ResponseBody //페이지 전환 없이 데이터 주고 받기 위한 것.post 방식만 사용
	public int idchk(MemberVO member) throws Exception{ //MemberVO member = #{필드명} 처리를 위한 것
		//System.out.println("idchk.............");
		int result = mservice.idchk(member);
		return result;
	}
	//로그인 페이지로 단순 이동
	@RequestMapping(value="login" , method=RequestMethod.GET)
	public String loginchkGet() throws Exception{
		//System.out.println("login............................");
		return "member/Login";
	}
	
	//로그인 check 처리
	@RequestMapping(value="login" , method=RequestMethod.POST)
	public String loginchkPost(MemberVO member,HttpServletRequest req,HttpServletResponse response) throws Exception{
		
		System.out.println("login post.......................");
		
		response.setContentType("text/html; charset=UTF-8");
        
		PrintWriter out = response.getWriter();
		
		HttpSession session = req.getSession();
		
		member = mservice.loginCheck(member);
			
		if(member == null) {
			out.println("<script>alert('회원이 아닙니다. 회원가입 해 주세요.');</script>");
			out.flush();
			session.setAttribute("member", null);
			return "member/Member";
		}else {
			session.setAttribute("member", member);
			return "redirect:/";
		}
		
		
	}
	//로그아웃
	@RequestMapping(value="logout" , method=RequestMethod.GET)
	public String logout(HttpSession session) throws Exception{
		
		session.invalidate();
		
		return "redirect:/";
	}
	
	//Account(계정) detail 페이지
	@RequestMapping(value="account" , method=RequestMethod.GET)
	public String accountGet(@RequestParam ("member") String member,Model model) throws Exception{
		//System.out.println("Account detail ..........");
		model.addAttribute("member",mservice.accdetail(member));
		
		return "member/Account";  
	}
	
	//Account(계정) 수정 페이지 단순 이동
	@RequestMapping(value="accModify" , method=RequestMethod.GET)
	public String accModifyGet(@RequestParam ("member") String member,Model model) throws Exception{
		//System.out.println("account page.................");
		model.addAttribute("member",mservice.accdetail(member));
		return "member/AccModify";
	}
	//Account(계정) 수정
	@RequestMapping(value="accModify", method=RequestMethod.POST)
	public String accModifyPost(@ModelAttribute MemberVO member,Model model) throws Exception{
		
		//System.out.println("account modify..............");
		member.setUserid(member.getUserid());
		mservice.accmodify(member);
		return "redirect:account?member="+member.getUserid();
	}
	
	//ID/PW 찾기 페이지 이동
	//a태그 통해서 연결 되므로 get방식
	@RequestMapping(value="id_pwChk", method=RequestMethod.GET)
	public String idpwchkGet() {
		System.out.println("id/pw 찾기");
		return "member/ID_PWFind";
	}
	
	//email 찾기
	@ResponseBody 
	@RequestMapping(value="FINDID", method=RequestMethod.POST)
	public String findidPost(@ModelAttribute MemberVO member,Model model)throws Exception{

		
		//System.out.println("userid : "+member.getUserid());
		
		System.out.println("find id ajax......");
		
		MemberVO findit = mservice.findid(member);
		
		System.out.println(findit);
		
		return findit.getEmail();
	}
	//이메일로 ID 보내기
	@RequestMapping(value="mail", method=RequestMethod.POST)
	public String MailSendingPost(MailVO mail,@ModelAttribute MemberVO member,HttpServletResponse response)throws Exception{

		
			MemberVO findit = mservice.findid(member);
			
			System.out.println("이름 : "+member.getName()); //입력 한 이름
			System.out.println("전화번호 : "+member.getPhone()); // 입력 한 전화번호
			System.out.println("이메일 : "+findit.getEmail()); //이름과 전화번호를 이용한 이메일 찾기
			System.out.println("아이디 : "+findit.getUserid()); //이름과 전화번호를 이용한 아이디 찾기
			
			MimeMessage message = mailsender.createMimeMessage();
			//기본 생성자가 없으므로 매개 변수 3개의 생성자 이용
			MimeMessageHelper messageHelper = new MimeMessageHelper(message,true,"utf-8");
			try {
				
				//mailVO에 해당 값 setting
				
				//관리자 메일 주소
				//String admin = "dudtis5501@gmail.com";
				//mail.setFrom(admin);
				//root-context에 username으로 관리자 ID를 지정 해 줬기 때문에 자동으로 연결 됨.
				
				//찾은 아이디를 받을 이메일로 전송
				mail.setTomail(findit.getEmail());
				
				//System.out.println("보내는 사람 : "+mail.getTomail());
				
				//제목 설정
				String title ="Book_lys의 "+member.getName()+"님의 아이디입니다.";
				mail.setTitle(title);
				
				//내용 설정
				String contents ="Book_lys의 "+member.getName()+"님의 아이디는"+findit.getUserid()+"입니다.";
				mail.setContents(contents);
				
				messageHelper.setTo(mail.getTomail());
				messageHelper.setSubject(mail.getTitle());
				messageHelper.setText(mail.getContents());
				//messageHelper.setFrom(mail.getFrom()); //관리자 ID는 이미 root-context에 저장 되어 있으므로 지정 안 해도 됨.
				
				mailsender.send(message);
			
			}catch(Exception e) {
				e.printStackTrace();
			}		
	        
			return "redirect:id_pwChk";
			
	}
	//password 변경 하기 : 아이디와 이메일이 같은 회원 정보 찾기
	@ResponseBody 
	@RequestMapping(value="ModifyPW", method=RequestMethod.POST)
	public int findmem(MemberVO member)throws Exception{
		int result = mservice.findmem(member);
		return result;
	}
	//email로 인증 번호 적용.
	@RequestMapping(value="mailnum", method=RequestMethod.POST)
	public ModelAndView mailsendingnum(MailVO mail,HttpServletRequest request,HttpServletResponse response)throws Exception{
		
		//랜덤한 난수(인증 번호 )생성
		Random r = new Random();
		int dice = r.nextInt(157211)+48271;
		
		//메일 정보 작성
		//받는 분 정보
		String tomail = request.getParameter("email");
		System.out.println("받는 분 : "+tomail);
		mail.setTomail(tomail);
		
		//제목 설정
		String title ="비밀 번호 찾기 인증 이메일입니다.";
		mail.setTitle(title);
		
		//내용 설정
		String contents = "비밀번호 찾기 인증번호는 "+dice+" 입니다."
				+ System.getProperty("line.separator") 
				+ "받으신 인증번호를 홈페이지에 입력해 주시면 다음으로 넘어갑니다.";
		mail.setContents(contents);
		
		try {
			MimeMessage message = mailsender.createMimeMessage();
			//기본 생성자가 없으므로 매개 변수 3개의 생성자 이용
			MimeMessageHelper messageHelper = new MimeMessageHelper(message,true,"utf-8");
			
			messageHelper.setTo(mail.getTomail());
			messageHelper.setSubject(mail.getTitle());
			messageHelper.setText(mail.getContents());
			
			mailsender.send(message);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/PwKey");
		mv.addObject("dice",dice); //임시 번호 저장
		mv.addObject("email",tomail);
		
		System.out.println("mv : "+mv);
		
		response.setContentType("text/html; charset=UTF-8");
        PrintWriter out_email = response.getWriter();
        out_email.println("<script>alert('이메일이 발송되었습니다. 인증번호를 입력해주세요.');</script>");
        out_email.flush();
        
		return mv;
		
	}
	//인증 화면으로 이동 후 인증
	@RequestMapping(value="pass_injeung",method=RequestMethod.POST)
	public ModelAndView pass_injeung(HttpServletRequest request,HttpServletResponse response)throws Exception {
		
		//System.out.println("입력 한 인증번호 : "+request.getParameter("pwkey"));
		//System.out.println("dice : "+request.getParameter("dice"));
		//System.out.println("email :"+request.getParameter("email"));
		
		String pwkey = request.getParameter("pwkey"); //입력 한 인증번호
		String dice = request.getParameter("dice"); //Random 번호
		String email = request.getParameter("email");
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("member/Pw_Change");
		mv.addObject("email",email);
		
		if(pwkey.equals(dice)) {
			//System.out.println("비교가 되니?");
			//System.out.println("pwkey : "+pwkey);
			//System.out.println("dice : "+dice);
			
			mv.setViewName("member/Pw_Change");
			mv.addObject("email",email);
			
			response.setContentType("text/html; charset=UTF-8");
            PrintWriter out_equals = response.getWriter();
            out_equals.println("<script>alert('인증번호가 일치하였습니다. 비밀번호 변경창으로 이동합니다.');</script>");
            out_equals.flush();
            
			return mv;
		}else if(!pwkey.equals(dice)) {
			ModelAndView mv2 = new ModelAndView();
			mv2.setViewName("member/PwKey");
			
			response.setContentType("text/html; charset=UTF-8");
            PrintWriter out_equals = response.getWriter();
            out_equals.println("<script>alert('인증번호가 일치하지않습니다. 인증번호를 다시 입력해주세요.'); history.go(-1);</script>");
            out_equals.flush();
            
            return mv2;
		}
		return mv;        
	}
	
	//인증 완료 된 후 패스워드 변경
	@RequestMapping(value="pass_change",method=RequestMethod.POST)
	public ModelAndView pass_change(MemberVO member,HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		
		System.out.println("password : "+password);
		System.out.println("email : "+email);
			
		member.setEmail(email);
		member.setPassword(password);
		
		//이메일과 수정 패스워드를 담아야 되므로 Map 이용.
		Map<String,Object> map = new HashMap<>();
		
		map.put("email",member.getEmail());
		map.put("password", member.getPassword());
		
		mservice.pass_change(member, map);
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("member/Login");
		
		response.setContentType("text/html; charset=UTF-8");
        PrintWriter out_equals = response.getWriter();
        out_equals.println("<script>alert('password 변경이 완료 되었습니다.login 해 주세요.');</script>");
        out_equals.flush();
	
		return mv;
	}
	//회원 탈퇴 page 단순 이동
	@RequestMapping(value="memberdel",method=RequestMethod.GET)
	public String memberdelget()throws Exception{
		return "member/MemberDel";
	}
	
	//회원 탈퇴
	@RequestMapping(value="memberdel",method=RequestMethod.POST)
	public String memberdelpost(@SessionAttribute("member")MemberVO member,MemberVO newmem,
			RedirectAttributes rttr,HttpSession session)throws Exception{
		System.out.println("회원 탈퇴 post.............");
		
		//System.out.println("세션 : "+member.getUserid());
		//System.out.println("세션 패스워드 :"+member.getPassword());
		//System.out.println("아이디 : "+newmem.getUserid());
		//System.out.println("내가 입력한 패스워드 : "+newmem.getPassword());
		
		newmem.setUserid(member.getUserid());
		
		if(!member.getPassword().equals(newmem.getPassword())) {
			rttr.addFlashAttribute("msg",false);
			return "redirect:memberdel";
		}
		
		mservice.memberdel(member);
		session.invalidate();
        return "redirect:/";
	}
	
}
