drop table members;

create table members(
    mid VARCHAR(20) PRIMARY key,
    mname VARCHAR(20) not null,
    mdate date default sysdate not null, --값이 주어지지 않으면 디폴트 값을 넣어주겠다.
    mcity VARCHAR(10) default '서울' null,
    mgrade char(1) default 'C' check(mgrade in ('A','B','C')) --mgrage는 목록중에 하나 
);

INSERT into members
values('winter','홍길동',default,default,default);

INSERT into members(mid, mname)
values('summer','하여름');

INSERT into members(mid, mname, mcity)
values('fall','하여름',null);

SELECT * from members;