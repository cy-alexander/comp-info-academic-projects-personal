USE Elecciones_CSST;
GO

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