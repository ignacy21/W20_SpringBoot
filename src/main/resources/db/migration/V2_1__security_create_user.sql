insert into zajavka_user (user_id, user_name, email, password, name, active)
values(1, 'admin', 'admin@zajavka.pl', '$2a$12$81/Z/.p4zExfxC6Hq/3CZOIAZxnB5yngL5U.RxxJuv/KkAAujcUqS', 'Admin', true);

insert into zajavka_user (user_id, user_name, email, password, name, active)
values(2, 'user1', 'user1@zajavka.pl', '$2a$12$IioEipP1RsovX8P3qihTtuoz5UdApD1Q6tJOo9cp7ZaWoOkPa9ijm', 'Admin1', true);

insert into zajavka_role (role_id, role) values (1, 'ADMIN'), (2 'USER');

insert into zajavka_user_role (user_id, role_id) values (1, 1), (1, 2);
insert into zajavka_user_role (user_id, role_id) values (2, 2);
