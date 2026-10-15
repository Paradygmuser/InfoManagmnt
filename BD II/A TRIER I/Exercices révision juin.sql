# FUNCTION f_ListEmp
# /*
# Créez une fonction qui produit une chaine de caractères reprenant les prénoms et noms des employés appartenant à un département donné, 
le tout séparé par des virgules.
# 
# Points d’attention :
# --------------------
#   a. La fonction doit renvoyer un NULL si la liste de noms est vide ou si le numéro de département n’est pas connu.
#   b.	Evitez d’avoir une virgule seule en début ou fin de liste.
# */
# 
# -- Résultat attendu
# -------------------
# 
# SELECT f_ListEmp(5);
# +--------------------------------------------------------------+
# | f_ListEmp(5)                                                 |
# +--------------------------------------------------------------+
# | Jean Dupont, Roger Durand, Morgane Massart, Frederic Lacroix |
# +--------------------------------------------------------------+
# 1 row in set (0.010 sec)
# 
# SELECT f_ListEmp(1);
# +-----------------+
# | f_ListEmp(1)    |
# +-----------------+
# | James Vermeulen |
# +-----------------+
# 1 row in set (0.001 sec)
# 
# SELECT f_ListEmp(0); -- Le département numéro "0" n'éxistant pas, la fonction renvoit NULL.
# +--------------+
# | f_ListEmp(0) |
# +--------------+
# | NULL         |
# +--------------+
# 1 row in set (0.000 sec)
# 

-- Code source
--------------

DELIMITER $
CREATE FUNCTION f_ListEmp(v_numdept INT)
RETURNS VARCHAR(255)
BEGIN
  -- Déclaration des variables
  DECLARE v_FullName,v_ListName VARCHAR(255) DEFAULT ''; -- Déclaration des variables qui vont permettre de construire la chaine de noms.
  DECLARE v_Done INT DEFAULT FALSE; -- Variable qui passera à TRUE dès que le curseur aura passé le dernier enregistrement.
  
  -- Déclaration des curseurs
  DECLARE c_ListEmp CURSOR FOR SELECT CONCAT(prenom,' ',nom) FROM Employe WHERE deptnr = v_numdept; -- Déclaration du curseur qui parcourera les enregistrements résultant de la requête associée.
  
  -- Déclaration des handlers
  DECLARE CONTINUE HANDLER FOR NOT FOUND SET v_Done = TRUE;

  IF NOT (SELECT COUNT(*) FROM Employe WHERE deptnr=v_numdept) THEN RETURN NULL;
  END IF;
  OPEN c_ListEmp; -- Ouverture de mon cuseur c_ListEmp
 
  read_loop: LOOP -- Boucle récupérant chaque enregistrement résultant de la requête associée à mon cuseur.
    FETCH c_ListEmp INTO v_FullName; -- Récupération d'un enregistrement résultant de la requête associée à mon cuseur.
    IF v_done THEN LEAVE read_loop; -- Arrèt de la boucle s'il n'y a plus d'enregistrement à traiter.
    END IF;
    IF LENGTH(v_ListName)<1
      THEN SET v_ListName = v_FullName; -- Concatenation de la valeur contenue dans v_FullName sans la virgule
      ELSE SET v_ListName = CONCAT_WS(', ',v_ListName,v_FullName); -- Concatenation de la valeur contenue dans v_FullName avec la virgule comme séparateur.
    END IF;    
  END LOOP read_loop; -- Fin de la boucle read_loop.
  
  CLOSE c_ListEmp; -- Fermeture de mon cuseur c_ListEmp.
  RETURN v_ListName; -- Renvois de la chaine v_ListName.
  
END$

DELIMITER ;

#----------------------------------------------------------------------------------------------------
# FUNCTION f_PRIME
# /* En tant que gestionnaire de la base de données Fil Rouge, il vous est demandé de calculer une prime pour chaque directeur de département. Sachant qu'elle doit correspondre à son salaire multiplié par le nombre de décennie (1 décennie = 10 ans) depuis ses 18 ans jusqu'à aujourd'hui.
# En d'autres mots, si un directeur gagne 50000 € et a aujourd'hui 55 ans, il a donc complété 3 décennie (55-18=37 années c-à-d 3 décennies), sa prime s'élèvera à 50000 x 3 = 150000 €.
# 
# Veuillez programmer une fonction de calcul de prime et montrez qu'elle peut être utilisée au sein d'une requête SQL qui affichera un résultat sous la forme d'un seul tableau. Veuillez donc fournir le code de votre fonction et l'instruction utilisée pour afficher le tableau demandé.
# nss 	Nom 	Prenom	Age 	Prime
# 888665555 	Vermeulen 	James 	90 	385000
# 987654321 	Materne 	Stéphanie 	87 	258000
# */

-- Code source
--------------

CREATE FUNCTION f_PRIME(pDATE DATE, pSALAIRE DOUBLE) RETURNS DOUBLE
RETURN TRUNCATE((TIMESTAMPDIFF(YEAR,pDATE,Current_Date())-18)/10,0)*pSALAIRE;

