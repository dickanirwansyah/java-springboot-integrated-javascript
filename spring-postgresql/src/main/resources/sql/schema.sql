create table category(
    id varchar(255) not null unique,
    name varchar(255) not null,
    disabled boolean not null,

    constraint pk_category_id PRIMARY KEY (id)
);

create table book(
    idbuku varchar(255) not null unique,
    title varchar(255) not null,
    author varchar(255) not null,
    quantity int not null,
    idcategory varchar(255) not null,
    price int not null,
    disabled boolean not null,

    constraint pk_book_id PRIMARY KEY (id),
    constraint fk_book_id FOREIGN KEY (categoryId)
    REFERENCES category(id)
);


insert into book(idbuku, title, author, quantity, idcategory, price, disabled)
values ('b001', 'buku algoritma', 'dickanirwansyah', 19, 'c0001', 19000, true);