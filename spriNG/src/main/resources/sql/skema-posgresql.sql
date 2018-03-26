create table category(
    idcategory varchar(255) not null,
    name varchar(255) not null,

    constraint pk_category_idcategory PRIMARY KEY (idcategory)
);

create table phone(
    idphone varchar(255) not null,
    name varchar(255) not null,
    quantity int not null,
    description varchar(255) not null,
    price int not null,
    idcategory varchar(255) not null,

    constraint pk_phone_idphone PRIMARY KEY (idphone),
    constraint fk_phone_idcategory FOREIGN KEY (idcategory)
    REFERENCES category(idcategory)
);