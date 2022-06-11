/*
    <VIEW>
        SELECT 문을 저장할 수 있는 객체(논리적인 가상 테이블)
        데이터를 저장하고 있지 않으며, 테이블에 대한 SQL만 저장되어 있어 VIEW에 접근할 때 SQL을 수행하면서 결과값을 가져온다.
        
        [표현법]
            CREATE [OR REPLACE] VIEW 뷰명
            AS 서브 쿼리;
*/

-- 쿼리문을 먼저 만들어서 데이터 조회
-- '한국'에서 근무하는 사원의 사번, 이름, 부서명, 급여, 근무 국가명을 조회하시오.
SELECT E.EMP_ID, E.EMP_NAME, D.DEPT_TITLE, E.SALARY, N.NATIONAL_NAME
FROM EMPLOYEE E
JOIN DEPARTMENT D ON (E.DEPT_CODE = D.DEPT_ID)
JOIN LOCATION L ON (D.LOCATION_ID = L.LOCAL_CODE)
JOIN NATIONAL N ON (L.NATIONAL_CODE = N.NATIONAL_CODE)
WHERE N.NATIONAL_NAME = '한국';

-- '러시아'에서 근무하는 사원의 사번, 이름, 부서명, 급여, 근무 국가명을 조회하시오.
SELECT E.EMP_ID, E.EMP_NAME, D.DEPT_TITLE, E.SALARY, N.NATIONAL_NAME
FROM EMPLOYEE E
JOIN DEPARTMENT D ON (E.DEPT_CODE = D.DEPT_ID)
JOIN LOCATION L ON (D.LOCATION_ID = L.LOCAL_CODE)
JOIN NATIONAL N ON (L.NATIONAL_CODE = N.NATIONAL_CODE)
WHERE N.NATIONAL_NAME = '러시아';


--------------------------------------------------------------------
-- 위 쿼리문을 가지고 VIEW 생성
CREATE OR REPLACE VIEW V_EMPLOYEE
AS SELECT E.EMP_ID, E.EMP_NAME, D.DEPT_TITLE, E.SALARY, N.NATIONAL_NAME
    FROM EMPLOYEE E
    JOIN DEPARTMENT D ON (E.DEPT_CODE = D.DEPT_ID)
    JOIN LOCATION L ON (D.LOCATION_ID = L.LOCAL_CODE)
    JOIN NATIONAL N ON (L.NATIONAL_CODE = N.NATIONAL_CODE);

SELECT *
FROM V_EMPLOYEE;    -- 가상 테이블로 실제 데이터가 담겨있는 것은 아니다.

-- 한국에서 근무하는 사번, 이름, 부서명, 급여, 근무 국가명을 조회하시오.
SELECT *
FROM V_EMPLOYEE
WHERE NATIONAL_NAME = '한국';

-- 러시아에서 근무하는 사원들 조회
SELECT *
FROM V_EMPLOYEE
WHERE NATIONAL_NAME = '러시아';

-- 총무부에 근무하는 사원들의 사원명, 급여
SELECT EMP_NAME, SALARY
FROM V_EMPLOYEE
WHERE DEPT_TITLE = '총무부';

-- 해당 유저가 가지고 있는 테이블 정보를 가지고 있는 데이터 딕셔너리
SELECT * FROM USER_TABLES;

-- 해당 계정이 가지고 있는 VIEW 들에 대한 내용을 조회하는 데이터 딕셔너리이다. (서브쿼리 확인가능)
SELECT * FROM USER_VIEWS;

------------------------------------------------------
/*
    <VIEW 컬럼에 별칭 부여>
        서브 쿼리의 SELECT 절에 함수나 산술연산이 기술되어 있는 경우 반드시 별칭을 지정해야 한다.
*/

-- 서브쿼리 생성
SELECT EMP_ID,
       EMP_NAME,
       DECODE(SUBSTR(EMP_NO, 8, 1), '1', '남', '2', '여'),
       EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM HIRE_DATE)    -- 근무년수 추출
FROM EMPLOYEE;


