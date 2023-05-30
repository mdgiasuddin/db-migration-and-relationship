create table if not exists university (
    id uuid,
    name varchar(255) not null,
    constraint pk_university primary key(id)
);