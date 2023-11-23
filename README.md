# Java Hibernate Loja

O projeto Java Hibernate Loja é uma aplicação Java com o framework Hibernate ,
que simula o funcionamento de uma loja virtual. Ele utiliza o padrão de persistência JPA (Java Persistence API) para interagir com o banco de dados, 
e as principais entidades do sistema são Cliente, Produto, Categoria e Pedido.

## 🚀 Funcionalidades Principais

```
- Cadastramento de clientes, produtos e categorias.
- Realização de pedidos, associando clientes e produtos.
- Consulta de relatórios de vendas.
```
## 📋 Tecnologias

```
- Java 17: Plataforma de desenvolvimento utilizada para criar a aplicação.
- Hibernate 5.5.6.Final: Framework de mapeamento objeto-relacional.
- MySQL Connector Java 8.0.33: Driver de conexão com o banco de dados MySQL.
- JPA 2.2: API de persistência para mapeamento objeto-relacional em aplicações Java.
- Validation API 2.0.1.Final: API de validação de dados.
```

## 🔧 Como Executar

- Clone este repositório para a sua máquina local ou faça o download do código-fonte.
- Configure um banco de dados MySQL e ajuste as configurações de conexão no arquivo persistence.xml.
- Abra o projeto em sua IDE preferida (IntelliJ, Eclipse, etc.).
- Execute as classes de teste localizadas no pacote br.com.jgmv.loja.testes para popular o banco de dados e realizar testes.

## ⚙️ Executando os testes

Explicar como executar os testes automatizados para este sistema.

## 📁 Estrutura do Projeto

O projeto está organizado da seguinte forma:

````
- src/br/com/jgmv/loja/dao: Classes responsáveis pelo acesso aos dados.
CategoriaDao.java: Operações relacionadas à entidade Categoria.
ClienteDao.java: Operações relacionadas à entidade Cliente.
PedidoDao.java: Operações relacionadas à entidade Pedido.
ProdutoDao.java: Operações relacionadas à entidade Produto.

- src/br/com/jgmv/loja/modelo: Entidades do sistema.
Categoria.java: Representa as categorias dos produtos.
Cliente.java: Representa os clientes da loja.
DadosPessoais.java: Classe incorporável para dados pessoais do cliente.
ItemPedido.java: Representa os itens de um pedido.
Pedido.java: Representa os pedidos realizados pelos clientes.
Produto.java: Representa os produtos disponíveis na loja.

- src/br/com/jgmv/loja/testes: Classes de teste para simular o funcionamento do sistema.
CadastroDePedido.java: Exemplo de cadastro de um pedido com cliente e produto.
CadastroProduto.java: Exemplo de cadastro de produtos e consulta por categoria.
PeformanceConsulta.java: Teste de desempenho para consulta de pedidos com clientes.

- src/br/com/jgmv/loja/util: Classes utilitárias.
JPAUtil.java: Classe para obtenção do EntityManager.

- src/br/com/jgmv/loja/vo: Classes de Value Object (VO) para representar dados em relatórios.
RelatorioVo.java: Classe que representa os dados de um relatório de vendas.
````
## Links Úteis
[Hibernate Documentation](https://docs.jboss.org/hibernate/stable/orm/userguide/html_single/Hibernate_User_Guide.html)
- Framework utilizado.

## Sobre o desenvolvedor 

Feito por José Gabriel (https://linkedin.com/in/josé-gabriel-mendes-vieira-970b57260) - Sinta-se à vontade para me conectar no LinkedIn!