SELECT E.nss, E.nom, E.prenom, TIMESTAMPDIFF(YEAR,E.datenaissance,Current_Date()) AS AGE, f_PRIME(E.datenaissance,E.salaire) AS Prime
FROM Employe E JOIN Departement D ON D.nssDirecteur = E.nss
;

#----------------------------------------------------------------------------------------------------
# PROCEDURE plistemp
#
# /*
# Créez une procédure qui crée ou met à jour une table « Results », détaillée ci-dessous, sur base d’une liste de noms de département fournis en paramètre. 
La table « Results » contient trois attributs :
#   a.	Id : Clé primaire assurant l’unicité de chaque enregistrement ;
#   b.  LaDate : Date d'insertion
#   c.	NomDept : Nom du département
#   d.	ListeEmployes : Chaine de caractères avec les prénoms et noms des employés le tout séparé par des virgules.
# */
# 
# -- Résultat attendu
# CALL p_listemp(' Recherche');
# Query OK, 0 rows affected (0.00 sec)
# 
# CALL p_listemp('Administration,Recherche');
# Query OK, 1 row affected (1.76 sec)
# 
# SELECT * FROM Results;
# +----+---------------------+----------------+----------------------------------------------------------------+
# | id | LaDate              | NomDept        | ListeEmployes                                                  |
# +----+---------------------+----------------+----------------------------------------------------------------+
# |  1 | 2019-05-14 11:59:12 | Recherche      | Jean Dupont, Roger Durand, Morgane Massart, Frédéric Lacroix   |
# |  2 | 2019-05-14 11:59:12 | Administration | Stéphanie Materne, François Feraux, Alice Garet                |
# +----+---------------------+----------------+----------------------------------------------------------------+
# 2 rows in set (0.00 sec)
# 
# CALL p_listemp('Administration,Recherche');
# Query OK, 1 row affected (0.47 sec)
# 
# mysql> SELECT * FROM Results;
# +----+---------------------+----------------+----------------------------------------------------------------+
# | id | LaDate              | NomDept        | ListeEmployes                                                  |
# +----+---------------------+----------------+----------------------------------------------------------------+
# |  1 | 2019-05-14 11:59:12 | Recherche      | Jean Dupont, Roger Durand, Morgane Massart, Frédéric Lacroix   |
# |  2 | 2019-05-14 11:59:12 | Administration | Stéphanie Materne, François Feraux, Alice Garet                |
# |  3 | 2019-05-14 11:59:29 | Recherche      | Jean Dupont, Roger Durand, Morgane Massart, Frédéric Lacroix   |
# |  4 | 2019-05-14 11:59:30 | Administration | Stéphanie Materne, François Feraux, Alice Garet                |
# +----+---------------------+----------------+----------------------------------------------------------------+
# 
# CALL p_listemp('Quartiers Généraux');
# Query OK, 1 row affected (0.47 sec)
# 
# mysql> SELECT * FROM Results;
# +----+---------------------+----------------------+----------------------------------------------------------------+
# | id | LaDate              | NomDept              | ListeEmployes                                                  |
# +----+---------------------+----------------------+----------------------------------------------------------------+
# |  1 | 2019-05-14 11:59:12 | Recherche            | Jean Dupont, Roger Durand, Morgane Massart, Frédéric Lacroix   |
# |  2 | 2019-05-14 11:59:12 | Administration       | Stéphanie Materne, François Feraux, Alice Garet                |
# |  3 | 2019-05-14 11:59:29 | Recherche            | Jean Dupont, Roger Durand, Morgane Massart, Frédéric Lacroix   |
# |  4 | 2019-05-14 11:59:30 | Administration       | Stéphanie Materne, François Feraux, Alice Garet                |
# |  5 | 2019-05-14 12:00:30 | Quartiers Généraux   | James Vermeulen                                                |
# +----+---------------------+----------------------+----------------------------------------------------------------+
# 5 rows in set (0.00 sec)
# 
-- Code source
--------------

