# Challenge Literalura para o curso Back-End da Alura 

**Literalura** é um projeto desenvolvido para facilitar a busca e organização de livros e autores, utilizando a API do Gutendex para obter informações sobre obras literárias. O projeto é construído em Java com o framework Spring Boot, e oferece uma interface de linha de comando (CLI) para interação com o usuário.

## Funcionalidades

O projeto oferece as seguintes funcionalidades:

1. **Buscar livro pelo título**: Permite ao usuário buscar um livro pelo título e salvar as informações no banco de dados.
2. **Listar livros registrados**: Exibe todos os livros que foram salvos no banco de dados.
3. **Listar autores registrados**: Exibe todos os autores que foram salvos no banco de dados.
4. **Listar autores vivos em um determinado ano**: Permite ao usuário listar autores que estavam vivos em um ano específico.
5. **Listar livros em um determinado idioma**: Permite ao usuário listar livros que estão disponíveis em um idioma específico.

## Tecnologias Utilizadas

<p align="left">
  <a href="https://skillicons.dev">
    <img src="https://skillicons.dev/icons?i=java,spring,postgresql&perline=9" />
  </a>
</p>

## Como Executar o Projeto

**Pré-requisitos**:
- Java JDK 17 ou superior.
- Gerenciador de pacotes maven instalado.
- Banco de dados configurado (por exemplo: MySQL ou PostgreSQL).

### Passos para Execução

1. Clone o repositório:
    ```bash
    git clone https://github.com/lucca16bit/spring-books-gutendex.git
    cd spring-books-gutendex
    ```
2. Configure o banco de dados:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/literalura
    spring.datasource.username=seu-usuario
    spring.datasource.password=sua-senha
    spring.jpa.hibernate.ddl-auto=update
    ```
3. Compile e execute o projeto:
    ```bash
    mvn clean install
    mvn spring-boot:run
    ```
4. Interaja com o sistema:

    Após a execução, o sistema estará disponível via linha de comando. Siga as instruções exibidas no menu para realizar as operações desejadas.


<div style="text-align: center;">
  <img src="src/main/resources/assets/badge-literalura.png" alt="badge literalura" width="300">
</div>