-- pour afficher les employer qui sont toujour en activité avec le plus gro salaire il y a plusieur solution
-- a se re exercer a la maison
-- n'oublie pas de rajouter une ligne avec le meme salair maximum comme 
-- tu aura plusieur employer qui auront le meme salaire qui correspond au salaire maximum

SELECT emp_no,salary FROM Salaries 
WHERE to_date=(SELECT MAX(to_date) FROM Salaries)
ORDER BY salary DESC
LIMIT 1 ; -- ok cool ais n'affiche que le premier employer ici on a de la chance un seul employe touche le max, pourtant on pourrait avoir un deux ( a rajouter fieu) ainsi on utilisera pas la imit by 1 mais une VIEW



SELECT *FROM (
SELECT * FROM Salaries 
WHERE to_date=(SELECT MAX(to_date) FROM Salaries)
) R
WHERE R.salary = SELECT MAX(salary) FROM Salaries 
WHERE to_date=(SELECT MAX(to_date) FROM Salaries) 

ou bien creation de vue

CREATE VIEW EmployeActif
AS SELECT * FROM Salaries 
WHERE to_date=(SELECT MAX(to_date) FROM Salaries);

SELECT * FROM EmployeActif 
WHERE salary= (SELECT MAX(salary) FROM EmployeActif);

CREATE TABLE latable
(montext VARCHAR(50));

INSERT INTO latable values ('Coco');

DELIMITER $
CREATE TRIGGER montrigger BEFORE UPDATE
Salaries FOR EACH ROW BEGIN
INSERT INTO latable VALUES (salary)

DELIMITER $



--Exercice: Créez 3 déclencheur INSERT, UPDATE et DELETE qui vérifient que le dept_no commence bien par la lettre "d".
--Si oui, on ne fait rien, si non, on ajoute un "d" devant la valeur proposée.

--Réponse INSERT :
DELIMITER hey
CREATE OR REPLACE TRIGGER TriggD BEFORE INSERT ON departements
FOR EACH ROW
BEGIN
DECLARE v_namepasencoreInsert;
SET v_namepasencoreInsert = ?;
IF v_namepasencoreInsert NOT LIKE'd%'
THEN
SET NEW.v_dept_name = CONCAT('d',v_namepasencorInsert);
INSERT INTO departements.dept_name VALUE v_deptname;
END IF
END
DELIMITER hey

--reponse update: 

DELIMITER hey
CREATE OR REPLACE TRIGGER TrigU AFTER UPDATE ON departements
DECLARE v_deptname VARCHAR DEFAULT '';
FOR EACH ROW
BEGIN
IF NEW.dept_name NOT LIKE 'd%'
THEN
SET NEW.dept_name = CONCAT('d',NEW.dept_name);
END IF;
END;
DELIMITER hey

--reponse DELETE, ne rien faire si le nom commence par un 'd' voudrait il dire ne pas l'effacer ou ne pas l'enregistrer,ou sauvegarder la valeur delete avec un d devant??
CREATE VIEW leseffacer;
DELIMITER hey
CREATE OR REPLACE TRIGGER TriggD BEFORE DELETE ON departements
FOR EACH ROW
BEGIN

DECLARE v_dept_nameeffacer
SET v_dept_nameeffacer = SELECT departements.dept_name FROM departements
IF v_deptname LIKE d%
SET OLD.v_effacer = v_deptname;
INSERT INTO leseffacer VALUE OLD.v_effacer;
END;
DELIMITER hey

--Exercice: Créez 3 déclencheur INSERT, UPDATE et DELETE qui vérifient que le dept_no commence bien par la lettre "d".
--Si oui, on ne fait rien, si non, on ajoute un "d" devant la valeur proposée.
 
--Réponse INSERT :
DELIMITER hey
  CREATE OR REPLACE TRIGGER TriggD BEFORE INSERT ON departements
  FOR EACH ROW
  BEGIN
    IF NEW.dept_name NOT LIKE'd%'
      THEN
      SET NEW.dept_name = CONCAT('d',NEW.dept_name);
    END IF;
  END hey
DELIMITER;
 
--reponse update:
 
DELIMITER hey
  CREATE OR REPLACE TRIGGER TrigU BEFORE UPDATE ON departements --before mais pas after et dpno et non dep name car les numero de departement commence avec D.
  FOR EACH ROW
    BEGIN
    IF NEW.dept_no NOT LIKE 'd%';
      THEN
      SET NEW.dept_name = CONCAT('d',NEW.dept_name);
    END IF;
  END hey
DELIMITER; -- on met le delimiter a la fin du END
 
--reponse DELETE,je n'ais pas saisie l'ennoncer pour le delete, ne rien faire si le nom commence par un 'd' voudrait il dire ne pas l'effacer ou ne pas l'enregistrer,ou sauvegarder la valeur delete avec un d devant??
CREATE VIEW leseffacer;
DELIMITER hey
  CREATE OR REPLACE TRIGGER TriggD BEFORE DELETE ON departements
  FOR EACH ROW  BEGIN
    IF OLD.dept_name LIKE 'd%';
      SET v_dept_nameeffacer = SELECT dept_name FROM departements;
      INSERT INTO leseffacer VALUE OLD.v_effacer;
    END IF;
  END hey
DELIMITER;


--proposer moi une solution on a un client "je voudrais pouvoir suivre le nombre de fois qu'un employé change de département"
-- savoir combien de changement un employer a fait et je souhaite que cette information sois disponible dans ma base de donnée.
--savoir qui a fait le changement et quand il l'a fait.

