package com.kh.mvc.member.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.kh.mvc.common.jdbc.JDBCTemplate.*;
import com.kh.mvc.member.model.vo.Member;

// 실제 데이터 베이스와 연결해서 데이터 가져옴
public class MemberDao {
	public Member findMemberById (Connection connection, String id) {
		Member member = null;
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String query = "SELECT * FROM MEMBER WHERE ID=? AND STATUS='Y'";
		
		try {
			// 오라클 드라이버 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 등록된 드라이버를 가지고 connect 해준다.
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "WEB", "WEB");
			
			pstm = conn.prepareStatement(query);
			
			// pstm 실행하기 전에 ?에 들어갈 값들을 세팅해준다.
			pstm.setString(1, id);
			// 쿼리문 실행 후 rs에 결과값 담아준다.
			rs = pstm.executeQuery();
			
			// next를 통해 결과값이 있는지 확인
			if(rs.next()) {
				// 해당하는 컬럼의 값 가져오기 (순서대로)
				// sql에 있는 하나의 행은 자바로 불러올 때 하나의 객체로 만들어준다.
//				System.out.println("ID : " + rs.getString("ID") + ", Password : " + rs.getString("PASSWORD") + ", NAME : " + rs.getString("NAME"));
				
				member = new Member();
				
				member.setNo(rs.getInt("NO"));
				member.setId(rs.getString("ID"));
				member.setPassword(rs.getString("PASSWORD"));
				member.setRole(rs.getString("ROLE"));
				member.setName(rs.getString("NAME"));
				member.setPhone(rs.getString("PHONE"));
				member.setEmail(rs.getString("EMAIL"));
				member.setAddress(rs.getString("ADDRESS"));
				member.setHobby(rs.getString("HOBBY"));
				member.setStatus(rs.getString("STATUS"));
				member.setEnrollDate(rs.getDate("ENROLL_DATE"));
				member.setModifyDate(rs.getDate("MODIFY_DATE"));
				
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			// 가져온 역순대로 close
			try {
				rs.close();
				pstm.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		// member로 리턴해준다.
		return member;
	}
	
//	public Member findMemberById(Connection connection, String id) {
//		Member member = null;
//		PreparedStatement pstm = null;	// preparedStatement가 실제로 connection에서 가져오고 결과값을 프로그램으로 받아옴
//		ResultSet rs = null;
//		String query = "SELECT * FROM MEMBER WHERE ID=? AND STATUS='Y'";
//		
//		try {
//			
//			pstm = connection.prepareStatement(query);
//			
//			pstm.setString(1, id);
//			rs = pstm.executeQuery();
//			
//			if(rs.next()) {
//				member = new Member();
//				
//				member.setNo(rs.getInt("NO"));
//				member.setId(rs.getString("ID"));
//				member.setPassword(rs.getString("PASSWORD"));
//				member.setRole(rs.getString("ROLE"));
//				member.setName(rs.getString("NAME"));
//				member.setPhone(rs.getString("PHONE"));
//				member.setEmail(rs.getString("EMAIL"));
//				member.setAddress(rs.getString("ADDRESS"));
//				member.setHobby(rs.getString("HOBBY"));
//				member.setStatus(rs.getString("STATUS"));
//				member.setEnrollDate(rs.getDate("ENROLL_DATE"));
//				member.setModifyDate(rs.getDate("MODIFY_DATE"));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			close(rs);	// 가져온 역순대로 close해준다.
//			close(pstm);
//		}
//		
//		return member;
//	}

	public int insertMember(Connection connection, Member member) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "INSERT INTO MEMBER VALUES(SEQ_UNO.NEXTVAL,?,?,DEFAULT,?,?,?,?,?,DEFAULT,DEFAULT,DEFAULT)";
		
		try {
			pstmt = connection.prepareStatement(query);
			
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getPhone());
			pstmt.setString(5, member.getEmail());
			pstmt.setString(6, member.getAddress());
			pstmt.setString(7, member.getHobby());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int updateMember(Connection connection, Member member) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "UPDATE MEMBER SET NAME=?,PHONE=?,EMAIL=?,ADDRESS=?,HOBBY=?,MODIFY_DATE=SYSDATE WHERE NO=?";
		
		try {
			pstmt = connection.prepareStatement(query);
			
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getPhone());
			pstmt.setString(3, member.getEmail());
			pstmt.setString(4, member.getAddress());
			pstmt.setString(5, member.getHobby());
			pstmt.setInt(6, member.getNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int updateMemberStatus(Connection connection, int no, String status) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "UPDATE MEMBER SET STATUS=? WHERE NO=?";
		
		try {
			pstmt = connection.prepareStatement(query);
			
			pstmt.setString(1, status);
			pstmt.setInt(2, no);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int updateMemberPassword(Connection connection, int no, String password) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "UPDATE MEMBER SET PASSWORD=? WHERE NO=?";
		
		try {
			pstmt = connection.prepareStatement(query);
			
			pstmt.setString(1, password);
			pstmt.setInt(2, no);
			
			result = pstmt.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
}
