CREATE TABLE MY_BOOKS
(
    my_books_id     SERIAL      NOT NULL,
    title        VARCHAR(32) NOT NULL,
    author     VARCHAR(64) NOT NULL,
    price       NUMERIC(5,2) NOT NULL,
    PRIMARY KEY (my_books_id)
);