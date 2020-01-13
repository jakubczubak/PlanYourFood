insert into role (role) value ("ADMIN");
insert into role (role) value ("USER");

insert into day (name, sequence) value ("Poniedzialek", 1);
insert into day (name, sequence) value ("Wtorek", 2);
insert into day (name, sequence) value ("Sroda", 3);
insert into day (name, sequence) value ("Czwartek", 4);
insert into day (name, sequence) value ("Piatek", 5);
insert into day (name, sequence) value ("Sobota", 6);
insert into day (name, sequence) value ("Niedziela", 7);


INSERT INTO plan (`id`, `name`, `description`, `created`, `admin_id`) VALUES
(null, 'Plan Jarski', 'Opis planu 1', '2018-10-17 14:27:05', 1),
(null, 'Plan Mięsny', 'Opis planu 2', '2018-10-17 14:27:05', 1),
(null, 'Plan Śniadaniowy', 'Opis planu 3', '2018-10-17 14:27:05', 1),
(null, 'Plan Redukcja', 'Opis planu 4', '2018-10-17 14:27:05', 1),
(null, 'Plan Dużo białka', 'Opis planu 5', '2018-10-17 14:27:05', 1),
(null, 'Kapuściana dieta', 'Opis planu 6', '2018-10-17 14:27:05', 1)
;

