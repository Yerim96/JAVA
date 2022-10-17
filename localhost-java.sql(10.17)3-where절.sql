--필요한 데이터만 출력하는 where(조건)절 p94(5-1)
select email, job_id, salary, hire_date
from employees 
where department_id = 30 --sql에서 =는 비교연산자 --조건을 먼저 가져오고, 올림차순한다.
order by hire_date; -- 올림차순 order by는 where앞에 올 수 없다.

--조건식이 여러개일 경우 and나 or 조건식을 연결할 수 있다. and, or 연산자 
select email, job_id, salary, hire_date
from employees 
where department_id = 30 and salary > 3000 --sql에서 =는 비교연산자 --조건을 먼저 가져오고, 올림차순한다.
order by hire_date; -- 올림차순 order by는 where앞에 올 수 없다.

select email, job_id, salary, hire_date, department_id
from employees 
where department_id = 30 or department_id =20 --sql에서 =는 비교연산자 --조건을 먼저 가져오고, 올림차순한다.
order by department_id, hire_date; -- 올림차순 order by는 where앞에 올 수 없다.