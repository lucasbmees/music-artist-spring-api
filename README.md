# Project CRUD Artist Persistence

Este projeto é uma aplicação Spring Boot desenvolvida para gerenciar um catálogo de artistas e suas músicas, focando na prática de persistência de dados com Spring Data JPA e PostgreSQL.

## Tecnologias Utilizadas

- Java 17
- Spring Boot 4.0.2
- Spring Data JPA
- PostgreSQL
- Maven

## Funcionalidades

O sistema oferece uma interface CLI (Command Line Interface) com as seguintes opções:

1.  **Cadastrar Artista**: Registro de novos artistas com definição de estilo (Solo, Banda ou Dupla).
2.  **Listar Artistas**: Exibição de todos os artistas salvos no banco de dados.
3.  **Remover Artista**: Exclusão de registros de artistas.
4.  **Cadastrar Música**: Adição de músicas vinculadas a um artista existente.
5.  **Listar Músicas**: Exibição detalhada de todas as músicas e seus respectivos autores.
6.  **Remover Música**: Exclusão de faixas específicas.
7.  **Busca por Artista**: Filtro de músicas utilizando consultas JPQL personalizadas.

## Estrutura do Projeto

- **Model**: Contém as entidades Artista (com estilos ENUM) e Musica.
- **Repository**: Interfaces que estendem JpaRepository para operações de CRUD.
- **Main**: Classe responsável pela lógica do menu interativo e interação com o usuário.
