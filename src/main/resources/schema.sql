/*create table user
(
    id         bigint not null auto_increment,
    age        integer,
    first_name varchar(255),
    last_name  varchar(255),
    password   varchar(255),
    salary     bigint,
    username   varchar(255),
    primary key (id)
) engine = MyISAM;

*/

DROP TABLE IF EXISTS users;
CREATE TABLE users
(
    user_id  BIGINT PRIMARY KEY auto_increment,
    username VARCHAR(128) UNIQUE,
    password VARCHAR(256),
    enabled  BOOL
);