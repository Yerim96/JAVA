select employee_id, first_name, job_id, salary,
    ROUND(decode(JOB_ID, 'AD_VP',SALARY*1.1,'FI_MGR',SALARY*1.3,salary*1.2)) as upsal --잡아이디가 AD_VP일경우셀러리에 1곱함,
    --ROUND로 소숫점정리
from employees
where job_id in ('AD_VP','FI_MGR','PU_MAN');
-----------------------------------------
--CASE문--
--케이스는 디코드와 비슷하다. 앞에는 원본데이터가 온다.(검사대상)
--WHEN을 IF로 생각하면 된다. WHEN일때 THEN뒤에 오는것. 
--맨마지막은 END. 그밖에는 ELSE (디폴트값)
--CASE문 끝에는 END가 반드시 있다.
--SIMPLE CASE EXPRESSION은 원본값.WHEN일때 THEN실행. 
--원본데이터가 when값일때  THEN 리턴
select employee_id, first_name, job_id, salary,
    ROUND(CASE JOB_ID
    WHEN 'AD_VP'THEN SALARY*1.1
    WHEN 'FI_MGR' THEN SALARY*1.3
    ELSE SALARY*1.2
    END
    ) as upsal

from employees
where job_id in ('AD_VP','FI_MGR','PU_MAN');
-----------------------------------------------------
--기준 데이터 없이 조건식만으로 CASE문 사용
--CASE 다음 원본값이 없다. 따라서 그 뒤에는 조건식이 오고, TRUE이면 THEN뒤 실행문 실행.
--물론 END뒤에 DEFAULT들어갈 수 있다.
select employee_id, first_name, commission_pct,
    case
    when commission_pct is null then '해당사항없음'
    when commission_pct > 0 then '수당: ' || commission_pct
    end as comm_text
from employees;
-----------------------------------------------

