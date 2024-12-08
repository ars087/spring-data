INSERT INTO user_one (name, email)
VALUES ('Alice', 'alice@example.com'),
       ('Bob', 'bob@example.com'),
       ('Charlie', 'charlie@example.com');


INSERT INTO order_user (product, amount, status, user_id)
VALUES ('Laptop', 999.99, 'Shipped', 1),
       ('Smartphone', 499.99, 'Pending', 1),
       ('Tablet', 299.99, 'Delivered', 2),
       ('Headphones', 199.99, 'Cancelled', 3),
       ('Smartwatch', 249.99, 'Pending', 3);