USE Elecciones_CSST;
GO

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