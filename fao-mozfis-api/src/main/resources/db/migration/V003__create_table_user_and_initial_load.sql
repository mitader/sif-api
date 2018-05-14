-------------------------------------------------------------------------------------------------------------------------
-- Creating structure for USER_DATA
-------------------------------------------------------------------------------------------------------------------------
create table users(
	id bigint(20) primary key auto_increment,
	username varchar(20) not null,
	password varchar(100) not null,
	fullname varchar(50) not null,
	email varchar(50),
	celular varchar(30),
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

insert into users (username, password, fullname, email, celular, status, province_id, access_profile_id)
values ('000000001','password','Nelson Magalhães', 'nelson.magalhaes@fao.org','+258000000001', 1, 1, 1);
insert into users (username, password, fullname, email, celular, status, province_id, access_profile_id)
values ('000000002','password','John Doe', 'john.doe@fao.org','+258000000002', 1, 1, 2);	
	
	

