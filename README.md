# ShortenerApp

ShortenerApp is URL shortening app. I used model (MVC) and multitier architecture: Controller - Service - Repository (- DataBase). HTTP methods: POST and GET (redirect). In service I make a six character generator (62 chars = alphabet + numbers).
Model is simple - object stores short, genereted URL and long URL. The repository connects to the NoSQL database Redis (key-value). Simple view using Thymeleaf (I was guided by the opinions from Stack Overflow - 
[Difference between spring JSP MVC and Thymeleaf MVC](https://stackoverflow.com/questions/41019274/difference-between-spring-jsp-mvc-and-thymeleaf-mvc).
## Technologies
  * Linux (Virtual Box),
  * Eclipse 2020-03,
  * Spring Boot,
  * Maven,
  * Thymeleaf,
  * Redis (Jedis),
  * Postman - tests.

## What I've learned
  * Divide responisibilities. Firstly Controller - Service (Map<String, String> instead of DataBase). Secondly test. Thirdly I added model, DB and test it. Finally adding Views.
  * Build automation - make a plan and add dependencies at the beginning of the process.
  * How convenient is Spring Boot to use.
  * MVC in practice.
  * Basic information about NoSQL DS - especially key-value store.
  * HTTP methods using controller and Postman.
  * Linux - deepening knowledge about the terminal.

## What I should to learn and improve

  * Posibilities of Spring Boot,
  * Developing views, also HTTP,
  * Gradle,
  * NoSQL: document, graph and wide-column,
  * Linux.
