create table TBL_Trainee_Absentee_Tailgater
(
	empId number(10) primary key,
	empName varchar2(50),
	lgName varchar2(50),
	batchName varchar2(50),
	project varchar2(50),
	city varchar2(50),
	location varchar2(50),
	dor DATE
);

create table TBL_Day
(
	curDate DATE primary key
);

create table TBL_Trainee_Day
(
	empId number(10) references TBL_Trainee_Absentee_Tailgater(empId),
	curDate Date references TBL_Day(curDate),
	status varchar2(10),
	primary key(empId, curDate)
);

create table TBL_UserType
(
	userTypeId number(5) primary key,
	userTypeName varchar2(50)
);

create table TBL_User
(
	empId number(10) primary key,
	userName varchar2(50),
	password varchar2(50),
	userTypeId number(5) references TBL_UserType(userTypeId)
);

create table TBL_Employee
(
	empId number(10) references TBL_User(empId),
	empName varchar2(50),
	email varchar2(50),
	designation varchar2(50),
	location varchar2(50),
	primary key(empId)
);

create table TBL_Trainee_Temp
(
	empId number(10) primary key,
	empName varchar2(50),
	lgName varchar2(50),
	batchName varchar2(50),
	doj date,
	dor date
);
insert into TBL_UserType values(1,'admin');
insert into TBL_UserType values(2,'ftm');
insert into TBL_Trainee_Temp values(834002,'emp1','TJA142','TVM30',TO_DATE('01-MAR-2015', 'dd-MON-yyyy'), TO_DATE('01-JUN-2015', 'dd-MON-yyyy'));
insert into TBL_Trainee_Temp values(834003,'emp2','TJA142','TVM30',TO_DATE('01-MAR-2015', 'dd-MON-yyyy'), TO_DATE('01-JUN-2015', 'dd-MON-yyyy'));
insert into TBL_Trainee_Temp values(834004,'emp3','TJA142','TVM30',TO_DATE('01-MAR-2015', 'dd-MON-yyyy'), TO_DATE('01-JUN-2015', 'dd-MON-yyyy'));
insert into TBL_Trainee_Temp values(834005,'emp4','TJA142','TVM30',TO_DATE('01-MAR-2015', 'dd-MON-yyyy'), TO_DATE('01-JUN-2015', 'dd-MON-yyyy'));
insert into TBL_Trainee_Temp values(834006,'emp5','TJA142','TVM30',TO_DATE('01-MAR-2015', 'dd-MON-yyyy'), TO_DATE('01-JUN-2015', 'dd-MON-yyyy'));
insert into TBL_Trainee_Temp values(834007,'emp6','TJA142','TVM30',TO_DATE('01-MAR-2015', 'dd-MON-yyyy'), TO_DATE('01-JUN-2015', 'dd-MON-yyyy'));
insert into TBL_Trainee_Temp values(834008,'emp7','TJA142','TVM30',TO_DATE('01-MAR-2015', 'dd-MON-yyyy'), TO_DATE('01-JUN-2015', 'dd-MON-yyyy'));

drop table TBL_Trainee_Day;
drop table TBL_Trainee_Absentee_Tailgater;
drop table TBL_Day;
drop table TBL_Employee;
drop table TBL_User;
drop table TBL_UserType;
drop table TBL_Trainee_Temp;

select * from TBL_User
select * from TBL_UserType;
select * from TBL_Employee;

select * from TBL_Trainee_Absentee_Tailgater;
select * from TBL_Day;
select * from TBL_Trainee_Day;
select  tr.* from TBL_Trainee_Absentee_Tailgater tr join TBL_Trainee_Day trd on tr.empId=trd.empId join TBL_Day da on da.curdate=trd.curdate where trd.status='A' and da.curdate= TO_DATE('03-MAR-2015', 'dd-MON-yyyy');
select tr.empId,tr.empName,tr.lgname, count(trd.status) from TBL_Trainee_Absentee_Tailgater tr join TBL_Trainee_Day trd on tr.empId=trd.empId join TBL_Day da on da.curdate=trd.curdate where trd.status='A' group by tr.empId,tr.empName,tr.lgname having count(trd.status)>2 order by empId;

insert into TBL_Trainee_Absentee_Tailgater (empId) values (834002);
insert into TBL_Trainee_Absentee_Tailgater (empId) values (834003);

insert into TBL_Trainee_Days values (834002,TO_DATE('02-MAR-2015', 'dd-MON-yyyy'), 'A');
insert into TBL_Trainee_Days values (834003,TO_DATE('02-MAR-2015', 'dd-MON-yyyy'), 'A');

insert into TBL_Trainee_Days values (834002,TO_DATE('03-MAR-2015', 'dd-MON-yyyy'), 'A');
insert into TBL_Trainee_Days values (834003,TO_DATE('03-MAR-2015', 'dd-MON-yyyy'), 'A');

insert into TBL_Trainee_Days values (834002,TO_DATE('04-MAR-2015', 'dd-MON-yyyy'), 'A');
insert into TBL_Trainee_Days values (834003,TO_DATE('04-MAR-2015', 'dd-MON-yyyy'), 'A');

select * from TBL_Trainee_Absentee_Tailgater;
select * from TBL_Trainee_Days;
select T.* from TBL_Trainee_Absentee_Tailgater T INNER JOIN TBL_Trainee_Days D ON T.empId = D.empId where D.status = 'A' AND D.curDate = TO_DATE('02-MAR-2015', 'dd-MON-yyyy');

select T.*, COUNT(D.Status) from TBL_Trainee_Absentee_Tailgater T, TBL_Trainee_Days D where D.empId = T.empId;

SELECT b.empId, COUNT(a.status) 
from TBL_Trainee_Absentee_Tailgater b, TBL_Trainee_Days a 
where a.empID = b.empID
group by b.empId;

select * from TBL_Trainee_Absentee_Tailgater;
select * from TBL_Trainee_Days;

insert into TBL_Trainee_Absentee_Tailgater (empId) values(834002);
insert into TBL_Trainee_Days values(834002,TO_DATE('01-03-2015', 'dd-MM-yyyy'),'A');