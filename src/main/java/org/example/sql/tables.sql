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
    phone bigint,
    nationalcode bigint unique not null
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

insert into users values (default,'Hadiseh','MyUsername','MyEmail.@domain.com','MyPassword@123');
insert into users values (default,'Jamal','JamalUser','Jamal.@domain.com','JamalJamal@123');

insert into shareholder values (default,'Parsa',09121234567,11223344556);
insert into shareholder values (default,'Sara',09127654321,65544332211);

insert into brand values (default,'MyBrand','www.MyBrand.com','This is a new Brand');
insert into brand values (default,'MyBrand2','www.MyBrand2.com','This is a new Brand2');


insert into category values (default,'Cat1','This is a sample category');
insert into category values (default,'Cat2','This is a sample category');


insert into shareholder_brand values (default,1,1);
insert into shareholder_brand values (default,1,2);
insert into shareholder_brand values (default,2,2);


insert into product values(default,'Product1',2018,1,1);
insert into product values(default,'Product2',2020,2,2);

select * from users;
select * from shareholder;
select * from brand;
select * from category;
select * from shareholder_brand;
select * from product;

select * from brand inner join shareholder_brand sb on brand.id = sb.brandID where shareholderID = 1;

