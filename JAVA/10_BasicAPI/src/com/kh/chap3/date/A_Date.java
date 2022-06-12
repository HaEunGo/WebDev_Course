package com.kh.chap3.date;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class A_Date {
	public void method1() {
		// Date 클래스에서 날짜, 시간을 어떻게 처리하는지 확인해보기
		// 날짜를 표현하는 용도로만 주로 사용, 임의로 변경한다거나 하진 않음
		
		// 기본 생성자를 통해서 Date 객체를 생성하면 컴퓨터의 현재 시간과 날짜에 대한 정보를 가지고 객체를 생성한다.
		Date now = new Date();
		
		System.out.println(now);	
		System.out.println(now.toString());		// KST : 한국 표준시
		System.out.println(now.toGMTString());	// GMT : 런던 기점 협정 세계시
		
		// 1970년 1월 1일 00시 00분 기준으로 밀리 세컨드 단위로 표기 된다.
		// 한국시간(KST)로 출력 될 땐 GMT(그리니치 평균 시)보다 +9시간 증가된 시간으로 표시된다.
		Date when = new Date(1);	 
		System.out.println(when.toGMTString());	
		
		when = new Date(1000);	 	// 1초 증가
		System.out.println(when);
		
		// Deprecated 된 생성자를 사용한 Date 객체 생성
		Date when2 = new Date((2021-1900), (9 - 1), 7);
		System.out.println(when2);
		
		System.out.println(now.getTime()); 	// 1970년 1월 1일 시간 기준으로 현재시간 까지 계산된 long타입의 수로 표기된다.
		System.out.println(now.getYear() + 1900);
		System.out.println(now.getMonth() + 1);
		System.out.println(now.getDate());
		System.out.println(now.getDay());	// 일요일은 숫자 0
		System.out.println(now.getHours());
		System.out.println(now.getMinutes());
		System.out.println(now.getSeconds());

		// SimpleDateFormat 클래스 사용
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss:SSS초 (E) a");
		String formatDate = sdf.format(now);
		
		System.out.println(formatDate);
		
	}

	public void method2() {
		/*
		 * Date는 대부분의 메소드가 Deprecated 되었고, 단순히 특정 시점의 날짜 정보를 저장하는 역할만 한다.
		 * java 8부터는 날짜와 시간을 나타내는 java.time 패키지를 제공한다.
		 * 
		 */
		
		LocalDateTime now = LocalDateTime.now();		// 객체를 직접 생성하지 않는다. 현재 시간정보를 가져옴
		LocalDateTime when = LocalDateTime.of(2021, 3, 1, 22, 13, 24);	// 특정 시점의 정보를 가져옴
		
		System.out.println(now);
		System.out.println(when);
		System.out.println();
		
		System.out.println(now.getYear());
		System.out.println(now.getMonth());
		System.out.println(now.getMonthValue());
		System.out.println(now.getDayOfMonth());
		System.out.println(now.getDayOfWeek());
		System.out.println(now.getDayOfYear());
		System.out.println(now.getMinute());
		System.out.println(now.getSecond());
		System.out.println(now.getNano());
		System.out.println();
		
		LocalDateTime plusDays = now.plusDays(1).plusMonths(1).plusYears(1);		// method 체이닝
		LocalDateTime minusDays = now.minusDays(1);
		
		System.out.println(now);
		LocalDateTime period = plusDays;
		System.out.println(period);
		System.out.println(minusDays);
		System.out.println();
		
		System.out.println(now.isAfter(period));
		System.out.println(now.isBefore(period));	// 매개값으로 전해준 날짜인지 확인
		System.out.println(now.isAfter(minusDays));
		System.out.println(now.isBefore(minusDays));
		
//		LocalDate localDate = LocalDate.now();
//		LocalDate localDate = LocalDate.of(2021, 09, 08);
		LocalDate localDate = now.toLocalDate();
//		LocalTime localTime = LocalTime.now();
//		LocalTime localTime = LocalTime.of(21, 20, 13);
		LocalTime localTime = now.toLocalTime();
		
		System.out.println(localDate);
		System.out.println(localTime);


		// D-DAY
//		Period perior = Period.between(period.toLocalDate(), minusDays.toLocalDate());		// 날짜의 차이를 나타내는 메소드
//		
//		System.out.println("D-DAY : " + perior.getDays());		// 일차이
//		
//		long between = ChronoUnit.DAYS.between(period.toLocalDate(), minusDays.toLocalDate());		//ChronoUnit을 통해 D-Day 계산(연,월,일)
//		System.out.println(between);
		
		// 문자열을 LocalDate 객체로 파싱
//		localDate = LocalDate.parse("2021-05-14");	// 문자열로 객체를 만들어준다.
//		localDate = LocalDate.parse("2021.05.14");	// 에러발생
//		localDate = LocalDate.parse("2021.05.14", DateTimeFormatter.ofPattern("yyyy.MM.dd"));	// 가지고 있는 문자열을 다른 형태로 바꾸고 싶을 때 사용
		localDate = LocalDate.parse("20210803", DateTimeFormatter.BASIC_ISO_DATE);	// format이 여러 개일 수도 있다.
		
		System.out.println(localDate);
		System.out.println();
		
		// LocalDateTime 객체를 문자열로 포맷팅
		System.out.println(now.toString());
		System.out.println(now.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 hh시 mm분 ss초")));
		System.out.println(now.format(DateTimeFormatter.ISO_ORDINAL_DATE));
		System.out.println(now.format(DateTimeFormatter.ISO_WEEK_DATE));
		System.out.println(ZonedDateTime.now());
		System.out.println(ZonedDateTime.now().format(DateTimeFormatter.RFC_1123_DATE_TIME));

		
		
	}
}
