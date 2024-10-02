CREATE TABLE mascota (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    fechaNac DATE,
    raza VARCHAR(255),
    peso DOUBLE,
    tiene_chip BOOLEAN,
    url_foto VARCHAR(255)
);
