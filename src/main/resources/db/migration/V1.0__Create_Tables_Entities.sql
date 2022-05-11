create table public.tbl_notifications (
    user_id serial primary key,
    "type" varchar(255) NOT NULL,
    "message" varchar(255) NOT NULL,
    "sent_at" timestamp NOT NULL DEFAULT now()
);

create table public.tbl_user_notifications_data (
    user_id serial primary key,
    "mail" varchar(255) NOT NULL,
    "phone_number" varchar(255) NOT NULL

);