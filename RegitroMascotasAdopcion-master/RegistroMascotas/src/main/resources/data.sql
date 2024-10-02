DROP TABLE IF EXISTS mascota;

CREATE TABLE mascota (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    fecha_nac DATE,
    peso DECIMAL,
    raza VARCHAR(255),
    tiene_chip BOOLEAN,
    url_foto VARCHAR(255)
);
