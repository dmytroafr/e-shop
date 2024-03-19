create table products (
                          id BIGSERIAL PRIMARY KEY ,
                          title text NOT NULL ,
                          description text,
                          image_link text,
                          brand text);

create sequence products_seq;

insert into products (title, description, image_link, brand) select title, description, image_link, brand from product;

drop sequence if exists products_seq;
create sequence products_seq start with 222;
select nextval('products_seq');

insert into users (created, id, email, first_name, last_name, password, role) values
    (CURRENT_TIMESTAMP, nextval('users_seq'),'admin@gmail.com', 'admin', 'admin', '','ADMIN');

update users set password='$2a$12$zw/VGyxSyaqk1QxXImcEte.rh30n0DY6t9GOQfNLh8fRWqdgxA7eK' where role='ADMIN';

drop sequence if exists users_seq;
create sequence users_seq start with 1;
select nextval('products_seq');