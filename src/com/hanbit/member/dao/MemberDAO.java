package com.hanbit.member.dao;

import java.util.List;

import com.hanbit.member.domain.MemberBean;

public interface MemberDAO {
	public int insert(MemberBean member); // 객체에 대한 setter (void, parameter 있음)
	public int countMembers(); //getter (return type 있고 parameter 없음)
	public List<MemberBean> selectAll(); //getter (return type 있고 parameter 없음)
	public MemberBean selectById(String id); //보안사항이 아니기때문에 public으로..
	public List<MemberBean> selectByName(String name);
	public int updatePass(MemberBean member);
	public int deleteMember(String id); //int- 성공여부를 알려주는것임
}
