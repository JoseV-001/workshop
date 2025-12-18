# Workshop – Web Services com Spring Boot e JPA

Este projeto é uma aplicação de serviços web desenvolvida com **Spring Boot e JPA**, criada com o objetivo de praticar a modelagem de domínios complexos, associações entre entidades e a construção de **APIs REST seguindo boas práticas de arquitetura**.

O sistema simula um fluxo completo de pedidos, desde usuários e produtos até o cálculo de totais, utilizando persistência relacional com **PostgreSQL**, suporte a múltiplos ambientes e deploy em nuvem.

---

## 🚀 Tecnologias e Versões

* **Java 21**
* **Spring Boot 3.5.8**
* **Spring Data JPA / Hibernate**
* **Maven**
* **PostgreSQL**
* **H2 (ambiente de testes)**
* **Docker (produção)**
* **Render (deploy em nuvem)**

---

## ⚙️ Arquitetura de Perfis (Multi-Environment)

A aplicação utiliza **Spring Profiles** para separar ambientes de execução.

### 📁 Perfis disponíveis

* **Test (`application-test.properties`)**

  * Banco **H2 em memória**
  * Ideal para testes rápidos

* **Dev (`application-dev.properties`)**

  * Banco **PostgreSQL local**
  * Usado durante o desenvolvimento

* **Prod (`application-prod.properties`)**

  * Banco **PostgreSQL gerenciado na nuvem (Render)**
  * Configuração via **variáveis de ambiente**

### 🔄 Como alternar o ambiente

No arquivo `src/main/resources/application.properties`:

```properties
spring.profiles.active=test
# ou
spring.profiles.active=dev
# ou
spring.profiles.active=prod
```

> ⚠️ No perfil **dev**, ajuste manualmente a URL, usuário e senha do PostgreSQL local.

---

## 🗄️ Banco de Dados e Script SQL

O projeto inclui um arquivo **`script.sql`**, que pode ser utilizado para:

* Criar e popular o banco de dados **localmente**
* Inicializar a estrutura do banco **na nuvem (Render)**

Ele garante a criação correta das tabelas, chaves primárias, estrangeiras e relacionamentos.

> 🔎 Observação: o projeto também possui **seed automático via Java**, utilizado principalmente nos ambientes de **test** e **dev**.

---

## 🧱 Estrutura do Sistema

A aplicação segue uma **arquitetura em camadas bem definida**, com separação clara de responsabilidades:

### 🧩 Resource Layer (`resources`)

* Controladores REST responsáveis pelos **endpoints da API**
* Recebem e retornam dados em formato JSON
* Delegam a lógica de negócio para a camada de serviços

### ⚙️ Service Layer (`services`)

* Camada de **regras de negócio e orquestração**
* Contém a lógica da aplicação
* Realiza validações e coordena chamadas aos repositórios
* Centraliza exceções de domínio

### 🗄️ Repository Layer (`repositories`)

* Interfaces de acesso a dados usando **Spring Data JPA**
* Responsáveis pela comunicação com o banco de dados
* Implementação automática fornecida pelo Spring

### 🧱 Entity Layer (`entities`)

* Contém as **entidades de domínio**
* Mapeamento ORM com **JPA/Hibernate**
* Define relacionamentos, chaves primárias e regras de persistência

---

## 📁 Estrutura de Pacotes

A organização do projeto segue boas práticas de separação de responsabilidades, facilitando manutenção, testes e evolução da aplicação.

```text
com.josev001.WorkShop
├── config
│   └── TestConfig
│       └── Configurações específicas para ambiente de testes e seed de dados
│
├── entities
│   ├── enums
│   │   └── OrderStatus
│   ├── pk
│   │   └── OrderItemPk
│   ├── Category
│   ├── Order
│   ├── OrderItem
│   ├── Payment
│   ├── Product
│   └── User
│
├── repositories
│   ├── CategoryRepository
│   ├── OrderItemRepository
│   ├── OrderRepository
│   ├── ProductRepository
│   └── UserRepository
│
├── resources
│   ├── exceptions
│   │   ├── ResourceExceptionHandler
│   │   └── StandardError
│   ├── CategoryResource
│   ├── OrderResource
│   ├── ProductResource
│   └── UserResource
│
├── services
│   ├── exceptions
│   │   ├── DatabaseException
│   │   └── ResourceNotFoundException
│   ├── CategoryService
│   ├── OrderService
│   ├── ProductService
│   └── UserService
│
└── WorkShopApplication
    └── Classe principal de inicialização do Spring Boot
```

---

## 📂 Recursos de Configuração

```text
src/main/resources
├── application.properties
├── application-dev.properties
├── application-test.properties
└── application-prod.properties
```

Cada arquivo representa um **perfil de execução**, permitindo alternar facilmente entre ambientes.

---

## 🧪 Testes com Postman

Os endpoints da API foram testados utilizando o **Postman**, garantindo o correto funcionamento das operações e o comportamento esperado da aplicação.

Os testes incluem:

- Operações completas de **CRUD**
- Validação das respostas em **JSON**
- Testes de **exceções personalizadas**, como:
  - Recurso não encontrado (`404`)
  - Erros de integridade de dados
- Verificação de códigos de status HTTP
- Testes de fluxo completo de pedidos

> 🔎 A utilização do Postman facilita a validação manual da API durante o desenvolvimento e garante maior confiabilidade antes do deploy em produção.

## 🏁 Funcionalidades Implementadas

* Modelagem completa de associações
* Tratamento global de exceções
* Seed automático de banco de dados
* Cálculo automático de subtotal e total de pedidos
* API REST seguindo boas práticas

---

## ▶️ Como Executar o Projeto Localmente

Este projeto foi projetado para ser executado **localmente via Maven**.
O uso de Docker é **exclusivo para produção no Render**.

Pré-requisitos:

* **Java 21**
* **Maven**

> Utilize os perfis **test** ou **dev** para execução local.

---

## 🐳 Docker e Deploy no Render

O arquivo `Dockerfile` presente no repositório é utilizado **exclusivamente para o deploy em produção no Render**.

Ele é responsável por:

* Definir o ambiente Java (Java 21 – Eclipse Temurin)
* Realizar o build do projeto utilizando o Maven Wrapper
* Gerar o arquivo `.jar`
* Executar a aplicação em produção

### 📄 Dockerfile

```dockerfile
FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY . .

RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests

CMD ["java", "-jar", "target/WorkShop-0.0.1-SNAPSHOT.jar"]
```

O **Render** é responsável por:

* Construir a imagem Docker
* Executar o container
* Injetar as variáveis de ambiente do PostgreSQL

---

## 📡 Endpoints Principais

* `GET /users`
* `POST /users`
* `GET /products`
* `POST /orders`
* `GET /orders/{id}`

---

## 👤 Autor

**JoseV-001**
Projeto de estudo e prática em **Spring Boot, JPA, Docker e APIs REST**
