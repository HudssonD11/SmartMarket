insert into sm.produto (id, nome, categoria, descricao, marca, unidade, imagem) values (1, 'Coca Cola', 'Bebida', 'Refrigerante CocaCola', 'Coca Cola', '1L', 'https://campota24.com/wp-content/uploads/2021/01/unnamed.jpg');

insert into sm.produto (id, nome, categoria, descricao, marca, unidade, imagem) values (2, 'Café', 'Padaria', 'Pó de café', 'Três corações', '1KG', 'https://fortatacadista.vteximg.com.br/arquivos/ids/291270-800-800/7896045102440.jpg?v=637521086631470000');

insert into sm.produto (id, nome, categoria, descricao, marca, unidade, imagem) values (3, 'Arroz', 'Alimentos', 'Sacola de Arroz', 'Prato Fino', '5KG', 'https://supernossoemcasa.vteximg.com.br/arquivos/ids/208218-1000-1000/Arroz-Prato-Fino-Branco-5-kg.jpg?v=637096914068000000');

insert into sm.estabelecimento (id, nome, estado, cidade, bairro, rua, numero, logo) values (1, 'Epa', 'MG', 'Belo Horizonte', 'Coração Eucarístico', 'Coração Eucarístico de Jesus', 86, 'https://redeapp.com.br/wp-content/uploads/2018/04/epa-supermercados-original.png');

insert into sm.estabelecimento (id, nome, estado, cidade, bairro, rua, numero, logo) values (2, 'BH', 'MG', 'Contagem', 'Industrial', 'Tiradentes', 1535, 'https://logodownload.org/wp-content/uploads/2021/07/supermercados-bh-logo.png');

insert into sm.estabelecimento (id, nome, estado, cidade, bairro, rua, numero, logo) values (3, 'Apoio Mineiro', 'MG', 'Belo Horizonte', 'Tirol', 'Antônio Eustáquio Piazza', 2725, 'https://pt-br-media.shopfully.cloud/images/catene/segnalino_apoio-mineiro@2x.png');

insert into sm.usuario (cpf, nome, login, senha, email, creditos, tipo) values ('12345678911', 'jose', 'login', 'senha', 'email', 4, 'o');

insert into sm.comercializa (estabelecimento, produto, preco) values (1, 1, '4,59');
insert into sm.comercializa (estabelecimento, produto, preco) values (2, 1, '3,99');
insert into sm.comercializa (estabelecimento, produto, preco) values (3, 1, '4,20');

insert into sm.comercializa (estabelecimento, produto, preco) values (1, 2, '11,59');
insert into sm.comercializa (estabelecimento, produto, preco) values (2, 2, '10,99');
insert into sm.comercializa (estabelecimento, produto, preco) values (3, 2, '10,98');

insert into sm.comercializa (estabelecimento, produto, preco) values (1, 3, '8,99');
insert into sm.comercializa (estabelecimento, produto, preco) values (2, 3, '7,48');
insert into sm.comercializa (estabelecimento, produto, preco) values (3, 3, '8,27');