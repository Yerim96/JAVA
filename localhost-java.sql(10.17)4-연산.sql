--연산자 종류와 활용 방법 (5-3,101p
select email, salary*12 as yearsal -- 연봉 계산해 가져오기
from employees
where salary*12 >= 200000;

select first_name
from employees
where first_name >= 'A' and first_name <'C';

select email, job_id
from employees
where  job_id != 'IT_PROG' and job_id <> 'FI_ACCOUNT';

--논리 부정 연산자 NOT은 !임 즉 뒤에오는 연산의 반대를 뜻함.
select email, job_id
from employees
where  NOT (job_id != 'IT_PROG' and job_id <> 'FI_ACCOUNT');

--in 쓴것과 결과는 같지만 컬럼을 계속 추가해줘야함.
select email, job_id
from employees
where  job_id = 'IT_PROG' or job_id = 'FI_ACCOUNT';

--IN 은 괄호안에 있는것중 하나여야함.
select email, job_id
from employees
where  job_id in('IT_PROG', 'FI_ACCOUNT');

--IN은 check 제한자 에서도 사용되었었음.
create table t1(
    grade char(1) check (grade in('A','B','C'))
    )
 
 --전체를 부정
select email, job_id
from employees
where not job_id in('IT_PROG', 'FI_ACCOUNT');

 --목록을 부정함.
select email, job_id
from employees
where  job_id not in('IT_PROG', 'FI_ACCOUNT');

--밑 코드 비트윈가 결과값은 같지만 연산자를 더 많이 써서 성능상 between이 더 좋다.
select email, salary
from employees
where salary >= 5000 and salary <=7000;

--비트윈 and 으로 비교
select email, salary
from employees
where salary between 5000 and 7000;


--------------------------------------
--LIKE 연산자와 와일드 카드
------------------------------------
-- 앞이 s인것 가져와라.
select first_name
from employees
where first_name like 'S%';

--앞이든 뒤든 상관없이 st가 포함된것 다가져와라.
select first_name
from employees
where first_name like '%St%'; --기호는 %대신 _를 쓸 수 있다.

select first_name, email
from employees
where first_name like '%ev%' or email like '%ev%';

select email
from employees
where email like '_L%' ;
---------------------------------------------
--IS NULL 연산자
-----------------------------------------------
select employee_id, first_name
from employees
where department_id is null; --이 컬럼의 값이 null이냐?

select employee_id, first_name
from employees
where department_id = null; --null은 데이터가 아니기 때문에 비교연산자 = 못씀 실행 (x)


--is null의 반대 = is not null
select employee_id, first_name
from employees
where department_id is not null; --이 컬럼의 값이 null이냐?

--null은 데이터가 아니라 연산 자체가 안됨. 따라서 아무리 null로 연산해봤자 null 나옴
select * from employees where salary is null; --없어서 결과 안나옴
select * from employees where commission_pct is null;

select (salary*12) + (commission_pct*salary) as yearsal --null이 있으면 아무리 연산해도  null이 나옴.
from employees;

---------------------------------
--집합연산자 UNION
-------------------------------------
--union의
select email, phone_number
from employees
where department_id = 10 or department_id = 20;
-------------------------------------------------
select email, phone_number
from employees
where department_id in (10,20);
------------------------------------
select email, phone_number, department_id
from employees
where department_id= 10
union --위 아래 결과셋을 합하겠다.
select email, phone_number, department_id
from employees
where department_id= 20;
-------------------------------------------------

