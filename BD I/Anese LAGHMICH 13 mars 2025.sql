--Je n'ai pas trouvé comment NARROW les valeurs dans les colonnes.

SELECT CONCAT(UPPER(nom),' ', UPPER(LEFT(prenom,1)),SUBSTR(prenom,2)) 
FROM Employe;