-- 사원의 사번, 사원명, 성별, 근무년수를 조회할 수 있는 뷰를 생성
CREATE OR REPLACE VIEW V_EMP01
AS SELECT EMP_ID,
       EMP_NAME,
       DECODE(SUBSTR(EMP_NO, 8, 1), '1', '남', '2', '여') 성별,
       EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM HIRE_DATE) 근무년수
    FROM EMPLOYEE;
    
SELECT * FROM V_EMP01;

-- 별칭 지정 방법 2)
-- 컬럼의 개수와 별칭의 개수가 같아야 한다. (모든 컬럼에 별칭을 부여해야 한다.)
CREATE OR REPLACE VIEW V_EMP02(사번, 사원명, 성별, 근무년수)
AS SELECT EMP_ID,
          EMP_NAME,
          DECODE(SUBSTR(EMP_NO, 8, 1), '1', '남', '2', '여'),
          EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM HIRE_DATE)
    FROM EMPLOYEE;
    
SELECT 사번, 사원명, 성별, 근무년수 FROM V_EMP02;


-- VIEW 삭제
DROP VIEW V_EMP01;
DROP VIEW V_EMP02;


-----------------------------------------------------------
/*
    <VIEW를 이용해서 DML구문(INSERT, UPDATE, DELETE) 사용>
        VIEW를 통해 데이터를 변경하게 되면 실제 데이터가 담겨있는 기본 테이블에도 적용된다.

*/

-- VIEW 생성
CREATE OR REPLACE VIEW V_JOB
AS SELECT * FROM JOB;

-- 생성된 VIEW 조회
SELECT * FROM V_JOB;

-- VIEW에 SELECT
SELECT JOB_CODE, JOB_NAME
FROM V_JOB;

-- VIEW에 INSERT
INSERT INTO V_JOB VALUES('J8', '알바');

SELECT * FROM V_JOB;
SELECT * FROM JOB;

-- VIEW에 UPDATE (J8의 직급명 인턴으로 변경)
UPDATE V_JOB
SET JOB_NAME = '인턴'
WHERE JOB_CODE = 'J8';

SELECT * FROM V_JOB;
SELECT * FROM JOB;

-- VIEW에 DELETE
DELETE FROM V_JOB
WHERE JOB_CODE = 'J8';

SELECT * FROM V_JOB;
SELECT * FROM JOB;

------------------------------------------------

/*
    <DML 구문으로 VIEW 조작이 불가능한 경우>
        1) 뷰 정의에 포함되지 않은 컬럼을 조작하는 경우
        2) 뷰에 포함되지 않는 컬럼 중에 기본 테이블 상에 NOT NULL 제약조건이 지정된 경우
        3) 산술 표현식으로 정의된 경우
        4) 그룹 함수나 GROUP BY 절을 포함한 경우
        5) DISTINCT를 포함한 경우
        6) JOIN을 이용해 여러 테이블을 연결한 경우
*/

-- 1) 뷰 정의에 포함되지 않은 컬럼을 조작하는 경우 (INSERT를 허용하지 않는다.)
CREATE OR REPLACE VIEW VM_JOB2
AS SELECT JOB_CODE
     FROM JOB;
     
-- INSERT
INSERT INTO VM_JOB2 VALUES ('J8', '알바');
INSERT INTO VM_JOB2 VALUES ('J8');

-- UPDATE
UPDATE VM_JOB2
SET JOB_NAME = '알바'
WHERE JOB_CODE = 'J8'; -- 에러 발생

SELECT * FROM VM_JOB2;
SELECT * FROM JOB;

-- 2) 뷰에 포함되지 않는 컬럼 중에 기본 테이블 상에 NOT NULL 제약 조건에 지정된 경우 (INSERT를 허용하지 않는다.)
CREATE OR REPLACE VIEW V_JOB3
AS SELECT JOB_NAME
     FROM JOB;
     
-- INSERT
-- 기본 테이블인 JOB 테이블에 JOB_CODE는 NOT NULL 제약조건이 있기 때문에 오류가 발생한다.
INSERT INTO V_JOB3 VALUES('알바');

-- UPDATE
UPDATE V_JOB3
SET JOB_NAME = '인턴'
WHERE JOB_NAME = '사원';