/*//Exo//
Proposez une solution pour maintenir dans une base de données Employees,
le nombre de changementx de departement des employés , 
vous devez tenir compte des changements déja effectués ainsi que tout furus chanements en sauvegardant egalement, 
l'identifiant de l'utilisateur qui a fait le chanfgement et la date et l'heur

*/
--// declarer plusieurs variables
--// exemple DECLARE I,J,nimport INT DEFAULT 0; ne pas declarer des variables nn utiliser
CREATE VIEW changement AS SELECT first_name,last_name FROM employees; /* lus tot cree une table */
DELIMITER pp
CREATE OR REPLACE TRIGGER triggC AFTER UPDATE ON detp_emp
FOR EACH ROW
BEGIN
  DECLARE requete VARCHAR(255) DEFAULT ''; /* pas d'espace entre VARCHAR et (255)*/
  DECLARE v_compteur INTEGER DEFAULT 0;
  SET requete = '
      SELECT first_name,last_name,COUNT FROM employees E 
      JOIN dept_emp D ON e.emp_no=d.emp_no 
      GROUP by emp_no 
      HAVING COUNT(D.dept_no)>=2;'
  PREPARE requeteP FROM requete;
IF NEW.D.dept_no != OLD.dept_no THEN
SET v_compteur = v_compteur + 1;
INSERT INTO changement (/*les attribut dans l'ordre sinon ca crain*/)
VALUES(first_name,last_name,(COUNT + v_compteur); --  j'aurais souhaiter declrarer un CURSOR mais y pas le temps de reflechir

END pp
DELIMITER;

// je souhaiterais une fonction et c t juste
-- je crée d'abord un tableau utile au client qui a besoin de cette fonction,
CREATE TABLE changements (
emp_no INT PRIMARY KEY NOT NULL,
nbre_changement INT DEFAULT 0,
id_user VARCHAR(50) DEFAULT USER(),
date_changemnt DATETIME DEFAULT TIMESTAMP(NOW()),
FOREIGN KEY (emp_no) REFERENCES employees(emp_no)
);
--je crée un trigger pour les future changement.
DELIMITER pp
CREATE TRIGGER triggC AFTER UPDATE ON dept_emp D
FOR EACH ROW
BEGIN
IF OLD.dept_no != NEW.dept_no
THEN
INSERT INTO changements
VALUES(D.emp_no,(nbre_changement+1),USER(),NOW());
END IF;
END pp
DELIMITER;
-- je crée la fonction appelé par un manager par exemple et introduit le numero de l'employe,
DELIMIITER pp
CREATE FUNCTION EMPCHGMNT (v_emp_no INT) -- la fonction appelé par call aura besoin du n'uméro d'employe
RETURNS INT
BEGIN
  DECLARE v_requete VARCHAR(255); -- je vais avoir besoin d'une request pour chaque emp et rajouter +1 a son compteur de changement
  DECLARE compteur INT DEFAULT 0;
  
  SET v_requete = 
  'SELECT COUNT(D.emp_no) FROM dept_emp E 
  WHERE D.emp_no=v_emp_no;' --Pour recuperer les anciens changement, car il y a des employes qui par le passé ont déja changé de département si c'est le cas la valeur du count sera de 2
  SET compteur = PREPARE requeteP FROM v_requete;
  
  INSERT INTO changements (emp_no, nbr_changement,id_user,date_changemnt)
  VALUES(OLD.emp_no,v_compteur,USER,NOW());
  
  RETURN compteur
END pp
DELIMITER;

--la requete pour le manager apres avoir ecrir dans la base de donné le trigger et la fonction

SELECT first_name,last_name , EMPCHGMNT(emp_no) AS changement/*je remplace le nom de l'attribut pour afficher le nom de la fontion*/
 FROM employees
 WHERE emp_no=200873; /*je n'ai pas verifié si ce numéro existe*/
--l'attribut ville n'existe pas dans la table enployees selon le jpeg donnée de la structure de la BD
ALTER TABLE employees
ADD ville VARCHAR(50) DEFaulT '';

--l'auto incrémentation n'est pas déclarer pour le emp_no dans la table employees
ALTER TABLE employees
MODIFY emp_no INT(11) AUTO_INCREMENT NOT NULL ; -- le primary key est deja déclarer dans cette table quand on demande SHOW CREATE TABLE mployees;

--Creation de procedur d'insertion
DELIMITER pp
CREATE OR REPLACE PROCEDURE Insertion(v_prenom VARCHAR(50),v_nom VARCHAR(50),v_salaire INT ,v_ville VARCHAR(50),v_departement VARCHAR(50))
BEGIN
  DECLARE hh_nom VARCHAR(255) DEFAULT '';
  DECLARE v_exist BOOL DEFAULT FALSE;  
  DECLARE n_empno INT(11) DEFAULT 0;
  SELECT last_name INTO hh_nom FROM employees WHERE last_name=v_nom AND first_name=v_prenom;  
  IF hh_nom THEN SET v_exist=TRUE;
  /*si le nom n'existe pas dans la list alors tu peux inserer sinon besoin d'une procedure update*/
  ELSEIF v_exist = FALSE 
  THEN
    INSERT INTO employees(first_name,last_name,ville)
    VALUES(v_prenom,v_nom,v_ville);/*normalmnt le empno sera ato incrémenter*/
    SELECT emp_no FROM employees WHERE first_name=v_prenom AND last_name=v_nom AND ville=v_ville INTO n_empno;
    INSERT INTO salaries(emp_no,salary)
    VALUES(n_empno,v_salaire);
    INSERT INTO dept_emp(emp_no,dept_no)
    VALUES (n_empno,v_departement);
  END IF;
END pp
DELIMITER;