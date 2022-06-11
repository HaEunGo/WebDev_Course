/*
    <DDL (Data Definition Language)>
        데이터 정의 언어로 오라클에서 제공하는 객체를 만들고(CREATE), 변경하고(ALTER), 삭제하는(DROP) 등
        실제 데이터 값이 아닌 데이터의 구조 자체를 정의하는 언어로 DB 관리자, 설계자가 주로 사용한다.
        
        * 오라클에서의 객체 : 테이블, 뷰, 시퀀스, 인덱스, 트리커, 프로시져, 함수, 동의어, 사용자 등등
        
    <CREATE>
        데이터베이스 객체를 생성하는 구문이다.
        
    <테이블 생성>
        행과 열로 구성되는 가장 기본적인 데이터베이스 객체로 데이터베이스 내에서 모든 데이터는 테이블에 저장된다.
        
        [표현식]
            CREATE TABLE 테이블명 (
                컬럼명 자료형(크기) [DEFAULT 기본값] [제약조건], -- 컬럼명과 자료형은 필수다.
                컬럼명 자료형(크기) [DEFAULT 기본값] [제약조건],
                ...
            );
*/

-- 회원에 대한 데이터를 담을 수 있는 MEMBER 테이블 생성
-- MEMBER_DATE : 날짜 데이터를 생략하면 현재 날짜,시간의 값을 기본값으로 지정
CREATE TABLE MEMBER (
    MEMBER_ID VARCHAR2(20),
    MEMBER_PWD VARCHAR(20),
    MEMBER_NAME VARCHAR2(20),
    MEMBER_DATE DATE DEFAULT SYSDATE
);

-- DROP TABLE MEMBER; -- 멤버 테이블 삭제

-- 만든 테이블 확인
DESC MEMBER;    -- 테이블의 구조를 표시해주는 구문이다.
SELECT * FROM MEMBER;

/*
    <컬럼에 주석 달기>
        [표현법]
            COMMENT ON COLUMN 테이블명, 컬럼명 IS '주석내용';
*/

COMMENT ON COLUMN MEMBER.MEMBER_ID IS '회원아이디';
COMMENT ON COLUMN MEMBER.MEMBER_PWD IS '비밀번호';
COMMENT ON COLUMN MEMBER.MEMBER_NAME IS '회원이름';
COMMENT ON COLUMN MEMBER.MEMBER_DATE IS '회원가입일';


/*
    데이터 딕셔너리(Data Dictionary)
        자원을 효율적으로 관리하기 위한 다양한 객체들의 정보를 저장하는 시스템 테이블이다.
        사용자가 객체를 생성하거나 객체를 변경하는 등의 작업을 할 때 데이터베이스에 의해서 자동으로 갱신되는 테이블이다.
        데이터에 관한 데이터가 저장되어 있다고 해서 '메타 데이터'라고도 한다.
        
    USER_TABLES : 사용자가 가지고 있는 테이블들의 전반적인 구조를 확인하는 뷰 테이블이다.
    USER_TAB_COLUMNS : 테이블, 뷰의 컬럼과 관련된 정보를 조회하는 뷰 테이블이다.
*/
SELECT * FROM USER_TABLES; -- 사용자(KH)에 대해서 사용자가 가지고 있는 테이블들에 대한 구조를 간략하게 보여준다.
SELECT * FROM USER_TABLES WHERE TABLE_NAME = 'MEMBER';
SELECT * FROM USER_TAB_COLUMNS WHERE TABLE_NAME = 'MEMBER';

-- 테이블의 샘플 데이터 추가(INSERT)
-- INSERT INTO 테이블명 [(컬럼명, ..., 컬럼명)] VALUES (값, ..., 값);
-- 테이블에 컬럼명을 지정해 주지 않으면 컬럼 순서대로 입력해야 한다.
INSERT INTO MEMBER VALUES('USER1', '1234', '홍길동', '2021-10-06');
INSERT INTO MEMBER VALUES('USER2', '1234', '김철수', SYSDATE);
INSERT INTO MEMBER VALUES('USER2', '1234', '김철수', DEFAULT);
INSERT INTO MEMBER (MEMBER_ID, MEMBER_PWD, MEMBER_NAME) VALUES('USER2', '1234', '김철수');

SELECT * FROM MEMBER;

