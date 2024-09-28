# Builder Pattern and Lombok

Este projeto consiste em uma simples API para demonstrar o uso do padrão de projetos criacional builder e a biblioteca Lombok.

## Tecnologias

- Java 17
- Spring Boot
- Lombok
- Postgres
- Docker

## Uso

1. Clone o projeto

3. Suba o docker com o serviço do banco de dados
    
    ```
    docker compose up -d --build
    ```

3. Rode o spring boot com o servidor tomcat

    ```
    mvn spring-boot:run
    ```
   
4. Acesse em http://localhost:8080/api

## Endpoints

### Cria um usuário básico: 
    
- Request: POST /api/user/basic
    ```
    {
      "name": "Ana",
      "email": "corina@email.com"
    }
    ```
   
- Response:

    ```
    {
      "id": 13,
      "name": "Ana",
      "email": "corina@email.com"
      "userType": "BASIC"
    }
    ```

### Cria um usuário premium:

- Request: POST /api/user/premium
    ```
    {
      "name": "João",
      "email": "joão@email.com"
    }
    ```

- Response:

    ```
    {
      "id": 14,
      "name": "João",
      "email": "joao@email.com",
      "code": "BL4TSLBPLA",
      "userType": "PREMIUM"
    }
    ```

### Lista todos os usuários básicos

- Response:

    ```
    [
      {
        "id": 8,
        "name": "Rafa",
        "email": "rafa@email.com",
        "userType": "BASIC"
      },
      {
        "id": 9,
        "name": "Toca",
        "email": "toca@email.com",
        "userType": "BASIC"
      },
      { 
        "id": 13,
        "name": "Ana",
        "email": "ana@email.com",
        "userType": "BASIC"
      }
    ]
    ```

### Lista todos os usuários premiums

- Response:

    ```
    [
      {
        "id": 14,
        "name": "Lorena",
        "email": "lorena@email.com",
        "code": "RDQ6KRI9NV",
        "userType": "PREMIUM"
      },
      {
        "id": 15,
        "name": "Paty",
        "email": "paty@email.com",
        "code": "9HFM44EZTF",
        "userType": "PREMIUM"
      },
      { 
        "id": 20,
        "name": "Guedes",
        "email": "guedes@email.com",
        "code": "314YW98MIQ",
        "userType": "PREMIUM"
      }
    ]
    ```