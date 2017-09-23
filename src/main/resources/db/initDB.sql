DROP TABLE IF EXISTS products;

CREATE SEQUENCE base_seq START 1;

CREATE TABLE products
(
  baseId INTEGER PRIMARY KEY DEFAULT nextval('base_seq'),
  productId INTEGER NOT NULL,
  title VARCHAR NOT NULL,
  description  VARCHAR,
  price INTEGER NOT NULL,
  rating REAL NOT NULL,
  inetPrice INTEGER,
  imageURL VARCHAR,
/*  image BYTEA,
  base64Encoded VARCHAR,*/
  views INTEGER
);