-- 위에서 테이블에 추가한 데이터를 실제 데이터베이스에 반영한다. 커밋 전에는 메모리 버퍼에 임시저장됨 -> 커밋 후 실제 테이블에 반영시키는 작업
COMMIT;

SHOW AUTOCOMMIT;

SET AUTOCOMMIT ON;
SET AUTOCOMMIT OFF;

-------------------------------------------------------
/*
    <제약 조건(CONSTRAINTS)>
        사용자가 원하는 조건의 데이터만 유지하기 위해서 테이블 작성 시 각 컬럼에 대해 저장될 값에 대한 제약 조건을 설정할 수 있다.
        제약 조건은 데이터 무결성 보장을 목적으로 한다. (데이터의 정확성과 일관성을 유지시키는 것)
        
        * 종류 : NOT NULL, UNIQUE, CHECK, PRIMARY KEY, FOREIGN KEY
        
        [표현법]
            1) 컬럼 레벨
                CRATE TABLE 테이블명 (
                    컬럼명 자료형(크기),
                    [CONSTRAINT 제약조건] 제약조건,
                    ...
                );
                
            2) 테이블 레벨
                CRATE TABLE 테이블명(
                    컬럼명 자료형(크기),
                    ...
                    [CONSTRAINT 제약조건명] 제약조건 (컬럼명)
                );
                  
*/

-- 제약 조건 확인
DESC USER_CONSTRAINTS;
SELECT * FROM USER_CONSTRAINTS;     -- 사용자가 작성한 제약조건을 확인하는 뷰

DESC USER_CONS_COLUMNS;
SELECT * FROM USER_CONS_COLUMNS;    -- 제약조건이 걸려있는 컬럼을 확인하는 뷰

/*
    <NOT NULL 제약조건>
        해당 컬럼에 반드시 값이 있어야만 하는 경우 사용한다.
        삽입 / 수정 시 NULL 값을 허용하지 않도록 제한한다.
*/
-- 기존 MEMBER 테이블은 값에 NULL이 있어도 삽입 가능하다.
INSERT INTO MEMBER VALUES(NULL, NULL, NULL, NULL);
SELECT * FROM MEMBER;

-- NOT NULL 제약조건을 설정한 테이블 만들기
-- NOT NULL 제약조건은 컬럼 레벨에서만 설정이 가능하다.

DROP TABLE MEMBER;
CREATE TABLE MEMBER (
    MEMBER_ID VARCHAR2(20) NOT NULL,
    MEMBER_PWD VARCHAR2(20) NOT NULL,
    MEMBER_NAME VARCHAR2(20) NOT NULL,
    MEMBER_DATE DATE DEFAULT SYSDATE
);

-- NOT NULL 제약 조건에 위배되어 오류 발생
INSERT INTO MEMBER VALUES (NULL, NULL, NULL, NULL);

-- NOT NULL 제약 조건이 걸려있는 컬럼에는 반드시 값이 있어야 한다.
INSERT INTO MEMBER VALUES ('USER1', '1234', '홍길동', DEFAULT/*'NULL'*/);

DESC MEMBER;
SELECT * FROM MEMBER;


/*
    <UNIQUE 제약조건>
        컬럼 입력 값에 중복 값을 제한하는 제약조건이다.
        데이터를 삽입/수정 시 기존에 있는 데이터 값 중에 중복 값이 있을 경우 삽입/수정되지 않는다.
        제약조건 지정 방식으로 컬럼 레벨, 테이블 레벨 방식 모두 사용 가능하다.
*/

-- 아이디가 중복됐어도 성공적으로 데이터가 삽입된다.
INSERT INTO MEMBER VALUES('USER1', '1234', '아무개', DEFAULT);
INSERT INTO MEMBER VALUES('USER1', '1234', '아무개', DEFAULT);

SELECT * FROM MEMBER;

DROP TABLE MEMBER;

CREATE TABLE MEMBER (
    MEMBER_ID VARCHAR2(20) NOT NULL UNIQUE,
    MEMBER_PWD VARCHAR2(20) NOT NULL,
    MEMBER_NAME VARCHAR2(20) NOT NULL,
    MEMBER_DATE DATE DEFAULT SYSDATE
);

-- 작성한 제약조건 확인
SELECT CONSTRAINT_NAME,
       CONSTRAINT_TYPE,
       UC.TABLE_NAME,
       COLUMN_NAME
