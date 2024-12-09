CREATE TABLE customers (
                           customer_id SERIAL PRIMARY KEY,
                           first_name VARCHAR(255) NOT NULL,
                           last_name VARCHAR(255) NOT NULL,
                           email VARCHAR(255) NOT NULL UNIQUE,
                           contact_number VARCHAR(50)
);

CREATE TABLE products (
                          product_id SERIAL PRIMARY KEY,
                          name VARCHAR(255) NOT NULL,
                          description TEXT,
                          price NUMERIC(10, 2) NOT NULL,
                          quantity_in_stock INTEGER NOT NULL
);
CREATE TABLE orders (
                        order_id SERIAL PRIMARY KEY,
                        customer_id INTEGER NOT NULL,
                        order_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                        shipping_address TEXT NOT NULL,
                        total_price NUMERIC(10, 2),
                        order_status VARCHAR(50),
                        FOREIGN KEY (customer_id) REFERENCES customers(customer_id) ON DELETE CASCADE
);
CREATE TABLE order_product (
                               order_id INTEGER NOT NULL,
                               product_id INTEGER NOT NULL,
                               PRIMARY KEY (order_id, product_id),
                               FOREIGN KEY (order_id) REFERENCES orders(order_id) ON DELETE CASCADE,
                               FOREIGN KEY (product_id) REFERENCES products(product_id) ON DELETE CASCADE
);