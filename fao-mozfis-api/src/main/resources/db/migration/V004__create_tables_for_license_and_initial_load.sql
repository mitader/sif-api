-------------------------------------------------------------------------------------------------------------------------
-- Creating structure for OPERATOR
-------------------------------------------------------------------------------------------------------------------------
create table product_type(
	id bigint(20) primary key auto_increment,
	name varchar(200) not null,
	status integer(1) not null,
	constraint uq_product_type_name unique(name)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table product_subtype(
	id bigint(20) primary key auto_increment,
	name varchar(200) not null,
	status integer(1) not null,
	product_type_id bigint(20),
	constraint uq_product_subtype_name unique(name),
	foreign key (product_type_id) references product_type(id)
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
	status integer(1) not null,
	constraint uq_operator_nuit unique(nuit)
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
	foreign key (stage_id) references stage(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table request(
	id bigint(20) primary key auto_increment,
	name varchar(200) not null,
	area decimal(12,2) not null,
	year int(4) not null,
	regime varchar(20),
	purpose varchar(20),
	duration_year decimal(5,2),
	status integer(1) not null,
	operator_id bigint(20) not null,
	locality_id bigint(20) not null,
	contract_id bigint(20) not null,
	product_type_id bigint(20),
	last_stage_id bigint(20),
	foreign key (operator_id) references operators(id),
	foreign key (locality_id) references locality(id),
	foreign key (contract_id) references contract(id),
	foreign key (product_type_id) references product_subtype(id),
	foreign key (last_stage_id) references request_stage(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

alter table request_stage add constraint foreign key (request_id) references request(id);

create table license(
	id bigint(20) primary key auto_increment,
	number varchar(50) not null,
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
	requested_quantity decimal(6,2),
	authorized_quantity decimal(6,2) not null,
	status integer(1) not null,
	request_id bigint(20) not null,
	specie_id bigint(20) not null,
	foreign key (request_id) references request(id),
	foreign key (specie_id) references specie(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-------------------------------------------------------------------------------------------------------------------------
-- Inserting initial DATA
-------------------------------------------------------------------------------------------------------------------------
insert into operators (id, nuit, name, identification, email, phone, status) values (1, '023456789','John Doe', '023456789', 'johndoe@mail.com','+258023',1);
insert into operators (id, nuit, name, identification, email, phone, status) values (2, '123456789','Mary Doe', '123456789', 'marydoe@mail.com','+258123',1);

insert into product_type (id, name, status) values (1, 'Madeireiro',1);
insert into product_type (id, name, status) values (2, 'Não Madeireiro',1);
insert into product_type (id, name, status) values (3, 'Combustível Lenhoso',1);
insert into product_type (id, name, status) values (4, 'Materiais de Construção',1);

insert into product_subtype (product_type_id, name, status) values (1, 'Madeira em toro', 1);
insert into product_subtype (product_type_id, name, status) values (1, 'Madeira serrada', 1);
insert into product_subtype (product_type_id, name, status) values (1, 'Contraplacado', 1);
insert into product_subtype (product_type_id, name, status) values (1, 'Painéis', 1);
insert into product_subtype (product_type_id, name, status) values (1, 'Parquet', 1);
insert into product_subtype (product_type_id, name, status) values (2, 'Raízes', 1);
insert into product_subtype (product_type_id, name, status) values (2, 'Bordão', 1);
insert into product_subtype (product_type_id, name, status) values (2, 'Fibras Espontâneas', 1);
insert into product_subtype (product_type_id, name, status) values (2, 'Cascas Tonantes', 1);
insert into product_subtype (product_type_id, name, status) values (2, 'Produtos de substâncias alcalóides', 1);
insert into product_subtype (product_type_id, name, status) values (2, 'Cortiça', 1);
insert into product_subtype (product_type_id, name, status) values (2, 'Látex boraxífero', 1);
insert into product_subtype (product_type_id, name, status) values (2, 'Resinas', 1);
insert into product_subtype (product_type_id, name, status) values (2, 'Gomas', 1);
insert into product_subtype (product_type_id, name, status) values (2, 'Folhas', 1);
insert into product_subtype (product_type_id, name, status) values (2, 'Flores', 1);
insert into product_subtype (product_type_id, name, status) values (2, 'Cogumelos', 1);
insert into product_subtype (product_type_id, name, status) values (2, 'Mel', 1);
insert into product_subtype (product_type_id, name, status) values (2, 'Frutos', 1);
insert into product_subtype (product_type_id, name, status) values (2, 'Sementes silvestres', 1);
insert into product_subtype (product_type_id, name, status) values (3, 'Lenha', 1);
insert into product_subtype (product_type_id, name, status) values (3, 'Carvão Vegetal', 1);
insert into product_subtype (product_type_id, name, status) values (4, 'Varas', 1);
insert into product_subtype (product_type_id, name, status) values (4, 'Estacas', 1);
insert into product_subtype (product_type_id, name, status) values (4, 'Postes', 1);
insert into product_subtype (product_type_id, name, status) values (4, 'Esteios', 1);
insert into product_subtype (product_type_id, name, status) values (4, 'bambús', 1);
insert into product_subtype (product_type_id, name, status) values (4, 'Caniço', 1);
insert into product_subtype (product_type_id, name, status) values (4, 'Capim', 1);

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