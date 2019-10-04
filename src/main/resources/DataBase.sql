create  table project.user(
    id int not null auto_increment primary key ,
    name varchar(20) not null ,
    surname varchar(20) not null,
    email varchar(64) not null  unique ,
    gender varchar(10) not null ,
    password varchar(50) not null
)

create  table project.contacts(
    id int not null  primary key ,
    country varchar(20) ,
    town varchar(20) ,
    phone varchar(20)
)

create  table project.interests(
    id int not null  primary key ,
    books varchar(255) ,
    films varchar(255) ,
    musics varchar(255) ,
    sports varchar(255)
)
