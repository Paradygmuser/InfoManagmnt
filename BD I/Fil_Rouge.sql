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


SELECT * FROM Employe;
SELECT E.nom,E.prenom,P.localisationProjet,TS.HEURES,COUNT(P.numeroprojet) FROM Employe E
JOIN Travaille_sur Ts on E.nss = Ts.enss
JOIN Projet P on P.numeroprojet = Ts.numeroprojet
WHERE TS.HEURES>=10 AND P.localisationProjet='Bruxelles'
GROUP BY E.nom
HAVING COUNT(P.numeroprojet) >=1;

SELECT * FROM Lien;
SELECT * FROM Projet;
SELECT * FROM Travaille_sur;
SELECT SUM(TS.heures) AS Totalheurfemme FROM Travaille_sur TS
JOIN Lien L ON L.enss=TS.enss
JOIN Projet P on Ts.numeroprojet = P.numeroprojet
WHERE L.sexe='F' AND P.nomprojet='ProduitZ';

SELECT nom,prenom,nss FROM Employe E
JOIN Travaille_sur TS ON TS.enss=E.nss
JOIN Projet P on TS.numeroprojet = P.numeroprojet
GROUP BY E.datenaissance DESC
HAVING COUNT(P.numeroprojet)>=2;

SELECT * FROM Departement;

ALTER TABLE Departement
ADD FOREIGN KEY (nssdirecteur) REFERENCES Employe(nss);
SHOW CREATE TABLE Departement;
ALTER TABLE Departement
DROP FOREIGN KEY departement_ibfk_1;

SHOW CREATE TABLE Employe;
ALTER TABLE Employe
MODIFY salaire DECIMAL(11,2) DEFAULT NULL;

SHOW CREATE TABLE  Lien;

ALTER TABLE Lien
DROP FOREIGN KEY lien_ibfk_1;

ALTER TABLE Lien
DROP PRIMARY KEY ;

ALTER TABLE Lien
ADD PRIMARY KEY (enss,nomdependant,datenaissance);
ALTER TABLE Lien
ADD FOREIGN KEY (enss) REFERENCES Employe(nss);

SELECT * FROM Employe;
SHOW TABLES ;


SELECT AVG(E.salaire) AS salaire_moyen,D.nom,E.sexe FROM Employe E
JOIN Departement D on D.numerodept = E.deptnr
GROUP BY D.nom ASC, E.sexe;

DROP TABLE voiture;

SHOW FULL TABLES ;

CREATE TABLE Voiture (
    num_plaque VARCHAR(9) PRIMARY KEY ,
    marque VARCHAR(20),
    date_achat DATE ,
    enss INT UNIQUE,
    FOREIGN KEY (enss) REFERENCES Employe(nss),
    CHECK ( enss IN (SELECT E.nss FROM  Employe E WHERE supernss IS NOT NULL ) )

);
/*CREATE TABLE `Employe` (
  `nom` varchar(20) NOT NULL,
  `prenom` varchar(20) NOT NULL,
  `nss` int(11) NOT NULL,
  `datenaissance` date NOT NULL,
  `adresse` varchar(20) DEFAULT NULL,
  `numero` int(11) DEFAULT NULL,
  `ville` varchar(20) DEFAULT NULL,
  `sexe` char(1) NOT NULL,
  `salaire` int(11) DEFAULT NULL,
  `supernss` int(11) DEFAULT NULL,
  `deptnr` int(11) NOT NULL,
  PRIMARY KEY (`nss`),
  KEY `deptnr` (`deptnr`),
  KEY `supernss` (`supernss`),
  CONSTRAINT `employe_ibfk_1` FOREIGN KEY (`deptnr`) REFERENCES `Departement` (`numerodept`),
  CONSTRAINT `employe_ibfk_2` FOREIGN KEY (`supernss`) REFERENCES `Employe` (`nss`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci*/
DELETE FROM Employe
WHERE nss = 123456789;
SHOW CREATE TABLE Employe;
ALTER TABLE Travaille_sur
ADD FOREIGN KEY (enss) REFERENCES Employe (nss)
ON DELETE CASCADE ;

ALTER TABLE Departement
ADD FOREIGN KEY (nssdirecteur) REFERENCES Employe(nss)
ON DELETE CASCADE
ON UPDATE CASCADE ;

SELECT * FROM localisation_Departement;
/*create table employe
(
    nom           varchar(20) not null,
    prenom        varchar(20) not null,
    nss           int         not null
        primary key,
    datenaissance date        not null,
    adresse       varchar(20) null,
    numero        int         null,
    ville         varchar(20) null,
    sexe          char        not null,
    salaire       int         null,
    supernss      int         null,
    deptnr        int         not null,
    constraint employe_ibfk_1
        foreign key (deptnr) references Departement (numerodept),
    constraint employe_ibfk_2
        foreign key (supernss) references Employe (nss)
            on delete cascade
);*/
INSERT INTO Departement
VALUES ('Laboratoire',9,976431852,19960521),('Entrepot',11,258741963,19940421);

