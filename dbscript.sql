create table users (
  id int primary key auto_increment,
  name varchar(50) not null,
  email varchar(255) not null unique,
  password varchar(255) not null,
  created_at datetime
);

create table contacts(
    id int primary key auto_increment,
    firstname varchar(50) not null,
    lastname varchar(50),
    email varchar(255) not null unique,
    phone varchar(100) not null unique,
    avatar varchar(255),
    address varchar(255),
    city varchar(100),
    pincode varchar(10),
    state varchar(50),
    country varchar(50),
    created_at datetime,
);