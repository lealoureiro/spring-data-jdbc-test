create table customer
(
    id   varchar(36)  not null,
    name varchar(255) not null,
    primary key (id)
);

create table note
(
    id          varchar(36)   not null,
    text        varchar(1024) not null,
    customer_id varchar(36)   not null,
    primary key (id),
    foreign key (customer_id) references customer (id)
);