use estate4month2019;

create table building(
	id bigint not null primary key auto_increment,
    name varchar(255) null,
    ward varchar(100) null,
    street varchar(100) null,
    buildingarea int null,
    structure varchar(100) null,
    numberofbasement int null,
    costrent int null,
    buildingtype text null,
    costdescription text null,
    servicecost varchar(255) null,
    carcost varchar(255) null,
    overtimecost varchar(255) null,
   	motorbikecost varchar(255) null,
   	electriccost varchar(255) null, 
   	deposit varchar(255) null, 
   	payment varchar(255) null, 
   	timerent varchar(255) null, 
   	timedecorate varchar(255) null, 
   	managename varchar(255) null,
   	managephone varchar(255) null,
   	type varchar(255) null
 	
);

create table role(
	id bigint not null primary key auto_increment,
    name varchar(255) not null,
    code varchar(255) not null

);


create table user(
	id bigint not null primary key auto_increment,
	name varchar(255) not null,
	password varchar(255) not null,
	fullname varchar(255)  null,
	status int not null,
	
	createddate timestamp null,
    modifieddate timestamp null,
    createdby varchar(255) null,
    modifiedby varchar(255) null
);


create table user_role(
	id bigint not null primary key auto_increment,
	roleid bigint not null,
	userid bigint not null,
	
	 createddate timestamp null,
    modifieddate timestamp null,
    createdby varchar(255) null,
    modifiedby varchar(255) null
);
alter table user_role add constraint fk_userrole_role foreign key(roleid) references role(id);
alter table user_role add constraint fk_userrole_user foreign key(userid) references user(id);

create table district(
	id bigint not null primary key auto_increment,
	 name varchar(255) not null,
    code varchar(255) not null,
    createddate timestamp null,
    modifieddate timestamp null,
    createdby varchar(255) null,
    modifiedby varchar(255) null
);

create table assignmentbuilding(
	id bigint not null primary key auto_increment,
	buildingid bigint not null,
	userid bigint not null
	
);
alter table assignmentbuilding add constraint fk_assignmentbuilding_building foreign key(buildingid) references building(id);
alter table assignmentbuilding add constraint fk_assignmentbuilding_user foreign key(userid) references user(id);

create table rentarea(
	id bigint not null primary key auto_increment,
	value varchar(255) not null,
    buildingid bigint not null,
    createddate timestamp null,
    modifieddate timestamp null,
    createdby varchar(255) null,
    modifiedby varchar(255) null
);

alter table rentarea add constraint fk_rentarea_building foreign key(buildingid) references building(id);











