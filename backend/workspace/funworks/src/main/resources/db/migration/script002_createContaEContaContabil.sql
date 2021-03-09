CREATE TABLE tipo_conta (
	id SERIAL PRIMARY KEY,
	descricao VARCHAR(200) NOT NULL,
	tipo char(1) NOT NULL
);

CREATE TABLE conta_contabil (
 id SERIAL PRIMARY KEY,
 descricao VARCHAR(200) NOT NULL,
 id_tipo_conta INT NOT NULL,
 CONSTRAINT fk_tipo_conta_id
 FOREIGN KEY (id_tipo_conta)
 REFERENCES tipo_conta(id)
);

CREATE TABLE conta (
	id SERIAL PRIMARY KEY,
	descricao VARCHAR(200) NOT NULL,
	id_conta_contabil INT NOT NULL,
	CONSTRAINT fk_conta_contabil_id
	FOREIGN KEY (id_conta_contabil)
	REFERENCES conta_contabil(id)
);