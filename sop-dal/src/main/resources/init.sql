INSERT INTO system_user_details VALUES(1,'76a8c4d720068979c22ca11461608fbed2f65f34606dfe92ba5cc8729b8de04065cb8c91f936e398','ADMIN');
INSERT INTO system_user_details VALUES(2,'9f44c7d5a7130a1b4de2e5f72b79e3f8d59928eb62dc1e15156114bb269d1afd9cc3ccca71ff8361','COURIER');
INSERT INTO system_user_details VALUES(3,'16983e62aff7e5244dcacec8e2e1b1ec6212c1d57e5145549d362f126f33d0720f7731a3e965f984','COURIER');
INSERT INTO system_user_details VALUES(4,'16983e62aff7e5244dcacec8e2e1b1ec6212c1d57e5145549d362f126f33d0720f7731a3e965f984','CUSTOMER');INSERT INTO system_user_details VALUES(5,'16983e62aff7e5244dcacec8e2e1b1ec6212c1d57e5145549d362f126f33d0720f7731a3e965f984','CUSTOMER');

INSERT INTO app_user VALUES(1, 'admin@mail.com', 1);
INSERT INTO app_user VALUES(2, 'courier1@mail.com', 2);
INSERT INTO app_user VALUES(3, 'courier2@mail.com', 3);
INSERT INTO app_user VALUES(4, 'customer1@mail.com', 4);
INSERT INTO app_user VALUES(5, 'customer2@mail.com', 5);

INSERT INTO restaurant VALUES(1, 30, 'Buena Vista');
INSERT INTO restaurant VALUES(2, 40, 'MammaMia');
INSERT INTO restaurant VALUES(3, 35, 'Restaurant Oscar');

INSERT INTO product VALUES(1, 'Pizza MammaMia', 'broccoli, branza cu mucegai, sos, măsline verzi, ardei copţi, brie, aluat, cascaval',30, 2, 200);
INSERT INTO product VALUES(2, 'Pizza Margerita', 'cascaval, sos, aluat', 25, 2, 500);
INSERT INTO product VALUES(3, 'Pulpe de pui la gratar', 'pulpe de pui, condimente', 17,  2, 412);
INSERT INTO product VALUES(4, 'Cartofi la cuptor', 'cartofi curatati, condimente', 8,2,420);
INSERT INTO product VALUES(5, 'Meniu traditional', 'cartofi curatati si prajiti in house, patrunjel proaspat, sos de smantâna cu usturoi si marar, salata de castraveti cu marar', 40, 3,235);
INSERT INTO product VALUES(6, 'Meniu costite', 'costite de porc, ceapa, faina, condimente, cartofi wedge', 37, 3,331);
INSERT INTO product VALUES(7, 'Supa crema', 'dovlecei, branza de capra, ceapa, lapte, ou, smantana, verdeata, crutoane', 15, 1,127);
INSERT INTO product VALUES(8, 'Tigaie de pui', 'pui, rosii , ardei gras, aeapa, sos iute',  22, 1,500);
INSERT INTO product VALUES(9, 'Tigaie de porc', 'porc, rosii , ardei gras, aeapa, sos iute',  24, 1,224);

INSERT INTO order_details VALUES(1, 'str. Stefan cel Mare, nr. 4', 44, 4, 2, 'PENDING');
INSERT INTO order_details VALUES(2, 'str. Ioan Cuza, nr. 24', 52, 5, 2, 'DELIVERED');
INSERT INTO order_details VALUES(3, 'bd. Primaverii, nr. 3', 48, 4, 3, 'DELIVERING');
INSERT INTO order_details VALUES(4, 'bd. Tudor Vladimirescu, nr. 32', 42, 5, 2, 'DELIVERING');
INSERT INTO order_details VALUES(5, 'str. Manta Rosie, nr. 22', 82, 4, 3, 'PENDING');

INSERT INTO order_product VALUES(1, 2);
INSERT INTO order_product VALUES(1, 1);
INSERT INTO order_product VALUES(2, 5);
INSERT INTO order_product VALUES(3, 7);
INSERT INTO order_product VALUES(3, 9);
INSERT INTO order_product VALUES(4, 5);
INSERT INTO order_product VALUES(5, 3);
INSERT INTO order_product VALUES(5, 1);

