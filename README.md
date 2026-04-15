# MyContacts

Projeto criando com: spring boot, flyway para criar as migrations e spring data jpa.

### Pré requisitos:
- Docker e Docker-compose instalados;
- Certifique-se que nada está rodando na porta do nginx, se seu so for baseado no linux, digite no terminal sudo lsof -i :80, se nada aparecer, pode prosseguir.

### Como rodar o projeto:

- Para rodar o projeto, basta preencher as variáveis de ambiente seguindo o padrão do .env.example, após isso, estando no diretório raiz do projeto, digite `docker compose up --build`, após isso, utilize o comando docker ps para verificar se todos os container estão rodando, após isso, acesse no navegador, `localhost`.

### O que foi utilizado no projeto

- No código da API foram abordados conceitos como estruturação em camadas, exceções personalizadas e com retorno padronizado, validações de entrada.
- Stacks utilizadas: Java com Spring Boot, pacotes validation para validação de entradas, git e github para versionamento, dockerfile para criar a imagem do backend, docker compose para ter tudo da aplicação containerizada como o: postgresql para banco de dados, nginx para proxy reverso, e a própria api, todas coma cesso apenas na própria rede, e dados do postgres persistidos utilizando o volumes do docker, para caso derrubar os containers com docker compose down, os dados do banco estarem persistidos na máquina.

- Próximos passos: refatorar alguns códigos repetitivos, subir em uma vps.
