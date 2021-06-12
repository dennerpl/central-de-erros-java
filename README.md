# Central de Erros
API para gerenciamento de logs de erros. Desafio prático Aceleração Codenation com apoio da Conta Azul.

# Tecnologias Utilizadas
- Java 1.8
- Spring Boot 2.4.4
- Maven 
- PostgreSQL 12.2
- Swagger 2.7.0
- Oauth 2

# Documentação da API:

Caso prefira, você pode acessar a documentação do swagger acessando a url `http://localhost:8080/swagger-ui.html`

## Descrição dos Endpoints

 **/user - POST** - Rota para criação de usuário. 
Recebe  através do **body** da requisição o email e senha, e cria um novo usuário.
```json
// Corpo da requisição:
   {
   	"name":"Nome",
   	"email": "contato@email.com",
   	"password": "senha123"
   }
```
 **/oauth/token - POST** - Rota de autenticação. Solicitação de token. 
Recebe  através do **body** da requisição o email e senha, e cria um novo usuário.
```json
// Corpo da requisição:
	*Colocar a estrutura aqui*
```

**GET - /log** - Rota para listagem de **Logs** com paginação. Requer **token** valido para ser acessado.
- Caso nenhum parametro de filtro seja passado pela url, o endpoint retornará uma pagina com até 20 registros e informações como total de registros, pagina atual etc.

- É possível definir a estrutura das páginas e qual acessar através dos parâmetros **size** e **page**, respectivamente.
Exemplo: `http://localhost:8080/log?page=2&size=10`

- É possível filtrar os logs retornados através dos parâmetros **filter** e **value**.
Exemplo: `http://localhost:8080/log?filter=level&value=error`

- É possível ordenar os logs retornados através do parâmetro **sort**.
Exemplo: `http://localhost:8080/log?sort=id,desc`

**Obs:** Todos os parâmetros anteriores podem ser usados de forma simultanea.


 **GET - /log/id** - Rota para exibir um Log especifico. Requer **token** valido para ser acessado.

**POST - /log** - Rota para criação de Log.  Requer **token** valido para ser acessado.
```json
// Corpo da requisição:
{
  "level":"error",
  "description":"Crash while server update",
  "log":"...",
  "origin":"Frontend Client",
  "date":"2021-04-07T16:11:26.485",
  "quantity":3
}
```
# Equipe

| ![luciano](https://avatars.githubusercontent.com/u/62217873?v=4) | ![luciano](https://avatars.githubusercontent.com/u/69821947?v=4) |![luciano](https://avatars.githubusercontent.com/u/69804027?v=4)|![luciano](https://avatars.githubusercontent.com/u/63373302?v=4)|![luciano](https://avatars.githubusercontent.com/u/56321955?v=4)|
|--|--|--|--|--|
| Dan | Denner | Mel | Luciano | Pedro |
