-------------------------------------------------------------------------------------------------------------------------
-- Creating structure for USER_DATA
-------------------------------------------------------------------------------------------------------------------------
create table users(
	id bigint(20) primary key auto_increment,
	username varchar(20) not null,
	password varchar(100) not null,
	fullname varchar(50) not null,
	email varchar(50),
	phone varchar(30),
	status integer(1) not null,
	province_id bigint(20),
	access_profile_id bigint(20),
	constraint uq_user_name unique(username),
	foreign key (province_id) references province(id),
	foreign key (access_profile_id) references access_profile(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-------------------------------------------------------------------------------------------------------------------------
-- Inserting initial DATA
-------------------------------------------------------------------------------------------------------------------------

insert into users (username, password, fullname, email, phone, status, province_id, access_profile_id)
values ('000000000','password','Nelson Magalhães', 'nelson.magalhaes@fao.org','+258000000000', 1, 1, 1);
insert into users (username, password, fullname, email, phone, status, province_id, access_profile_id)
values ('000000001','password','John Doe 1', 'john1.doe@fao.org','+258000000001', 1, 1, 2);
insert into users (username, password, fullname, email, phone, status, province_id, access_profile_id)
values ('000000002','password','John Doe 2', 'john2.doe@fao.org','+258000000002', 1, 1, 2);
insert into users (username, password, fullname, email, phone, status, province_id, access_profile_id)
values ('000000003','password','John Doe 3', 'john3.doe@fao.org','+258000000003', 1, 1, 2);
insert into users (username, password, fullname, email, phone, status, province_id, access_profile_id)
values ('000000004','password','John Doe 4', 'john4.doe@fao.org','+258000000004', 1, 1, 2);
insert into users (username, password, fullname, email, phone, status, province_id, access_profile_id)
values ('000000005','password','John Doe 5', 'john5.doe@fao.org','+258000000005', 1, 1, 2);
insert into users (username, password, fullname, email, phone, status, province_id, access_profile_id)
values ('000000006','password','John Doe 6', 'john6.doe@fao.org','+258000000006', 1, 1, 2);
insert into users (username, password, fullname, email, phone, status, province_id, access_profile_id)
values ('000000007','password','John Doe 7', 'john7.doe@fao.org','+258000000007', 1, 1, 2);
insert into users (username, password, fullname, email, phone, status, province_id, access_profile_id)
values ('000000008','password','John Doe 8', 'john8.doe@fao.org','+258000000008', 1, 1, 2);
insert into users (username, password, fullname, email, phone, status, province_id, access_profile_id)
values ('000000009','password','John Doe 9', 'john9.doe@fao.org','+258000000009', 1, 1, 2);
insert into users (username, password, fullname, email, phone, status, province_id, access_profile_id)
values ('000000010','password','John Doe 10', 'john10.doe@fao.org','+258000000010', 1, 1, 2);
insert into users (username, password, fullname, email, phone, status, province_id, access_profile_id)
values ('000000011','password','John Doe 11', 'john11.doe@fao.org','+258000000011', 1, 1, 2);
insert into users (username, password, fullname, email, phone, status, province_id, access_profile_id)
values ('000000012','password','John Doe 12', 'john12.doe@fao.org','+258000000012', 1, 1, 2);
insert into users (username, password, fullname, email, phone, status, province_id, access_profile_id)
values ('000000013','password','John Doe 13', 'john13.doe@fao.org','+258000000013', 1, 1, 2);
insert into users (username, password, fullname, email, phone, status, province_id, access_profile_id)
values ('000000014','password','John Doe 14', 'john14.doe@fao.org','+258000000014', 1, 1, 2);
insert into users (username, password, fullname, email, phone, status, province_id, access_profile_id)
values ('000000015','password','John Doe 15', 'john15.doe@fao.org','+258000000015', 1, 1, 2);