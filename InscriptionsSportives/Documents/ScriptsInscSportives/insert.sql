Insert Into COMPETITION (Num_Competition, Nom_Competition, DateCloture_Comp)
Values
(1, 'tournoi de foot', '2018/12/01'),
(2, 'course sur glace', '2019/01/01');

Insert Into CANDIDAT (Num_Candidat, Nom_Candidat)
VALUES
(1, 'Régis'),
(2, 'Emeline'),
(3, 'Bryan'),
(4, 'Les bras tordu'),
(5, 'Les jambes cassé');

Insert Into CONSTITUER (Num_Candidat, Num_Competition)
VALUES
(4, 1),
(3, 1),
(5, 2),
(1, 2),
(3, 2);

Insert Into PERSONNE (Num_Candidat, Prenom_Personne, Mail_Personne, Nom_Candidat)
VALUES
(1, 'Régis', 'reglisse@gmail.com', 'Grimbergen'),
(2, 'Emeline', 'lunasticot@gmail.com', 'Revolvert'),
(3, 'Bryan', 'letoilebrian@gmail.com', 'Kstellaire');

Insert Into EQUIPE (Num_Candidat, Nom_Candidat)
VALUES
(4, 'Les bras tordu'),
(5, 'Les jambes cassé');

Insert Into COMPOSER (Num_Candidat, Num_Candidat_PERSONNE)
VALUES
(4, 1),
(4, 2),
(5, 2);