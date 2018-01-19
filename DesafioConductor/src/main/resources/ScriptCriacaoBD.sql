/**
 * Script de criação do BD e tabelas.
 */

/**
 * Author:  rodst
 * Created: 19/01/2018
 */


-- DROP DATABASE "dbClientes";

CREATE DATABASE "dbClientes"
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'Portuguese_Brazil.1252'
       LC_CTYPE = 'Portuguese_Brazil.1252'
       CONNECTION LIMIT = -1;

-- Table: tbcliente

-- DROP TABLE tbcliente;

CREATE TABLE tbcliente
(
  id serial NOT NULL,
  nome character varying(200),
  cpf character varying(20),
  email character varying(200),
  telefone character varying(20),
  CONSTRAINT pkidcliente PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE tbcliente
  OWNER TO postgres;
