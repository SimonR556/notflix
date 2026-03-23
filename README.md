O Notflix é uma aplicação Full Stack desenvolvida em Java com Spring Boot. O projeto consome a API do TMDB (The Movie Database) para listar filmes populares, realizar buscas em tempo real e exibir detalhes como sinopse e onde assistir (streaming). Além disso, possui um sistema de feedback onde usuários podem deixar comentários armazenados em um banco de dados local.

como rodar o projeto:

1. clone o repositorio
2. crie uma conta no TheMovieDB[https://www.themoviedb.org] e gere ua chave de API gratuita
3. abra o arquivo src/main/resources/application.properties e insira sua chave
4. execute a aplicação digitando dentro da pasta do projeto ./gradlew bootRun
5. acesse pelo navegador -> http://localhost:8080
