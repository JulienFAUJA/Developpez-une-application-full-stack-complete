DROP DATABASE `mdd`;
CREATE DATABASE `mdd`;
USE `mdd`;

CREATE TABLE `USERS` (
  `id` integer PRIMARY KEY AUTO_INCREMENT,
  `email` varchar(255),
  `name` varchar(255),
  `password` varchar(255),
  `created_at` timestamp
);

CREATE TABLE `ARTICLES` (
  `id` integer PRIMARY KEY AUTO_INCREMENT,
  `titre` varchar(255),
  `contenu` varchar(2000),
  `auteur_id` integer NOT NULL,
  `theme_id` integer NOT NULL,
  `created_at` timestamp
);

CREATE TABLE `THEMES` (
  `id` integer PRIMARY KEY AUTO_INCREMENT,
  `theme` varchar(255),
  `description` varchar(2000)
);

CREATE TABLE `COMMENTAIRES` (
  `id` integer PRIMARY KEY AUTO_INCREMENT,
  `contenu` varchar(2000),
  `article_id` integer NOT NULL,
  `user_id` integer NOT NULL
);

CREATE TABLE `ABONNEMENTS` (
  `user_id` integer NOT NULL,
  `theme_id` integer NOT NULL
);

CREATE UNIQUE INDEX `USERS_index` ON `USERS` (`email`);

ALTER TABLE `ARTICLES` ADD FOREIGN KEY (`auteur_id`) REFERENCES `USERS` (`id`);
ALTER TABLE `ARTICLES` ADD FOREIGN KEY (`theme_id`) REFERENCES `THEMES` (`id`);

ALTER TABLE `COMMENTAIRES` ADD FOREIGN KEY (`article_id`) REFERENCES `ARTICLES` (`id`);
ALTER TABLE `COMMENTAIRES` ADD FOREIGN KEY (`user_id`) REFERENCES `USERS` (`id`);

ALTER TABLE `ABONNEMENTS` ADD FOREIGN KEY (`user_id`) REFERENCES `USERS` (`id`);
ALTER TABLE `ABONNEMENTS` ADD FOREIGN KEY (`theme_id`) REFERENCES `THEMES` (`id`);



INSERT INTO USERS (email, name, password, created_at) VALUES
  ('julienfaujanet@gmail.com', 'Julien FAUJANET', '1234', now()),
  ('technicien@tech.com', 'technicien stagiaire', '1234', now()),
  ('technicien_chef@tech.com', 'technicien en chef', '1234', now()),
  ('ingenieur@tech.com', 'Ingenieur', '1234', now()),
  ('dev@web.com', 'Dev web senior', '1234', now());

INSERT INTO THEMES (theme, description) VALUES
  ('Python', "Langage de script, utilisé pour le prototypage et le domaine scientifique, nottement l'intelligence artificielle..."),
  ('Javascript', "Langage de programmation côté client pour le web..."),
  ('Rust', "Langage ayant pour vocation de remplacer le C/C++ dans le but de sécuriser les logiciels dans le domaine des fuites mémoires..."),
  ('C++', "Langage de programmation très rapide mais aussi assez complexe à apprendre..."),
  ('CSS', "Langage web utilisé pour le style des pages web...");

INSERT INTO ARTICLES (titre, contenu, auteur_id, theme_id, created_at) VALUES
  ('Découverte de Rust', 'Rust est un langage de programmation système axé sur la sécurité, la vitesse et la concurrence.', 4, 3, now()),
  ('Les bases de Python', 'Python est un langage de programmation interprété, interactif et orienté objet. Il est parfait pour les débutants.', 2, 1, now()),
  ('CSS pour débutants', 'Cet article présente les bases de CSS pour ceux qui débutent dans la conception web.', 5, 5, now()),
  ('Optimisation C++', 'Apprenez à optimiser vos programmes C++ pour une performance maximale.', 3, 4, now());


-- Assumant que la table COMMENTAIRES a déjà les champs article_id et user_id
INSERT INTO COMMENTAIRES (contenu, user_id, article_id) VALUES
  ('Article très informatif, merci pour le partage!', 2, 1),
  ('Je n\'ai pas compris la partie sur les closures en Rust, pouvez-vous élaborer?', 1, 1),
  ('Merci pour cet article! Python est vraiment un langage puissant et accessible.', 3, 2),
  ('Les sélecteurs CSS peuvent être déroutants au début, mais cet article aide beaucoup.', 5, 3),
  ('C++ est intimidant, mais cet article rend les choses un peu plus claires.', 2, 4),
  ('Rust semble être l\'avenir pour les systèmes sécurisés, très bon article!', 4, 1),
  ('Cet article manque quelques exemples de code en Python.', 1, 3),
  ('Excellent travail! Les optimisations C++ sont cruciales pour mon travail quotidien.', 3, 4);






INSERT INTO ABONNEMENTS (user_id, theme_id) VALUES
(1,1),
(1,2),
(1,5),
(2,1),
(2,3),
(2,4),
(3,1),
(3,4),
(4,1),
(4,3),
(5,2),
(5,5);

