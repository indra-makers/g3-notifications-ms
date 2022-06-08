create table tbl_notifications_user (
  	id_notification serial,
  	id_user int not null,
    mail varchar(255) NOT NULL,
    phone_number varchar(255) NOT NULL,
    PRIMARY KEY(id_notification, id_user)

);

create table tbl_user_notifications_data (
 	id_notifications_data serial primary key,
 	id_user int NOT NULL,
 	id_notification int not null,
    type varchar(255) NOT NULL,
    message varchar(255) NOT NULL,
    date_sent timestamp NOT NULL DEFAULT now(),
   FOREIGN KEY (id_user,id_notification) REFERENCES tbl_notifications_user(id_user,id_notification)
);