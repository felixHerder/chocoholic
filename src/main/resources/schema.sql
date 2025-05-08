create table if not exists catalog
(
    uuid varchar(32) not null primary key,
    title varchar(256) not null,
    price decimal not null
);