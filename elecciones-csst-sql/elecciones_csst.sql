-- =============================================
-- BASE DE DATOS
-- =============================================
CREATE DATABASE Elecciones_CSST; 
GO

USE Elecciones_CSST;
GO

-- =============================================
-- TABLAS
-- =============================================
-- Procesos Electorales
CREATE TABLE PROCESO_ELECTOR (
    ID_Proceso VARCHAR(10) PRIMARY KEY,
    Nombre_Proceso VARCHAR(100) NOT NULL,
    Descripcion TEXT,
    Fecha_Creacion DATE DEFAULT GETDATE()
)
GO

-- Lugares de Votación
CREATE TABLE LUGAR (
    ID_Lugar VARCHAR(10) PRIMARY KEY,
    Nombre VARCHAR(100) NOT NULL,
    Direccion VARCHAR(200) NOT NULL,
	Capacidad INT CHECK (Capacidad > 0),
    Estado VARCHAR(20) DEFAULT 'DISPONIBLE' CHECK (Estado IN ('DISPONIBLE', 'OCUPADO', 'MANTENIMIENTO', 'INACTIVO'))
)
GO

-- Electores (Votantes)
CREATE TABLE ELECTOR (
    ID_Elector VARCHAR(10) PRIMARY KEY,
    Nombre VARCHAR(100) NOT NULL,
    DNI VARCHAR(8) UNIQUE NOT NULL CHECK (LEN(DNI) = 8 AND DNI NOT LIKE '%[^0-9]%'), 
    Telefono VARCHAR(15),
    Email VARCHAR(100) CHECK (Email LIKE '%@%.%'),
    Estado VARCHAR(20) DEFAULT 'ACTIVO' CHECK (Estado IN ('ACTIVO', 'INACTIVO'))
)
GO

-- Responsables (Organizadores)
CREATE TABLE RESPONSABLE (
    ID_Responsable VARCHAR(10) PRIMARY KEY,
    Nombre VARCHAR(100) NOT NULL,
    Cargo VARCHAR(50),
    Telefono VARCHAR(15),
    Estado VARCHAR(20) DEFAULT 'ACTIVO' CHECK (Estado IN ('ACTIVO', 'INACTIVO'))
)
GO

-- Cronograma Principal
CREATE TABLE CRONOGRAMA (
    ID_Cronograma VARCHAR(10) PRIMARY KEY,
    Nombre VARCHAR(100) NOT NULL,
    Fecha_Inicio DATE NOT NULL, -- 
    Fecha_Fin DATE NOT NULL, 
    Estado VARCHAR(20) DEFAULT 'PENDIENTE' CHECK (Estado IN ('PENDIENTE', 'ACTIVO', 'FINALIZADO', 'CANCELADO')), 
	CONSTRAINT CK_Cronograma_Fechas CHECK (Fecha_Fin >= Fecha_Inicio),
    ID_Proceso VARCHAR(10) NOT NULL,
    ID_Responsable VARCHAR(10) NOT NULL,
    FOREIGN KEY (ID_Proceso) REFERENCES PROCESO_ELECTOR(ID_Proceso),
    FOREIGN KEY (ID_Responsable) REFERENCES RESPONSABLE(ID_Responsable)
)
GO

-- Actividades del Cronograma
CREATE TABLE ACTIVIDAD (
    ID_Actividad VARCHAR(10) PRIMARY KEY,
    Nombre VARCHAR(200) NOT NULL,
    Fecha DATE NOT NULL,
    Hora_Inicio TIME NOT NULL,  
    Hora_Fin TIME NOT NULL, 
	CONSTRAINT CK_Actividad_Horas CHECK (Hora_Fin > Hora_Inicio),
    Estado VARCHAR(20) DEFAULT 'PENDIENTE' CHECK (Estado IN ('PENDIENTE', 'EN_CURSO', 'FINALIZADA', 'CANCELADA')),
    ID_Cronograma VARCHAR(10) NOT NULL,
    ID_Lugar VARCHAR(10) NOT NULL,
    ID_Responsable VARCHAR(10) NOT NULL,
    FOREIGN KEY (ID_Cronograma) REFERENCES CRONOGRAMA(ID_Cronograma),
    FOREIGN KEY (ID_Lugar) REFERENCES LUGAR(ID_Lugar),
    FOREIGN KEY (ID_Responsable) REFERENCES RESPONSABLE(ID_Responsable)
)
GO

-- Registro de Votos
CREATE TABLE VOTO (
    ID_Voto INT PRIMARY KEY IDENTITY (1,1),
    Fecha DATE NOT NULL CONSTRAINT DF_Voto_Fecha DEFAULT GETDATE(), 
    Hora TIME NOT NULL CONSTRAINT DF_Voto_Hora DEFAULT CONVERT(TIME, GETDATE()), 
    ID_Actividad VARCHAR(10) NOT NULL,
    ID_Elector VARCHAR(10) NOT NULL,
	FOREIGN KEY (ID_Actividad) REFERENCES ACTIVIDAD(ID_Actividad), --
    FOREIGN KEY (ID_Elector) REFERENCES ELECTOR(ID_Elector), --
    CONSTRAINT UQ_Voto_Actividad_Elector UNIQUE (ID_Actividad, ID_Elector) -- 
)
GO

