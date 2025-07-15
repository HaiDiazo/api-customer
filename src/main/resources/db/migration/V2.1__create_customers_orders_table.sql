CREATE TABLE customers (
    id UUID PRIMARY KEY,
    username VARCHAR(100) NOT NULL,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE,
    phone VARCHAR(20),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE products (
    id UUID PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO products (id, name) VALUES ('59763f14-87ff-4a73-9f1e-5b2d798cec23', 'Donat');
INSERT INTO products (id, name) VALUES ('75048fc8-26a3-481b-a7e5-acd408f60c80', 'Telo');

CREATE TABLE orders (
    id UUID PRIMARY KEY,
    customer_id UUID NOT NULL,
    product_id UUID NOT NULL,
    order_date DATE NOT NULL,
    total_amount NUMERIC(12, 2) NOT NULL,
    status VARCHAR(50),

    CONSTRAINT fk_customer
      FOREIGN KEY (customer_id)
      REFERENCES customers(id)
      ON DELETE CASCADE,

    CONSTRAINT fk_product
          FOREIGN KEY (product_id)
          REFERENCES products(id)
          ON DELETE CASCADE
);

