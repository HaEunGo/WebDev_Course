<%@ page import="java.time.LocalDate" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 스크립트 요소(Elements)</title>
</head>
<body>
	<h2>JSP 스크립트 요소(Elements)</h2>
	<!-- HTML -->
	<%-- JSP --%>
	<%-- 두 주석의 차이점 --%>
	<%-- 페이지의 소스 보기 혹은 개발자 도구에서 HTML 주석은 확인 가능하고, JSP 주석은 확인이 불가능하다.
	<%-- (파일을 브라우저에게 보내주면서 서블릿으로 변환될 때 제외하고 변환되기 때문에 JSP파일에서만 주석 확인 가능) --%>
	
	<%!
		// 선언부 (필드, 메소드를 선언한다.)
		private String name = "홍길동";	/* 필드에 접근제한자가 붙는다. / 서블릿에도 추가된 걸 확인할 수 있음 */
		private LocalDate date;
	%>
	<%
		// 자바 코드를 기술
		int total = 0;					/* 스크립트 / 지역변수 선언이기 때문에 접근제한자를 붙여줄 수 없다.(에러 발생) */
		
		for(int i = 1; i <= 10; i++){
			total += i;
		
	%>
	
	안녕하세요. <br>
	
	<%
	
		}
		
		
		System.out.println(total);
	%>
	
	저의 이름은 <%= name %> 입니다. <!-- 변수의 담긴 값 표현 (서블릿에 변환될 때 out.print(name);으로 바뀌므로 값 뒤에 세미콜론(;)은 빼줘야 한다.); -->
	
	<br>
	
	expression 출력 :
	1 부터 10까지의 합은 <%= total %> 입니다. <br>
	
	scriptlet 출력 :
<%-- 	1 부터 10까지의 합은 <% out.write(total); %> 입니다. <br> --%>
	1 부터 10까지의 합은 <% out.print(total); %> 입니다. <br>
	
	

</body>
</html>