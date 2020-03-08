package com.lys.model;

public class MemberVO {
	
	//회원 가입
	
	private String userid;			 //ID
	private String password;	 //Password
	private String name;		 //Name
	private String address_post; //우편번호
	private String address_road; //도로 주소
	private String address_jibun; //지번 주소
	private String address_detail;//상세 주소
	private String phone; 			  //휴대폰 번호
	private String email;		  //email
	
	//getter / setter
	
	public String getUserid() {
		return userid;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress_post() {
		return address_post;
	}
	public void setAddress_post(String address_post) {
		this.address_post = address_post;
	}
	public String getAddress_road() {
		return address_road;
	}
	public void setAddress_road(String address_road) {
		this.address_road = address_road;
	}
	public String getAddress_jibun() {
		return address_jibun;
	}
	public void setAddress_jibun(String address_jibun) {
		this.address_jibun = address_jibun;
	}
	public String getAddress_detail() {
		return address_detail;
	}
	public void setAddress_detail(String address_detail) {
		this.address_detail = address_detail;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	//회원가입폼에서 입력 된 값 확인
	@Override
	public String toString() {
		return "MemberVO [userid=" + userid + ", password=" + password + ", name=" + name + ", address_post="
				+ address_post + ", address_road=" + address_road + ", address_jibun=" + address_jibun
				+ ", address_detail=" + address_detail + ", phone=" + phone + ", email=" + email + "]";
	}
	

}
