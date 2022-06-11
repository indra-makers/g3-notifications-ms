create table public.tbl_user_notifications_data(
    id_user serial primary key,
    "mail" varchar(255) NOT NULL,
    "phone_number" varchar(255) NOT NULL
);

create table public.tbl_notifications (
    id_notifications serial primary key,
    "type" varchar(255) NOT NULL,
    "message" varchar(255) NOT NULL,
    "sent_at" timestamp NOT NULL DEFAULT now(),
    sent_to varchar(255) NOT NULL,
    id_user int NOT NULL,
    CONSTRAINT fk_tbl_notifications FOREIGN KEY (id_user) REFERENCES tbl_user_notifications_data(id_user)
);