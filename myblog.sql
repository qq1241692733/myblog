drop database if exists myblog;
create database myblog;

use myblog;

drop table if exists userinfo;
create table userinfo(
id int primary key auto_increment,
createtime datetime default now(),
updatetime datetime default now(),
username varchar(50) not null,
password varchar(50) not null,
state int default 1
);
-----------------------------------------

drop table if exists articleinfo;
create table articleinfo(
id int primary key auto_increment,
createtime datetime default now(),
updatetime datetime default now(),
title varchar(100) not null,
content text not null,
rcount int default 1,
state int default 1,
uid int not null
);


