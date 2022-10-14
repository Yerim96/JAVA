drop table mambers;
create table members(
    mid varchar(10) PRIMARY key, --컬럼수준의 제약조건 1
    memail varchar(50)null
);

insert into members values ('winter','한겨울');
insert into members values ('winter','한겨울'); --x
insert into members values ('null','한겨울'); -- x

--방법 3
drop table mambers;
create table members(
    mid varchar(10) not null, --컬럼수준의 제약조건
    memail varchar(50)null
);
alter table members  
    modify(mid constraint pk_mid primary key)  --컬럼수정
    
alter table members   --도큐먼트 참고하기
 ADD constraint pk_mid primary key (mid); --제약조건 추가
 
 --방법 1
 drop table members;
 create table members(
    first_no char(6) CONSTRAINT CONSTRAINT_NAME PRIMARY KEY,
    second_no char(7) not null,
    memail varchar(50) null
 );
 --방법2
  drop table members;
 create table members(
    first_no char(6) ,
    second_no char(7) ,
    memail varchar(50),
    PRIMARY KEY (first),
    CONSTRAINT CONSTRAINT_NAME UNIQUE(second_no)
 );
 
alter table members
    add CONSTRAINT  pk_ssn primary key (first_no, second_no); -- 두컬럼 만들어 하나의pk키를 만듦 복합키
    
    --컬럼대로 정의하고, 나중에 정의할 수 있다. 방법 3
     drop table members;
 create table members(
    first_no char(6) not null,
    second_no char(7) not null,
    memail varchar(50) null,
    constraint pk_mid primary key(mid),
    constraint u_email unique (memail)
 );