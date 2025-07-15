CREATE TABLE tb_orders (
    id UUID PRIMARY KEY,
    customer_id UUID NOT NULL,
    order_name TEXT,
    order_date DATE NOT NULL,
    total_amount INTEGER,
    status VARCHAR(50),

    CONSTRAINT fk_customer
      FOREIGN KEY (customer_id)
      REFERENCES customers(id)
      ON DELETE CASCADE
);