-- DELETE (FK 제약조건으로 인해서 삭제되지 않는다.)
DELETE FROM V_JOB3
WHERE JOB_NAME = '인턴';

SELECT * FROM V_JOB3;
SELECT * FROM JOB;

ROLLBACK;

-- 3) 산술 표현식으로 정의된 경우 (INSERT, UPDATE를 허용하지 않는다.)
CREATE OR REPLACE VIEW V_EMP_SAL
AS SELECT EMP_ID,
          EMP_NAME,
          SALARY,
          SALARY * 12 AS "연봉"
     FROM EMPLOYEE;
     
SELECT * FROM V_EMP_SAL;
SELECT * FROM EMPLOYEE;

-- INSERT
INSERT INTO V_EMP_SAL VALUES(300,'홍길동', 3000000, 36000000);

-- UPDATE
UPDATE V_EMP_SAL
SET "연봉" = 80000000
WHERE EMP_ID = 200;

-- 산술연산과 무관한 컬럼은 변경 가능
UPDATE V_EMP_SAL
SET SALARY = 5000000
WHERE EMP_ID = 200;

SELECT * FROM V_EMP_SAL;
SELECT * FROM EMPLOYEE;

-- DELETE
DELETE FROM V_EMP_SAL
WHERE "연봉" = 60000000;

ROLLBACK;

--SELECT EMP_ID,
--       EMP_NAME,
--       SALARY,
--       SALARY * 12 AS "연봉"
--FROM EMPLOYEE
--WHERE SALARY * 12 = 60000000;

--DELETE FROM EMPLOYEE
--WHERE SALARY * 12  = 96000000;


-- 4) 그룹 함수나 GROUP BY 절을 포함한 경우 (INSERT, UPDATE, DELETE 모두 허용하지 않는다.)
SELECT DEPT_CODE, SUM(SALARY), FLOOR(AVG(NVL(SALARY, 0)))
FROM EMPLOYEE
GROUP BY DEPT_CODE;

CREATE OR REPLACE VIEW V_DEPT
AS SELECT DEPT_CODE, SUM(SALARY) 합계, FLOOR(AVG(NVL(SALARY, 0))) 평균
     FROM EMPLOYEE
     GROUP BY DEPT_CODE;

SELECT * FROM V_DEPT;

-- INSERT
INSERT INTO V_DEPT VALUES ('D0', 6000000, 4000000);


-- UPDATE
UPDATE V_DEPT
SET "합계" = 12000000
WHERE DEPT_CODE = 'D1'; -- 에러발생 : 원본 테이블의 여러 값들이 같은 값으로 변경될 수 있다.


-- DELETE
DELETE FROM V_DEPT
WHERE DEPT_CODE = 'D1'; -- 지원 X


-- 5) DISTINCT를 포함한 경우
CREATE OR REPLACE VIEW V_DT_JOB
AS SELECT DISTINCT JOB_CODE
   FROM EMPLOYEE;

SELECT * FROM V_DT_JOB;

-- INSERT
INSERT INTO V_DT_JOB VALUES ('J8');

-- UPDATE
UPDATE V_DT_JOB
SET JOB_CODE = 'J8'
WHERE JOB_CODE = 'J7';  -- 이미 중복제거 후 결과를 가져오는 것이기 때문에 지원 X

-- DELETE
DELETE FROM V_DT_JOB
WHERE JOB_CODE = 'J7';  -- 오류발생


-- 6) JOIN을 이용해 여러 테이블을 연결한 경우
CREATE OR REPLACE VIEW V_EMP
AS SELECT E.EMP_ID, E.EMP_NAME, D.DEPT_TITLE
   FROM EMPLOYEE E
   JOIN DEPARTMENT D ON E.DEPT_CODE = D.DEPT_ID;

SELECT * FROM V_EMP;

-- INSERT
INSERT INTO V_EMP VALUES (800, '홍홍홍', '총무부');

-- UPDATE
UPDATE V_EMP
SET EMP_NAME = '서동일'
WHERE EMP_ID = 200;

UPDATE V_EMP
SET DEPT_TITLE = '총무1팀'
WHERE EMP_ID = 200; -- 변경 X

