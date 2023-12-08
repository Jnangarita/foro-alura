CREATE TABLE usuarios (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre_usuario VARCHAR(25),
    contrasena VARCHAR(300),
    fecha_creacion DATE,
    usuario_activo TINYINT(1)
);