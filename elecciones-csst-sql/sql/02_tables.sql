USE Elecciones_CSST;
GO

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
