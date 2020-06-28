create database bank;

use bank;

create table account(accountId int(10) unique not null auto_increment ,balance int,constraint acc_id primary key(accountId));


create table accountHolder(accountHolderId int(10) not null, firstName varchar(20) not null,lastName varchar(20) not null,emailId varchar(50),address varchar(500) not null,accountId int(10));

alter table accountHolder add constraint acc_Id_FK foreign key (accountId) references account(accountId); 

insert into account values(1000008662,50000);
insert into account values(1000008663,60000);
insert into account values(1000008664,70000);
insert into account values(1000008665,80000);
insert into account values(1000008666,90000);
insert into account values(1000008667,100000);

insert into accountHolder values(1000000001,"pranav","kadam","pranavkadam@gmail.com","katraj,pune,maharashtra",1000008662);
insert into accountHolder values(1000000001,"pranav","kadam","pranavkadam@gmail.com","katraj,pune,maharashtra",1000008663);
insert into accountHolder values(1000000002,"pushkar","kale","pushkarkale@gmail.com","deccan,pune,maharashtra",1000008664);
insert into accountHolder values(1000000002,"pushkar","kale","pushkarkale@gmail.com","deccan,pune,maharashtra",1000008665);
insert into accountHolder values(1000000003,"pavan","kasar","pavankasar@gmail.com","swargate,pune,maharashtra",1000008666);
insert into accountHolder values(1000000003,"pavan","kasar","pavankasar@gmail.com","swargate,pune,maharashtra",1000008667);




