----------------------------------------
--다중행 함수 7-1(177)
--7장의 목표: group by 
------------------------------------------
select sum(salary) from employees;
select avg(salary) from employees;
select max(salary) from employees;
select min(salary) from employees;

select count(employee_id) from employees;  -- resultset에 표시되는 행의 수는 가져올수있을만큼만 가져오는것이지 실제 데이터의 행의 수는 아니다. 필요할떄마다 데이터를 가져오는 방식
select count(department_id) from employees; --count는 null수를 카운팅하지 않는다.
select count(*) from employees; --아스타는 행수를 이야기함. null도 카운팅함.
