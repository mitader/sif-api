-------------------------------------------------------------------------------------------------------------------------
-- Creating structure for PROVINCE
-------------------------------------------------------------------------------------------------------------------------
create table province(
	id bigint(20) primary key auto_increment,
	name varchar(20) not null,
	status integer(1) not null,
	constraint uq_province_name unique(name) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table district(
	id bigint(20) primary key auto_increment,
	name varchar(20) not null,
	status integer(1) not null,
	province_id bigint(20),	
	foreign key (province_id) references province(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table administrative_post(
	id bigint(20) primary key auto_increment,
	name varchar(20) not null,
	status integer(1) not null,
	district_id bigint(20),	
	foreign key (district_id) references district(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table locality(
	id bigint(20) primary key auto_increment,
	name varchar(20) not null,
	status integer(1) not null,
	administrative_post_id bigint(20),	
	foreign key (administrative_post_id) references administrative_post(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-------------------------------------------------------------------------------------------------------------------------
-- Inserting initial DATA
-------------------------------------------------------------------------------------------------------------------------
insert into province (id, name, status) values (1, 'Central', 1);
insert into province (id, name, status) values (2, 'Cabo Delgado', 1);
insert into province (id, name, status) values (3, 'Niassa', 1);
insert into province (id, name, status) values (4, 'Nampula', 1);
insert into province (id, name, status) values (5, 'Zambézia', 1);
insert into province (id, name, status) values (6, 'Tete', 1);
insert into province (id, name, status) values (7, 'Sofala', 1);
insert into province (id, name, status) values (8, 'Manica', 1);
insert into province (id, name, status) values (9, 'Inhambane', 1);
insert into province (id, name, status) values (10, 'Gaza', 1);
insert into province (id, name, status) values (11, 'Maputo Cidade', 1);
insert into province (id, name, status) values (12,'Maputo Província', 1);

insert into district (id, province_id, name, status) values (1, 1, 'Central', 1);
insert into district (id, province_id, name, status) values (2, 2, 'Pemba', 1);
insert into district (id, province_id, name, status) values (3, 3, 'Lichinga', 1);
insert into district (id, province_id, name, status) values (4, 4, 'Nampula', 1);
insert into district (id, province_id, name, status) values (5, 5, 'Quelimane', 1);
insert into district (id, province_id, name, status) values (6, 6, 'Tete', 1);
insert into district (id, province_id, name, status) values (7, 7, 'Beira', 1);
insert into district (id, province_id, name, status) values (8, 8, 'Chimoio', 1);
insert into district (id, province_id, name, status) values (9, 9, 'Inhambane', 1);
insert into district (id, province_id, name, status) values (10, 10, 'Xai-xai', 1);
insert into district (id, province_id, name, status) values (11, 11, 'Cidade Maputo', 1);
insert into district (id, province_id, name, status) values (12, 12, 'Matola', 1);

insert into administrative_post (id, district_id, name, status) values (1, 1, 'Central', 1);
insert into administrative_post (id, district_id, name, status) values (2, 2, 'Cidade de Pemba', 1);
insert into administrative_post (id, district_id, name, status) values (3, 3, 'Cidade de Lichinga', 1);
insert into administrative_post (id, district_id, name, status) values (4, 4, 'Cidade de Nampula', 1);
insert into administrative_post (id, district_id, name, status) values (5, 5, 'Cidade de Quelimane', 1);
insert into administrative_post (id, district_id, name, status) values (6, 6, 'Cidade de Tete', 1);
insert into administrative_post (id, district_id, name, status) values (7, 7, 'Cidade da Beira', 1);
insert into administrative_post (id, district_id, name, status) values (8, 8, 'Cidade de Chimoio', 1);
insert into administrative_post (id, district_id, name, status) values (9, 9, 'Cidade de Inhambane', 1);
insert into administrative_post (id, district_id, name, status) values (10, 10, 'Cidade de Xai-xai', 1);
insert into administrative_post (id, district_id, name, status) values (11, 11, 'Cidade de Maputo', 1);
insert into administrative_post (id, district_id, name, status) values (12, 12, 'Cidade da Matola', 1);

insert into locality (id, administrative_post_id, name, status) values (1, 1, 'Central', 1);
insert into locality (id, administrative_post_id, name, status) values (2, 2, 'Cidade de Pemba', 1);
insert into locality (id, administrative_post_id, name, status) values (3, 3, 'Cidade de Lichinga', 1);
insert into locality (id, administrative_post_id, name, status) values (4, 4, 'Cidade de Nampula', 1);
insert into locality (id, administrative_post_id, name, status) values (5, 5, 'Cidade de Quelimane', 1);
insert into locality (id, administrative_post_id, name, status) values (6, 6, 'Cidade de Tete', 1);
insert into locality (id, administrative_post_id, name, status) values (7, 7, 'Cidade da Beira', 1);
insert into locality (id, administrative_post_id, name, status) values (8, 8, 'Cidade de Chimoio', 1);
insert into locality (id, administrative_post_id, name, status) values (9, 9, 'Cidade de Inhambane', 1);
insert into locality (id, administrative_post_id, name, status) values (10, 10, 'Cidade de Xai-xai', 1);
insert into locality (id, administrative_post_id, name, status) values (11, 11, 'Cidade de Maputo', 1);
insert into locality (id, administrative_post_id, name, status) values (12, 12, 'Cidade da Matola', 1);