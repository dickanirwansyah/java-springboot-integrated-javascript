create table category(
idcategory varchar(255) not null,
name varchar(255) not null,
disabled varchar(255) not null,

CONSTRAINT pk_category_idcategory PRIMARY KEY (idcategory)
);

create table book(
idbuku varchar(255) not null,
author varchar(255) not null,
disabled boolean not null,
price int not null,
quantity int not null,
title varchar(255) not null,
idcategory varchar(255) not null,

CONSTRAINT pk_book_idbuku PRIMARY KEY (idbuku),
CONSTRAINT fk_book_idcategory FOREIGN KEY (idcategory)
REFERENCES category(idcategory)
);
