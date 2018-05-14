-------------------------------------------------------------------------------------------------------------------------
-- Creating structure for ACCESS_PROFILE
-------------------------------------------------------------------------------------------------------------------------
create table access_profile(
	id bigint(20) primary key auto_increment,
	code varchar(20) not null,
	name varchar(20) not null,
	status integer(1) not null,
	constraint uq_access_profile_code unique(code)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-------------------------------------------------------------------------------------------------------------------------
-- Inserting initial DATA
-------------------------------------------------------------------------------------------------------------------------
insert into access_profile (code, name, status) values ('00','Administrador', 1);
insert into access_profile (code, name, status) values ('01','Gestor', 1);