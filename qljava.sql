use master
go
create database qlynhomJAVA
go
use qlynhomJAVA
go
create table admin(
id int identity primary key,
username varchar(30),
password varchar(20),
hoten nvarchar(50),
)
go
create table topic(
id int identity primary key,
nd nvarchar(1000),
)
go
create table team(
id int identity primary key,
topic_id int foreign key references topic(id),

result nvarchar(100),
ghichu nvarchar(100),
)
go
create table stage(
id int identity primary key,
start date,
finish date,


)
go
create table stage_result(
stage_id int foreign key references stage(id),
team_id int  foreign key references team(id),
primary key (stage_id,team_id),
result nvarchar(100),
ghichu nvarchar(1000),
)
go
create table sinhvien(
id int identity primary key,
masv char(10),
hoten nvarchar(30),
lop varchar(10),
team_id int foreign key references team(id), 
)
create table work(
sv_id int foreign key references sinhvien(id),
stage_id int foreign key references stage(id),
duty nvarchar(500),
result nvarchar(100),
ghichu nvarchar(1000),
)
go


/*



*/
insert into admin values ('abc','1','abc')
go