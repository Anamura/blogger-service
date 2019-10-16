DROP TABLE IF EXISTS account CASCADE;
DROP TABLE IF EXISTS post;
DROP TABLE IF EXISTS comment;

CREATE TABLE account(
    id             INT AUTO_INCREMENT,
    name           varchar(255) NOT NULL,
    email          VARCHAR(100) NOT NULL,
    social_network varchar(100) DEFAULT NULL,
    CONSTRAINT account_PK PRIMARY KEY (id)
);

CREATE TABLE post(
    id               INT AUTO_INCREMENT,
    name             VARCHAR(255) NOT NULL,
    slugs            text,
    publication_date TIMESTAMP    NOT NULL,
    content          text,
    views            INT,
    account_id       INT          NOT NULL,
    CONSTRAINT post_PK PRIMARY KEY (id),
    CONSTRAINT post_account_FK FOREIGN KEY (account_id) REFERENCES account (id) on DELETE CASCADE
);

CREATE TABLE comment(
    id            INT AUTO_INCREMENT,
    last_modified TIMESTAMP,
    content       text,
    like_count    INT,
    post_id       INT NOT NULL,
    account_id    INT NOT NULL,
    CONSTRAINT comment_PK PRIMARY KEY (id),
    CONSTRAINT comment_post_FK FOREIGN KEY (post_id) REFERENCES post (id) ON DELETE CASCADE,
    CONSTRAINT post_account_FK FOREIGN KEY (account_id) REFERENCES account (id) on DELETE CASCADE
);

INSERT INTO account(id, name, email, social_network)
VALUES (6789, 'Bill Gates', 'bgate@microsoft.com', 'twitter, facebook'),
       (1234, 'Chris Richardson', 'chric@pivotal.com', 'instagram'),
       (2345, 'Anna Muraveva', 'murava@yandex.ru', 'facebook'),
       (7624, 'John Legend', 'jlegtn@music.com', 'vk.com');


INSERT INTO post(id, content, name, publication_date, slugs, views, account_id)
VALUES (24, 'Your go to source for aviation news and stories. What Will Happen To El Als Boeing 747.',
        'Aviation technology', '2019-10-12', 'Aviation strizhi', 6, 6789),
       (31, 'Modern recipe saving techniques and ideas to preserve your own recipes.', 'Breakfast recipe', '2019-10-06',
        'Home cooking', 2, 1234);

INSERT INTO comment(id, content, like_count, last_modified, account_id, post_id)
VALUES (45, 'Best nice', 6, '2019-10-12', 7624, 24),
       (87, 'cool yes', 4, '2019-09-11', 2345, 31);