DELIMITER $
CREATE PROCEDURE p_ListEmp(v_ListNomdept VARCHAR(255))
BEGIN

  -- Déclaration des variables
  DECLARE v_FullName,v_ListName,v_NomDept VARCHAR(255) DEFAULT ''; -- Déclaration des variables qui vont permettre de construire la chaine de noms.
  DECLARE v_counter, v_Done INT DEFAULT FALSE; -- Variable qui passera à TRUE dès que le curseur aura passé le dernier enregistrement.
  
  -- Déclaration des curseurs
  DECLARE c_ListEmp CURSOR FOR SELECT CONCAT(E.prenom,' ',E.nom) FROM Employe E JOIN Departement D ON E.deptnr=D.numerodept WHERE D.nom=v_NomDept; -- Déclaration du curseur qui parcourera les enregistrements résultant de la requête associée.
  
  -- Déclaration des handlers
  DECLARE CONTINUE HANDLER FOR NOT FOUND SET v_Done = TRUE;
  
  SET v_counter = LENGTH(v_ListNomdept) - LENGTH(REPLACE(v_ListNomdept, ',', '')) + 1; -- Récupération du nombre de départements fournis en paramètre.
  WHILE v_counter > 0 DO -- Boucle tant qu'il reste un nom de département.
  
    SET v_NomDept=REPLACE(
                    SUBSTRING(
                        SUBSTRING_INDEX(
                          v_ListNomdept,',', v_counter
                        ),
                        LENGTH(
                          SUBSTRING_INDEX(
                            v_ListNomdept, ',', v_counter -1
                          )
                        ) 
                        + 1
                    ),',', ''
                  ); -- Récupération du nom de département à la position indiquée par v_counter.
    SET v_counter=v_counter-1; -- Décrémentation de v_counter pour éviter une boucle tant que infinie.   

    IF (SELECT COUNT(*) FROM Employe E JOIN Departement D ON E.deptnr=D.numerodept WHERE D.nom=v_NomDept LIMIT 1)>0 -- Vérification s'il y a au moins un enregistrement pour le département donné.
      THEN  
        OPEN c_ListEmp; -- Ouverture de mon cuseur c_ListEmp
     
        read_loop: LOOP -- Boucle récupérant chaque enregistrement résultant de la requête associée à mon cuseur.

          FETCH c_ListEmp INTO v_FullName; -- Récupération d'un enregistrement résultant de la requête associée à mon cuseur.
          IF v_done
            THEN LEAVE read_loop; -- Arrèt de la boucle s'il n'y a plus d'enregistrement à traiter.
          END IF;
          
          IF LENGTH(v_ListName) < 1
            THEN SET v_ListName = v_FullName; -- La valeur contenue dans v_FullName sans la virgule
            ELSE SET v_ListName = CONCAT_WS(', ',v_ListName,v_FullName); -- Concatenation de la valeur contenue dans v_FullName avec la virgule comme séparateur.
          END IF;    
        
        END LOOP read_loop; -- Fin de la boucle read_loop.
        
        CLOSE c_ListEmp; -- Fermeture de mon cuseur c_ListEmp.
        
      -- Création de la table que accueillera les listes d'employés par département.
        CREATE TABLE IF NOT EXISTS Results(
          id INT AUTO_INCREMENT PRIMARY KEY,
          LaDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),
          NomDept VARCHAR(50) NOT NULL,
          ListeEmployes VARCHAR(255)
        );

      -- Insertion de chaque liste d'employés pour chaque département donné.
        INSERT INTO Results(NomDept,ListeEmployes)
        VALUES(v_NomDept,v_ListName);
        SET v_done= FALSE, v_FullName = '', v_ListName = '', v_NomDept = '';
    END IF;
  END WHILE;
END$

DELIMITER ;

# /*
# Modifiez le code précédent en remplaçant la boucle "LOOP" par une boucle "WHILE...DO".
# */

DELIMITER $
CREATE PROCEDURE p_ListEmp(v_ListNomdept VARCHAR(255))
BEGIN
  -- Déclaration des variables
  DECLARE v_FullName,v_ListName,v_NomDept VARCHAR(255) DEFAULT ''; -- Déclaration des variables qui vont permettre de construire la chaine de noms.
  DECLARE v_counter, v_Continue INT DEFAULT TRUE; -- Variable qui passera à TRUE dès que le curseur aura passé le dernier enregistrement.
  
  -- Déclaration des curseurs
  DECLARE c_ListEmp CURSOR FOR SELECT CONCAT(E.prenom,' ',E.nom) FROM Employe E JOIN Departement D ON E.deptnr=D.numerodept WHERE D.nom=v_NomDept; -- Déclaration du curseur qui parcourera les enregistrements résultant de la requête associée.
  
  -- Déclaration des handlers
  DECLARE CONTINUE HANDLER FOR NOT FOUND SET v_Continue = FALSE;
  
  SET v_counter = LENGTH(v_ListNomdept) - LENGTH(REPLACE(v_ListNomdept, ',', '')) + 1; -- Récupération du nombre de départements fournis en paramètre.
  Dept_WHILE: WHILE v_counter > 0 DO -- Boucle tant qu'il reste un nom de département.
  
    SET v_NomDept=REPLACE(SUBSTRING(SUBSTRING_INDEX(v_ListNomdept,',', v_counter),LENGTH(SUBSTRING_INDEX(v_ListNomdept, ',', v_counter -1)) + 1),',', ''); -- Récupération du nom de département à la position indiquée par v_counter.
    SET v_counter=v_counter-1; -- Décrémentation de v_counter pour éviter une boucle tant que infinie.   
  
    IF (SELECT COUNT(*) FROM Employe E JOIN Departement D ON E.deptnr=D.numerodept WHERE D.nom=v_NomDept)>0
      THEN  -- Vérification s'il y a au moins un enregistrement pour le département donné.
      OPEN c_ListEmp; -- Ouverture de mon cuseur c_ListEmp
      FETCH c_ListEmp INTO v_FullName; -- Récupération d'un enregistrement résultant de la requête associée à mon cuseur.
      
      Fetch_WHILE: WHILE v_Continue DO -- Boucle récupérant chaque enregistrement résultant de la requête associée à mon cuseur.

        IF LENGTH(v_ListName)<1
          THEN SET v_ListName = CONCAT(v_ListName,v_FullName); -- Concatenation de la valeur contenue dans v_FullName sans la virgule
          ELSE SET v_ListName = CONCAT_WS(', ',v_ListName,v_FullName); -- Concatenation de la valeur contenue dans v_FullName avec la virgule comme séparateur.
        END IF;    
        
        FETCH c_ListEmp INTO v_FullName; -- Récupération d'un enregistrement résultant de la requête associée à mon cuseur.
        END WHILE Fetch_WHILE; -- Fin de la boucle Fetch_WHILE.
      CLOSE c_ListEmp; -- Fermeture de mon cuseur c_ListEmp.
      
    -- Création de la table que accueillera les listes d'employés par département.
      CREATE TABLE IF NOT EXISTS Results(
        id INT AUTO_INCREMENT PRIMARY KEY,
        LaDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),
        NomDept VARCHAR(50) NOT NULL,
        ListeEmployes VARCHAR(255));

    -- Insertion de chaque liste d'employés pour chaque département donné.
      INSERT INTO Results(NomDept,ListeEmployes) VALUES(v_NomDept,v_ListName);
  
      SET v_Continue = TRUE,v_FullName = '', v_ListName = '', v_NomDept = '';

      END IF;
    
  END WHILE Dept_WHILE;
