
INSERT INTO UTILISATEUR(pseudo, nom, prenom, email, password, telephone, adresse, code_postal, ville, credit, administrateur, actif)
VALUES ('SuperVendeur', 'Super', 'Vendeur', 'supervendeur@vente.com', 'JADOREVENDRE', '06 66 66 66 66', '15 rue des Vendeurs', '50000', 'VenteVille', 500, 0, 1);



INSERT INTO CATEGORIE( libelle)
VALUES  ('INFORMATIQUE' ),
        ('SPORT & LOISIRS'),
        ('AMEUBLEMENT'),
        ('VÊTEMENT');


INSERT INTO ARTICLE (nom_article,description, date_debut_enchere, date_fin_enchere, prix_de_base, prix_de_vente, vente_en_cours, id_categorie, image_lien, id_utilisateur)
VALUES
    ('Ballon', 'Ballon signe par Kylian Mbappé', null, null, '100', null, 1, 2, 'ballonKilyan.jpg', 1),
    ('Canapé', 'Canapé 3 places en cuir', NULL, NULL,'450', NULL, 1, 3, 'canape.jpg', 1),
    ('Table basse', 'Table basse en bois massif', NULL, NULL, '180', NULL, 1, 3, 'table_basse.jpg', 1),
    ('Veste', 'Veste en jean taille M', NULL, NULL, '60', NULL, 1, 4, 'veste.jpg', 1),
    ('Ordinateur portable', 'PC portable i5 16Go RAM', NULL, NULL, '750', NULL, 1, 1, 'ordinateur_portable.jpg', 1),
    ('Écran', 'Écran 27 pouces Full HD', NULL, NULL, '220', NULL, 1, 1, 'ecran.jpg', 1);

SELECT * FROM ARTICLE
SELECT * FROM CATEGORIE

SELECT * FROM ARTICLE WHERE ARTICLE.nom_article LIKE '%a%'

-- selectionnne article avec categorie et vendeur
select id_article,
       nom_article,
       description,
       date_debut_enchere,
       date_fin_enchere,
       prix_de_base,
       prix_de_vente,
       vente_en_cours,
       image_lien,
       ARTICLE.id_categorie,
       libelle AS 'categorie',
       UTILISATEUR.id_utilisateur AS 'id_vendeur',
       pseudo  AS 'vendeur'
from ARTICLE
left join CATEGORIE on ARTICLE.id_categorie = CATEGORIE.id_categorie
left join UTILISATEUR on ARTICLE.id_utilisateur = UTILISATEUR.id_utilisateur;

SELECT * FROM UTILISATEUR