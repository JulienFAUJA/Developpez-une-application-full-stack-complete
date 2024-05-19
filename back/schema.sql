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

CREATE TABLE `ABONNEMENTS` (
  `user_id` integer NOT NULL,
  `theme_id` integer NOT NULL
);

CREATE UNIQUE INDEX `USERS_index` ON `USERS` (`email`);

ALTER TABLE `ARTICLES` ADD FOREIGN KEY (`auteur_id`) REFERENCES `USERS` (`id`);
ALTER TABLE `ARTICLES` ADD FOREIGN KEY (`theme_id`) REFERENCES `THEMES` (`id`);

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
  ('Maitriser Javascript', 'Voici dans cet article des astuces pour maitriser Javascript', 1, 2, now());




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

