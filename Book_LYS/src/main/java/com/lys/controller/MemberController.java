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
	
	//ȸ�� ���� ������ �ܼ� �̵�
	@RequestMapping(value="register" , method=RequestMethod.GET)
	public String memberGet() throws Exception{
		//System.out.println("register get.................");
		return "member/Member";
	}
	
	//ȸ�� ���� �� �Է� �� ���� database�� ���� -> login�������� �̵�
	@RequestMapping(value="register" , method=RequestMethod.POST)
	public String memberPost(MemberVO member , Model model) throws Exception{
		
		//System.out.println("register......................");
		
		int result = mservice.idchk(member);
		
		System.out.println("id : "+member.getUserid());
		//System.out.println(member.getAddress_post() + member.getAddress_jibun() + "/" + member.getAddress_road());
		try {
			if(result == 1) {
				//�Է� �� ���̵� ���� -> ȸ������ ������
				return "member/register";
			}else if(result == 0) {
				//�Է� �� ���̵� ������ -> ���
				mservice.Mregister(member);
				//System.out.println("������ �Ǵ�?");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "redirect:login"; 
	}
	
	//id �ߺ� üũ
	@RequestMapping(value="IDCHK")
	@ResponseBody //������ ��ȯ ���� ������ �ְ� �ޱ� ���� ��.post ��ĸ� ���
	public int idchk(MemberVO member) throws Exception{ //MemberVO member = #{�ʵ��} ó���� ���� ��
		//System.out.println("idchk.............");
		int result = mservice.idchk(member);
		return result;
	}
	//�α��� �������� �ܼ� �̵�
	@RequestMapping(value="login" , method=RequestMethod.GET)
	public String loginchkGet() throws Exception{
		//System.out.println("login............................");
		return "member/Login";
	}
	
	//�α��� check ó��
	@RequestMapping(value="login" , method=RequestMethod.POST)
	public String loginchkPost(MemberVO member,HttpServletRequest req,HttpServletResponse response) throws Exception{
		
		System.out.println("login post.......................");
		
		response.setContentType("text/html; charset=UTF-8");
        
		PrintWriter out = response.getWriter();
		
		HttpSession session = req.getSession();
		
		member = mservice.loginCheck(member);
			
		if(member == null) {
			out.println("<script>alert('ȸ���� �ƴմϴ�. ȸ������ �� �ּ���.');</script>");
			out.flush();
			session.setAttribute("member", null);
			return "member/Member";
		}else {
			session.setAttribute("member", member);
			return "redirect:/";
		}
		
		
	}
	//�α׾ƿ�
	@RequestMapping(value="logout" , method=RequestMethod.GET)
	public String logout(HttpSession session) throws Exception{
		
		session.invalidate();
		
		return "redirect:/";
	}
	
	//Account(����) detail ������
	@RequestMapping(value="account" , method=RequestMethod.GET)
	public String accountGet(@RequestParam ("member") String member,Model model) throws Exception{
		//System.out.println("Account detail ..........");
		model.addAttribute("member",mservice.accdetail(member));
		
		return "member/Account";  
	}
	
	//Account(����) ���� ������ �ܼ� �̵�
	@RequestMapping(value="accModify" , method=RequestMethod.GET)
	public String accModifyGet(@RequestParam ("member") String member,Model model) throws Exception{
		//System.out.println("account page.................");
		model.addAttribute("member",mservice.accdetail(member));
		return "member/AccModify";
	}
	//Account(����) ����
	@RequestMapping(value="accModify", method=RequestMethod.POST)
	public String accModifyPost(@ModelAttribute MemberVO member,Model model) throws Exception{
		
		//System.out.println("account modify..............");
		member.setUserid(member.getUserid());
		mservice.accmodify(member);
		return "redirect:account?member="+member.getUserid();
	}
	
	//ID/PW ã�� ������ �̵�
	//a�±� ���ؼ� ���� �ǹǷ� get���
	@RequestMapping(value="id_pwChk", method=RequestMethod.GET)
	public String idpwchkGet() {
		System.out.println("id/pw ã��");
		return "member/ID_PWFind";
	}
	
	//email ã��
	@ResponseBody 
	@RequestMapping(value="FINDID", method=RequestMethod.POST)
	public String findidPost(@ModelAttribute MemberVO member,Model model)throws Exception{

		
		//System.out.println("userid : "+member.getUserid());
		
		System.out.println("find id ajax......");
		
		MemberVO findit = mservice.findid(member);
		
		System.out.println(findit);
		
		return findit.getEmail();
	}
	//�̸��Ϸ� ID ������
	@RequestMapping(value="mail", method=RequestMethod.POST)
	public String MailSendingPost(MailVO mail,@ModelAttribute MemberVO member,HttpServletResponse response)throws Exception{

		
			MemberVO findit = mservice.findid(member);
			
			System.out.println("�̸� : "+member.getName()); //�Է� �� �̸�
			System.out.println("��ȭ��ȣ : "+member.getPhone()); // �Է� �� ��ȭ��ȣ
			System.out.println("�̸��� : "+findit.getEmail()); //�̸��� ��ȭ��ȣ�� �̿��� �̸��� ã��
			System.out.println("���̵� : "+findit.getUserid()); //�̸��� ��ȭ��ȣ�� �̿��� ���̵� ã��
			
			MimeMessage message = mailsender.createMimeMessage();
			//�⺻ �����ڰ� �����Ƿ� �Ű� ���� 3���� ������ �̿�
			MimeMessageHelper messageHelper = new MimeMessageHelper(message,true,"utf-8");
			try {
				
				//mailVO�� �ش� �� setting
				
				//������ ���� �ּ�
				//String admin = "dudtis5501@gmail.com";
				//mail.setFrom(admin);
				//root-context�� username���� ������ ID�� ���� �� ��� ������ �ڵ����� ���� ��.
				
				//ã�� ���̵� ���� �̸��Ϸ� ����
				mail.setTomail(findit.getEmail());
				
				//System.out.println("������ ��� : "+mail.getTomail());
				
				//���� ����
				String title ="Book_lys�� "+member.getName()+"���� ���̵��Դϴ�.";
				mail.setTitle(title);
				
				//���� ����
				String contents ="Book_lys�� "+member.getName()+"���� ���̵��"+findit.getUserid()+"�Դϴ�.";
				mail.setContents(contents);
				
				messageHelper.setTo(mail.getTomail());
				messageHelper.setSubject(mail.getTitle());
				messageHelper.setText(mail.getContents());
				//messageHelper.setFrom(mail.getFrom()); //������ ID�� �̹� root-context�� ���� �Ǿ� �����Ƿ� ���� �� �ص� ��.
				
				mailsender.send(message);
			
			}catch(Exception e) {
				e.printStackTrace();
			}		
	        
			return "redirect:id_pwChk";
			
	}
	//password ���� �ϱ� : ���̵�� �̸����� ���� ȸ�� ���� ã��
	@ResponseBody 
	@RequestMapping(value="ModifyPW", method=RequestMethod.POST)
	public int findmem(MemberVO member)throws Exception{
		int result = mservice.findmem(member);
		return result;
	}
	//email�� ���� ��ȣ ����.
	@RequestMapping(value="mailnum", method=RequestMethod.POST)
	public ModelAndView mailsendingnum(MailVO mail,HttpServletRequest request,HttpServletResponse response)throws Exception{
		
		//������ ����(���� ��ȣ )����
		Random r = new Random();
		int dice = r.nextInt(157211)+48271;
		
		//���� ���� �ۼ�
		//�޴� �� ����
		String tomail = request.getParameter("email");
		System.out.println("�޴� �� : "+tomail);
		mail.setTomail(tomail);
		
		//���� ����
		String title ="��� ��ȣ ã�� ���� �̸����Դϴ�.";
		mail.setTitle(title);
		
		//���� ����
		String contents = "��й�ȣ ã�� ������ȣ�� "+dice+" �Դϴ�."
				+ System.getProperty("line.separator") 
				+ "������ ������ȣ�� Ȩ�������� �Է��� �ֽø� �������� �Ѿ�ϴ�.";
		mail.setContents(contents);
		
		try {
			MimeMessage message = mailsender.createMimeMessage();
			//�⺻ �����ڰ� �����Ƿ� �Ű� ���� 3���� ������ �̿�
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
		mv.addObject("dice",dice); //�ӽ� ��ȣ ����
		mv.addObject("email",tomail);
		
		System.out.println("mv : "+mv);
		
		response.setContentType("text/html; charset=UTF-8");
        PrintWriter out_email = response.getWriter();
        out_email.println("<script>alert('�̸����� �߼۵Ǿ����ϴ�. ������ȣ�� �Է����ּ���.');</script>");
        out_email.flush();
        
		return mv;
		
	}
	//���� ȭ������ �̵� �� ����
	@RequestMapping(value="pass_injeung",method=RequestMethod.POST)
	public ModelAndView pass_injeung(HttpServletRequest request,HttpServletResponse response)throws Exception {
		
		//System.out.println("�Է� �� ������ȣ : "+request.getParameter("pwkey"));
		//System.out.println("dice : "+request.getParameter("dice"));
		//System.out.println("email :"+request.getParameter("email"));
		
		String pwkey = request.getParameter("pwkey"); //�Է� �� ������ȣ
		String dice = request.getParameter("dice"); //Random ��ȣ
		String email = request.getParameter("email");
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("member/Pw_Change");
		mv.addObject("email",email);
		
		if(pwkey.equals(dice)) {
			//System.out.println("�񱳰� �Ǵ�?");
			//System.out.println("pwkey : "+pwkey);
			//System.out.println("dice : "+dice);
			
			mv.setViewName("member/Pw_Change");
			mv.addObject("email",email);
			
			response.setContentType("text/html; charset=UTF-8");
            PrintWriter out_equals = response.getWriter();
            out_equals.println("<script>alert('������ȣ�� ��ġ�Ͽ����ϴ�. ��й�ȣ ����â���� �̵��մϴ�.');</script>");
            out_equals.flush();
            
			return mv;
		}else if(!pwkey.equals(dice)) {
			ModelAndView mv2 = new ModelAndView();
			mv2.setViewName("member/PwKey");
			
			response.setContentType("text/html; charset=UTF-8");
            PrintWriter out_equals = response.getWriter();
            out_equals.println("<script>alert('������ȣ�� ��ġ�����ʽ��ϴ�. ������ȣ�� �ٽ� �Է����ּ���.'); history.go(-1);</script>");
            out_equals.flush();
            
            return mv2;
		}
		return mv;        
	}
	
	//���� �Ϸ� �� �� �н����� ����
	@RequestMapping(value="pass_change",method=RequestMethod.POST)
	public ModelAndView pass_change(MemberVO member,HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		
		System.out.println("password : "+password);
		System.out.println("email : "+email);
			
		member.setEmail(email);
		member.setPassword(password);
		
		//�̸��ϰ� ���� �н����带 ��ƾ� �ǹǷ� Map �̿�.
		Map<String,Object> map = new HashMap<>();
		
		map.put("email",member.getEmail());
		map.put("password", member.getPassword());
		
		mservice.pass_change(member, map);
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("member/Login");
		
		response.setContentType("text/html; charset=UTF-8");
        PrintWriter out_equals = response.getWriter();
        out_equals.println("<script>alert('password ������ �Ϸ� �Ǿ����ϴ�.login �� �ּ���.');</script>");
        out_equals.flush();
	
		return mv;
	}
	//ȸ�� Ż�� page �ܼ� �̵�
	@RequestMapping(value="memberdel",method=RequestMethod.GET)
	public String memberdelget()throws Exception{
		return "member/MemberDel";
	}
	
	//ȸ�� Ż��
	@RequestMapping(value="memberdel",method=RequestMethod.POST)
	public String memberdelpost(@SessionAttribute("member")MemberVO member,MemberVO newmem,
			RedirectAttributes rttr,HttpSession session)throws Exception{
		System.out.println("ȸ�� Ż�� post.............");
		
		//System.out.println("���� : "+member.getUserid());
		//System.out.println("���� �н����� :"+member.getPassword());
		//System.out.println("���̵� : "+newmem.getUserid());
		//System.out.println("���� �Է��� �н����� : "+newmem.getPassword());
		
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
