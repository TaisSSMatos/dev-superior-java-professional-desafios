# Projeto Evento

Este projeto é uma aplicação Spring Boot que gerencia eventos, atividades, participantes, categorias e blocos de horários. Ele foi desenvolvido como parte de um desafio para demonstrar o uso de entidades JPA e relacionamentos ORM.

## Modelo de Entidades e Relacionamentos

O sistema é composto por quatro entidades principais: `Participante`, `Atividade`, `Categoria` e `Bloco`.

### Entidades

| Entidade     | Campos                      | Tipo de Dado                               |
| :----------- | :-------------------------- | :----------------------------------------- |
| `Participante` | `id`, `nome`, `email`       | `Integer`, `String`, `String`              |
| `Atividade`    | `id`, `nome`, `descricao`, `preco` | `Integer`, `String`, `String`, `Double`    |
| `Categoria`    | `id`, `descricao`           | `Integer`, `String`                        |
| `Bloco`        | `id`, `inicio`, `fim`       | `Integer`, `Instant`, `Instant`            |

### Mapeamento de Relacionamentos (ORM)

*   **`Categoria` $\leftrightarrow$ `Atividade`:**
    *   Relacionamento 1 para N (One-to-Many).
    *   Uma `Categoria` possui várias `Atividades`.
    *   Uma `Atividade` pertence a uma única `Categoria`.

*   **`Atividade` $\leftrightarrow$ `Bloco`:**
    *   Relacionamento 1 para N (One-to-Many).
    *   Uma `Atividade` possui vários `Blocos` de horários.
    *   Um `Bloco` pertence a uma única `Atividade`.
    *   Configurado com `CascadeType.ALL` para que os blocos sejam excluídos junto com a atividade.

*   **`Atividade` $\leftrightarrow$ `Participante`:**
    *   Relacionamento N para N (Many-to-Many).
    *   Uma `Atividade` possui vários `Participantes`.
    *   Um `Participante` pode estar inscrito em várias `Atividades`.

## Tecnologias Utilizadas

*   **Java 17+**
*   **Spring Boot**
*   **Spring Data JPA**
*   **Hibernate**
*   **H2 Database** (para desenvolvimento e testes)
*   **Maven** (gerenciamento de dependências)

## Como Rodar o Projeto

### Pré-requisitos

Certifique-se de ter o Java Development Kit (JDK) 17 ou superior e o Maven instalados em sua máquina.

### Passos

1.  **Clone o repositório:**
    ```bash
    git clone <URL_DO_SEU_REPOSITORIO>
    cd evento
    ```

2.  **Compile o projeto:**
    ```bash
    mvn clean install
    ```

3.  **Execute a aplicação:**
    ```bash
    mvn spring-boot:run
    ```
    A aplicação será iniciada na porta padrão 8080.

## Acesso ao Banco de Dados H2 Console

O projeto utiliza o banco de dados H2 em memória para desenvolvimento e testes. Você pode acessar o console do H2 para visualizar as tabelas e dados.

1.  Certifique-se de que a aplicação esteja em execução.
2.  Abra seu navegador e acesse: `http://localhost:8080/h2-console`
3.  Utilize as seguintes credenciais para conectar:
    *   **JDBC URL:** `jdbc:h2:mem:eventodb`
    *   **User Name:** `sa`
    *   **Password:** (deixe em branco)
4.  Clique em "Connect".

Você poderá ver as tabelas criadas pelo JPA e os dados inseridos (se houver algum script de inicialização como `import.sql`).

## Scripts de Inicialização (import.sql)

O projeto pode conter um arquivo `src/main/resources/import.sql` que é executado automaticamente pelo Hibernate na inicialização da aplicação (quando `spring.jpa.defer-datasource-initialization` é `true` e o perfil `test` está ativo). Este arquivo é usado para popular o banco de dados com dados de teste.

## Estrutura do Projeto

```
evento/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── devsuperior/
│   │   │           └── evento/
│   │   │               ├── EventoApplication.java
│   │   │               └── entities/
│   │   │                   ├── Atividade.java
│   │   │                   ├── Bloco.java
│   │   │                   ├── Categoria.java
│   │   │                   └── Participante.java
│   │   └── resources/
│   │       ├── application.yaml
│   │       ├── application-test.yaml
│   │       └── import.sql
│   └── test/
│       └── java/
│           └── com/
│               └── devsuperior/
│                   └── evento/
│                       └── ... (testes)
├── pom.xml
└── README.md
```

---

Este `README.md` fornece uma visão geral completa do projeto, incluindo o modelo de dados, tecnologias, instruções de execução e acesso ao banco de dados H2.
