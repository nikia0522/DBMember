package com.hanbit.member.daoImpl;

import java.util.ArrayList;
import java.util.List;

import com.hanbit.member.constants.DB;
import com.hanbit.member.dao.MemberDAO;
import com.hanbit.member.domain.MemberBean;
import java.sql.*;
public class MemberDAOImpl implements MemberDAO{
	public MemberDAOImpl(){ //Class.forName을 공유한다. connection은 공유하지 않는다.
		try {
			Class.forName(DB.DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("driver load fail...");
			e.printStackTrace();
		}
	}
	//실제로는 finally close 하지 말것->GC
	@Override
	public int insert(MemberBean member) {
		int rs=0;
		try {
			rs=DriverManager.getConnection(DB.URL, DB.USERID, DB.PASSWORD).createStatement().executeUpdate(String.format("INSERT INTO %s(%s,%s,%s,%s,%s)VALUES('%s', '%s', '%s', '%s', SYSDATE)",DB.TABLE_MEMBER,DB.MEMBER_ID, DB.MEMBER_NAME, DB.MEMBER_PASS, DB.MEMBER_SSN, member.getId(), member.getName(), member.getPassword(), member.getSsn()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
		
	}

	@Override
	public int countMembers() {
		int count=0;
		try {
			ResultSet rs=DriverManager.getConnection(DB.URL,DB.USERID,DB.PASSWORD).createStatement().executeQuery(String.format("SELECT COUNT(*) AS	%s FROM %s","count",DB.TABLE_MEMBER));
			if(rs.next()){
				count=Integer.parseInt(rs.getString("count"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public List<MemberBean> selectAll() {
		List<MemberBean>list=new ArrayList<>();
		try {
			ResultSet rs=DriverManager.getConnection(DB.URL, DB.USERID, DB.PASSWORD).createStatement().executeQuery(String.format("SELECT * FROM %s", DB.TABLE_MEMBER));
			MemberBean member=null; //지역변수는 반드시 초기화
			while(rs.next()){ //여러개 호출하기 때문에 while loop
				member=new MemberBean();
				member.setId(rs.getString(DB.MEMBER_ID));
				member.setName(rs.getString(DB.MEMBER_NAME));
				member.setSsn(rs.getString(DB.MEMBER_SSN));
				list.add(member);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return list;
	}

	@Override
	public MemberBean selectById(String id) {
		MemberBean member=new MemberBean();
		try {
			ResultSet rs=DriverManager.getConnection(DB.URL, DB.USERID, DB.PASSWORD).createStatement().executeQuery(String.format("SELECT * FROM Member WHERE id='%s'", id));
			if(rs.next()){
				member.setId(rs.getString(DB.MEMBER_ID));
				member.setName(rs.getString(DB.MEMBER_NAME));
				member.setSsn(rs.getString(DB.MEMBER_SSN));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return member;
	}

	@Override
	public List<MemberBean> selectByName(String name) {
		List<MemberBean> nameList=new ArrayList<>();
				try {
			ResultSet rs=DriverManager.getConnection(DB.URL, DB.USERID,DB.PASSWORD).createStatement().executeQuery(String.format("SELECT * FROM Member WHERE name='%s'", name));
			MemberBean member=null;
			while(rs.next()){
				member=new MemberBean(); 
				member.setId(rs.getString(DB.MEMBER_ID));
				member.setName(rs.getString(DB.MEMBER_NAME));
				member.setSsn(rs.getString(DB.MEMBER_SSN));
				nameList.add(member);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return nameList;
	}

	@Override
	public int updatePass(MemberBean member) {
		int rs=0;
		try {
			rs=DriverManager.getConnection(DB.URL, DB.USERID, DB.PASSWORD).createStatement().executeUpdate(String.format("%s",""));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;

		
	}

	@Override
	public int deleteMember(String id) {
		int rs=0;
		try {
			rs=DriverManager.getConnection(DB.URL, DB.USERID, DB.PASSWORD).createStatement().executeUpdate(String.format("%s",""));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
		
	}

}
