/*Créer manuellement dans SSMS la table projet_enchere*/

--CREATE DATABASE projet_enchere;
--GO

USE projet_enchere;
GO

DROP TABLE IF EXISTS RETRAIT;
DROP TABLE IF EXISTS ENCHERE;
DROP TABLE IF EXISTS ROLE;
DROP TABLE IF EXISTS UTILISATEUR;
DROP TABLE IF EXISTS ARTICLE;
DROP TABLE IF EXISTS CATEGORIE;

CREATE TABLE CATEGORIE (
                           id_categorie 	INTEGER IDENTITY(1,1),
                           libelle        	VARCHAR(255),
                           CONSTRAINT CATEGORIE_PK PRIMARY KEY (id_categorie)
);

CREATE TABLE ARTICLE (
                         id_article 			INTEGER IDENTITY(1,1),
                         nom_article 		VARCHAR(255),
                         description 		VARCHAR(300),
                         date_debut_enchere 	DATETIME2,
                         date_fin_enchere 	DATETIME2,
                         prix_de_base 		INTEGER,
                         prix_de_vente 		INTEGER,
                         vente_en_cours 		bit ,
                         id_categorie 		INTEGER,
                         image_lien			VARCHAR(255),
                         CONSTRAINT ARTICLE_PK PRIMARY KEY (id_article)
);

ALTER TABLE ARTICLE ADD CONSTRAINT article_categorie_fk
    FOREIGN KEY (id_categorie) REFERENCES CATEGORIE (id_categorie)
        ON UPDATE CASCADE ON DELETE SET NULL;

CREATE TABLE UTILISATEUR (
                             id_utilisateur   INTEGER IDENTITY(1,1) NOT NULL,
                             pseudo           VARCHAR(255) UNIQUE,
                             nom              VARCHAR(255),
                             prenom           VARCHAR(255),
                             email            VARCHAR(255),
                             password		 VARCHAR(255),
                             telephone        VARCHAR(255),
                             adresse              VARCHAR(255),
                             code_postal      VARCHAR(255),
                             ville            VARCHAR(255),
                             credit           INTEGER,
                             administrateur   bit,
                             actif			 bit,
                             CONSTRAINT UTILISATEUR_PK PRIMARY KEY (id_utilisateur)
);

CREATE TABLE ROLE (
                      id_role 		INTEGER 	IDENTITY (1,1),
                      pseudo VARCHAR(255),
                      role 			VARCHAR(255),
                      id_utilisateur INTEGER,
                      CONSTRAINT ROLE_PK PRIMARY KEY (id_role)
);

ALTER TABLE ROLE ADD CONSTRAINT role_utilisateur_fk
    FOREIGN KEY (id_utilisateur) REFERENCES UTILISATEUR (id_utilisateur)
        ON UPDATE CASCADE ON DELETE CASCADE;

CREATE TABLE ENCHERE (
                         id_enchere 		INTEGER 	IDENTITY(1,1),
                         date_enchere 	DATETIME2,
                         montant_enchere INTEGER,
                         id_utilisateur 	INTEGER,
                         id_article 		INTEGER,
                         CONSTRAINT ENCHERE_PK 		PRIMARY KEY (id_enchere)
);

ALTER TABLE ENCHERE ADD CONSTRAINT enchere_utilisateur_fk
    FOREIGN KEY (id_utilisateur)
        REFERENCES UTILISATEUR (id_utilisateur)
        ON UPDATE CASCADE ON DELETE SET NULL;

ALTER TABLE ENCHERE ADD CONSTRAINT enchere_article_fk
    FOREIGN KEY (id_article)
        REFERENCES ARTICLE (id_article)
        ON UPDATE CASCADE ON DELETE SET NULL;

CREATE TABLE RETRAIT (
                         id_retrait 			INTEGER 	IDENTITY(1,1),
                         adresse              	VARCHAR(255),
                         code_postal      	VARCHAR(255),
                         ville            	VARCHAR(255),
                         id_article			INTEGER,
                         CONSTRAINT RETRAIT_PK PRIMARY KEY (id_retrait)
);

ALTER TABLE RETRAIT ADD CONSTRAINT retrait_article_fk
    FOREIGN KEY (id_article) REFERENCES ARTICLE (id_article)
        ON UPDATE CASCADE ON DELETE SET NULL;