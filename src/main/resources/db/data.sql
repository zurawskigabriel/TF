INSERT INTO produto(codigo,descricao,preco_unitario) VALUES (10, 'Geladeira', 2500.0);
INSERT INTO produto(codigo,descricao,preco_unitario) VALUES (20, 'Fogao', 1200.0);
INSERT INTO produto(codigo,descricao,preco_unitario) VALUES (30, 'Lava louca', 4300.0);
INSERT INTO produto(codigo,descricao,preco_unitario) VALUES (40, 'Lava roupa', 3350.0);
INSERT INTO produto(codigo,descricao,preco_unitario) VALUES (50, 'Aspirador de po', 780.0);

INSERT INTO item_de_estoque(id, cod_produto, quantidade_atual, estoque_minimo, estoque_maximo) VALUES (1, 10, 10, 5, 50);
INSERT INTO item_de_estoque(id, cod_produto, quantidade_atual, estoque_minimo, estoque_maximo) VALUES (2, 20, 0, 5, 50);
INSERT INTO item_de_estoque(id, cod_produto, quantidade_atual, estoque_minimo, estoque_maximo) VALUES (3, 30, 7, 5, 50);
INSERT INTO item_de_estoque(id, cod_produto, quantidade_atual, estoque_minimo, estoque_maximo) VALUES (4, 40, 11, 5, 50);
INSERT INTO item_de_estoque(id, cod_produto, quantidade_atual, estoque_minimo, estoque_maximo) VALUES (5, 50, 22, 5, 50);

INSERT INTO orcamento (ID, NOME_CLIENTE, CUSTO_PEDIDO, CUSTO_IMPOSTO, DESCONTO, TOTAL_PAGAR, EFETIVADO, DATA) VALUES (1, 'Fulano', 3000.0, 300.0, 150, 3250.0, true, '2023-01-03');
INSERT INTO orcamento (ID, NOME_CLIENTE, CUSTO_PEDIDO, CUSTO_IMPOSTO, DESCONTO, TOTAL_PAGAR, EFETIVADO, DATA) VALUES (2, 'Beltrano', 4000.0, 400.0, 200, 4300.0, true, '2023-01-04');

INSERT INTO item_Pedido (id, cod_Produto, quantidade, preco, orcamento_id) VALUES (1, 10, 1, 2500.0, 1);
INSERT INTO item_Pedido (id, cod_Produto, quantidade, preco, orcamento_id) VALUES (2, 20, 2, 1200.0, 1);
INSERT INTO item_Pedido (id, cod_Produto, quantidade, preco, orcamento_id) VALUES (3, 30, 1, 4300.0, 1);
INSERT INTO item_Pedido (id, cod_Produto, quantidade, preco, orcamento_id) VALUES (4, 40, 1, 3350.0, 1);
INSERT INTO item_Pedido (id, cod_Produto, quantidade, preco, orcamento_id) VALUES (5, 50, 3, 780.0, 1);

INSERT INTO item_Pedido (id, cod_Produto, quantidade, preco, orcamento_id) VALUES (6, 10, 2, 2500.0, 2);
INSERT INTO item_Pedido (id, cod_Produto, quantidade, preco, orcamento_id) VALUES (7, 20, 1, 1200.0, 2);
INSERT INTO item_Pedido (id, cod_Produto, quantidade, preco, orcamento_id) VALUES (8, 30, 2, 4300.0, 2);
INSERT INTO item_Pedido (id, cod_Produto, quantidade, preco, orcamento_id) VALUES (9, 40, 2, 3350.0, 2);
INSERT INTO item_Pedido (id, cod_Produto, quantidade, preco, orcamento_id) VALUES (10, 50, 1, 780.0, 2);
