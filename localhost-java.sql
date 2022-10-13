create table emp_ddl (
    empno number(4) not null,
    ename VARCHAR2(10)not null,
    job varchar2(9)null,
    mgr number(4) null,
    hiredate date not null,
    sal number( 7 , 2 )not null,
    comm number(7,2) not null,
    deptno number(2) null

); 
/*###############################################
---테이블 생성 및 수정, 이름 변경
####################################################*/


--테이블 생성
create table emp_ddl(
    empno number(4) not null,
    ename varchar2(10) not null
);

--테이블 삭제
drop table employess;

--행저장
insert into emp_ddl (empno, ename) values(1,'winter');
insert into emp_ddl (empno, ename) values(1,'summer');
commit;
--기존의 데이터가 있는 테이블에서 컬럼을 새로 추가할 때에는 null을 허용하도록 해야함.
--not null로 하고 싶다면 데이터를 채우고 후에 not null로 변경해야함.
alter table emp_ddl 
    add (
        city varchar(10)  null,
        age number(3)  null
    );

--테이블 이름 변경
alter table emp_ddl
    rename to employes;
    
--컬럼 이름 변경
alter table employes
rename column city to ecity;

alter table employes
rename column age to eage;

--컬럼의 데이터 타입 변경
alter table employes
    MODIFY (
        ename VARCHAR2(15),
        ecity VARCHAR2(20)
    );
    
--컬럼 삭제하기
alter table employes
    drop COLUMN eage;
    
alter table employes
    drop (ename,ecity);