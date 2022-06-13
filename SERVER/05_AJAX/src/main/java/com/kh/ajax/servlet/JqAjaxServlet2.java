package com.kh.ajax.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kh.ajax.model.vo.User;


@WebServlet("/jqAjax2.do")
public class JqAjaxServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public JqAjaxServlet2() {
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		
		// 사용자 정보가 저장되어 있는 List 생성
		List<User> list = new ArrayList<>();
		
		list.add(new User(1, "바나나", 20, '남'));
		list.add(new User(2, "딸기", 27, '여'));
		list.add(new User(3, "복숭아", 18, '여'));
		list.add(new User(4, "자몽", 17, '남'));
		list.add(new User(5, "청포도", 30, '남'));
		
		User findUser = list.stream()
							.filter(user -> user.getNo() == userNo)
							.findFirst()
							.orElse(null);
		
		response.setContentType("application/json; charset=UTF-8");
		
		// 라이브러리를 쓰기 전에 JSON을 만들어서 테스트
//		String result = "{\"no\":1, \"name\": \"바나나\", \"age\": 20 \"gender\":\"남\"}";
//		response.getWriter().print(result);
//		String json = new Gson().toJson(findUser);
		
//		String json2 = new GsonBuilder().setPrettyPrinting().create().toJson(findUser);
		
//		System.out.println(json);
		
//		System.out.println(json2);
		
//		response.getWriter().print(new Gson().toJson(findUser));
//		response.getWriter().print(json);
		
		new Gson().toJson(findUser, response.getWriter());
	}
}