FROM USER_CONSTRAINTS UC
JOIN USER_CONS_COLUMNS UCC USING (CONSTRAINT_NAME)
WHERE UC.TABLE_NAME = 'MEMBER';  -- 사용자가 작성한 제약조건을 확인하는 뷰


INSERT INTO MEMBER VALUES('USER1', '1234', '아무개', DEFAULT);
INSERT INTO MEMBER VALUES('USER1', '1234', '아무개', DEFAULT);

DROP TABLE MEMBER;

-- 여러 개의 컬럼을 묶어서 하나의 UNIQUE 제약 조건을 설정하는 것도 가능하다.(단, 반드시 테이블 레벨로만 설정이 가능하다.)
-- MEMBER_NO 멤버를 구분할 수 있는 정수값(특정 코드값)
CREATE TABLE MEMBER (
    MEMBER_NO NUMBER NOT NULL,
    MEMBER_ID VARCHAR2(20) NOT NULL,
    MEMBER_PWD VARCHAR2(20) NOT NULL,
    MEMBER_NAME VARCHAR2(20) CONSTRAINT MEMBER_MEMBER_NAME_NN NOT NULL,
    MEMBER_DATE DATE DEFAULT SYSDATE,
    CONSTRAINT MEMBER_MEMBER_ID_UQ UNIQUE(MEMBER_ID)    -- CONSTRAINT_테이블명_제약을 걸 컬럼명_제약조건
);

-- 여러 컬럼을 묶어서 UNIQUE 제약 조건이 설정되어 있으면 제약 조건이 설정되어 있는 컬럼값이 모두 중복되는 경우에만 오류가 발생한다.
INSERT INTO MEMBER VALUES(1, 'USER1', '1234', '아무개', DEFAULT);
INSERT INTO MEMBER VALUES(2, 'USER1', '1234', '아무개', DEFAULT);
INSERT INTO MEMBER VALUES(2, 'USER2', '1234', '아무개', DEFAULT);
INSERT INTO MEMBER VALUES(1, 'USER1', '1234', '아무개', DEFAULT);  -- 에러


-- 작성한 제약조건 확인
SELECT CONSTRAINT_NAME,
       CONSTRAINT_TYPE,
       UC.TABLE_NAME,
       COLUMN_NAME
FROM USER_CONSTRAINTS UC
JOIN USER_CONS_COLUMNS UCC USING (CONSTRAINT_NAME)
WHERE UC.TABLE_NAME = 'MEMBER';


SELECT * FROM MEMBER;



/*
    <CHECK 제약조건>
        컬럼에 기록되는 값에 조건을 설정하고 조건을 만족하는 값만 기록할 수 있다.
        비교 값은 리터럴만 사용 가능하다. (변하는 값이나 함수 사용하지 못한다.)
        
        [표현법]
            CHECK(비교연산자)
                CHECK(컬럼 [NOT] IN(값, 값, ...))
                CHECK(컬럼 = 값)
                CHECK(컬럼 BETWEEN 값 AND 값)
                CHECK(컬럼 LIKE '_문자' OR 컬럼 LIKE '문자%')
                ...
*/

DROP TABLE MEMBER;

CREATE TABLE MEMBER (
    MEMBER_NO NUMBER NOT NULL,
    MEMBER_ID VARCHAR2(20) NOT NULL,
    MEMBER_PWD VARCHAR2(20) NOT NULL,
    MEMBER_NAME VARCHAR2(20) CONSTRAINT MEMBER_MEMBER_NAME_NN NOT NULL,
    GENDER CHAR(3) CHECK(GENDER IN('남', '여')),
    AGE NUMBER CHECK(AGE > 0), 
    MEMBER_DATE DATE DEFAULT SYSDATE,
    CONSTRAINT MEMBER_MEMBER__ID_UQ UNIQUE (MEMBER_NO, MEMBER_ID)
);

DESC MEMBER;

-- 작성한 제약조건 확인
SELECT CONSTRAINT_NAME,
       CONSTRAINT_TYPE,
       UC.TABLE_NAME,
       COLUMN_NAME
FROM USER_CONSTRAINTS UC
JOIN USER_CONS_COLUMNS UCC USING (CONSTRAINT_NAME)
WHERE UC.TABLE_NAME = 'MEMBER';


