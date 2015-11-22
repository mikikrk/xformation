INSERT INTO CUISINE (name) VALUES ('Polish');
INSERT INTO CUISINE (name) VALUES ('Italian');
INSERT INTO CUISINE (name) VALUES ('Mexican');

INSERT INTO DISH (name, description, price, type) VALUES ('Schabowy', 'Pork chop with potatos', 24.99, 0);
INSERT INTO CUISINE_DISH (cuisine_id, dish_id) VALUES ((SELECT cuisine_id FROM CUISINE WHERE name='Polish'), (SELECT currval('dish_dish_id_seq')));

INSERT INTO DISH (name, description, price, type) VALUES ('Pierogi ruskie', 'Dumplings with potatoes', 6.24, 0);
INSERT INTO CUISINE_DISH (cuisine_id, dish_id) VALUES ((SELECT cuisine_id FROM CUISINE WHERE name='Polish'), (SELECT currval('dish_dish_id_seq')));

INSERT INTO DISH (name, description, price, type) VALUES ('Bigos', 'Mix of pork and vegatables in tomato sauce', 8.90, 0);
INSERT INTO CUISINE_DISH (cuisine_id, dish_id) VALUES ((SELECT cuisine_id FROM CUISINE WHERE name='Polish'), (SELECT currval('dish_dish_id_seq')));

INSERT INTO DISH (name, description, price, type) VALUES ('Spaghetti Bolognese', 'Pasta with meat in tomato sauce', 15.00, 0);
INSERT INTO CUISINE_DISH (cuisine_id, dish_id) VALUES ((SELECT cuisine_id FROM CUISINE WHERE name='Italian'), (SELECT currval('dish_dish_id_seq')));

INSERT INTO DISH (name, description, price, type) VALUES ('Lasagna', 'Flat pasta with meat', 14.20, 0);
INSERT INTO CUISINE_DISH (cuisine_id, dish_id) VALUES ((SELECT cuisine_id FROM CUISINE WHERE name='Italian'), (SELECT currval('dish_dish_id_seq')));

INSERT INTO DISH (name, description, price, type) VALUES ('Pizza Margarita', 'Simple pizza', 25.63, 0);
INSERT INTO CUISINE_DISH (cuisine_id, dish_id) VALUES ((SELECT cuisine_id FROM CUISINE WHERE name='Italian'), (SELECT currval('dish_dish_id_seq')));

INSERT INTO DISH (name, description, price, type) VALUES ('Chili con carne', 'Really hot stuff', 16.32, 0);
INSERT INTO CUISINE_DISH (cuisine_id, dish_id) VALUES ((SELECT cuisine_id FROM CUISINE WHERE name='Mexican'), (SELECT currval('dish_dish_id_seq')));

INSERT INTO DISH (name, description, price, type) VALUES ('Quasadilla', 'Mixed meat and vegetables between 2 tortillas', 19.00, 0);
INSERT INTO CUISINE_DISH (cuisine_id, dish_id) VALUES ((SELECT cuisine_id FROM CUISINE WHERE name='Mexican'), (SELECT currval('dish_dish_id_seq')));

INSERT INTO DISH (name, description, price, type) VALUES ('Burrito', 'Mixed meat and vegetables in 1 tortilla', 16.33, 0);
INSERT INTO CUISINE_DISH (cuisine_id, dish_id) VALUES ((SELECT cuisine_id FROM CUISINE WHERE name='Mexican'), (SELECT currval('dish_dish_id_seq')));

INSERT INTO DISH (name, description, price, type) VALUES ('Ice cream', 'Ice cream in 20 flavours', 10.00, 1);
INSERT INTO CUISINE_DISH (cuisine_id, dish_id) VALUES ((SELECT cuisine_id FROM CUISINE WHERE name='Polish'), (SELECT currval('dish_dish_id_seq')));
INSERT INTO CUISINE_DISH (cuisine_id, dish_id) VALUES ((SELECT cuisine_id FROM CUISINE WHERE name='Italian'), (SELECT currval('dish_dish_id_seq')));

