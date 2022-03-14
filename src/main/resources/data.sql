INSERT IGNORE INTO `type_utilisateur` (`typeID`, `description`) VALUES (1, 'GESTIONNAIRE'), (2, 'VACATAIRE'), (3, 'RESPONSABLE');

INSERT IGNORE INTO `utilisateur` (`id`, `login`, `mail`, `mot_de_passe`, `nom_usuel`, `prenom`, `cours_id`, `type_typeid`) VALUES (NULL, 'OscarNak', 'oscar@mail.com', 'Iroise29', 'La graine', 'Oscar', NULL, '2');

INSERT IGNORE INTO `utilisateur` (`id`, `login`, `mail`, `mot_de_passe`, `nom_usuel`, `prenom`, `cours_id`, `type_typeid`) VALUES (NULL, 'PeronEB', 'valentin@mail.com', 'Iroise29', 'Peron', 'Valentin', NULL, '2');

INSERT IGNORE INTO `utilisateur` (`id`, `login`, `mail`, `mot_de_passe`, `nom_usuel`, `prenom`, `cours_id`, `type_typeid`) VALUES (NULL, 'LeT', 'tanguy@mail.com', 'Iroise29', 'Salou', 'Tanguy', NULL, '1');

INSERT IGNORE INTO `cours` (`id`, `intitule`) VALUES (NULL, 'Français');

INSERT IGNORE INTO `cours` (`id`, `intitule`) VALUES (NULL, 'Anglais');

INSERT IGNORE INTO `cours` (`id`, `intitule`) VALUES (NULL, 'Chinois');

