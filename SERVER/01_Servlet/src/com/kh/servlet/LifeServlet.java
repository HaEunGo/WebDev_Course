package com.kh.servlet;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifeServlet
 */
@WebServlet({ "/LifeServlet", "/life.do" })
public class LifeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LifeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
    	System.out.println("init() 메소드 실행");
	}

    @Override
	public void destroy() {
		// TODO Auto-generated method stub
    	System.out.println("destroy() 메소드 실행");
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service 메소드 호출 : 요청방식에 따라 doGet() 또는 doPost() 메소드를 호출(실행)한다.");

		super.service(request, response);
	}

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("doGet() 메소드 실행");
	}

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("doGet() 메소드 실행");
	}

}
