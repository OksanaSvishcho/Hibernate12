CREATE TABLE Client (
                        id SERIAL PRIMARY KEY,
                        name VARCHAR(200) NOT NULL CHECK (LENGTH(name) BETWEEN 3 AND 200)
);

