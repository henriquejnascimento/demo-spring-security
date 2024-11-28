INSERT INTO role (role_id, name) VALUES (1, 'ADMIN');
INSERT INTO role (role_id, name) VALUES (2, 'BASIC');

INSERT INTO "user" (user_id, username, "password")
VALUES ('a12a8476-952b-4735-bd49-bddac6b8a921'::uuid, 'admin', '$2a$10$VKM0jUOv2669A06BNzxbSe2huLUBDAlOey41WZkiC0K1QVuU6jt3G'); -- password = demo

INSERT INTO user_role (user_id, role_id) VALUES('a12a8476-952b-4735-bd49-bddac6b8a921'::uuid, 1);
