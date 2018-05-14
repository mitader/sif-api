-------------------------------------------------------------------------------------------------------------------------
-- Creating structure for PROVINCE
-------------------------------------------------------------------------------------------------------------------------
create table province(
	id bigint(20) primary key auto_increment,
	name varchar(20) not null,
	status integer(1) not null,
	constraint uq_province_name unique(name) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-------------------------------------------------------------------------------------------------------------------------
-- Inserting initial DATA
-------------------------------------------------------------------------------------------------------------------------
insert into province (name, status) values ('Central', 1);
insert into province (name, status) values ('Cabo Delgado', 1);
insert into province (name, status) values ('Niassa', 1);
insert into province (name, status) values ('Nampula', 1);
insert into province (name, status) values ('Zambézia', 1);
insert into province (name, status) values ('Tete', 1);
insert into province (name, status) values ('Sofala', 1);
insert into province (name, status) values ('Inhambane', 1);
insert into province (name, status) values ('Gaza', 1);
insert into province (name, status) values ('Maputo Cidade', 1);
insert into province (name, status) values ('Maputo Província', 1);