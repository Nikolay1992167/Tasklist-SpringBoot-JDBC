insert into users (name, username, password)
values ('Alex Morozov', 'alexmorozov@gmail.com', '$2a$10$hRX.GjIRujOUFTC8rqsRYuKvwD5KqiM1NFwr1CGaO1Zq4ym.ho.Wi'),
       ('Denis Tarik', 'denistarik@gmail.com', '$2a$10$hRX.GjIRujOUFTC8rqsRYuKvwD5KqiM1NFwr1CGaO1Zq4ym.ho.Wi');

insert into tasks (title, description, status, expiration_date)
values ('Buy cheese', null, 'TODO', '2023-07-30 12:00:00'),
       ('Do homework', 'Math, Golang', 'IN_PROGRESS', '2023-07-28 00:00:00'),
       ('Clean rooms', null, 'DONE', null),
       ('Call Mike', 'Ask about meeting', 'TODO', '2023-08-15 00:00:00');

insert into users_tasks (task_id, user_id)
values (1, 2),
       (2, 2),
       (3, 2),
       (4, 1);

insert into users_roles (user_id, role )
values (1, 'ROLE_ADMIN'),
       (1, 'ROLE_USER'),
       (2, 'ROLE_USER');