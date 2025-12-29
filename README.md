📌 Tecnologias Utilizadas

Backend

- Java

- Spring Boot

- Maven

- JPA / Hibernate

Frontend

- React

- Vite

- TypeScript

- CSS

Como rodar o BACKEND

1- Abra o terminal na pasta do backend:

cd backend

2- Rode a aplicação:

mvn spring-boot:run

3- Backend sobe normalmente em:

http://localhost:8080

Como rodar o FRONTEND

1- Abra outro terminal na pasta do frontend:

cd frontend

2- Instale as dependências (apenas na primeira vez):

npm install

3- Inicie o frontend:

npm run dev

4- Frontend roda normalmente em:

http://localhost:5173

Endpoints principais (Backend)

Exemplo de endpoints:

- GET /urls
Lista todas as URLs

- POST /urls
Cria uma nova URL

- GET /urls/{id}
Busca URL por ID

- DELETE /urls/{id}
Remove uma URL