INSERT INTO MEMBER VALUES(1, 'USER1', '1234', '아무개', '남', 25, DEFAULT);

-- GENDER 컬럼에 CHECK 제약 조건으로 '남' 또는 '여'만 기록 가능하도록 설정이 되었기 때문에 에러가 발생한다.
INSERT INTO MEMBER VALUES(3, 'USER3', '1234', '홍길동', '강', 30, DEFAULT);

-- AGE NUMBER CHECK 제약 조건에 AGE > 0 설정으로 음수를 입력하려고 하면 에러가 발생한다.
INSERT INTO MEMBER VALUES(4, 'USER4', '1234', '고길동', '남', -30, DEFAULT);


SELECT * FROM MEMBER;

/*
    <PRIMARY KEY(기본 키), 제약조건>
        테이블에서 한 행의 정보를 식별하기 위해 사용할 컬럼에 부여하는 제약조건이다.
        각 행들을 구분할 수 있는 식별자의 역할(회원번호, 부서 코드, 직급 코드, ...)
        PRIMARY KEY 제약조건을 설정하게 되면 자동으로 해당 컬럼에 NOT NULL + UNIQUE 제약조건이 설정된다.
        한 테이블에 한 개만 설정할 수 있다.(단, 한 개 이상의 컬럼을 묶어서 PRIMARY KEY로 제약 조건을 설정할 수 있다.)
        컬럼 레벨, 테이블 레벨 방실 모두 설정 가능하다.
*/

DROP TABLE MEMBER;

CREATE TABLE MEMBER (
    MEMBER_NO NUMBER CONSTRAINT MEMBER_MEMBER_NO_PK PRIMARY KEY,
    MEMBER_ID VARCHAR2(20) NOT NULL,
    MEMBER_PWD VARCHAR2(20) NOT NULL,
    MEMBER_NAME VARCHAR2(20) CONSTRAINT MEMBER_MEMBER_NAME_NN NOT NULL,
    GENDER CHAR(3) CHECK(GENDER IN('남', '여')),
    AGE NUMBER CHECK(AGE > 0), 
    MEMBER_DATE DATE DEFAULT SYSDATE,
--    CONSTRAINT MEMBER_MEMBER_NO_PK PRIMARY KEY(MEMBER NO),
    CONSTRAINT MEMBER_MEMBER__ID_UQ UNIQUE (MEMBER_ID)
);


-- 작성한 제약조건 확인
SELECT CONSTRAINT_NAME,
       CONSTRAINT_TYPE,
       UC.TABLE_NAME,
       COLUMN_NAME
FROM USER_CONSTRAINTS UC
JOIN USER_CONS_COLUMNS UCC USING (CONSTRAINT_NAME)
WHERE UC.TABLE_NAME = 'MEMBER';


INSERT INTO MEMBER VALUES(1, 'USER1', '1234', '아무개', '남', 25, DEFAULT);
INSERT INTO MEMBER VALUES(2, 'USER2', '1234', '춘향이', '여', 20, DEFAULT);
INSERT INTO MEMBER VALUES(3, 'USER3', '1234', '고길동', '남', 30, DEFAULT);
INSERT INTO MEMBER VALUES(3, 'USER4', '1234', '유관순', '여', 15, DEFAULT); -- 기본키 (PRIMARY KEY) 중복으로 오류
INSERT INTO MEMBER VALUES(NULL, 'USER5', '1234', '자장면', '남', 25, DEFAULT); -- 기본 키가 NULL이므로 오류

SELECT * FROM MEMBER;

DROP TABLE MEMBER;

CREATE TABLE MEMBER (
    MEMBER_NO NUMBER,
    MEMBER_ID VARCHAR2(20),
    MEMBER_PWD VARCHAR2(20) NOT NULL,
    MEMBER_NAME VARCHAR2(20) CONSTRAINT MEMBER_MEMBER_NAME_NN NOT NULL,
    GENDER CHAR(3) CHECK(GENDER IN('남', '여')),
    AGE NUMBER CHECK(AGE > 0), 
    MEMBER_DATE DATE DEFAULT SYSDATE,
    CONSTRAINT MEMBER_MEMBER_NO_PK PRIMARY KEY(MEMBER_NO, MEMBER_ID) -- 컬럼을 묶어서 하나의 기본 키를 설정 -> 복합키라고 한다.
);


