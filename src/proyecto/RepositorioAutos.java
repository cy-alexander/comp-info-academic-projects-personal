package proyecto;

import java.util.ArrayList;

/**
 * Repositorio centralizado que almacena todos los automóviles disponibles en el
 * sistema.
 * <p>
 * Esta clase actúa como una base en memoria, propocionando acceso a todos los
 * autmóviles registrados en sistema de ventas. Los datos se inicializan
 * automáticamente al cargar la clase
 * </p>
 * <p>
 * Para agregar nuevos autómoviles al sistema, simplemente añade una nueva línea
 * en el bloque static con los datos del vehículo.
 * </p>
 * 
 * @Autor Alexander Carrasco
 * @version 1.0
 * @since 2025
 * @see Automovil
 */
public class RepositorioAutos {

	/**
	 * Lista que contiene todos los automoviles disponibles en el sistema
	 * <p>
	 * Esta lista es estatica y public apara permitir el acceso desde cualquier
	 * parte del sistema. Los indices van de 0 a 4.
	 * </p>
	 * <ul>
	 * <li>0 - Toyota Corolla</li>
	 * <li>1 - Honda Civic</li>
	 * <li>2 - Tesla Model 3</li>
	 * <li>3 - Chevrolet Tracker</li>
	 * <li>5 - Ford Mustang</li>
	 * </ul>
	 */
	public static ArrayList<Automovil> autos = new ArrayList<>();

	/**
	 * Bloque de incialización estática que carga los automoviles al sistema
	 * <p>
	 * Este bloque se ejecuta automaticamenete una sola vez cuando la clase
	 * RepositorioAutos es cargada en memoria. Inicializa el ArrayList con los 5
	 * automóviles predeterminados del sistema.
	 * </p>
	 */
	static {
		autos.add(new Automovil("Toyota Corolla", 22000.0, "Blanco", 1350.5, "Nuevo"));
		autos.add(new Automovil("Honda Civic", 24500.0, "Rojo", 1420.8, "Usado"));
		autos.add(new Automovil("Tesla Model 3", 39990.0, "Gris", 1760.3, "Nuevo"));
		autos.add(new Automovil("Chevrolet Tracker", 21000.0, "Azul", 1370.2, "Seminuevo"));
		autos.add(new Automovil("Ford Mustang", 36000.0, "Negro", 1680.6, "Usado"));
	}
}
