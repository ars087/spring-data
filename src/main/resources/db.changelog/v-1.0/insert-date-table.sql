INSERT INTO customers (first_name, last_name, email, contact_number)
VALUES ('Иван', 'Иванов', 'ivan.ivanov@example.com', '123-456-7890'),
       ('Мария', 'Петрова', 'maria.petrova@example.com', '098-765-4321'),
       ('Алексей', 'Сидоров', 'alexey.sidorov@example.com', '555-444-3333');

INSERT INTO products (name, description, price, quantity_in_stock)
VALUES ('Утюг', 'Современный утюг с парогенератором', 19.99, 100),
       ('Чайник', 'Электрический чайник на 1,5 литра', 29.99, 50),
       ('Блендер', 'Мощный блендер для смузи', 9.99, 200);


INSERT INTO orders (customer_id, order_date, shipping_address, total_price, order_status)
VALUES (1, '2024-01-01 10:00:00', 'Красивая улица, 123', 49.98, 'Доставлен'),
       (2, '2024-01-02 14:30:00', 'Улица Ленина, 456', 19.99, 'В ожидании'),
       (1, '2024-01-03 09:15:00', 'Красивая улица, 123', 9.99, 'Доставлен');


INSERT INTO order_product (order_id, product_id)
VALUES (1, 1),
       (1, 2),
       (2, 1),
       (3, 3);