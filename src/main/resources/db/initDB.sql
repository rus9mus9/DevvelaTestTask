DROP TABLE IF EXISTS products;
DROP SEQUENCE IF EXISTS base_seq;

CREATE SEQUENCE base_seq START 1;

CREATE TABLE products
(
  baseId INTEGER PRIMARY KEY DEFAULT nextval('base_seq'),
  productId INTEGER NOT NULL,
  title VARCHAR NOT NULL,
  description  VARCHAR,
  price INTEGER NOT NULL,
  rating NUMERIC NOT NULL,
  inetPrice INTEGER,
  imageURL VARCHAR,
  views INTEGER
);