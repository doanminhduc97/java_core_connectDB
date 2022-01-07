create database BkapStore;
go
use BkapStore;
go
create table Cargo (
	id int not null identity(1,1),
	name nvarchar(64),
	supplier nvarchar(64),
	quantity int default(0),
	price float default(0),
	tax tinyint default(10),
	primary key(id)
);