END$

DELIMITER ;



#----------------------------------------------------------------------------------------------------
# PROCEDURE p_CreateUser
# /*
# Veuillez programmer une procédure de création d'utilisateur locaux (localhost) qui prendra les 3 paramètres suivants:
# 
#     Le premier paramètre correspondra au profil de l'utilisateur à créer. Si le profil fourni n'est pas reconnu, c'est le profil "Simple" qui sera appliqué:
#         Simple: Utilisateur avec les droits de lecture (SELECT) sur toute la base de donnée Fil_Rouge;
#         Middle: Utilisateur avec des droits de lecture et d'écriture (SELECT, INSERT,DELETE et UPDATE) sur toute la base de donnée Fil_Rouge;
#         Superior: Utilisateur avec des droits de gestion (CREATE, ALTER et DROP) sur toute la base de donnée Fil_Rouge.
#     Le deuxième paramètre correspond au nom de l’utilisateur. Si le nom existe déjà, la procédure s'arrêtera et affichera un message indiquant que ce nom d'utilisateur est déjà pris.
#     Le troisième paramètre correspond au mot de passe qui sera assigné à l'utilisateur. Ce mot de passe devra:
#         Être entre 8 et 15 caractères de long;
#         Démarrer par une lettre;
#         Contenir au moins 1 chiffre.
# 
# */

-- Code source
--------------

