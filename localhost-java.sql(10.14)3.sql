drop table members;
drop table freeboards;

create table members (
    mid varchar(10) not null,
    mname VARCHAR(20) not null
);

alter table members
    add CONSTRAINT pk_mid primary key (mid);
    
create table freeboards(
    bno number not null, --number의 크기를 알려면 도큐먼트참고
    btitle varchar(50) not null,
    writer varchar(10) not null --이값은 멤버테이블의 mid에 넣겠다 . mid의 값을 writer에 넣는다 p.k는 외부에 있는키를 가져온다는 뜻에서 Foreign key라고 한다.
);
    
alter table freeboards
    add CONSTRAINT pk_bno primary key (bno);
---------------------------------------------
insert into members VALUES('fall','한가을');
insert into freeboards VALUES(1,'단풍','fall');
insert into freeboards VALUES(2,'눈','winter'); --(0)

select * from freeboards;

------------------------------------------
drop table freeboards;
--방법1
create table freeboards(
    bno number not null, --number의 크기를 알려면 도큐먼트참고
    btitle varchar(50) not null,
    writer varchar(10) CONSTRAINT fk_writer REFERENCES members(mid) --이름안주면 제약조건 sys로 시작하는 이름붙음
);
alter table freeboards
    add CONSTRAINT pk_bno primary key (bno);
--방법2
create table freeboards(
    bno number not null, --number의 크기를 알려면 도큐먼트참고
    btitle varchar(50) not null,
    writer varchar(10) not null,
    CONSTRAINT fk_writer FOREIGN key(writer) REFERENCES members(mid) --컬럼정의하고 맨마지막에 
);

alter table freeboards
    add CONSTRAINT pk_bno primary key (bno);
    
    --방법3(가장많이씀)
create table freeboards( --컬럼정의할떄는 컬럼정의만하고 , 나중에 만듦
    bno number not null, --number의 크기를 알려면 도큐먼트참고
    btitle varchar(50) not null,
    writer varchar(10) not null
);

alter table freeboards
    add CONSTRAINT pk_bno primary key (bno); --프라이머리키 추가
alter table freeboards
    add CONSTRAINT fk_writer FOREIGN key(writer) REFERENCES members(mid); --레퍼런스 키추가
    
insert into freeboards VALUES(1,'단풍','fall');
insert into freeboards VALUES(2,'눈','winter'); --(x) 부모키, 참조키가 없음
------------------------------------------
--참조하고 있는 키는 삭제할 수 없음 
delete from members where mid='fall';
delete from freeboards where bno=1;

--방법1
--모든 참조하는 키를 포함한 행을 삭제한다.(위험) (게시글 자체를 삭제)
drop table freeboards;
create table freeboards(
    bno number not null, --number의 크기를 알려면 도큐먼트참고
    btitle varchar(50) not null,
    writer varchar(10) null,
    CONSTRAINT fk_writer FOREIGN key(writer) REFERENCES members(mid) --컬럼정의하고 맨마지막에 
);

alter table freeboards
    add CONSTRAINT pk_bno primary key (bno);
    
alter table freeboards
        add CONSTRAINT fk_writer 
        FOREIGN key(writer)
        REFERENCES members(mid) on delete cascade; 
    insert into freeboards VALUES(1,'단풍','fall');
    delete from members where mid='fall';
    
--방법2 삭제하려는 참조키가 not null 이면 불가능 (게시글은 남아있고, 작성자부분에 null이 들어감 포인터가 가르키고있는 참조만 없어짐)
drop table freeboards;
create table freeboards(
    bno number not null, --number의 크기를 알려면 도큐먼트참고
    btitle varchar(50) not null,
    writer varchar(10) null
);


alter table freeboards
        add CONSTRAINT fk_writer 
        FOREIGN key(writer)
        REFERENCES members(mid) on delete set null;  --작성자에 null만 넣어줌.
        
insert into freeboards VALUES(1,'단풍','fall');

delete from members where mid='fall';