-- 작성한 제약조건 확인
SELECT CONSTRAINT_NAME,
       CONSTRAINT_TYPE,
       UC.TABLE_NAME,
       COLUMN_NAME
FROM USER_CONSTRAINTS UC
JOIN USER_CONS_COLUMNS UCC USING (CONSTRAINT_NAME)
WHERE UC.TABLE_NAME = 'MEMBER';


INSERT INTO MEMBER VALUES(1, 'USER1', '1234', '아무개', '남', 25, DEFAULT);
INSERT INTO MEMBER VALUES(1, 'USER2', '1234', '춘향이', '여', 20, DEFAULT);
INSERT INTO MEMBER VALUES(2, 'USER2', '1234', '고길동', '남', 30, DEFAULT);
-- 회원번호, 아이디가 세트로 동일한 값이 이미 존재하기 때문에 에러가 발생한다.
INSERT INTO MEMBER VALUES(1, 'USER1', '1234', '유관순', '여', 15, DEFAULT);
-- 기본 키로 설정된 컬럼은 NULL 값이 있으면 에러가 발생한다.
INSERT INTO MEMBER VALUES(NULL, 'USER5', '1234', '자장면', '남', 25, DEFAULT);


/*
    <FOREIGN KEY(외래 키) 제약조건>
        다른 테이블에 존재하는 값만을 가져야 하는 컬럼에 부여하는 제약조건이다. (단, NULL 값도 가질 수 있다.)
        즉, 참조된 다른 테이블이 제공하는 값만 기록할 수 있다. (FOREIGN KEY 제약조건에 의해서 테이블 간에 관계가 형성된다. - 테이블간의 연결고리 역할)
        
        [표현식]
            1) 컬럼 레벨
                컬럼명 자료형(크기) [CONSTRAINT 제약조건명] REFERENCES 참조할테이블명 [(기본 키)][삭제룰]
                
            2) 테이블 레벨
                [CONSTRAINT 제약조건명] FOREIGN KEY(컬럼명) REFERENCES 참조할테이블명 [(기본 키)][삭제룰]
                
            
        [삭제룰]
                부모 테이블의 데이터가 삭제 됐을 때의 옵션을 지정해 놓을 수 있다.
                1) ON DELETE RESTRICT : 자식 테이블의 참조 키가 부모 테이블의 키 값을 참조하는 경우 주어진 상위 행(부모테이블의 행)을 삭제할 수 없다. (기본적으로 적용되는 옵션)
                2) ON DELETE SET NULL : 부모 테이블의 데이터 삭제 시 참조하고 있는 자식 테이블의 컬럼 값이 NULL로 변경된다.
                3) ON DELETE CASCADE : 부모 테이블의 데이터가 삭제 시 참조하고 있는 자식 테이블의 컬럼 값이 존재하는 행 전체가 삭제된다.
                
*/
-- 회원 등급에 대한 데이터를 보관하는 테이블 (부모테이블)
CREATE TABLE MEMBER_GRADE(
    GRADE_CODE NUMBER PRIMARY KEY,
    GRADE_NAME VARCHAR2(30) NOT NULL
);

INSERT INTO MEMBER_GRADE VALUES(10, '일반회원');
INSERT INTO MEMBER_GRADE VALUES(20, '우수회원');
INSERT INTO MEMBER_GRADE VALUES(30, '특별회원');

SELECT * FROM MEMBER_GRADE;


DROP TABLE MEMBER;

-- 자식 테이블
CREATE TABLE MEMBER (
    MEMBER_NO NUMBER CONSTRAINT MEMBER_MEMBER_NO_PK PRIMARY KEY,
    MEMBER_ID VARCHAR2(20) NOT NULL,
    MEMBER_PWD VARCHAR2(20) NOT NULL,
    MEMBER_NAME VARCHAR2(20) CONSTRAINT MEMBER_MEMBER_NAME_NN NOT NULL,
    GENDER CHAR(3) CHECK(GENDER IN('남', '여')),
    AGE NUMBER CHECK(AGE > 0),
    GRADE_ID NUMBER REFERENCES MEMBER_GRADE(GRADE_CODE), -- (GRADE_CODE)생략가능 
    MEMBER_DATE DATE DEFAULT SYSDATE,
--    CONSTRAINT MEMBER_MEMBER_NO_PK PRIMARY KEY(MEMBER NO),
--    FOREIGN KEY(GRADE_ID) REFERENCES MEMBER_GRADE/*(GRADE_CODE)*/,  -- 자동으로 부모 테이블의 기본 키로 연결된다.
    CONSTRAINT MEMBER_MEMBER__ID_UQ UNIQUE (MEMBER_ID)
);

