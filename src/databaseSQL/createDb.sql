
-- Tabla users: Representa tanto personas naturales como jurídicas (empresas)

Create schema estraMyPime;
use estraMyPime;

CREATE TABLE users (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       name VARCHAR(255), -- Nombre de la persona o empresa
                       email VARCHAR(255) UNIQUE NOT NULL,
                       password VARCHAR(255) NOT NULL,
                       typeUser ENUM('natural', 'juridica') NOT NULL, -- 'natural' para personas naturales, 'juridica' para empresas
                       sizeCompany INT DEFAULT NULL, -- Solo aplicable si es una empresa (persona jurídica)
                       sector INT DEFAULT NULL, -- Solo aplicable si es una empresa (persona jurídica)
                       registerDate DATETIME DEFAULT CURRENT_TIMESTAMP,
                       isBookDownloaded BOOLEAN DEFAULT FALSE,
                       isTestDone BOOLEAN DEFAULT FALSE
);

-- Tabla tests: Relacionada con la tabla users (empresas y personas naturales)
CREATE TABLE tests (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       user_id INT,
                       pregunta1 TEXT,
                       pregunta2 TEXT,
                       pregunta3 TEXT,
                       pregunta4 TEXT,
                       pregunta5 TEXT,
                       pregunta6 TEXT,
                       pregunta7 TEXT,
                       pregunta8 TEXT,
                       pregunta9 TEXT,
                       FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

-- Tabla students: Almacena la información de los estudiantes, con datos opcionales
CREATE TABLE students (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          email VARCHAR(255) UNIQUE NOT NULL,
                          name VARCHAR(255) DEFAULT NULL, -- Opcional, puede ser NULL
                          haceParteProyecto BOOLEAN DEFAULT TRUE
);

-- Tabla teachers: Almacena la información de los profesores, con datos opcionales
CREATE TABLE teachers (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          email VARCHAR(255) UNIQUE NOT NULL,
                          name VARCHAR(255) DEFAULT NULL, -- Opcional, puede ser NULL
                          profesorParteProyecto BOOLEAN DEFAULT TRUE
);

-- Tabla admins: Almacena la información de los administradores, con datos opcionales
CREATE TABLE admins (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        email VARCHAR(255) UNIQUE NOT NULL,
                        password VARCHAR(255) NOT NULL,
                        name VARCHAR(255) DEFAULT NULL, -- Opcional, puede ser NULL
                        lastname VARCHAR(255) DEFAULT NULL, -- Opcional, puede ser NULL
                        phoneNumber VARCHAR(20) DEFAULT NULL -- Opcional, puede ser NULL
);


