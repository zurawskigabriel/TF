INSERT INTO Produto(codigo,descricao,precounitario) VALUES (10, 'Geladeira', 2500.0);
INSERT INTO Produto(codigo,descricao,precounitario) VALUES (20, 'Fogao', 1200.0);
INSERT INTO Produto(codigo,descricao,precounitario) VALUES (30, 'Lava louca', 4300.0);
INSERT INTO Produto(codigo,descricao,precounitario) VALUES (40, 'Lava roupa', 3350.0);
INSERT INTO Produto(codigo,descricao,precounitario) VALUES (50, 'Aspirador de po', 780.0);
 
INSERT INTO ItemDeEstoque(id,codProduto,quantidadeAtual,estoqueMinimo,estoqueMaximo) VALUES (1, 10, 10, 5, 50);
INSERT INTO ItemDeEstoque(id,codProduto,quantidadeAtual,estoqueMinimo,estoqueMaximo) VALUES (2, 20, 0, 5, 50);
INSERT INTO ItemDeEstoque(id,codProduto,quantidadeAtual,estoqueMinimo,estoqueMaximo) VALUES (3, 30, 7, 5, 50);
INSERT INTO ItemDeEstoque(id,codProduto,quantidadeAtual,estoqueMinimo,estoqueMaximo) VALUES (4, 40, 11, 5, 50);
INSERT INTO ItemDeEstoque(id,codProduto,quantidadeAtual,estoqueMinimo,estoqueMaximo) VALUES (5, 50, 22, 5, 50);
