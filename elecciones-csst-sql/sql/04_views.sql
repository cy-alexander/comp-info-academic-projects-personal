USE Elecciones_CSST;
GO

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