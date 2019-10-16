Реализация RESTfull бэкенда для сайта "блогов".

На сайте можно:
1. Взаимодействовать с аккаунтом. Аккаунт может иметь много постов и комментов.
2. Взаимодействовать с постами. Пост может иметь много комментариев и одного автора.
3. Комментировать посты. Комментарий имеет одного автора и привязан к одному посту.

Желательно использовать следующие технологии:
1. Spring Boot
2. Lombok
3. Spring Data (JPA2.1/Specifications, касательно N+1 join fetch)
4. Spring Validation https://habr.com/ru/post/424819/
5. H2 база в памяти, создаваемая при старте приложения из DDL

Для окружения:
1. Живой сервер и присланные нам исполняемые curl запросы помимо голого кода на github
2. Swagger спецификация.

How to build:

mvn install -Dmaven.test.skip
java -jar target/blogger-service-1.0.2-SNAPSHOT.jar

H2 console http://localhost:8091/h2-console
Swagger http://localhost:8091/swagger-ui.html#/account-web-api


-- curl http://localhost:8091/api/accounts/6789/posts create post
-- curl http://localhost:8091/api/posts/1/comments add comment
-- curl http://localhost:8091/api/posts/all get posts
-- curl http://localhost:8091/api/accounts/1234/posts get posts of account
-- curl http://localhost:8091/api/comments/all get comments

JPA Query output

select post0_.id                as id1_2_0_,
       comments1_.id            as id1_1_1_,
       post0_.content           as content2_2_0_,
       post0_.name              as name3_2_0_,
       post0_.account_id        as account_7_2_0_,
       post0_.publication_date  as publicat4_2_0_,
       post0_.slugs             as slugs5_2_0_,
       post0_.views             as views6_2_0_,
       comments1_.content       as content2_1_1_,
       comments1_.last_modified as last_mod3_1_1_,
       comments1_.like_count    as like_cou4_1_1_,
       comments1_.account_id    as account_5_1_1_,
       comments1_.post_id       as post_id6_1_1_,
       comments1_.post_id       as post_id6_1_0__,
       comments1_.id            as id1_1_0__
from
     post post0_
         left outer join
    comment comments1_
    on
        post0_.id = comments1_.post_id
where
      post0_.account_id = ?
order by
    post0_.publication_date desc;


select
    characteri0_.id as id1_4_0_,
    item1_.id as id1_10_1_,
    characteri0_.item_id as item_id3_4_0_,
    characteri0_.type as type2_4_0_,
    item1_.name as name2_10_1_
from
    characteristic characteri0_
        left outer join
    item item1_
    on
            characteri0_.item_id=item1_.id
where
        characteri0_.type=?



RequestSystem works under 500 requests per second load in _real_ time (meaning that request execution delay cannot be queued indefinitely). 
Requests with the same client executed sequentially. Sometimes a request will be duplicated. Duplicated requests (request with the same request id)
will only appear on 20 seconds windows. If duplicated request are received, just execute the first one.
*The method _execute_ on the interface RequestService returns a CompletableFuture for each request.

MetricsCollector.log output

2016-12-23 05:04:21 DEBUG RequestExecutor:40 - Execution complete Request: 2016-12-23T02:04:20.947Z clientId: 73047 requestId: 5341566c-ec40-4550-8f25-9bddd28110e4
2016-12-23 05:04:21 DEBUG RequestExecutor:36 - Executing Request: 2016-12-23T02:04:20.947Z clientId: 975862 requestId: bb55e6c5-46e5-4413-bcb0-b58c247c8ce8
2016-12-23 05:04:21 DEBUG RequestExecutor:36 - Executing Request: 2016-12-23T02:04:20.947Z clientId: 485865 requestId: 5e13e7ac-4f2a-4c65-b16e-e75af14a60f6
2016-12-23 05:04:21 DEBUG RequestExecutor:40 - Execution complete Request: 2016-12-23T02:04:20.947Z clientId: 156988 requestId: 28ea13ef-42ff-4eca-9252-b9346b02395c

2016-12-23 05:06:43 WARN  OCCRequestResolver:54 - Concurrency control issue: Deducted duplicate request id of the client 6624


23.12.16 5:04:21 ===============================================================
service-latency
             count = 6497
         mean rate = 487,81 calls/second
     1-minute rate = 472,02 calls/second
     5-minute rate = 470,26 calls/second
    15-minute rate = 469,95 calls/second
               min = 0,00 milliseconds
               max = 113,00 milliseconds
              mean = 32,26 milliseconds
            stddev = 20,14 milliseconds
            median = 32,00 milliseconds
              75% <= 49,00 milliseconds
              95% <= 62,00 milliseconds
              98% <= 67,00 milliseconds
              99% <= 71,00 milliseconds
            99.9% <= 107,00 milliseconds
	
queue value = 345
	cacheSize value = 697
	
duplicates
             count = 3
         mean rate = 0,23 events/second

		 
mvn findbugs:findbugs
mvn findbugs:gui
mvn clean install