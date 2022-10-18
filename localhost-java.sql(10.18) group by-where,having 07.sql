--------------------------------
--여러개를 묶기위한 grouping
--grouping에는 반드시 집계함수가 있어야한다.
--GROUP by 뒤에있는 행은 반드시 select절에 있어야하고 , 그 뒤에는 반드시 집계함수가 있어야한다.
--오라클에서 제공해주는 집계함수를 모아놓은 도큐먼트 - aggrergate functions
select department_id , max(salary) 
from employees
where department_id in (10,20,30)
GROUP by department_id
order by department_id;


select department_id ,job_id, max(salary) 
from employees
where department_id in (10,20,30)
GROUP by department_id,job_id
order by department_id;

--다중행 함수를 사용하지 않은 일반열은 그룹바이절에 명시하지 않으면 셀렉트절에서 사용할수 없다.
select department_id ,job_id, max(salary) 
from employees
where department_id in (10,20,30)
GROUP by department_id --- job_id가 group by절 뒤에 없어서 셀렉트절에서 사용 불가. 실행 (x)
order by department_id;


----------------------------------------
--where는 그룹 전의 조건이다. 조건을 걸어준다는 점에서는 where과 having은 비슷하지만 다르다.
--그룹핑후 집계까지 끝났는데, 이상태에서 조건을 달고싶음. 집계 후의 집계값만 가지고 조건을 따져야한다.
--데이터를 그룹핑대상으로 보고, 그룹을 하고나서 조건을 달떄는 집계값만 가지고 조건을 달아야한다.
--having은 그룹핑한 후의 조건 (집계값을 조건으로해야함)
------------------------------
select department_id , avg(salary) 
from employees
where department_id in (10,20,30)
GROUP by department_id
having avg(salary) > 5000 --그룹핑이 끝나면 셀렉트절에 있는 결과만 가지고 따져야한다. 이미 셀러리는 계산되었음
order by department_id;

select department_id , avg(salary) 
from employees
where department_id in (10,20,30) --select부터 where까지 1번째 평가
GROUP by department_id --group by 2번쨰 평가
having department_id=10 --그룹핑하고 난 이후의 조건이니 이후에 결과 안의 행에있는것으로만 having가능. 3번째 평가
order by department_id; --정렬

