CREATE TABLE Ticket (
                        id SERIAL PRIMARY KEY,
                        created_at TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
                        client_id INT NOT NULL,
                        from_planet_id VARCHAR(10) NOT NULL,
                        to_planet_id VARCHAR(10) NOT NULL,
                        FOREIGN KEY (client_id) REFERENCES Client(id) ON DELETE CASCADE,
                        FOREIGN KEY (from_planet_id) REFERENCES Planet(id),
                        FOREIGN KEY (to_planet_id) REFERENCES Planet(id),
                        CHECK (from_planet_id <> to_planet_id)
);