-- DELETE
DELETE FROM V_EMP
WHERE EMP_ID = 200;

DELETE FROM V_EMP
WHERE DEPT_TITLE = '총무부';   -- 서브 쿼리에 FROM 절의 테이블에만 영향을 끼친다.

SELECT *
FROM EMPLOYEE;
SELECT *
FROM DEPARTMENT;

ROLLBACK;

-------------------------------------------------
/*
    <VIEW 옵션>
        [표현법]
            CREATE [OR REPLACE][FORCE | NOFORCE] VIEW 뷰명
            AS 서브쿼리
            [WITH CHECK OPTION]
            [WITH READ ONLY];
            
        - OR REPLACE : 기존에 동일한 뷰가 있을 경우 덮어쓰고, 존재하지 않으면 뷰를 새로 생성한다.
        - FORCE : 서브 쿼리에 기술된 테이블이 존재하지 않는 테이블이어도 뷰가 생성된다.
        - NOFORCE : 서브 쿼리에 기술된 테이블이 존재해야만 뷰가 생성된다.(기본값)
        - WITH CHECK OPTION : 서브 쿼리에 기술된 조건에 부합하지 않는 값으로 수정하는 경우 오류를 발생시킨다.
        - WITH READ ONLY : 뷰에 대해 조회만 가능(DML 수행 불)

*/
-- 1) OR REPLACE
CREATE /*OR REPLACE*/ VIEW V_EMP01
AS SELECT EMP_ID, EMP_NAME, SALARY, HIRE_DATE
     FROM EMPLOYEE;

SELECT * FROM USER_VIEWS WHERE VIEW_NAME = 'V_EMP01';

-- 2) FORCE / NOFORCE
-- NOFORCE
CREATE OR REPLACE /*NOFORCE*/ VIEW V_EMP02
AS SELECT TCODE, TNAME, TCONTENT
    FROM TT;

-- FORCE
CREATE OR REPLACE FORCE VIEW V_EMP02
AS SELECT TCODE, TNAME, TCONTENT
    FROM TT;

SELECT * FROM USER_VIEWS WHERE VIEW_NAME = 'V_EMP02';

SELECT * FROM V_EMP02;

-- TT 테이블을 생성해야 그때부터 VIEW조회가 가능
CREATE TABLE TT(
    TCODE NUMBER,
    TNAME VARCHAR2(10),
    TCONTENT VARCHAR2(20)
);

SELECT * FROM V_EMP02;

-- 3) WITH CHECK OPTION
CREATE OR REPLACE VIEW V_EMP03
AS SELECT *
   FROM EMPLOYEE
   WHERE SALARY >= 3000000
WITH CHECK OPTION;

SELECT * FROM V_EMP03;
SELECT * FROM USER_VIEWS WHERE VIEW_NAME = 'V_EMP03';

-- 200번 사원 (대표님)의 급여를 200만원으로 변경 (서브 쿼리의 조건에 부합하지 않기 때문에 변경이 불가능하다.)
UPDATE V_EMP03
SET SALARY = 2000000
WHERE EMP_ID = 200;

-- 200번 사원 (대표님)의 급여를 200만원으로 변경 (서브 쿼리의 조건에 부합하기 때문에 변경이 가능하다.)
UPDATE V_EMP03
SET SALARY = 4000000
WHERE EMP_ID = 200;

SELECT * FROM EMPLOYEE;

ROLLBACK;

-- 4) WITH READ ONLY
CREATE OR REPLACE VIEW V_DEPT02
AS SELECT *
     FROM DEPARTMENT
WITH READ ONLY;

SELECT * FROM V_DEPT02;
SELECT * FROM USER_VIEWS WHERE VIEW_NAME = 'V_DEPT02';

-- INSERT
INSERT INTO V_DEPT02 VALUES ('D0', '해외영업4부', 'L5');

-- UPDATE
UPDATE V_DEPT02
SET LOCATION_ID = 'L2'
WHERE DEPT_TITLE = '해외영업4부';

-- DELETE
DELETE FROM V_DEPT02
WHERE DEPT_ID = 'D0';

SELECT * FROM V_DEPT02;