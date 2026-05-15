insert into TB_COZINHA (nome) values ('Brasileira');
insert into TB_COZINHA (nome) values ('Japonesa');
insert into TB_COZINHA (nome) values ('Indiana');
insert into TB_COZINHA (nome) values ('Árabe');

insert into TB_CIDADE (nome) values ('Vila Prudente');
insert into TB_CIDADE (nome) values ('Complexo do Alemão');

insert into TB_ESTADO (nome) values ('São Paulo');
insert into TB_ESTADO (nome) values ('Rio de Janeiro');

insert into TB_FORMA_PAGAMENTO (descricao) values ('Crédito');
insert into TB_FORMA_PAGAMENTO (descricao) values ('Débito');
insert into TB_FORMA_PAGAMENTO (descricao) values ('Pix');
insert into TB_FORMA_PAGAMENTO (descricao) values ('Dinheiro');

insert into TB_USUARIO (nome, email, senha) values ('Leonardo', 'leonardo@hotmail.com', 'leonardo123');
insert into TB_USUARIO (nome, email, senha) values ('Fernando', 'fernando@hotmail.com', 'fernando123');
insert into TB_USUARIO (nome, email, senha) values ('Flavio', 'flavio@hotmail.com', 'flavio123');

insert into TB_PERMISSAO (nome, descricao) values ('CONSULTAR_COZINHAS', 'Permite consultar cozinhas');
insert into TB_PERMISSAO (nome, descricao) values ('EDITAR_COZINHAS', 'Permite editar cozinhas');

insert into TB_GRUPO (nome) values ('Gerente');
insert into TB_GRUPO (nome) values ('Vendedor');