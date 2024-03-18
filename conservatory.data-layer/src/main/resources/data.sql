insert into PERSON(NAME, PERSON_ID, ACTIVE, EMAIL, ADDRESS, OCCUPATION, IMAGE, DOB, PHONE1, PHONE2)
values
('Gabriela Sanchez', 456, true, 'gabskatze@gmail.com', '2110 Sutton Ridge Ave', 'Software Engineer', 'image', '2019-01-10', 323, 1),
('Leonardo Jimenez', 123, true, 'ljimenez@gmail.com', 'Heredia Centro', 'Estudiante', 'image', '2010-01-10', 323, 1),
('Natalia Lopez', 675, true, 'nlopez@gmail.com', 'La Trinidad, Alajuela', 'Estudiante', 'image', '2001-04-11', 323, 1),
('Ricardo Zepeda', 980, true, 'rzepeda@gmail.com', 'El Coyol, Alajuela', 'Administrador Empresas', 'image', '1987-09-09', 323, 1),
('Dana Arias', 777, true, 'darias@gmail.com', 'La Aurora, Heredia', 'Periodista', 'image', '2013-01-10', 323, 1),
('Ana Scott', 599, true, 'ascott@gmail.com', 'La Guacima, Alajuela', 'Doctora', 'image', '1985-04-11', 4567, 1),
('Solopin Garcia', 342, true, 'dlopez@gmail.com', 'El Coyol, Alajuela', 'Administrador Empresas', 'image', '1981-09-10', 323, 1),
('Juan Carlos Rudin', 599, true, 'juancrud@gmail.com', 'Ulloa, Heredia', 'Ingeniero', 'image', '1985-04-11', 4567, 1),
('Ximun Alberto', 3142, true, 'elbergomeztorba@gmail.com', 'Centro, Alajuela', 'Administrador Empresas', 'image', '1981-09-10', 323, 1);

insert into STUDENT(EDUCATIONAL_LEVEL, TYPE, PERSON_ID)
values
('bachellor', 'regular', 1),
('high school', 'becado', 2),
('bachellor', 'regular', 3),
('bachellor', 'regular', 4),
('bachellor', 'regular', 5);

insert into PROFESSOR(PERSON_ID)
values
(4),
(5),
(6),
(7);

insert into COMMISSIONED(PERSON_ID)
VALUES
(4),
(7),
(8),
(9);