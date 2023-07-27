create table admin(
id INT AUTO_INCREMENT PRIMARY KEY,
user_name varchar(100) not null unique,
email varchar(100) not null unique,
password varchar(255) not null,
date_time datetime not null
);