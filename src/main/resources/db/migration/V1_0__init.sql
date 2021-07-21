create table reminder (
    id serial not null primary key,
    name varchar,
    note varchar,
    date date,
    status varchar
);
