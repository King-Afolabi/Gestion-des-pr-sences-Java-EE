SELECT * FROM primowebcda24.USERS
where id_role = 1;


SELECT u.*, r.libelle, c.nom_class, c.niveau_class, c.nbre_apprenant   FROM USERS u INNER JOIN ROLES r  ON u.id_role = r.id_role INNER JOIN CLASSES c ON u.id_class = c.id_class WHERE r.libelle = 'formateur' OR r.libelle = 'apprenant';

SELECT u.*, r.libelle, c.nom_class, c.niveau_class, c.nbre_apprenant FROM USERS  u INNER JOIN ROLES r  ON u.id_role = r.id_role INNER JOIN CLASSES c  ON u.id_class = c.id_class WHERE u.id_class = 4 ;
SELECT u.*, r.libelle, c.nom_class, c.niveau_class, c.nbre_apprenant FROM USERS  u INNER JOIN ROLES r  ON u.id_role = r.id_role INNER JOIN CLASSES c  ON u.id_class = c.id_class WHERE u.id_class = 4;