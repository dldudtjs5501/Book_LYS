package com.lys.controller;

import java.io.File;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;

import com.lys.model.BookVO;
import com.lys.model.Book_Criteria;
import com.lys.model.Book_PageVO;
import com.lys.model.MemberVO;
import com.lys.service.BookService;
import com.lys.utils.UploadFileUtils;


@Controller
@RequestMapping("/Book")
public class BookController {
	
	@Autowired
	private BookService Bservice;
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	private static final Logger logger=LoggerFactory.getLogger((BookController.class));

	//상품 등록 페이지 단순 이동
	@RequestMapping(value="bookwrite" , method=RequestMethod.GET )
	public String bookregGet(@SessionAttribute("member")MemberVO member,Model model)throws Exception{
		System.out.println("bookwrite Get................");
		model.addAttribute("member",member.getUserid());
		return "Book/BookWrite";
	}
	//상품 등록 
	@RequestMapping(value="bookwrite", method=RequestMethod.POST )
	public String bookregPost(BookVO book,MultipartFile file)throws Exception{
		
		System.out.println("bookwrite post ....................");
		
		String imgUploadPath = uploadPath + File.separator + "Booklys_Image"; //이미지 업로드 저장소
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath); //년도
		String fileName = null; //파일 전체 이름
		
		System.out.println("------------------ imgUploadPath : "+imgUploadPath);
		System.out.println("------------------ ymdPath : "+ymdPath);
		System.out.println("------------------ file : "+file.getOriginalFilename());
		System.out.println("------------------ file size : "+file.getSize());

		if(!file.getOriginalFilename().equals("") && !file.getOriginalFilename().equals(null)) {
			fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);
			System.out.println("fileName : "+fileName);
		} else {
		 //fileName = uploadPath + File.separator + "images" + File.separator + "none.png";
		}

		book.setB_img(File.separator + "Booklys_Image" + ymdPath + File.separator + fileName);
		book.setB_thumbnail(File.separator + "Booklys_Image" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
		
		Bservice.bookwrite(book);
		
		return "redirect:booklist";		
	}
	//상품 리스트 
	/*@RequestMapping(value="booklist" , method=RequestMethod.GET)
	public String booklistGet(Model model) throws Exception{
		System.out.println("Booklist...............");
		model.addAttribute("list",Bservice.booklist());
		return "Book/BookList";
	}*/
	
	//상품 리스트 페이징 처리 
	@RequestMapping(value="booklist" , method=RequestMethod.GET)
		public String booklistGet(Book_Criteria bcri,Model model) throws Exception{
		
		int b_total = Bservice.boardcount(bcri);
		
		System.out.println("controller bcri : "+bcri);
		System.out.println("controller total : "+b_total);
		
		Book_PageVO bp = new Book_PageVO(bcri,b_total);
	
		System.out.println("bp: "+bp);
		
		
		System.out.println("Bservice.booklistpaging(bcri) :"+Bservice.booklistpaging(bcri));
		
		model.addAttribute("list",Bservice.booklistpaging(bcri)); //페이징에 대한 정보
		model.addAttribute("page", bp);
		
		return "Book/BookList";
	}
	//상품 상세 페이지 이동 및 내용 확인
	@RequestMapping(value="bookdtail",method=RequestMethod.GET)
	public String bookdetailGet(@RequestParam("bookno") int bookno,Model model)throws Exception{
		System.out.println("BookDetail Get------------");
		model.addAttribute("bookno",Bservice.bookdetail(bookno));
		return "Book/BookDetail";
	}
	//상품 수정 페이지로 단순 이동(기존 내용이 보여야 되므로 화면에 상품 번호 저장)
	@RequestMapping(value="bookmodify" , method=RequestMethod.GET)
	public String bookmodifyGet(@RequestParam int bookmodify, Model model) throws Exception{
		System.out.println("BookmodifyGet...............");
		model.addAttribute("bookmodify", Bservice.bookdetail(bookmodify));
		return "Book/BookModify";
	}
	
	//상품 수정(이미지 수정도 이뤄져야 됨)
	@RequestMapping(value="bookmodify" , method=RequestMethod.POST)
	public String bookmodifyPost(BookVO book,Model model,MultipartFile file,HttpServletRequest req) throws Exception{
		
		System.out.println("BookmodifyPost...............");
		
		//새로운 파일이 등록 되었는지 확인
		if(!file.getOriginalFilename().equals("") && !file.getOriginalFilename().equals(null)) {
			//기존 파일을 삭제
			new File(uploadPath + req.getParameter("b_img")).delete();
			new File(uploadPath + req.getParameter("b_thumbnail")).delete();
			
			//새로 첨부한 파일을 등록
			String imgUploadPath = uploadPath + File.separator + "Booklys_Image"; //이미지 업로드 저장소
			String ymdPath = UploadFileUtils.calcPath(imgUploadPath); //년도
			String fileName = UploadFileUtils.fileUpload(imgUploadPath,file.getOriginalFilename(),file.getBytes(),ymdPath);
			
			book.setB_img(File.separator + "Booklys_Image" + ymdPath + File.separator + fileName);
			book.setB_thumbnail(File.separator + "Booklys_Image" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
		}else {//새로운 파일이 등록 되지 않았다면 기존 이미지 그대로 사용
			//뷰에 저장 된 정보를 가져 와야 되므로 jsp 파일에서 값을 넘겨 줘야 됨.
			book.setB_img(req.getParameter("b_img"));
			book.setB_thumbnail(req.getParameter("b_thumbnail"));
		}
		Bservice.bookmodify(book);
		
		return "redirect:booklist?bookno="+book.getBookno();
	}
	
	//상품 삭제(이미지도 같이 삭제)
	@RequestMapping(value="bookdelete" , method=RequestMethod.GET)
	public String bookdel(BookVO book,@RequestParam int bookno)throws Exception{
		
		System.out.println("bookdelete Get.............");
		
		//상품 이미지 url을 filename에 저장
		String filename = Bservice.bookimgurl(bookno);
		System.out.println("filename : "+filename);
		
		//filename 값이 null이 아니거나 filename에 속해 있는 값이 ("-")와 같은 것
		if(!filename.equals(null) && !filename.equals("-")) {
			
			String imgUploadPath = uploadPath + File.separator;
			
			File file = new File(imgUploadPath+filename);
			
			if(file.exists()) {
				
				file.delete();
			}
		
		}
		Bservice.bookdel(bookno);
		return "redirect:booklist";
	}
	
	
}
