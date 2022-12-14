create schema if not exists train;

create table if not exists train.customers
(
    id           uuid primary key default gen_random_uuid(),
    firstname         varchar(50) not null,
    lastname      varchar(50) not null,
    age          int check ( age > -1 ),
    registration_date         date         not null default now()
);

insert into train.customers (firstname, lastname, age)
values ('Alexey', 'Ivanov', '21');
insert into train.customers (firstname, lastname, age)
values ('Ivan', 'Alekseev', '34');

create table if not exists train.goods
(
    id           uuid primary key default gen_random_uuid(),
    product_name varchar(100) not null,
    quantity_in_one int check ( quantity_in_one > 0 ) not null,
    measure      varchar(100) not null,
    amount       int check ( amount > -1 ),
    currency     varchar(100) not null

);

insert into train.goods (product_name, quantity_in_one, measure, amount, currency)
values ('tea', 100, 'g', 99, 'RUB');
insert into train.goods (product_name, quantity_in_one, measure, amount, currency)
values ('bread', 1, 'piece', 40, 'RUB');
insert into train.goods (product_name, quantity_in_one, measure, amount, currency)
values ('honey', 100, 'ml', 150, 'RUB');
insert into train.goods (product_name, quantity_in_one, measure, amount, currency)
values ('beef', 1, 'kg', 500, 'RUB');
insert into train.goods (product_name, quantity_in_one, measure, amount, currency)
values ('eggs', 10, 'piece', 89, 'RUB');

create table if not exists train.customer_goods
(
    id           uuid primary key default gen_random_uuid(),
    customer_id  uuid references train.customers (id) not null,
    good_id      uuid references train.goods (id) not null,
    count       int check ( count > -1 )
);