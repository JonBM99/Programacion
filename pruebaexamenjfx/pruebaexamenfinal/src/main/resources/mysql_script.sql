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

CREATE TABLE Producto_especial(
	id INT PRIMARY KEY,
    descuento INT NOT NULL,
    FOREIGN KEY (id) REFERENCES Producto(id)
);

-- Inserts para la tabla Tipo
INSERT INTO Tipo (id, nombre) VALUES (1, 'Electrónica');
INSERT INTO Tipo (id, nombre) VALUES (2, 'Ropa');
INSERT INTO Tipo (id, nombre) VALUES (3, 'Alimentos');

-- Inserts para la tabla Producto
INSERT INTO Producto (id, nombre, descripcion, precio, tipo) VALUES
(101, 'Televisor', 'Televisor LED 42 pulgadas', 399.99, 1),
(102, 'Pantalón vaquero', 'Pantalón azul de mezclilla', 29.95, 2),
(103, 'Manzanas', 'Bolsa de 1kg de manzanas rojas', 2.49, 3),
(104, 'Auriculares', 'Auriculares inalámbricos Bluetooth', 49.99, 1);

-- Inserts para la tabla Producto_especial
INSERT INTO Producto_especial (id, descuento) VALUES
(101, 10),  -- Televisor con 10% de descuento
(104, 15);  -- Auriculares con 15% de descuento
