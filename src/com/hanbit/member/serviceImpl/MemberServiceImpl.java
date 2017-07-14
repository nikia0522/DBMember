package com.hanbit.member.serviceImpl;
import java.util.ArrayList;
import java.util.List;

import com.hanbit.member.dao.MemberDAO;
import com.hanbit.member.daoImpl.MemberDAOImpl;
import com.hanbit.member.domain.MemberBean;
import com.hanbit.member.service.MemberService;

public class MemberServiceImpl implements MemberService{
	MemberBean member;
	List<MemberBean> list;
	public MemberServiceImpl(){
		list=new ArrayList<MemberBean>(); 
		member=new MemberBean();
	}
	
	@Override
	public String addMember(MemberBean member) {
		return (new MemberDAOImpl().insert(member)==1)? "성공":"실패";
	}
		
	@Override
	public List<MemberBean> getMembers() {		
		return (new MemberDAOImpl().selectAll());
	}
	
	@Override
	public int countMembers() {
		return new MemberDAOImpl().countMembers();
	}
	
	@Override
	public MemberBean findById(String id) {	
		MemberBean member=new MemberBean();
		MemberDAO dao=new MemberDAOImpl();
		member=dao.selectById(id);
		for(MemberBean mem:list){
			if(id.equals(mem.getId())){
				member=mem;
				break;
			}
		}
		return member;
	}

	@Override
	public List<MemberBean> findByName(String name) {
		return new MemberDAOImpl().selectByName(name);
	}

	@Override
	public String modify(MemberBean member) {		
		String msg="";
		MemberDAO dao=new MemberDAOImpl();
		int rs=dao.updatePass(member);
		if(rs==1){
			msg="성공";
		}else{
			msg="실패";
		}return msg;
	}
	
	@Override
	public String remove(String id) {
		String msg="";
		MemberDAO dao=new MemberDAOImpl();
		int rs=dao.insert(member);
		if(rs==1){
			msg="성공";
		}else{
			msg="실패";
		}return msg;
	}
}