CREATE PROCEDURE p_CreateUser(p_Role VARCHAR(8),p_Username VARCHAR(64), p_PWD VARCHAR(255))
BEGIN
  DECLARE v_Username VARCHAR(100) DEFAULT '@''localhost''';
  DECLARE v_Error VARCHAR(100) DEFAULT '';
  DECLARE v_DigitInString BOOLEAN DEFAULT FALSE;
  DECLARE i,j INT DEFAULT 0;
  
  SELECT COUNT(*) INTO j FROM Mysql.User WHERE user=p_Username;
  
  IF j = 0 THEN
    BEGIN
      SET v_Username=CONCAT('''',p_Username,'''',v_Username);

      IF LENGTH(p_PWD) >=8 AND LENGTH(p_PWD) <=15 AND ((ASCII(LEFT(p_PWD,1)) >= 65 AND ASCII(LEFT(p_PWD,1)) <= 90) OR (ASCII(LEFT(p_PWD,1)) >= 97 AND ASCII(LEFT(p_PWD,1)) <= 122)) THEN  -- Premier tests PWD OK
        BEGIN
          MaBoucle: REPEAT
            IF LOCATE (CHAR(48+i),p_PWD)>0 THEN
              BEGIN
                SET v_DigitInString = TRUE;
                LEAVE MaBoucle;
              END;
            END IF;
            SET i=i+1;
          UNTIL i >= 10 END REPEAT MaBoucle;

          IF v_DigitInString THEN
            BEGIN
               SET @v_SQL = CONCAT('CREATE USER ',v_Username,' IDENTIFIED BY ''',p_PWD,'''');
               PREPARE stmt FROM @v_SQL;
                EXECUTE stmt;
                DEALLOCATE PREPARE stmt;
              
              CASE p_Role
                WHEN 'Middle' THEN
                  GRANT SELECT,INSERT,UPDATE,DELETE ON Fil_Rouge.* TO v_Username;
                WHEN 'Superior' THEN
                  GRANT CREATE,ALTER,DROP ON Fil_Rouge.* TO v_Username;
                ELSE
                    GRANT SELECT ON Fil_Rouge.* TO v_Username;
              END CASE;
            END;
        
          ELSE
            SELECT 'Mauvais mot de passe.';
          
          END IF;
        END;
      ELSE
        SELECT 'Mauvais mot de passe.';
      END IF;
    END;
  ELSE
    SELECT 'Ce nom d''utilisateur existe déjà.';
  END IF;  
END
$




#----------------------------------------------------------------------------------------------------
# TRIGGER LogLien
# /*
#   Créez une table "LogLien" avec les attributs suivants:
#   - ID Identifiant unique de chaque enregistrement.
#   - DateTemps : Moment auquel le changement a lieu.
#   - Utilisateur : Identifiant de l'initiateur du changement.
#   - TypeModif : Type de modification: INSERT, UPDATE ou DELETE.
#   - DataAvant : Chaine de caractères reprennant les données avant modification, s'il y en a, le tout séparé par des virgules.
#   - DataApres : Chaine de caractères reprennant les données après modification, s'il y en a, le tout séparé par des virgules.
#   
#   Créez des déclencheurs qui insereront automatiquement dans la table "LogLien" les données de tout changement (INSERT, UPDATE et DELETE) effectué sur la table Lien.
#   
#   Pour éviter que la table "LogLien" ne grossise à l'infini, votre déclencheur devra, après y avoir inséré un nouvel enregistrement, supprimer le plus ancien du même type pour ne garder que les 10 les plus récents.
# 
# */
# 
# 
# -- Résultat attendu
# -------------------
# 
# INSERT INTO Lien VALUES
#   (123456789,'Pat00','M',19810329,'Fils'),
#   (123456789,'Pat01','M',19810329,'Fils'),
#   (123456789,'Pat02','M',19810329,'Fils'),
#   (123456789,'Pat03','M',19810329,'Fils'),
#   (123456789,'Pat04','M',19810329,'Fils'),
#   (123456789,'Pat05','M',19810329,'Fils'),
#   (123456789,'Pat06','M',19810329,'Fils'),
#   (123456789,'Pat07','M',19810329,'Fils'),
#   (123456789,'Pat08','M',19810329,'Fils'),
#   (123456789,'Pat09','M',19810329,'Fils'),
#   (123456789,'Pat10','M',19810329,'Fils'),
#   (123456789,'Pat11','M',19810329,'Fils'),
#   (123456789,'Pat12','M',19810329,'Fils'),
#   (123456789,'Pat13','M',19810329,'Fils'),
#   (123456789,'Pat14','M',19810329,'Fils'),
#   (123456789,'Pat15','M',19810329,'Fils'),
#   (123456789,'Pat16','M',19810329,'Fils'),
#   (123456789,'Pat17','M',19810329,'Fils');
# 
# UPDATE lien SET relation='Cousin' WHERE nomdependant LIKE'Pat%';
# 
# DELETE FROM Lien WHERE nomdependant LIKE 'pat%';
# 
# SELECT * FROM LogLien;
# +----+---------------------+----------------+-----------+-------------------------------------+-------------------------------------+
# | ID | DateTemps           | Utilisateur    | TypeModif | DataAvant                           | DataApres                           |
# +----+---------------------+----------------+-----------+-------------------------------------+-------------------------------------+
# |  9 | 2019-05-17 12:30:44 | root@localhost | INSERT    | NULL                                | 123456789,Pat08,M,1981-03-29,Fils   |
# | 10 | 2019-05-17 12:30:44 | root@localhost | INSERT    | NULL                                | 123456789,Pat09,M,1981-03-29,Fils   |
# | 11 | 2019-05-17 12:30:44 | root@localhost | INSERT    | NULL                                | 123456789,Pat10,M,1981-03-29,Fils   |
# | 12 | 2019-05-17 12:30:45 | root@localhost | INSERT    | NULL                                | 123456789,Pat11,M,1981-03-29,Fils   |
# | 13 | 2019-05-17 12:30:45 | root@localhost | INSERT    | NULL                                | 123456789,Pat12,M,1981-03-29,Fils   |
# | 14 | 2019-05-17 12:30:45 | root@localhost | INSERT    | NULL                                | 123456789,Pat13,M,1981-03-29,Fils   |
# | 15 | 2019-05-17 12:30:45 | root@localhost | INSERT    | NULL                                | 123456789,Pat14,M,1981-03-29,Fils   |
# | 16 | 2019-05-17 12:30:45 | root@localhost | INSERT    | NULL                                | 123456789,Pat15,M,1981-03-29,Fils   |
# | 17 | 2019-05-17 12:30:45 | root@localhost | INSERT    | NULL                                | 123456789,Pat16,M,1981-03-29,Fils   |
# | 18 | 2019-05-17 12:30:45 | root@localhost | INSERT    | NULL                                | 123456789,Pat17,M,1981-03-29,Fils   |
# | 27 | 2019-05-17 12:31:09 | root@localhost | UPDATE    | 123456789,Pat08,M,1981-03-29,Fils   | 123456789,Pat08,M,1981-03-29,Cousin |
# | 28 | 2019-05-17 12:31:09 | root@localhost | UPDATE    | 123456789,Pat09,M,1981-03-29,Fils   | 123456789,Pat09,M,1981-03-29,Cousin |
# | 29 | 2019-05-17 12:31:09 | root@localhost | UPDATE    | 123456789,Pat10,M,1981-03-29,Fils   | 123456789,Pat10,M,1981-03-29,Cousin |
# | 30 | 2019-05-17 12:31:09 | root@localhost | UPDATE    | 123456789,Pat11,M,1981-03-29,Fils   | 123456789,Pat11,M,1981-03-29,Cousin |
# | 31 | 2019-05-17 12:31:09 | root@localhost | UPDATE    | 123456789,Pat12,M,1981-03-29,Fils   | 123456789,Pat12,M,1981-03-29,Cousin |
# | 32 | 2019-05-17 12:31:09 | root@localhost | UPDATE    | 123456789,Pat13,M,1981-03-29,Fils   | 123456789,Pat13,M,1981-03-29,Cousin |
# | 33 | 2019-05-17 12:31:09 | root@localhost | UPDATE    | 123456789,Pat14,M,1981-03-29,Fils   | 123456789,Pat14,M,1981-03-29,Cousin |
# | 34 | 2019-05-17 12:31:09 | root@localhost | UPDATE    | 123456789,Pat15,M,1981-03-29,Fils   | 123456789,Pat15,M,1981-03-29,Cousin |
# | 35 | 2019-05-17 12:31:09 | root@localhost | UPDATE    | 123456789,Pat16,M,1981-03-29,Fils   | 123456789,Pat16,M,1981-03-29,Cousin |
# | 36 | 2019-05-17 12:31:09 | root@localhost | UPDATE    | 123456789,Pat17,M,1981-03-29,Fils   | 123456789,Pat17,M,1981-03-29,Cousin |
# | 45 | 2019-05-17 12:31:09 | root@localhost | DELETE    | 123456789,Pat08,M,1981-03-29,Cousin | NULL                                |
# | 46 | 2019-05-17 12:31:09 | root@localhost | DELETE    | 123456789,Pat09,M,1981-03-29,Cousin | NULL                                |
# | 47 | 2019-05-17 12:31:09 | root@localhost | DELETE    | 123456789,Pat10,M,1981-03-29,Cousin | NULL                                |
# | 48 | 2019-05-17 12:31:09 | root@localhost | DELETE    | 123456789,Pat11,M,1981-03-29,Cousin | NULL                                |
# | 49 | 2019-05-17 12:31:09 | root@localhost | DELETE    | 123456789,Pat12,M,1981-03-29,Cousin | NULL                                |
# | 50 | 2019-05-17 12:31:09 | root@localhost | DELETE    | 123456789,Pat13,M,1981-03-29,Cousin | NULL                                |
# | 51 | 2019-05-17 12:31:09 | root@localhost | DELETE    | 123456789,Pat14,M,1981-03-29,Cousin | NULL                                |
# | 52 | 2019-05-17 12:31:09 | root@localhost | DELETE    | 123456789,Pat15,M,1981-03-29,Cousin | NULL                                |
# | 53 | 2019-05-17 12:31:09 | root@localhost | DELETE    | 123456789,Pat16,M,1981-03-29,Cousin | NULL                                |
# | 54 | 2019-05-17 12:31:09 | root@localhost | DELETE    | 123456789,Pat17,M,1981-03-29,Cousin | NULL                                |
# +----+---------------------+----------------+-----------+-------------------------------------+-------------------------------------+
# 30 rows in set (0.001 sec)
# 
-- Code source
--------------

CREATE TABLE IF NOT EXISTS LogLien ( -- Création de la table qui accueillera les données sur les changements.
  ID INT AUTO_INCREMENT PRIMARY KEY,
  DateTemps TIMESTAMP DEFAULT CURRENT_TIMESTAMP() NOT NULL,
  Utilisateur VARCHAR(255) DEFAULT CURRENT_USER() NOT NULL,
  TypeModif CHAR(6) NOT NULL,
  DataAvant VARCHAR(255),
  DataApres VARCHAR(255)
);

DELIMITER $

CREATE OR REPLACE TRIGGER AI_Lien AFTER INSERT ON Lien
FOR EACH ROW
BEGIN
  DECLARE v_Marqueur INT DEFAULT 0; -- Ni MariaDB, ni MySQL n'acceptent la clause LIMIT dans une sous requête IN/ANY/ALL/SOME. Cette variable permet d'identifier le Nième enregistrement. 
  INSERT INTO LogLien(TypeModif,DataApres) 
  Values('INSERT',CONCAT_WS
  (',',
  NEW.enss,
  NEW.nomdependant,
  NEW.sexe,
  NEW.datenaissance,
  NEW.relation)
  );
  SELECT LogLien.id FROM LogLien WHERE LogLien.typeModif = 'INSERT' ORDER BY LogLien.id DESC LIMIT 10,1 INTO v_Marqueur;
  DELETE FROM LogLien WHERE LogLien.id <= v_Marqueur AND LogLien.typeModif = 'INSERT';

END
$

CREATE OR REPLACE TRIGGER AD_Lien AFTER DELETE ON Lien
FOR EACH ROW
BEGIN
  DECLARE v_Marqueur INT DEFAULT 0; -- Ni MariaDB, ni MySQL n'acceptent la clause LIMIT dans une sous requête IN/ANY/ALL/SOME. Cette variable permet d'identifier le Nième enregistrement.
  INSERT INTO LogLien(TypeModif,DataAvant) Values('DELETE',CONCAT_WS(',',OLD.enss,OLD.nomdependant,OLD.sexe,OLD.datenaissance,OLD.relation));
  SELECT LogLien.id FROM LogLien WHERE LogLien.typeModif = 'DELETE' ORDER BY LogLien.id DESC LIMIT 10,1 INTO v_Marqueur;
  DELETE FROM LogLien WHERE LogLien.id <= v_Marqueur AND LogLien.typeModif = 'DELETE';
END
$


CREATE OR REPLACE TRIGGER AU_Lien AFTER UPDATE ON Lien
FOR EACH ROW
BEGIN
  DECLARE v_Marqueur INT DEFAULT 0; -- Ni MariaDB, ni MySQL n'acceptent la clause LIMIT dans une sous requête IN/ANY/ALL/SOME. Cette variable permet d'identifier le Nième enregistrement.
  INSERT INTO LogLien(TypeModif,DataAvant,DataApres) Values('UPDATE',CONCAT_WS(',',OLD.enss,OLD.nomdependant,OLD.sexe,OLD.datenaissance,OLD.relation),CONCAT_WS(',',NEW.enss,NEW.nomdependant,NEW.sexe,NEW.datenaissance,NEW.relation));
  SELECT LogLien.id FROM LogLien WHERE LogLien.typeModif = 'UPDATE' ORDER BY LogLien.id DESC LIMIT 10,1 INTO v_Marqueur;
  DELETE FROM LogLien WHERE LogLien.id <= v_Marqueur AND LogLien.typeModif = 'UPDATE';
END
$

DELIMITER ;


#----------------------------------------------------------------------------------------------------
# TRIGGER Projet
# /*
#   Les suppressions d'enregistrements de la table Projet sont systémantiquement rejetées car des enregistrements de la table Travaille_Sur y font référence.
#   Créez un déclencheur sur la table Projet qui supprime de la table Travaille_Sur les enregistrements faisant référence à l'enregistrement devant être supprimer de la table Projet.
#   
# */
# 
# -- Résultat attendu
# 
# DELETE FROM PROJET WHERE nomprojet='ProduitY'; -- Sans déclencheur la suppression est rejetée.
# ERROR 1451 (23000): Cannot delete or update a parent row: a foreign key constraint fails (`fil_rouge_exam`.`travaille_sur`, CONSTRAINT `travaille_sur_ibfk_2` FOREIGN KEY (`numeroprojet`) REFERENCES `projet` (`numeroprojet`))
# 
# DELETE FROM PROJET WHERE nomprojet='ProduitY'; -- Avec déclencheur la suppression est effectuée sans erreur.
# Query OK, 1 row affected (0.312 sec)


-- Code source
--------------

DELIMITER $

CREATE OR REPLACE TRIGGER BD_Projet BEFORE DELETE ON Projet
FOR EACH ROW
BEGIN
  DELETE FROM Travaille_Sur WHERE Travaille_Sur.numeroprojet=OLD.numeroprojet;
END
$

DELIMITER ;

#----------------------------------------------------------------------------------------------------
# TRIGGER Recherche_Localisation
# 
# /* En tant que gestionnaire de la base de données "Fil_rouge", le responsable du département "Recherche" vous demande de développer une solution 
qui lui permette de suivre les modifications (insertion, mise à jour et suppression) sur la table "Localisation_Departement" pour tous changements liés à son département. Voici le détail de sa demande:
# 
# 1. Tout d'abord, créez une table nommée "Recherche_Localisation" définie avec les attributs suivants et dont vous choisirez le type adéquat:
# 
#     nomUtilisateur = Nom de l'utilisateur effectuant la modification;
#     moment = Date et heure de la modification;
#     typeModif = Correspondant au type de modification (Insert, Update ou Delete);
#     Modification = Chaîne de caractères reprenant les éventuelles valeurs avant et après modification.
#     nbLoc = Nombre total des localisation de son département (après sa modification)
# 
# 2. Pour toute modification (insertion, mise à jour et suppression) sur la table "Localisation_Departement" concernant le département "Recherche", un nouvel enregistrement devra être inséré de façon automatique dans la table "Recherche_Localisation" renseignant tous les attributs qu'elle contient.
# 
# */

-- Code source
--------------

CREATE TABLE Recherche_Localisation(
  id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  nomUtilisateur VARCHAR(64) NOT NULL,
  moment TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  typeModif CHAR(2) NOT NULL,
  modification VARCHAR(255),
  nbLoc INT
);

DELIMITER $

CREATE TRIGGER t_AI_LD AFTER INSERT ON Localisation_departement
FOR EACH ROW
BEGIN
  DECLARE vNumDept, vNbLoc INT DEFAULT 0;
  SELECT D.numerodept INTO vNumDept FROM Departement D WHERE D.nom = 'Recherche';
  IF NEW.numerodept = vNumDept THEN
    SELECT COUNT(*) INTO vNbLoc FROM localisation_departement WHERE numerodept=vNumDept;
    INSERT INTO Recherche_Localisation(nomUtilisateur,typeModif,modification,nbLoc)
    VALUES(CURRENT_USER(),'AI',CONCAT_WS(',',NEW.numerodept,NEW.localisation),vNbLoc);
  END IF;
END$

CREATE TRIGGER t_AD_LD AFTER DELETE ON Localisation_departement
FOR EACH ROW
BEGIN
  DECLARE vNumDept, vNbLoc INT DEFAULT 0;
  SELECT D.numerodept INTO vNumDept FROM Departement D WHERE D.nom = 'Recherche';
  IF OLD.numerodept = vNumDept THEN
    SELECT COUNT(*) INTO vNbLoc FROM localisation_departement WHERE numerodept=vNumDept;
    INSERT INTO Recherche_Localisation(nomUtilisateur,typeModif,modification,nbLoc)
    VALUES(CURRENT_USER(),'AD',CONCAT_WS(',',OLD.numerodept,OLD.localisation),vNbLoc);
  END IF;
END$

CREATE TRIGGER t_AU_LD AFTER UPDATE ON Localisation_departement
FOR EACH ROW
BEGIN
  DECLARE vNumDept, vNbLoc INT DEFAULT 0;
  SELECT D.numerodept INTO vNumDept FROM Departement D WHERE D.nom = 'Recherche';
  IF NEW.numerodept = vNumDept OR OLD.numerodept = vNumDept THEN
    SELECT COUNT(*) INTO vNbLoc FROM localisation_departement WHERE numerodept=vNumDept;
    INSERT INTO Recherche_Localisation(nomUtilisateur,typeModif,modification,nbLoc)
    VALUES(CURRENT_USER(),'AU',CONCAT_WS(',',OLD.numerodept,OLD.localisation, NEW.numerodept,NEW.localisation),vNbLoc);
  END IF;
END$


DELIMITER ;

-- On teste nos TRIGGERs
START TRANSACTION;

INSERT INTO localisation_departement(numerodept,localisation) VALUES(5,'Liège');
UPDATE Localisation_departement SET localisation='Arlon' WHERE localisation='Liège';
DELETE FROM Localisation_departement WHERE localisation ='Arlon';

ROLLBACK


#----------------------------------------------------------------------------------------------------
# TRANSACTION
#/* En tant que gestionnaire de la base de données, vous devez faire la preuve de la fiabilité de votre base de données.
# 
# Écrivez une dizaines de requêtes distinctes modifiant (insertion, mise à jour, suppression) des données et montrez (en incluant vos commentaires sous format SQL) qu'il est possible :
# 
#     D'annuler des instructions de modification après que celles-ci aient été exécutées;
#     D'annuler plusieurs instructions de modification déjà exécutées mais jusqu'à un point de précis;
#     D'appliquer en "dur" les instructions de modification déjà exécutées et ne plus pouvoir les annulées.
#*/ 

-- Code source
--------------

START TRANSACTION; -- Démarrage d'une transaction

INSERT INTO employe (nom,prenom,nss,datenaissance,adresse,numero,sexe,salaire,supernss,deptnr)
VALUES ('Ahmed','Marc',454578126,'1965-05-31','Av du marche',13,'M',30000,123456789,5);
UPDATE employe SET salaire=35000 WHERE deptnr = 5;

ROLLBACK; -- Annulation des instructions exécutées depuis le début de la transaction

START TRANSACTION; -- Démarrage d'une nouvelle transaction

INSERT INTO employe (nom,prenom,nss,datenaissance,adresse,numero,sexe,salaire,supernss,deptnr)
VALUES ('Lah','Mehdi',463182632,'1945-05-31','Av du poisson',12,'M',30500,123456789,5);

SAVEPOINT T1; -- Création d'un point de sauvegarde T1

DELETE FROM employe WHERE nss=463182632;
DELETE FROM employe WHERE nss=454578126;

ROLLBACK TO SAVEPOINT T1; -- annulation des instructions jusqu'au point de sauvegarde T1.

UPDATE employe SET salaire=35000 WHERE deptnr = 5;
UPDATE employe SET salaire=80000 WHERE supernss=null;
UPDATE employe SET salaire=80000 WHERE nss=888665555;

COMMIT; -- Application en dur des instructions de la transaction

#----------------------------------------------------------------------------------------------------


CREATE DATABASE nomdebaseDeDonnée;
