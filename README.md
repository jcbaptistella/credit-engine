# Aplicação de Análise de Crédito

## Visão Geral
Essa aplicação é um motor de crédito que realiza uma análise para verificar se um crédito é aprovado ou não com base nos dados fornecidos pelo usuário.

## Funcionamento da API

A aplicação oferece uma API para análise de crédito. O fluxo de operação é o seguinte:

1. **Entrada de Dados**: O usuário envia seus dados pessoais e informações financeiras para a API.
2. **Processamento**: A API executa uma série de regras de negócios para verificar se o crédito é aprovado ou não.
3. **Resultado**: A resposta contém a aprovação ou reprovação do crédito com base nas regras de análise.

## Tecnologias Utilizadas
- **Java 23**
- **Spring Boot 3**
- **Docker**
- **JUnit (para testes unitários)**

## Como Rodar Localmente

### Pré-requisitos
- **Java 23** instalado.
- **Maven** para gerenciamento de dependências.
- **Postman** (opcional, para testar a API).

### Passo a Passo

1. Clone o repositório:

    ```bash
    git clone https://github.com/jcbaptistella/credit-engine.git
    cd credit-engine
    ```

2. Compile o projeto com Maven:

    ```bash
    mvn clean install
    ```

3. Inicie o servidor localmente:

    ```bash
    mvn spring-boot:run
    ```

4. A aplicação estará rodando em `http://localhost:8080`.

### Como Subir com Docker

1. Certifique-se de ter o Docker instalado e funcionando.

2. No diretório raiz do projeto, construa a imagem Docker:

    ```bash
    docker build -t credit-engine .
    ```

3. Suba o container:

    ```bash
    docker run -p 8080:8080 credit-engine
    ```

4. A aplicação estará rodando no Docker e acessível em `http://localhost:8080`.

## Documentação da API

A documentação da API pode ser encontrada na pasta `docs` na raiz do projeto. Lá possui uma collection do postman que inclui todas as rotas da API.

## Como Executar os Testes Unitários Localmente
Para rodar os testes unitários, execute o seguinte comando:

   ``` bash
       mvn test 
   ```

Isso irá executar todos os testes definidos no projeto.
