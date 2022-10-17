--한눈에 보기 좋게 별칭 설정하기 p84 -- 컬럼 내용을 연산할 경우에는 별칭을 붙여주는것이 좋다.
select first_name, salary, salary*12 as yearsal --셀러리 한행에 *12한 값이 나옴  컬럼 이름 제시하는것이 좋음
--as를 이용해 연산식에 대해 가져온 값의 컬럼 이름을 yearsal로 하겠다. 이때  as는 생략 가능하다. 하지만 가급젹 사용하기
from employees;

