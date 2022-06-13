package com.kh.mvc.member.model.service;

import java.sql.Connection;

import static com.kh.mvc.common.jdbc.JDBCTemplate.*;
import com.kh.mvc.member.model.dao.MemberDao;
import com.kh.mvc.member.model.vo.Member;

public class MemberService {
//  데이터 베이스에 접근
//	ctrl+1 해서 멤버 DAO 생성
	private MemberDao dao = new MemberDao();
	
//	id, password 가져온 값으로 파라미터 넘겨줌 -> service에서는 실제 비즈니스 로직을 처리함
//	service가 직접적으로 데이터베이스에 접근하진 않고 DAO객체를 만들어서 DAO에서 접근함
	public Member login(String id, String password) {
//		id로 멤버(findMemberById)를 찾아오기 없으면 null
		Member member = this.findMemberById(id);
		// member가 null이 아니면서 password가 매개값으로 전달된 password가 같으면
		if(member != null && member.getPassword().equals(password)) {
			// member 리턴
			return member;
		} else {
			// 일치하지 않으면 null 리턴해준다.
			return null;
		}
	}

	public int save(Member member) {
		int result = 0; 
		Connection connection = getConnection();
		
		if(member.getNo() != 0) {
			result = dao.updateMember(connection, member);
		} else {			
			result = dao.insertMember(connection, member);
		}
		
		if(result > 0) {
			commit(connection);
		} else {
			rollback(connection);
		}
		
		close(connection);
		
		return result;
	}
	
	public int delete(int no) {
		int result = 0;
		Connection connection = getConnection();
		
		result = dao.updateMemberStatus(connection, no, "N");
		
		if(result > 0) {
			commit(connection);
		} else {
			rollback(connection);
		}
		
		close(connection);
		
		return result;
	}
	
	public int updatePassword(int no, String password) {
		int result = 0;
		Connection connection = getConnection();
		
		result = dao.updateMemberPassword(connection, no, password);
		
		if(result > 0) {
			commit(connection);
		} else {
			rollback(connection);
		}
		
		close(connection);
		
		return result;
	}

	public boolean isDuplicateID(String id) {

		return this.findMemberById(id) != null;
	}
	
	public Member findMemberById(String id) {
		Connection connection = getConnection();
		Member member = dao.findMemberById(connection, id);
		
		close(connection);
		
		return member;
	}
}
