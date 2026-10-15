DROP DATABASE IF EXISTS Fil_rouge_EXAM;

CREATE DATABASE Fil_rouge_EXAM;
USE Fil_rouge_EXAM;

CREATE TABLE Departement(
  nom VARCHAR(20) NOT NULL,
  numerodept INTEGER NOT NULL ,
  nssdirecteur INTEGER NOT NULL,
  dateprisefonction DATE NOT NULL,
  PRIMARY KEY (numerodept)
) ENGINE=InnoDB;

INSERT INTO Departement VALUES ('Recherche',5,333445555,'1978-05-22'),('Administration',4,987654321,'1985-01-01'),('Quartiers Generaux',1,888665555,'1971-06-19');

CREATE TABLE localisation_Departement(
  numerodept INTEGER NOT NULL,
  localisation VARCHAR(20) NOT NULL,
  PRIMARY KEY (numerodept,localisation),
  FOREIGN KEY (numerodept) REFERENCES Departement(numerodept)
) ENGINE=InnoDB;

INSERT INTO localisation_Departement VALUES (1,'Bruxelles'),(4,'Bruges'),(5,'Mons'),(5,'Anvers'),(5,'Bruxelles');

CREATE TABLE Employe(
  nom VARCHAR(20) NOT NULL,
  prenom VARCHAR(20) NOT NULL,
  nss INTEGER NOT NULL,
  datenaissance DATE NOT NULL,
  adresse VARCHAR(20),
  numero INTEGER,
  ville VARCHAR(20),
  sexe CHAR(1) NOT NULL,
  salaire INTEGER,
  supernss INTEGER,
  deptnr INTEGER NOT NULL,
  PRIMARY KEY (nss),
  FOREIGN KEY (deptnr) REFERENCES Departement(numerodept),
  FOREIGN KEY (supernss) REFERENCES Employe(nss)
) ENGINE=InnoDB;

INSERT INTO Employe VALUES ('Vermeulen','James',888665555,'1927-11-10','Rue des Templiers',25,'Arlon','M',55000,NULL,1),('Materne','Stephanie',987654321,'1931-06-20','Avenue Tenderie',8,'Anvers','F',43000,888665555,4),('Durand','Roger',333445555,'1945-12-08','Rue de Gembloux',45,'Mons','M',40000,888665555,5),('Feraux','Franck',987987987,'1959-03-29','Rue du Ruisseau',111,'Charleroi','M',25000,987654321,4),('Garet','Alice',999887777,'1958-07-19','Ch de Bruxelles',1,'Namur','F',25000,987654321,4),('Dupont','Jean',123456789,'1955-01-09','Rue des Eglises',23,'Bruxelles','M',30000,333445555,5),('Lacroix','Frederic',666884444,'1952-08-15','Rue des Heritages',5,'Bruges','M',38000,333445555,5),('Massart','Morgane',453453453,'1962-07-31','Avenue Vauban',90,'Mons','F',25000,333445555,5);

CREATE TABLE Projet(
  nomprojet VARCHAR(20) NOT NULL,
  numeroprojet INTEGER NOT NULL,
  localisationProjet VARCHAR(20),
  numerodept INTEGER NOT NULL,
  PRIMARY KEY (numeroprojet),
  FOREIGN KEY (numerodept) REFERENCES Departement(numerodept)
) ENGINE=InnoDB;

INSERT INTO Projet VALUES ('ProduitX',1,'Charleroi',5),('ProduitY',2,'Arlon',5),('ProduitZ',3,'Bruxelles',5),('Informatisation',10,'Mons',4),('Reorganisation',20,'Bruxelles',1),('Nouveaux Benefices',30,'Mons',4);

CREATE TABLE Travaille_sur(
  enss INTEGER NOT NULL,
  numeroprojet INTEGER NOT NULL,
  HEURES DECIMAL(4,2) UNSIGNED,
  PRIMARY KEY (enss,numeroprojet),
  FOREIGN KEY (enss)
  REFERENCES Employe (nss),
  FOREIGN KEY (numeroprojet) REFERENCES Projet(numeroprojet)
) ENGINE=InnoDB;

INSERT INTO Travaille_sur VALUES (123456789,1,32.5),(123456789,2,7.5),(666884444,3,40.5),(453453453,1,20.0),(453453453,2,20.0),(333445555,2,10.0),(333445555,3,10.0),(333445555,10,10.0),(333445555,20,10.0),(999887777,30,30.0),(999887777,10,10.0),(987987987,10,35.0),(987987987,30,5.0),(987654321,30,20.0),(987654321,20,15.0),(888665555,20,NULL);

CREATE TABLE Lien(
  enss INTEGER NOT NULL,
  nomdependant VARCHAR(20) NOT NULL,
  sexe CHAR(1) NOT NULL,
  datenaissance DATE NOT NULL,
  relation VARCHAR(20) NOT NULL,
  PRIMARY KEY (enss,nomdependant,relation),
  FOREIGN KEY (enss) REFERENCES Employe(nss)
) ENGINE=InnoDB;

INSERT INTO Lien VALUES (333445555,'Christelle','F','1976-04-05','Fille'),(333445555,'Emmanuel','M','1973-10-25','Fils'),(333445555,'Erine','F','1948-05-03','Epouse'),(987654321,'Leo','M','1932-02-29','Epoux'),(123456789,'Bastien','M','1978-01-01','Fils'),(123456789,'Sandrine','F','1978-12-31','Fille'),(123456789,'Helene','F','1957-05-05','Epouse');

