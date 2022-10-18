------------------------------------------------------------------
--09 서브쿼리 
-- select안의 select를 (다른 문 안의 서브쿼리)를 서브 쿼리라고 한다. -내부적으로 select가 있으면 서브쿼리이다.
--서브쿼리는 조회 대상의 오른쪽에 놓이며 항상 괄호로 묶여져야한다.
-- 
--일반 쿼리와 서브 쿼리의 리턴 타입과 개수가 맞아야함
--단일행:결과값 하나.
--in은 여러 결과값을 가져올수있다.
select salary from employees where first_name='John';
select salary from employees where EMPLOYEE_ID=110;

SELECT employee_id, salary
FROM employees
where salary>(select salary from employees where employee_id=110);

SELECT employee_id, salary
FROM employees
where salary>(select salary from employees where employee_id='John'); -- 서브쿼리는 3개, 일반 쿼리는 1개를 반환하기 때문에 안됨.
--리턴 타입과 개수가 맞아야함

SELECT employee_id, salary
FROM employees
where salary >( 
    select salary 
    from employees 
    where employee_id=100
);

select employee_id, salary, department_id
from employees
where department_id in ( --인 다음 여러개의 연산자가 들어가도 된다.
    select department_id
    from departments
    where department_id<30
);

--110번보다 입사 날짜가 빠른 사원
select * 
from employees
where hire_date < (
    select hire_date
    from employees
    where employee_id=110
);

--전체 평균 봉급보다 많은 봉급을 가져가는 사원
select * 
from employees
where salary < (
    select avg(salary) from employees
);