UPDATE Projet
SET localisationProjet = 'Namur',numerodept=1 WHERE nomprojet = (
SELECT nomprojet FROM Projet
WHERE nomprojet LIKE '% %');
ALTER TABLE Projet
ADD INDEX(nomprojet ASC,localisationProjet DESC ) ;

SHOW FULL TABLES ;

CREATE VIEW NPSAD AS
SELECT
    E.nom,E.prenom,
    E.salaire,
    D.nom AS nomdepartement,
    (SELECT DATEDIFF(2025-02-09,E.datenaissance)WHERE E.nss=E.nss) AS age
FROM Employe E
JOIN Departement D on D.numerodept = E.deptnr;

SELECT * FROM AGE;
DROP VIEW age;

CREATE VIEW age AS;
SELECT DATEDIFF(NOW(),E.datenaissance) FROM Employe E ;

select *
from (SELECT DATEDIFF(year(NOW() :'19881229'))) D;
SELECT DATEDIFF('2020-03-01 23:59:59', '2019-02-01');
SELECT datenaissance FROM Employe;
SELECT DATEDIFF('2020-03-01 23:59:59', '2020-02-01');

SELECT DATEDIFF(year, '2010/01/12', '2021/01/12');

SELECT * FROM Employe
WHERE ((datenaissance %4!=0 AND datenaissance %100=0) OR datenaissance %400=0);

SELECT E.nom,E.prenom FROM Employe E
JOIN Projet P ON P.numerodept=E.deptnr
JOIN Travaille_sur Ts on E.nss = Ts.enss
WHERE TS.HEURES>=10 AND P.localisationProjet ='Bruxelles'
GROUP BY E.nss
HAVING COUNT (P.numerodept)>=1;

SELECT SUM(TS.HEURES) FROM Travaille_sur TS
JOIN Employe E on TS.enss = E.nss
JOIN Projet P on P.numerodept= E.deptnr
WHERE E.sexe='F' AND P.nomprojet='ProduitZ';

SELECT  * FROM Employe;

SELECT E.nom,E.prenom,E.nss FROM Employe E
JOIN Projet P ON P.numerodept=E.deptnr
GROUP BY E.datenaissance ASC
HAVING COUNT(P.nomprojet)>=2;

ALTER TABLE Departement
ADD FOREIGN KEY (nssdirecteur) REFERENCES Employe (nss)
ON DELETE CASCADE ;

SELECT E.nom,E.prenom FROM Employe E
WHERE E.ville ='Arlon'
OR E.ville='Mons';

SELECT E.nom,E.prenom FROM Employe E
JOIN Projet P on P.numerodept = E.deptnr
GROUP BY P.localisationProjet
HAVING P.localisationProjet='Bruxelles';

SELECT E.nom, E.prenom FROM Employe E
WHERE E.nss IN
      (SELECT TS.enss FROM Travaille_sur TS
        WHERE TS.numeroprojet IN
              (SELECT P2.numeroprojet FROM Projet P2
                WHERE P2.localisationProjet='Bruxelles'));
SELECT E.nom, E.prenom FROM Employe E
WHERE E.nss IN (SELECT E2.nss FROM EMploye E2
    JOIN Projet P ON P.numerodept=E2.deptnr
    WHERE localisationProjet='Bruxelles');

SELECT * FROM Employe
JOIN Departement D on D.numerodept = Employe.deptnr
WHERE D.nom = 'Recherche';

SELECT * FROM Employe E
WHERE E.deptnr=
(SELECT D.numerodept FROM Departement D
WHERE D.nom='Recherche');

SELECT enss, nomdependant FROM Lien

WHERE enss NOT IN (SELECT E.nss FROM Employe E WHERE E.supernss IS NULL);

//création de vu
//modification des données
//

SELECT  * FROM Departement;
1//
CREATE VIEW Vue_Departement_Projet AS
(SELECT D.nom, P.nomprojet, LD.localisation FROM Departement D
    JOIN Projet P on D.numerodept = P.numerodept
        JOIN localisation_Departement LD ON LD.numerodept= D.numerodept
    GROUP BY P.numeroprojet
        HAVING  COUNT(P.numeroprojet)>=1);

SELECT * FROM Vue_Departement_Projet;

2//

CREATE INDEX TS_enss_nprojet ON Travaille_sur(enss,numeroprojet);
3//
UPDATE  Employe
SET salaire=45000
WHERE nss=333445555;

SELECT * FROM Employe;

4//
SELECT nom,prenom,HEURES FROM Employe
JOIN Travaille_sur Ts on Employe.nss = Ts.enss
JOIN Projet P on P.numerodept=deptnr
WHERE P.numeroprojet=10;

5//
//il faut rajouter DELETE ON CASCADE et update ON CASCADE pour le faire
    DELETE FROM Employe
        where nss IN (SELECT enss from Travaille_sur
                                  where numeroprojet is null);
6//
        SHOW CREATE  TABLE Departement;
//la reponse C employe

7//
CREATE VIEW vue_employe_ancien AS
(
SELECT nom,prenom,datenaissance,salaire FROM Employe
    WHERE TIMESTAMPDIFF(year , datenaissance, NOW())>=50   );

SELECT * FROM vue_employe_ancien;

