Реализация RESTfull бэкенда для сайта "блогов".

На сайте можно:
1. Взаимодействовать с аккаунтом. Аккаунт может иметь много постов и комментов.
2. Взаимодействовать с постами. Пост может иметь много комментариев и одного автора.
3. Комментировать посты. Комментарий имеет одного автора и привязан к одному посту.

Стек технологий: Spring Boot, Lombok, Spring Data, Spring Validation, H2 inMemory db.

mvn clean install -Dmaven.test.skip
java -jar target/blogger-service-1.0.2-SNAPSHOT.jar

Swagger Spec http://localhost:8091/swagger-ui.html
![alt text](swagger2.JPG)

H2 console http://localhost:8091/h2-console
![alt text](h2console.JPG)


-- curl http://localhost:8091/api/accounts/6789/posts create post
-- curl http://localhost:8091/api/posts/1/comments add comment
-- curl http://localhost:8091/api/posts/all get posts
-- curl http://localhost:8091/api/accounts/1234/posts get posts of account
-- curl http://localhost:8091/api/comments/all get comments
