DROP DATABASE IF EXISTS film;

CREATE TABLE film
(
    Title              VARCHAR(255),
    Release_Year       INT,
    Locations          VARCHAR(255),
    Fun_Facts          VARCHAR(255),
    Production_Company VARCHAR(255),
    Distributor        VARCHAR(255),
    Director           VARCHAR(255),
    Writer             VARCHAR(255),
    Actor_1            VARCHAR(255),
    Actor_2            VARCHAR(255),
    Actor_3            VARCHAR(255)
);

SELECT *
FROM film;

