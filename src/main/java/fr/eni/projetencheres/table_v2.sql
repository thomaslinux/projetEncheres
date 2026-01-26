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
	id_categorie 	INTEGER IDENTITY(1,1) 	NOT NULL,
    libelle        	VARCHAR(255) 			NOT NULL,
	CONSTRAINT CATEGORIE_PK PRIMARY KEY (id_categorie)
);

CREATE TABLE ARTICLE (
	id_article 			INTEGER IDENTITY(1,1) NOT NULL,
	nom_article 		VARCHAR(255) 	NOT NULL,
	description 		VARCHAR(300) 	NOT NULL,
	date_debut_enchere 	DATETIME2 		NOT NULL,
	date_fin_enchere 	DATETIME2		NOT NULL,
	prix_de_base 		INTEGER 		NOT NULL,
	prix_de_vente 		INTEGER 		NOT NULL,
	vente_en_cours 		bit 			NOT NULL,
	id_categorie 		INTEGER 		NOT NULL,
	CONSTRAINT ARTICLE_PK PRIMARY KEY (id_article)
);

ALTER TABLE ARTICLE ADD CONSTRAINT article_categorie_fk
FOREIGN KEY (id_categorie) REFERENCES CATEGORIE (id_categorie)
ON UPDATE NO ACTION ON DELETE NO ACTION;

CREATE TABLE UTILISATEUR (
    id_utilisateur   INTEGER IDENTITY(1,1) NOT NULL,
    pseudo           VARCHAR(255) NOT NULL,
    nom              VARCHAR(255) NOT NULL,
    prenom           VARCHAR(255) NOT NULL,
    email            VARCHAR(255) NOT NULL,
	password		 VARCHAR(255) NOT NULL,
    telephone        VARCHAR(255),
    rue              VARCHAR(255) NOT NULL,
    code_postal      VARCHAR(255) NOT NULL,
    ville            VARCHAR(255) NOT NULL,
    credit           INTEGER 	 NOT NULL,
    administrateur   bit 		 NOT NULL,
	actif			 bit 		 NOT NULL,
	CONSTRAINT UTILISATEUR_PK PRIMARY KEY (id_utilisateur)
);

CREATE TABLE ROLE (
    id_role 		INTEGER 	IDENTITY (1,1) 	NOT NULL,
    role 			VARCHAR(255) NOT NULL,
	id_utilisateur INTEGER 		NOT NULL,
    CONSTRAINT ROLE_PK PRIMARY KEY (id_role)
);

ALTER TABLE ROLE ADD CONSTRAINT role_utilisateur_fk
FOREIGN KEY (id_utilisateur) REFERENCES UTILISATEUR (id_utilisateur)
ON UPDATE NO ACTION ON DELETE NO ACTION;

CREATE TABLE ENCHERE (
	id_enchere 		INTEGER 	IDENTITY(1,1) NOT NULL,
	date_enchere 	DATETIME2 	NOT NULL,
	montant_enchere INTEGER 	NOT NULL,
	id_utilisateur 	INTEGER 	NOT NULL,
	id_article 		INTEGER 	NOT NULL,
	CONSTRAINT ENCHERE_PK 		PRIMARY KEY (id_enchere)
);

ALTER TABLE ENCHERE ADD CONSTRAINT enchere_utilisateur_fk
FOREIGN KEY (id_utilisateur)
REFERENCES UTILISATEUR (id_utilisateur)
ON UPDATE NO ACTION ON DELETE NO ACTION;

ALTER TABLE ENCHERE ADD CONSTRAINT enchere_article_fk
FOREIGN KEY (id_article)
REFERENCES ARTICLE (id_article)
ON UPDATE NO ACTION ON DELETE NO ACTION;

CREATE TABLE RETRAIT (
	id_retrait 			INTEGER 	IDENTITY(1,1) NOT NULL,
	rue              	VARCHAR(255) NOT NULL,
    code_postal      	VARCHAR(255) NOT NULL,
    ville            	VARCHAR(255) NOT NULL,
	id_article			INTEGER 	NOT NULL,
	CONSTRAINT RETRAIT_PK PRIMARY KEY (id_retrait)
);

ALTER TABLE RETRAIT ADD CONSTRAINT retrait_article_fk
FOREIGN KEY (id_article) REFERENCES ARTICLE (id_article)
ON UPDATE NO ACTION ON DELETE NO ACTION;
