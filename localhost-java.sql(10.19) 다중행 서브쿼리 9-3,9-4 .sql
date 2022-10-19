--249p 09-3 실행 결과가 여러 개인 다중행 서브쿼리
--실행 결과가 여러개 =실행결과 행이 여러개로 나오는 서브쿼리를 다중행 서브쿼리라고 한다.
--서브쿼리
--행별로 조인을 한다. 수십억행을 조인한다는 이야기는 시간이 오래걸린단 이야기임. 서브쿼리로 대체할 수 있는것은 해야함.



select employee_id , first_name
from employees
where salary =(select max(salary) from employees); --=뒤에는 단일행 서브쿼리만 와야하고, 리턴값이 맞아야한다.

select employee_id , first_name
from employees
where department_id in(
    select department_id from departments where location_id=1700 --다중행 서브쿼리 메인쿼리와 비교한 값에서 리턴값이 맞는것만가져옴
    ); 

--in 연산자 
select employee_id, first_name, job_id, department_id
from employees
where salary in (select max(salary) --셀렉트에 있는것은 반드시 그룹바이에 있어야한다.in은 이중select문중에서 하나만 있으면 된다.
        from employees  
        group by department_id);
-----------------------------------------
----any,some 연산자---------------------
--any와 some은 모두 어떤것(몇몇)이라는 의미로 , 기능이 같은 연산자이다.
--in은 자체가 연산자지만 any나 some이나 all은 앞에 연산자가 하나 더 붙는다.(=,>,<)
--=,>,<들중에 하나라도 만족하는가에 따라 true,false가 되며 리턴한다.

--any 연산자
select employee_id, department_id 
from employees
where department_id = any(10,11);  --department id 가 any에 있는지 확인.있으면 사원과 부서 아이디를 가져와라. 하나라도 같으면 같은것이다.

--some 연산자
select employee_id, department_id 
from employees
where department_id = some(10,11);

select employee_id, salary, department_id
from employees
where department_id=100 and
    salary>any (8000,9000,10000); --여러값들중에서 하나라도 만족되면 true. 메인쿼리에 있는 행중에서 만족이 되면, 그것이 선택됨.


select employee_id, salary, department_id
from employees
where department_id=100 and
    salary>=any (
    select avg(salary)
    from employees
    group by department_id
    );
    
--all 연산자
select employee_id, salary, department_id
from employees
where department_id=100 and
    salary>=all (8000,9000,10000); -- >=10000보다 크거나 같다.와 의미가 같음.
    
select employee_id, salary, department_id
from employees
where department_id=100 and
    salary>=all (-- all 안에 여러개의 값을 제공해주는 서브쿼리를 작성할 수 있다.
    select avg(salary)
    from employees
    group by department_id
    ); 

----------
--exists 연산자는 서브쿼리에 값의 유뮤에 따라 메인쿼리의 선택 여부가 달라진다.
--exists 다음에는 서브쿼리가 와야함.
select employee_id, department_id
from employees
where exists(select 10 from dual); --뒤에값이 하나라도 있으면 true라 메인 select문과 결과가 같아지지만 없으면 실행결과 x

select employee_id, department_id
from employees
where exists(select department_name --서브쿼리문에 해당하는 값이 없기 때문에 메인 select문에서 아무것도 가져오지 않는다.
    from departments
    where department_id=1000
    );
    
--메인쿼리의 값을 서브커리에 실행할때 받고 처리후 값이 있을때 메인쿼리의 값이 선택되도록함.
--바깥쪽의 메인쿼리 값(외부 값)을 서브쿼리에서 사용
select employee_id, department_id
from employees e
where exists(select department_name 
    from departments
    where department_id= e.department_id
    );
    
--메인쿼리의 값이 서브쿼리에 들어가 가져오는 결과값이 달라짐.
select employee_id, department_id
from employees e
where exists(select department_name  --exit는외부커리값을 받아서 수행한다음 존재할경우 외부커리값이 선택된다.
    from departments
    where department_id =(e.department_id + 200) --부서아이디가 120까지는 괜찮지만 120을 넘어가면 부서이름은 존재하지 않는다. 
    );
    
--exists 연산자 문제
--게시물을 전혀 작성하지 않은 멤버의 아이디와 이름을 가져오시오.

select * from members;
select * from boards;
--방법1 join이용 outer조인 summer,winter출력 한번도 글 작성안한사람.
--사원이 없는 부서의 번호와 이름
select m.MID,m.MNAME
from members m, boards b
where m.mid=b.mid(+) and
    b.bno is null;
 

 
--방법 2 subquery이용 exists
select MID,MNAME
from MEMBERS m
where not exists(
    select bno  
    from boards b
    where b.mid =m.mid --summer가 글을 하나도 쓰지 않았다면 bno에 값이 들어가지않아 아무것도 나오지 않는다. 
    );
    
--근무도시가 시애틀인 사원의 이메일과 전화번호를 가져오시오
--방법1: join 이용 
select EMAIL,PHONE_NUMBER
from EMPLOYEES e , departments d, locations l
where e.department_id=d.department_id 
    and d.location_id=l.location_id 
    and l.city='Seattle';
    
--방법2: subquery 이용
select EMAIL,PHONE_NUMBER
from EMPLOYEES
where department_id in( --where자리에 서브쿼리가 사용,
    select department_id
    from departments
    where location_id = (
        select location_id
        from locations
        where city = 'Seattle'
    )
); 
--방법3: exists
select EMAIL,PHONE_NUMBER
from EMPLOYEES e
where exists( 
    select department_id
    from departments d, locations l
    where d.loaction_id =l.loaction_id and
        d.department_id=e.department_id and
        l.city='Seattle'
);

-------------------------------------------
--09-4 비교할 열이 여러개인 다중열 서브쿼리
-----------------------------------------------
select employee_id,salary, department_id
from employees
where (department_id, salary) in (
    select department_id, max(salary)
    from employees
    group by department_id --각부서에서 가장 봉급을 많이 가져가는 사람의 컬럼을 출력
);

