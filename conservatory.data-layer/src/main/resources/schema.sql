create table mytest
(
	id varchar(255)
);

create table person
(
	id int not null,
	name varchar(255) not null,
	personId bigint,
	active boolean,
	email varchar(255),
	address varchar(400),
	occupation varchar(50),
	image varchar(255),
	dateOfBirth date,
	phone1 bigint,
	phone2 bigint,
	primary key (id)
);

insert into mytest(id)
values
('prueba');
insert into person(id, name, active, email, address, occupation, image, phone1, phone2)
values
(1, 'Gabriela Sanchez', true, 'gabskatze@gmail', '2110 Sutton Ridge Ave', 'Software Engineer', 'image', 323, 1);

