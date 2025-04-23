CREATE DATABASE IF NOT EXISTS db_api_library;

USE db_api_library;

CREATE TABLE autor (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    biografia TEXT,
    data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE livro (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(200) NOT NULL,
    isbn VARCHAR(20) UNIQUE NOT NULL,
    ano_publicacao INT,
    qtd_exemplares INT NOT NULL DEFAULT 1,
    autor_id BIGINT NOT NULL,
    FOREIGN KEY (autor_id) REFERENCES autor(id)
);