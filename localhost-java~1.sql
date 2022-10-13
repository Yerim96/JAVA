drop table employes;

create table employes(
    eno number(4) not null,
    ename varchar(15) not null
);

insert into employes(eno, ename)
values(1,'홍길동');

insert into employes(eno, ename)
values(2,'감자바');
commit;

select * from employes;

--모든 행을 삭제
delete from employes;
rollback;

-- 실제 테이블의 저장 공간을 초기화 한다.
-- rollback 대상이 아님.
TRUNCATE table employes; --dml이 아니라 ddl임 삭제긴 한데 초기화 하는것임. 
rollback;