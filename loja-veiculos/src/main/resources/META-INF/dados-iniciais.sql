insert into proprietario (codigo, nome, telefone) values (1, "Lucas", "(11) 1111-1111");
insert into proprietario (codigo, nome, telefone) values (2, "Jessica", "(11) 2222-2222");
insert into proprietario (codigo, nome, telefone) values (3, "José", "(19) 91234-1234");

insert into tab_veiculo (placa, cidade, fabricante, modelo, ano_fabricacao, ano_modelo, valor, tipo_combustivel, data_cadastro, especificacoes, proprietario_codigo) values ("AAA-1111", "São Paulo - SP", 'Fiat', 'Toro', 2020, 2020, 107000, 'DIESEL', sysdate(), "\nCarro em excelente estado.\nCompleto, menos ar.\nPrimeiro dono, com manual de instrução e todas as revisões feitas.\nIPVA pago, aceita financiamento.\n", 1);
insert into tab_veiculo (placa, cidade, fabricante, modelo, ano_fabricacao, ano_modelo, valor, tipo_combustivel, data_cadastro, especificacoes, proprietario_codigo) values ("BBB-2222", "Rio de Janeiro - RJ", 'Ford', 'Fiesta', 2019, 2019, 42000, 'GASOLINA', sysdate(), "Carro economico, pouca quilometragem, final da placa 2", 2);
insert into tab_veiculo (placa, cidade, fabricante, modelo, ano_fabricacao, ano_modelo, valor, tipo_combustivel, data_cadastro, especificacoes, proprietario_codigo) values ("CCC-3333", "Jundiaí-SP", 'VW', 'Gol', 2019, 2020, 35000, 'BICOMBUSTIVEL', sysdate(), "Carro do ano, completo, ar-condicionado incluso", 3);
insert into tab_veiculo (placa, cidade, fabricante, modelo, ano_fabricacao, ano_modelo, valor, tipo_combustivel, data_cadastro, especificacoes, proprietario_codigo) values ("DDD-4444", "São Paulo - SP", 'Ford', 'Ka', 2018, 2019, 27000, 'BICOMBUSTIVEL', sysdate(), "Semi-novo, com garantia, completo", 1);