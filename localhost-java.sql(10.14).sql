drop table member;

CREATE table member(
    mid varchar2(20) UNIQUE not null, 
    u_memail VARCHAR2(50) CONSTRAINT u_memail unique,
    mname varchar2(20) not null
);

--2번 실행시 무결성 제약조건 위반
insert into member values('fall','fall@mycompany.com', '홍길동');

--null은 중복의 대상이 아님
insert into member values('winter','null', '홍길동');

select * from member;

--------------------------------------
drop table member;
CREATE table member(
    mid varchar2(20) not null, 
    u_memail VARCHAR2(50) null,
    mname varchar2(20) not null
);
--- 
--생성 후에 테이블에 unique  제약조건 지정
alter table member
modify(
    mid constraint u_mid unique,
    u_memail constraint u_memail unique
);

-- 제약 조건 삭제
alter table member
    drop CONSTRAINT u_memail;