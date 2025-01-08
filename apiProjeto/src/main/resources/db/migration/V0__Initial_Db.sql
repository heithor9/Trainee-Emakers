CREATE TABLE IF NOT EXISTS livro (
    id_livro SERIAL PRIMARY KEY, -- Chave primária
    nome VARCHAR(45) NOT NULL,      -- Nome do livro, obrigatório
    autor VARCHAR(45) NOT NULL,     -- Nome do autor, obrigatório
    data_publicacao DATE NOT NULL,  -- Data de publicação, obrigatório
    disponivel BOOLEAN NOT NULL     -- Indica se está disponível, obrigatório
);

CREATE TABLE IF NOT EXISTS pessoa (
    id_pessoa BIGSERIAL PRIMARY KEY, -- Chave primária
    nome VARCHAR(45) NOT NULL,       -- Nome da pessoa, obrigatório
    cep VARCHAR(9) NOT NULL          -- CEP da pessoa, obrigatório
);


CREATE TABLE IF NOT EXISTS emprestimo (
    id_emprestimo BIGSERIAL PRIMARY KEY,       -- Chave primária
    id_pessoa BIGINT NOT NULL,                 -- FK para pessoa
    id_livro BIGINT NOT NULL,                  -- FK para livro
    data_emprestimo DATE NOT NULL,             -- Data do empréstimo, obrigatório
    data_devolucao DATE,                       -- Data da devolução, opcional
    CONSTRAINT fk_pessoa FOREIGN KEY (id_pessoa) REFERENCES pessoa (id_pessoa) ON DELETE CASCADE,
    CONSTRAINT fk_livro FOREIGN KEY (id_livro) REFERENCES livro (id_livro) ON DELETE CASCADE
);