INSERT INTO DISH (name, description, price, type) VALUES ('Makaron z serem i cukrem', 'Pasta with white cheese and sugar', 3.99, 1);
INSERT INTO CUISINE_DISH (cuisine_id, dish_id) VALUES ((SELECT cuisine_id FROM CUISINE WHERE name='Polish'), (SELECT currval('dish_dish_id_seq')));

INSERT INTO DISH (name, description, price, type) VALUES ('Cheese cake', 'As above', 5.99, 1);
INSERT INTO CUISINE_DISH (cuisine_id, dish_id) VALUES ((SELECT cuisine_id FROM CUISINE WHERE name='Polish'), (SELECT currval('dish_dish_id_seq')));
INSERT INTO CUISINE_DISH (cuisine_id, dish_id) VALUES ((SELECT cuisine_id FROM CUISINE WHERE name='Mexican'), (SELECT currval('dish_dish_id_seq')));

INSERT INTO DISH (name, description, price, type) VALUES ('Tiramisu', 'Coffe cake', 5.00, 1);
INSERT INTO CUISINE_DISH (cuisine_id, dish_id) VALUES ((SELECT cuisine_id FROM CUISINE WHERE name='Italian'), (SELECT currval('dish_dish_id_seq')));

INSERT INTO DISH (name, description, price, type) VALUES ('Churros', 'Fried-dough pastry', 6.50, 1);
INSERT INTO CUISINE_DISH (cuisine_id, dish_id) VALUES ((SELECT cuisine_id FROM CUISINE WHERE name='Mexican'), (SELECT currval('dish_dish_id_seq')));

INSERT INTO DISH (name, description, price, type) VALUES ('Beer', 'Gold drink', 5.00, 2);
INSERT INTO CUISINE_DISH (cuisine_id, dish_id) VALUES ((SELECT cuisine_id FROM CUISINE WHERE name='Polish'), (SELECT currval('dish_dish_id_seq')));
INSERT INTO CUISINE_DISH (cuisine_id, dish_id) VALUES ((SELECT cuisine_id FROM CUISINE WHERE name='Italian'), (SELECT currval('dish_dish_id_seq')));
INSERT INTO CUISINE_DISH (cuisine_id, dish_id) VALUES ((SELECT cuisine_id FROM CUISINE WHERE name='Mexican'), (SELECT currval('dish_dish_id_seq')));

INSERT INTO DISH (name, description, price, type) VALUES ('Coffee', 'Dark drink', 6.00, 2);
INSERT INTO CUISINE_DISH (cuisine_id, dish_id) VALUES ((SELECT cuisine_id FROM CUISINE WHERE name='Polish'), (SELECT currval('dish_dish_id_seq')));
INSERT INTO CUISINE_DISH (cuisine_id, dish_id) VALUES ((SELECT cuisine_id FROM CUISINE WHERE name='Italian'), (SELECT currval('dish_dish_id_seq')));
INSERT INTO CUISINE_DISH (cuisine_id, dish_id) VALUES ((SELECT cuisine_id FROM CUISINE WHERE name='Mexican'), (SELECT currval('dish_dish_id_seq')));

INSERT INTO DISH (name, description, price, type) VALUES ('Wine', 'Grapes juice', 10.89, 2);
INSERT INTO CUISINE_DISH (cuisine_id, dish_id) VALUES ((SELECT cuisine_id FROM CUISINE WHERE name='Italian'), (SELECT currval('dish_dish_id_seq')));
INSERT INTO CUISINE_DISH (cuisine_id, dish_id) VALUES ((SELECT cuisine_id FROM CUISINE WHERE name='Mexican'), (SELECT currval('dish_dish_id_seq')));

INSERT INTO DISH (name, description, price, type) VALUES ('Sangria', 'Gas wine', 1.25, 2);
INSERT INTO CUISINE_DISH (cuisine_id, dish_id) VALUES ((SELECT cuisine_id FROM CUISINE WHERE name='Mexican'), (SELECT currval('dish_dish_id_seq')));