-- =============================================
-- DATOS DE PRUEBA
-- =============================================
INSERT INTO PROCESO_ELECTOR (ID_Proceso, Nombre_Proceso, Descripcion, Fecha_Creacion) VALUES 
('PE001', 'Elecciones CSST 2024', 'Elecciones del Comité de Seguridad y Salud en el Trabajo', '2024-01-10'),
('PE002', 'Elecciones de Delegados', 'Renovación de delegados de área', '2024-02-15');

INSERT INTO LUGAR (ID_Lugar, Nombre, Direccion, Capacidad, Estado) VALUES 
('L001', 'Auditorio Principal', 'Edificio A, Piso 3', 200, 'DISPONIBLE'),
('L002', 'Sala de Conferencias', 'Edificio B, Piso 1', 50, 'DISPONIBLE');

INSERT INTO RESPONSABLE (ID_Responsable, Nombre, Cargo, Telefono, Estado) VALUES 
('R001', 'Ana Torres', 'Coordinadora General', '987654321', 'ACTIVO'),
('R002', 'Luis Mendoza', 'Jefe de Logística', '987123456', 'ACTIVO');

INSERT INTO CRONOGRAMA (ID_Cronograma, Nombre, Fecha_Inicio, Fecha_Fin, Estado, ID_Proceso, ID_Responsable) VALUES 
('CR001', 'Cronograma CSST 2024', '2024-03-01', '2024-03-30', 'ACTIVO', 'PE001', 'R001'),
('CR002', 'Cronograma Delegados', '2024-04-01', '2024-04-20', 'PENDIENTE', 'PE002', 'R002');

INSERT INTO ACTIVIDAD (ID_Actividad, Nombre, Fecha, Hora_Inicio, Hora_Fin, Estado, ID_Cronograma, ID_Lugar, ID_Responsable) VALUES 
('A001', 'Inscripción de Candidatos', '2024-03-05', '09:00:00', '17:00:00', 'PENDIENTE', 'CR001', 'L001', 'R001'),
('A002', 'Votación CSST', '2024-03-15', '08:00:00', '18:00:00', 'PENDIENTE', 'CR001', 'L002', 'R002');

INSERT INTO ELECTOR (ID_Elector, Nombre, DNI, Telefono, Email, Estado) VALUES 
('E001', 'Carlos Ramírez', '87654321', '999888777', 'carlos@mail.com', 'ACTIVO'),
('E002', 'María López', '12345678', '987654321', 'maria@mail.com', 'ACTIVO');

INSERT INTO VOTO (Fecha, Hora, ID_Actividad, ID_Elector) VALUES
('2024-03-15', '10:30:00', 'A002', 'E001'),
('2024-03-15', '11:15:00', 'A002', 'E002');
GO

-- =============================================
-- VISTAS
-- =============================================
CREATE VIEW vw_CronogramasActivos AS
SELECT 
    C.ID_Cronograma,
    C.Nombre,
    P.Nombre_Proceso,
    C.Fecha_Inicio,
    C.Fecha_Fin,
    R.Nombre AS Responsable,
    C.Estado
FROM CRONOGRAMA C
JOIN PROCESO_ELECTOR P ON C.ID_Proceso = P.ID_Proceso
JOIN RESPONSABLE R ON C.ID_Responsable = R.ID_Responsable
WHERE C.Estado = 'ACTIVO';
GO

CREATE VIEW vw_ResultadosVotacion AS
SELECT 
    A.ID_Actividad,
    A.Nombre AS Actividad,
    A.Fecha,
    A.Hora_Inicio,
    A.Hora_Fin,
    COUNT(V.ID_Voto) AS Total_Votos,
    L.Nombre AS Lugar,
    A.Estado
FROM ACTIVIDAD A
LEFT JOIN VOTO V ON A.ID_Actividad = V.ID_Actividad
JOIN LUGAR L ON A.ID_Lugar = L.ID_Lugar
GROUP BY A.ID_Actividad, A.Nombre, A.Fecha, A.Hora_Inicio, A.Hora_Fin, L.Nombre, A.Estado;
GO

-- =============================================
-- PROCEDIMIENTOS ALMACENADOS
-- =============================================
CREATE PROCEDURE sp_GetActividadesPorCronograma
    @ID_Cronograma VARCHAR(10)
AS
BEGIN
    SELECT 
        A.ID_Actividad, 
        A.Nombre, 
        A.Fecha, 
        A.Hora_Inicio, 
        A.Hora_Fin, 
        L.Nombre AS Lugar,
        R.Nombre AS Responsable,
        A.Estado
    FROM ACTIVIDAD A
    JOIN LUGAR L ON A.ID_Lugar = L.ID_Lugar
    JOIN RESPONSABLE R ON A.ID_Responsable = R.ID_Responsable
    WHERE A.ID_Cronograma = @ID_Cronograma
    ORDER BY A.Fecha, A.Hora_Inicio;
END;
GO

CREATE PROCEDURE sp_RegistrarVoto
    @ID_Actividad VARCHAR(10),
    @ID_Elector VARCHAR(10)
AS
BEGIN
    BEGIN TRY
        INSERT INTO VOTO (ID_Actividad, ID_Elector)
        VALUES (@ID_Actividad, @ID_Elector);
        
        SELECT 'Voto registrado correctamente' AS Mensaje;
    END TRY
    BEGIN CATCH
        SELECT ERROR_MESSAGE() AS Error;
    END CATCH
END;
GO
