CREATE TABLE usuarios (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          nome VARCHAR(255) NOT NULL,
                          email VARCHAR(255) NOT NULL
);
INSERT INTO usuarios (nome, email) VALUES ('Alice', 'alice@example.com');
INSERT INTO usuarios (nome, email) VALUES ('Bob', 'bob@example.com');
INSERT INTO usuarios (nome, email) VALUES ('Charlie', 'charlie@example.com');