CREATE TABLE BOOK
(
    book_id     SERIAL      NOT NULL,
    title        VARCHAR(32) NOT NULL,
    author     VARCHAR(64) NOT NULL,
    price       NUMERIC(5,2) NOT NULL,
    PRIMARY KEY (book_id)
);