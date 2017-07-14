package com.hanbit.member.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hanbit.member.constants.DB;

public class JDBCTest {
	public static void main(String[] args) {
		String findName="";
		Connection conn=null;
		try {
			Class.forName(DB.DRIVER);
			conn=DriverManager.getConnection(DB.URL,DB.USERID,DB.PASSWORD);
			Statement stmt=conn.createStatement();
			String sql="SELECT * FROM Member WHERE id='hong'"; //where=if(id="hong")
			ResultSet rs=stmt.executeQuery(sql);
			
			if(rs.next()){
				findName=rs.getString("name");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{ //여기는 없어도 돌아감, 가비지 컬렉션 때문에 제거가 됨 ㅋㅋ
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("### 결과:"+findName);
	}
}
