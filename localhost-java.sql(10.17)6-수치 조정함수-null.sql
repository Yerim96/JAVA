--------06-3 숫자 데이터를 연산하고 수치를 조정하는 숫자 함수 
select salary,
    round(salary/31),
    round(salary/31,2), --2번째 자리에서 올릴수있으면올리고
    trunc(salary/31,2), -- 2번쨰 자리에서 무조건 버림
    ceil(salary/31),
    floor(salary/31),
    mod(salary,31)
from employees;

create table boards(
    bno number primary key,
    btitle varchar(50) not null,
    bdate date  not null
);

insert into boards values(1,'제목', sysdate); 
select * from boards;

--날짜 연산(일수기준)
select sysdate, sysdate+14 from dual;

select to_date('2022-12-31', 'YYYY-MM-dd') - sysdate from dual; --문자-날짜라 형식 안맞아 (x)

--날짜 함수
select sysdate, add_months(sysdate, 1) from dual;
select months_between(to_date('2022-12-31', 'YYYY-MM-dd'), sysdate) from dual;

SELECT SYSDATE, NEXT_DAY(SYSDATE, '금요일') from dual; --돌아오는 금요일 (현재날짜에서) 설정이 한국어로 되어있어 영어로 안됨
SELECT SYSDATE, LAST_DAY(SYSDATE) from dual; --오늘달의 마지막 일

select hire_date from employees;
select to_char(sysdate,'yyyy.mm.dd hh24:mi:ss am') from employees;

--변환 함수 ~6.5
select hire_date from employees; --날짜형식 바꾸려면 환경설정 가서 바꿔주기
select to_char(sysdate,'yyyy.mm.dd hh24:mi:ss am') from employees;
select to_char(salary,'l99,999.00') from employees;

insert into boards values(2,'제목2', to_date('2022.10.17','yyyy.mm.dd')); --문자를 날짜타입으로 바꾸어 저장할수도 있지만,
select * from boards where bdate='2022.10.17';--그냥 묵시적으로 변환할수있다.
select * from boards where bdate >='2022.10.16';
select '2022-12-31' - sysdate from dual; --문자열 형식달라서안됨 이럴때 데이터로 바꿔줘야함.
select to_date('2022.12.31', 'yyyy.mm.dd') - sysdate from dual; --묵시적으로 변환할수 있어도 to_date 필요할떄가 있다.