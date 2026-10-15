exam 2023 JUIN

==================================theorie ====================================

QCM sur les Fonctions et Procédures Stockées en SQL/MariaDB,
#### Question 1
Quelle est la différence principale entre une fonction stockée et une procédure stockée en SQL/MariaDB ?
a) Une fonction stockée peut retourner plusieurs valeurs, tandis qu'une procédure stockée ne retourne qu'une seule valeur.
b) Une fonction stockée peut être appelée à partir d'une instruction SQL, tandis qu'une procédure stockée ne peut pas.
c) Une procédure stockée peut être utilisée dans une clause SELECT, tandis qu'une fonction stockée ne peut pas.
d) Il n'y a pas de différence significative entre une fonction stockée et une procédure stockée.

#### Question 2
Comment définir une procédure stockée en SQL/MariaDB ?
a) CREATE FUNCTION
b) CREATE PROCEDURE
c) CREATE TRIGGER
d) CREATE ROUTINE

#### Question 3
Quel mot-clé est utilisé pour spécifier les paramètres de sortie dans une procédure stockée en SQL/MariaDB ?
a) IN
b) OUT
c) INOUT
d) RETURN

#### Question 4
Quelle commande est utilisée pour supprimer une procédure stockée existante en SQL/MariaDB ?
a) DROP FUNCTION
b) DELETE PROCEDURE
c) REMOVE PROCEDURE
d) DROP PROCEDURE

#### Question 5
Quelle est la syntaxe correcte pour déclarer une variable dans une procédure stockée en SQL/MariaDB ?
a) SET @variable_name INT;
b) DECLARE variable_name INT;
c) DECLARE variable_name AS INT;
d) SET variable_name INT;

#### Question 6
Quel mot-clé est utilisé pour définir une valeur de retour dans une fonction stockée en SQL/MariaDB ?
a) OUT
b) RETURN
c) YIELD
d) OUTPUT

#### Question 7
Comment exécuter une procédure stockée nommée my_procedure avec un paramètre d'entrée param1 ?
a) EXECUTE my_procedure(param1);
b) CALL my_procedure(param1);
c) RUN my_procedure(param1);
d) PERFORM my_procedure(param1);

#### Question 8
Dans quelle section d'une procédure stockée peut-on gérer les exceptions en SQL/MariaDB ?
a) EXCEPTION
b) EXCEPTION HANDLER
c) HANDLER
d) TRY...CATCH

#### Question 9
Quel mot-clé permet d'indiquer que le corps d'une procédure stockée ou d'une fonction stockée se termine ?
a) END
b) FINISH
c) COMPLETE
d) CLOSE

#### Question 10
Pour quelle raison pourrait-on utiliser le mot-clé DETERMINISTIC lors de la création d'une fonction stockée en SQL/MariaDB ?
a) Pour indiquer que la fonction est lente à exécuter.
b) Pour indiquer que la fonction ne modifie pas les données de la base de données.
c) Pour indiquer que la fonction retourne toujours le même résultat pour les mêmes entrées.
d) Pour indiquer que la fonction peut être utilisée dans des transactions.


===================================pratique ==================================
	
	Question 1 10 points
Veuillez traduire l'algorithme suivant en instructions SQL et compléter les instructions au besoin :

1. Créez une table nommée "Voiture" ayant les attributs suivants:

Num_Plaque de type chaîne fixe de 9 caractères correspondant à la clé primaire de la table;
Marque de type chaîne variable de 20 caractères maximum;
DateAcquisition correspondant à la date d'acquisition du véhicule.
2. Ajoutez à la table Voiture les enregistrements suivants:

a) "1-123-ABC","BMW",20190502

b) "1-321-ZYX","Opel",20171124

c) "T-232-AAA","Seat",20170209

d) "1-784-JED","BMW",20190913

e) "D-987-TNT","Tesla",20200130

3. Modifiez la Marque de la voiture ayant comme Num_Plaque la valeur "1-321-ZYX" en "Ford";

4. Ajoutez à la table Voiture les enregistrements suivants:

a) "00-VIP-01","Tesla",20181012

b) "00-VIP-02","Tesla",20181012

5. Annulez toutes les modifications effectuée depuis le point 3 compris;

6. Modifiez la Marque de la voiture ayant comme Num_Plaque la valeur "1-321-ZYX" en "KIA";

7. Assurez-vous que les changements effectués jusqu'à présent le soit de façon permanente.

8. Ajoutez à la table Voiture les enregistrements suivants:

a) "00-VIP-03","Ford",20181012

b) "00-VIP-04","Lotus",20150504

9. Modifiez la date de la voiture ayant comme Num_Plaque la valeur "00-VIP-03" en "20171012";

10. Ajoutez à la table Voiture les enregistrements suivants:

a) "00-VIP-05","Tesla",20161119

b) "00-VIP-06","Tesla",20180214

11. Annulez toutes les modifications effectuée depuis le point 9 compris;

12. Annulez toutes les modifications effectuée depuis le point 7 compris;

 

 


 Question 2
Question 215 points
Veuillez créer une routine qui crée une table de manière autonome sur base des paramètres fournis en entré:

Le premier paramètre correspond au nom de la table;
Le second paramètre correspond à une chaîne de noms d'attribut séparés par des points-virgules ";".
Votre routine doit tout d'abord vérifier que le nom dans la nouvelle table n'existe pas déjà. Auquel cas, elle affiche un message d'erreur et s'arrête. S'il n'y a pas d'autre table du même nom, elle crée cette table en assignant aléatoirement à chaque attribut l'un des types SQL suivants:

Entier positif non-null;
Chaîne variable de maximum 100 caractères;
Date et heure;
Décimale ayant une précision de 10 chiffres et une échelle de 3 chiffres.
Le premier attribut de votre table doit être défini par votre routine comme clé primaire.

Exemple

L'instruction suivante doit créer une table nommée "MaTable" contenant 4 attributs dont le premier est la clé primaire: "Col1", "Col2", "Col3" et "Col4". Le type SQL de chaque attribut aura été choisi aléatoirement parmi les choix proposés.

CALL CreationTable('MaTable';'Col1;Col2;Col3;Col4');
 

 

 

 







Question 3
Question 3 10 points
Veuillez fournir votre code SQL pour la réalisation de ce qui suit:

Créez une base de données DVDs ayant les 3 tables ci-dessous et dont les attributs sont mentionnés entre parenthèses.
Base de données : DVDs

Acteur(CodeActeur, nom, prenom, dateNaissance)
Filmographie (CodeActeur, CodeFilm)
Film (CodeFilm, TitreFilm, dateParution, NombreActeur)
Pour chaque attribut, choisissez le type SQL le plus adéquat sachant que:

Les attributs soulignés et en gras constituent la clé primaire de leur table;
CodeActeur de la table Filmographie fait référence à l'attribut CodeActeur de la table Acteur, de même que CodeFilm de la table Filmographie fait référence à l'attribut CodeFilm de la table Film.
Insérez au moins 3 enregistrements de votre choix dans chacune des tables.
Faites en sorte que dès qu'un nouvel Acteur est associé à ou est retiré d'un Film, le nombre de Acteur impliqué sur un Film, soit automatiquement mis à jour avec le total des Acteurs sur ce même film.


p





 
Marquer la question : Question 4
Question 410 points
Veuillez développer une routine stockée qui vérifie qu'une chaîne de caractères fournie en entrée respecte les critères suivants et puisse être utilisée au sein d'une instruction telle qu'un SELECT ;

Commence par une lettre de l'alphabet;
Contient au minimum 8 caractères et 15 au maximum;
Contient au minimum 1 minuscule, 1 majuscule et 1 chiffre.
Cette routine devra retourner un et un seul chiffre correspondant au résultat de sa vérification:

0 : Si tous les critères sont respectés;
1 : Si la chaîne ne commence pas par une lettre de l'alphabet;
2 : Si la longueur de la chaîne est trop courte ou trop longue;
3 : Si la chaîne ne contient pas de minuscule, de majuscule ou de chiffre;
 

 



p





 
Marquer la question : Question 5
Question 5 15 points
Veuillez créer une routine qui crée une table de manière autonome sur base des paramètres fournis en entré:

Le premier paramètre correspond au nom de la table;
Le second paramètre correspond à une chaîne de noms d'attribut séparés par des points-virgules ";".
Votre routine doit tout d'abord vérifier que le nom dans la nouvelle table n'existe pas déjà. Auquel cas, elle affiche un message d'erreur et s'arrête. S'il n'y a pas d'autre table du même nom, elle crée cette table en assignant aléatoirement à chaque attribut l'un des types SQL suivants:

Entier positif non-null;
Chaîne variable de maximum 100 caractères;
Date et heure;
Décimale ayant une précision de 10 chiffres et une échelle de 3 chiffres.
Le premier attribut de votre table doit être défini par votre routine comme clé primaire.

Exemple:

L'instruction suivante doit créer une table nommée "MaTable" contenant 4 attributs dont le premier est la clé primaire: "Col1", "Col2", "Col3" et "Col4". Le type SQL de chaque attribut aura été choisi aléatoirement parmi les choix proposés.

CALL CreationTable('MaTable';'Col1;Col2;Col3;Col4');

 

 

 

 




 
Marquer la question : Question 6
Question 610 points
Veuillez traduire l'algorithme suivant en instructions SQL et complétez les instructions au besoin :

1. Créez une table nommée "Voiture" ayant les attributs suivants:

Num_Plaque de type chaîne fixe de 9 caractères correspondant à la clé primaire de la table;
Marque de type chaîne variable de 20 caractères maximum;
DateAcquisition correspondant à la date d'acquisition du véhicule.
2. Ajoutez à la table Voiture les enregistrements suivants:

a) "1-123-ABC","BMW",20190502

b) "1-321-ZYX","Opel",20171124

c) "T-232-AAA","Seat",20170209

d) "1-784-JED","BMW",20190913

e) "D-987-TNT","Tesla",20200130

3. Modifiez la Marque de la voiture ayant comme Num_Plaque la valeur "1-321-ZYX" en "Ford";

4. Ajoutez à la table Voiture les enregistrements suivants:

a) "00-VIP-01","Tesla",20181012

b) "00-VIP-02","Tesla",20181012

5. Annulez toutes les modifications effectuée depuis le point 3 compris;

6. Modifiez la Marque de la voiture ayant comme Num_Plaque la valeur "1-321-ZYX" en "KIA";

7. Assurez-vous que les changements effectués jusqu'à présent le soit de façon permanente.

8. Ajoutez à la table Voiture les enregistrements suivants:

a) "00-VIP-03","Ford",20181012

b) "00-VIP-04","Lotus",20150504

9. Modifiez la date de la voiture ayant comme Num_Plaque la valeur "00-VIP-03" en "20171012";

10. Ajoutez à la table Voiture les enregistrements suivants:

a) "00-VIP-05","Tesla",20161119

b) "00-VIP-06","Tesla",20180214

11. Annulez toutes les modifications effectuée depuis le point 9 compris;

12. Annulez toutes les modifications effectuée depuis le point 7 compris;

 

 







p








