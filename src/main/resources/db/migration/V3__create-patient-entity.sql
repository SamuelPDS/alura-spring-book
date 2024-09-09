create table patients (
    id bigint not null auto_increment,
    name varchar(100) not null,
    email varchar(100) not null unique,
    cpf varchar(11) not null unique,
    phone varchar(14) not null,
    street varchar(100) not null,
    neighborhood varchar(100) not null,
    cep varchar(9) not null,
    number varchar(20),
    city varchar(100) not null,

    primary key(id)
)