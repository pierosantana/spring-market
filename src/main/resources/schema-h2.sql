-- -----------------------------------------------------
-- Table CATEGORIAS
-- -----------------------------------------------------
CREATE TABLE CATEGORIAS (
                            id_categoria INT AUTO_INCREMENT PRIMARY KEY,
                            descripcion VARCHAR(45) NOT NULL,
                            estado BOOLEAN NOT NULL
);

-- -----------------------------------------------------
-- Table PRODUCTOS
-- -----------------------------------------------------
CREATE TABLE PRODUCTOS (
                           id_producto INT AUTO_INCREMENT PRIMARY KEY,
                           nombre VARCHAR(45),
                           id_categoria INT NOT NULL,
                           codigo_barras VARCHAR(150),
                           precio_venta DECIMAL(16,2),
                           cantidad_stock INT NOT NULL,
                           estado BOOLEAN,
                           CONSTRAINT fk_PRODUCTOS_CATEGORIAS
                               FOREIGN KEY (id_categoria)
                                   REFERENCES CATEGORIAS(id_categoria)
);

-- -----------------------------------------------------
-- Table CLIENTES
-- -----------------------------------------------------
CREATE TABLE CLIENTES (
                          id VARCHAR(20) PRIMARY KEY,
                          nombre VARCHAR(40),
                          apellidos VARCHAR(100),
                          celular NUMERIC,
                          direccion VARCHAR(80),
                          correo_electronico VARCHAR(70)
);

-- -----------------------------------------------------
-- Table COMPRAS
-- -----------------------------------------------------
CREATE TABLE COMPRAS (
                         id_compra INT AUTO_INCREMENT PRIMARY KEY,
                         id_cliente VARCHAR(20) NOT NULL,
                         fecha TIMESTAMP,
                         medio_pago CHAR(1),
                         comentario VARCHAR(300),
                         estado CHAR(1),
                         CONSTRAINT fk_COMPRAS_CLIENTES
                             FOREIGN KEY (id_cliente)
                                 REFERENCES CLIENTES(id)
);

-- -----------------------------------------------------
-- Table COMPRAS_PRODUCTOS
-- -----------------------------------------------------
CREATE TABLE COMPRAS_PRODUCTOS (
                                   id_compra INT NOT NULL,
                                   id_producto INT NOT NULL,
                                   cantidad INT,
                                   total DECIMAL(16,2),
                                   estado BOOLEAN,
                                   PRIMARY KEY (id_compra, id_producto),
                                   CONSTRAINT fk_COMPRAS_PRODUCTOS_PRODUCTOS
                                       FOREIGN KEY (id_producto)
                                           REFERENCES PRODUCTOS(id_producto),
                                   CONSTRAINT fk_COMPRAS_PRODUCTOS_COMPRAS
                                       FOREIGN KEY (id_compra)
                                           REFERENCES COMPRAS(id_compra)
);
