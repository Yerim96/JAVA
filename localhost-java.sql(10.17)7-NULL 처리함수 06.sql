--------------NULL 처리 함수 06-6
select 10 + nvl(null,0) from dual;
select salary * 12 +nvl( commission_pct,0) *salary from employees;

--null이 있을때 어떻게 연산?  NVL
select salary* 12+ nvl2 (commission_pct,commission_pct*salary,0)
from employees;