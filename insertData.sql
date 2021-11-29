USE `lab1_AMT`;

-- INSERTION des Stations
INSERT INTO `Station` (`adresse`)
VALUES ('Rue du lac 6'),
       ('Rue du Milieu 18'),
       ('Route de lausanne 10'),
       ('Rue de l\'industrie 14'),
       ('Rue d\'Orbe 51');

-- INSERTION des Emplacement
INSERT INTO `Emplacement`(`id`, `station_id`)
VALUES (1, 1),
       (2, 1),
       (3, 1),
       (4, 1),
       (5, 1),
       (6, 1),
       (7, 1),
       (8, 1),
       (9, 1),
       (10, 1),
       (11, 1),
       (12, 1),
       (13, 1),
       (14, 1),
       (15, 1),
       (16, 1),
       (1, 2),
       (2, 2),
       (3, 2),
       (4, 2),
       (5, 2),
       (6, 2),
       (7, 2),
       (8, 2),
       (9, 2),
       (10, 2),
       (1, 3),
       (2, 3),
       (3, 3),
       (4, 3),
       (5, 3),
       (6, 3),
       (7, 3),
       (8, 3),
       (9, 3),
       (10, 3),
       (11, 3),
       (12, 3),
       (13, 3),
       (14, 3),
       (15, 3),
       (16, 3),
       (17, 3),
       (18, 3),
       (1, 4),
       (2, 4),
       (3, 4),
       (4, 4),
       (5, 4),
       (6, 4),
       (7, 4),
       (8, 4),
       (9, 4),
       (10, 4),
       (11, 4),
       (12, 4),
       (13, 4),
       (14, 4),
       (1, 5),
       (2, 5),
       (3, 5),
       (4, 5),
       (5, 5),
       (6, 5),
       (7, 5),
       (8, 5),
       (9, 5),
       (10, 5),
       (11, 5),
       (12, 5),
       (13, 5),
       (14, 5),
       (15, 5),
       (16, 5),
       (17, 5),
       (18, 5),
       (19, 5),
       (20, 5);


-- INSERTION des prix de location
INSERT INTO Prix(categorie, prix1, prix2, prix3)
VALUES ('BERLINE', 2.95, 2.60, 2.30),
       ('MOTO', 1.70, 1.50, 1.50),
       ('FOURGON', 3.60, 3.00, 2.80);


-- INSERTION des Véhicules
INSERT INTO Vehicule (matricule, emplacement_id, station_id, categorie)
VALUES ('VD 364 263', 1, 1, 'MOTO'),
       ('VD 536 245', 2, 1, 'BERLINE'),
       ('VD 873 422', 3, 1, 'BERLINE'),
       ('VD 969 142', 4, 1, 'MOTO'),
       ('VD 153 758', 5, 1, 'FOURGON'),
       ('VD 542 436', 1, 2, 'BERLINE'),
       ('VD 211 738', 2, 2, 'BERLINE'),
       ('VD 532 374', 3, 2, 'BERLINE'),
       ('VD 645 555', 4, 2, 'MOTO'),
       ('VD 786 588', 5, 2, 'MOTO'),
       ('VD 873 041', 6, 2, 'MOTO'),
       ('VD 176 591', 7, 2, 'FOURGON'),
       ('VD 793 272', 8, 2, 'FOURGON'),
       ('VD 635 242', 13, 3, 'BERLINE'),
       ('VD 436 502', 14, 3, 'BERLINE'),
       ('VD 825 332', 15, 3, 'MOTO'),
       ('VD 645 322', 16, 3, 'FOURGON'),
       ('VD 245 153', 17, 3, 'FOURGON'),
       ('VD 421 482', 18, 3, 'FOURGON'),
       ('VD 587 428', 9, 4, 'BERLINE'),
       ('VD 921 351', 10, 4, 'MOTO'),
       ('VD 921 118', 11, 4, 'BERLINE'),
       ('VD 268 402', 12, 4, 'FOURGON'),
       ('VD 008 276', 13, 4, 'FOURGON'),
       ('VD 241 522', 14, 4, 'BERLINE'),
       ('VD 291 853', 6, 5, 'BERLINE'),
       ('VD 458 635', 12, 5, 'FOURGON'),
       ('VD 426 529', 7, 5, 'BERLINE'),
       ('VD 652 288', 8, 5, 'MOTO'),
       ('VD 425 321', 9, 5, 'MOTO'),
       ('VD 577 929', 10, 5, 'FOURGON'),
       ('VD 894 303', 5, 5, 'FOURGON'),
       ('VD 318 843', 14, 1, 'FOURGON'),
       ('VD 894 263 ', 15, 1, 'BERLINE'),
       ('VD 436 508 ', 16, 1, 'BERLINE');


-- INSERTION des Utilisateurs
INSERT INTO Utilisateur (login, password)
VALUES ('Warren', MD5('AMT123')),
       ('Boris', MD5('AMTabc')),
       ('Jessamine', MD5('AMTABC')),
       ('Rowan', MD5('AMTAbc')),
       ('Chava', MD5('AMTaBC'));

-- INSERTION des Trajet
INSERT INTO Trajet (id, vehicule_id, destination_emplacement_id, destination_Station_id, duree, prix)
VALUES (1, 1, 1, 5, NULL, NULL),
       (2, 12, 7, 2, NULL, NULL), -- Voiture qui revient à son emplacement de départ
       (3, 6, 7, 4, 154, 79.80);


-- INSERTION des Client
INSERT INTO Client (utilisateur_id, trajet_id, solde)
VALUES (2, 2, 0.0),
       (3, 1, 25.0),
       (5, 3, 8.80);


-- INSERTION des administrateurs
INSERT INTO Administrateur (utilisateur_id)
VALUES (1),
       (4);

