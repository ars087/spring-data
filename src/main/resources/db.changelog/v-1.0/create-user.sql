CREATE TABLE user_one
(
    id    SERIAL PRIMARY KEY,
    name  VARCHAR(100)        NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL

);


CREATE TABLE order_user
(
    id      SERIAL PRIMARY KEY,
    product VARCHAR(100)   NOT NULL,
    amount  DECIMAL(10, 2) NOT NULL,
    status  VARCHAR(50)    NOT NULL,
    user_id INT            NOT NULL,
    FOREIGN KEY (user_id) REFERENCES user_one (id)
);