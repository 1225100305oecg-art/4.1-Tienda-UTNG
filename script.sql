CREATE DATABASE IF NOT EXISTS utng_tienda;

USE utng_tienda;

CREATE TABLE IF NOT EXISTS producto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(200),
    precio DOUBLE NOT NULL,
    existencia INT NOT NULL
);

INSERT INTO producto (nombre, descripcion, precio, existencia) VALUES
('Laptop HP', 'Laptop Core i5 16GB RAM', 12500.00, 10),
('Mouse Logitech', 'Mouse USB inalambrico', 350.00, 25),
('Teclado Redragon', 'Teclado mecanico RGB', 950.00, 12),
('Monitor Samsung', 'Monitor LED 24 pulgadas', 3200.00, 8),
('Memoria USB', 'USB 64GB', 180.00, 30);
