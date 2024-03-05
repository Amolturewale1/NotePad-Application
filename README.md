use notedb;
create table user_info 
(
user_id int  auto_increment primary key,
user_name varchar(20) unique,
user_password varchar(10)
);


insert into user_info (user_name,user_password) values('amol','A@123');
insert into user_info (user_name,user_password) values('om','om123');
drop table user_info;
	create table note_info
	(	
		note_id int auto_increment  primary key,
		user_id int,
		title varchar(20),
		note Text,
		date_time varchar(30),
		foreign key (user_id) references user_info(user_id),
         UNIQUE (user_id, title)
	);
	
   

CREATE TABLE notes_table (
    note_id INT PRIMARY KEY,
    user_id INT,
    title VARCHAR(255),
    note TEXT,
    date_time varchar(20),
    FOREIGN KEY (user_id) REFERENCES user_info(user_id),
    UNIQUE (user_id, title)
);
