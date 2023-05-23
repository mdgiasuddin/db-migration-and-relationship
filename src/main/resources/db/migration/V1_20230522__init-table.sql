create table if not exists department (
    id bigserial,
    name varchar(255) unique not null,
    constraint pk_department primary key(id)
);

create table if not exists instructor (
    id bigserial,
    name varchar(255) not null,
    constraint pk_instructor primary key(id)

);

create table if not exists course (
    id bigserial,
    name varchar(255) not null,
    department_id bigint,
    instructor_id bigint,
    constraint pk_course primary key(id),
    constraint fk_course_department foreign key(department_id) references department,
    constraint fk_course_instructor foreign key(instructor_id) references instructor
);