package com.hanbit.member.controller;

import java.util.List;

import javax.swing.JOptionPane;

import com.hanbit.member.constants.Butt;
import com.hanbit.member.domain.MemberBean;
import com.hanbit.member.service.MemberService;
import com.hanbit.member.serviceImpl.MemberServiceImpl;

public class MemberController {
	public static void main(String[] args){
		MemberService service=(MemberService) new MemberServiceImpl();
		MemberBean member=null; //declaration
		Butt[] buttons={Butt.EXIT, Butt.ADD, Butt.LIST, Butt.FIND_NAME, Butt.FIND_ID, Butt.COUNT, Butt.UPDATE, Butt.DELETE};
		do{
			flag: //라벨
			switch((Butt)JOptionPane.showInputDialog(null, "MEMBER ADMIN", "SELECT MENU", JOptionPane.QUESTION_MESSAGE, null, buttons, buttons[1])){
			case EXIT:
				return;
	
			case ADD:
				member=new MemberBean(); //초기화
				String[] arr=(JOptionPane.showInputDialog("ID/이름/Password/SSN")).split("/");
				member.setId(arr[0]);
				member.setName(arr[1]);
				member.setPassword(arr[2]);
				member.setSsn(arr[3]);
				JOptionPane.showMessageDialog(null, service.addMember(member));
				break flag;
				
			case COUNT:							
				JOptionPane.showMessageDialog(null,service.countMembers());
				break flag;
			
			case LIST:
				JOptionPane.showMessageDialog(null, service.getMembers());
				break flag;

			case FIND_ID:
				JOptionPane.showMessageDialog(null, service.findById((JOptionPane.showInputDialog(null, "조회하려는 ID를 입력하세요"))).toString());
				break flag;
				
			case FIND_NAME:			
				JOptionPane.showMessageDialog(null, service.findByName((JOptionPane.showInputDialog(null, "찾으려는 이름을 입력하세요"))));
				break flag;
				
			case UPDATE:
				member = new MemberBean();
				String updateId=JOptionPane.showInputDialog("ID를 입력하세요.");
				member.setId(updateId);
				member.setPassword(JOptionPane.showInputDialog("바꿀 비밀번호"));
				member.setName(JOptionPane.showInputDialog("바꿀 이름"));
				member.setSsn(JOptionPane.showInputDialog("바꿀SSN"));
				service.modify(member);
				JOptionPane.showMessageDialog(null, "변경 성공");
				break flag;
			case DELETE:
				String deleteId=JOptionPane.showInputDialog("지울 회원 ID를 입력하세요");
				service.remove(deleteId);
				JOptionPane.showMessageDialog(null, "삭제 완료");
				break flag;
			}
		}while(true);
	}
}
