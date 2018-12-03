-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Lun 03 Décembre 2018 à 16:32
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `inscsportives`
--

-- --------------------------------------------------------

--
-- Structure de la table `candidat`
--

CREATE TABLE IF NOT EXISTS `candidat` (
  `Num_Candidat` int(11) NOT NULL,
  `Nom_Candidat` varchar(20) NOT NULL,
  PRIMARY KEY (`Num_Candidat`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `candidat`
--

INSERT INTO `candidat` (`Num_Candidat`, `Nom_Candidat`) VALUES
(1, 'R?®gis'),
(2, 'Emeline'),
(3, 'Bryan'),
(4, 'Les bras tordu'),
(5, 'Les jambes cass?®');

-- --------------------------------------------------------

--
-- Structure de la table `competition`
--

CREATE TABLE IF NOT EXISTS `competition` (
  `Num_Competition` int(11) NOT NULL,
  `Nom_Competition` varchar(50) NOT NULL,
  `DateCloture_Comp` date NOT NULL,
  PRIMARY KEY (`Num_Competition`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `competition`
--

INSERT INTO `competition` (`Num_Competition`, `Nom_Competition`, `DateCloture_Comp`) VALUES
(1, 'tournoi de foot', '2018-12-01'),
(2, 'course sur glace', '2019-01-01');

-- --------------------------------------------------------

--
-- Structure de la table `composer`
--

CREATE TABLE IF NOT EXISTS `composer` (
  `Num_Candidat` int(11) NOT NULL,
  `Num_Candidat_PERSONNE` int(11) NOT NULL,
  PRIMARY KEY (`Num_Candidat`,`Num_Candidat_PERSONNE`),
  KEY `COMPOSER_PERSONNE0_FK` (`Num_Candidat_PERSONNE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `composer`
--

INSERT INTO `composer` (`Num_Candidat`, `Num_Candidat_PERSONNE`) VALUES
(4, 1),
(4, 2),
(5, 2);

-- --------------------------------------------------------

--
-- Structure de la table `constituer`
--

CREATE TABLE IF NOT EXISTS `constituer` (
  `Num_Candidat` int(11) NOT NULL,
  `Num_Competition` int(11) NOT NULL,
  PRIMARY KEY (`Num_Candidat`,`Num_Competition`),
  KEY `CONSTITUER_COMPETITION0_FK` (`Num_Competition`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `constituer`
--

INSERT INTO `constituer` (`Num_Candidat`, `Num_Competition`) VALUES
(3, 1),
(4, 1),
(1, 2),
(3, 2),
(5, 2);

-- --------------------------------------------------------

--
-- Structure de la table `equipe`
--

CREATE TABLE IF NOT EXISTS `equipe` (
  `Num_Candidat` int(11) NOT NULL,
  `Nom_Candidat` varchar(20) NOT NULL,
  PRIMARY KEY (`Num_Candidat`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `equipe`
--

INSERT INTO `equipe` (`Num_Candidat`, `Nom_Candidat`) VALUES
(4, 'Les bras tordu'),
(5, 'Les jambes cass?®');

-- --------------------------------------------------------

--
-- Structure de la table `personne`
--

CREATE TABLE IF NOT EXISTS `personne` (
  `Num_Candidat` int(11) NOT NULL,
  `Prenom_Personne` varchar(10) NOT NULL,
  `Mail_Personne` varchar(50) NOT NULL,
  `Nom_Candidat` varchar(20) NOT NULL,
  PRIMARY KEY (`Num_Candidat`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `personne`
--

INSERT INTO `personne` (`Num_Candidat`, `Prenom_Personne`, `Mail_Personne`, `Nom_Candidat`) VALUES
(1, 'R?®gis', 'reglisse@gmail.com', 'Grimbergen'),
(2, 'Emeline', 'lunasticot@gmail.com', 'Revolvert'),
(3, 'Bryan', 'letoilebrian@gmail.com', 'Kstellaire');

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `composer`
--
ALTER TABLE `composer`
  ADD CONSTRAINT `COMPOSER_EQUIPE_FK` FOREIGN KEY (`Num_Candidat`) REFERENCES `equipe` (`Num_Candidat`),
  ADD CONSTRAINT `COMPOSER_PERSONNE0_FK` FOREIGN KEY (`Num_Candidat_PERSONNE`) REFERENCES `personne` (`Num_Candidat`);

--
-- Contraintes pour la table `constituer`
--
ALTER TABLE `constituer`
  ADD CONSTRAINT `CONSTITUER_CANDIDAT_FK` FOREIGN KEY (`Num_Candidat`) REFERENCES `candidat` (`Num_Candidat`),
  ADD CONSTRAINT `CONSTITUER_COMPETITION0_FK` FOREIGN KEY (`Num_Competition`) REFERENCES `competition` (`Num_Competition`);

--
-- Contraintes pour la table `equipe`
--
ALTER TABLE `equipe`
  ADD CONSTRAINT `EQUIPE_CANDIDAT_FK` FOREIGN KEY (`Num_Candidat`) REFERENCES `candidat` (`Num_Candidat`);

--
-- Contraintes pour la table `personne`
--
ALTER TABLE `personne`
  ADD CONSTRAINT `PERSONNE_CANDIDAT_FK` FOREIGN KEY (`Num_Candidat`) REFERENCES `candidat` (`Num_Candidat`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
