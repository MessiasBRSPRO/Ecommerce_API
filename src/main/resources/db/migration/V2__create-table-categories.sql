CREATE TABLE categories(
    id SERIAL PRIMARY KEY,
    category_name VARCHAR(125) NOT NULL UNIQUE
);