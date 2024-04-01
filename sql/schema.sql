//запросы для создания схемы данных по проекту
create table category
(
    id serial8,
    category_name varchar(20),
    primary key (id)
);

drop table if exists category;
create table description
( id serial8,
  d_name varchar(40) not null,
  primary key (id),
  category_id int8,
  foreign key (category_id) references category(id)
);

create table product (
                         id serial8,
                         p_name varchar(20) not null ,
                         price int4 not null,
                         primary key (id),
                         category_id int8,
                         foreign key (category_id) references category(id)
);


create table value  (
                        id serial8,
                        value_name varchar(20),
                        primary key (id),
                        description_id int8,
                        product_id int8,
                        foreign key (description_id) references description(id),
                        foreign key (product_id) references product(id)

);

insert into category (category_name)
values ('Процессоры'), ('Мониторы');

insert into description ( d_name, category_id)
values ('Производитель процессора',1),
       ('Производитель монитора',2),
       ('Количество ядер',1),
       ('Сокет',1),
       ('Диагональ',2),
       ('Матрица',2),
       ('Разрешение',2);

insert into product ( p_name, price, category_id)
values ('Intel Core I9 9900',2000, 1),
       ('AMD Ryzen R7 7700',1800,1),
       ('Samsung SU556270', 1000,2),
       ('AOC Z215S659', 800,2);

insert into value (value_name, description_id, product_id)
VALUES ('Intel ', 1, 1), ('AMD',1, 2),
       ('Samsung  ',2,2),('AOC', 2,4),
       ('8',3, 1),( '12', 3, 2),
       ('1250',4, 1),('AM4',4, 2),
       ('27', 5,3), ('21.5',5,4),
       ('TN',6,3), ('AH-IPS',6,4),
       ('2560*1440 ', 7,3), ('1920*1080',7,4);