-- 작성한 제약조건 확인
SELECT CONSTRAINT_NAME,
       CONSTRAINT_TYPE,
       UC.TABLE_NAME,
       COLUMN_NAME
FROM USER_CONSTRAINTS UC
JOIN USER_CONS_COLUMNS UCC USING (CONSTRAINT_NAME)
WHERE UC.TABLE_NAME = 'MEMBER';


INSERT INTO MEMBER VALUES(1, 'USER1', '1234', '춘향이', '여', 20, 10, DEFAULT);
-- 50이라는 값이 MEMBER_GRADE 테이블 GRADE_CODE 컬럼에서 제공하는 값이 아니므로 외래키 제약 조건에 위배되어 오류 발생
INSERT INTO MEMBER VALUES(2, 'USER2', '1234', '고길동', '남', 30, 50, DEFAULT);
INSERT INTO MEMBER VALUES(3, 'USER3', '1234', '소나무', '남', 25, NULL, DEFAULT);   -- GRADE_ID 컬럼에 NULL 사용 가능

SELECT * FROM MEMBER;


-- MEMBER 테이블과 MEMBER_GRADE 테이블을 조인하여 MEMBER_ID, MEMBER_NAME, GRADE_NAME 조회 (JOIN 복습)
-- ANSI
SELECT MEMBER_ID,
       MEMBER_NAME,
       GRADE_NAME
FROM MEMBER M
LEFT JOIN MEMBER_GRADE G ON (M.GRADE_ID = G.GRADE_CODE); 
-- 자식테이블의 외래키(GRADE_ID)와 부모 테이블의 기본키 (GRADE_CODE)를 가지고 JOIN한다.


-- 오라클 구문
SELECT MEMBER_ID,
       MEMBER_NAME,
       GRADE_NAME
FROM MEMBER M, MEMBER_GRADE G
WHERE M.GRADE_ID = G.GRADE_CODE(+);



-- MEMBER_GRADE 테이블에서 GRADE_CODE 가 10인 데이터 지우기
-- 객체 삭제 : DROP / 데이터 삭제 : DELETE
-- 자식 테이블의 행등 중에 10을 사용하고 있기 때문에 삭제할 수 없다.
DELETE FROM MEMBER_GRADE WHERE GRADE_CODE = 10;
-- 자식 테이블의 행들 중에 30을 사용하고 있는 행이 없기 때문에 삭제할 수 있다.
DELETE FROM MEMBER_GRADE WHERE GRADE_CODE = 30;

SELECT * FROM MEMBER_GRADE;

-- 위 테이블의 삭제 작업을 취소한다. (메모리 버퍼에 임시 삭제한 데이터를 실제 테이블에 반영하지 않고 작업을 취소한다.)
ROLLBACK;

DROP TABLE MEMBER;

-- ON DELETE SET NULL 옵션이 추가된 자식 테이블 생성
CREATE TABLE MEMBER (
    MEMBER_NO NUMBER CONSTRAINT MEMBER_MEMBER_NO_PK PRIMARY KEY,
    MEMBER_ID VARCHAR2(20) NOT NULL,
    MEMBER_PWD VARCHAR2(20) NOT NULL,
    MEMBER_NAME VARCHAR2(20) CONSTRAINT MEMBER_MEMBER_NAME_NN NOT NULL,
    GENDER CHAR(3) CHECK(GENDER IN('남', '여')),
    AGE NUMBER CHECK(AGE > 0),
    GRADE_ID NUMBER REFERENCES MEMBER_GRADE(GRADE_CODE) ON DELETE SET NULL,
    MEMBER_DATE DATE DEFAULT SYSDATE,
    CONSTRAINT MEMBER_MEMBER__ID_UQ UNIQUE (MEMBER_ID)
);


