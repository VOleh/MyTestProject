create  table project.user(
    id int not null auto_increment primary key ,
    name varchar(20) not null ,
    surname varchar(20) not null,
    email varchar(64) not null  unique ,
    gender varchar(10) not null ,
    password varchar(50) not null,
    role varchar (10) not null
)

SET GLOBAL time_zone = '+3:00';

create  table project.contacts(
    id int not null  primary key ,
    country varchar(20) ,
    town varchar(20) ,
    phone varchar(20),
    FOREIGN KEY (id) REFERENCES user(id)
)


create  table project.interests(
    id int not null  primary key ,
    books varchar(500) ,
    films varchar(500) ,
    musics varchar(500) ,
    sports varchar(500),
    FOREIGN KEY (id) REFERENCES user(id)
)

create  table project.post(
     id int not null  primary key auto_increment ,
     comments varchar(1000) ,
     userId int not null,
     created datetime default CURRENT_TIMESTAMP,
     FOREIGN KEY (userId) REFERENCES user(id)
)

create  table project.photo(
     id int not null  primary key ,
     url varchar(50) ,
     postId int not null,
     FOREIGN KEY (postId) REFERENCES post(id)
)

