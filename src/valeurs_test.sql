
INSERT INTO UTILISATEUR(pseudo, nom, prenom, email, password, telephone, adresse, code_postal, ville, credit, administrateur, actif)
VALUES ('SuperVendeur', 'Super', 'Vendeur', 'supervendeur@vente.com', 'JADOREVENDRE', '06 66 66 66 66', '15 rue des Vendeurs', '50000', 'VenteVille', 500, 0, 1);



INSERT INTO CATEGORIE(libelle, image_categorie)
VALUES  ('INFORMATIQUE','informatique.jpg'),
        ('SPORT & LOISIRS','sport&loisirs.jpg'),
        ('AMEUBLEMENT', 'ameublement.jpg'),
        ('VÊTEMENT','vetement.jpg');



INSERT INTO ARTICLE (nom_article,description, date_debut_enchere, date_fin_enchere, prix_de_base, prix_de_vente, vente_en_cours, id_categorie, image_lien, id_utilisateur)
VALUES
    ('Ballon', 'Ballon signe par Kylian Mbappé', '2026-02-02', '2026-02-12', '100', 300, 1, 2, 'ballonKilyan.jpg', 1),
    ('Canapé', 'Canapé 3 places en cuir', '2026-02-02', '2026-02-12','450', 750, 1, 3, 'canape.jpg', 1),
    ('Table basse', 'Table basse en bois massif', '2026-02-02', '2026-02-12', '180', 500, 1, 3, 'table_basse.jpg', 1),
    ('Veste', 'Veste en jean taille M', '2026-02-02', '2026-02-12', '60', 200, 1, 4, 'veste.jpg', 1),
    ('Ordinateur portable', 'PC portable i5 16Go RAM', '2026-02-02', '2026-02-12', '750', 700, 1, 1, 'ordinateur_portable.jpg', 1),
    ('Écran', 'Écran 27 pouces Full HD', '2026-02-02', '2026-02-12', '220', 600, 1, 1, 'ecran.jpg', 1);
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
left join UTILISATEUR on ARTICLE.id_utilisateur = UTILISATEUR.id_utilisateur
WHERE libelle = 'INFORMATIQUE';

SELECT * FROM UTILISATEUR

SELECT * FROM ARTICLE