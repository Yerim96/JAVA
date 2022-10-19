----------------------------------------------------------
--09-5 from절에 사용하는 서브쿼리와 with절
-------------------------------------------------------
--셀렉트된 컬럼으로만 사용하기
--조인하기에는 행의 수가 너무 많아서 행의 수를 줄여 간단히 가져오기 위해서 사용한다.
---------------------------------------
select email, department_name
from(
    select email,department_id  -- 서브 쿼리select를 테이블인것처럼 조인해 가져올수있다.
    from employees 
    where department_id in (10,20)
) e,
(
    select department_id, department_name,location_id
    from departments
)d,
(
    select location_id,city
    from locations
)l
where e.department_id = d.department_id and
        d.location_id = l.location_id;
----------------------------------------------------------------
    with
    e as(select email,department_id from employees  where department_id in (10,20)
    ),
    d as (  select department_id, department_name,location_id from departments ),
    l as (select  location_id,city from locations)
    select email, department_name,city
    from e,d,l
    where e.department_id = d.department_id and
        d.location_id = l.location_id;
        
---------
select employee_id, department_id, salary
from employees e1
where salary >(
    select min(salary) from employees e2
    where e2.department_id = e1.department_id
)
order by department_id, salary;

