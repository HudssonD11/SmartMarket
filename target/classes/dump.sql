CREATE SCHEMA IF NOT EXISTS SM ;


CREATE TABLE IF NOT EXISTS SM.usuario (
  CPF CHAR(11) NOT NULL,
  nome VARCHAR(45) NOT NULL,
  login VARCHAR(45) NOT NULL,
  senha CHAR(68) NOT NULL,
  creditos SMALLINT ,
  email VARCHAR(45),
  tipo CHAR(1) NOT NULL);


CREATE TABLE IF NOT EXISTS SM.estabelecimento (
  id INT NOT NULL,
  nome VARCHAR(45) NOT NULL,
  estado CHAR(2) NOT NULL,
  cidade VARCHAR(45) NOT NULL,
  bairro VARCHAR(45) NOT NULL,
  rua VARCHAR(45) NOT NULL,
  numero SMALLINT NOT NULL,
  logo VARCHAR(500));


CREATE TABLE IF NOT EXISTS SM.produto (
  id INT NOT NULL,
  nome VARCHAR(45) NOT NULL,
  categoria VARCHAR(45) NOT NULL,
  descricao VARCHAR(45),
  marca VARCHAR(45) NOT NULL,
  unidade VARCHAR(10),
  imagem VARCHAR (500));


CREATE TABLE IF NOT EXISTS SM.comercializa (
  estabelecimento INT NOT NULL,
  produto INT NOT NULL,
  preco VARCHAR(15));


CREATE TABLE IF NOT EXISTS SM.atualiza (
  usuario CHAR(11) NOT NULL,
  produto INT NOT NULL,
  estabelecimento INT NOT NULL,
  data DATE NOT NULL);


CREATE TABLE IF NOT EXISTS SM.acessa (
  usuario CHAR(11) NOT NULL,
  produto INT NOT NULL,
  quantidade INT,
  data DATE NOT NULL);

ALTER TABLE SM.usuario ADD CONSTRAINT pk_usuario
    PRIMARY KEY(CPF);

ALTER TABLE SM.estabelecimento ADD CONSTRAINT pk_estabelecimento
    PRIMARY KEY(id);

ALTER TABLE SM.produto ADD CONSTRAINT pk_produto
    PRIMARY KEY(id);

ALTER TABLE SM.comercializa ADD CONSTRAINT pk_comercializa
    PRIMARY KEY(estabelecimento, produto);

ALTER TABLE SM.acessa ADD CONSTRAINT pk_acessa
    PRIMARY KEY(produto, usuario);

ALTER TABLE SM.atualiza ADD CONSTRAINT pk_atualiza
    PRIMARY KEY(estabelecimento, produto, usuario);
    

ALTER TABLE SM.atualiza ADD CONSTRAINT fk_usuario_atualiza
    FOREIGN KEY (usuario)
    REFERENCES SM.usuario (CPF)
    ON DELETE CASCADE
    ON UPDATE CASCADE;

ALTER TABLE SM.comercializa ADD CONSTRAINT fk_produto_comercializa
    FOREIGN KEY (produto)
    REFERENCES SM.produto (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE;

ALTER TABLE SM.comercializa ADD CONSTRAINT fk_estabelecimento_comercializa
    FOREIGN KEY (estabelecimento)
    REFERENCES SM.estabelecimento (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE;


ALTER TABLE SM.atualiza ADD CONSTRAINT fk_produto_atualiza
    FOREIGN KEY (produto)
    REFERENCES SM.produto (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE;

ALTER TABLE SM.atualiza ADD CONSTRAINT fk_estabelecimento_atualiza
    FOREIGN KEY (estabelecimento)
    REFERENCES SM.estabelecimento (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE;


ALTER TABLE SM.acessa ADD CONSTRAINT fk_produto_acessa
    FOREIGN KEY (produto)
    REFERENCES SM.produto (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE;

ALTER TABLE SM.acessa ADD CONSTRAINT fk_usuario_acessa
    FOREIGN KEY (usuario)
    REFERENCES SM.usuario (CPF)
    ON DELETE CASCADE
    ON UPDATE CASCADE;
