INSERT INTO artists VALUES (1,'Chadwick, Lynn','female'),(2,'Ono, Yoko','female'),(3,'Opie, Julian','male'),(4,'Etty, William','male'),(5,'Wallis, Henry','male');

INSERT INTO movements VALUES (1,'Geometry of Fear'),(2,'Kinetic Art'),(3,'New British Sculpture'),(4,'Romanticism');

INSERT INTO artist_movements VALUES (1,1),(1,2),(3,3),(4,4),(5,4);

INSERT INTO users (id, username, password, enabled) VALUES (1, 'admin', 'password', 1);
INSERT INTO authorities (id, username, authority) VALUES (1, 'admin', 'ROLE_ADMIN');

INSERT INTO users (id, username, password, enabled) VALUES (2, 'manager', 'password2', 1);
INSERT INTO authorities (id, username, authority) VALUES (2, 'manager', 'ROLE_USER');
INSERT INTO authorities (id, username, authority) VALUES (3, 'manager', 'ROLE_MANAGER');