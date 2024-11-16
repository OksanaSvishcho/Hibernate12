INSERT INTO client (name) VALUES ('John Doe'), ('Jane Smith'), ('Alice Johnson'),
                                 ('Bob Brown'), ('Eve White'), ('Charlie Black'), ('David Gray'), ('Emma Green'),
                                 ('Frank Blue'), ('Grace Yellow');

INSERT INTO planet (id, name) VALUES
                                  ('MARS', 'Mars'),
                                  ('VEN', 'Venus'),
                                  ('EARTH', 'Earth'),
                                  ('JUP', 'Jupiter'),
                                  ('SAT', 'Saturn');

INSERT INTO ticket (client_id, from_planet_id, to_planet_id) VALUES
                                                                 (1, 'EARTH', 'MARS'),
                                                                 (2, 'MARS', 'VEN'),
                                                                 (3, 'VEN', 'EARTH'),
                                                                 (4, 'EARTH', 'JUP'),
                                                                 (5, 'JUP', 'SAT'),
                                                                 (6, 'SAT', 'EARTH'),
                                                                 (7, 'EARTH', 'VEN'),
                                                                 (8, 'MARS', 'JUP'),
                                                                 (9, 'SAT', 'MARS'),
                                                                 (10, 'VEN', 'EARTH');
