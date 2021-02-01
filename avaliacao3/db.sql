USE trabJDBC;

CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    senha VARCHAR(255) NOT NULL
);

CREATE TABLE produtos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    quantidade INT(4) NOT NULL,
    preco DECIMAL(4, 2) NOT NULL
);

INSERT INTO usuarios (nome, email, senha)
VALUES ("Adm", "adm@adm.com", "senha4");

INSERT INTO produtos (nome, quantidade, preco)
VALUES ("Produto Teste", 10, 1.99);