CREATE DATABASE javafx;
USE javafx;

CREATE TABLE Tipo(
	id INT PRIMARY KEY,
    nombre CHAR(40) NOT NULL
);

CREATE TABLE Producto(
	id INT PRIMARY KEY,
    nombre CHAR(40) NOT NULL,
    descripcion CHAR(100) NOT NULL,
    precio DOUBLE NOT NULL,
    tipo INT NOT NULL,
    FOREIGN KEY (tipo) REFERENCES Tipo(id)
);