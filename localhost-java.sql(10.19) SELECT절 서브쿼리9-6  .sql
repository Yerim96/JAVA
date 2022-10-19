---------------------------------------------
--.9-6 SELECT절에 사용하는 서브쿼리
--------------------------------------

select employee_id , first_name, job_id, 
     salary, grade_id, department_id
from employees, grade g
where salary between low_salary and hi_salary
        and department_id =30; --범위로 join
        
        

select  employee_id , first_name, job_id,  salary, department_id, grade_id
     from 
     (
        select employee_id , first_name, job_id, salary, department_id
        from employees
        where department_id =30 --범위로 join
    )e,
    grade g
    where salary between low_salary and hi_salary;
    
-------
--위 코드와 달리 join을 완전히 쓰지 않을 방법 select절에 사용하는 서브쿼리
--외부의 값을 집어넣어주고, 
select  employee_id , first_name, job_id, salary, department_id, --grade_id 대신 서브쿼리
    (
    select grade_id 
    from grade 
    where e.salary between low_salary and hi_salary --조건
   )as grade_id
from employees e
where department_id =30;
-------------------------------------------------------
-----DEPARTMENT_NAME나오게 하고싶다,where job_id ='ST_CLERK';인것만.
select employee_id , first_name, job_id
from employees
where job_id ='ST_CLERK'; 

--방법 1: JOIN
select employee_id , first_name, job_id, e.department_id, department_name
from employees e, departments d
where e.department_id = d.department_id
    and e.job_id='ST_CLERK';
    
--방법 2: FROM (서브쿼리) 
select employee_id , first_name, job_id
from(
    select job_id, department_id ,employee_id, first_name-- 서브 쿼리select를 테이블인것처럼 조인해 가져올수있다.
    from employees
    where job_id in('ST_CLERK')
) e,
(select department_name, department_id  -- 서브 쿼리select를 테이블인것처럼 조인해 가져올수있다.
    from departments
)d
where e.department_id = d.department_id;
--방법 3: SELECT (서브쿼리)
select  job_id, department_id ,employee_id, first_name, --grade_id 대신 서브쿼리
    ( select department_name
        from departments
        where e.department_id =department_id
    ) as dname
from employees e --FROM에 테이블이 여러개여야 JOIN
where job_id ='ST_CLERK';