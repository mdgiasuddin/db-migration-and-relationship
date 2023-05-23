create table if not exists student (
    id bigserial,
    roll_number int not null,
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