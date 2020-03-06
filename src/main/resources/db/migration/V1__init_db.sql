create sequence hibernate_sequence start 1 increment 1;
create table news
(
    id           serial not null,
    created_at   timestamp,
    updated_at   timestamp,
    author       varchar(100),
    bad          SMALLINT default '0'::SMALLINT,
    category_ids integer[],
    comments_off SMALLINT default '0'::SMALLINT,
    date         timestamp,
    description  text,
    image        varchar(100),
    image_source varchar(200),
    isnot        SMALLINT default '0'::SMALLINT,
    name         varchar(500),
    own          SMALLINT default '0'::SMALLINT,
    person_ids   integer[],
    tag_ids      integer[],
    text         text,
    top          SMALLINT default '0'::SMALLINT,
    url          varchar(500),
    primary key (id)
);
create table persons
(
    id                 serial not null,
    created_at         timestamp,
    updated_at         timestamp,
    birthday           date,
    deathday           date,
    facebook           int2,
    info               text,
    info_short         text,
    instagram          int2,
    name               varchar(200),
    name_fenitive      varchar(200),
    name_nominative    varchar(200),
    name_original      varchar(200),
    name_prepositional varchar(200),
    photo              varchar(50),
    photo_source       varchar(200),
    sex                SMALLINT,
    singer             SMALLINT,
    twitter            int2,
    vk                 int2,
    primary key (id)
);
create table roles
(
    id         serial not null,
    created_at timestamp,
    updated_at timestamp,
    name       varchar(255),
    primary key (id)
);
create table users
(
    id          serial not null,
    created_at  timestamp,
    updated_at  timestamp,
    active      SMALLINT,
    activist    SMALLINT,
    avatar      varchar(100),
    banned_date date,
    birthdate   date,
    city        varchar(100),
    city_id     int4   not null,
    country     varchar(100),
    country_id  int4   not null,
    credo       text,
    family      varchar(100),
    name        varchar(100),
    nick        varchar(100),
    password    varchar(255),
    sex         SMALLINT,
    show_db     SMALLINT default '0'::SMALLINT,
    username    varchar(255),
    primary key (id)
);
create table users_roles
(
    users_id serial not null,
    roles_id serial not null,
    primary key (users_id, roles_id)
);
create index news_k_name on news (name);
create index news_k_id_url on news (id, url);
create index persons_k_name on persons (name);
create index users_k_nick on users (nick);
alter table if exists users_roles
    add constraint FKa62j07k5mhgifpp955h37ponj foreign key (roles_id) references roles;
alter table if exists users_roles
    add constraint FKml90kef4w2jy7oxyqv742tsfc foreign key (users_id) references users;