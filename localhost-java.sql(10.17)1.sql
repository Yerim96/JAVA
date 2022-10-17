--전체 사원의 정보 가져오기
select * from employees; 

--전체 사원의 특정 컬럼 정보 가져오기
select employee_id, first_name, last_name, department_id 
from employees; 

--사원들이 소속되어 있는 부서 번호 가져오기 (중복을 제거)-- DISTINCT
select distinct department_id from employees; 

--직무 번호와 부서 번호를 결합해서 중복을 제거 --하나의 컬럼만 적용되는것이 아니라 코드에 있는 컬럼을 모두 적용
select distinct job_id, department_id from employees;

--같은 의미. select는 중복설정이 없을경우 all을 기본적으로 사용
select job_id, department_id from employees;
select all job_id, department_id from employees;