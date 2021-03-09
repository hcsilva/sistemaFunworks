CREATE TABLE lancamentos (
	id SERIAL PRIMARY KEY,
	valor NUMERIC(14,2) NOT NULL,
	descricao VARCHAR(200) NOT NULL,
	id_conta INT NOT NULL,
	data_lancamento DATE NOT NULL,
	usuario_lancamento INT NOT NULL,
	CONSTRAINT fk_conta_id
	FOREIGN KEY (id_conta)
	REFERENCES conta(id),
	
	CONSTRAINT fk_usuario_id
	FOREIGN KEY (usuario_lancamento)
	REFERENCES usuarios(id)
);

