--------------------------
--등가조인(내부조인=inner join)
---------------------------------------------------------------------------
--08-2 조인 종류
--등가조인,비등가조인,자체조인,외부조인
--값이 같은것끼리 조인한다.
--등가조인: 내부조인 또는 단순조인으로 부른다
--내부조인은같은값끼리 조인하는것. 등가조인의 반대= 비등가조인
--조인은 보통 등가조인
---------------------------

--이 방법만 알아두기 
select email, department_name
from employees e, departments d
where e.department_id = d.department_id; --iso 문법

--SQL 92문법
select email, department_name
from employees e inner join department b  on e.department_id = d.department_id;  -- 위코드와 같음 ANSI 문법

--SQL 99문법
--두테이블의 컬럼이름이 두개이상 존재할때는 컬럼을 지정해 using 사용
select email, department_name
from employees e NATURAL JOIN departments d; --네추럴조인은 같은 컬럼이 딱 하나만 있어야 사용 가능하다.

select email, department_name
from employees e JOIN departments d using (department_id); --두개이상 같은 컬럼이 있을 경우 컬럼을 지정해 사용할 수 있다


--원하는 조건을 걸고 원하는 컬럼을 사용. 여기서 join은 inner가 생략되어있다.
select email, department_name
from employees e JOIN departments d 
                    on (e.department_id=d.department_id);
                    
 --------------------------
--등가조인(외부조인=outer join)
---------------------------

--이방법만 알아두기
select email, department_name
from employees e, departments d
where e.department_id(+) = d.department_id;--없는것은 null로
--+는 null추가 할 수 있으면 null로 추가.


select email, department_name
from employees e right outer join departments d --오른쪽에 있는것(department)은 다나오게 , 왼쪽에 있는것은 null로
on e.department_id= d.department_id;

----------
drop table boards;
drop table members;


create table members(
    mid VARCHAR2(10) primary key,
    mname varchar2(20) not null
);

create table boards(
    bno number primary key,
    btitle varchar(100) not null,
    mid varchar2(10) REFERENCES members(mid) on delete cascade,
    mname varchar2(20) not null
);

insert into members values ('spring','김하늘');
insert into members values ('summer','하여름');
insert into members values ('fall','단풍잎');
insert into members values ('winter','동장군');
commit;

insert into boards values(1,'제목1', 'spring','김하늘');
insert into boards values(2,'제목2', 'fall','단풍잎');
insert into boards values(3,'제목3', 'spring','이바다');
commit;
---------------------------
select m.mid,m.mname, bno, btitle, b.mid, b.mname
from members m, boards b
where m.mid= b.mid;

--같은 컬럼하나가 동일할때는 상관없는데 같은 컬럼 두개가있을때는 그 안의 값이 같을때가 있고, 
--다를 때가 있다. 같은 이때 같은 값만 연결한다.
select mname, mid, bno , btitle
from members m natural join boards b;