CREATE DATABASE bibliotheque;
USE bibliotheque;

CREATE TABLE auteur(
  id_auteur INT AUTO_INCREMENT PRIMARY KEY,
  nom VARCHAR(255) NOT NULL,
  prenom VARCHAR(255) NOT NULL,
  nationalite VARCHAR(150) NOT NULL  -- Correction : nationalité -> nationalite
);

CREATE TABLE livre(
  id_livre INT AUTO_INCREMENT PRIMARY KEY,
  titre VARCHAR(255) NOT NULL,
  isbn VARCHAR(20) NOT NULL UNIQUE,  
  annee_publication YEAR,
  id_auteur INT NOT NULL,
  nb_exemplaires INT DEFAULT 0,
  FOREIGN KEY (id_auteur) REFERENCES auteur(id_auteur) ON UPDATE CASCADE ON DELETE RESTRICT
);

CREATE TABLE membre(
  id_membre INT AUTO_INCREMENT PRIMARY KEY,
  nom VARCHAR(255) NOT NULL,  
  prenom VARCHAR(255) NOT NULL, 
  email VARCHAR(255) UNIQUE NOT NULL,
  date_inscription DATE NOT NULL, 
  statut ENUM('ACTIF', 'SUSPENDU') DEFAULT 'ACTIF' 
);

CREATE TABLE emprunt (
  id_emprunt INT AUTO_INCREMENT PRIMARY KEY,
  id_livre INT NOT NULL,
  id_membre INT NOT NULL,
  date_emprunt DATE NOT NULL,  -- DATE et NOT NULL
  date_retour_prevue DATE NOT NULL,
  date_retour_reelle DATE,  -- Peut etre NULL 
  FOREIGN KEY(id_livre) REFERENCES livre(id_livre) ON UPDATE CASCADE ON DELETE RESTRICT,
  FOREIGN KEY(id_membre) REFERENCES membre(id_membre) ON UPDATE CASCADE ON DELETE RESTRICT
);

-- Insertion des auteurs
INSERT INTO auteur (nom, prenom, nationalite) VALUES
('Hugo', 'Victor', 'Française'),
('Camus', 'Albert', 'Française'),
('Orwell', 'George', 'Britannique'),
('Rowling', 'J.K.', 'Britannique'),
('Tolkien', 'J.R.R.', 'Britannique'),
('Dumas', 'Alexandre', 'Française'),
('Zola', 'Émile', 'Française'),
('Christie', 'Agatha', 'Britannique'),
('Hemingway', 'Ernest', 'Américaine'),
('Steinbeck', 'John', 'Américaine'),
('García Márquez', 'Gabriel', 'Colombienne'),
('Kafka', 'Franz', 'Tchèque'),
('Dostoïevski', 'Fiodor', 'Russe'),
('Proust', 'Marcel', 'Française'),
('Wilde', 'Oscar', 'Irlandaise');

-- Insertion des livres (20 livres - table la plus longue)
INSERT INTO livre (titre, isbn, annee_publication, id_auteur, nb_exemplaires) VALUES
('Les Misérables', '978-2-07-040190-1', 1862, 1, 3),
('Notre-Dame de Paris', '978-2-07-041439-0', 1831, 1, 2),
('L\'Étranger', '978-2-07-036002-1', 1942, 2, 4),
('La Peste', '978-2-07-036003-8', 1947, 2, 2),
('1984', '978-0-452-28423-4', 1949, 3, 5),
('La Ferme des animaux', '978-0-452-28424-1', 1945, 3, 3),
('Harry Potter à l\'école des sorciers', '978-2-07-054120-7', 1997, 4, 6),
('Harry Potter et la Chambre des secrets', '978-2-07-054121-4', 1998, 4, 4),
('Le Seigneur des anneaux', '978-2-266-15444-9', 1954, 5, 2),
('Le Hobbit', '978-2-266-15445-6', 1937, 5, 3),
('Le Comte de Monte-Cristo', '978-2-07-045123-3', 1844, 6, 2),
('Les Trois Mousquetaires', '978-2-07-045124-0', 1844, 6, 3),
('Germinal', '978-2-07-040999-3', 1885, 7, 2),
('Le Crime de l\'Orient-Express', '978-2-253-00547-8', 1934, 8, 4),
('Le Vieil Homme et la Mer', '978-2-07-036157-8', 1952, 9, 3),
('Les Raisins de la colère', '978-2-07-037658-9', 1939, 10, 2),
('Cent ans de solitude', '978-2-02-006899-4', 1967, 11, 2),
('La Métamorphose', '978-2-07-037658-6', 1915, 12, 3),
('Crime et Châtiment', '978-2-07-040134-5', 1866, 13, 2),
('Le Portrait de Dorian Gray', '978-2-07-041384-3', 1890, 15, 3);

-- Insertion des membres
INSERT INTO membre (nom, prenom, email, date_inscription, statut) VALUES
('Martin', 'Sophie', 'sophie.martin@email.com', '2023-01-15', 'ACTIF'),
('Dubois', 'Pierre', 'pierre.dubois@email.com', '2023-02-20', 'ACTIF'),
('Bernard', 'Marie', 'marie.bernard@email.com', '2023-03-10', 'ACTIF'),
('Petit', 'Jean', 'jean.petit@email.com', '2023-04-05', 'SUSPENDU'),
('Robert', 'Anne', 'anne.robert@email.com', '2023-05-12', 'ACTIF'),
('Richard', 'Paul', 'paul.richard@email.com', '2023-06-18', 'ACTIF'),
('Moreau', 'Claire', 'claire.moreau@email.com', '2023-07-22', 'ACTIF'),
('Simon', 'Luc', 'luc.simon@email.com', '2023-08-30', 'ACTIF'),
('Laurent', 'Julie', 'julie.laurent@email.com', '2023-09-14', 'ACTIF'),
('Lefebvre', 'Marc', 'marc.lefebvre@email.com', '2023-10-08', 'ACTIF');

-- Insertion des emprunts
INSERT INTO emprunt (id_livre, id_membre, date_emprunt, date_retour_prevue, date_retour_reelle) VALUES
(1, 1, '2024-01-10', '2024-01-24', '2024-01-22'),
(3, 2, '2024-01-15', '2024-01-29', '2024-01-30'),
(5, 3, '2024-02-01', '2024-02-15', NULL),
(7, 1, '2024-02-05', '2024-02-19', NULL),
(2, 5, '2024-02-10', '2024-02-24', '2024-02-23'),
(9, 6, '2024-02-12', '2024-02-26', NULL),
(11, 7, '2024-02-15', '2024-03-01', '2024-02-28'),
(13, 8, '2024-02-20', '2024-03-06', NULL),
(15, 9, '2024-02-25', '2024-03-11', NULL),
(4, 10, '2024-03-01', '2024-03-15', '2024-03-14'),
(6, 2, '2024-03-05', '2024-03-19', NULL),
(8, 3, '2024-03-10', '2024-03-24', NULL),
(10, 1, '2024-03-12', '2024-03-26', NULL),
(12, 5, '2024-03-15', '2024-03-29', NULL),
(14, 6, '2024-03-18', '2024-04-01', NULL);