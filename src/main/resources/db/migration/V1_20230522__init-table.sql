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

create table if not exists student (
    id bigserial,
    roll_number int not null,
    id_key uuid default gen_random_uuid(),
    name varchar(255) not null,
    constraint pk_student primary key(id)
);

create table if not exists course_registration (
    student_id bigint,
    course_id bigint,
    constraint fk_course_registration_student foreign key(student_id) references student,
    constraint fk_course_registration_course foreign key(course_id) references course,
    constraint pk_course_registration primary key(student_id, course_id)
);

create table if not exists university (
    id uuid,
    name varchar(255) not null,
    constraint pk_university primary key(id)
);