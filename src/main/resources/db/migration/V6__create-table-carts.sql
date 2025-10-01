CREATE TABLE carts (
    id SERIAL PRIMARY KEY,
    customer_id BIGINT NOT NULL UNIQUE,
    CONSTRAINT fk_cart_customer FOREIGN KEY (customer_id) REFERENCES customers(id) ON DELETE CASCADE
);
