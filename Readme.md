## Реализация RESTfull бэкенда для сайта "Blogger".

На сайте можно:
1. Взаимодействовать с аккаунтом. Аккаунт может иметь много постов и комментов.
2. Взаимодействовать с постами. Пост может иметь много комментариев и одного автора.
3. Комментировать посты. Комментарий имеет одного автора и привязан к одному посту.

Стек технологий:

Spring Boot, Lombok, Spring Data, Spring Validation, H2 inMemory db.

Build

    $ ./mvn clean install -Dmaven.test.skip

    $  java -jar target/blogger-service-1.0.2-SNAPSHOT.jar


Curl

-- curl http://localhost:8091/api/accounts/register create account

-- curl http://localhost:8091/api/accounts/1/posts create post

-- curl http://localhost:8091/api/posts/2/comments?author=1 add comment

-- curl http://localhost:8091/api/accounts/1/posts get posts of account

-- curl http://localhost:8091/api/comments/all get comments


Swagger Spec

http://localhost:8091/swagger-ui.html
![swagger2](https://user-images.githubusercontent.com/5726929/66917057-4d216080-f025-11e9-9781-adc29147d71e.JPG)



H2 console

http://localhost:8091/h2-console
![h2console](https://user-images.githubusercontent.com/5726929/66916965-10556980-f025-11e9-9ac4-b0ffa6b238c0.JPG)

Usage


      $ curl POST http://localhost:8091/api/accounts/register create account
    {
      "name": "Chris Richardson',
      "email": "chric@pivotal.com",
      "logo": null,
      "social_network": "twitter"
    }
    
      $ POST http://localhost:8091/api/accounts/1/posts create post
    {
      "name": "Aviation news",
      "slugs": "tech",
      "content": "description",
      "views": 6
    }
    
    $ POST http://localhost:8091/api/posts/1/comments?author=1 add comment
    {
      "content": "Best nice",
      "likeCount": 6
    }


    $ GET http://localhost:8091/api/accounts/1/posts get posts of account

    $ GET http://localhost:8091/api/posts/all

    $ GET http://localhost:8091/api/comments/all get comments
