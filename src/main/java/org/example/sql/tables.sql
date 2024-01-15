create table if not exists users
(
    id serial unique primary key,
    name varchar(20) not null,
    username varchar(20) unique not null,
    email varchar(20) unique not null,
    password varchar(20) not null
);

create table if not exists shareholder
(
    id serial unique primary key,
    name varchar(20) not null,
    phone int,
    nationalcode int unique not null
);

create table if not exists brand
(
    id serial unique primary key,
    name varchar(20) unique not null,
    website varchar(20),
    description varchar(50)
);

create table if not exists category
(
    id serial unique primary key,
    name varchar(20) unique not null,
    description varchar(50)
);

create table if not exists product
(
    id serial unique primary key,
    name varchar(20) unique not null,
    createdate int,
    categoryID int references category(id),
    brandID int references brand(id)
);

create table if not exists shareholder_brand
(
    id serial unique primary key,
    shareholderID int references shareholder(id),
    brandID int references brand(id)
);



