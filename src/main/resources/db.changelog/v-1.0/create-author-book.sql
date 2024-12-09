CREATE TABLE author (
                        id SERIAL PRIMARY KEY,
                        name VARCHAR(100) NOT NULL
);

CREATE TABLE book (
                      id SERIAL PRIMARY KEY,
                      title VARCHAR(255) NOT NULL,
                      genre VARCHAR(100),
                      author_id INT NOT NULL,
                      FOREIGN KEY (author_id) REFERENCES author(id)
);