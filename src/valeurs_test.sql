INSERT INTO CATEGORIE( libelle)
VALUES  ('INFORMATIQUE' ),
        ('SPORT & LOISIRS'),
        ('AMEUBLEMENT'),
        ('VÊTEMENT');


INSERT INTO ARTICLE (nom_article,description, date_debut_enchere, date_fin_enchere, prix_de_base, prix_de_vente, vente_en_cours, id_categorie, image_lien)
VALUES
    ('Ballon', 'Ballon signe par Kylian Mbappé', null, null, '100', null, 1, 2, 'ballonKilyan.jpg'),
    ('Canapé', 'Canapé 3 places en cuir', NULL, NULL,'450', NULL, 1, 3, 'canape.jpg'),
    ('Table basse', 'Table basse en bois massif', NULL, NULL, '180', NULL, 1, 3, 'table_basse.jpg'),
    ('Veste', 'Veste en jean taille M', NULL, NULL, '60', NULL, 1, 4, 'veste.jpg'),
    ('Ordinateur portable', 'PC portable i5 16Go RAM', NULL, NULL, '750', NULL, 1, 1, 'ordinateur_portable.jpg'),
    ('Écran', 'Écran 27 pouces Full HD', NULL, NULL, '220', NULL, 1, 1, 'ecran.jpg');
SELECT * FROM ARTICLE
SELECT * FROM CATEGORIE