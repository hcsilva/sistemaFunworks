CREATE TABLE usuarios (
 id SERIAL PRIMARY KEY,
 usuario VARCHAR(50) UNIQUE NOT NULL,
 senha VARCHAR(50) NOT NULL,
 data_criacao TIMESTAMP NOT NULL
);