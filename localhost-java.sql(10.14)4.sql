--데이터 형태와 범위를 정하는 CHECK
drop table freeboards;
drop table members;

create table members(
    mid VARCHAR(20) PRIMARY key,
    mname VARCHAR(20) not null,
    mage number(3) check(mage>0 and mage<200),
    mgrade char(1) check(mgrade in ('A','B','C')) --mgrage는 목록중에 하나 
);

insert into members
values ('winter','한겨울',25,'A'); --CHECK로 지정된 범위만 넣을수있다.

--방법 2
create table members(
    mid VARCHAR(20) PRIMARY key,
    mname VARCHAR(20) not null,
    mage number(3) not null,
    mgrade char(1)  not null, --mgrage는 목록중에 하나 
    CONSTRAINT ok_mage check (mage>0 and mage<200),
     CONSTRAINT ok_mgrade check(mgrade in ('A','B','C'))
);

--방법3
create table members(
    mid VARCHAR(20) not null, 
    mname VARCHAR(20) not null,
    mage number(3) not null,
    mgrage char(1) not null
);

alter table members
    add constraint pk_mid primary key(mid);
    
alter table members
    add constraint ok_mage check (mage>0 and mage<200);

alter table members
    add CONSTRAINT ok_mgrade check(mgrade in ('A','B','C'));

