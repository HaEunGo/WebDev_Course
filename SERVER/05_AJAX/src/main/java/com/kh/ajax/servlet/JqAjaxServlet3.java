package com.kh.ajax.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.GsonBuilder;
import com.kh.ajax.model.vo.User;


@WebServlet("/jqAjax3.do")
public class JqAjaxServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public JqAjaxServlet3() {
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// 우리가 가져올 파라미터 값 -> 비교할 값은 문자값이기 때문에 charAt으로 가져온다.
    	char gender = request.getParameter("gender").charAt(0);
    	
		// 사용자 정보가 저장되어 있는 List 생성
		List<User> list = new ArrayList<>();
		
		list.add(new User(1, "바나나", 20, '남'));
		list.add(new User(2, "딸기", 27, '여'));
		list.add(new User(3, "복숭아", 18, '여'));
		list.add(new User(4, "자몽", 17, '남'));
		list.add(new User(5, "청포도", 30, '남'));
		
		// 위 리스트에서 같은 gender끼리 새로운 list를 만들어주기 (배열)
		List<User> users = list.stream()
								// gender가 우리가 가져온 gender와 같은지 확인
							   .filter(user -> user.getGender() == gender)
							   // 필터를 통해 걸러진 요소들을 모아서 새로운 list로 만들어주기
							   .collect(Collectors.toList());
		
		response.setContentType("application/json; charset=UTF-8");
		
		
		new GsonBuilder().setPrettyPrinting().create().toJson(users, response.getWriter());
		
	}
}
