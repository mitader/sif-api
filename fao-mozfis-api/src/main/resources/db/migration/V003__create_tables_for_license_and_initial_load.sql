-------------------------------------------------------------------------------------------------------------------------
-- Creating structure for OPERATOR
-------------------------------------------------------------------------------------------------------------------------
create table product_category(
	id bigint(20) primary key auto_increment,
	name varchar(200) not null,
	status integer(1) not null,
	constraint uq_product_category_name unique(name)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table product_type(
	id bigint(20) primary key auto_increment,
	name varchar(200) not null,
	status integer(1) not null,
	product_category_id bigint(20),
	constraint uq_product_type_name unique(name),
	foreign key (product_category_id) references product_category(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table specie(
	id bigint(20) primary key auto_increment,
	scientific_name varchar(200) not null,
	commercial_name varchar(200),
	local_name varchar(200),
	minimum_diameter decimal(10,2) not null,
	measurement_unit varchar(20),
	classification varchar(20),
	status integer(1) not null,
	constraint uq_specie_name unique(scientific_name, classification)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table operators(
	id bigint(20) primary key auto_increment,
	nuit varchar(9) not null,
	name varchar(200) not null,
	identification varchar(200),
	email varchar(100) not null,
	phone varchar(100) not null,
	operator_type varchar(20) not null,
	comments varchar(1000),
	status integer(1) not null,
	locality_id bigint(20) not null,
	constraint uq_operator_nuit unique(nuit),
	foreign key (locality_id) references locality(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table contract(
	id bigint(20) primary key auto_increment,
	contract_number varchar(200) not null,
	signature_date date,
	approval_date date,
	revision_date date,
	status integer(1) not null,
	constraint uq_contract_number unique(contract_number)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table document(
	id bigint(20) primary key auto_increment,
	file_name varchar(200) not null,
	file_name_uuid varchar(200) not null,
	content_type varchar(200) not null,
	contents longblob,
	status integer(1) not null
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table stage(
	id bigint(20) primary key auto_increment,
	name varchar(200) not null,
	final_stage boolean not null,
	status integer(1) not null,
	constraint uq_stage_name unique(name)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table request_stage(
	id bigint(20) primary key auto_increment,
	description varchar(500) not null,
	effective_date date,
	status integer(1) not null,
	stage_id bigint(20) not null,
	request_id bigint(20) not null,
	document_id bigint(20),
	foreign key (stage_id) references stage(id),
	foreign key (document_id) references document(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table request(
	id bigint(20) primary key auto_increment,
	process_number varchar(50) not null,
	area decimal(12,2) not null,
	year int(4) not null,
	regime varchar(30),
	purpose varchar(30),
	duration_year decimal(5,2),
	status integer(1) not null,
	operator_id bigint(20) not null,
	locality_id bigint(20) not null,
	contract_id bigint(20), -- not null,
	product_type_id bigint(20),
	last_stage_id bigint(20),
	constraint uq_request_process_number unique(process_number),
	foreign key (operator_id) references operators(id),
	foreign key (locality_id) references locality(id),
	foreign key (contract_id) references contract(id),
	foreign key (product_type_id) references product_type(id),
	foreign key (last_stage_id) references request_stage(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

alter table request_stage add constraint foreign key (request_id) references request(id);

create table license(
	id bigint(20) primary key auto_increment,
	license_number varchar(50) not null,
	year int(4) not null,
	description varchar(1000),
	status integer(1) not null,
	request_id bigint(20) not null,
	operator_id bigint(20),
	foreign key (request_id) references request(id),
	foreign key (operator_id) references operators(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table product(
	id bigint(20) primary key auto_increment,
	requested_quantity decimal(12,2),
	authorized_quantity decimal(12,2),
	status integer(1) not null,
	license_id bigint(20) not null,
	specie_id bigint(20) not null,
	foreign key (license_id) references license(id),
	foreign key (specie_id) references specie(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-------------------------------------------------------------------------------------------------------------------------
-- Inserting initial DATA
-------------------------------------------------------------------------------------------------------------------------
insert into operators (id, nuit, name, identification, email, phone, operator_type, locality_id, status) values (1, '023456789','John Doe', '023456789', 'johndoe@mail.com','+258023','COLLECTIVE',1, 1);
insert into operators (id, nuit, name, identification, email, phone, operator_type, locality_id, status) values (2, '123456789','Mary Doe', '123456789', 'marydoe@mail.com','+258123','SINGULAR',1, 1);
insert into operators (id, nuit, name, identification, email, phone, operator_type, locality_id, status) values (3, '123456780','Mary John', '123456780', 'maryjohn@mail.com','+258120','ASSOCIATION',1, 1);

insert into product_category (id, name, status) values (1, 'Madeireiro',1);
insert into product_category (id, name, status) values (2, 'Não Madeireiro',1);
insert into product_category (id, name, status) values (3, 'Combustível Lenhoso',1);
insert into product_category (id, name, status) values (4, 'Materiais de Construção',1);

insert into product_type (product_category_id, name, status) values (1, 'Madeira em toro', 1);
insert into product_type (product_category_id, name, status) values (1, 'Madeira serrada', 1);
insert into product_type (product_category_id, name, status) values (1, 'Contraplacado', 1);
insert into product_type (product_category_id, name, status) values (1, 'Painéis', 1);
insert into product_type (product_category_id, name, status) values (1, 'Parquet', 1);
insert into product_type (product_category_id, name, status) values (2, 'Raízes', 1);
insert into product_type (product_category_id, name, status) values (2, 'Bordão', 1);
insert into product_type (product_category_id, name, status) values (2, 'Fibras Espontâneas', 1);
insert into product_type (product_category_id, name, status) values (2, 'Cascas Tonantes', 1);
insert into product_type (product_category_id, name, status) values (2, 'Produtos de substâncias alcalóides', 1);
insert into product_type (product_category_id, name, status) values (2, 'Cortiça', 1);
insert into product_type (product_category_id, name, status) values (2, 'Látex boraxífero', 1);
insert into product_type (product_category_id, name, status) values (2, 'Resinas', 1);
insert into product_type (product_category_id, name, status) values (2, 'Gomas', 1);
insert into product_type (product_category_id, name, status) values (2, 'Folhas', 1);
insert into product_type (product_category_id, name, status) values (2, 'Flores', 1);
insert into product_type (product_category_id, name, status) values (2, 'Cogumelos', 1);
insert into product_type (product_category_id, name, status) values (2, 'Mel', 1);
insert into product_type (product_category_id, name, status) values (2, 'Frutos', 1);
insert into product_type (product_category_id, name, status) values (2, 'Sementes silvestres', 1);
insert into product_type (product_category_id, name, status) values (3, 'Lenha', 1);
insert into product_type (product_category_id, name, status) values (3, 'Carvão Vegetal', 1);
insert into product_type (product_category_id, name, status) values (4, 'Varas', 1);
insert into product_type (product_category_id, name, status) values (4, 'Estacas', 1);
insert into product_type (product_category_id, name, status) values (4, 'Postes', 1);
insert into product_type (product_category_id, name, status) values (4, 'Esteios', 1);
insert into product_type (product_category_id, name, status) values (4, 'bambús', 1);
insert into product_type (product_category_id, name, status) values (4, 'Caniço', 1);
insert into product_type (product_category_id, name, status) values (4, 'Capim', 1);

insert into stage (id, name, final_stage, status) values (1, 'Pedido de Área', 0, 1);
insert into stage (id, name, final_stage, status) values (2, 'Verificação Documental', 0, 1);
insert into stage (id, name, final_stage, status) values (3, 'Certidão Negativa', 0, 1);
insert into stage (id, name, final_stage, status) values (4, 'Reconhecimento do Campo', 0, 1);
insert into stage (id, name, final_stage, status) values (5, 'Parecer Despacho', 0, 1);
insert into stage (id, name, final_stage, status) values (6, 'Parecer Chefe Serviço', 0, 1);
insert into stage (id, name, final_stage, status) values (7, 'Parecer/Aprovação Director Provincial', 0, 1);
insert into stage (id, name, final_stage, status) values (8, 'Parecer/Aprovação Governador', 0, 1);
insert into stage (id, name, final_stage, status) values (9, 'Parecer/Aprovação Ministro', 0, 1);
insert into stage (id, name, final_stage, status) values (10, 'Aprovação Conselho de Ministro', 0, 1);
insert into stage (id, name, final_stage, status) values (11, 'Termo de Adesão', 0, 1);
insert into stage (id, name, final_stage, status) values (12, 'Despacho Final', 0, 1);
insert into stage (id, name, final_stage, status) values (13, 'Publicação no BR', 0, 1);
insert into stage (id, name, final_stage, status) values (14, 'Vistoria Instalações', 0, 1);
insert into stage (id, name, final_stage, status) values (15, 'Pagamento', 0, 1);
insert into stage (id, name, final_stage, status) values (16, 'Autorizado', 1, 1);

insert into specie (id, scientific_name, commercial_name, local_name, minimum_diameter, measurement_unit, classification, status) 
values (1, 'Berchemia Zeyheri', 		'Pau-rosa', 	'Mulatchine, Sungagoma',	'30', 'CUBIC_METERS', 'PRECIOUS', 1);
insert into specie (id, scientific_name, commercial_name, local_name, minimum_diameter, measurement_unit, classification, status)
values (2, 'Dalbergia melanoxylon',		'Pau-preto', 	'Mpinge,Mpivi, Nmico',		'20', 'CUBIC_METERS', 'PRECIOUS', 1);
insert into specie (id, scientific_name, commercial_name, local_name, minimum_diameter, measurement_unit, classification, status)
values (3, 'Diospyros kirkii', 			'',				'Mucula-cula, Muoma',		'40', 'CUBIC_METERS', 'PRECIOUS', 1);
insert into specie (id, scientific_name, commercial_name, local_name, minimum_diameter, measurement_unit, classification, status)
values (4, 'Dyospiros mespilifornzis', 	'Ebano',		'Mfuma, Ntoma',				'50', 'CUBIC_METERS', 'PRECIOUS', 1);
insert into specie (id, scientific_name, commercial_name, local_name, minimum_diameter, measurement_unit, classification, status)
values (5, 'Ekebergia capensis', 		'Inhamarre',	'Inhamarre',				'50', 'CUBIC_METERS', 'PRECIOUS', 1);
insert into specie (id, scientific_name, commercial_name, local_name, minimum_diameter, measurement_unit, classification, status)
values (6, 'Entandophragma caudatum', 	'Mbuti',		'Bubuti, Mubuti', 			'50', 'CUBIC_METERS', 'PRECIOUS', 1);
insert into specie (id, scientific_name, commercial_name, local_name, minimum_diameter, measurement_unit, classification, status)
values (7, 'Guibourtia conjugata', 		'Chacate preto','Chacate',					'40', 'CUBIC_METERS', 'PRECIOUS', 1);
insert into specie (id, scientific_name, commercial_name, local_name, minimum_diameter, measurement_unit, classification, status)
values (8, 'Milicia excelsa', 			'Tule',			'Megunda, Mecuco, Mahundo',	'50', 'CUBIC_METERS', 'PRECIOUS', 1);
insert into specie (id, scientific_name, commercial_name, local_name, minimum_diameter, measurement_unit, classification, status)
values (9, 'Spirostachys africana', 	'Sândalo',		'Chilingamache, Mucunite',	'30', 'CUBIC_METERS', 'PRECIOUS', 1);
insert into specie (id, scientific_name, commercial_name, local_name, minimum_diameter, measurement_unit, classification, status)
values (101, 'Afielia quanzensis', 	'Chanfuta',		'Mussacossa, Mugengema, Muoco',	'50', 'CUBIC_METERS', 'CLASS1', 1);
insert into specie (id, scientific_name, commercial_name, local_name, minimum_diameter, measurement_unit, classification, status)
values (102, 'Androstachys johnsonii', 	'Mecrusse',		'Cimbirre',	'30', 'CUBIC_METERS', 'CLASS1', 1);
insert into specie (id, scientific_name, commercial_name, local_name, minimum_diameter, measurement_unit, classification, status)
values (103, 'Combretum imberbe', 	'Mondzo',		'Munagari, Mungari, Ehupu',	'40', 'CUBIC_METERS', 'CLASS1', 1);
insert into specie (id, scientific_name, commercial_name, local_name, minimum_diameter, measurement_unit, classification, status)
values (104, 'Millettia stuhlmannii', 	'Jambire',		'Panga-panga, Panguire',	'40', 'CUBIC_METERS', 'CLASS1', 1);
insert into specie (id, scientific_name, commercial_name, local_name, minimum_diameter, measurement_unit, classification, status)
values (105, 'Pterocarpus angolensis', 	'Umbila',		'Mbila, Mucurambira',	'40', 'CUBIC_METERS', 'CLASS1', 1);
insert into specie (id, scientific_name, commercial_name, local_name, minimum_diameter, measurement_unit, classification, status)
values (106, 'Swartzia madagascariensis', 	'Pau ferro',		'Nhaquata, Pau-rosa, Cimbe',	'30', 'CUBIC_METERS', 'CLASS1', 1);
insert into specie (id, scientific_name, commercial_name, local_name, minimum_diameter, measurement_unit, classification, status)
values (201, 'Albizia adianthifolia', 	'Mepepe',		'Goana, Megerenge',	'40', 'CUBIC_METERS', 'CLASS2', 1);
insert into specie (id, scientific_name, commercial_name, local_name, minimum_diameter, measurement_unit, classification, status)
values (301, 'Acacia nigrescens', 	'Namuno',		'Mecungo, Micaia',	'40', 'CUBIC_METERS', 'CLASS3', 1);
insert into specie (id, scientific_name, commercial_name, local_name, minimum_diameter, measurement_unit, classification, status)
values (401, 'Acacia albida', 	'',		'Micaia, Dzungua, Sango',	'40', 'CUBIC_METERS', 'CLASS4', 1);

insert into request(id,process_number,area,year,regime,purpose,duration_year,status,operator_id,locality_id,contract_id,product_type_id,last_stage_id)
values (1, '2017.S01.100', 10000, 2017, 'SIMPLE_LICENSE', 'PROCESSING_INDUSTRY_SUPPLY', 5, 1, 1, 1, null, null, null);
insert into request(id,process_number,area,year,regime,purpose,duration_year,status,operator_id,locality_id,contract_id,product_type_id,last_stage_id)
values (2, '2018.C01.100', 50000, 2018, 'CONCESSION', 'PROCESSING_INDUSTRY_SUPPLY', 50, 1, 1, 5, null, null, null);
insert into request(id,process_number,area,year,regime,purpose,duration_year,status,operator_id,locality_id,contract_id,product_type_id,last_stage_id)
values (3, '2018.C02.101', 50000, 2018, 'CONCESSION', 'PROCESSING_INDUSTRY_SUPPLY', 50, 1, 1, 7, null, null, null);
insert into request(id,process_number,area,year,regime,purpose,duration_year,status,operator_id,locality_id,contract_id,product_type_id,last_stage_id)
values (4, '2018.C03.102', 50000, 2018, 'CONCESSION', 'PROCESSING_INDUSTRY_SUPPLY', 50, 1, 2, 7, null, null, null);
insert into request(id,process_number,area,year,regime,purpose,duration_year,status,operator_id,locality_id,contract_id,product_type_id,last_stage_id)
values (5, '2018.S01.101', 10000, 2018, 'SIMPLE_LICENSE', 'PROCESSING_INDUSTRY_SUPPLY', 5, 1, 3, 7, null, null, null);

insert into request_stage(id,description,effective_date,status,stage_id,request_id) values (1, 'autorização automática', sysdate(), 1, 16, 1);
insert into request_stage(id,description,effective_date,status,stage_id,request_id) values (2, 'autorização automática', sysdate(), 1, 16, 2);
insert into request_stage(id,description,effective_date,status,stage_id,request_id) values (3, 'autorização automática', sysdate(), 1, 16, 3);
insert into request_stage(id,description,effective_date,status,stage_id,request_id) values (4, 'autorização automática', sysdate(), 1, 16, 4);
insert into request_stage(id,description,effective_date,status,stage_id,request_id) values (5, 'autorização automática', sysdate(), 1, 16, 5);
	
update request set last_stage_id = 1 where id = 1;
update request set last_stage_id = 2 where id = 2;
update request set last_stage_id = 3 where id = 3;
update request set last_stage_id = 4 where id = 4;
update request set last_stage_id = 5 where id = 5;

insert into license(id, license_number, year, description, status, request_id, operator_id) values (1, '20170001', 2017, 'auto', 1, 1, 1);
insert into license(id, license_number, year, description, status, request_id, operator_id) values (2, '20180001', 2018, 'auto', 1, 3, 1);
	
insert into product(id, requested_quantity, authorized_quantity, status, license_id, specie_id) values (1, 500, 300, 1, 1, 1);
insert into product(id, requested_quantity, authorized_quantity, status, license_id, specie_id) values (2, 500, 300, 1, 1, 2);
insert into product(id, requested_quantity, authorized_quantity, status, license_id, specie_id) values (3, 1000, 500, 2, 1, 1);
insert into product(id, requested_quantity, authorized_quantity, status, license_id, specie_id) values (4, 500, 200, 2, 2, 2);
insert into product(id, requested_quantity, authorized_quantity, status, license_id, specie_id) values (5, 500, 300, 1, 2, 2);