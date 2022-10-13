/*########################
제약 조건: Not Null
#############################*/

--데이터가 들어오지 않으면 예외처리
drop table members;
create table members(
    mid VARCHAR(20) constraint members_mid_nn not null,
    mname VARCHAR(20) not null,
    mtel VARCHAR(20) null
);

insert into members (mid, mname, mtel) --컬럼목록있음
values('winter','한겨울','010-123-1234');

-- 컬럼리스트가 생략되면, DB에 추가된 컬럼 순서대로 모든 컬럼의 값을 제공
--컬럼목록없음
insert into members values('winter','한겨울','010-123-1234');

--명시적으로null에 저장
insert into members (mid, mname, mtel)
values('winter','한겨울','null');

--컬럼 리스트에 없는 컬럼은 null로 저장됨.
insert into members (mid, mname)
values('winter','한겨울');