INSERT INTO MEMBER VALUES(1, 'USER1', '1234', '춘향이', '여', 20, 10, DEFAULT);
INSERT INTO MEMBER VALUES(3, 'USER3', '1234', '소나무', '남', 25, NULL, DEFAULT);

-- 문제없이 행이 삭제 되고 GRADE_ID -> NULL로 변함
-- 단, 자식 테이블을 조회해 보면 삭제된 행을 참조하고 있던 컬럼의 값이 NULL로 변경된 것을 확인할 수 있다.
DELETE FROM MEMBER_GRADE WHERE GRADE_CODE = 10;

SELECT * FROM MEMBER_GRADE;
SELECT * FROM MEMBER;

ROLLBACK;

DROP TABLE MEMBER;

-- ON DELETE CASCADE 옵션이 추가된 자식 테이블 생성
CREATE TABLE MEMBER (
    MEMBER_NO NUMBER CONSTRAINT MEMBER_MEMBER_NO_PK PRIMARY KEY,
    MEMBER_ID VARCHAR2(20) NOT NULL,
    MEMBER_PWD VARCHAR2(20) NOT NULL,
    MEMBER_NAME VARCHAR2(20) CONSTRAINT MEMBER_MEMBER_NAME_NN NOT NULL,
    GENDER CHAR(3) CHECK(GENDER IN('남', '여')),
    AGE NUMBER CHECK(AGE > 0),
    GRADE_ID NUMBER REFERENCES MEMBER_GRADE(GRADE_CODE) ON DELETE CASCADE,
    MEMBER_DATE DATE DEFAULT SYSDATE,
    CONSTRAINT MEMBER_MEMBER__ID_UQ UNIQUE (MEMBER_ID)
);


INSERT INTO MEMBER VALUES(1, 'USER1', '1234', '춘향이', '여', 20, 10, DEFAULT);
INSERT INTO MEMBER VALUES(3, 'USER3', '1234', '소나무', '남', 25, NULL, DEFAULT);

SELECT * FROM MEMBER_GRADE;
SELECT * FROM MEMBER;

COMMIT;

-- 문제없이 행이 삭제되는 것을 확인할 수 있다.
-- 단, 자식 테이블을 조회해 보면 삭제된 행을 참조하고 있던 컬럼의 행들이 모두 삭제된 것을 확인할 수 있다.
DELETE FROM MEMBER_GRADE WHERE GRADE_CODE = 10;

ROLLBACK;


-- 작성한 제약 조건 컬럼명까지 확인
SELECT * 
FROM USER_CONSTRAINTS UC
JOIN USER_CONS_COLUMNS UCC ON UC.TABLE_NAME = UCC.TABLE_NAME;

SELECT CONSTRAINT_NAME,
       CONSTRAINT_TYPE,
       UC.TABLE_NAME,
       COLUMN_NAME
FROM USER_CONSTRAINTS UC
JOIN USER_CONS_COLUMNS UCC USING (CONSTRAINT_NAME)
WHERE UC.TABLE_NAME = 'MEMBER';



--------------------------------------------------
/*
    <SUBQUERY를 이용한 테이블 생성>
        SUBQUERY를 사용해서 테이블을 생성한다.
        컬럼명, 데이터 타입, 값이 복사되고 제약 조건은 NOT NULL만 복사된다.
        
        [표현법]
            CREATE TABLE 테이블명
            AS 서브 쿼리;
            
*/
-- EMPLOYEE 테이블을 복사한 새로운 테이블 생성 (컬럼, 데이터 타입, 값, 제약 조건을 복사)
CREATE TABLE EMPLOYEE_COPY
AS SELECT *
    FROM EMPLOYEE;
    
SELECT * FROM EMPLOYEE_COPY;

CREATE TABLE MEMBER_COPY
AS SELECT *
    FROM MEMBER;


-- EMPLOYEE 테이블을 복사한 새로운 테이블 생성 (컬럼, 데이터 타입, NOT NULL 제약 조건만 복사)
CREATE TABLE EMPLOYEE_COPY2
AS SELECT *
    FROM EMPLOYEE
    WHERE 1 = 0; -- 구조만 복사되고 모든 행에 대해서 매번 FALSE이기 때문에 데이터 값은 복사되지 않는다.


