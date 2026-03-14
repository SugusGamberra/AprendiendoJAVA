CREATE DATABASE m0495_prg_p23;
USE m0495_prg_p23;

CREATE TABLE clientes (
    id               INT           AUTO_INCREMENT PRIMARY KEY,
    razon_social     VARCHAR(150)  NOT NULL,
    nombre_comercial VARCHAR(150),
    limite_credito   DECIMAL(15,2) NOT NULL DEFAULT 0.00
);