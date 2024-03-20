CREATE SCHEMA IF NOT EXISTS catalogue;

CREATE TABLE IF NOT EXISTS catalogue.product
(
    id      SERIAL PRIMARY KEY,
    url     VARCHAR(512),
    price   DOUBLE PRECISION,
    title   VARCHAR(50) NOT NULL,
    details VARCHAR(1024)
);
