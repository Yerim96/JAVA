--------------------------------
--08 조인 . 테이블의 관계를 이용해 연결(join)한다
--연결이 되어있는 테이블은 join을 할 수 있다. 분리되어있는 테이블의 데이터를 한번에 가져오고 싶어서.
--연결이 안되면 join이 불가. join 하는이유?-> 데이터의 일부를 한꺼번에 다 가져올 수 있는 방법이 있어서.
--유니온은 결과를 함치는것이고, 조인은 테이블을 합치는것이다.조인은 결과가 나오기 전에 미리 테이블을 연결하는것.
----------------------------------------------------

select email, phone_number, department_name
from employees, departments --관계를 이용해 join함을 반드시 밝혀야한다. 
--어디에서 join할것인지 연결 조건을 명시해주지 않으면 값이 반복되기 때문에 엉터리 데이터임.
where employees.department_id = departments.department_id; -- 두테이블을 연결하려면 연결조건이 !반드시! 필요함 두 테이블에 겹치는것이 있어야함


select employee_id, phone_number, department_name
from employees e, departments d  --테이블의 별칭은 select문 처럼 as쓰면 안됨. 무조건 생략해서 써야함.
where e.department_id = d.department_id ;

select email, phone_number, department_name
from employees e, departments d 
where e.department_id = d.department_id ;

select email, phone_number, department_name, department_id --id 어느 테이블에서 가져올지 애매하다.
from employees e, departments d 
where e.department_id = d.department_id;

select email, phone_number, department_name, e.department_id
from employees e, departments d 
where e.department_id = d.department_id ;

select email, phone_number, e.department_id, d.department_id, department_name
from employees e, departments d
where e.department_id = d.department_id; --테이블 수 -1 (테이블
---------------------------------------
select email, phone_number, e.department_id, d.department_id, department_name, salary
from employees e, departments d
where e.department_id = d.department_id
    and d.department_id=20 --연결 조건은 반드시 and .join으로 테이블을 합친후에도 연산은 정상적으로 이용 가능. 테이블이 2개일뿐이다.
    and salary> 100;  
-------------------------------------------
--사원의 전화번호와 사원의 사원의 번호와 도시를 가져오고 싶다.
select employee_id, phone_number, city, department_name
from employees e, departments d, Locations c
where e.department_id=d.department_id 
    and d.location_id=c.location_id;
---------------------------------------------------
select employee_id, phone_number, region_name
from employees e, departments d, Locations c , countries a, regions b
where  e.department_id=d.department_id 
    and d.location_id=c.location_id
    and c.country_id=a.country_id
    and a.region_id= b.region_id;
    ---------------------------------------------
--사번, 이름, 관리자 이름
select  e1.employee_id as 사번 ,e1.first_name as 이름,e2.first_name  as "관리자 이름"
from employees e1, employees e2 --셀프조인
where e1.EMPLOYEE_ID = e2.manager_id;
---------------------------------------------------
----------------------------------------------------
--비등가조인
--들어가있는 값에 포함되면 비등가조인이 가능하다.
------------------------------------------------
create table grade (
    grade_id char(1) primary key,
    low_salary number(8,2) not null,
    hi_salary number(8,2) not null
);
insert into grade values ('A',3001,9999);
insert into grade values ('B',2001,3000); 
insert into grade values ('C',1401,2000);
insert into grade values ('D',1201,1400);
insert into grade values ('E',700,1200);
commit;
------------------------------------------------
select employee_id, salary, grade_id
from employees e, grade g
where e.salary between g.low_salary and g.hi_salary;

---------------------------------------------------------
---외부조인
---한쪽의 내용은 다 안나오게하고, 한쪽의 내용은 다 나오게 한다.
--등가(이너)조인에서는 두테이블에 똑같이 있는것만(같은같끼리) 가져오고, 다른것은 가져오지 못한다. 
--한쪽테이블에 있는것은 다나오게 하고, 반대 테이블에서 같지 않은것도 null상태에서 조인이 되게 만들어주는것이 외부조인이다.
--+가 붙은쪽의 값이 없는것은 null로 처리한다.

select employee_id , e.department_id, department_name
from employees e, departments d
where e.department_id=d.department_id;

--사원이 없는 부서의 번호와 이름
select  d.department_id, department_name
from employees e, departments d
where e.department_id(+)=d.department_id and --+의 의미는 상대 테이블이 값있고 나는 없으면 null 추가해서라도 조인하겠다.
    employee_id is null;
------------------------------------------
select emp.employee_id, emp.manager_id, mgr.first_name
from employees emp, employees mgr
where emp.manager_id(+) = mgr.employee_id; --manager가 없는 employee도 나와야하기 떄문에 manager쪽에 +를 붙여준다

--관리자가 없는 사원
select emp.employee_id, emp.manager_id, mgr.first_name
from employees emp, employees mgr
where emp.manager_id = mgr.employee_id(+) and
    emp.manager_id is null;
    