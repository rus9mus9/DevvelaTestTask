DROP TABLE IF EXISTS products;

CREATE TABLE products
(
  id INTEGER NOT NULL,
  title VARCHAR NOT NULL,
  description VARCHAR NOT NULL,
  price INTEGER NOT NULL,
  rating REAL NOT NULL,
  inetPrice INTEGER,
  image BYTEA,
  views INTEGER
);