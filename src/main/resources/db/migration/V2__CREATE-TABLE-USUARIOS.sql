CREATE TABLE usuarios (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre_usuario VARCHAR(25) NOT NULL UNIQUE,
    contrasena VARCHAR(300) NOT NULL,
    fecha_creacion DATE,
    usuario_activo TINYINT(1)
);