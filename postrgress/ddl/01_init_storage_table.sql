CREATE SCHEMA IF NOT EXIST storage;

CREATE TABLE IF NOT EXISTS labs.storage
(
    divisible numeric NOT NULL,
    divisor numeric NOT NULL,
    total bigint NOT NULL,
    remains bigint NOT NULL,
    CONSTRAINT pk PRIMARY KEY (divisible, divisor)
);