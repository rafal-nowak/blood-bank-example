create sequence provider_id_seq start with 1 increment by 1;

create table provider_entity
(
    created_by integer                     not null,
    id         integer                     not null,
    created_at timestamp(6) with time zone not null,
    email      varchar(255)                not null,
    name       varchar(255)                not null,
    primary key (id),
    constraint provider_email_unique unique (email)
);