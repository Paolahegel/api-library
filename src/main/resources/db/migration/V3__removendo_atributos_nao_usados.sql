START TRANSACTION;

ALTER TABLE autor DROP COLUMN data_criacao;

-- Remove colunas isbn e qtd_exemplares da tabela livro
ALTER TABLE livro DROP COLUMN isbn;
ALTER TABLE livro DROP COLUMN qtd_exemplares;

COMMIT;