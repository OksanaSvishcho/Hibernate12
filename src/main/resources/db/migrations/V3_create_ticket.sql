CREATE TABLE ticket (
                        id BIGSERIAL PRIMARY KEY,
                        created_at TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
                        client_id BIGINT NOT NULL,
                        from_planet_id VARCHAR(10) NOT NULL,
                        to_planet_id VARCHAR(10) NOT NULL,
                        CONSTRAINT fk_client FOREIGN KEY (client_id) REFERENCES client (id) ON DELETE CASCADE,
                        CONSTRAINT fk_from_planet FOREIGN KEY (from_planet_id) REFERENCES planet (id),
                        CONSTRAINT fk_to_planet FOREIGN KEY (to_planet_id) REFERENCES planet (id),
                        CHECK (from_planet_id <> to_planet_id)
);
