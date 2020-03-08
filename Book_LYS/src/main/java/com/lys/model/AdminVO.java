package com.lys.model;

public class AdminVO {
	
	
	private String admin_id; //admin ID	
	private String admin_pw; //admin password
	private String admin_name; //admin ÀÌ¸§	
	private String admin_email;	//admin email
	private String admin_regdata; 
	private String admin_updata;
	
	public String getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
	public String getAdmin_pw() {
		return admin_pw;
	}
	public void setAdmin_pw(String admin_pw) {
		this.admin_pw = admin_pw;
	}
	public String getAdmin_name() {
		return admin_name;
	}
	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}
	public String getAdmin_email() {
		return admin_email;
	}
	public void setAdmin_email(String admin_email) {
		this.admin_email = admin_email;
	}
	public String getAdmin_regdata() {
		return admin_regdata;
	}
	public void setAdmin_regdata(String admin_regdata) {
		this.admin_regdata = admin_regdata;
	}
	public String getAdmin_updata() {
		return admin_updata;
	}
	public void setAdmin_updata(String admin_updata) {
		this.admin_updata = admin_updata;
	}
	
	@Override
	public String toString() {
		return "AdminVO [admin_id=" + admin_id + ", admin_pw=" + admin_pw + ", admin_name=" + admin_name
				+ ", admin_email=" + admin_email + ", admin_regdata=" + admin_regdata + ", admin_updata=" + admin_updata
				+ "]";
	}
	
}
