# Banco Javer

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![SpringBoot](https://img.shields.io/badge/SpringBoot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![H2 Database](https://img.shields.io/badge/H2-0078D4?style=for-the-badge&logo=h2&logoColor=white)
![Swagger](https://img.shields.io/badge/Swagger-85EA2D?style=for-the-badge&logo=swagger&logoColor=black)
![Postman](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white)
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ-000000?style=for-the-badge&logo=intellij-idea&logoColor=white)

Banco Javer é uma aplicação desenvolvida em Java utilizando o framework Spring Boot. Este projeto foi criado para um desafio da IBM e possui as seguintes operações:

- Cadastrar cliente
- Buscar todos os clientes
- Buscar cliente por id
- Atualizar cliente
- Deletar cliente

## Tecnologias Utilizadas

- **Java**: Linguagem de programação utilizada para desenvolver a aplicação.
- **Spring Boot**: Framework que facilita a criação de aplicações Java.
- **H2 Database**: Banco de dados utilizado para armazenamento de dados localmente.
- **Swagger**: Ferramenta para documentação das APIs.
- **Postman**: Ferramenta utilizada para testar as APIs.
- **IntelliJ IDEA**: IDE utilizada para o desenvolvimento do projeto.

## Documentação da API

A documentação da API pode ser acessada através do Swagger. Para acessar a documentação, basta iniciar a aplicação e abrir o seguinte link no navegador: `http://localhost:8080/swagger-ui.html`

## Executando a Aplicação

### Pré-requisitos

- JDK 17

### Passos para executar a aplicação

1. Clone o repositório:
   ```bash
   git clone https://github.com/JoaomBRosio/ibm_projeto_final
2. Abra o projeto na sua IDE.

3. Na sua IDE aguarde instalar as dependencias e rode ambas as aplicações.

### Passos para usar e testar a aplicação

1. Com ambas as aplicações rodando, acesse a documentação swagger para que você tenha uma melhor visualização e entendimento.
<br>
2. Execute o primeiro POST de 'criar um novo cliente' (o ID é gerado automaticamente e o score crédito é recuperado através do saldo.) usando o seguinte JSON:
    ```bash
    {
    "username": "Seu nome",
    "telefone": 123456789,
    "correntista": true,
    "saldo_cc": 90000.50
    }
3. Agora com um ou mais clientes criados podemos ir para a rota de 'buscar todos os clientes'. Para isso, apenas execute o pelo botão de 'Try it out' e depois o 'Execute'.
<br>
4. Para uma busca detalhada use a rota de 'buscar um cliente'. Clique em 'Try it out'e no campo 'ID' coloque o ID do cliente que você pretende retornar e novamente clique em 'Execute'.
<br>
5. Você também pode atualizar um cliente. Para isso use a rota de 'atualizar um cliente'. Ao clicar em 'Try it out' coloque no campo ID o ID de quem você deseja atualizar e preencha o corpo da requisição com os dados atualizados colocando o seguinte JSON:
    ```bash
    {
        "username": "Seu nome atualizado",
        "telefone": 123456789,
        "correntista": true,
        "saldo_cc": 90000.50
    }

6. E por ultimo, você pode excluir um usuario apenas indo em 'Try it out' e preenchendo o campo de ID e clicando em 'Execute'.
<br>
   Dessa forma você conclui todas as operações desse sistema.
   Espero que tenha gostado do projeto. 
<br>
   João Ambrósio




