--실제 데이터베이스에 저장된 순서는 중요하지 않다. 빈번하게 데이터를 삭제하고 추가하는 테이블이라면 순서는 다 달라짐. (새로 저장 공간을 
--만드는것보다 공간을 재활용하는것이 효율적)
--저장된 순서는 중요하지 않지만 가져오는 순서는 중요하다. 정렬해서 가져오려면 ORDER BY 

--봉급액 순으로 올림차순으로 사원 번호와 봉급을 가져온다. 이때 저장된 순서로 가져오눈것이 아니라 가져온 순서대로 가져온다.
select employee_id, salary
from employees
order by salary asc;

--봉급액 순으로 내림차순으로 사원번호와 봉급 가져오기 
select employee_id, salary
from employees
order by salary desc;

--부서별로 올림차순으로 정렬하고, 같은 부서 내에서 봉급을 내림차순으로 가져오시오.
select department_id, salary
from employees
order by department_id, salary desc; --desc 생략하면 asc