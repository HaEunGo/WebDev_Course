-- FOR TEST

-- 부서 별 평균 월급이 2800000을 초과하는 부서를 조회한 것
SELECT * FROM EMPLOYEE;

SELECT DEPT_CODE, SUM(SALARY) 합계, FLOOR(AVG(SALARY)) 평균, COUNT(*) 인원수
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING FLOOR(AVG(SALARY)) > 2800000
ORDER BY DEPT_CODE ASC;

SELECT DEPT_CODE, SUM(SALARY) 합계, FLOOR(AVG(SALARY)) 평균, COUNT(*) 인원수
FROM EMPLOYEE
WHERE SALARY > 2800000
GROUP BY DEPT_CODE
ORDER BY DEPT_CODE ASC;
-- 그룹에 대한 조건식은 HAVING절에 기술되어야 한다.
-- 부서별로 평균 월급에 대한 조건식을 기술해야 하는데,
-- 사원 월급의 합계를 조건식으로 사용하여 제외된 직원들을 그룹화한 뒤 만들어지도록 조건식이 기술되어 있다.



-- ROWNUM을 이용해서 월급이 가장 높은 3명을 뽑을려고 하였으나, 올바른 결과가 조회 되지 않았다.

SELECT ROWNUM, EMP_NAME, SALARY
FROM EMPLOYEE
ORDER BY SALARY DESC;

-- 이미 SELECT문에서 순번이 정해진 상태(EMP_NAME)에서 ORDER BY(정렬)되었기 때문에 급여는 높은 순서대로 출력되지만,
-- ROWNUM은 순서가 뒤섞여 있어서 ROWNUM순번이 3번인 노옹철 사원이 급여순위 3위로 출력이 된다.


SELECT ROWNUM,
        EMP_NAME,
        SALARY
FROM (
    SELECT EMP_NAME, SALARY
    FROM EMPLOYEE
    ORDER BY SALARY DESC
) WHERE ROWNUM <= 3;




ALTER SESSION SET NLS_DATE_FORMAT = 'RR/MM/DD';
ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD';​


SELECT TO_DATE('20201013', 'YYYY-MM-DD') FROM DUAL;


-- 문자열 데이터 190505 -> 2019년 5월 5일

SELECT TO_DATE ('190505', 'YYMMDD') FROM DUAL;
ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY"년"MM"월"DD"일"';​
SELECT ('20190505', 'YYYY"년" MM"월" DD"일"');


ALTER SESSION SET NLS_DATE_FORMAT = 'YYMMDD';
SELECT TO_DATE ('190505') FROM DUAL;

ALTER SESSION SET NLS_DATE_FORMAT = 'YYYYMMDD';
SELECT TO_CHAR ('20190505', 'YYYY"년" MM"월" DD"일"') FROM DUAL;



SELECT TO_CHAR(190505, '00000000') FROM DUAL;


SELECT TO_CHAR('190505','RR"년" MM"월" DD"일"') FROM DUAL;

ALTER SESSION SET NLS_DATE_FORMAT = 'RR-MM-DD';​
SELECT TO_CHAR('190505') FROM DUAL;

--> 문자열 데이터 '20/10/13' -> '2020-10-13'으로 표현할 수 있도록 형변환
SELECT TO_CHAR(TO_DATE('20/10/13','YY/MM/DD'), 'YYYY"-"fmMM"-"fmDD') FROM DUAL;

--> 문자열 데이터 '190505' '2019년 5월 5일'로 표현할 수 있도록 형변환
SELECT TO_CHAR (TO_DATE('190505', 'YYMMDD'), 'YYYY"년" fmMM"월"DD"일"') FROM DUAL;
