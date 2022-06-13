package com.kh.el.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.el.model.vo.Person;

@WebServlet("/el.do")
public class ELServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ELServlet() {
    }
    
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// 서블릿에서 request, session, application 객체를 가져와서 
    	// 데이터를 setAttribute()에 담아서 el.jsp에 전달
    	HttpSession session = request.getSession();
    	ServletContext application = request.getServletContext();
    	
    	// Request Scope에 데이터를 저장
    	request.setAttribute("classRoom", "A 강의실");
//    	request.setAttribute("student", 1);	// 숫자는 오브젝트가 아닌데 되는 이유? autoBoxing 되기 때문
    	request.setAttribute("student", new Person("달팽이", 20, '여'));
    	request.setAttribute("scope", "Request 영역");
    	
    	// Session Scope에 데이터를 저장
    	session.setAttribute("academy", "Art of Seoul");
    	session.setAttribute("teacher", new Person("James", 28, '남'));
    	session.setAttribute("scope", "Session 영역");
    	
    	// Application Scope에 데이터를 저장
    	application.setAttribute("scope", "Applicaion 영역");
    	
    	// Dispatcher : 리퀘스트를 전달해주는 역할 / request와 response 같이 전달
    	request.getRequestDispatcher("views/el/el.jsp").forward(request, response);
    }

}
