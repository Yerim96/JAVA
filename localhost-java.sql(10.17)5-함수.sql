----------------------------------------------------------
--오라클 함수
----------------------------------------------------------------

--여러개의 행이(사원별) 함수가 처리되는것 = single=row
-- Aggregate Functions => 집계. 여러개의 행을 축약해 하나의 결과로 만듦.
--문자데이터를 매개값으로 받고 리턴값으로 문자를 리턴한다.
--upper,lower,initcap 등등...으로 !!행별로!!사용한다. 필요할떄마다 도큐먼트 참고 function- Character Functions Returning Number Values

--행별로 대문자로 바꾸어 가져와달라.
select last_name, upper(last_name) 
from employees;

--행별로 소문자로 바꾸어 가져와달라.
select last_name, lower(last_name)
from employees;

--위치 상관없이 st가 포함된 
select first_name
from employees
where lower(first_name) like '%st%';--함수가 조건식으로 사용됨.모두 소문자로 변환 후 st에 포함될경우 출력

--INITCAP의 도큐먼트안의 가상테이블
SELECT INITCAP('the soap') "Capitals" 
  FROM DUAL; -- DUAL은 가상테이블 특정테이블에서 데이터를 가져오는게 아니라 위코드에서만 연산하고 싶을떄 사용.

--INITCAP으로 첫글자는 대문자, 나머지는 소문자  
select email from employees;
select initcap(email) from employees;

create table members (
    mid varchar(50) not null,
    mname varchar(50) not null
);
insert into members values('fall','한가을');
commit;

select mname, length(mname),lengthb(mname),lengthc(mname) from members;

select first_name, substr(first_name, 5), substr(first_name, -3, 2) --순수 컬럼값이 아니라 연산한경우 꼭 as로 이름을 따로 만들어줘라.
from employees;

------------------------REPLACE 함수
select phone_number, replace(phone_number,'.','-')
from employees;

--3자리까지 나오는데 , 나머지는 아스타처리 substr, rpad (3자리, 뒤에 *처리 뒤에 전체가 6자리)
select first_name, RPAD(substr(first_name,1,3),6 , '*')
from employees;

select (first_name || ',' || last_name) as name -- 연산값 행에는 이름을 달아야함. +대신 ||가 문자열 결합을 뜻함. 
from employees;

select concat(first_name, concat( ',', last_name)) as name -- 연산값 행에는 이름을 달아야함. +대신 ||가 문자열 결합을 뜻함. 
from employees;

--substr, replace,rpad,length 알아두기----