CREATE TABLE MEMBER_COPY2
AS SELECT *
    FROM EMPLOYEE
    WHERE 2 = 1;    -- 데이터 값 없이 구조만 복사, 무조건 FALSE가 나온다.

SELECT * FROM EMPLOYEE_COPY2;
SELECT * FROM MEMBER_COPY2;

-- EMPLOYEE 테이블의 사번, 사원명, 급여, 연봉을 저장하는 테이블 서브 쿼리를 사용하여 생성
CREATE TABLE EMPLOYEE_COPY3
AS SELECT EMP_NO AS "사번",
          EMP_NAME AS "사원명",
          SALARY AS "급여",
          SALARY * 12 AS "연봉"   -- SELECT 절에 산술연산 또는 함수식이 들어간 경우 반드시 별칭을 정해줘야 한다.
    FROM EMPLOYEE;
    
SELECT * FROM EMPLOYEE_COPY3;

DROP TABLE EMPLOYEE_COPY;
DROP TABLE EMPLOYEE_COPY2;
DROP TABLE EMPLOYEE_COPY3;
DROP TABLE MEMBER_COPY;
DROP TABLE MEMBER_COPY2;


---------------------------------------------------------------------
-- 실습 문제
-- 도서관리 프로그램을 만들기 위한 테이블 만들기
-- 이때, 제약조건에 이름을 부여하고, 각 컬럼에 주석 달기


-- 1. 출판사들에 대한 데이터를 담기 위한 출판사 테이블(TB_PUBLISHER) 
--  1) 컬럼 : PUB_NO(출판사 번호) -- 기본 키
--           PUB_NAME(출판사명) -- NOT NULL
--           PHONE(출판사 전화번호) -- 제약조건 없음

--  2) 3개 정도의 샘플 데이터 추가하기


-- 2. 도서들에 대한 데이터를 담기 위한 도서 테이블 (TB_BOOK)
--  1) 컬럼 : BK_NO (도서번호) -- 기본 키
--           BK_TITLE (도서명) -- NOT NULL
--           BK_AUTHOR(저자명) -- NOT NULL
--           BK_PRICE(가격)
--           BK_PUB_NO(출판사 번호) -- 외래 키(BOOK_FK) (TB_PUB 테이블을 참조하도록)
--                                  이때 참조하고 있는 부모 데이터 삭제 시 자식 데이터도 삭제 되도록 옵션 지정

--  2) 5개 정도의 샘플 데이터 추가하기


-- 3. 회원에 대한 데이터를 담기 위한 회원 테이블 (TB_MEMBER)
--  1) 컬럼 : MEMBER_NO(회원번호) -- 기본 키
--           MEMBER_ID(아이디)   -- 중복 금지
--           MEMBER_PWD(비밀번호) -- NOT NULL
--           MEMBER_NAME(회원명) -- NOT NULL
--           GENDER(성별)        -- 'M' 또는 'F'로 입력되도록 제한
--           ADDRESS(주소)       
--           PHONE(연락처)       
--           STATUS(탈퇴 여부)     -- 기본값으로 'N'  그리고 'Y' 혹은 'N'으로 입력되도록 제약조건
--           ENROLL_DATE(가입일)  -- 기본값으로 SYSDATE, NOT NULL

--  2) 3개 정도의 샘플 데이터 추가하기


-- 4. 도서를 대여한 회원에 대한 데이터를 담기 위한 대여 목록 테이블(TB_RENT)
--  1) 컬럼 : RENT_NO(대여번호) -- 기본 키
--           RENT_MEM_NO(대여 회원번호) -- 외래 키(TB_MEMBER와 참조)
--                                      이때 부모 데이터 삭제 시 NULL 값이 되도록 옵션 설정
--           RENT_BOOK_NO(대여도서번호) -- 외래 키(TB_BOOK와 참조)
--                                      이때 부모 데이터 삭제 시 NULL 값이 되도록 옵션 설정
--           RENT_DATE(대여일) -- 기본값 SYSDATE

--  2) 샘플 데이터 3개 정도 


-- 4. 2번 도서를 대여한 회원의 이름, 아이디, 대여일, 반납 예정일(대여일 + 7일)을 조회하시오


-- 5. 회원번호가 1번인 회원이 대여한 도서들의 도서명, 출판사명, 대여일, 반납예정일을 조회하시오


----------------------------------------------------------------------------------------------------------------
