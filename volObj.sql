CREATE DATABASE IF NOT EXISTS objetdb;
USE objetdb;
CREATE TABLE objets (
    id INT AUTO_INCREMENT PRIMARY KEY,
    type VARCHAR(50),
    numero_serie VARCHAR(50) ,
    marque VARCHAR(50),
    vole BOOLEAN DEFAULT FALSE
); 
