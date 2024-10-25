CREATE TABLE Planet (
                        id VARCHAR(10) PRIMARY KEY CHECK (id ~ '^[A-Z0-9]+$'),
                        name VARCHAR(500) NOT NULL CHECK (LENGTH(name) BETWEEN 1 AND 500)
);
