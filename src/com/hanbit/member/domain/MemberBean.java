package com.hanbit.member.domain;

public class MemberBean {
	   private String id, name, password, ssn, regdate;


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getSsn() {
		return ssn;
	}


	public void setSsn(String ssn) {
		this.ssn = ssn;
	}


	public String getRegdate() {
		return regdate;
	}


	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String toString(){
		   return "회원 [id=" +id+" name="+name+" ssn="+ssn+"]\n";
		
	   }


}

