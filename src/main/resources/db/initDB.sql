DROP TABLE IF EXISTS products;

CREATE TABLE products
(
  id INTEGER NOT NULL,
  title VARCHAR NOT NULL,
  description  VARCHAR,
  price INTEGER NOT NULL,
  rating REAL NOT NULL,
  inetPrice INTEGER,
  imageURL VARCHAR,
  image BYTEA,
  base64Encoded VARCHAR,
  views INTEGER
);