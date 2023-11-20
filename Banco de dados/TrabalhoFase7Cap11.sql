-- Criando tabelas

CREATE TABLE TGF_USUARIO(
    cod_usuario NUMBER(10) NOT NULL,
    usu_nome VARCHAR2(32) NOT NULL,
    usu_senha NUMBER (10) NOT NULL,
    usu_email VARCHAR2 (25) NOT NULL,
    nr_cpfcnpj NUMBER (16) NOT NULL,
    dt_nascimento DATE,
    usu_pais VARCHAR2(20),
    CONSTRAINT PK_TGF_USUARIO PRIMARY KEY (cod_usuario)
);

ALTER TABLE TGF_USUARIO
MODIFY usu_senha VARCHAR2(20);

CREATE TABLE TGF_INVESTIMENTO(
    cod_investimento NUMBER (10) NOT NULL,
    cod_usuario NUMBER(10) NOT NULL,
    des_investimento VARCHAR2(32) NOT NULL,
    val_investimento NUMBER (10) NOT NULL,
    nom_instituicao VARCHAR2 (25) NOT NULL,
    nom_tipo VARCHAR2(32) NOT NULL,
    dt_inicio DATE,
    dt_conclusao DATE,
    CONSTRAINT PK_TGF_INVESTIMENTO PRIMARY KEY (cod_investimento)
);

ALTER TABLE TGF_INVESTIMENTO
MODIFY val_investimento NUMBER (10, 2);
    
ALTER TABLE TGF_INVESTIMENTO
    ADD CONSTRAINT FK_COD_USUARIO_TGF_INVESTIMENTO FOREIGN KEY (cod_usuario)
    REFERENCES TGF_USUARIO (cod_usuario);
 
CREATE TABLE TGF_OBJETIVO(
    cod_investimento NUMBER (10) NOT NULL,
    cod_usuario NUMBER(10) NOT NULL,
    des_objetivo VARCHAR2(32) NOT NULL,
    val_objetivo NUMBER (10) NOT NULL,
    dt_inicio DATE,
    dt_conclusao DATE,
    CONSTRAINT PK_TGF_OBJETIVO PRIMARY KEY (cod_objetivo),
    CONSTRAINT FK_COD_USUARIO_TGF_OBJETIVO FOREIGN KEY (cod_usuario)
        REFERENCES TGF_USUARIO(cod_usuario)
);

ALTER TABLE TGF_OBJETIVO
RENAME COLUMN cod_investimento TO cod_objetivo;

ALTER TABLE TGF_OBJETIVO
MODIFY val_objetivo NUMBER (10, 2);

ALTER TABLE TGF_OBJETIVO
DROP PRIMARY KEY

ALTER TABLE TGF_OBJETIVO
ADD CONSTRAINT PK_TGF_OBJETIVO PRIMARY KEY (cod_objetivo);

ALTER TABLE TGF_OBJETIVO
DROP CONSTRAINT FK_COD_USUARIO_TGF_OBJETIVO;

ALTER TABLE TGF_OBJETIVO
ADD CONSTRAINT FK_COD_USUARIO_TGF_OBJETIVO FOREIGN KEY (cod_usuario) REFERENCES TGF_USUARIO(cod_usuario);

CREATE TABLE TGF_RECEITA(
    cod_receita NUMBER (10) NOT NULL,
    cod_usuario NUMBER(10) NOT NULL,
    des_receita VARCHAR2(32) NOT NULL,
    val_receita NUMBER (10) NOT NULL,
    dt_entrada DATE,
    CONSTRAINT PK_TGF_RECEITA PRIMARY KEY (cod_receita),
    CONSTRAINT FK_COD_USUARIO_TGF_RECEITA FOREIGN KEY (cod_usuario)
        REFERENCES TGF_USUARIO(cod_usuario)
);

CREATE TABLE TGF_DESPESA(
    cod_despesa NUMBER (10) NOT NULL,
    cod_usuario NUMBER(10) NOT NULL,
    des_despesa VARCHAR2(32) NOT NULL,
    val_despesa NUMBER (10) NOT NULL,
    dt_saida DATE,
    CONSTRAINT PK_TGF_DESPESA PRIMARY KEY (cod_despesa),
    CONSTRAINT FK_COD_USUARIO_TGF_DESPESA FOREIGN KEY (cod_despesa)
        REFERENCES TGF_USUARIO(cod_usuario)
);

ALTER TABLE TGF_DESPESA
DROP CONSTRAINT FK_COD_USUARIO_TGF_DESPESA;

ALTER TABLE TGF_DESPESA
ADD CONSTRAINT FK_COD_USUARIO_TGF_DESPESA FOREIGN KEY (cod_usuario) REFERENCES TGF_USUARIO(cod_usuario);

commit;

-- MUITA ATENÇÃO! ANTES DE RODAR FintechApp.java NÃO ESQUEÇA DE RESETAR A SQ_USUARIO_TGF
-- resetar significa ir em Sequências/SQ_USUARIO_TGF e colocar no campo "Começar com" o valor 1
-- é importante para na hora de cadastrar as demais tabela a chave primária cod_usuario deve ficar 1
-- cod_usuario é a chave primario na tabela TGF_USUARIO e é chave estrangeira nas demais
select * from tgf_usuario order by cod_usuario
DELETE FROM TGF_USUARIO
WHERE cod_usuario >= 1;

select * from tgf_investimento order by cod_investimento
DELETE FROM TGF_INVESTIMENTO
WHERE cod_investimento >= 1;

select * from tgf_objetivo order by cod_objetivo
DELETE FROM TGF_OBJETIVO
WHERE cod_objetivo >= 1;

select * from tgf_receita order by cod_receita
DELETE FROM TGF_RECEITA
WHERE cod_receita >= 1;

select * from tgf_despesa order by cod_despesa
DELETE FROM TGF_DESPESA
WHERE cod_despesa >= 1;