INSERT INTO CATEGORIE( libelle)
VALUES  ('INFORMATIQUE' ),
        ('SPORT & LOISIRS'),
        ('AMEUBLEMENT'),
        ('VÊTEMENT');

INSERT INTO ARTICLE (nom_article,description, date_debut_enchere, date_fin_enchere, prix_de_base, prix_de_vente, vente_en_cours, id_categorie)
VALUES
    ('Ballon', 'Ballon signe par Kylian Mbappé', NULL, null, '100', null, 1, 2),
    ('Canapé', 'Canapé 3 places en cuir', NULL, NULL,'450', NULL, 1, 3),
    ('Table basse', 'Table basse en bois massif', NULL, NULL, '180', NULL, 1, 3),
    ('Veste', 'Veste en jean taille M', NULL, NULL, '60', NULL, 1, 4),
    ('Ordinateur portable', 'PC portable i5 16Go RAM', NULL, NULL, '750', NULL, 1, 1),
    ('Écran', 'Écran 27 pouces Full HD', NULL, NULL, '220', NULL, 1, 1);

SELECT * FROM ARTICLE
SELECT * FROM CATEGORIE