Projet JavaFx pour retrouver object volé

Structure:
-package vole qui contient les classes;
-Object: qui contient les constructeur, getters, setters et attribut des objects
-Connexion_to_db: qui nous permet de nous connecter a la base de donnees 
-volObj: qui nous permets de nous connecter a la classe connexion_to_db,connecter a la classe Object,et nous genere l'interface javaFx

Script SQL à exécuter :
CREATE DATABASE IF NOT EXISTS objetdb;
USE objetdb;
CREATE TABLE objets (
    id INT AUTO_INCREMENT PRIMARY KEY,
    type VARCHAR(50),
    numero_serie VARCHAR(50) ,
    marque VARCHAR(50),
    vole BOOLEAN DEFAULT FALSE
); 

difficulter rencontrer;-connexion a la Base de donnee en utlisant JDBC cela na vraiment pas ete facile
connaisnce aquis: creer une interfcae JAVAFX, Connexon BD en utilisant la JDBc, Comment faire un debot git.

Projet developper par: DEMANOU NGOUFFO BILL NELSON 3GI
