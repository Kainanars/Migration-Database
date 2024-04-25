CREATE TABLE "user" (
                        id SERIAL PRIMARY KEY,
                        name VARCHAR(255) NOT NULL,
                        password VARCHAR(255) NOT NULL
);

INSERT INTO "user" (id, name, password) VALUES (1, 'Alice', 'password1');
INSERT INTO "user" (id, name, password) VALUES (2, 'Bob', 'password2');
INSERT INTO "user" (id, name, password) VALUES (3, 'Charlie', 'password3');
INSERT INTO "user" (id, name, password) VALUES (4, 'David', 'password4');
INSERT INTO "user" (id, name, password) VALUES (5, 'Eve', 'password5');
INSERT INTO "user" (id, name, password) VALUES (6, 'Frank', 'password6');
INSERT INTO "user" (id, name, password) VALUES (7, 'Grace', 'password7');
INSERT INTO "user" (id, name, password) VALUES (8, 'Hannah', 'password8');
INSERT INTO "user" (id, name, password) VALUES (9, 'Ivy', 'password9');
INSERT INTO "user" (id, name, password) VALUES (10, 'Jack', 'password10');