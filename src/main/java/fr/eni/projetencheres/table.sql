CREATE TABLE CATEGORIE (
	id_categorie INTEGER IDENTITY(1,1) NOT NULL,
    libelle        VARCHAR(30) NOT NULL,
	CONSTRAINT CATEGORIE_PK PRIMARY KEY (id_categorie)
)

CREATE TABLE ARTICLE (
	id_article INTEGER IDENTITY(1,1) NOT NULL,
	nom_article VARCHAR(30) NOT NULL,
	description VARCHAR(300) NOT NULL,
	date_debut_enchere DATETIME2 NOT NULL,
	date_fin_enchere DATETIME2 NOT NULL,
	prix_de_base INTEGER NOT NULL,
	prix_de_vente INTEGER NOT NULL,
	vente_en_cours bit NOT NULL,
	id_categorie INTEGER NOT NULL,
	CONSTRAINT ARTICLE_PK PRIMARY KEY (id_article)
)

ALTER TABLE ARTICLE ADD CONSTRAINT article_categorie_fk
FOREIGN KEY (id_categorie) REFERENCES CATEGORIE (id_categorie)
ON DELETE NO ACTION
ON UPDATE NO ACTION

CREATE TABLE UTILISATEUR (
    id_utilisateur   INTEGER IDENTITY(1,1) NOT NULL,
    pseudo           VARCHAR(30) NOT NULL,
    nom              VARCHAR(30) NOT NULL,
    prenom           VARCHAR(30) NOT NULL,
    email            VARCHAR(20) NOT NULL,
	password		 VARCHAR(30) NOT NULL,
    telephone        VARCHAR(15),
    rue              VARCHAR(30) NOT NULL,
    code_postal      VARCHAR(10) NOT NULL,
    ville            VARCHAR(30) NOT NULL,
    credit           INTEGER NOT NULL,
    administrateur   bit NOT NULL,
	actif			 bit NOT NULL,
	CONSTRAINT UTILISATEUR_PK PRIMARY KEY (id_utilisateur)
)

CREATE TABLE ENCHERE (
	id_enchere INTEGER IDENTITY(1,1) NOT NULL,
	date_enchere DATETIME2 NOT NULL,
	montant_enchere INTEGER NOT NULL,
	id_utilisateur INTEGER NOT NULL,
	id_article INTEGER NOT NULL
	CONSTRAINT ENCHERE_PK PRIMARY KEY (id_enchere)
)

ALTER TABLE ENCHERE ADD CONSTRAINT enchere_utilisateur_fk
FOREIGN KEY (id_utilisateur) REFERENCES UTILISATEUR (id_utilisateur)
ON DELETE NO ACTION
ON UPDATE NO ACTION

ALTER TABLE ENCHERE ADD CONSTRAINT enchere_article_fk
FOREIGN KEY (id_article) REFERENCES ARTICLE (id_article)
ON DELETE NO ACTION
ON UPDATE NO ACTION

CREATE TABLE RETRAIT (
	id_retrait INTEGER IDENTITY(1,1) NOT NULL,
	rue              VARCHAR(30) NOT NULL,
    code_postal      VARCHAR(15) NOT NULL,
    ville            VARCHAR(30) NOT NULL,
	id_article		INTEGER NOT NULL,
	CONSTRAINT RETRAIT_PK PRIMARY KEY (id_retrait)
)

ALTER TABLE RETRAIT ADD CONSTRAINT retrait_article_fk
FOREIGN KEY (id_article) REFERENCES ARTICLE (id_article)
ON DELETE NO ACTION
ON UPDATE NO ACTION