8//
SELECT D.nom, AVG(E.salaire) AS salaire_moyen FROM Employe E
JOIN Departement D on E.deptnr = D.numerodept
GROUP BY D.nom ;

SHOW CREATE TABLE Travaille_sur;


//9
UPDATE Employe
SET adresse='Avenue de l\'europe'
WHERE nss=987654321;

SELECT * FROM Departement;

//10

Réponse C

//
CREATE  VIEW vue_employe_projet as
    (select E.prenom,E.nom,P.nomprojet,TS.HEURES FROM employe E
        JOIN Travaille_sur Ts on E.nss = Ts.enss
        JOIN Projet P ON P.numerodept=E.deptnr
        GROUP BY P.numeroprojet);

//12
DELETE FROM Employe
WHERE nss in (SELECT enss FROM Travaille_sur
                          JOIN Projet P on Travaille_sur.numeroprojet = P.numeroprojet
                          WHERE heures >=10
                          GROUP BY P.numeroprojet
                          HAVING  COUNT(P.numeroprojet)=1);

//13
CREATE INDEX employe_nom
ON employe(nom);

//14
ALTER TABLE Employe
MODIFY salaire INT
CHECK ( salaire>=20000 );

//15
C relation multiple.

SHOW TABLE Employe;

SELECT CONCAT(UPPER(nom),' ', UPPER(LEFT(prenom,1)),SUBSTR(prenom,2)) FROM Employe as Employ;

DELIMITER $$
CREATE PROCEDURE unaun()
    BEGIN
    DECLARE tf BOOL DEFAULT FALSE;
    DECLARE e_nom, e_prenom VARCHAR(255) DEFAULT '';
    DECLARE c_curseur CURSOR FOR SELECT nom,prenom FROM Employe ORDER BY salaire DESC;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET tf := TRUE;

    OPEN c_curseur ;
    loopa1 : LOOP
        FETCH c_curseur INTO e_nom,e_prenom;
            IF tf=TRUE THEN LEAVE loopa1 ; END IF;
            SELECT (CONCAT(e_nom,' ',e_prenom)) ;


        END LOOP loopa1;
   CLOSE c_curseur;
END
$$
DELIMITER ;

SELECT (SELECT heures*(COUNT(*)/100) NB_Emp FROM Travaille_sur TS
                      JOIN Departement D ON TS.enss=D.nssdirecteur
                      WHERE heures IS NOT NULL
                      AND NB_emp=(;

SELECT TS.heures +(TS.HEURES * NE.NB_Emp) FROM Travaille_sur TS
JOIN (SELECT nssdirecteur,(COUNT(*)/100) NB_Emp FROM Departement D
JOIN Employe E ON E.deptNR=D.numerodept
GROUP BY D.NSSdirecteur ) AS NE ON NE.nssdirecteur=TS.enss
WHERE HEURES IS NOT NULL;
           *
       (SELECT (COUNT(*)) NB_Emp FROM Departement D
    JOIN Employe E ON E.deptNR=D.numerodept
  GROUP BY D.NSSdirecteur) as bvlheures;

DELIMITER ##
CREATE PROCEDURE plusvalue
BEGIN
    SELECT TS.heures +(TS.HEURES * NE.NB_Emp) FROM Travaille_sur TS
        JOIN (SELECT nssdirecteur,(COUNT(*)/100) NB_Emp FROM Departement D
        JOIN Employe E ON E.deptNR=D.numerodept
        GROUP BY D.NSSdirecteur ) AS NE ON NE.nssdirecteur=TS.enss
        WHERE HEURES IS NOT NULL;
END ##
DELIMITER ;

CALL plusvalue();

SELECT * FROM Travaille_sur;
SELECT * FROM Departement;
SELECT * FROM Employe;
SELECT * FROM Projet;

DELIMITER $$
CREATE OR REPLACE PROCEDURE byRow (a CHAR(50),x INTEGER)
BEGIN
    DECLARE v_maxrow INT DEFAULT 0;
    SELECT COUNT(*) FROM a INTO v_maxrow;
    PREPARE xlignes FROM 'SELECT * FROM Employe LIMIT x';

    EXECUTE xlignes USING x;
    DEALLOCATE PREPARE xlignes;
    SELECT CONCAT('il reste',' ',v_maxrow-x,' ','lignes') AS nbre_de_lignes_restantes;
end $$
DELIMITER ;

CALL byRow (Travaille_sur,3);
SHOW WARNINGS ;

DELIMITER $$
CREATE OR REPLACE PROCEDURE byRows (a VARCHAR(50),x INTEGER)
BEGIN
    DECLARE v_maxrow INT DEFAULT 0;
    SELECT COUNT(*) INTO v_maxrow FROM a;
    PREPARE xlignes FROM CONCAT('SELECT * FROM', a, 'LIMIT',x);
    EXECUTE xlignes;
    DEALLOCATE PREPARE xlignes;
    SELECT CONCAT('il reste',' ',v_maxrow-x,' ','lignes') AS nbre_de_lignes_restantes;
end $$
DELIMITER ;

ALTER TABLE Employe
ADD token VARCHAR(64) ;